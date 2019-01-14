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
	
	<fieldset id="fd1" style="width:900px;">
		<legend>
			<span>项目信息</span>
		</legend>
		<div class="fieldset-body">
			<form id="head" method="post" >
			<table class="form-table" border="0" cellpadding="5" cellspacing="2">
				<tr>
					<td class="form-label" style="width:60px">付款单号：</td>
					<td style="width:150px"><input
						name="finance_settlepay_id" id="finance_settlepay_id" readonly="readonly"
						class="mini-textbox" value="${head.finance_settlepay_id}" /></td> 
						
					<td class="form-label" style="width:110px;">供应商：</td>
					<td style="width:150px"><input type="text" name="finance_settlepay_supplier"
						id="finance_settlepay_supplier" class="mini-textbox" readonly="readonly"
						value="${head.finance_settlepay_supplier}" /></td>
						
					<td class="form-label" style="width:110px;">项目：</td>
					<td style="width:150px"><input type="text"
						value="${head.construct_project_name}" readonly="readonly"
						name="construct_project_name" id="construct_project_name" class="mini-textbox" /></td>
					<td class="form-label" style="display: none">项目id：</td>
					<td style="display: none"><input type="text"
						value="${head.finance_settlepay_projectid}" readonly="readonly"
						name="finance_settlepay_projectid" id="finance_settlepay_projectid" class="mini-textbox" /></td>
						
					<td class="form-label" style="width:110px;">欠款：</td>
					<td style="width:150px"><input type="text"
						value="${head.finance_settlepay_owe}"
						name="finance_settlepay_owe" id="finance_settlepay_owe" class="mini-textbox" readonly="readonly" /></td>
						
					<td  class="form-label" style="width:110px;display: none">已付：</td>
					<td style="width:150px;display: none"><input type="text"
						value="${head.finance_settlepay_payed}"
						name="finance_settlepay_purNum_payed" id="finance_settlepay_purNum_payed" class="mini-textbox" readonly="readonly" /></td>
				</tr>
				
			</table>
			</form>
		</div>
	</fieldset>
	
	<fieldset id="fd1" style="width:880px;">
		<legend>
			<span>采购单明细：</span>
		</legend>
		<div class="fieldset-body">
		<table id="pur" class="easyui-datagrid" title="采购单"
		style="width:900px;height:450px"
		data-options="
				iconCls: 'icon-edit',
				singleSelect: true,
				toolbar: '#purtb',showFooter:true,
				">
			<thead>
				<tr>
					<th data-options="field:'finance_settlepay_pur_id',width:80,align:'right',hidden:true">id</th>
					<th data-options="field:'finance_settlepay_pur_parentid',width:80,align:'right',hidden:true">付款单号</th>
					
					<th data-options="field:'finance_settlepay_pur_purchaseid',width:80,align:'right'">采购单号</th>
					
					<!-- <th data-options="field:'finance_settlepay_pur_arrivedid',width:80,align:'right'">到货单号</th> -->
					<th
						data-options="field:'finance_settlepay_pur_supplier',width:80,align:'right'">供应商</th>
					<th
						data-options="field:'construct_project_name',width:250,align:'right'">项目名</th>
					<th
						data-options="field:'finance_settlepay_pur_projectid',width:250,align:'right',hidden:true">项目id</th>	
					<th
						data-options="field:'finance_settlepay_pur_shouldpay',width:80,align:'right'">应付</th>
				</tr>
	
			</thead>
		</table>
			
		</div>
	</fieldset>
	
	<div id="purtb" style="height:auto">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="view()">查看</a>
	</div>
	
	
	
	
	<script type="text/javascript">
	
	var editIndex = undefined;
	//合计
	var total=0;
	$(function(){
		
		//数据初始化
		if(${rows}.settlePurs!=undefined||${rows}.settlePays!=undefined){
			var settlePurs = ${rows}.settlePurs; 
			$('#pur').datagrid('loadData',settlePurs);
			var settlePays = ${rows}.settlePays; 
			$('#pay').datagrid('loadData',settlePays);
		}
		
	});
		
		
		
		
		//查看
		function view(){
				var rows = $("#pur").datagrid("getSelections");//获取表格数据
				if (rows.length == 0) {
					alert("请选择需要查看的行");
					return null;
				}else if(rows.length>1){
					alert("一次只能查看一行");
					return null;
				}
				location.href = "purchaseView.do?" + $.param({
					'construct_purchase_id' : rows[0].finance_settlepay_pur_purchaseid, 
				});
				
				//location.href ="arrivePurchaseView.do?construct_purchase_arrived_id="+rows[0].finance_settlepay_pur_purchaseid;
		}
		
		
	</script>
</body>
</html>