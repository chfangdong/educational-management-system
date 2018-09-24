package com.bfw.classinfo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bfw.classinfo.service.DisciplineInfoService;
import com.bfw.po.DisciplineInfo;

@Controller
@RequestMapping("/disciplineinfo/")
public class DisciplineInfoController {

	@Resource(name="disciplineInfoServiceImpl")
	private DisciplineInfoService disciplineInfoService;
	
	/**
	 * 查询信息
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(DisciplineInfo info,Model model){
		List<DisciplineInfo> list = disciplineInfoService.getList(info);
		model.addAttribute("list", list);
		return "classinfo/disciplineinfo/disciplineinfo_list";
	}
	
	/**
	 * 添加信息
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("add.do")
	public String add(DisciplineInfo info,Model model){
		
		boolean mark = disciplineInfoService.addDisciplineInfo(info);
		if(mark){
			model.addAttribute("info", "添加信息成功");
		}else{
			model.addAttribute("info", "添加信息失败");
		}
		
		return list(info,model);
	}
	
	/**
	 * 加载修改页面信息
	 * @param disciplineId
	 * @param model
	 * @return
	 */
	@RequestMapping("load.do")
	public String load(Integer disciplineId,Model model){
		
		DisciplineInfo discipline= disciplineInfoService.getDisciplineInfo(disciplineId);
		model.addAttribute("discipline", discipline);
		
		return "classinfo/disciplineinfo/disciplineinfo_update";
	}
	
	
	/**
	 * 修改信息
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("update.do")
	public String update(DisciplineInfo info,Model model){
		
		boolean mark = disciplineInfoService.updateDisciplineInfo(info);
		if(mark){
			model.addAttribute("info", "修改信息成功");
		}else{
			model.addAttribute("info", "修改信息失败");
		}
		
		return list(info,model);
	}
	
	/**
	 * 删除信息
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("delete.do")
	public String delete(DisciplineInfo info,Model model){
		
		if(info== null){
			info = new DisciplineInfo();
		}
		//1为有效 0 为无效
		info.setDisciplineIsuesd("0");
		
		boolean mark = disciplineInfoService.updateDisciplineInfo(info);
		if(mark){
			model.addAttribute("info", "删除信息成功");
		}else{
			model.addAttribute("info", "删除信息失败");
		}
		
		return list(info,model);
	}
	
}
