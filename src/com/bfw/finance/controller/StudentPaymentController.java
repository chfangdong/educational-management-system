package com.bfw.finance.controller;

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
import com.bfw.finance.service.StudentPaymentService;
import com.bfw.po.ClassInfo;
import com.bfw.po.StaffInfo;
import com.bfw.po.StudentInfo;
import com.bfw.po.StudentPayment;
import com.bfw.recruitstudent.service.StudentInfoService;
import com.bfw.recruitstudent.service.TrackRecordInfoService;

/**
 * 学员管理缴费
 * 
 * @author 老牛 2014年11月30日
 *
 */
@Controller
@RequestMapping("/studentpayment/")
public class StudentPaymentController {

	@Resource(name = "studentInfoServiceImpl")
	private StudentInfoService studentInfoService;

	@Resource(name = "trackRecordInfoServiceImpl")
	private TrackRecordInfoService trackRecordInfoService;

	/**
	 * 学员缴费的业务逻辑
	 */
	@Resource(name="studentPaymentServiceImpl")
	private StudentPaymentService studentPaymentService;
	
	/**
	 * 班级Service
	 */
	@Resource(name = "classInfoServiceImpl")
	private ClassInfoService classInfoService;



	@RequestMapping("list.do")
	public String list(StudentInfo stuinfo, Model model,
			HttpServletRequest request) {

		// HttpSession session = request.getSession();
		// StaffInfo staff = (StaffInfo) session.getAttribute("staff");

		if (stuinfo == null) {
			stuinfo = new StudentInfo();
		}
		// if (staff != null) {
		// stuinfo.setStaffId(staff.getStaffId());
		// }
		stuinfo.setStudentMark("2");// -1 表示无效 0表示未分配学员 1已分配学员 2报名学员

		List<StudentInfo> list = studentInfoService.getStudentInfoList(stuinfo);
		model.addAttribute("list", list);
		model.addAttribute("stuinfo", stuinfo);

		return "finance/studentpayment/studentpayment_list";
	}

	

	/**
	 * 根据编号查询学员信息
	 * 
	 * @param studentId
	 * @param model
	 * @return
	 */
	@RequestMapping("show.do")
	public String show(StudentPayment info, Model model) {

		StudentInfo stuinfo = studentInfoService.getStudentInfo(info.getStudentId());
		model.addAttribute("stuinfo", stuinfo);

		// 根据编号查询班级信息
		ClassInfo classInfo = classInfoService.getClassInfo(stuinfo.getClassId());
		model.addAttribute("classInfo", classInfo);
		
		List<StudentPayment> list = studentPaymentService.getList(info);
		model.addAttribute("list", list);
		
		return "finance/studentpayment/studentpayment_show";
	}
	
	
	/**
	 * 根据编号查询学员信息
	 * 
	 * @param studentId
	 * @param model
	 * @return
	 */
	@RequestMapping("loadpayment.do")
	public String loadpayment(Integer studentId, Model model) {

		StudentInfo stuinfo = studentInfoService.getStudentInfo(studentId);
		model.addAttribute("stuinfo", stuinfo);

		// 根据编号查询班级信息
		ClassInfo classInfo = classInfoService.getClassInfo(stuinfo.getClassId());
		model.addAttribute("classInfo", classInfo);
		
		
		
		return "finance/studentpayment/student_payment";
	}
	
	/**
	 * 学员缴费
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("payment.do")
	public String payment(StudentPayment info,Model model,HttpServletRequest request){
		
		HttpSession session = request.getSession();
		StaffInfo staff = (StaffInfo) session.getAttribute("staff");

		if(info!=null){
			info.setStaffId(staff.getStaffId());
		}
		
		
		
		boolean mark = studentPaymentService.add(info);
		if(mark){
			StudentInfo stuinfo = new StudentInfo();
			stuinfo.setStudentId(info.getStudentId());
			if(info.getDebtAmount()>0){
				stuinfo.setStudentIspay("1");//部分缴费
			}else{
				stuinfo.setStudentIspay("2");//已经交清费用
			}
			
			studentInfoService.updateStudent(stuinfo);
			
			model.addAttribute("info", "缴费成功");
		}else{
			model.addAttribute("info", "缴费失败");
		}
		
		return show(info,model);
	}

	
	@RequestMapping("delete.do")
	public String delete(Integer paymentId,Model model,HttpServletRequest request){
		
		boolean mark = studentPaymentService.delete(paymentId);
		if(mark){
			
			
			model.addAttribute("info", "删除缴费信息成功");
		}else{
			model.addAttribute("info", "删除缴费信息失败");
		}
		
		return list(null,model,request);
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
