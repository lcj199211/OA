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
			<span>项目信息</span>
		</legend>
		<div class="fieldset-body">
			<table class="form-table" border="0" cellpadding="5" cellspacing="2">
			<tr><td><input type="hidden" value="${bill_type}" id="bill_type"></td></tr>
				<tr>
			
					<td class="form-label" style="width:60px;display: none">项目编号：</td>
					<td style="width:150px;display: none"><input
						name="construct_project_id" id="construct_project_id"
						class="mini-textbox" value="${construct.construct_project_id}" /></td>
					<td class="form-label" style="width:110px;">项目名称：</td>
					<td style="width:150px"><input type="text"
						name="construct_project_name" id="construct_project_name"
						class="mini-textbox" readonly="readonly"
						value="${construct.construct_project_name}" /></td>
					<td class="form-label" style="width:110px;">工程地址：</td>
					<td style="width:150px"><input type="text"
						value="${construct.construct_project_addr}" readonly="readonly"
						name="construct_project_addr" id="construct_project_addr"
						class="mini-textbox" /></td>
					<td class="form-label" style="width:110px;">项目经理：</td>
					<td style="width:150px"><input type="text"
						value="${construct.construct_project_leader}"
						name="construct_project_leader" id="construct_project_leader"
						class="mini-textbox" readonly="readonly" /></td>
				</tr>
				<tr>
					<td class="form-label" style="width:110px;">项目经理联系方式：</td>
					<td style="width:150px"><input type="text"
						value="${construct.construct_project_leaderTel}"
						readonly="readonly"
						name="flow_descriconstruct_project_leaderTelption"
						id="construct_project_leaderTel" class="mini-textbox" /></td>
				</tr>

			</table>
		</div>
	</fieldset>


	<fieldset id="fd1" style="width:930px;">
		<legend>
			<span>材料信息</span>
		</legend>
		<div class="fieldset-body">
			<table class="form-table" border="0" cellpadding="5" cellspacing="2">
				<tr>
					<td class="form-label" style="display: none">headId：</td>
					<td style="display: none"><input name="construct_purchase_id"
						id="construct_purchase_id" class="mini-textbox"
						readonly="readonly" value="${purchaseHead.construct_purchase_id}" /></td>
					<td class="form-label" style="display: none">状态：</td>
					<td style="display: none"><input
						name="construct_purchase_status" id="construct_purchase_status"
						class="mini-textbox" readonly="readonly"
						value="${purchaseHead.construct_purchase_status}" /></td>

					<td class="form-label" style="width:110px">计划日期：</td>
					<td style="width:150px"><input
						name="construct_purchase_planDate" readonly="readonly"
						id="construct_purchase_planDate" class="easyui-datebox"
						value="${purchaseHead.construct_purchase_planDate}" /></td>
					<td class="form-label" style="width:110px;">希望送达时间：</td>
					<td style="width:150px"><input type="text"
						name="construct_purchase_arriveDate" readonly="readonly"
						id="construct_purchase_arriveDate" class="easyui-datebox"
						value="${purchaseHead.construct_purchase_arriveDate}" /></td>
					<td class="form-label" style="width:110px;">材料计划员：</td>
					<td style="width:150px"><input type="text"
						value="${purchaseHead.construct_purchase_planMan}"
						readonly="readonly" name="construct_purchase_planMan"
						id="construct_purchase_planMan" class="mini-textbox" /></td>

				</tr>
				<tr>
					<td class="form-label" style="width:60px;">材料复核员：</td>
					<td style="width:150px"><input type="text"
						value="${purchaseHead.construct_purchase_reviewer}"
						name="construct_purchase_reviewer" readonly="readonly"
						id="construct_purchase_reviewer" class="mini-textbox" /></td>
					<td class="form-label" style="width:60px;">供应商：</td>
					<td style="width:150px"><input type="text"
						value="${purchaseHead.construct_purchase_supplier}"
						name="construct_purchase_supplier" readonly="readonly"
						id="construct_purchase_supplier" class="mini-textbox" /></td>
					<td class="form-label" style="width:60px;">供应商联系方式：</td>
					<td style="width:150px"><input type="text"
						value="${purchaseHead.construct_purchase_supplierTel}"
						name="construct_purchase_supplierTel" readonly="readonly"
						id="construct_purchase_supplierTel" class="mini-textbox" /></td>
				</tr>

			</table>
		</div>
	</fieldset>


	<div style="margin:20px 0;"></div>

	<table id="materialListID" class="easyui-datagrid" title="材料清单"
		style="width:980px;height:300px"
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
					data-options="field:'construct_purchase_arriveNum',width:80,hidden:'hidden',align:'right'">已到货量</th>
				<th
					data-options="field:'construct_purchase_remarks',width:80,align:'right'">备注</th>


			</tr>
		</thead>


	</table>
         <div style="margin:20px 0;">
       审核意见：<input type="text" name=""  id="options"/>
         </div>

	<br/>
	<div>
	     
		<tr>
            <td class="form-label" style="width:80px;">审核人：&nbsp;</td>
			<td style="width:150px"><select name="auditor"id="auditor" style="width:120px;">
								<option value="">请选择审批人</option>
								<c:forEach items="${auditor}" var="c">
								<option value="${c.username}">${c.username}</option>
			</c:forEach></select></td>
			
			<td style="align:center"><a href="javascript:void(0)"
				class="easyui-linkbutton" onclick="auditClick()">提交审核</a></td>
				
           <c:if test="${purchaseHead.construct_purchase_status==3}">
			<td style="align:center"><a href="javascript:void(0)"
				class="easyui-linkbutton" onclick="purchase()">采购</a></td>
				</c:if>
				
			<td style="align:center"><a class="easyui-linkbutton"
				href="javascript:;" id="btnCancel" onclick="btnCancel()">驳回</a></td>


		</tr>
	</div>

