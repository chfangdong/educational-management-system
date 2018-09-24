package com.bfw.studentphone.controllerr;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bfw.finance.service.StudentPaymentService;
import com.bfw.po.StudentPayment;

/**
 * 手机端 学员缴费信息查询
 * @author 老牛
 * 2014年12月4日
 *
 */
@Controller
@RequestMapping("/studentphone/studentpayment/")
public class StudentPhonePaymentController {

	/**
	 * 学员缴费的业务逻辑
	 */
	@Resource(name="studentPaymentServiceImpl")
	private StudentPaymentService studentPaymentService;
	
	/**
	 * 根据学员编号查询学员缴费信息
	 * @param info 学员信息
	 * @param model 
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(StudentPayment info,Model model){
		
		//查询缴费信息
		List<StudentPayment> list = studentPaymentService.getList(info);
		model.addAttribute("list", list);
		
		return "studentphone/student_payment";
	}
	
}
