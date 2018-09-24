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

import com.bfw.po.StaffInfo;
import com.bfw.po.StudentInfo;
import com.bfw.po.StudentWriteGrade;
import com.bfw.recruitstudent.service.StudentInfoService;
import com.bfw.student.service.StudentWriteGradeService;

/**
 * 学员成绩
 * @author 老牛
 * 2014年11月30日
 *
 */
@Controller
@RequestMapping("/studentwritegrade/")
public class StudentWriteGradeController {

	@Resource(name="studentWriteGradeServiceImpl")
	private StudentWriteGradeService studentWriteGradeService;
	
	@Resource(name = "studentInfoServiceImpl")
	private StudentInfoService studentInfoService;
	/**
	 * 查询信息
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(StudentWriteGrade info,Model model){
		
		List<StudentWriteGrade> list = studentWriteGradeService.getList(info);
		model.addAttribute("list", list);
		
		return "student/studentwritegrade/studentwritegrade_list";
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
		
		return "student/studentwritegrade/studentwritegrade_add";
	}
	
	/**
	 * 加载修改页面
	 * @param model
	 * @return
	 */
	@RequestMapping("loadupdate.do")
	public String  loadupdate(Integer writeGradeId,Model model){
		

		StudentInfo stuinfo = new StudentInfo();

		stuinfo.setStudentMark("2");// -1 表示无效 0表示未分配学员 1已分配学员 2报名学员

		List<StudentInfo> list = studentInfoService.getStudentInfoList(stuinfo);
		model.addAttribute("stulist", list);
		
		StudentWriteGrade swg = studentWriteGradeService.getStudentWriteGrade(writeGradeId);
		model.addAttribute("swg", swg);
		
		
		
		return "student/studentwritegrade/studentwritegrade_update";
	}
	
	@RequestMapping("add.do")
	public String add(StudentWriteGrade info,Model model,HttpServletRequest request){
		HttpSession session = request.getSession();
		StaffInfo staff = (StaffInfo) session.getAttribute("staff");
		
		if(info==null){
			info = new StudentWriteGrade();
		}
		if(staff!=null){
			info.setStaffId(staff.getStaffId());
		}
	
		
		boolean mark = studentWriteGradeService.add(info);
		if (mark) {
			model.addAttribute("info", "添加信息成功！");
		} else {
			model.addAttribute("info", "添加信息失败");
		}
		
		return list(info,model);
	}
	
	@RequestMapping("update.do")
	public String update(StudentWriteGrade info,Model model,HttpServletRequest request){
		HttpSession session = request.getSession();
		StaffInfo staff = (StaffInfo) session.getAttribute("staff");
		
		if(info==null){
			info = new StudentWriteGrade();
		}
		if(staff!=null){
			info.setStaffId(staff.getStaffId());
		}
		boolean mark = studentWriteGradeService.update(info);
		if (mark) {
			model.addAttribute("info", "修改信息成功！");
		} else {
			model.addAttribute("info", "修改信息失败");
		}
		
		return list(info,model);
	}
	
	@RequestMapping("delete.do")
	public String delete(Integer writeGradeId,Model model){
		
		boolean mark = studentWriteGradeService.delete(writeGradeId);
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
