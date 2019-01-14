package com.casd.serviceimpl.ownCenter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casd.controller.web.Ref;
import com.casd.dao.ownCenter.OwnWorkDao;
import com.casd.entity.ownCenter.OwnWorkEntry;
import com.casd.entity.ownCenter.OwnWorkHead;
import com.casd.entity.sciAndTec.CheckPro;
import com.casd.entity.uc.User;
import com.casd.service.ownCenter.OwnWorkService;

@Service
public class OwnWorkServiceImpl implements OwnWorkService {
	@Autowired
	private OwnWorkDao ownWorkDao;
	@Override
	public void save_workArrang(OwnWorkHead ownWorkHead, JSONArray myJsonArray,HttpServletRequest request) {
		// TODO Auto-generated method stub
		int head_id=ownWorkHead.getOwn_workArrangHead_id();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("center_id", ownWorkHead.getOwn_workArrangHead_centerId());
		int companyId=ownWorkDao.getCompany(map);
		ownWorkHead.setOwn_workArrangHead_companyId(companyId);
		if (head_id==0) {
			ownWorkDao.save_workArrang(ownWorkHead);
			head_id=ownWorkHead.getOwn_workArrangHead_id();
		}else {
			ownWorkDao.save_workArrang(ownWorkHead);
		}
		
		for (int i = 0; i < myJsonArray.size(); i++) {
			//OwnWorkEntry ownWorkEntry = new OwnWorkEntry();
			JSONObject myjObject = myJsonArray.getJSONObject(i);
			OwnWorkEntry ownWorkEntry = (OwnWorkEntry) JSONObject.toBean(myjObject,  
					OwnWorkEntry.class);
			int own_workArranged_id=0;
			if (!myjObject.get("own_workArranged_id").toString().equals("")) {
				own_workArranged_id=Integer.valueOf(myjObject.get("own_workArranged_id").toString());
			}
			ownWorkEntry.setOwn_workArranged_categoryId(head_id);
			ownWorkEntry.setOwn_workArranged_id(own_workArranged_id);
			Date d = new Date();  
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		    String dateNowStr = sdf.format(d);  
			ownWorkEntry.setOwn_workArranged_creatTime(myjObject.get("own_workArranged_creatTime").toString().equals("")?dateNowStr:myjObject.get("own_workArranged_creatTime").toString());
			User user=(User) request.getSession().getAttribute("loginUser");
			ownWorkEntry.setOwn_workArranged_arranger(Integer.valueOf(myjObject.get("own_workArranged_arranger")==null?""+user.getUserid():myjObject.get("own_workArranged_arranger").toString()));
			ownWorkDao.save_workArrangEntry(ownWorkEntry);
		}
		
	}
	@Override
	public List<Map<String, Object>> ownWorkList(int page, int pageSize,
			Ref<Integer> record, String where) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("where", where);

		if (record != null) {
			int count = ownWorkDao.getOwnWorkCount(param);
			record.setValue(count);
		}
		// 分页
		if (pageSize <= 0)
			throw new Exception("pageSize 必须 > 0");

		param.put("limit", String.format("limit %1$s,%2$s", page < 0 ? 0 : page
				* pageSize, pageSize));

		return ownWorkDao.ownWorkList(param);
		
	}
	
	@Override
	@Transactional
	public Map<String, Object> getOwnWorkById(int own_workArranged_categoryId) {
		// TODO Auto-generated method stub
		Map<String, Object> data=new HashMap<String, Object>();
		Map<String, Object> map=new HashMap<String, Object>();
		StringBuffer sbf = new StringBuffer();
		sbf.append(" own_workArrangHead  where 1=1 and own_workArrangHead_id="
				+ own_workArranged_categoryId + "");
		map.put("fields", " * ");
		map.put("where", sbf.toString());
		OwnWorkHead ownWorkHead= ownWorkDao.getOwnWorkHead(map);
		map.clear();
		map.put("own_workArranged_categoryId", own_workArranged_categoryId);
		List<Map<String, Object>> ownWorkEntry= ownWorkDao.getOwnWorkEntry(map);
		data.put("ownWorkHead", ownWorkHead);
		data.put("ownWorkEntry", ownWorkEntry);
		return data;
		
	}
	
	@Override
	public void update_work(OwnWorkEntry ownWorkEntry) {
		// TODO Auto-generated method stub
		ownWorkDao.update_work(ownWorkEntry);
	}
	@Override
	public void delete_workerEntry(Map<String, Object> map) {
		// TODO Auto-generated method stub
		ownWorkDao.delete_worker(map);
	}
	@Override
	public void delete_workerHead(Map<String, Object> map) {
		// TODO Auto-generated method stub
		String id= map.get("cid").toString();
		StringBuffer sbf = new StringBuffer();
		sbf.append(" own_workArrangHead where own_workArrangHead_id =" + id + "");
		map.put("where", sbf.toString());
		ownWorkDao.delete_worker(map);
		sbf.delete(0, sbf.length());
		sbf.append(" own_workarranged where own_workArranged_categoryId =" + id + "");
		map.put("where", sbf.toString());
		ownWorkDao.delete_worker(map);
		
	}
	@Override
	public Map<String, Object> selectArrCount(HttpServletRequest request) {
		Map<String, Object> data=new HashMap<String, Object>();
		Map<String, Object> map=new HashMap<String, Object>();
		StringBuffer stringBuff = new StringBuffer();
		User loginUser = (User)request.getSession().getAttribute("loginUser");
		stringBuff.append(" and own_workArranged_status=0 and own_workArranged_sponsor = "+ loginUser.getUserid() + " or own_workArranged_coordinator  = "+ loginUser.getUserid() + "  ");
		map.put("what", stringBuff.toString());
		int dealtCount= ownWorkDao.selectArrCount(map);
		data.put("dealtCount", dealtCount);
		
		stringBuff.delete(0, stringBuff.length());
		stringBuff.append(" and own_workArranged_status>0 and own_workArranged_sponsor = '"+ loginUser.getUserid() + "' or own_workArranged_coordinator  = "+ loginUser.getUserid() + " ");
		map.put("what", stringBuff.toString());
		int finishCount= ownWorkDao.selectArrCount(map);
		data.put("finishCount", finishCount);
		
		stringBuff.delete(0, stringBuff.length());
		stringBuff.append(" and own_workArranged_arranger = "+ loginUser.getUserid() + "  ");
		map.put("what", stringBuff.toString());
		int creatCount= ownWorkDao.selectArrCount(map);
		data.put("creatCount", creatCount);
		return data;
	}
	 
}
