package com.casd.service.finance;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.casd.controller.web.Ref;
import com.casd.entity.finance.Base_wages;
import com.casd.entity.finance.Material;
import com.casd.entity.finance.MaterialModel;
import com.casd.entity.finance.MaterialSeries;

public interface WagesService {

	void save_userWages(JSONArray myJsonArray, Double finance_wages_vacaCount, Double finance_wages_dedu, Double finance_wages_wages, Double finance_wages_tax, Double finance_wages_baseTotal);

	Map<String, Object> base_Wages(int userid);

	void submitWages(Base_wages base_wages);

	void dele_userWages(int finance_wages_id);

	  
}
