package com.bfw.classinfo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.bfw.classinfo.service.ClassInfoService;
import com.bfw.classinfo.service.ClassroomInfoService;
import com.bfw.classinfo.service.DisciplineInfoService;
import com.bfw.classinfo.service.SyllabusInfoService;
import com.bfw.po.ClassInfo;
import com.bfw.po.ClassroomInfo;
import com.bfw.po.DisciplineInfo;
import com.bfw.po.StaffInfo;
import com.bfw.po.SyllabusInfo;
import com.bfw.system.service.StaffInfoService;

/**
 * 班级管理
 * @author 老牛
 * 2014年11月29日
 *
 */
@Controller
@RequestMapping("/classinfo/")
public class ClassInfoController {

	@Resource(name="classInfoServiceImpl")
	private ClassInfoService classInfoService;
	
	//教师
	@Resource(name = "staffInfoServiceImpl")
	private StaffInfoService staffInfoService;
	
	//学科
	@Resource(name="disciplineInfoServiceImpl")
	private DisciplineInfoService disciplineInfoService;
	
	//课程表
	@Resource(name = "syllabusInfoServiceImpl")
	private SyllabusInfoService syllabusInfoService;
	
	//教室
	@Resource(name="classroomInfoServiceImpl")
	private ClassroomInfoService classroomInfoService;
	
	/**
	 * 查询班级信息
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(ClassInfo info,Model model){
		
		List<ClassInfo> list = classInfoService.getList(info);
		
		model.addAttribute("list", list);
		return "classinfo/classinfo/classinfo_list";
	}
	
	/**
	 * 加载添加页面
	 * @param model
	 * @return
	 */
	@RequestMapping("loadadd.do")
	public String loadAdd(Model model){
		
		//获取教师
		StaffInfo	staff = new  StaffInfo();
		staff.setStaffState("2");
		List<StaffInfo> stafflist = staffInfoService.getList(staff);
		model.addAttribute("stafflist", stafflist);
		
		//学科信息
		List<DisciplineInfo> disciplist = disciplineInfoService.getList(null);
		model.addAttribute("disciplist", disciplist);
		
		//课程表
		List<SyllabusInfo> sylllist = syllabusInfoService.getList(null);
		model.addAttribute("sylllist", sylllist);
		
		//教室
		List<ClassroomInfo> roomlist = classroomInfoService.getClassroomList(null);
		model.addAttribute("roomlist", roomlist);
		
		return "classinfo/classinfo/classinfo_add";
	}
	
	/**
	 * 加载修改页面
	 * @param model
	 * @return
	 */
	@RequestMapping("loadupdate.do")
	public String loadupdate(Integer classId,Model model){
		
		//获取教师
		StaffInfo	staff = new  StaffInfo();
		staff.setStaffState("2");
		List<StaffInfo> stafflist = staffInfoService.getList(staff);
		model.addAttribute("stafflist", stafflist);
		
		//学科信息
		List<DisciplineInfo> disciplist = disciplineInfoService.getList(null);
		model.addAttribute("disciplist", disciplist);
		
		//课程表
		List<SyllabusInfo> sylllist = syllabusInfoService.getList(null);
		model.addAttribute("sylllist", sylllist);
		
		//教室
		List<ClassroomInfo> roomlist = classroomInfoService.getClassroomList(null);
		model.addAttribute("roomlist", roomlist);
		
		//根据编号查询班级信息
		ClassInfo classInfo = classInfoService.getClassInfo(classId);
		model.addAttribute("classInfo", classInfo);
		
		return "classinfo/classinfo/classinfo_update";
	}
	
	/**
	 * 添加班级信息
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("add.do")
	public String add(ClassInfo info,Model model){
		if(info == null){
			info = new ClassInfo();
		}
		info.setClassState("1");
		boolean mark = classInfoService.add(info);
		if(mark){
			model.addAttribute("info", "添加班级成功");
		}else{
			model.addAttribute("info", "添加班级失败");
		}
		
		return list(info,model);
	}
	
	/**
	 * 修改班级信息
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("update.do")
	public String update(ClassInfo info,Model model){
		if(info == null){
			info = new ClassInfo();
		}
		info.setClassState("1");
		boolean mark = classInfoService.update(info);
		if(mark){
			model.addAttribute("info", "修改班级成功");
		}else{
			model.addAttribute("info", "修改班级失败");
		}
		
		return list(info,model);
	}
	
	/**
	 * 删除班级信息
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("delete.do")
	public String delete(ClassInfo info,Model model){
		if(info == null){
			info = new ClassInfo();
		}
		info.setClassState("0");
		boolean mark = classInfoService.update(info);
		if(mark){
			model.addAttribute("info", "删除班级成功");
		}else{
			model.addAttribute("info", "删除班级失败");
		}
		
		return list(info,model);
	}
	
	/**
	 * 时间属性的编辑器
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder bin) {
		bin.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
