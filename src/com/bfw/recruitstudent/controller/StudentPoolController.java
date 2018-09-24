package com.bfw.recruitstudent.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bfw.po.StaffInfo;
import com.bfw.po.StudentInfo;
import com.bfw.recruitstudent.service.StudentInfoService;

/**
 * 学员池的信息管理控制器
 * 
 * @author 老牛 2014年11月24日
 *
 */
@Controller
@RequestMapping("/studentpool/")
public class StudentPoolController {

	@Resource(name = "studentInfoServiceImpl")
	private StudentInfoService studentInfoService;

	@RequestMapping("list.do")
	public String list(StudentInfo stuinfo, Model model) {

		if (stuinfo == null) {
			stuinfo = new StudentInfo();
		}
		stuinfo.setStudentMark("0");// -1 表示无效 0表示未分配学员 1已分配学员 2报名学员

		List<StudentInfo> list = studentInfoService.getStudentInfoList(stuinfo);
		model.addAttribute("list", list);

		return "recruitstudent/studentpool/studentpool_list";
	}

	/**
	 * 添加学员信息
	 * 
	 * @param stuinfo
	 * @param model
	 * @return
	 */
	@RequestMapping("add.do")
	public String add(StudentInfo stuinfo, Model model) {
		if (stuinfo == null) {
			stuinfo = new StudentInfo();
		}
		stuinfo.setStudentMark("0");// -1 表示无效 0表示未分配学员 1已分配学员 2报名学员

		boolean mark = studentInfoService.addStudent(stuinfo);
		if (mark) {
			model.addAttribute("info", "添加学员信息成功！");
		} else {
			model.addAttribute("info", "添加学员信息失败");
		}

		return list(stuinfo, model);
	}

	/**
	 * 修改学员信息
	 * 
	 * @param stuinfo
	 * @param model
	 * @return
	 */
	@RequestMapping("update.do")
	public String update(StudentInfo stuinfo, Model model) {
		if (stuinfo == null) {
			stuinfo = new StudentInfo();
		}
		stuinfo.setStudentMark("0");// -1 表示无效 0表示未分配学员 1已分配学员 2报名学员

		boolean mark = studentInfoService.updateStudent(stuinfo);
		if (mark) {
			model.addAttribute("info", "修改学员信息成功！");
		} else {
			model.addAttribute("info", "修改学员信息失败");
		}

		return list(stuinfo, model);
	}

	/**
	 * 删除学员信息
	 * 
	 * @param stuinfo
	 * @param model
	 * @return
	 */
	@RequestMapping("delete.do")
	public String delete(StudentInfo stuinfo, Model model) {
		if (stuinfo == null) {
			stuinfo = new StudentInfo();
		}
		stuinfo.setStudentMark("-1");// -1 表示无效 0表示未分配学员 1已分配学员 2报名学员

		boolean mark = studentInfoService.updateStudent(stuinfo);
		if (mark) {
			model.addAttribute("info", "删除学员信息成功！");
		} else {
			model.addAttribute("info", "删除学员信息失败");
		}

		return list(stuinfo, model);
	}

	/**
	 * 领取学员信息
	 * 
	 * @param stuinfo
	 * @param model
	 * @return
	 */
	@RequestMapping("receive.do")
	public String receive(StudentInfo stuinfo, Model model,
			HttpServletRequest request) {

		HttpSession session = request.getSession();
		StaffInfo staff = (StaffInfo) session.getAttribute("staff");

		if (stuinfo == null) {
			stuinfo = new StudentInfo();
		}
		if (staff != null) {
			stuinfo.setStaffId(staff.getStaffId());
		}
		stuinfo.setStudentMark("1");// -1 表示无效 0表示未分配学员 1已分配学员 2报名学员

		boolean mark = studentInfoService.updateStudent(stuinfo);
		if (mark) {
			model.addAttribute("info", "领取学员信息成功！");
		} else {
			model.addAttribute("info", "领取学员信息失败");
		}

		return list(null, model);
	}

	/**
	 * 根据编号查询学员信息
	 * 
	 * @param studentId
	 * @param model
	 * @return
	 */
	@RequestMapping("show.do")
	public String show(Integer studentId, Model model) {

		StudentInfo stuinfo = studentInfoService.getStudentInfo(studentId);
		model.addAttribute("stuinfo", stuinfo);

		return "recruitstudent/studentpool/studentpool_show";
	}

	/**
	 * 加载修改页面
	 * 
	 * @param studentId
	 * @param model
	 * @return
	 */
	@RequestMapping("load.do")
	public String load(Integer studentId, Model model) {

		StudentInfo stuinfo = studentInfoService.getStudentInfo(studentId);
		model.addAttribute("stuinfo", stuinfo);

		return "recruitstudent/studentpool/studentpool_update";
	}

}
