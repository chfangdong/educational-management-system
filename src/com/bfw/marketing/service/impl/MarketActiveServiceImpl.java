package com.bfw.marketing.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bfw.marketing.mapper.MarketActiveMapper;
import com.bfw.marketing.service.MarketActiveService;
import com.bfw.po.MarketActive;

@Service
public class MarketActiveServiceImpl implements MarketActiveService{

	/**
	 * 
	 */
	@Resource(name="marketActiveMapper")
	private MarketActiveMapper marketActiveMapper;
	
	@Override
	public boolean addMarket(MarketActive market) {
		
		try {
			
			int count = marketActiveMapper.insertSelective(market);
			if(count>0){
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public boolean updateMarket(MarketActive market) {
		
		try {
			
			int count = marketActiveMapper.updateByPrimaryKeySelective(market);
			if(count>0){
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public boolean deleteMarket(Integer activeId) {
		
		try {
			
			int count = marketActiveMapper.deleteByPrimaryKey(activeId);
			if(count>0){
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<MarketActive> getMarketActiveList(MarketActive market) {
		
		if(market!=null&&market.getActiveName()!=null&&!"".equals(market.getActiveName())){
			market.setActiveName("%"+market.getActiveName()+"%");
		}
		
		return marketActiveMapper.getMarketList(market);
	}

	@Override
	public MarketActive getMarketActive(Integer activeId) {
		// TODO Auto-generated method stub
		return marketActiveMapper.selectByPrimaryKey(activeId);
	}

}
