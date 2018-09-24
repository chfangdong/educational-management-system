package com.bfw.educational.controller;

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

import com.bfw.classinfo.service.ClassInfoService;
import com.bfw.educational.service.ClassTransactionInfoService;
import com.bfw.po.ClassInfo;
import com.bfw.po.ClassTransactionInfo;

/**
 * 班级事务管理的控制器
 * @author 老牛
 * 2014年12月1日
 *
 */
@Controller
@RequestMapping("/classtransactioninfo/")
public class ClassTransactionInfoController {

	/**
	 * 班级事务业务逻辑处理
	 */
	@Resource(name="classTransactionInfoServiceImpl")
	private ClassTransactionInfoService classTransactionInfoService;

	/**|
	 * 班级业务逻辑
	 */
	@Resource(name="classInfoServiceImpl")
	private ClassInfoService classInfoService;
	
	/**
	 * 查询班级事务信息
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(ClassTransactionInfo info,Model model){
		
		List<ClassTransactionInfo> list =classTransactionInfoService.getList(info);
		model.addAttribute("list", list);
		
		return "educational/classtransactioninfo/classtransactioninfo_list";
	}
	
	/**
	 * 加载添加页面
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("loadadd.do")
	public String loadadd(Model model){
		
		List<ClassInfo> classlist = classInfoService.getList(null);
		model.addAttribute("classlist", classlist);
		
		return "educational/classtransactioninfo/classtransactioninfo_add";
	}
	
	/**
	 * 加载修改页面
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("loadupdate.do")
	public String loadadd(Integer classTransactionId,Model model){
		
		List<ClassInfo> classlist = classInfoService.getList(null);
		model.addAttribute("classlist", classlist);
		
		ClassTransactionInfo transactinfo = classTransactionInfoService.getInfo(classTransactionId);
		model.addAttribute("transactinfo", transactinfo);
		
		
		return "educational/classtransactioninfo/classtransactioninfo_update";
	}
	
	@RequestMapping("add.do")
	public String add(ClassTransactionInfo info,Model model){
		
		boolean mark = classTransactionInfoService.add(info);
		if(mark){
			model.addAttribute("info", "添加班级事务信息成功");
		}else{
			model.addAttribute("info", "添加班级事务信息失败");
		}
		
		return list(info,model);
	}
	
	
	@RequestMapping("update.do")
	public String update(ClassTransactionInfo info,Model model){
		
		boolean mark = classTransactionInfoService.update(info);
		if(mark){
			model.addAttribute("info", "修改班级事务信息成功");
		}else{
			model.addAttribute("info", "修改班级事务信息失败");
		}
		
		return list(info,model);
	}
	
	@RequestMapping("delete.do")
	public String delete(Integer classTransactionId,Model model){
		
		boolean mark = classTransactionInfoService.delete(classTransactionId);
		if(mark){
			model.addAttribute("info", "删除班级事务信息成功");
		}else{
			model.addAttribute("info", "删除班级事务信息失败");
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
