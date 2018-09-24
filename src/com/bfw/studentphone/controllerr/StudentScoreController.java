package com.bfw.studentphone.controllerr;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bfw.po.StudentWriteGrade;
import com.bfw.student.service.StudentWriteGradeService;

/**
 * 手机 查询学员成绩
 * 
 * @author 老牛 2014年12月4日
 *
 */
@Controller
@RequestMapping("/studentscore/")
public class StudentScoreController {

	/**
	 * 学员成绩的业务逻辑
	 */
	@Resource(name = "studentWriteGradeServiceImpl")
	private StudentWriteGradeService studentWriteGradeService;

	/**
	 * 查询学员成绩信息
	 * 
	 * @param info
	 *            条件
	 * @param model
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(StudentWriteGrade info, Model model) {

		//根据学员编号查询相关成绩信息
		List<StudentWriteGrade> list = studentWriteGradeService.getList(info);
		model.addAttribute("list", list);
		
		return "studentphone/student_score";
	}
}
