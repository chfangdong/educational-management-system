package com.bfw.classinfo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bfw.classinfo.service.ClassroomInfoService;
import com.bfw.po.ClassroomInfo;

/**
 * 教室信息管理的控制器
 * @author 老牛
 * 2014年11月29日
 *
 */
@Controller
@RequestMapping("/classroominfo/")
public class ClassroomInfoController {

	@Resource(name="classroomInfoServiceImpl")
	private ClassroomInfoService classroomInfoService;
	
	@RequestMapping("list.do")
	public String list(ClassroomInfo info,Model model){
		
		List<ClassroomInfo> list = classroomInfoService.getClassroomList(info);
		model.addAttribute("list", list);
		
		return "classinfo/classroominfo/classroominfo_list";
	}
	
	/**
	 * 添加信息
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("add.do")
	public String add(ClassroomInfo info,Model model){
		if(info == null){
			info = new ClassroomInfo();
		}
		//1 为有效 0为无效
		info.setClassroomMark("1");
		boolean mark = classroomInfoService.addClassroom(info);
		if(mark){
			model.addAttribute("info", "添加教室成功");
		}else{
			model.addAttribute("info", "添加教室失败");
		}
		
		return list(info,model);
	}
	
	/**
	 * 修改信息
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("update.do")
	public String update(ClassroomInfo info,Model model){
		boolean mark = classroomInfoService.updateClassroom(info);
		if(mark){
			model.addAttribute("info", "修改教室成功");
		}else{
			model.addAttribute("info", "修改教室失败");
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
	public String delete(ClassroomInfo info,Model model){
		if(info == null){
			info = new ClassroomInfo();
		}
		//1 为有效 0为无效
		info.setClassroomMark("0");
		boolean mark = classroomInfoService.updateClassroom(info);
		if(mark){
			model.addAttribute("info", "删除教室成功");
		}else{
			model.addAttribute("info", "删除教室失败");
		}
		
		return list(info,model);
	}
	
	/**
	 * 加载修改页面
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("load.do")
	public String load(Integer classroomId,Model model){
		ClassroomInfo classroom=classroomInfoService.getClassroomInfo(classroomId);
		model.addAttribute("classroom", classroom);
		
		return "classinfo/classroominfo/classroominfo_update";
	}
	
}
