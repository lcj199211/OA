package com.casd.controller.sciAndTec;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
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
import org.springframework.web.servlet.ModelAndView;

import com.casd.controller.web.Ref;
import com.casd.entity.sciAndTec.CheckPro;
import com.casd.entity.sciAndTec.CheckRecordEntry;
import com.casd.entity.sciAndTec.CheckRecordHead;
import com.casd.service.construct.ConstructService;
import com.casd.service.sciAndTec.MaintService;
import com.casd.service.uc.UserService;

@Controller
@RequestMapping("/admin")
public class MaintController {

	@Autowired
	private ConstructService constructService;
	@Autowired
	private MaintService maintService;

	@Autowired
	private UserService userService;

	/**
	 * 保养项目list
	 */
	@RequestMapping(value = "/sciAndTecList", method = RequestMethod.GET)
	public ModelAndView sciAndTecList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		int projectDep = Integer.valueOf(request
				.getParameter("constuct_project_dep_id"));
		mv.addObject("projectDep", projectDep);
		mv.setViewName("sciAndTec/sciAndTecConList");
		return mv;
	}

	@RequestMapping(value = "/sciAndTecList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> sciAndTecList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Ref<Integer> record = new Ref<Integer>();
		Map<String, Object> json = new HashMap<String, Object>();
		StringBuffer sbf = new StringBuffer();
		int projectDep = Integer.valueOf(request
				.getParameter("constuct_project_dep_id"));

		sbf.append("  construct_project_table project left join manage_contract contract on project.construct_project_contractId=contract.manage_contract_id where 1=1 and construct_project_dep="
				+ projectDep + "");

		String construct_project_name = request
				.getParameter("construct_project_name");
		if (StringUtils.hasText(construct_project_name)) {
			sbf.append(" and project.construct_project_name like '%"
					+ construct_project_name + "%'");
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
	 * 检查内容list
	 */
	@RequestMapping(value = "/maintainCheckConList", method = RequestMethod.GET)
	public ModelAndView maintainCheckConList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sciAndTec/maintainCheckConList");
		return mv;
	}

	@RequestMapping(value = "/maintainCheckConList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> maintainCheckConList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Ref<Integer> record = new Ref<Integer>();
		Map<String, Object> json = new HashMap<String, Object>();
		StringBuffer sbf = new StringBuffer();

		sbf.append("  maintain_checkPro checkPro inner join maintain_checkContent checkContent on "
				+ " checkContent.maintain_checkContent_parentId=checkPro.maintain_checkPro_id where 1=1 ");

		String maintain_checkPro_name = request
				.getParameter("maintain_checkPro_name");
		if (StringUtils.hasText(maintain_checkPro_name)) {
			sbf.append(" and maintain_checkPro_name like '%"
					+ maintain_checkPro_name + "%'");
		}
		sbf.append(" order BY maintain_checkPro_name ");
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int pageIndex = Integer.parseInt(request.getParameter("page")) - 1;

		List<Map<String, Object>> data = constructService.constructList(
				pageIndex, pageSize, record, sbf.toString());

		json.put("rows", data);
		json.put("total", record.getValue());
		return json;

	}

	/**
	 * 检查内容增改
	 */
	@RequestMapping(value = "/maintainCheckContent", method = RequestMethod.GET)
	public ModelAndView maintainCheckContent(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		JSONObject dataObject = new JSONObject();
		CheckPro checkPro = new CheckPro();
		String type = "'new'";
		if (StringUtils.hasText(request.getParameter("maintain_checkPro_id"))) {
			type = "'update'";
			Map<String, Object> paramMap = new HashMap<String, Object>();
			int maintain_checkPro_id = Integer.valueOf(request.getParameter(
					"maintain_checkPro_id").toString());
			StringBuffer sbf = new StringBuffer();
			sbf.append(" maintain_checkPro  where 1=1 and maintain_checkPro_id="
					+ maintain_checkPro_id + "");
			String fields = " * ";
			paramMap.put("where", sbf.toString());
			paramMap.put("fields", fields);
			Map<String, Object> data = maintService
					.getCheckContentById(paramMap);
			checkPro = (CheckPro) data.get("checkPro");
			List<Map<String, Object>> entry = (List<Map<String, Object>>) data
					.get("checkConList");
			dataObject.put("checkPro", checkPro);
			dataObject.put("entry", entry);

		} else {
			checkPro.setMaintain_checkPro_id(0);
			dataObject.put("checkPro", checkPro);

		}
		mv.addObject("data", dataObject);
		mv.addObject("type", type);
		mv.setViewName("sciAndTec/maintainCheckContent");
		return mv;
	}

	@RequestMapping(value = "/saveCheckCon", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveCheckCon(HttpServletRequest request,
			CheckPro checkPro) throws Exception {

		JSONArray myJsonArray = JSONArray.fromObject(request
				.getParameter("rows"));
		maintService.saveCheckCon(checkPro, myJsonArray);
		return null;
	}

	/**
	 * 删除分录
	 */
	@RequestMapping(value = "/delete_checkCon", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete_checkCon(HttpServletRequest request)
			throws Exception {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			String cid = request.getParameter("cid");
			StringBuffer sbf = new StringBuffer();
			Map<String, Object> map = new HashMap<String, Object>();
			sbf.append(" maintain_checkContent where maintain_checkContent_id ="
					+ cid + "");
			map.put("where", sbf.toString());
			maintService.delete_checkCon(map);
			json.put("msg", "删除成功！");
		} catch (Exception e) {
			json.put("msg", "删除失败！");
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * 删除系统
	 */
	@RequestMapping(value = "/dele_checkPro", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> dele_checkPro(HttpServletRequest request)
			throws Exception {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			String cid = request.getParameter("ids");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("cid", cid);
			maintService.dele_checkPro(map);
			json.put("msg", "删除成功！");
		} catch (Exception e) {
			json.put("msg", "删除失败！");
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * 检查内容月份
	 */
	@RequestMapping(value = "/maintainCheckRecordList", method = RequestMethod.GET)
	public ModelAndView maintainCheckRecordList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("maintain_checkRecord_head_id", 0);
		mv.addObject("maintain_checkRecord_head_proId",
				request.getParameter("construct_project_id").toString());
		mv.addObject("maintain_checkRecord_head_contractId", request
				.getParameter("manage_contract_id").toString());
		mv.setViewName("sciAndTec/maintainCheckRecordList");
		return mv;
	}

	@RequestMapping(value = "/maintainCheckRecordList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> maintainCheckRecordList(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Ref<Integer> record = new Ref<Integer>();
		Map<String, Object> json = new HashMap<String, Object>();
		StringBuffer sbf = new StringBuffer();
		String construct_project_id = request
				.getParameter("construct_project_id");

		sbf.append("  maintain_checkRecord_head head left join manage_contract contract on "
				+ " head.maintain_checkRecord_head_contractId=contract.manage_contract_id where 1=1 and head.maintain_checkRecord_head_proId="
				+ construct_project_id + " ");

		String maintain_checkRecord_head_date = request
				.getParameter("maintain_checkRecord_head_date");
		if (StringUtils.hasText(maintain_checkRecord_head_date)) {
			sbf.append(" and head.maintain_checkRecord_head_date like '%"
					+ maintain_checkRecord_head_date + "%'");
		}
		sbf.append(" order BY maintain_checkRecord_head_date DESC");
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int pageIndex = Integer.parseInt(request.getParameter("page")) - 1;

		List<Map<String, Object>> data = constructService.constructList(
				pageIndex, pageSize, record, sbf.toString());

		json.put("rows", data);
		json.put("total", record.getValue());
		return json;

	}

	/**
	 * 检查详细
	 */
	@RequestMapping(value = "/maintainCheckRecord", method = RequestMethod.GET)
	public ModelAndView maintainCheckRecord(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("sciAndTec/maintainCheckRecord");
		return mv;
	}

	@RequestMapping(value = "/maintainCheckRecord", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> maintainCheckRecord(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Ref<Integer> record = new Ref<Integer>();
		Map<String, Object> json = new HashMap<String, Object>();
		StringBuffer sbf = new StringBuffer();
		String maintain_checkRecord_head_id = request
				.getParameter("maintain_checkRecord_head_id");

		sbf.append(" maintain_checkRecord_entry  where 1=1 and maintain_checkRecord_entry_parentId="
				+ maintain_checkRecord_head_id);

		String maintain_checkPro_name = request
				.getParameter("maintain_checkPro_name");
		if (StringUtils.hasText(maintain_checkPro_name)) {
			sbf.append(" and maintain_checkPro_name like '%"
					+ maintain_checkPro_name + "%'");
		}
		sbf.append(" order BY maintain_checkRecord_entry_system ");
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int pageIndex = Integer.parseInt(request.getParameter("page")) - 1;

		List<Map<String, Object>> data = constructService.constructList(
				pageIndex, pageSize, record, sbf.toString());

		json.put("rows", data);
		json.put("total", record.getValue());
		return json;

	}

	/**
	 * 添加检查记录
	 */
	@RequestMapping(value = "/update_record", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update_record(CheckRecordEntry checkRecordEntry) {

		Map<String, Object> json = new HashMap<String, Object>();
		try {
			maintService.update_record(checkRecordEntry);
			json.put("Success", true);
			json.put("Msg", "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			json.put("Success", false);
			json.put("Msg", "修改失败");
		}
		return json;
	}

	/**
	 * 添加检查记录
	 */
	@RequestMapping(value = "/add_record", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add_record(CheckRecordHead checkRecordHead) {

		Map<String, Object> json = new HashMap<String, Object>();
		try {
			maintService.add_record(checkRecordHead);
			json.put("Success", true);
			json.put("Msg", "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			json.put("Success", false);
			json.put("Msg", "添加失败");
		}
		return json;
	}

	/**
	 * 删除检查记录
	 */
	@RequestMapping(value = "/dele_checkRecord", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> dele_checkRecord(HttpServletRequest request) {

		Map<String, Object> json = new HashMap<String, Object>();
		try {
			String id = request.getParameter("ids");
			maintService.dele_checkRecord(id);
			json.put("Success", true);
			json.put("Msg", "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			json.put("Success", false);
			json.put("Msg", "删除失败");
		}
		return json;
	}

	@RequestMapping(value = "/sciAndTecPrint", method = RequestMethod.GET)
	public void sciAndTecPrint(HttpServletResponse response, String bizId)
			throws Exception {
		OutputStream ous = null;
		try {

			String fields = " maintain_checkRecord_entry_system,maintain_checkRecord_entry_content,";
			fields += "maintain_checkRecord_entry_status,maintain_checkRecord_entry_describe,";
			fields += "maintain_checkRecord_entry_handle,maintain_checkRecord_entry_reasonNoHandle";
			StringBuffer sbf = new StringBuffer();
			sbf.append(" maintain_checkRecord_entry  where 1=1 and maintain_checkRecord_entry_parentId="
					+ bizId);
			sbf.append(" order BY maintain_checkRecord_entry_system");

			List<CheckRecordEntry> dataList = maintService.getEntryList(fields,
					sbf.toString());

			String[] title = { "系统", "明细", "运行状态", "故障描述", "处理记录", "未处理原因" };
			// 创建excel工作簿
			HSSFWorkbook workbook = new HSSFWorkbook();
			// 创建工作表sheet
			HSSFSheet sheet = workbook.createSheet();
			HSSFCellStyle style = workbook.createCellStyle();// 得到单元格样式
			HSSFFont font = workbook.createFont();
			font.setFontHeightInPoints((short) 12);// 字号
			font.setFontName("宋体");
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 粗体显示
			style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
			style.setFont(font);
			style.setWrapText(true);

			// 创建第一行
			HSSFRow row = sheet.createRow(0);
			HSSFCell cell = row.createCell(0);
			cell.setCellValue("建筑消防设施维修保养记录");
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));
			cell.setCellStyle(style);
			sheet.setColumnWidth(0, 256 * 15);
			sheet.setColumnWidth(1, 256 * 45);
			sheet.setColumnWidth(2, 256 * 6);
			sheet.setColumnWidth(3, 256 * 45);
			sheet.setColumnWidth(4, 256 * 15);
			sheet.setColumnWidth(5, 256 * 15);
			row.setHeight((short) (20 * 40));

			// 插入第一行数据的表头
			HSSFCellStyle style1 = workbook.createCellStyle();// 设置第二行样式
			HSSFFont font1 = workbook.createFont();
			HSSFRow row2 = sheet.createRow(1);
			row.setHeight((short) (20 * 40));
			for (int i = 0; i < title.length; i++) {
				cell = row2.createCell(i);
				font1.setFontHeightInPoints((short) 10);// 字号
				cell.setCellValue(title[i]);
				style1.setFont(font1);
				cell.setCellStyle(style1);
				style1.setWrapText(true);
			}

			int i = 2;
			int num = 0;// 当行单元格
			int startRow = 2;
			int endRow = 2;

			for (CheckRecordEntry entry : dataList) {

				String status = (entry.getMaintain_checkRecord_entry_status() == 1) ? "正常"
						: "不正常";
				String entry_handle = entry
						.getMaintain_checkRecord_entry_handle() + "";

				String reasonNoHandle = entry
						.getMaintain_checkRecord_entry_reasonNoHandle() + "";

				if (entry_handle.equals("1")) {
					entry_handle = null;
				} else if (entry_handle.equals("2")) {
					entry_handle = "无配件设备";
				} else if (entry_handle.equals("3")) {
					entry_handle = "其他原因";
				} else {
					entry_handle = null;
				}
				if (reasonNoHandle.equals("1")) {
					reasonNoHandle = "";
				} else if (reasonNoHandle.equals("2")) {
					reasonNoHandle = "无配件设备";
				} else if (reasonNoHandle.equals("3")) {
					reasonNoHandle = "其他原因";
				} else {
					reasonNoHandle = "";
				}

				HSSFRow row3 = sheet.createRow(i);
				HSSFCell cell3 = row3.createCell(0);

				cell3.setCellValue(entry.getMaintain_checkRecord_entry_system());
				String ites1 = entry.getMaintain_checkRecord_entry_system();

				if (num > 0) {

					String ites2 = dataList.get(num - 1)
							.getMaintain_checkRecord_entry_system();
					if (ites2.equals(ites1) && num != dataList.size() - 1) {
						endRow++;
					} else {
						if (num == dataList.size() - 1) {
							endRow++;
						}
						sheet.addMergedRegion(new CellRangeAddress(startRow,
								endRow, 0, 0));
						startRow = endRow + 1;
						endRow++;
					}

				}

				row3.setHeight((short) (15 * 40));
				style1.setFont(font1);
				cell3.setCellStyle(style1);
				cell3 = row3.createCell(1);
				cell3.setCellValue(entry
						.getMaintain_checkRecord_entry_content());
				style1.setFont(font1);
				cell3.setCellStyle(style1);
				cell3 = row3.createCell(2);
				cell3.setCellValue(status);
				style1.setFont(font1);
				cell3.setCellStyle(style1);
				cell3 = row3.createCell(3);
				cell3.setCellValue(entry
						.getMaintain_checkRecord_entry_describe());
				style1.setFont(font1);
				cell3.setCellStyle(style1);
				cell3 = row3.createCell(4);
				cell3.setCellValue(entry_handle);
				style1.setFont(font1);
				cell3.setCellStyle(style1);
				cell3 = row3.createCell(5);
				cell3.setCellValue(reasonNoHandle);
				style1.setFont(font1);
				cell3.setCellStyle(style1);
				i++;
				num++;
			}

			style1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
			style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
			style1.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框
			style1.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
			style1.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框
			style1.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框

			HSSFPrintSetup ps = sheet.getPrintSetup();
			ps.setLandscape(true); // 打印方向，true：横向，false：纵向
			ps.setPaperSize(HSSFPrintSetup.A4_PAPERSIZE); // 纸张
			sheet.setMargin(HSSFSheet.BottomMargin, (double) 0.5);// 页边距（下）
			sheet.setMargin(HSSFSheet.LeftMargin, (double) 0.0);// 页边距（左）
			sheet.setMargin(HSSFSheet.RightMargin, (double) 0.0);// 页边距（右）
			sheet.setMargin(HSSFSheet.TopMargin, (double) 0.5);// 页边距（上）
			ps.setScale((short) 90);// 自定义缩放①，此处100为无缩放
			sheet.setHorizontallyCenter(true);// 设置打印页面为水平居中

			String filename = System.currentTimeMillis() + ".xls";// 设置下载时客户端Excel的名称
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-disposition", "attachment;filename="
					+ java.net.URLEncoder.encode(filename, "UTF-8"));

			ous = new BufferedOutputStream(response.getOutputStream());

			workbook.write(ous);
			ous.flush();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			if (ous != null) {
				ous.close();
			}
		}
	}

}
