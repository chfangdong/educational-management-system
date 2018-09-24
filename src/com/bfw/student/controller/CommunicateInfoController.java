package com.bfw.student.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bfw.po.CommunicateInfo;
import com.bfw.po.StaffInfo;
import com.bfw.po.StudentInfo;
import com.bfw.recruitstudent.service.StudentInfoService;
import com.bfw.student.service.CommunicateInfoService;

/**
 * 沟通记录
 * @author 老牛
 * 2014年11月30日
 *
 */
@Controller
@RequestMapping("/communicateinfo/")
public class CommunicateInfoController {

	/**
	 * 
	 */
	@Resource(name="communicateInfoServiceImpl")
	private CommunicateInfoService communicateInfoService;
	
	
	@Resource(name = "studentInfoServiceImpl")
	private StudentInfoService studentInfoService;
	
	/**
	 * 查询信息
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(CommunicateInfo info,Model model){
		
		List<CommunicateInfo> list = communicateInfoService.getList(info);
		model.addAttribute("list", list);
		
		return "student/communicateinfo/communicateinfo_list";
	}
	
	/**
	 * 加载添加页面
	 * @param model
	 * @return
	 */
	@RequestMapping("loadadd.do")
	public String  loadadd(Model model){
		

		StudentInfo stuinfo = new StudentInfo();

		stuinfo.setStudentMark("2");// -1 表示无效 0表示未分配学员 1已分配学员 2报名学员

		List<StudentInfo> list = studentInfoService.getStudentInfoList(stuinfo);
		model.addAttribute("stulist", list);
		
		return "student/communicateinfo/communicateinfo_add";
	}
	
	/**
	 * 加载修改页面
	 * @param model
	 * @return
	 */
	@RequestMapping("loadupdate.do")
	public String  loadupdate(Integer communicateId,Model model){
		

		StudentInfo stuinfo = new StudentInfo();

		stuinfo.setStudentMark("2");// -1 表示无效 0表示未分配学员 1已分配学员 2报名学员

		List<StudentInfo> list = studentInfoService.getStudentInfoList(stuinfo);
		model.addAttribute("stulist", list);
		
		CommunicateInfo commum = communicateInfoService.getCommunicateInfo(communicateId);
		model.addAttribute("commum", commum);
		
		
		
		return "student/communicateinfo/communicateinfo_update";
	}
	
	@RequestMapping("add.do")
	public String add(CommunicateInfo info,Model model,HttpServletRequest request){
		HttpSession session = request.getSession();
		StaffInfo staff = (StaffInfo) session.getAttribute("staff");
		
		if(info==null){
			info = new CommunicateInfo();
		}
		if(staff!=null){
			info.setStaffId(staff.getStaffId());
		}
	
		
		boolean mark = communicateInfoService.add(info);
		if (mark) {
			model.addAttribute("info", "添加信息成功！");
		} else {
			model.addAttribute("info", "添加信息失败");
		}
		
		return list(info,model);
	}
	
	@RequestMapping("update.do")
	public String update(CommunicateInfo info,Model model,HttpServletRequest request){
		HttpSession session = request.getSession();
		StaffInfo staff = (StaffInfo) session.getAttribute("staff");
		
		if(info==null){
			info = new CommunicateInfo();
		}
		if(staff!=null){
			info.setStaffId(staff.getStaffId());
		}
		boolean mark = communicateInfoService.update(info);
		if (mark) {
			model.addAttribute("info", "修改信息成功！");
		} else {
			model.addAttribute("info", "修改信息失败");
		}
		
		return list(info,model);
	}
	
	@RequestMapping("delete.do")
	public String delete(Integer communicateId,Model model){
		
		boolean mark = communicateInfoService.delete(communicateId);
		if (mark) {
			model.addAttribute("info", "删除信息成功！");
		} else {
			model.addAttribute("info", "删除信息失败");
		}
		
		return list(null,model);
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
