package com.casd.dao.finance;

import java.util.List;
import java.util.Map;

import com.casd.entity.finance.Base_wages;
import com.casd.entity.finance.Material;
import com.casd.entity.finance.MaterialModel;
import com.casd.entity.finance.MaterialPrice;
import com.casd.entity.finance.MaterialSeries;
import com.casd.entity.finance.Wages;

public interface WagesDao {

	void save_userWages(Wages wages);

	Map<String, Object> base_Wages(int userid);

	void submitWages(Base_wages base_wages);

	void dele_userWages(int finance_wages_id);


}
