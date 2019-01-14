package com.casd.controller.finance;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.casd.controller.web.Ref;
import com.casd.entity.finance.MaterialPrice;
import com.casd.service.finance.MaterialPriceService;


@Controller
@RequestMapping("/admin")
public class MaterialPriceController {
	
	
	@Autowired
	private MaterialPriceService materialPriceService;
	
	/**
	 * 材料单价基础资料
	*/
	
	@RequestMapping(value="/materialPrice" , method = RequestMethod.GET)
	public ModelAndView materialPrice(HttpServletRequest request) {
		ModelAndView mv=new ModelAndView();
		String construct_supplier_id = request.getParameter("construct_supplier_id");
		mv.addObject("construct_supplier_id", construct_supplier_id);
		mv.setViewName("finance/materialPrice");
		return mv;
	}
	
	
	@RequestMapping(value="/materialPrice" , method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> materialPrice(HttpServletRequest request,HttpServletResponse response) throws Exception {
		Ref<Integer> record = new Ref<Integer>();
		Map<String, Object> json = new HashMap<String, Object>();
		StringBuffer sbf=new StringBuffer();
		String construct_supplier_id = request.getParameter("construct_supplier_id");
		sbf.append(" ( ");
		sbf.append(" select price.construct_material_priceId, supplier.*,model.construct_material_model_name construct_material_model,model.construct_material_model_unit construct_material_unit ,material.construct_material_name construct_material_name,series.construct_material_seriesName, ");
		sbf.append(" price.construct_material_price,price.construct_material_modelId,price.construct_lowest_price,price.construct_latest_price,price.construct_material_remarks ");
		sbf.append(" from  construct_material_price price ");
		sbf.append(" left join construct_supplier_table supplier on price.construct_material_supplierId=supplier.construct_supplier_id  ");
		
		sbf.append(" left join construct_material_model model on model.construct_material_model_id=price.construct_material_modelId ");
		sbf.append(" left join construct_material_table material on material.construct_material_id=model.construct_material_model_parentid ");
		sbf.append(" left join construct_material_series series on series.construct_material_seriesID=material.construct_material_seriesId ");
		
		sbf.append(" where 1=1 and construct_material_supplierId ="+construct_supplier_id+"");
		sbf.append(" ) tableAll where 1=1  ");
		
		
		String searchName=request.getParameter("construct_material_name");
		String construct_material_model=request.getParameter("construct_material_model");
		if (StringUtils.hasText(searchName)) {
			sbf.append(" and tableAll.construct_material_name like'%"+searchName+"%'");
		}
		if (StringUtils.hasText(construct_material_model)) {
			sbf.append(" and tableAll.construct_material_model like'%"+construct_material_model+"%'");
		}
		
		sbf.append(" order by tableAll.construct_material_seriesName ,tableAll.construct_material_name ");
		
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int pageIndex = Integer.parseInt(request.getParameter("page")) - 1;
		
		List<Map<String, Object>> data=materialPriceService.materialPrice(pageIndex, pageSize, record, sbf.toString());
		
	    json.put("rows", data);
	    json.put("total", record.getValue());
	    return json;
		
	}
	
	
	/**
	 * 添加台账资料
	 * @author Administrator
	 * */
	@RequestMapping(value="/addmaterialprice" , method = RequestMethod.POST)
	@ResponseBody
	 public Map<String, Object> addmaterialprice(HttpServletRequest request) {
		Map<String, Object> json=new HashMap<String, Object>();
		String message="";
		try {
		
		String construct_material_name=request.getParameter("construct_material_name");
		String construct_material_model=request.getParameter("construct_material_model");
		String construct_material_unit=request.getParameter("construct_material_unit");
		 String material_brand=request.getParameter("material_brand");
		 String supplier=request.getParameter("supplier");
		String price=request.getParameter("price");
		String material_remarks=request.getParameter("material_remarks");
		 String construct_material_supplierTel=request.getParameter("construct_material_supplierTel");
		
		String construct_material_supplierId=request.getParameter("construct_supplier_id");
		String construct_lowest_price=request.getParameter("construct_lowest_price");
		String construct_latest_price=request.getParameter("construct_latest_price");
		String construct_material_modelId=request.getParameter("construct_material_modelId");
		
		String construct_material_priceId=request.getParameter("construct_material_priceId").isEmpty()?"0":request.getParameter("construct_material_priceId");
		MaterialPrice mp=new MaterialPrice();
		mp.setConstruct_material_priceId(Integer.parseInt(construct_material_priceId));
		mp.setConstruct_material_name(construct_material_name);
		mp.setConstruct_material_model(construct_material_model);
		mp.setConstruct_material_unit(construct_material_unit);
		mp.setConstruct_material_brand("");
		mp.setConstruct_material_supplier("");
		mp.setConstruct_material_price(Double.parseDouble(price));
		mp.setConstruct_material_remarks(material_remarks);
		mp.setConstruct_material_supplierTel("");
		mp.setConstruct_latest_price(Double.parseDouble(construct_latest_price));
		mp.setConstruct_lowest_price(Double.parseDouble(construct_lowest_price));
		mp.setConstruct_material_modelId(Integer.parseInt(construct_material_modelId));
		mp.setConstruct_material_supplierId(Integer.parseInt(construct_material_supplierId));
		
		message=materialPriceService.insert(mp);
		} catch (Exception e) {
			e.printStackTrace();
			json.put("msg","操作失败！");
		} finally{
			if (!message.equals("")) {
				json.put("msg","此材料已存在，不可选择！");
			}
		}
		 
		return json;
		
	}
	@RequestMapping(value="/deleprice" , method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleprice(HttpServletRequest request)  throws Exception{
		Map<String, Object> json=new HashMap<String, Object>();
	  String material_priceId=request.getParameter("material_priceId");
	  StringBuffer sbf=new StringBuffer();
	  try {
		  sbf.append("where construct_material_priceId="+material_priceId);
		  materialPriceService.delete(sbf.toString());	  
	} catch (Exception e) {
		json.put("msg", "删除失败！");
	}
	 
		return json;
		
	}
	
	
	//重复数据
	@RequestMapping(value="/exis_repetition" , method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> exis_repetition(HttpServletRequest request)  throws Exception{
		Map<String, Object> json=new HashMap<String, Object>();
		String modelId=request.getParameter("modelId");
		String quantities_id=request.getParameter("quantities_id");
		String quantities_conId=request.getParameter("quantities_conId");
		Map<String, Object> map=new HashMap<String, Object>();
		StringBuffer sbf=new StringBuffer();
	  
		try {
			  String fiedsString="*";
			  sbf.append(" construct_project_quantities  where construct_project_quantities_conId="+quantities_conId+" "
			  		+ " and construct_project_quantities_modelId="+modelId+"  and construct_project_quantities_id !="+quantities_id+"");
			  map.put("fieds", fiedsString);
			  map.put("where", sbf);
			  List<Map<String , Object>> data= materialPriceService.exis_repetition(map);
			  json.put("data", data);
	  } catch (Exception e) {
		  json.put("msg", "删除失败！"+e);
	  }
	  	
		return json;
		
	}
}
