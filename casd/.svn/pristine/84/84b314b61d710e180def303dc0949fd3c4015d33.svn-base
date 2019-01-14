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
	src="<%=request.getContextPath()%>/res/admin/scripts/jquery.ajaxfileupload.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/res/admin/scripts/ueditor/third-party/codemirror/codemirror.js"
	type="text/javascript"></script>
<script src="${CASD_PATH}/res/layui/format/dateformat.js?HJ_v=<%=Math.random()%>" charset="utf-8"></script>

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

#main{
				
				height:120px;
				border: 1px solid #000;
				margin: 10px auto;	
				float: left;			
			}
			#main .title{
				float: left;
				
			}
			
			#mes-tec{
				height: 120px;
				width:40px;
				border-right: 1px solid #000;
				text-align: center;
			
			}
			
			#person{
				height: 120px;
				width:50px;
				border-right: 1px solid #000;
			}
			
			#person div input{
				height: 120px;
				width:50px;
				border:0;
				padding-left:10px;
				line-height:120px;
			}
			
			
			#option{
				width:170px;
				border-right: 1px solid #000;
				height: 120px;
			}
			#option div input{
				width:170px;
				height: 120px;
				border:0;
				padding-left:10px;
				line-height:120px;
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
						id="construct_project_id" class="mini-textbox" value="${construct.construct_project_id}" /></td>
					<td class="form-label" style="width:110px;">项目名称：</td>
					<td style="width:150px"><input type="text" name="flow_name"
						id="flow_name" class="mini-textbox" value="${construct.construct_project_name}" /></td>
					<td class="form-label" style="width:110px;">工程地址：</td>
					<td style="width:150px"><input type="text"
						value="${construct.construct_project_addr}" name="flow_description"
						id="flow_description" class="mini-textbox" /></td>
					<td class="form-label" style="width:110px;">项目经理：</td>
					<td style="width:150px"><input type="text"
						value="${construct.construct_project_leader}" name="flow_description"
						id="flow_leader" class="mini-textbox" /></td>
					</tr>
					<tr>	
					<td class="form-label" style="width:110px;">项目经理联系方式：</td>
					<td style="width:150px"><input type="text"
						value="${construct.construct_project_leaderTel}" name="flow_description"
						id="flow_leaderTel" class="mini-textbox" /></td>
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
				<td class="form-label" style="display: none">headId：</td>
					<td style="display: none"><input name="construct_purchase_id"
						id="construct_purchase_id" class="mini-textbox" value="${purchaseHead.construct_purchase_id}" /></td>
					<td class="form-label" style="width:110px">计划日期：</td>
					<td style="width:150px"><input name="construct_purchase_planDate"
						id="construct_purchase_planDate" class="easyui-datebox" value="${purchaseHead.construct_purchase_planDate}" /></td>
					<td class="form-label" style="width:110px;">希望送达时间：</td>
					<td style="width:150px"><input type="text" name="construct_purchase_arriveDate"
						id="construct_purchase_arriveDate" class="easyui-datebox" value="${purchaseHead.construct_purchase_arriveDate}" /></td>
					<td class="form-label" style="width:110px;">材料计划员：</td>
					<td style="width:150px"><input type="text"
						value="${purchaseHead.construct_purchase_planMan}" name="construct_purchase_planMan"
						id="construct_purchase_planMan" class="mini-textbox" /></td>
					
					</tr>
					<tr>
					<td class="form-label" style="width:60px;">材料复核员：</td>
					<td style="width:150px"><input type="text"
						value="${purchaseHead.construct_purchase_reviewer}" name="construct_purchase_reviewer"
						id="construct_purchase_reviewer" class="mini-textbox" /></td>	
					<td class="form-label" style="width:60px;">供应商：</td>
					<td style="width:150px"><input type="text"
						value="${purchaseHead.construct_purchase_supplier}" name="construct_purchase_supplier"
						id="construct_purchase_supplier" class="mini-textbox" /></td>
					<td class="form-label" style="width:60px;">供应商联系方式：</td>
					<td style="width:150px"><input type="text"
						value="${purchaseHead.construct_purchase_supplierTel}" name="construct_purchase_supplierTel"
						id="construct_purchase_supplierTel" class="mini-textbox" /></td>				
				</tr>

			</table>
		</div>
	</fieldset>
	
	
	<div style="margin:20px 0;"></div>
