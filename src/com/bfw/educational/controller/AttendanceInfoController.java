package com.bfw.educational.controller;

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

import com.bfw.educational.service.AttendanceInfoService;
import com.bfw.po.AttendanceInfo;
import com.bfw.po.StudentInfo;
import com.bfw.recruitstudent.service.StudentInfoService;

/**
 * 学员考勤控制器
 * 
 * @author 老牛 2014年12月1日
 *
 */
@Controller
@RequestMapping("/attendanceinfo/")
public class AttendanceInfoController {

	@Resource(name = "attendanceInfoServiceImpl")
	private AttendanceInfoService attendanceInfoService;

	@Resource(name = "studentInfoServiceImpl")
	private StudentInfoService studentInfoService;

	/**
	 * 查询信息
	 * 
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(AttendanceInfo info, Model model) {

	
		List<AttendanceInfo> list = attendanceInfoService.getList(info);
		model.addAttribute("list", list);

		return "educational/attendanceinfo/attendanceinfo_list";
	}

	/**
	 * 加载添加页面
	 * 
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("loadadd.do")
	public String loadadd(Model model) {
		StudentInfo stuinfo = new StudentInfo();

		stuinfo.setStudentMark("2");// -1 表示无效 0表示未分配学员 1已分配学员 2报名学员
		List<StudentInfo> stulist = studentInfoService.getStudentInfoList(stuinfo);
		model.addAttribute("stulist", stulist);

		return "educational/attendanceinfo/attendanceinfo_add";
	}

	/**
	 * 加载修改页面
	 * 
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("loadupdate.do")
	public String loadadd(Integer attendanceId, Model model) {

		StudentInfo stuinfo = new StudentInfo();

		stuinfo.setStudentMark("2");// -1 表示无效 0表示未分配学员 1已分配学员 2报名学员
		List<StudentInfo> stulist = studentInfoService.getStudentInfoList(stuinfo);
		model.addAttribute("stulist", stulist);

		AttendanceInfo attendance = attendanceInfoService
				.getAttendanceInfo(attendanceId);
		model.addAttribute("attendance", attendance);

		return "educational/attendanceinfo/attendanceinfo_update";
	}

	@RequestMapping("add.do")
	public String add(AttendanceInfo info, Model model) {

		boolean mark = attendanceInfoService.add(info);
		if (mark) {
			model.addAttribute("info", "添加考勤信息成功");
		} else {
			model.addAttribute("info", "添加考勤信息失败");
		}

		return list(info, model);
	}

	@RequestMapping("update.do")
	public String update(AttendanceInfo info, Model model) {

		boolean mark = attendanceInfoService.update(info);
		if (mark) {
			model.addAttribute("info", "修改考勤信息成功");
		} else {
			model.addAttribute("info", "修改考勤信息失败");
		}

		return list(info, model);
	}

	@RequestMapping("delete.do")
	public String delete(Integer attendanceId, Model model) {

		boolean mark = attendanceInfoService.delete(attendanceId);
		if (mark) {
			model.addAttribute("info", "删除考勤信息成功");
		} else {
			model.addAttribute("info", "删除考勤信息失败");
		}

		return list(null, model);
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
