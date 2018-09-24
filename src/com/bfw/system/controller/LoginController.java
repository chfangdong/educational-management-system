package com.bfw.system.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bfw.po.AuthorityInfo;
import com.bfw.po.StaffInfo;
import com.bfw.system.dto.AuthorityDTO;
import com.bfw.system.dto.ReportInfo;
import com.bfw.system.service.AuthorityService;
import com.bfw.system.service.ReportService;
import com.bfw.system.service.StaffInfoService;

/**
* <p>Title: LoginController</p>  
* <p>Description:用户登录 </p>  
* @author William  
* @date 2018-9-2  
* @version 1.0
 */
@Controller
public class LoginController {

	@Resource(name = "staffInfoServiceImpl")
	private StaffInfoService staffInfoService;

	@Resource(name = "authorityServiceImpl")
	private AuthorityService authorityService;

	@Resource(name="reportServiceImpl")
	private ReportService reportService;
	
	@RequestMapping("/out.do")
	public String out(HttpServletRequest request) {
		// 获取Session
		HttpSession session = request.getSession();
		session.removeAttribute("staff");
		return "login";
	}

	/** 
	 * 用户登录
	 * @param staffInfo
	 * @param request
	 * @return
	 */
	@RequestMapping("/login.do")
	public String login(StaffInfo staffInfo, HttpServletRequest request) {

		// 获取Session
		HttpSession session = request.getSession();

		if (staffInfo != null && staffInfo.getUserNumber() != null
				&& !staffInfo.getUserNumber().equals("")
				&& staffInfo.getUserPassowrd() != null
				&& !staffInfo.getUserPassowrd().equals("")) {
		

		// 获取当前登录用户信息，根据staffInfo信息到数据库查询
		List<StaffInfo> list = staffInfoService.getList(staffInfo);
		if (list != null && list.size() > 0) {
			// 把当前用户登录信息保存到Session中
			StaffInfo staff = list.get(0);
			session.setAttribute("staff", staff);
			//获取报表信息
			ReportInfo reportInfo =	reportService.getReportInfo();
			session.setAttribute("reportInfo", reportInfo);
			
			if (staff.getRoleId() != null) {
				// 根据角色编号查询出权限信息
				List<AuthorityInfo> authlist = authorityService.getAuthList(staff
						.getRoleId());

				// 构建菜单（一级和二级）
				List<AuthorityDTO> dtolist = new ArrayList<AuthorityDTO>();

				for (AuthorityInfo auth : authlist) {

					if (auth != null && auth.getAuthorityPid() == 1) {
						AuthorityDTO dto = new AuthorityDTO();
						dto.setAuth(auth);

						// 子菜单
						List<AuthorityInfo> sublist = new ArrayList<AuthorityInfo>();
						getAuthority(sublist, authlist, auth.getAuthorityId());

						dto.setList(sublist);
						dtolist.add(dto);
					}
				}

				request.setAttribute("dtolist", dtolist);

				return "index";
			}

		} else {
			request.setAttribute("info", "账号或密码错误！");
		}
		
		}else{
			request.setAttribute("info", "账号或密码不能为空！");
		}

		return "login";
	}

	public void getAuthority(List<AuthorityInfo> sublist,
			List<AuthorityInfo> list, Integer authorityId) {

		if (list != null && list.size() > 0) {
			for (AuthorityInfo auth : list) {
				if (auth != null && auth.getAuthorityPid() != null
						&& auth.getAuthorityPid().equals(authorityId)) {

					sublist.add(auth);
					getAuthority(sublist, list, auth.getAuthorityId());
				}
			}
		}

	}

}
