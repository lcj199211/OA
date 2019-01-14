package com.casd.serviceimpl.finance;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casd.controller.web.Ref;
import com.casd.dao.finance.MaterialDao;
import com.casd.dao.finance.MaterialPriceDao;
import com.casd.dao.finance.WagesDao;
import com.casd.entity.construct.PurChangeEmtry;
import com.casd.entity.finance.Base_wages;
import com.casd.entity.finance.Material;
import com.casd.entity.finance.MaterialModel;
import com.casd.entity.finance.MaterialPrice;
import com.casd.entity.finance.MaterialSeries;
import com.casd.entity.finance.Wages;
import com.casd.service.finance.MaterialService;
import com.casd.service.finance.WagesService;

@Service
public class WagesServiceImpl implements WagesService{

	@Autowired
	private WagesDao wagesDao;

	@Override
	@Transactional
	public void save_userWages(JSONArray myJsonArray,Double finance_wages_vacaCount,
			Double finance_wages_dedu,Double finance_wages_wages,Double finance_wages_tax,Double finance_wages_baseTotal) {
		
		JSONObject jsonObject = myJsonArray.getJSONObject(0);
		Wages wages = (Wages) JSONObject.toBean(jsonObject,  
				Wages.class);
		Calendar c1 = Calendar.getInstance();
		// 获得年份
		int year = c1.get(Calendar.YEAR);
		// 获得月份
		int month = c1.get(Calendar.MONTH);
		String monString=String.valueOf(month);
		if (month<10) {
			monString="0"+month;
		}
		wages.setFinance_wages_yearMon(""+year+"-"+monString+"");
		wages.setFinance_wages_vacaCount(finance_wages_vacaCount);
		wages.setFinance_wages_dedu(finance_wages_dedu);
		wages.setFinance_wages_wages(finance_wages_wages);
		wages.setFinance_wages_tax(finance_wages_tax);
		wages.setFinance_wages_baseTotal(finance_wages_baseTotal);
		wagesDao.save_userWages(wages);
	}

	@Override
	@Transactional
	public Map<String, Object> base_Wages(int userid) {
		// TODO Auto-generated method stub
		return wagesDao.base_Wages(userid);
	}

	@Override
	public void submitWages(Base_wages base_wages) {
		// TODO Auto-generated method stub
		wagesDao.submitWages(base_wages);
	}

	@Override
	public void dele_userWages(int finance_wages_id) {
		// TODO Auto-generated method stub
		wagesDao.dele_userWages(finance_wages_id);
	}
	

}