<div>
	<table id="materialListID" class="easyui-datagrid" title="材料清单"
		style="width:1200px;height:200px"
		data-options="
				iconCls: 'icon-edit',
				singleSelect: true,
				toolbar: '#tb',onDblClickCell: onDblClickCell,onClickCell: onClickCell
				">
			<thead>
		 <thead>
			<tr>
				<th class="123" data-options="field:'construct_purchase_entryId',width:80,hidden:'hidden',editor:'text'">Item ID</th>
				<th
					data-options="field:'num',width:80,align:'right'">材料编号</th>
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
					data-options="field:'construct_purchase_remarks',width:300,align:'left'">备注</th>	
						
							
			</tr>
		</thead>


	</table>
	<div id="tb">
	<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="exc_print()">打印</a>
	
</div>
</div>

	<div  id="win" class="easyui-window" data-options="region:'center',title:'备注'" closed="true" style="height: 500px; width: 800px" >    
		<textarea style="width: 100%;height: 100% "  readonly="readonly" id="remark" ></textarea>
	</div>

	<div id="audit">
	<table id="history" class="easyui-datagrid" title="审批记录"
		style="width:1200px;height:150px"
		data-options="
				iconCls: 'icon-edit',
				singleSelect: true,rownumbers:true">
			<thead>
			<tr>	
				<th data-options="field:'name_',width:120">步骤名称</th>
				<th data-options="field:'username',width:80">相关人员</th>
				<th data-options="field:'MESSAGE_',width:300">审核意见</th>
				<th data-options="field:'START_TIME_',width:180" formatter="dateformat">发生时间</th>			
				<th data-options="field:'center_name',width:100">中心</th>	
				<th data-options="field:'department_name',width:200">部门</th>
			</tr>
		</thead>
	</table>
	</div>
	
	<script type="text/javascript">
	var editIndex = undefined;
	$(function(){
		if(${history}.history!=undefined){
			var historys = ${history}.history; 
			$('#history').datagrid('loadData',historys);
		}
		

		if(${rows}.rows!=undefined){
			var rows = ${rows}.rows; 
			$('#materialListID').datagrid('loadData',rows);
		}
		
		
		
		//单元格编辑
		$.extend($.fn.datagrid.methods, {
			editCell: function(jq,param){
				return jq.each(function(){
					var fields = $(this).datagrid('getColumnFields',true).concat($(this).datagrid('getColumnFields'));
					for(var i=0; i<fields.length; i++){
						var col = $(this).datagrid('getColumnOption', fields[i]);
						col.editor1 = col.editor;
						if (fields[i] != param.field){
							col.editor = null;
						}
					}
					$(this).datagrid('beginEdit', param.index);
					for(var i=0; i<fields.length; i++){
						var col = $(this).datagrid('getColumnOption', fields[i]);
						col.editor = col.editor1;
					}
				});
			}
		});  
		
	});
			

	
	 function dateformat(value, row, index) {
		if (value == undefined)
			return "";	
	  var  date=new  Date(value.time); 
      var time=date.Format("yyyy-MM-dd HH:mm:ss");
			return time;
            }
			
			//是否编辑结束
			function endEditing(){
				if (editIndex == undefined){return true}
				if ($('#materialListID').datagrid('validateRow', editIndex)){
					$('#materialListID').datagrid('endEdit', editIndex);
					editIndex = undefined;
					return true;
				} else {
					return false;
				}
			}
			
			
			function onClickCell(index, field){
				$('#materialListID').datagrid('selectRow', index);
				if (endEditing()) {
					$(this).datagrid('beginEdit', index);
				}
			}
			
			
			
			function onDblClickCell(index, field, value) {
				
				if (field == "construct_purchase_remarks") {
					$("#remark").val(value);
					$("#win").window("open");
				}
			}
					
			
			//撤销新增行
			function reject(){
				$('#materialListID').datagrid('rejectChanges');
				editIndex = undefined;
			}
			
		//打印
	   function exc_print(){
			
			var bizId= $("#construct_purchase_id").val();
		
			 var rows4 = $("#materialListID").datagrid("getRows");   			  
				total=0;
				for (var int = 0; int < rows4.length; int++) {
					total=parseFloat(rows4[int].construct_purchase_purchaseTotal)+parseFloat(total);
				}
				location.href = "excelprint.do?" + $.param({		
					'bizId':bizId,
				});

			
		
	}
			
			
			
		
			
	</script>
</body>
</html>