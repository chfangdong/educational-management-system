package com.bfw.student.controller;

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

import com.bfw.po.EvaluationInfo;
import com.bfw.po.StudentInfo;
import com.bfw.recruitstudent.service.StudentInfoService;
import com.bfw.student.service.EvaluationInfoService;

/**
 * 学员评价
 * @author 老牛
 * 2014年11月30日
 *
 */
@Controller
@RequestMapping("/evaluationinfo/")
public class EvaluationInfoController {

	@Resource(name = "evaluationInfoServiceImpl")
	private EvaluationInfoService evaluationInfoService;

	@Resource(name = "studentInfoServiceImpl")
	private StudentInfoService studentInfoService;

	/**
	 * 查询评价信息
	 * 
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(EvaluationInfo info, Model model) {

		List<EvaluationInfo> list = evaluationInfoService.getList(info);
		model.addAttribute("list", list);

		return "student/evaluationinfo/evaluationinfo_list";
	}

	/**
	 * 加载添加页面
	 * 
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("loadadd.do")
	public String loadadd(EvaluationInfo info, Model model) {

		StudentInfo stuinfo = new StudentInfo();

		stuinfo.setStudentMark("2");// -1 表示无效 0表示未分配学员 1已分配学员 2报名学员

		List<StudentInfo> list = studentInfoService.getStudentInfoList(stuinfo);
		model.addAttribute("stulist", list);

		return "student/evaluationinfo/evaluationinfo_add";
	}
	

	/**
	 * 加载修改页面
	 * 
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("loadupdate.do")
	public String loadupdate(Integer evaluationId, Model model) {

		StudentInfo stuinfo = new StudentInfo();

		stuinfo.setStudentMark("2");// -1 表示无效 0表示未分配学员 1已分配学员 2报名学员

		List<StudentInfo> list = studentInfoService.getStudentInfoList(stuinfo);
		model.addAttribute("stulist", list);
		
		EvaluationInfo evaluation=	evaluationInfoService.getEvaluationInfo(evaluationId);

		model.addAttribute("evaluation", evaluation);
		
		return "student/evaluationinfo/evaluationinfo_update";
	}
	
	/**
	 * 添加
	 * 
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("add.do")
	public String add(EvaluationInfo info, Model model) {

		boolean mark = evaluationInfoService.add(info);
		if (mark) {
			model.addAttribute("info", "添加评价信息成功！");
		} else {
			model.addAttribute("info", "添加评价信息失败");
		}
		
		
		return list(info,model);
	}

	
	/**
	 * 修改
	 * 
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("update.do")
	public String update(EvaluationInfo info, Model model) {

		boolean mark = evaluationInfoService.update(info);
		if (mark) {
			model.addAttribute("info", "修改评价信息成功！");
		} else {
			model.addAttribute("info", "修改评价信息失败");
		}
		
		
		return list(info,model);
	}
	
	/**
	 * 删除
	 * 
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("delete.do")
	public String delete(Integer evaluationId, Model model) {

		boolean mark = evaluationInfoService.delete(evaluationId);
		if (mark) {
			model.addAttribute("info", "删除评价信息成功！");
		} else {
			model.addAttribute("info", "删除评价信息失败");
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
