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
				toolbar: '#tb',onClickCell: onClickCell
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
	<div id="tb" style="height:auto">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true" onclick="add()">添加</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-cut',plain:true" onclick="removeit()">删除</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-undo',plain:true" onclick="cancel()">撤销</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-tip',plain:true" onclick="proQuantyCheck()">选择合同工程量</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-tip',plain:true" onclick="materialList()">选择材料</a>		
	</div>
</fieldset>
<br/>
<div>
		<table>
		<tr>
		<td class="form-label" style="width:80px;">审核人：</td>
			<td style="width:150px"><select name="auditor"id="auditor" style="width:120px;">
								<option value="">请选择审批人</option>
								<c:forEach items="${auditor}" var="c">
								<option value="${c.username}">${c.username}</option>
			</c:forEach>
		</select></td>
		</tr>
		</table>			
	</div>

		<br/><br/><br/><br/>
		<div style="text-align:center">

			<a class="easyui-linkbutton" href="javascript:;" id="btnCancel"
				onclick="btnSubmit('save')">保存</a>&nbsp;&nbsp;&nbsp;&nbsp; 
			<a class="easyui-linkbutton" href="javascript:;" id="btnSave"
				onclick="btnSubmit('submit')">提交</a> &nbsp;&nbsp;&nbsp;&nbsp; 
			<a class="easyui-linkbutton" href="javascript:;" id="btnCancel"
				onclick="btnBack()">取消</a>
		</div>

	<div  id="win" class="easyui-window" data-options="region:'center',title:'请选择值'" closed="true" style="height: 500px; width: 800px" >    
	</div>
	
	<script type="text/javascript">
		var editIndex = undefined;
		var projectId=${projectId};
		var indexNum=null;
		
		$(function() {
			
			if (${rows}.rows != undefined) {
				var rows = ${rows}.rows;
				$('#Purchange').datagrid('loadData', rows);
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
		
		//撤销
		function cancel() {
			var row = $('#Purchange').datagrid('getSelected');
			if (row) {
				var rowIndex = $('#Purchange').datagrid('getRowIndex', row);
				$('#Purchange').datagrid('deleteRow', rowIndex);
			} else {
				$.messager.alert("提示", "请选择删除行!");
			}
		}
		
		function  btnBack(){
			
			location.href="purChangeList.do?construct_project_id="+projectId;
		}
		
		
		//选择合同工程量弹框
		function proQuantyCheck() {
			var row = $('#Purchange').datagrid('getSelected');
			if (row!=null) {
				indexNum=$('#Purchange').datagrid('getRowIndex',row);
				var hrefs = "<iframe id='son' src='proQuantyCheck.do?index="
						+ indexNum+"&projectId="+projectId
						+ "' allowTransparency='true' style='border:0;width:99%;height:99%;padding-left:2px;' frameBorder='0'></iframe>";
				$("#win").html(hrefs);
				$("#win").window("open");
			}else{
				$.messager.alert("提示", "至少需要添加一行");
			}
		}
		
		//合同工程量子窗口调用
		function materialData(data, index) {
			index=indexNum;
			var row = $('#Purchange').datagrid("selectRow", index)
					.datagrid("getSelected");
			
			$('#Purchange').datagrid('acceptChanges');
			var rows = $('#Purchange').datagrid('getRows');
			
			row.purChangeEntryTab_material = data.name;
			row.purChangeEntryTab_model = data.model;
			row.purChangeEntryTab_quarityNum = data.num;
			row.purChangeEntryTab_price = data.price;
			row.purChangeEntryTab_unit = data.unit;
			row.purChangeEntryTab_applyNum = rows[index].purChangeEntryTab_applyNum;
			row.purChangeEntryTab_remarks = rows[index].purChangeEntryTab_remarks;
			//row.purChangeEntryTab_total = rows[index].purChangeEntryTab_total; 金额需要计算
			$('#Purchange').datagrid('refreshRow', index);
		}
		//材料子窗口调用
		function materialDatas(data) {
			index=indexNum;
			var row = $('#Purchange').datagrid("selectRow", index)
					.datagrid("getSelected");
			
			$('#Purchange').datagrid('acceptChanges');
			var rows = $('#Purchange').datagrid('getRows');
			
			
			row.purChangeEntryTab_material = data.construct_material_name;
			row.purChangeEntryTab_model = data.construct_material_model_name;
			row.purChangeEntryTab_quarityNum = 0;
			row.purChangeEntryTab_price = 0;
			row.purChangeEntryTab_unit = data.construct_material_model_unit;
			row.purChangeEntryTab_applyNum = rows[index].purChangeEntryTab_applyNum;
			row.purChangeEntryTab_remarks = rows[index].purChangeEntryTab_remarks;
			//row.purChangeEntryTab_total = rows[index].purChangeEntryTab_total; 金额需要计算
			$('#Purchange').datagrid('refreshRow', index);
		}
		
		
		//选择材料
		function materialList() {
			var row = $('#Purchange').datagrid('getSelected');
			if (row!=null) {
				indexNum=$('#Purchange').datagrid('getRowIndex',row);
				var hrefs = "<iframe id='son' src='materialListCheck.do"
						+ "' allowTransparency='true' style='border:0;width:99%;height:99%;padding-left:2px;' frameBorder='0'></iframe>";
				$("#win").html(hrefs);
				$("#win").window("open");
			}else{
				$.messager.alert("提示", "至少需要添加一行");
			}
		}
		
		
		//提交
		function btnSubmit(obj) {
			var auditor = "";
			if(obj=='submit'){
				var auditor = $("#auditor").val();
				if(auditor==""){
					$.messager.alert("提示","审核人不能为空！");
					return false;
				}
			}
			var purChangeTab_id = $("#purChangeTab_id").val();
			var purChangeTab_proName = $("#purChangeTab_proName").val();
			var purChangeTab_matter = $("#purChangeTab_matter").val();
			var purChangeTab_dep = $("#purChangeTab_dep").val();
			var purChangeTab_reason = $("#purChangeTab_reason").val();
			var purChangeTab_proId = $("#purChangeTab_proId").val();
			var purChangeEntryTab_total = $("#purChangeEntryTab_total").val();
			
			
			var rows = null;
			if (endEditing()) {
				$('#Purchange').datagrid('acceptChanges');
				 rows = $('#Purchange').datagrid('getRows');
			}
			
			$.ajax({
					type : 'POST',
					url : 'submitPurChange.do',
					data : {
						'rows' : JSON.stringify(rows),
						'purChangeTab_id' : purChangeTab_id,
						'purChangeTab_proName' : purChangeTab_proName,
						'purChangeTab_matter' : purChangeTab_matter,
						'purChangeTab_dep' : purChangeTab_dep,
						'purChangeTab_reason' : purChangeTab_reason,
						'purChangeTab_proId' : purChangeTab_proId,
						'auditor' : auditor
					},
					success : function(data) {
						if(obj=='submit'){
							if (data == "") {
								alert("提交成功");
								location.reload(true);
							} else {
								alert("提交失败");
							}
						}else{
							if (data == "") {
								alert("保存成功");
								location.reload(true);
							} else {
								alert("保存失败");
							}
						}
					}
			});
		}
		
		
		//删除
		function removeit() {
			var rows = $("#Purchange").datagrid("getSelections");//获取表格数据
				if (rows.length == 0) {
					$.messager.alert("提示","请选择需要删除的行");
					return false;
				} else if (rows.length > 1) {
					$.messager.alert("提示","一次只能选择一行喔！");
					return false;
				}
			
				$.post("delete_purChangeEntry.do", {
					purChangeEntryTab_id:rows[0].purChangeEntryTab_id,
				},function(data) {
					if (data.msg != undefined) {
					    $.messager.alert("提示",data.msg,"error");
					}else{
						$.messager.alert("提示","操作成功！");
						window.location.reload(true);
					}
				});
		}
		

		//是否编辑结束
		function endEditing() {
			if (editIndex == undefined) {
				return true;
			}
			if ($('#Purchange').datagrid('validateRow', editIndex)) {
				$('#Purchange').datagrid('endEdit', editIndex);
				editIndex = undefined;
				return true;
			} else {
				return false;
			}
		}
		
		//新增行
		function add() {
			if (endEditing()) {
				$('#Purchange').datagrid('appendRow', {
					status : 'P'
				});
				editIndex = $('#Purchange').datagrid('getRows').length - 1;

				$('#Purchange').datagrid('selectRow', editIndex).datagrid(
						'beginEdit', editIndex);
			}
		}
		
		function onClickCell(index, field) {
			if (endEditing()) {
				$("#Purchange").datagrid('selectRow', index).datagrid('editCell',
						{
							index : index,
							field : field
						});
				editIndex = index;
			}
		}
	</script>
</body>
</html>