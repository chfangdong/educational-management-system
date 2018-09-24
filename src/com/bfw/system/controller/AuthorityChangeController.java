package com.bfw.system.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bfw.po.AuthorityInfo;
import com.bfw.po.RoleAuthorityInfo;
import com.bfw.po.RoleInfo;
import com.bfw.system.dto.AuthorityDTO;
import com.bfw.system.service.AuthorityService;
import com.bfw.system.service.AuthorityChangeService;
import com.bfw.system.service.RoleInfoService;

/**
* <p>Title: AuthorityChangeController</p>  
* <p>Description: 权限变更控制器</p>  
* @author William  
* @date 2018-8-26  
* @version 1.0
 */
@Controller
@RequestMapping("/authoritychange/")
public class AuthorityChangeController {

	/**
	 * 角色管理的业务逻辑层
	 */
	@Resource(name = "roleInfoServiceImpl")
	private RoleInfoService roleInfoService;

	/**
	 * 权限基本信息的业务逻辑层
	 */
	@Resource(name = "authorityServiceImpl")
	private AuthorityService authorityService;
	
	
	/**
	 * 角色权限信息的业务逻辑层
	 */
	@Resource(name = "authorityChangeServiceImpl")
	private AuthorityChangeService authorityChangeService;

	/**
	 * 查询角色信息
	 * 
	 * @param roleinfo
	 *            查询条件
	 * @param model
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(RoleInfo roleinfo, Model model) {

		List<RoleInfo> list = roleInfoService.getRoleList(roleinfo);
		model.addAttribute("list", list);

		return "system/authoritychange/authority_changelist";
	}

	@RequestMapping("load.do")
	public String load(Integer roleId, Model model) {
		// 角色
		RoleInfo roleinfo = roleInfoService.getRoleInfo(roleId);
		model.addAttribute("roleinfo", roleinfo);
		RoleAuthorityInfo rai = new RoleAuthorityInfo();
		rai.setRoleId(roleId);
		
		List<RoleAuthorityInfo> railist = authorityChangeService.getRoleAuthorityList(rai);

		// 权限（菜单）
		List<AuthorityInfo> list = authorityService.getList();

		List<AuthorityDTO> dtolist = new ArrayList<AuthorityDTO>();

		for (AuthorityInfo auth : list) {

			if (auth!=null &&auth.getAuthorityPid() == 1) {
				AuthorityDTO dto = new AuthorityDTO();
				
				if(railist!=null && railist.size()>0){
					for(RoleAuthorityInfo rainfo:railist){
						if(rainfo.getAuthorityId() == auth.getAuthorityId()){
							auth.setChecked(true);
						}
					}
				}
				
				// 一级菜单
				dto.setAuth(auth);
				
				
				
				// 子菜单
				List<AuthorityInfo> sublist = new ArrayList<AuthorityInfo>();
				getAuthority(railist,sublist, list, auth.getAuthorityId());

				dto.setList(sublist);
				System.out.println(sublist.size());

				dtolist.add(dto);
			}

		}

		model.addAttribute("dtolist", dtolist);

		return "system/authoritychange/authority_change";
	}

	public void getAuthority(List<RoleAuthorityInfo> railist,List<AuthorityInfo> sublist,
			List<AuthorityInfo> list, Integer authorityId) {

		if (list != null && list.size() > 0) {
			for (AuthorityInfo auth : list) {
				if (auth!=null && auth.getAuthorityPid()!=null && auth.getAuthorityPid().equals(authorityId)) {
					if(railist!=null && railist.size()>0){
						for(RoleAuthorityInfo rainfo:railist){
							if(rainfo.getAuthorityId() == auth.getAuthorityId()){
								auth.setChecked(true);
							}
						}
					}
					sublist.add(auth);
					getAuthority(railist,sublist, list, auth.getAuthorityId());
				}
			}
		}

	}
	
	/**
	 * 添加权限信息
	 * @param roleId 角色编号
	 * @param authorityId 权限编号
	 * @param model
	 * @return
	 */
	@RequestMapping("add.do")
	public String add(Integer roleId,Integer[] authorityId,Model model){
		System.out.println("角色编号："+roleId);
		System.out.println("权限编号："+authorityId);
		
		boolean mark = false;
		
		if(authorityId!=null && authorityId.length>0){
			
			try {
				authorityChangeService.add(roleId, authorityId);
				mark = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		if (mark) {

			model.addAttribute("info", "权限变更成功");
		} else {
			model.addAttribute("info", "权限变更失败");
		}
		
		
		
		return list(null,model);
	}
}