<div style="margin:20px 0;">

	<table id="mask" class="easyui-datagrid" title="审批记录"
		style="width:980px;height:100%px"
		data-options="iconCls: 'icon-edit',
				singleSelect: true,">
		<thead>
		<thead>
		<c:forEach items="${listsMaps}" var="c">
			<tr>
		       	<th
					data-options="field:'flow_auditer',width:150">${c.flow_auditer}</th>
				<th
					data-options="field:'flow_audit_option',width:600">${c.flow_audit_option}</th>
		
			</tr>
			</c:forEach>
		</thead>
	</table>

	
</div>
	

	<script type="text/javascript">
	

		var editIndex = undefined;
		$(function() {
			if (${rows} != undefined) {
				var rows = ${rows};
				$('#materialListID').datagrid('loadData', rows);
			}

			//单元格编辑
			$.extend($.fn.datagrid.methods, {
				editCell : function(jq, param) {
					return jq.each(function() {
						var fields = $(this).datagrid('getColumnFields', true)
								.concat($(this).datagrid('getColumnFields'));
						for (var i = 0; i < fields.length; i++) {
							var col = $(this).datagrid('getColumnOption',
									fields[i]);
							col.editor1 = col.editor;
							if (fields[i] != param.field) {
								col.editor = null;
							}
						}
						$(this).datagrid('beginEdit', param.index);
						for (var i = 0; i < fields.length; i++) {
							var col = $(this).datagrid('getColumnOption',
									fields[i]);
							col.editor = col.editor1;
						}
					});
				}
			});

		});

		//是否编辑结束
		function endEditing() {
			if (editIndex == undefined) {
				return true
			}
			if ($('#materialListID').datagrid('validateRow', editIndex)) {
				$('#materialListID').datagrid('endEdit', editIndex);
				editIndex = undefined;
				return true;
			} else {
				return false;
			}
		}
	
		
		function auditClick(){
			var bill_type=$("#bill_type").val();
	
			var auditID = ${auditID};
			var flow_audit_next_auditid = ${flow_audit_next_auditid};
			var flow_audit_last_auditid = ${flow_audit_last_auditid};
			var flow_node_order = ${flow_node_order};
			var size=${size};
			var purchase_id=$("#construct_purchase_id").val();
			var auditor=$("#auditor option:selected").val();
			var option = $("#options").val();
			if(option==""){
				$.messager.alert("提示", "请填写审核意见");
				return false;
			}
			if(size!=0 && auditor==""){
				$.messager.alert("提示", "请选择审核人");
				return false;
			}
		
			$.ajax({
				type : 'POST',
				url : "purchasing_submit.do",
				data : {'option' : option,
						'auditID' : auditID,
						'flow_node_order' : flow_node_order,
						'auditor':auditor,
						'purchase_id': purchase_id,
						'flow_audit_last_auditid':flow_audit_last_auditid,
						'flow_audit_next_auditid' :flow_audit_next_auditid,
						'size':size,
						'bill_type':bill_type,
					
				},
				success : function(data) {
					
					if (data.msg != undefined) {
						$.messager.alert("提示", data.msg, "error");
					} else {
						$.messager.alert("提示", "操作成功！", "info", function() {
							location.href="auditList.do";
						});
					}

				} 

			
		});
				
			
		}
		

		
		//驳回
		function btnCancel(){
		
		
			var option = $("#options").val();
			if(option==''){
				$.messager.alert("提示","审核意见不能为空！");
				return false;
			}
			
			$.messager.confirm('提示！', '你确定退回吗？', function(r) {
				if (r) {
			var flow_node_order = ${flow_node_order};
		
			var flow_audit_last_auditid = ${flow_audit_last_auditid};
			var auditID = ${auditID};
			

			$.ajax({
				type : 'POST',
				url : 'return_purchase.do',
				data : {'option' : option,
						'auditID' : auditID,
						'flow_node_order':flow_node_order,
						'flow_audit_last_auditid' : flow_audit_last_auditid,
					
				},success:function(data){
					if (data.msg != undefined) {
						$.messager.alert("提示", data.msg, "error");
					} else {
						$.messager.alert("提示", "操作成功！", "info", function() {
						  location.href="auditList.do";
						});
					}

					
				}
				});
			}
				});
		}
	</script>
</body>
</html>