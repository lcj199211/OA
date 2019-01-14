package com.casd.service.finance;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.casd.controller.web.Ref;
import com.casd.entity.finance.Material;
import com.casd.entity.finance.MaterialModel;
import com.casd.entity.finance.MaterialSeries;

public interface MaterialService {

	List<Map<String, Object>> materialList(int pageIndex, int pageSize,
			Ref<Integer> record, String string) throws Exception;
 
	  public void addMaterial(Material material);
	  
	  public List<Map<String, Object>> getMaterialById(int pageIndex, int pageSize,
				Ref<Integer> record, String string) throws Exception;

	  public Map<String, Object> editmaterial(MaterialModel materialModel);
	  
	  public String delete(Map<String, Object> deleMap) throws Exception;
	  
	  public void deletemt(Map<String, Object> map);

	void saveSeries(MaterialSeries materialSeries);

	List<Map<String, Object>> selectData(String string, String string2);

	void delete_Series(Map<String, Object> map);

	void cp_material_exl(List<List<Object>> list);
	  
}
