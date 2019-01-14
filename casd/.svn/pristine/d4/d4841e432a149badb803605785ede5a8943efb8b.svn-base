package com.casd.controller.construct;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.casd.controller.web.Ref;
import com.casd.controller.web.common.excel.ImportExcel;
import com.casd.entity.construct.ApartyMaterial;
import com.casd.entity.construct.ApartyPur;
import com.casd.entity.uc.User;
import com.casd.service.construct.APartyService;
import com.casd.service.construct.ConstructService;
import com.casd.service.hr.ActivitiService;
import com.casd.service.manage.SupOpinionService;


@Controller
@RequestMapping("/admin")
public class APartyController {
	
	@Autowired
	private ConstructService constructService;
	@Autowired
	private APartyService aPartyService;
	
	@Autowired
	private ActivitiService activitiService;  
	
	@Autowired
	private SupOpinionService supOpinionService;
	
	/**
	 * 建设公司项目list
	 */
	@RequestMapping(value = "/aPartyConList", method = RequestMethod.GET)
	public ModelAndView aPartyConList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("construct/aPartyConList");
		return mv;
	}

	@RequestMapping(value = "/aPartyConList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> aPartyConList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Ref<Integer> record = new Ref<Integer>();
		Map<String, Object> json = new HashMap<String, Object>();
		StringBuffer sbf = new StringBuffer();
		sbf.append(" construct_project_table pro left join construct_project_dep dep on dep.constuct_project_dep_id=pro.construct_project_dep where dep.constuct_project_dep_company=1  ");
		String construct_project_name = request.getParameter("construct_project_name");
		if (StringUtils.hasText(construct_project_name)) {
			sbf.append(" and pro.construct_project_name like '%" + construct_project_name
					+ "%'");
		}
		
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int pageIndex = Integer.parseInt(request.getParameter("page")) - 1;
		
		
		List<Map<String, Object>> data = constructService.constructList(
				pageIndex, pageSize, record, sbf.toString());

		json.put("rows", data);
		json.put("total", record.getValue());
		return json;

	}
	    
	
	/**
	 * 甲供材料list
	 */
	@RequestMapping(value = "/aPartyMaterialList", method = RequestMethod.GET)
	public ModelAndView aPartyMaterialList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("construct_project_id", request.getParameter("construct_project_id"));
		mv.setViewName("construct/aPartyMaterialList");
		return mv;
	}
	@RequestMapping(value = "/aPartyMaterialList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> aPartyMaterialList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Ref<Integer> record = new Ref<Integer>();
		Map<String, Object> json = new HashMap<String, Object>();
		StringBuffer sbf = new StringBuffer();
		
		sbf.append(" (select mat.construct_Aparty_material_id,mat.construct_Aparty_material_name,mat.construct_Aparty_material_unit, ");
		sbf.append(" mat.construct_Aparty_material_category,mat.construct_Aparty_material_num,mat.construct_Aparty_material_model, ");
		sbf.append(" mat.construct_Aparty_material_remark,mat.construct_Aparty_material_constructId,SUM(purentry.construct_Aparty_purEntry_num) sum ");
		sbf.append(" from construct_aparty_material mat ");
		sbf.append(" left join  construct_aparty_purentry purentry on mat.construct_Aparty_material_id=construct_Aparty_purEntry_materialId ");
		sbf.append(" where mat.construct_Aparty_material_constructId="+request.getParameter("construct_project_id")+"");
		sbf.append(" GROUP BY mat.construct_Aparty_material_id");
		sbf.append(" ) tableAParty  where 1=1 ");
		
		//sbf.append(" construct_aparty_material  where construct_Aparty_material_constructId="+request.getParameter("construct_project_id")+"");
		String material_category = request.getParameter("material_category");
		if (StringUtils.hasText(material_category)) {
			sbf.append(" and  tableAParty.construct_Aparty_material_category like '%" + material_category
					+ "%'");
		}
		String material_name = request.getParameter("material_name");
		if (StringUtils.hasText(material_name)) {
			sbf.append(" and tableAParty.construct_Aparty_material_name like '%" + material_name
					+ "%'");
		}
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int pageIndex = Integer.parseInt(request.getParameter("page")) - 1;
		
		
		List<Map<String, Object>> data = aPartyService.getList(
				pageIndex, pageSize, record, sbf.toString());
		
		Double material_num=0.00;
		Double sum=0.00;
	    for (Map<String, Object> m : data){
	    	material_num =material_num + Double.valueOf(m.get("construct_Aparty_material_num").toString()==null?"0.00":m.get("construct_Aparty_material_num").toString());
	    	sum =sum + Double.valueOf((m.get("sum")==null?"0.00":m.get("sum")).toString());
	    }
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> footMap = new HashMap<String, Object>();
		footMap.put("sum", sum);
		footMap.put("construct_Aparty_material_num", material_num);
		list.add(footMap);
		json.put("footer", list);
		json.put("rows", data);
		json.put("total", record.getValue());
		return json;

	}
	
	
	/**
	 * 订单list
	 */
	@RequestMapping(value = "/aPartyPurList", method = RequestMethod.GET)
	public ModelAndView aPartyPurList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("construct_project_id", request.getParameter("construct_project_id"));
		mv.setViewName("construct/aPartyPurList");
		return mv;
	}
	
	@RequestMapping(value = "/aPartyPurList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> aPartyPurList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Ref<Integer> record = new Ref<Integer>();
		Map<String, Object> json = new HashMap<String, Object>();
		StringBuffer sbf = new StringBuffer();
		sbf.append(" construct_aparty_purchase apa left join construct_project_table pro on apa.construct_Aparty_purchase_constructId=pro.construct_project_id where apa.construct_Aparty_purchase_constructId="+request.getParameter("construct_project_id")+"");
		String construct_Aparty_purchase_orderNum = request.getParameter("construct_Aparty_purchase_orderNum");
		if (StringUtils.hasText(construct_Aparty_purchase_orderNum)) {
			sbf.append(" and apa.construct_Aparty_purchase_orderNum like '%" + construct_Aparty_purchase_orderNum
					+ "%'");
		}
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int pageIndex = Integer.parseInt(request.getParameter("page")) - 1;
		
		
		List<Map<String, Object>> data = aPartyService.getList(
				pageIndex, pageSize, record, sbf.toString());

		json.put("rows", data);
		json.put("total", record.getValue());
		return json;
	}
	
	
	/**
	 * 添加订单明细
	 */
	@RequestMapping(value = "/aPartyPurNew", method = RequestMethod.GET)
	public ModelAndView aPartyPurEntry(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
	
		Map<String, Object> aParty=new HashMap<String, Object>();
		int construct_Aparty_purchase_id=Integer.valueOf(request.getParameter("construct_Aparty_purchase_id").toString().equals("")?"0":request.getParameter("construct_Aparty_purchase_id").toString());
		String type="";
	      
        String fields="*";
        String where="";
        List<Map<String, Object>> entries=null;
        StringBuffer sbf=new StringBuffer();
        
                where +=" construct_aparty_purchase apa";
     			where +=" left join construct_project_table pro";
     			where +=" on apa.construct_Aparty_purchase_constructId=pro.construct_project_id";  
     			where +="  where apa.construct_Aparty_purchase_id="+construct_Aparty_purchase_id;
     			sbf.append(" construct_aparty_purentry entry");
     			sbf.append(" left join construct_aparty_material mat");
     	        sbf.append(" on entry.construct_Aparty_purEntry_materialId=mat.construct_Aparty_material_id");
     	        sbf.append(" where construct_Aparty_purEntry_parentId="+construct_Aparty_purchase_id+"");
        
		if(construct_Aparty_purchase_id!=0){
			aParty=aPartyService.getConstruct(fields,where);
			entries=aPartyService.dataList(fields,sbf.toString());				
		}else{
			
			Integer construct_project_id = Integer.valueOf(request.getParameter("construct_project_id"));
			sbf.delete(0, sbf.length());
			sbf.append("construct_project_table where construct_project_id="+construct_project_id);
		
			aParty = aPartyService.getConstruct(fields,sbf.toString());
			aParty.put("construct_Aparty_purchase_constructId", construct_project_id);
			aParty.put("construct_Aparty_purchase_id",0);
	
			type="new";
		}
		JSONObject json =new JSONObject();
		json.put("entries", entries);
		json.put("type", type);
		mv.addObject("aParty",aParty);
		mv.addObject("entries", json);
		mv.setViewName("construct/aPartyPurNew");
		return mv;
	}
	
	
	/**
	 * 查看订单明细
	 * @throws Exception 
	 */
	@RequestMapping(value = "/aPartyPurView", method = RequestMethod.GET)
	public ModelAndView aPartyPurView(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();

       Map<String, Object> aParty=new HashMap<String, Object>();
		int construct_Aparty_purchase_id=Integer.valueOf(request.getParameter("construct_Aparty_purchase_id").toString().equals("")?"0":request.getParameter("construct_Aparty_purchase_id").toString());
		
		    String fields="*";
	        String where="";
	        List<Map<String, Object>> entries=null;
	        StringBuffer sbf=new StringBuffer();
		if(construct_Aparty_purchase_id!=0){
		 
	        where +=" construct_aparty_purchase apa";
			where +=" left join construct_project_table pro";
			where +=" on apa.construct_Aparty_purchase_constructId=pro.construct_project_id";  
			where +="  where apa.construct_Aparty_purchase_id="+construct_Aparty_purchase_id;
			sbf.append(" construct_aparty_purentry entry");
			sbf.append(" left join construct_aparty_material mat");
	        sbf.append(" on entry.construct_Aparty_purEntry_materialId=mat.construct_Aparty_material_id");
	        sbf.append(" where construct_Aparty_purEntry_parentId="+construct_Aparty_purchase_id+"");
	        
	    	aParty=aPartyService.getConstruct(fields,where);
			entries=aPartyService.dataList(fields,sbf.toString());
		}else{
		
			Integer construct_project_id = Integer.valueOf(request.getParameter("construct_project_id"));
			sbf.delete(0, sbf.length());
			sbf.append(" construct_project_table where construct_project_id="+construct_project_id);
		
			aParty = aPartyService.getConstruct(fields,sbf.toString());
			aParty.put("construct_Aparty_purchase_constructId", construct_project_id);
			aParty.put("construct_Aparty_purchase_id",0);
		
		}
		
		String bizId = String.valueOf(construct_Aparty_purchase_id);
		String beyId = "aPartyPurView"; // 流程实例key 请勿改动

		List<Map<String, Object>> historyList = activitiService.viewHisComments(bizId, beyId);
		//审核历史意见
	
		
		JSONObject json =new JSONObject();
		
		json.put("history", historyList);
		mv.addObject("history", json);
		
		json.put("entries", entries);
		mv.addObject("aParty", aParty);
		mv.addObject("entries", json);
		mv.setViewName("construct/aPartyPurView");
		return mv;
	}
	
	
	
	/**
	 * 保存工程量
	 * 
	 * */
	@RequestMapping(value = "/save_aPartyMaterial", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> save_aPartyMaterial(HttpServletRequest request, ApartyMaterial apartyMaterial)
			throws Exception {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			String project_name=request.getParameter("project_name");
			System.out.println(project_name);
		//	aPartyService.save_aPartyMaterial(apartyMaterial);
			json.put("Success", true);
			json.put("Msg", "保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			json.put("Success", false);
			json.put("Msg", "上传失败" + e);
		}
		return json;
	}
	
	/**
	 * 删除
	*/
	@RequestMapping(value = "/delete_aPartyMaterial", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete_aPartyMaterial(HttpServletRequest request) throws Exception {
		Map<String, Object> json=new HashMap<String, Object>();
		try {	
		String cid = request.getParameter("cid");
		cid = cid.substring(1);
		String[] ids = cid.split("]");
		StringBuffer sbf = new StringBuffer();
		sbf.append(" where construct_Aparty_material_id in(" + ids[0] + ")");
		System.out.println(sbf.toString());
		aPartyService.delete_aPartyMaterial(sbf.toString());
		} catch (Exception e) {
			json.put("msg", "删除失败！");
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 方法说明：将Excel表格数据 导入
	 * 
	 * */
	@RequestMapping(value = "/cp_aParty_exl", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object>  cp_aParty_exl(MultipartFile pic,
			HttpServletRequest request) throws IOException {
		Map<String, Object> json = new HashMap<String, Object>();

		try {

			// 获取原始文件名
			String fileName = pic.getOriginalFilename();

			String construct_project_id = request.getParameter("construct_project_id");

			List<List<Object>> list = new ArrayList<List<Object>>();
			ImportExcel ie = new ImportExcel();

			if (StringUtils.isEmpty(fileName)) {
				json.put("Success", false);
				json.put("Msg", "请选择要导入的文件");
				return json;
			}

			if (!fileName.substring(fileName.lastIndexOf(".")).equals(".xlsx")) {
				json.put("Success", false);
				json.put("Msg", "请选择Excel2007以上版本文件.xlsx");
				return json;
			}

			File file2 = new File("e:/uploadfile");
			if (!file2.exists()) {
				file2.mkdirs();
			}

			// 定义文件路径
			String fileUploadBasePath = "e:/uploadfile/";
			File newFile = new File(fileUploadBasePath
					+ System.currentTimeMillis() + fileName);

			pic.transferTo(newFile); // 写入文件到服务器目录

			list = ie.read2007Excel(newFile);

			// 读取完信息删除上传文件
			// 判断文件存在,删除
			if (newFile.exists()) {
				newFile.delete();
			}
			
			aPartyService.cp_aParty_exl(list,construct_project_id);
			
			json.put("Success", true);
			json.put("Msg", "导入成功");
		} catch (Exception e) {
			json.put("Success", false);
			json.put("Msg", "导入失败" + e);
		}
		return json;
	}
	
	
	
	/**
	 * 甲供材料选择
	 * 
	 */
	@RequestMapping(value = "/aPartyMaterialCheck", method = RequestMethod.GET)
	public ModelAndView aPartyMaterialCheck(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("construct_project_id", request.getParameter("construct_project_id"));
		mv.addObject("index", request.getParameter("index"));
		mv.setViewName("checkBox/aPartyMaterialCheck");
		return mv;
	}
	@RequestMapping(value = "/aPartyMaterialCheck", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> aPartyMaterialCheck(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Ref<Integer> record = new Ref<Integer>();
		Map<String, Object> json = new HashMap<String, Object>();
		StringBuffer sbf = new StringBuffer();
		
		String filds = "mat.construct_Aparty_material_id,mat.construct_Aparty_material_name,mat.construct_Aparty_material_unit,"
				+ " mat.construct_Aparty_material_category,mat.construct_Aparty_material_num,mat.construct_Aparty_material_model,"
				+ " mat.construct_Aparty_material_remark,mat.construct_Aparty_material_constructId, sum ";
		
		sbf.append(" (select mat.construct_Aparty_material_id,mat.construct_Aparty_material_name,mat.construct_Aparty_material_unit, ");
		sbf.append(" mat.construct_Aparty_material_category,mat.construct_Aparty_material_num,mat.construct_Aparty_material_model, ");
		sbf.append(" mat.construct_Aparty_material_remark,mat.construct_Aparty_material_constructId,SUM(purentry.construct_Aparty_purEntry_num) sum ");
		sbf.append(" from construct_aparty_material mat ");
		sbf.append(" left join  construct_aparty_purentry purentry on mat.construct_Aparty_material_id=construct_Aparty_purEntry_materialId ");
		sbf.append(" where mat.construct_Aparty_material_constructId="+request.getParameter("construct_project_id")+"");
		sbf.append(" GROUP BY mat.construct_Aparty_material_id");
		sbf.append(" ) tableAll ");
		/*String construct_project_name = request.getParameter("construct_project_name");
		if (StringUtils.hasText(construct_project_name)) {
			sbf.append(" and pro.construct_project_name like '%" + construct_project_name
					+ "%'");
		}*/
		
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int pageIndex = Integer.parseInt(request.getParameter("page")) - 1;
		
		
		List<Map<String, Object>> data = aPartyService.getList(
				pageIndex, pageSize, record, sbf.toString());

		json.put("rows", data);
		json.put("total", record.getValue());
		return json;

	}
	
	
	/**
	 * 保存采购单
	 * 
	 * */
	@RequestMapping(value = "/save_aPartyPur", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> save_aPartyPur(HttpServletRequest request, ApartyPur apartyPur)
			throws Exception {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
		
			int construct_Aparty_purchase_id= aPartyService.save_aPartyPur(apartyPur,request);
			
			json.put("construct_Aparty_purchase_id", construct_Aparty_purchase_id);
			json.put("Success", true);
			json.put("Msg", "保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			json.put("Success", false);
			json.put("Msg", "保存失败");
		}
		return json;
	}
	
	/**
	 * 删除采购单
	*/
	@RequestMapping(value = "/dele_apartyPur", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> dele_apartyPur(HttpServletRequest request) throws Exception {
		Map<String, Object> json=new HashMap<String, Object>();
		try {	
		String id = request.getParameter("id");
		
		aPartyService.dele_apartyPur(id);
		
		json.put("Success", true);
		json.put("msg", "删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
			json.put("Success", false);
			json.put("msg", "删除失败！");
			
		}
		return json;
	}
	
	/**
	 * 删除采购单
	*/
	@RequestMapping(value = "/delete_aPartyEntry", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete_aPartyEntry(HttpServletRequest request) throws Exception {
		Map<String, Object> json=new HashMap<String, Object>();
		try {	
		String id = request.getParameter("id");
		StringBuffer sbf = new StringBuffer();
		sbf.append(" where construct_Aparty_purEntry_id = "+id );
		aPartyService.delete_aPartyEntry(sbf.toString());
		json.put("Success", true);
		json.put("msg", "删除成功！");
		} catch (Exception e) {
			json.put("Success", false);
			json.put("msg", "删除失败！");
			e.printStackTrace();
		}
		return json;
	}
	
	/**
	 *  审核界面
	 * @throws Exception 
	 * 
	 * */
	@RequestMapping(value = "/aPartyPurAudit", method = RequestMethod.GET)
	public ModelAndView aPartyPurAudit(String taskid,String taskName) throws Exception {
		ModelAndView mv = new ModelAndView();
		String bizkey = activitiService.getBusinessBizId(taskid);// 获取业务编号

		String[] strs = bizkey.split("\\.");
		String bizId = null; // 业务编号
		for (int i = 0, len = strs.length; i < len; i++) {
			bizId = strs[i].toString();
		}
	
		Map<String, Object> aParty=new HashMap<String, Object>();
		int construct_Aparty_purchase_id=Integer.valueOf(bizId.toString().equals("")?"0":bizId.toString());
		
		    String fields="*";
	        String where="";
	        List<Map<String, Object>> entries=null;
	        StringBuffer sbf=new StringBuffer();
		if(construct_Aparty_purchase_id!=0){
		 
	        where +=" construct_aparty_purchase apa";
			where +=" left join construct_project_table pro";
			where +=" on apa.construct_Aparty_purchase_constructId=pro.construct_project_id";  
			where +="  where apa.construct_Aparty_purchase_id="+construct_Aparty_purchase_id;
			sbf.append(" construct_aparty_purentry entry");
			sbf.append(" left join construct_aparty_material mat");
	        sbf.append(" on entry.construct_Aparty_purEntry_materialId=mat.construct_Aparty_material_id");
	        sbf.append(" where construct_Aparty_purEntry_parentId="+construct_Aparty_purchase_id+"");
	        
	    	aParty=aPartyService.getConstruct(fields,where);
			entries=aPartyService.dataList(fields,sbf.toString());
			//map = aPartyService.constructNew(construct_Aparty_purchase_id);
		}
		
		List<Map<String, Object>> userList = supOpinionService.supOpinionUser(
				taskName, "aPartyPurView"); //查询审核人
		
		List<String> bot = activitiService.findOutComeListByTaskId(taskid);// 查看当前有几条线
		List<Map<String, Object>> historyList = activitiService.getProcessComments(taskid);// 查询审批记录

		
		
		JSONObject jsonObject =new JSONObject();
		jsonObject.put("history", historyList);
		mv.addObject("history", jsonObject);
		mv.addObject("bot", bot);
		mv.addObject("userList", userList);
		
		jsonObject.put("entries",entries);
		mv.addObject("aParty",aParty);
		mv.addObject("entries", jsonObject);
		mv.setViewName("construct/aPartyPurAudit");
		
		mv.addObject("taskid", taskid);
		mv.addObject("taskName", taskName);
		return mv;
		
		
	}
	
	@RequestMapping(value = "/aPartyPurPass", method = RequestMethod.POST)
	@ResponseBody
    public 	Map<String, Object> aPartyPurPass(HttpServletRequest request){
		
	Map<String, Object> json=new HashMap<String, Object>();
        try {
        	
        aPartyService.aPartyPurPass(request);	
        json.put("Success", true);
		json.put("Msg", "已审核!");
	    } catch (Exception e) {
		e.printStackTrace();
		json.put("Success", false);
		json.put("Msg", "程序出错,请联系技术员");
    	}
		return json;

	}
	
	@SuppressWarnings("null")
	@RequestMapping(value = "/aPartyPurPass", method = RequestMethod.GET)
	public void aPartyPurExcel(HttpServletResponse response,String biz) throws IOException {
		    HSSFWorkbook wb = new HSSFWorkbook(); // 定义一个新的工作簿
			HSSFSheet sheet=wb.createSheet("材料单明细");  // 创建第一个Sheet页
	        HSSFCellStyle style = wb.createCellStyle();
		    HSSFFont font = wb.createFont();
		    HSSFRow row = null; // 创建一个行
		    HSSFCell cell=null;//创建列
	        font.setFontHeightInPoints((short) 12);//字号
	        font.setFontName("宋体");
	        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
	        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直
	        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平
	        style.setFont(font);
	         style.setWrapText(true);
	     String fString=" *";
	     StringBuffer sbf=new StringBuffer();
	     sbf.append(" construct_aparty_purchase apa");
	     sbf.append(" left join construct_project_table pro");	 
	     sbf.append(" on apa.construct_Aparty_purchase_constructId=pro.construct_project_id");
	     sbf.append(" where construct_Aparty_purchase_id="+biz);
	    List<Map<String, Object>> aparty= aPartyService.dataList(fString, sbf.toString());
	    HSSFCellStyle style1=null;
         for (int i = 0; i < 6; i++) {
        	   row= sheet.createRow(i); 
        	   row.setHeightInPoints(20);
        	for (int j = 0; j < 10; j++) {
        	  if (i==0) {
        		   cell= row.createCell(j);
           		   cell.setCellValue("时代地产材料订单表");
               	   cell.setCellStyle(style);
               	   sheet.addMergedRegion(new CellRangeAddress(0,0,0,9)); //单元格合并
			  }else if (i==1) {
               
				  if (j==0) {
					 cell= row.createCell(0);
		       		 cell.setCellValue("施工合同： "+aparty.get(0).get("construct_project_name"));  
				  }else if(j==5){
					 cell= row.createCell(5);
		       		 cell.setCellValue("订单号：");
				  }else {
					 cell= row.createCell(j);
		       		
				  }		 
				 
				  style1=style1(wb);  
           	     cell.setCellStyle(style1);
           	     sheet.addMergedRegion(new CellRangeAddress(1,1,0,4)); //单元格合并
                 sheet.addMergedRegion(new CellRangeAddress(1,1,5,9)); //单元格合并
			  }else if (i==2) {
				  if (j==0) {
					  cell= row.createCell(0);
					  cell.setCellValue("收货地址："+aparty.get(0).get("construct_project_addr"));  
				 }else if (j==5){
					 cell= row.createCell(5);
					 cell.setCellValue("供货单位："+aparty.get(0).get("construct_Aparty_purchase_supplier"));  
				
				 }else {
					   cell= row.createCell(j);  
				}
				  sheet.addMergedRegion(new CellRangeAddress(2,2,0,4)); //单元格合并
	              sheet.addMergedRegion(new CellRangeAddress(2,2,5,9)); //单元格合并
			      cell.setCellStyle(style1);
	   		  }else if (i==3) {
	   			  if (j==0) {
					  cell= row.createCell(0);
					  cell.setCellValue("收货人："+aparty.get(0).get("construct_project_leader"));  
				 }else if (j==5){
					 cell= row.createCell(5);
					 cell.setCellValue("联系人："+aparty.get(0).get("construct_Aparty_purchase_contacts"));  
				 }else {
					   cell= row.createCell(j);
				}
				  sheet.addMergedRegion(new CellRangeAddress(3,3,0,4)); //单元格合并
	              sheet.addMergedRegion(new CellRangeAddress(3,3,5,9)); //单元格合并
	              cell.setCellStyle(style1);
              }else if (i==4) {
            	  if (j==0) {
					  cell= row.createCell(0);
					  cell.setCellValue("电话："+aparty.get(0).get("construct_project_leaderTel"));  
					  sheet.addMergedRegion(new CellRangeAddress(4,4,0,1)); //单元格合并
				 }else if (j==2){
					 cell= row.createCell(2);
					 cell.setCellValue("传真号码： ");  
					 sheet.addMergedRegion(new CellRangeAddress(4,4,2,4)); //单元格合并
               }else if (j==5){
	                  cell= row.createCell(5);
	                  cell.setCellValue("联系电话："+aparty.get(0).get("construct_Aparty_purchase_tel"));  
	                  sheet.addMergedRegion(new CellRangeAddress(4,4,5,7)); //单元格合并
	                  sheet.addMergedRegion(new CellRangeAddress(4,4,8,9)); //单元格合并
                 }else {
					   cell= row.createCell(j);	   
				 }
            	
            	  cell.setCellStyle(style1);
			  }else{
				  cell= row.createCell(0);
				  cell.setCellValue("序号"); 
				  cell.setCellStyle(style1);
				  cell= row.createCell(1);
				  cell.setCellValue("材料名称"); 
				  cell.setCellStyle(style1);
				  cell= row.createCell(2);
				  cell.setCellValue("规格、型号"); 
				  cell.setCellStyle(style1);
				  cell= row.createCell(3);
				  cell.setCellValue("单位"); 
				  cell.setCellStyle(style1);
				  cell= row.createCell(4);
				  cell.setCellValue("数量"); 
				  cell.setCellStyle(style1);
				  cell= row.createCell(5);
				  cell.setCellValue("单价(元)"); 
				  cell.setCellStyle(style1);
				  cell= row.createCell(6);
				  cell.setCellValue("金额(元)"); 
				  cell.setCellStyle(style1);
				  cell= row.createCell(7);
				  cell.setCellValue("计划进场时间"); 
				  cell.setCellStyle(style1);
				  cell= row.createCell(8);
				  cell.setCellValue("供货到场时间 "); 
				  cell.setCellStyle(style1);
				  cell= row.createCell(9);
				  cell.setCellValue("备注"); 
				  cell.setCellStyle(style1);
			  }	 
			}	   
		  }
            sheet.setColumnWidth(0, 8 * 256);
			sheet.setColumnWidth(1, 35 * 256);
			sheet.setColumnWidth(2, 15 * 256);
			sheet.setColumnWidth(3, 6 * 256);
			sheet.setColumnWidth(4, 15 * 256);
			sheet.setColumnWidth(5, 15 * 256);
			sheet.setColumnWidth(6, 15 * 256);
			sheet.setColumnWidth(7, 13 * 256);
			sheet.setColumnWidth(8, 15 * 256);
			sheet.setColumnWidth(9, 15 * 256);
			  
         String fields="*";
         String where= " construct_aparty_purentry entry";
         where +=" LEFT JOIN construct_aparty_material mat ON";
         where +=" entry.construct_Aparty_purEntry_materialId = mat.construct_Aparty_material_id";
         where +=" WHERE construct_Aparty_purEntry_parentId ="+biz;  
        List<Map<String, Object>> dataList= aPartyService.dataList(fields, where);
        
       int i=0;
       for (i= 0; i < dataList.size(); i++) {
    	      row= sheet.createRow(6+i);  
    	      cell= row.createCell(0);
			  cell.setCellValue(i+1); 
			  cell.setCellStyle(style1);
			  cell= row.createCell(1);
			  cell.setCellValue(dataList.get(i).get("construct_Aparty_material_name").toString()); 
			  cell.setCellStyle(style1);
			  cell= row.createCell(2);
			  cell.setCellValue(dataList.get(i).get("construct_Aparty_material_model").toString()); 
			  cell.setCellStyle(style1);
			  cell= row.createCell(3);
			  cell.setCellValue(dataList.get(i).get("construct_Aparty_material_unit").toString());  
			  cell.setCellStyle(style1);
			  cell= row.createCell(4);
			  cell.setCellValue(dataList.get(i).get("construct_Aparty_purEntry_num").toString());  
			  cell.setCellStyle(style1);
			  cell= row.createCell(5);
			  // 单价(元)
			  cell.setCellStyle(style1);
			  cell= row.createCell(6);
			 //金额(元)
			  cell.setCellStyle(style1);
			  cell= row.createCell(7);
			  cell.setCellValue(""+aparty.get(0).get("construct_Aparty_purchase_creatTime")); 
			  cell.setCellStyle(style1);
			  cell= row.createCell(8);
			  cell.setCellValue("");//供货到场时间 
			  cell.setCellStyle(style1);
			  cell= row.createCell(9);
			  cell.setCellValue(""); // 备注
			  cell.setCellStyle(style1);
	        }
       //合计
       row= sheet.createRow(6+i);  
       for (int j = 0; j < 10; j++) {
    	   if (j==0) {
    		   cell= row.createCell(0);
 			   cell.setCellValue("合计:"); 
 			   cell.setCellStyle(style1);
 			 sheet.addMergedRegion(new CellRangeAddress(6+i,6+i,0,3)); //单元格合并
		    }else if(j==6){
		    	   cell= row.createCell(j);
		    	   cell.setCellStyle(style1);
		    	   sheet.addMergedRegion(new CellRangeAddress(6+i,6+i,5,6)); //单元格合并
		    	   sheet.addMergedRegion(new CellRangeAddress(6+i,6+i,7,9)); //单元格合并
		    }else {
			  cell= row.createCell(j);
			 
			  cell.setCellStyle(style1);
		 }			
	   }     
       for (int e = 0; e < 4; e++) {
    	  row= sheet.createRow(7+i+e);
		for (int j = 0; j < 10; j++) {
			if (e==0) {
				if (j==0) {
					 cell= row.createCell(j);
		     		 cell.setCellValue("使用单位确认：");
		         	
				}else if (j==4) {
					 cell= row.createCell(j);
		     		 cell.setCellValue("使用单位确认：");        	 
			   }else if (j==7) {
					 cell= row.createCell(j);
		     		 cell.setCellValue("成本管理部审核：");       	
			   }
			}else if (e==1) {		
				if (j==0) {
					 cell= row.createCell(j);
		     		 cell.setCellValue("日期：");         	
				}else if (j==4) {
					 cell= row.createCell(j);
		     		 cell.setCellValue("日期："); 	
			   }else if (j==7) {
					 cell= row.createCell(j);
		     		 cell.setCellValue("日期：");	         	 
			   }
			}else if (e==2) {		
				if (j==0) {
					 cell= row.createCell(j);
		     		 cell.setCellValue("集团招投标部批准： ");
		         	
				}else if (j==4) {
					 cell= row.createCell(j);
		     		 cell.setCellValue("供货单位供货时间确认：");	
			   }		
			}else if (e==3) {		
				if (j==0) {
					 cell= row.createCell(j);
		     		 cell.setCellValue("日期： "); 	
				}else if (j==4) {
					 cell= row.createCell(j);
		     		 cell.setCellValue("日期：");
			   }	
			}
	    	}
     	   }
               HSSFPrintSetup ps = sheet.getPrintSetup();
    			ps.setLandscape(true); // 打印方向，true：横向，false：纵向
    			ps.setPaperSize(HSSFPrintSetup.A4_PAPERSIZE); //纸张
    			sheet.setMargin(HSSFSheet.BottomMargin,( double ) 1 );// 页边距（下）
    			sheet.setMargin(HSSFSheet.LeftMargin,( double ) 1.5);// 页边距（左）
    			sheet.setMargin(HSSFSheet.RightMargin,( double ) 1.5 );// 页边距（右）
    			sheet.setMargin(HSSFSheet.TopMargin,( double ) 1.5 );// 页边距（上）  
	    	String filename = "材料计划采购单.xls";// 设置下载时客户端Excel的名称
			response.setContentType("application/vnd.ms-excel");
			response.setHeader(
					"Content-disposition",
					"attachment;filename="
							+ java.net.URLEncoder.encode(filename, "UTF-8"));
			OutputStream ous = new BufferedOutputStream(
					response.getOutputStream());
			
			wb.write(ous);
			ous.flush();
			ous.close();

		}

	
	 public static HSSFCellStyle  style1(HSSFWorkbook workbook){
	   	  HSSFFont font = workbook.createFont();
	   	   HSSFCellStyle styleList = workbook.createCellStyle();
	           HSSFFont fontList = workbook.createFont();
	           fontList.setFontHeightInPoints((short) 8);//字号
	           fontList.setFontName("宋体");
	     
	           styleList.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直

	           styleList.setFont(font);
	           styleList.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
	           styleList.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
	           styleList.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
	           styleList.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边
	           styleList.setWrapText(true);
				return styleList;
	   }
	
	
	
	
	
}
