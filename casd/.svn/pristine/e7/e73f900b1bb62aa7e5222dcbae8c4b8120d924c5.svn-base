package com.casd.controller.uc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.casd.controller.web.Ref;
import com.casd.controller.web.common.Authorize;
import com.casd.controller.web.common.Authorize.ResultType;
import com.casd.controller.web.common.Authorize.RoleEnum;
import com.casd.controller.web.common.excel.ImportExcel;
import com.casd.entity.uc.User;
import com.casd.service.uc.UserService;

@Controller
@RequestMapping("/admin")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public ModelAndView userList() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("uc/userList");
		return mv;
	}

	/**
	 * 用户列表信息
	 * 
	 * */
	@RequestMapping(value = "/userLists", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> userList(Integer limit,Integer page,HttpServletRequest request) throws Exception {
		String	username=request.getParameter("username");
		Ref<Integer> record = new Ref<Integer>();
		
     	page = page==null ? 1: page;
		       page=page-1;
			StringBuilder sbf = new StringBuilder();// 拼接sql
			StringBuilder fields = new StringBuilder();// 需要显示字段
			fields.append(" *");
			sbf.append(" uc_user where 1=1");
			if(org.apache.commons.lang3.StringUtils.isNotEmpty(username)){
				sbf.append(" and username like '%"+username+"%'");
			}
			List<Map<String, Object>> data = userService.userList(page,
					limit, record, sbf.toString(), fields.toString());
			 JSONArray jsonArray=JSONArray.fromObject(data);
			  Map<String, Object> result = new HashMap<String, Object>();
			    result.put("code", 0);
			    result.put("msg", "");
			    result.put("count", record.getValue());
		   
			    result.put("data", jsonArray);

		return result;

	}

	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		String cid = request.getParameter("cid");
		// 根据用户userid查询用户信息
		if (cid != null) {
			String fields = " username,userid,password";
			StringBuilder sbf = new StringBuilder();
			sbf.append(" `uc_user` where 1=1");
			sbf.append(" and userid=" + cid);
			Map<String, Object> data = userService.queryUserById(fields, sbf.toString());
	     	mv.addAllObjects(data);
		}
		mv.setViewName("uc/editUser");
		return mv;
	}

	/**
	 * 编辑用户
	 * */
	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> editUser(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
   try {
	

		String username = request.getParameter("username");
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
	
	
		if (userid == "") {
			

		} else { // 编辑用户信息

			StringBuilder pars = new StringBuilder();
			pars.append(" admin_id= 521 ,");
			if (username != null) {
				pars.append(" username='" + username + "',");
			}
			if (password != null) {
				pars.append(" password='" + password + "'");
			}
			
			String where = " where userid=" + userid;
			userService.updateUser(pars.toString(), where);
		}
		params.put("Success",true);
		params.put("Msg", "修改成功！");
	} catch (Exception e) {
		
		params.put("Msg", "操作失败！");
		params.put("Success", false);
	}
		return params;

	}

	// 批量删除用户信息
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteUser(HttpServletRequest request)
			throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuffer sbf = new StringBuffer();
		String fields = " uc_user,hr_contract, hr_register,hr_salary,hr_training_record";
		String cid = request.getParameter("cid");
		cid = cid.substring(1);
		String[] ids = cid.split("]");

		sbf.append(" from uc_user LEFT JOIN hr_contract ON uc_user.userid = hr_contract.user_id");
		sbf.append(" LEFT JOIN hr_register ON hr_register.user_id =uc_user.userid");
		sbf.append(" LEFT JOIN hr_salary ON hr_salary.user_id =uc_user.userid");
		sbf.append(" LEFT JOIN hr_training_record ON hr_training_record.user_id =uc_user.userid");
		sbf.append(" where userid in (" + ids[0] + ")");
		userService.deleteUser(fields, sbf.toString());

		return null;

	}

	/**
	 * @author 求职登记表打印
	 * */
	@Authorize(code = "APP_ADMIN_ROOT", type = ResultType.REDIRECT, role = RoleEnum.ADMIN)
	@RequestMapping(value = "/qiuzhibiao", method = RequestMethod.GET)
	public String qiuzhi() {

		return "uc/qiuzhibiao";

	}

	  /*** @author Administrator
	    *  查看通讯录
	    *   
	    * */
	@RequestMapping(value = "/addressList", method = RequestMethod.GET)
	public ModelAndView uploadPdf() {
		ModelAndView mv=new ModelAndView();

		 mv.setViewName("uc/addressList");
		return mv;

		
	}
	
	
   /*** @author Administrator
    *   通讯录上传
    *   
    * */
	
	@RequestMapping(value = "/uploadPdf", method = RequestMethod.POST)
	@ResponseBody
	public Object uploadPdf(MultipartFile pic,HttpServletRequest request) {
		
			Map<String, Object> json = new HashMap<String, Object>();

			try {
				// 获取原始文件名
				String fileName = pic.getOriginalFilename();
				if (StringUtils.isEmpty(fileName)) {
					json.put("Success", false);
					json.put("Msg", "请选择文件");
					return json;
				}

				if (!fileName.substring(fileName.lastIndexOf(".")).equals(".pdf")) {
					json.put("Success", false);
					json.put("Msg", "请选择文件格式为.pdf");
					return json;
				}
		
				File file2 = new File("e:/file/casd/userfile/通讯录");
				if (!file2.exists()) {
					file2.mkdirs();
				}
				fileName="address_list.pdf";
				// 定义文件路径
				String fileUploadBasePath =file2.toString();
				File newFile = new File(fileUploadBasePath +"/"+ fileName);
				pic.transferTo(newFile); // 写入文件到服务器目录
				json.put("Success", true);
				json.put("Msg", "上传成功");
			} catch (Exception e) {
				e.printStackTrace();
				json.put("Success", false);
				json.put("Msg", "上传失败" + e);
			}
			return json;
		}

	
}
