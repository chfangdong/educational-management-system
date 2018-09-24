package com.bfw.studentphone.controllerr;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bfw.po.StudentInfo;
import com.bfw.recruitstudent.service.StudentInfoService;

/**
 * 手机端登录的控制器
 * 
 * @author 老牛 2014年12月4日
 *
 */
@Controller
@RequestMapping("/studentphone/")
public class LoginPhoneController {

	/**
	 * 学员业务逻辑
	 */
	@Resource(name = "studentInfoServiceImpl")
	private StudentInfoService studentInfoService;

	/**
	 * 手机登录
	 * 
	 * @param info
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("login.do")
	public String isLogin(StudentInfo info, Model model, HttpSession session) {

		if (info != null && info.getStudentNumber() != null
				&& !info.getStudentNumber().equals("")
				&& info.getStudentPassword() != null
				&& !info.getStudentPassword().equals("")) {
			
			info.setStudentMark("2");

			List<StudentInfo> list = studentInfoService
					.getStudentInfoList(info);
			if (list != null && list.size() > 0) {

				StudentInfo stuinfo = list.get(0);
				if (stuinfo != null) {

					session.setAttribute("stuinfo", stuinfo);
					return "studentphone/student_index";
				}

			}
		}

		return "login_phone";
	}
	
	/**
	 * 退出登录
	 * @return
	 */
	@RequestMapping("loadlogin.do")
	public String laodLogin(Model model,HttpSession session){
		session.removeAttribute("stuinfo");
		return "login_phone";
	}

	
}
