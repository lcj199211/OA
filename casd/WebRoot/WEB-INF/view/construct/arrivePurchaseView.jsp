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


	<fieldset id="fd1" style="width:930px;">
		<legend>
			<span>数据信息</span>
		</legend>
		<div class="fieldset-body">
		<form id="arrive" method="post" >
			<table class="form-table" border="0" cellpadding="5" cellspacing="2">
				<tr>
					<td class="form-label" style="display: none">采购单id：</td>
					<td style="display: none"><input name="construct_purchase_arrived_parentId"
						id="construct_purchase_arrived_parentId" class="mini-textbox"  readonly="readonly"
						value="${head.construct_purchase_arrived_parentId}" /></td>
						
					<td class="form-label" style="width:110px">单据编号：</td>
					<td style="width:150px"><input name="construct_purchase_arrived_id"
						id="construct_purchase_arrived_id" class="mini-textbox"  readonly="readonly"
						value="${head.construct_purchase_arrived_id}" /></td>
							
					<td class="form-label" style="width:110px">到货日期：</td>
					<td style="width:150px"><input
						name="construct_purchase_arrived_data"  readonly="readonly"
						id="construct_purchase_arrived_data" class="easyui-datebox"
						value="${head.construct_purchase_arrived_data}" /></td>
						
					<td class="form-label" style="width:110px">总金额：</td>
					<td style="width:150px"><input name="construct_purchase_arrived_money"
						id="construct_purchase_arrived_money" class="mini-textbox"  readonly="readonly"
						value="${head.construct_purchase_arrived_money}" /></td>
					<!-- <td >
						<a class="easyui-linkbutton" href="javascript:;"data-options="iconCls:'icon-sum',plain:true"  onclick="summary()">汇总</a>
					</td>		 -->
				</tr>

			</table>
			</form>
		</div>
	</fieldset>


	<div style="margin:20px 0;"></div>
	<table id="materialListID" class="easyui-datagrid" title="材料清单"
		style="width:1500px;height:800px"
		data-options="
				iconCls: 'icon-edit',
				singleSelect: true,
				toolbar: '#tb',
				showFooter: true
				">
		<thead>
		<thead>
			<tr>
				<th
					data-options="field:'construct_purchase_arrived_entry_id',width:80,hidden:'hidden',editor:'text'">分录id</th>
				<th
					data-options="field:'construct_purchase_arrived_entry_parentId',width:80,hidden:'hidden',editor:'text'">单头id</th>	
				<th
					data-options="field:'construct_purchase_arrived_entry_chassId',width:80,hidden:'hidden',editor:'text'">分录父id</th>	
				<th
					data-options="field:'construct_purchase_entryParentId',width:80,hidden:'hidden',editor:'text'">采购单材料id</th>	
				<th
					data-options="field:'construct_purchase_material',width:80,align:'right'">材料名称</th>
				<th
					data-options="field:'construct_purchase_model',width:80,align:'right'">型号规格</th>
				<th
					data-options="field:'construct_purchase_unit',width:80,align:'right'">单位</th>
				<th
					data-options="field:'construct_purchase_quantities',width:80,align:'right'">合同工程量</th>
				<th
					data-options="field:'construct_purchase_approvalNum',width:80,align:'right'">累计审批量</th>
				<th
					data-options="field:'construct_purchase_applyNum',width:80,align:'right'">计划采购量</th>
				<th
					data-options="field:'construct_purchase_contractPrice',width:80,align:'right'">合同单价</th>
				<th
					data-options="field:'construct_purchase_purchasePrice',width:80,align:'right'">采购单价</th>
				<th
					data-options="field:'construct_purchase_purchaseTotal',width:80,align:'right'">采购小计</th>
				<th
					data-options="field:'construct_purchase_brand',width:80,align:'right'">材料品牌</th>
				<th
					data-options="field:'construct_purchase_arriveNum',width:80,align:'right'">已到货量</th>
				<th
					data-options="field:'construct_purchase_noArrive',width:80,align:'right'">未到货量</th>
				<th
					data-options="field:'construct_purchase_arrived_entry_num',width:80,align:'right'">此次到货量</th>
				<th
					data-options="field:'construct_purchase_arrived_entry_money',width:80,align:'right'">结算金额</th>					
				<th
					data-options="field:'construct_purchase_remarks',width:80,align:'right'">备注</th>


			</tr>
		</thead>


	</table>


<div id="tb" style="height:auto">
		&nbsp;&nbsp;
		<a class="easyui-linkbutton"
				href="javascript:;"  onclick="btnCancel()">返回</a>&nbsp;
		</div>





	<script type="text/javascript">
		var editIndex = undefined;
		//var construct_purchase_id=${construct_purchase_id};
		$(function() {
			if (${rows} != undefined) {
				var rows = ${rows};
				$('#materialListID').datagrid('loadData', rows);
			}
		});
		
		
		//取消
		function btnCancel() {
			location.href ="arrivePurchaseList.do?construct_purchase_id="+construct_purchase_id+"";
		}
	</script>
</body>
</html>