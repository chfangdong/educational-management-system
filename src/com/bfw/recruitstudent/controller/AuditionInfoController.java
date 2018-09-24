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

import com.bfw.po.AuditionInfo;
import com.bfw.po.StaffInfo;
import com.bfw.po.StudentInfo;
import com.bfw.recruitstudent.service.AuditionInfoService;
import com.bfw.recruitstudent.service.StudentInfoService;

/**
 * 试听记录
 * 
 * @author 老牛 2014年11月25日
 *
 */
@Controller
@RequestMapping("/auditioninfo/")
public class AuditionInfoController {

	/**
	 * 学员管理的业务逻辑接口
	 */
	@Resource(name = "studentInfoServiceImpl")
	private StudentInfoService studentInfoService;

	/**
	 * 试听记录业务逻辑接口
	 */
	@Resource(name = "auditionInfoServiceImpl")
	private AuditionInfoService auditionInfoService;

	@RequestMapping("loadadd.do")
	public String loadAdd(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		StaffInfo staff = (StaffInfo) session.getAttribute("staff");

		StudentInfo stuinfo = new StudentInfo();

		if (staff != null) {
			stuinfo.setStaffId(staff.getStaffId());
		}
		stuinfo.setStudentMark("1");// -1 表示无效 0表示未分配学员 1已分配学员 2报名学员

		List<StudentInfo> list = studentInfoService.getStudentInfoList(stuinfo);
		model.addAttribute("list", list);

		return "recruitstudent/auditioninfo/auditioninfo_add";
	}

	/**
	 * 加载修改页面
	 * @param auditionId
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("loadupdate.do")
	public String loadupdate(Integer auditionId, Model model,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		StaffInfo staff = (StaffInfo) session.getAttribute("staff");

		StudentInfo stuinfo = new StudentInfo();

		if (staff != null) {
			stuinfo.setStaffId(staff.getStaffId());
		}
		stuinfo.setStudentMark("1");// -1 表示无效 0表示未分配学员 1已分配学员 2报名学员

		List<StudentInfo> list = studentInfoService.getStudentInfoList(stuinfo);
		model.addAttribute("list", list);

		AuditionInfo audit = auditionInfoService.getAuditionInfo(auditionId);
		model.addAttribute("audit", audit);
		
		
		return "recruitstudent/auditioninfo/auditioninfo_update";
	}
	
	/**
	 * 修改信息
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("update.do")
	public String update(AuditionInfo info, Model model) {

		boolean mark = auditionInfoService.updateAudition(info);
		if (mark) {
			model.addAttribute("info", "修改试听记录成功");
		} else {
			model.addAttribute("info", "修改试听记录失败");
		}
		return list(info, model);
	}
	
	/**
	 * 删除信息
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("delete.do")
	public String delete(Integer auditionId, Model model) {

		boolean mark = auditionInfoService.deleteAudition(auditionId);
		if (mark) {
			model.addAttribute("info", "删除试听记录成功");
		} else {
			model.addAttribute("info", "删除试听记录失败");
		}
		
		return list(null, model);
	}
	
	/**
	 * 查询试听记录信息
	 * 
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(AuditionInfo info, Model model) {

		List<AuditionInfo> list = auditionInfoService.getList(info);
		model.addAttribute("list", list);

		return "recruitstudent/auditioninfo/auditioninfo_list";
	}

	/**
	 * 添加试听记录
	 * 
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("add.do")
	public String add(AuditionInfo info, Model model) {

		boolean mark = auditionInfoService.addAudition(info);
		if (mark) {
			model.addAttribute("info", "添加试听记录成功");
		} else {
			model.addAttribute("info", "添加试听记录失败");
		}
		return list(info, model);
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
