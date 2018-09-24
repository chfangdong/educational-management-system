package com.bfw.studentphone.controllerr;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bfw.po.EvaluationInfo;
import com.bfw.po.StudentInfo;
import com.bfw.student.service.EvaluationInfoService;

/**
 * 手机版 学员评价查询 和添加
 * @author 老牛
 * 2014年12月4日
 *
 */
@Controller
@RequestMapping("/evaluationphone/")
public class EvaluationPhoneController {

	/**
	 * 学员评价的业务逻辑
	 */
	@Resource(name="evaluationInfoServiceImpl")
	private EvaluationInfoService evaluationInfoService;
	
	/**
	 * 根据学员编号查询评价信息
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(EvaluationInfo info,Model model){
		
		//查询评价信息
		List<EvaluationInfo> list = evaluationInfoService.getList(info);
		model.addAttribute("list", list);
		
		return "studentphone/evaluation_list";
	}
	
	/**
	 * 添加评价信息
	 * @param info 信息内容
	 * @param model
	 * @return
	 */
	@RequestMapping("add.do")
	public String add(EvaluationInfo info,Model model,HttpSession session){
		
		//获取当前登录的学员信息
		StudentInfo stuinfo = (StudentInfo)session.getAttribute("stuinfo");
	
		
		if(info!=null){
			info.setStudentId(stuinfo.getStudentId());
			info.setEvaluationTime(new Date());
		}
		//添加信息
		evaluationInfoService.add(info);
		
		//查询条件
		EvaluationInfo pinfo = new EvaluationInfo();
		pinfo.setStudentId(stuinfo.getStudentId());
		
		return list(pinfo,model);
	}
	
}
