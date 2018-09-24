package com.bfw.system.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bfw.po.AuthorityInfo;
import com.bfw.system.service.AuthorityService;

/**
* <p>Title: AuthortyController</p>  
* <p>Description: 权限管理的控制器</p>  
* @author William  
* @date 2018-9-22  
* @version 1.0
 */
@Controller
@RequestMapping("/authority/")
public class AuthortyController {

	@Resource(name = "authorityServiceImpl")
	private AuthorityService authorityService;

	/**
	 * 查询权限信息
	 * 
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(Model model, HttpServletRequest request) {

		List<AuthorityInfo> list = authorityService.getList();
		model.addAttribute("list", list);

		if (list != null && list.size() > 0) {
			request.getSession().setAttribute("anth", list.get(0));
		}

		return "system/authority/authority_list";
	}

	@RequestMapping("show.do")
	public String show(Integer authorityId, Model model) {

		AuthorityInfo anth = authorityService.getAuthorityInfo(authorityId);
		model.addAttribute("anth", anth);

		return "system/authority/authority_show";
	}

	@RequestMapping("loadAdd.do")
	public String loadAdd(Integer authorityId,Model model) {
		List<AuthorityInfo> list = authorityService.getList();
		model.addAttribute("list", list);
		
		model.addAttribute("authorityId", authorityId);

		return "system/authority/authority_add";
	}

	@RequestMapping("loadUpdate.do")
	public String loadUpdate(Integer authorityId, Model model) {

		AuthorityInfo anth = authorityService.getAuthorityInfo(authorityId);
		model.addAttribute("anth", anth);

		List<AuthorityInfo> list = authorityService.getList();
		model.addAttribute("list", list);

		return "system/authority/authority_update";
	}

	/**
	 * 添加权限信息
	 * 
	 * @param authority
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("add.do")
	public String add(AuthorityInfo authority, Model model,
			HttpServletRequest request) {
		boolean mark = authorityService.add(authority);
		if (mark) {
			model.addAttribute("info", "权限信息添加成功");
		} else {
			model.addAttribute("info", "权限信息添加失败");
		}

		return "system/authority/authority_info";
	}

	/**
	 * 修改权限信息
	 * 
	 * @param authority
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("update.do")
	public String update(AuthorityInfo authority, Model model,
			HttpServletRequest request) {
		boolean mark = authorityService.update(authority);
		if (mark) {
			model.addAttribute("info", "权限信息修改成功");
		} else {
			model.addAttribute("info", "权限信息修改失败");
		}

		return "system/authority/authority_info";
	}

	/**
	 * 根据编号删除权限信息
	 * 
	 * @param authorityId
	 *            编号
	 * @param model
	 * @return
	 */
	@RequestMapping("delete.do")
	public String delete(Integer authorityId, Model model) {
		boolean mark = false;
	
		try {
			//先验证是否有下级菜单，如果没有才能删除
			if(authorityService.isDelete(authorityId)){
				authorityService.delete(authorityId);
				mark = true;
			}else{
				model.addAttribute("info1", "请先删除下级菜单，");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (mark) {
			model.addAttribute("info", "权限信息删除成功");
		} else {
			model.addAttribute("info", "权限信息删除失败");
		}

		return "system/authority/authority_info";
	}

}
