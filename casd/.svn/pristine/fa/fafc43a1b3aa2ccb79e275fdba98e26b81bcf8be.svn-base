<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title></title>

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

#main {
	width: 400px;
	height: 120px;
	border: 1px solid #000;
	margin: 10px auto;
	float: left;
}

#main .title {
	float: left;
}

#shen-chuang-fu {
	width: 80px;
	border-right: 1px solid #000;
	height: 120px;
}

#shen-chuang-fu div {
	height: 80px;
	text-align: center;
	line-height: 39px;
	border-bottom: 1px solid #000;
}

#name_box {
	width: 318px;
	border-right: 1px solid #000;
	height: 120px;
}

#button {
	width: 318px;
	border-right: 1px solid #000;
	height: 40px;
}

#opinion {
	height: 80px;
	border-bottom: 1px solid #000;
}
</style>
</head>
<body>

	<fieldset id="fd1" style="width:880px;">
		<legend>
			<span>项目信息</span>
		</legend>
		<div class="fieldset-body">
			<table class="form-table" border="0" cellpadding="5" cellspacing="2">
				<tr>
					<td class="form-label" style="width:60px;display: none">项目编号：</td>
					<td style="width:150px;display: none"><input name="construct_project_id"
						id="construct_project_id" class="mini-textbox" value="${head.construct_project_id}" /></td>
					<td class="form-label" style="width:110px;">项目名称：</td>
					<td style="width:150px"><input type="text" name="flow_name"
						id="flow_name" class="mini-textbox" value="${head.construct_project_name}" /></td>
					<td class="form-label" style="width:110px;">工程地址：</td>
					<td style="width:150px"><input type="text"
						value="${head.construct_project_addr}" name="flow_description"
						id="flow_description" class="mini-textbox" /></td>
					<td class="form-label" style="width:110px;">项目经理：</td>
					<td style="width:150px"><input type="text"
						value="${head.construct_project_leader}" name="flow_description"
						id="flow_description" class="mini-textbox" /></td>
					</tr>
					<tr>	
					<td class="form-label" style="width:110px;">项目经理联系方式：</td>
					<td style="width:150px"><input type="text"
						value="${head.construct_project_leaderTel}" name="flow_description"
						id="flow_description" class="mini-textbox" /></td>
				</tr>

			</table>
		</div>
	</fieldset>
	
	<fieldset id="fd1" style="width:880px;">
		<legend>
			<span>材料信息</span>
		</legend>
		<div class="fieldset-body">
			<table class="form-table" border="0" cellpadding="5" cellspacing="2">
				<tr>
				<td class="form-label" style="display: none">单据编号：</td>
					<td style="display: none"><input name="construct_purchase_id"
						id="construct_purchase_id" class="mini-textbox" value="${head.construct_purchase_id}" /></td>
					<td style="display: none"><input name="construct_purchase_projectId"
						id="construct_purchase_projectId" class="mini-textbox" value="${head.construct_purchase_projectId}" /></td>
					<td class="form-label" style="width:110px">计划日期：</td>
					<td style="width:150px"><input name="construct_purchase_planDate"
						id="construct_purchase_planDate" class="easyui-datebox" value="${head.construct_purchase_planDate}" /></td>
					<td class="form-label" style="width:110px;">希望送达时间：</td>
					<td style="width:150px"><input type="text" name="construct_purchase_arriveDate"
						id="construct_purchase_arriveDate" class="easyui-datebox" value="${head.construct_purchase_arriveDate}" /></td>
					<td class="form-label" style="width:110px;">材料计划员：</td>
					<td style="width:150px"><input type="text"
						value="${head.construct_purchase_planMan}" name="construct_purchase_planMan"
						id="construct_purchase_planMan" class="mini-textbox" /></td>
					</tr>
					<tr>
					<td class="form-label" style="width:60px;">材料复核员：</td>
					<td style="width:150px"><input type="text"
						value="${head.construct_purchase_reviewer}" name="construct_purchase_reviewer"
						id="construct_purchase_reviewer" class="mini-textbox" /></td>	
					<td class="form-label" style="width:60px;">供应商：</td>
					<td style="width:150px"><input type="text"
						value="${head.construct_purchase_supplier}" name="construct_purchase_supplier"
						id="construct_purchase_supplier" class="mini-textbox" /></td>
					<td class="form-label" style="width:60px;">供应商联系方式：</td>
					<td style="width:150px"><input type="text"
						value="${head.construct_purchase_supplierTel}" name="construct_purchase_supplierTel"
						id="construct_purchase_supplierTel" class="mini-textbox" /></td>
					<td class="form-label" style="width:60px;">状态：</td>
					<td style="width:150px"><input type="text"
						value="${head.construct_purchase_status}" name="construct_purchase_status"
						id="construct_purchase_status" class="mini-textbox" /></td>					
				</tr>

			</table>
		</div>
	</fieldset>
	
	
	<div style="margin:20px 0;"></div>

	<table id="materialListID" class="easyui-datagrid" title="材料清单" 
		style="width:930px;height:350px"
		data-options="
				iconCls: 'icon-edit',
				singleSelect: true,
				toolbar: '#tb'
				">
			<thead>
		 <thead>
			<tr>
				<th class="123" data-options="field:'construct_purchase_entryId',width:80,hidden:'hidden',editor:'text'">Item ID</th>
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
					data-options="field:'construct_purchase_applyNum',width:80,align:'right',editor:{type:'text',options:{required:true}}">计划采购量</th>
				<th
					data-options="field:'construct_purchase_contractPrice',width:80,align:'right'">合同单价</th>	
				<th
					data-options="field:'construct_purchase_purchasePrice',width:80,align:'right',editor:{type:'text',options:{required:true}}">采购单价</th>	
				<th
					data-options="field:'construct_purchase_purchaseTotal',width:80,align:'right',editor:{type:'text',options:{required:true}}">采购小计</th>
				<th
					data-options="field:'construct_purchase_brand',width:80,align:'right',editor:{type:'text',options:{required:true}}">材料品牌</th>	
				<th
					data-options="field:'construct_purchase_remarks',width:80,align:'right',editor:{type:'text',options:{required:true}}">备注</th>	
						
			</tr>
		</thead>

	</table>

	<div id="main">

		<div id="shen-chuang-fu" class="title">
			<div style="margin-top: 40px" class="name">审核意见：</div>
		</div>

		<div id="name_box" class="title">
			<div id="opinion">
				<input id="options"
					style="width:309px;height:80px;border:0;padding-left:10px;line-height:120px"
					value=""></input>
			</div>
			<div id="button" style="text-align: center">
				<a class="easyui-linkbutton" href="javascript:;" id="btnAudit"
					style="margin-top: 10px">审核</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a class="easyui-linkbutton" href="javascript:;" id="btnBack"
					style="margin-top: 10px">退回</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				
			</div>
		</div>

	</div>
	<br />
	<br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
	<div style="text-align: center">
		<a class="easyui-linkbutton" href="javascript:;" id="backList"
					style="margin-top: 10px">返回</a>	
	</div>
	
	<div  id="win" class="easyui-window" data-options="region:'center',title:'请选择值'" closed="true" style="height: 500px; width: 800px" >    
				</div>
	
	
	<script type="text/javascript">
		
		$(document).ready(function() {
			if(${rows}.rows!=undefined){
				var rows = ${rows}.rows; 
				$('#materialListID').datagrid('loadData',rows);
			}
			
			
			
			//按钮审核
			var auditID = ${auditID};
			var flow_status = ${flow_status};
			var flow_audit_next_auditid = ${flow_audit_next_auditid};
			
			$("#btnAudit").click(function() {
				if(flow_status!=1){
					alert("已经审核，不能再操作");
					return false;
				}
				var option = $("#options").val();
				if (option == "") {
					alert("审核意见不能为空!");
					return false;
				}
				 if (confirm("你确定审核通过吗？")) {
					var construct_purchase_id = $("#construct_purchase_id").val();
					var construct_purchase_status= $("#construct_purchase_status").val();
					$.ajax({
						type : 'POST',
						url : 'auditFinalPurchase.do',
						data : {
							'construct_purchase_id' : construct_purchase_id,
							'option' : option,
							'auditID' : auditID,
							'flow_audit_next_auditid' :flow_audit_next_auditid,
							'construct_purchase_status' : construct_purchase_status
						},
						success : function(data) {
							if (data == "") {
								alert("已提交到下一审批人");
							} else {
								alert("提交失败");
							}
						}
					});
				} else {
					return false;
				} 
			});

/* 			//按钮退回
			$("#btnBack").click(function() {
				if(flow_status!=1){
					alert("已经审核，不能再操作");
					return false;
				}
				var option = $("#options").val();
				if (option == "") {
					alert("审核意见不能为空!");
					return false;
				} else {
				if (confirm("你确定退回申请吗？")) {
					var id = $("#id").val();
					$.ajax({
						type : 'POST',
						url : 'backLeave.do',
						data : {
							'id' : id,
							'option' : option,
							'auditID' : auditID
						},
						success : function(data) {
							if (data == "") {
								alert("成功退回申请");
							} else {
								alert("退回失败");
							}
						}
					});
				} else {
					return false;
				}
				}
			});
 */
			
			
			
			$("#backList").click(function() {
				location.href="auditList.do";
			});

		});
		
		
		
		
		
	</script>

</body>