<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<td class="form-label" style="width:60px;display: none">编号id：</td>
					<td style="width:150px;display: none"><input name="purChangeTab_id"
						id="purChangeTab_id" class="mini-textbox" value="${purChange.purChangeTab_id}" /></td>
					<td class="form-label" style="width:60px;">项目名称：</td>
					<td style="width:150px"><input type="text" name="purChangeTab_proName"
						id="purChangeTab_proName" class="mini-textbox" value="${construct.construct_project_name}"
						readonly="readonly" /></td>
					<td class="form-label" style="width:60px;">事宜：</td>
					<td style="width:150px"><input type="text"
						value="${purChange.purChangeTab_matter}" name="purChangeTab_matter"
						 id="purChangeTab_matter" class="mini-textbox" /></td>
					<td class="form-label" style="width:60px;">申请部门：</td>
					<td style="width:150px"><input type="text"
						value="${purChange.purChangeTab_dep}" name="purChangeTab_dep"
						 id="purChangeTab_dep" class="mini-textbox" /></td>
				</tr>
				<tr>	
					<td class="form-label" style="width:60px;">原因：</td>
					<td style="width:150px"><input type="text"
						value="${purChange.purChangeTab_reason}" name="purChangeTab_reason"
						 id="purChangeTab_reason" class="mini-textbox" /></td>
					<td  class="form-label" style="width:60px;display: none">项目id：</td>
					<td style="width:150px;display: none"><input type="text" 
						value="${construct.construct_project_id}" name="purChangeTab_proId"
						 id="purChangeTab_proId" class="mini-textbox" /></td>			
				</tr>

			</table>
		</div>
	</fieldset>

	<fieldset id="fd1" style="width:880px;">
		<legend>
			<span>变更项</span>
		</legend>
	<div style="margin:20px 0;"></div>

	<table id="Purchange" class="easyui-datagrid" title="流程节点"
		style="width:880px;height:auto"
		data-options="
				iconCls: 'icon-edit',
				singleSelect: true,
				toolbar: '#tb'
				">

		<thead>
			<tr>
				<th data-options="field:'purChangeEntryTab_id',width:80,hidden:true" >分录id</th>
				<th data-options="field:'purChangeEntryTab_material',width:80,align:'right',editor:'text'">材料名</th>
				<th data-options="field:'purChangeEntryTab_model',width:80,align:'right',editor:'text'">规格</th>
				<th data-options="field:'purChangeEntryTab_quarityNum',width:80,align:'right',editor:'text'">合同工程量</th>
				<th data-options="field:'purChangeEntryTab_applyNum',width:80,align:'right',editor:'text'">申请增加工作量</th>
				<th data-options="field:'purChangeEntryTab_price',width:80,align:'right',editor:'text'">单价</th>
				<th data-options="field:'purChangeEntryTab_unit',width:80,align:'right',editor:'text'">单位</th>
				<th data-options="field:'purChangeEntryTab_total',width:80,align:'right',editor:'text'">金额</th>
				<th data-options="field:'purChangeEntryTab_remarks',width:80,align:'right',editor:'text'">备注</th>
			</tr>
		</thead>


	</table>
</fieldset>
	
	<script type="text/javascript">
		var projectId=${projectId};
		
		$(function() {
			if (${rows}.rows != undefined) {
				var rows = ${rows}.rows;
				$('#Purchange').datagrid('loadData', rows);
			}
		});
		
		

		
	</script>
</body>
</html>