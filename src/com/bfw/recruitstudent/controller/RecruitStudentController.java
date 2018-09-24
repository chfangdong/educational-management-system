package com.bfw.recruitstudent.controller;

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

import com.bfw.classinfo.service.ClassInfoService;
import com.bfw.po.AuditionInfo;
import com.bfw.po.ClassInfo;
import com.bfw.po.StaffInfo;
import com.bfw.po.StudentInfo;
import com.bfw.po.TrackRecordInfo;
import com.bfw.recruitstudent.service.AuditionInfoService;
import com.bfw.recruitstudent.service.StudentInfoService;
import com.bfw.recruitstudent.service.TrackRecordInfoService;

/**
 * 招生线索
 * 
 * @author 老牛 2014年11月25日
 *
 */
@Controller
@RequestMapping("/recruitstudent/")
public class RecruitStudentController {

	@Resource(name = "studentInfoServiceImpl")
	private StudentInfoService studentInfoService;

	@Resource(name = "trackRecordInfoServiceImpl")
	private TrackRecordInfoService trackRecordInfoService;

	/**
	 * 班级Service
	 */
	@Resource(name = "classInfoServiceImpl")
	private ClassInfoService classInfoService;

	/**
	 * 试听记录业务逻辑接口
	 */
	@Resource(name = "auditionInfoServiceImpl")
	private AuditionInfoService auditionInfoService;

	@RequestMapping("list.do")
	public String list(StudentInfo stuinfo, Model model,
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

		List<StudentInfo> list = studentInfoService.getStudentInfoList(stuinfo);
		model.addAttribute("list", list);
		model.addAttribute("stuinfo", stuinfo);

		return "recruitstudent/recruitstudent/recruitstudent_list";
	}

	/**
	 * 添加学员信息
	 * 
	 * @param stuinfo
	 * @param model
	 * @return
	 */
	@RequestMapping("add.do")
	public String add(StudentInfo stuinfo, Model model,
			HttpServletRequest request) {
		if (stuinfo == null) {
			stuinfo = new StudentInfo();
		}
		stuinfo.setStudentMark("1");// -1 表示无效 0表示未分配学员 1已分配学员 2报名学员

		boolean mark = studentInfoService.addStudent(stuinfo);
		if (mark) {
			model.addAttribute("info", "添加学员信息成功！");
		} else {
			model.addAttribute("info", "添加学员信息失败");
		}

		return list(stuinfo, model, request);
	}

	/**
	 * 修改学员信息
	 * 
	 * @param stuinfo
	 * @param model
	 * @return
	 */
	@RequestMapping("update.do")
	public String update(StudentInfo stuinfo, Model model,
			HttpServletRequest request) {
		if (stuinfo == null) {
			stuinfo = new StudentInfo();
		}

		boolean mark = studentInfoService.updateStudent(stuinfo);
		if (mark) {
			model.addAttribute("info", "修改学员信息成功！");
		} else {
			model.addAttribute("info", "修改学员信息失败");
		}

		return list(stuinfo, model, request);
	}

	/**
	 * 加载学员转正页面
	 * 
	 * @param studentId
	 * @param model
	 * @return
	 */
	@RequestMapping("loadpositive.do")
	public String loadpositive(Integer studentId, Model model) {
		StudentInfo stuinfo = studentInfoService.getStudentInfo(studentId);
		model.addAttribute("stuinfo", stuinfo);
		
		List<ClassInfo> classlist = classInfoService.getList(null);
		model.addAttribute("classlist", classlist);

		return "recruitstudent/recruitstudent/recruitstudent_positive";
	}
	
	/**
	 * 修改学员信息
	 * 
	 * @param stuinfo
	 * @param model
	 * @return
	 */
	@RequestMapping("positive.do")
	public String positive(StudentInfo stuinfo, Model model,
			HttpServletRequest request) {
		if (stuinfo == null) {
			stuinfo = new StudentInfo();
		}
		//-1 表示无效 0表示未分配学员 1已分配学员 2报名学员
		stuinfo.setStudentMark("2");

		boolean mark = studentInfoService.updateStudent(stuinfo);
		if (mark) {
			model.addAttribute("info", "学员转正成功！");
		} else {
			model.addAttribute("info", "学员转正失败");
		}

		return list(null, model, request);
	}

	/**
	 * 删除学员信息
	 * 
	 * @param stuinfo
	 * @param model
	 * @return
	 */
	@RequestMapping("delete.do")
	public String delete(StudentInfo stuinfo, Model model,
			HttpServletRequest request) {
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

		return list(stuinfo, model, request);
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
		TrackRecordInfo trackRecordinfo = new TrackRecordInfo();
		trackRecordinfo.setStudentId(studentId);
		// 获取跟踪记录的相关信息
		List<TrackRecordInfo> tracklist = trackRecordInfoService
				.getTrackRecordList(trackRecordinfo);
		model.addAttribute("tracklist", tracklist);

		AuditionInfo info = new AuditionInfo();
		info.setStudentId(studentId);
		// 试听记录的信息
		List<AuditionInfo> auditlist = auditionInfoService.getList(info);
		model.addAttribute("auditlist", auditlist);

		return "recruitstudent/recruitstudent/recruitstudent_show";
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

		return "recruitstudent/recruitstudent/recruitstudent_update";
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
