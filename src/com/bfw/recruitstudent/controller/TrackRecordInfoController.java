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

import com.bfw.po.StaffInfo;
import com.bfw.po.StudentInfo;
import com.bfw.po.TrackRecordInfo;
import com.bfw.recruitstudent.service.StudentInfoService;
import com.bfw.recruitstudent.service.TrackRecordInfoService;

/**
 * 跟踪记录的控制器
 * 
 * @author 老牛 2014年11月25日
 *
 */
@Controller
@RequestMapping("/trackrecordinfo/")
public class TrackRecordInfoController {

	@Resource(name = "trackRecordInfoServiceImpl")
	private TrackRecordInfoService trackRecordInfoService;

	@Resource(name = "studentInfoServiceImpl")
	private StudentInfoService studentInfoService;
	
	
	/**
	 * 查询跟踪记录信息
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(TrackRecordInfo info, Model model){
		
		List<TrackRecordInfo> list = trackRecordInfoService.getTrackRecordList(info);
		model.addAttribute("list", list);
		
		return "recruitstudent/trackrecord/trackrecord_list";
	}
	
	/**
	 * 根据编号查询跟踪记录信息
	 * @param trackRecordId
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("load.do")
	public String loadUpdate(Integer trackRecordId,Model model, HttpServletRequest request){
		
		HttpSession session = request.getSession();
		StaffInfo staff = (StaffInfo) session.getAttribute("staff");

		StudentInfo stuinfo = new StudentInfo();

		if (staff != null) {
			stuinfo.setStaffId(staff.getStaffId());
		}
		stuinfo.setStudentMark("1");// -1 表示无效 0表示未分配学员 1已分配学员 2报名学员

		List<StudentInfo> list = studentInfoService.getStudentInfoList(stuinfo);
		model.addAttribute("list", list);
		
		
		TrackRecordInfo trackinfo = trackRecordInfoService.getTrackRecord(trackRecordId);
		model.addAttribute("trackinfo", trackinfo);
		
		
		
		return "recruitstudent/trackrecord/trackrecord_update";
	}
	
	/**
	 * 修改信息
	 * 
	 * @param info
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("update.do")
	public String update(TrackRecordInfo info, Model model) {

		boolean mark = trackRecordInfoService.updateTrackRecord(info);
		if(mark){
			model.addAttribute("info", "修改跟踪记录信息成功");
		}else{
			model.addAttribute("info", "修改跟踪记录信息失败");
		}
		
		
		return list(info,model);
	}
	
	/**
	 * 删除信息
	 * 
	 * @param info
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("delete.do")
	public String delete(Integer trackRecordId, Model model) {

		boolean mark = trackRecordInfoService.deleteTrackRecord(trackRecordId);
		if(mark){
			model.addAttribute("info", "删除跟踪记录信息成功");
		}else{
			model.addAttribute("info", "删除跟踪记录信息失败");
		}
		
		return list(null,model);
	}
	
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

		return "recruitstudent/trackrecord/trackrecord_add";
	}

	/**
	 * 添加信息
	 * 
	 * @param info
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("add.do")
	public String add(TrackRecordInfo info, Model model) {

		boolean mark = trackRecordInfoService.addTrackRecord(info);
		if(mark){
			model.addAttribute("info", "添加跟踪记录信息成功");
		}else{
			model.addAttribute("info", "添加跟踪记录信息失败");
		}
		
		
		return list(info,model);
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
