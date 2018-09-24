package com.bfw.classinfo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bfw.classinfo.service.SyllabusInfoService;
import com.bfw.po.SyllabusInfo;

/**
 * 课程表的控制器
 * 
 * @author 老牛 2014年11月29日
 * 
 */
@Controller
@RequestMapping("/syllabusinfo/")
public class SyllabusInfoController {

	@Resource(name = "syllabusInfoServiceImpl")
	private SyllabusInfoService syllabusInfoService;

	/**
	 * 根据条件查询课程表信息
	 * 
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(SyllabusInfo info, Model model) {

		List<SyllabusInfo> list = syllabusInfoService.getList(info);
		model.addAttribute("list", list);
		return "classinfo/syllabusinfo/syllabusinfo_list";
	}

	/**
	 * 加载修改页面
	 * 
	 * @param syllabusId
	 * @param model
	 * @return
	 */
	@RequestMapping("load.do")
	public String load(Integer syllabusId, Model model) {

		SyllabusInfo syllabus = syllabusInfoService.getSyllabusInfo(syllabusId);
		model.addAttribute("syllabus", syllabus);

		return "classinfo/syllabusinfo/syllabusinfo_update";
	}

	/**
	 * 添加课程表信息
	 * 
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("add.do")
	public String add(SyllabusInfo info, Model model) {

		if (info == null) {
			info = new SyllabusInfo();
		}
		info.setIsUesd("1");
		boolean mark = syllabusInfoService.addSyllabus(info);
		if (mark) {
			model.addAttribute("info", "添加课程表成功");
		} else {
			model.addAttribute("info", "添加课程表失败");
		}

		return list(info, model);
	}

	/**
	 * 修改课程表信息
	 * 
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("update.do")
	public String update(SyllabusInfo info, Model model) {
		boolean mark = syllabusInfoService.updateSyllabus(info);
		if (mark) {
			model.addAttribute("info", "修改课程表成功");
		} else {
			model.addAttribute("info", "修改课程表失败");
		}

		return list(info, model);
	}

	/**
	 * 删除课程表信息
	 * 
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("delete.do")
	public String delete(SyllabusInfo info, Model model) {
		// 1为有效 0 为无效
		info.setIsUesd("0");
		boolean mark = syllabusInfoService.updateSyllabus(info);
		if (mark) {
			model.addAttribute("info", "删除课程表成功");
		} else {
			model.addAttribute("info", "删除课程表失败");
		}

		return list(info, model);
	}

}
