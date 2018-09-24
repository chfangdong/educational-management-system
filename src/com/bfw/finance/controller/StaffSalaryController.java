package com.bfw.finance.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bfw.finance.service.StaffSalaryService;
import com.bfw.po.StaffInfo;
import com.bfw.po.StaffSalary;
import com.bfw.system.service.StaffInfoService;

/**
 * 员工薪水发放的控制器
 * @author 老牛
 * 2014年12月2日
 *
 */
@Controller
@RequestMapping("/staffsalary/")
public class StaffSalaryController {

	@Resource(name="staffSalaryServiceImpl")
	private StaffSalaryService staffSalaryService;
	
	@Resource(name = "staffInfoServiceImpl")
	private StaffInfoService staffInfoService;
	
	@RequestMapping("list.do")
	public String list(StaffSalary info,Model model){
		List<StaffSalary> list = staffSalaryService.getList(info);
		if(list!=null && list.size()>0){
			for(StaffSalary ss:list){
				if("0".equals(ss.getIsUesd())){
					ss.setUrl("<a href='staffsalary/update.do?staffSalaryId="+ss.getStaffSalaryId()+"' >领取工资</a>");
				}else{
					ss.setUrl("已领取");
				}
			}
			
		}
		
		model.addAttribute("list", list);
		
		
		return "finance/staffsalary/staffsalary_list";
	}
	
	@RequestMapping("loadadd.do")
	public String loadAdd(StaffSalary info,Model model){
		
		List<StaffInfo> list = staffInfoService.getList(null);
		model.addAttribute("stafflist", list);
		
		return "finance/staffsalary/staffsalary_add";
	}
	
	@RequestMapping("add.do")
	public String add(StaffSalary info,Model model){
		if(info!=null){
			//1已发放 0 未发放
			info.setIsUesd("0");
			
		}
		boolean mark = staffSalaryService.add(info);
		if(mark){
			model.addAttribute("info", "添加纪录成功!");
		}else{
			model.addAttribute("info", "添加纪录失败!");
		}
		
		return list(info,model);
	}
	
	@RequestMapping("update.do")
	public String update(StaffSalary info,Model model){
		
		if(info!=null){
			//1已发放 0 未发放
			info.setIsUesd("1");
			info.setStaffSalaryTime(new Date());
		}
		
		boolean mark = staffSalaryService.update(info);
		if(mark){
			model.addAttribute("info", "领取成功!");
		}else{
			model.addAttribute("info", "领取失败!");
		}
		
		return list(info,model);
	}
	
}
