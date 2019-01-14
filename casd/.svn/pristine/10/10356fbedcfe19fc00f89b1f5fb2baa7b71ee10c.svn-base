<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>首页</title>
<jsp:include page="../common/css.jsp"></jsp:include>
<jsp:include page="../common/scripts.jsp"></jsp:include>

<script
	src="<%=request.getContextPath()%>/res/admin/scripts/admin_grid.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/res/admin/scripts/ueditor/third-party/codemirror/codemirror.js"
	type="text/javascript"></script>

<style type="text/css">
fieldset {
	border: solid 1px #aaa;
}

.hideFieldset {
	border-left: 0;
	border-right: 0;
	border-bottom: 0;
}

.hideFieldset .fieldset-body {
	display: none;
}
</style>
</head>
<body>
	<fieldset id="fd1" style="width:880px;">
		<legend>
			<span>基本信息</span>
		</legend>
		
		<div class="fieldset-body">
			<table class="form-table" border="0" cellpadding="1" cellspacing="2">
				<tr>
					<td class="form-label" style="width:60px;display: none">列表id：</td>
					<td style="width:150px;display: none"><input
						name="gad_paylist_id" id="gad_paylist_id" class="mini-textbox"
						value="${PayList.gad_paylist_id}" /></td>
					<td class="form-label" style="display: none">中心id：</td>
					<td style="display: none"><input type="text" name="gad_paylist_centerid"
						id="gad_paylist_centerid" class="mini-textbox" value="${PayList.gad_paylist_centerid}" /></td>
					<td class="form-label" style="width:60px;"><a
						href="javascript:void(0)" >中心(选择):</a>
					</td>
					<td data-options="region:'north',title:'North Title',split:true"
						style="height:50px;"><input type="text" name="center_name"
						id="center_name" readonly="readonly" value="${PayList.center_name}" />
					</td>
					<!-- 父页面的文本框 -->

					<td class="form-label" style="width:60px;">月份：</td>
					<td style="width:150px"><input type="text"
						value="${PayList.gad_paylist_month}" name="gad_paylist_month"
						id="gad_paylist_month" class="mini-textbox" /></td>
					<td class="form-label" style="width:60px;">备注：</td>
					<td style="width:150px"><input type="text"
						value="${PayList.gad_paylist_remarks}" name="gad_paylist_remarks"
						id="gad_paylist_remarks" class="mini-textbox" /></td>	
					
				</tr>
				<tr>
					<td class="form-label" style="width:60px;">实发工资：</td>
					<td style="width:150px"><input type="text"
						value="${PayList.gad_paylist_payroll}" name="gad_paylist_payroll"
						id="gad_paylist_payroll" class="mini-textbox" /></td>
					<td class="form-label" style="width:60px;">人数：</td>
					<td style="width:150px"><input type="text"
						value="${PayList.gad_paylist_men_num}" name="gad_paylist_men_num"
						id="gad_paylist_men_num" class="mini-textbox" /></td>
					
				</tr>

			</table>
		</div>
	</fieldset>
<div class="controls">
								<a class="easyui-linkbutton"
									data-options="iconCls:'icon-search'" href="javascript:;"
									id="btnSearch">查询</a>
								<a class="easyui-linkbutton"
									data-options="iconCls:'icon-page_excel'" id="btnExcel">导出Excel</a>		
							</div>
	<div id="centers" class="easyui-window"
		data-options="region:'center',title:'请选择值'" closed="true"
		style="height: 500px; width: 800px"></div>

	<div style="margin:20px 0;"></div>

	<table id="payroll" class="easyui-datagrid" title="工资明细"
		style="width:1650px;height:auto"
		data-options="
				iconCls: 'icon-edit',
				singleSelect: true,
				toolbar: '#tb',
				multiSort:true,pagination:true,
				
				">

		<thead>
			<tr class="baidu">
			
				<th
					data-options="field:'finance_paylist_id',width:80,align:'right',hidden:true,editor:{type:'text',options:{required:true}} ">单头id</th>
				<th
					data-options="field:'wages_id',width:80,align:'right',hidden:true,editor:{type:'text',options:{required:true}} ">id</th>
				<th
					data-options="field:'user_name',width:80,align:'right'">员工姓名</th>
				<th
					data-options="field:'role_name',width:80,align:'right'">职位</th>
				<th
					data-options="field:'attendances',width:80,align:'right',editor:{type:'text',options:{required:true}}">出勤数</th>
				<th
					data-options="field:'vacation',width:80,align:'right',editor:{type:'text',options:{required:true}}">休假天数</th>
				<th
					data-options="field:'go_out',width:80,align:'right',editor:{type:'text',options:{required:true}}">外出</th>
				<th
					data-options="field:'leave_day',width:80,align:'right',editor:{type:'text',options:{required:true}}">请假天数</th>
				<th
					data-options="field:'base_pay',width:80,align:'right',editor:{type:'text',options:{required:true}}">基本工资</th>
				<th
					data-options="field:'years_wages',width:80,align:'right',editor:{type:'text',options:{required:true}}">工龄工资</th>
				<th
					data-options="field:'post_wage',width:80,align:'right',editor:{type:'text',options:{required:true}}">岗位工资</th>
				<th
					data-options="field:'technical_wages',width:80,align:'right',editor:{type:'text',options:{required:true}}">技术工资</th>
				<th
					data-options="field:'total_wages',width:80,align:'right',editor:{type:'text',options:{required:true}}">合计工资</th>
				<th
					data-options="field:'meal_supplement',width:80,align:'right',editor:{type:'text',options:{required:true}}">餐补</th>
				<th
					data-options="field:'phone_subsidy',width:80,align:'right',editor:{type:'text',options:{required:true}}">电话补贴</th>
				<th 
					data-options="field:'deduction',width:80,align:'right',editor:{type:'text',options:{required:true}}">扣发事假工资</th>
				<th
					data-options="field:'should_wages',width:80,align:'right',editor:{type:'text',options:{required:true}}">应发工资</th>
				<th
					data-options="field:'social_security',width:80,align:'right',editor:{type:'text',options:{required:true}}">社保</th>
				<th
					data-options="field:'any_other',width:80,align:'right',editor:{type:'text',options:{required:true}}">其它借支</th>
				<th
					data-options="field:'payroll',width:80,align:'right',editor:{type:'text',options:{required:true}}">实发工资</th>
				<th
					data-options="field:'remarks',width:80,align:'right',editor:{type:'text',options:{required:true}}">备注</th>
			</tr>
		</thead>


	</table>


<div  id="win" class="easyui-window" data-options="region:'center',title:'请选择值'" closed="true" style="height: 500px; width: 800px" >    
				</div>


	<script type="text/javascript">
		var editIndex = undefined;
		$(function() {

			if(${rows}.rows!=undefined){
			var rows = ${rows}.rows; 
			$('#payroll').datagrid('loadData',rows);
			}
			$("#payroll").admin_grid({
				
				excelBtn : "#btnExcel",
				
			});
		});

		
	</script>
</body>
</html>