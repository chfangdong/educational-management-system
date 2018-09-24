package com.bfw.system.controller;

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

import com.bfw.po.StaffInfo;
import com.bfw.system.service.StaffInfoService;

/**
 * 员工信息管理的控制器
 * 
 * @author 老牛 时间：2014年11月1日
 */
@Controller
@RequestMapping("/system/")
public class StaffInfoController {

	@Resource(name = "staffInfoServiceImpl")
	private StaffInfoService staffInfoService;

	/**
	 * 添加员工信息
	 * 
	 * @return
	 */
	@RequestMapping("add.do")
	public String addStaffInfo(StaffInfo staff, Model model) {

		boolean mark = staffInfoService.addStaff(staff);
		if (mark) {

			model.addAttribute("info", "添加成功");
		} else {
			model.addAttribute("info", "添加失败");
		}

		return this.list(null, model);
	}

	@RequestMapping("list.do")
	public String list(StaffInfo staff, Model model) {

		List<StaffInfo> list = staffInfoService.getList(staff);
		model.addAttribute("list", list);

		return "system/staffinfo/staffinfo_list";
	}

	/**
	 * 根据编号查询员工信息
	 * 
	 * @param staffId
	 *            员工编号
	 * @param model
	 * @return
	 */
	@RequestMapping("show.do")
	public String showStaffInfo(Integer staffId, Model model) {

		StaffInfo staffInfo = staffInfoService.getStaffInfo(staffId);
		model.addAttribute("staffInfo", staffInfo);

		return "system/staffinfo/staffinfo_show";
	}
	
	/**
	 * 根据编号查询员工信息
	 * 
	 * @param staffId
	 *            员工编号
	 * @param model
	 * @return
	 */
	@RequestMapping("load.do")
	public String loadUpdate(Integer staffId, Model model) {

		StaffInfo staffInfo = staffInfoService.getStaffInfo(staffId);
		model.addAttribute("staffInfo", staffInfo);

		return "system/staffinfo/staffinfo_update";
	}
	
	/**
	 * 修改员工信息
	 * 
	 * @return
	 */
	@RequestMapping("update.do")
	public String updateStaffInfo(StaffInfo staff, Model model) {

		boolean mark = staffInfoService.updateStaff(staff);
		if (mark) {

			model.addAttribute("info", "修改成功");
		} else {
			model.addAttribute("info", "修改失败");
		}

		return this.list(null, model);
	}
	
	/**
	 * 修改员工信息
	 * 
	 * @return
	 */
	@RequestMapping("delete.do")
	public String deleteStaffInfo(StaffInfo staff, Model model) {
		//设置员工信息为 0无效  1普通员工  2 教师 
		staff.setStaffState("0");
		boolean mark = staffInfoService.updateStaff(staff);
		if (mark) {

			model.addAttribute("info", "删除成功");
		} else {
			model.addAttribute("info", "删除失败");
		}

		return this.list(null, model);
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
