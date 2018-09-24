package com.bfw.marketing.controller;

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

import com.bfw.marketing.service.MarketActiveService;
import com.bfw.po.MarketActive;
import com.bfw.po.StaffInfo;

/**
 * 营销活动的实现类
 * 
 * @author 老牛 2014年11月24日
 *
 */
@Controller
@RequestMapping("/marketactive/")
public class MarketActiveController {

	@Resource(name = "marketActiveServiceImpl")
	private MarketActiveService marketActiveService;

	/**
	 * 添加营销活动
	 * 
	 * @param market
	 * @param model
	 * @return
	 */
	@RequestMapping("add.do")
	public String add(MarketActive market, Model model,
			HttpServletRequest request) {

		HttpSession session = request.getSession();
		StaffInfo staff = (StaffInfo) session.getAttribute("staff");

		if (staff != null) {
			if (market != null) {
				market.setStaffId(staff.getStaffId());
			}
		}

		boolean mark = marketActiveService.addMarket(market);
		if (mark) {
			model.addAttribute("info", "添加营销活动成功");
		} else {
			model.addAttribute("info", "添加营销活动失败");
		}

		return list(market, model);
	}

	@RequestMapping("list.do")
	public String list(MarketActive market, Model model) {

		List<MarketActive> list = marketActiveService
				.getMarketActiveList(market);
		
		model.addAttribute("list", list);

		return "marketing/marketactive/marketactive_list";
	}

	/**
	 * 加载修改页面信息
	 * @param activeId
	 * @param model
	 * @return
	 */
	@RequestMapping("load.do")
	public String  load(Integer activeId, Model model){
		
		MarketActive market = marketActiveService.getMarketActive(activeId);
		model.addAttribute("market", market);
		
		return "marketing/marketactive/marketactive_update";
	}
	
	/**
	 * 修改活动信息
	 * @param market
	 * @param model
	 * @return
	 */
	@RequestMapping("update.do")
	public String update(MarketActive market, Model model){
		boolean mark = marketActiveService.updateMarket(market);
		if (mark) {
			model.addAttribute("info", "修改营销活动成功");
		} else {
			model.addAttribute("info", "修改营销活动失败");
		}

		return list(market, model);
	}	
	
	/**
	 * 根据编号删除信息
	 * @param activeId
	 * @param model
	 * @return
	 */
	@RequestMapping("delete.do")
	public String delete(Integer activeId, Model model){
		boolean mark = marketActiveService.deleteMarket(activeId);
		if (mark) {
			model.addAttribute("info", "删除营销活动成功");
		} else {
			model.addAttribute("info", "删除营销活动失败");
		}

		return list(null, model);
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
