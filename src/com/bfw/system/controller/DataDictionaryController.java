package com.bfw.system.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bfw.po.DataDictionary;
import com.bfw.system.service.DataDictionaryService;

/**
 * 数据字典控制器
 * 
 * @author 老牛 2014年11月19日
 *
 */
@Controller
@RequestMapping("/datadictionary/")
public class DataDictionaryController {

	@Resource(name = "dataDictionaryServiceImpl")
	private DataDictionaryService dataDictionaryService;

	/**
	 * 查询数据字典信息
	 * 
	 * @param data
	 * @param model
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(DataDictionary data, Model model) {

		// 查询
		List<DataDictionary> list = dataDictionaryService.getDataList(data);
		// 返回页面
		model.addAttribute("list", list);

		// 查询页面
		return "system/datadictionary/datadictionary_list";
	}

	/**
	 * 添加信息
	 * 
	 * @param data
	 * @param model
	 * @return
	 */
	@RequestMapping("add.do")
	public String add(DataDictionary data, Model model) {

		boolean mark = dataDictionaryService.addData(data);
		if (mark) {
			model.addAttribute("info", "数据字典添加成功");
		} else {
			model.addAttribute("info", "数据字典添加失败");
		}

		return list(data, model);
	}

	/**
	 * 加载修改页面
	 * 
	 * @param dataId
	 * @param model
	 * @return
	 */
	@RequestMapping("load.do")
	public String load(Integer dataId, Model model) {

		DataDictionary data = dataDictionaryService.getDataDictionary(dataId);
		model.addAttribute("data", data);

		return "system/datadictionary/datadictionary_update";
	}

	/**
	 * 修改信息
	 * 
	 * @param data
	 * @param model
	 * @return
	 */
	@RequestMapping("update.do")
	public String update(DataDictionary data, Model model) {

		boolean mark = dataDictionaryService.updateData(data);
		if (mark) {
			model.addAttribute("info", "数据字典修改成功");
		} else {
			model.addAttribute("info", "数据字典修改失败");
		}

		return list(data, model);
	}

	@RequestMapping("delete.do")
	public String delete(Integer dataId, Model model) {

		// 根据编号删除数据字典信息
		boolean mark = dataDictionaryService.deleteData(dataId);

		if(mark){
			model.addAttribute("info", "删除数据字典信息成功");
		}else{
			model.addAttribute("info", "删除数据字典信息失败");
		}
		
		return list(null, model);
	}

}
