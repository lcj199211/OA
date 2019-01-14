package com.casd.serviceimpl.manage;

import java.io.File;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Case;
import org.apache.jasper.tagplugins.jstl.core.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.casd.controller.web.Ref;
import com.casd.dao.manage.SupplierformDao;
import com.casd.entity.hr.Hregister;
import com.casd.entity.manage.Supplierform;
import com.casd.service.manage.SupplierformService;

@Service
public class SupplierformServiceImpl implements SupplierformService {
	@Autowired
	private SupplierformDao supplierformDao;

	@Override
	@Transactional
	public List<Map<String, Object>> supplierformList(int page, int pageSize,
			Ref<Integer> record, String fields, String where) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("fields", fields);
		param.put("where", where);

		if (record != null) {
			Integer count = supplierformDao.getCount(param);
			record.setValue(count);
		}
		// 分页
		if (pageSize <= 0)
			throw new Exception("pageSize 必须 > 0");
		param.put("limit", String.format("limit %1$s,%2$s", page < 0 ? 0 : page
				* pageSize, pageSize));

		return supplierformDao.getList(param);
		
	}

	@Transactional
	public void saveSupplierform(Supplierform supplierform) {
		supplierformDao.saveSupplierform(supplierform);
	}


	@Override
	@Transactional
	public Map<String, Object> getData(String supplierform_id) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<String, Object>();
		String fieds ="*";
		StringBuffer sBuffer=new StringBuffer();
		sBuffer.append(" manage_supplierform  where supplierform_id="+supplierform_id+" ");
		map.put("fields", fieds);
		map.put("where", sBuffer);
		return supplierformDao.getSupplierform(map);
	}

	@Override
	@Transactional
	public void delete_Supplierform(String supplierform_id) {
		Map<String, Object> map=new HashMap<String, Object>();
		StringBuffer sBuffer=new StringBuffer();
		sBuffer.append(" manage_supplierform where supplierform_id = "+supplierform_id);
		map.put("what",sBuffer.toString()); 
		supplierformDao.delete_Supplierform(map);
		
	}
	@Override
	@Transactional
	public Map<String, Object> uploadFile(MultipartFile file,HttpServletRequest request) {
  
		Map<String, Object> json = new HashMap<String, Object>();
		String bizId=request.getParameter("bizId");
		 try {
	            // 获取原始文件名  
	            String fileName = file.getOriginalFilename();  
		
				if(StringUtils.isEmpty(fileName)){
					json.put("Success", false);
					json.put("Msg", "请选择要导的文件");
					return json;
				}
							       
	        	File file2=new File("e:/uploadFile/photo");	
	            if(!file2.exists()) {  
	            	file2.mkdirs();  
	            }  
	            //定义文件路径
	            String fileUploadBasePath = "e:/uploadFile/photo/";
	            String timeStr = System.currentTimeMillis() + fileName;
	            String newFilePath = fileUploadBasePath + timeStr;
	            File newFile = new File(newFilePath);
	            file.transferTo(newFile);  // 写入文件到服务器目录
	            System.out.println(timeStr);
	            Map<String, Object> uploadVar=new HashMap<String, Object>();
	            uploadVar.put("filds", timeStr);
	            uploadVar.put("billID", bizId);
	            supplierformDao.updatefile(uploadVar);

			json.put("Success", true);
			json.put("Msg", "上传成功,可点击查看文件是否正确");
	     }catch (Exception e) {
	    	 e.printStackTrace();
		    json.put("Success", false);
			json.put("Msg", "上传失败"+e);
		}
	    return json;

	
	}

	@Override
	public void add_Supplierform(String supplierform_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Map<String, Object>> add_supplierformList(int pageIndex,
			int pageSize, Ref<Integer> record, String fields, String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> getData(Map<String, Object> map) {
		Map<String, Object> daoMap=new HashMap<String, Object>();
		daoMap.put("fields", "*");
		daoMap.put("where", " manage_supplierform where supplierform_id="+map.get("supplierform_id")+"");
		return supplierformDao.getData(daoMap);
	}

	@Override
	public List<Map<String, Object>> getCenter(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return supplierformDao.getData(map);
	}

	
	


	



	
	
}
