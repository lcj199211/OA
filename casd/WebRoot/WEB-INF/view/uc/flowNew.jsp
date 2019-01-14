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
					<td class="form-label" style="width:60px;display: none">流程id：</td>
					<td style="width:150px;display: none"><input name="flow_id"
						id="flow_id" class="mini-textbox" value="${flow.flow_id}" /></td>
					<td class="form-label" style="width:60px;">流程名称：</td>
					<td style="width:150px"><input type="text" name="flow_name"
						id="flow_name" class="mini-textbox" value="${flow.flow_name}"
						readonly="readonly" /></td>
					<td class="form-label" style="width:60px;">描述：</td>
					<td style="width:150px"><input type="text"
						value="${flow.flow_description}" name="flow_description"
						readonly="readonly" id="flow_description" class="mini-textbox" /></td>
				</tr>

			</table>
		</div>
	</fieldset>

	<p>流程节点:</p>
	<div style="margin:20px 0;"></div>

	<table id="nodeID" class="easyui-datagrid" title="流程节点"
		style="width:900px;height:auto"
		data-options="
				iconCls: 'icon-edit',
				singleSelect: true,
				toolbar: '#tb',onClickCell: onClickCell
				">

		<thead>
			<tr>
				<th data-options="field:'flow_node_id',width:80">节点id</th>
				<th data-options="field:'flow_node_name',width:80,align:'right'">节点名</th>
				<th data-options="field:'orders',width:80,align:'right'">顺序</th>
				<th
					data-options="field:'flow_node_auditors',width:80,align:'right',editor:'text'">审核角色</th>
			</tr>

		</thead>


	</table>





	<div id="tb" style="height:auto">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true" onclick="add()">添加</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">删除</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-undo',plain:true" onclick="edit()">修改</a>


	</div>

	<div id="w" class="easyui-window" title='修改信息'
		data-options="modal:true,closed:true,iconCls:'icon-save'"
		style="width:700px;height:400px;padding:10px;">
		<form id="form1" method="post">

			<div style="margin:10px 0;">
				<table>
					<span>节点编号：<input type="text" name="flow_node_id"
						id="node_id" value="0" readonly="readonly" /></span>
					<span>节点名称：<input type="text" name="flow_node_name"
						id="node_name" /></span>
						<span>顺序：<input type="number" name="orders" value="0"
						id="orderid" /></span>

				</table>
			</div>

		</form>

		<table class="easyui-datagrid" id="datas" toolbar="#tbd"
			data-options="singleSelect:true,collapsible:true,onDblClickRow:onDblClickRow">
			<thead>
				<tr>
					<th data-options="field:'userid',width:80">访问人编号</th>
					<th data-options="field:'username',width:80,align:'right'">允许访问人</th>
				</tr>
			</thead>
		</table>

		<div id="tbd" style="padding:5px;">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="add2()">添加</a> <a href="javascript:void(0)"
				class="easyui-linkbutton" onclick="remove_processo()">删除</a>
		</div>

		<br /> <br /> <br />
		<div style="text-align:center">

			<a class="easyui-linkbutton" href="javascript:;" id="btnSave"
				onclick="btnSaveEva()">提交</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
				class="easyui-linkbutton" href="javascript:;" id="btnCancel"
				onclick="closeDown()">取消</a>

		</div>

	</div>

	<div id="win" class="easyui-window" title='赋值'
		data-options="modal:true,closed:true,iconCls:'icon-save'"
		style="width:800px;height:400px;padding:10px;"></div>

	<div><form id="jvForm" action="" method="post"
					enctype="multipart/form-data">
					<table>
						<tbody>
							<tr>
								<td hidden="hidden"><input type="text" id="bizId"
									value="${bizId}"></td>
								<td width="80%"><input name="file" type="file" id="file"/>
									<a class="easyui-linkbutton"
									
									onclick="uploadPic();" href="javascript:;" id="btnSaveExp">部署流程文件</a></td>
							</tr>
						</tbody>
					</table>
				</form>
	</div>
	
	
	<script type="text/javascript">
		//新增行
		function add2() {
			if (endEditing()) {
				$('#datas').datagrid('appendRow', {

				});
				editIndex = $('#datas').datagrid('getRows').length - 1;

				$('#datas').datagrid('selectRow', editIndex).datagrid(
						'beginEdit', editIndex);
			}
		}

		//打开用户子页面
		var indexs = 0;
		function onDblClickRow(index, field) {
			indexs = index;
			var hrefs = "<iframe id='son' src='userListCheck.do?index="
					+ index
					+ "' allowTransparency='true' style='border:0;width:99%;height:99%;padding-left:2px;' frameBorder='0'></iframe>";
			$("#win").html(hrefs);
			$("#win").window("open");

		}

		//子页面赋值
		function pryData(data, index) {
			$('#datas').datagrid('acceptChanges');
			var row = $('#datas').datagrid("selectRow", index).datagrid(
					"getSelected");
			row.userid = data.userid;
			row.username = data.username;
			$('#datas').datagrid('refreshRow', index); //刷新当前行
		}

		//w子窗口保存流程
		function btnSaveEva() {

			var node_id = $("#node_id").val();
			var flow_id = $("#flow_id").val();
			var node_name = $("#node_name").val();
			var orderid=$("#orderid").val();
			var rows = $("#datas").datagrid("getRows");
			var ids = [];
			if (rows.length > 0 && rows[0].userid != undefined) {
				for (var i = 0; i < rows.length; i++) {
					ids.push(rows[i].userid);
				}
			} else {
				ids.push(0);
			}

			$.ajax({
				type : 'POST',
				url : "saveFlowNode.do",
				data : {
					'node_id' : node_id,
					'flow_id' : flow_id,
					'node_name' : node_name,
					'orderid':orderid,
					'ids' : JSON.stringify(ids),
				},
				success : function(data) {
					if (data.msg != undefined) {
						$.messager.alert("提示", data.msg, "error");
					} else {
						$.messager.alert("提示", "操作成功！", "info", function() {
							window.location.reload();
						});
					}

				}
			});

		}
		//w窗口审核人信息
		function edit() {
			var rows = $("#nodeID").datagrid("getSelections");//获取表格数据
			if (rows.length == 0) {
				$.messager.alert("提示", "请选择需要修改的行！");
				return false;
			} else if (rows.length > 1) {
				$.messager.alert("提示", "一次只能选择一行喔！");
				return false;
			}

			$.ajax({
				type : 'POST',
				url : "editFlowUser.do",
				data : {
					'node_auditors' : rows[0].flow_node_auditors,
				},
				success : function(data) {
					if (data.msg != undefined) {
						$.messager.alert("提示", data.msg, "error");
					} else {
						$('#w').window('open');
						$("#node_id").val(rows[0].flow_node_id);
						$("#node_name").val(rows[0].flow_node_name);
						$("#orderid").val(rows[0].orders);
						var listMap = data.listMap;
						$('#datas').datagrid('loadData', listMap);
					}

				}
			});
		}
		//w子窗口删除行
		function remove_processo() {
			var row = $('#datas').datagrid('getSelected');
			if (row) {
				var rowIndex = $('#datas').datagrid('getRowIndex', row);
				$('#datas').datagrid('deleteRow', rowIndex);

			} else {
				$.messager.alert("提示", "请选择删除行!");

			}

		}
		//关闭窗口
		function closeDown() {
			$('#w').window('close');

		}

		var editIndex = undefined;

		//列表数据加载
		/***处理操作列的功能***/
		function cmdHanlder(cmd, row) {
		}
		$(function() {

			$("#nodeID").admin_grid({
				cmdHanlder : cmdHanlder,
			});
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

		//删除节点处理
		function removeit() {
			var rows = $("#nodeID").datagrid("getSelected");//获取表格数据

			if (rows == null) {
				$.messager.alert("提示", "请选择要删除行！");
				return null;

			}
			$.messager.confirm('提示！', '你确定删除吗？', function(r) {
				if (r) {
					$.ajax({
						type : 'POST',
						url : "delectNode.do",
						data : {
							'cid' : rows.flow_node_id,
						},
						success : function(data) {
							if (data.msg != undefined) {
								$.messager.alert("提示", data.msg, "error");
							} else {
								$.messager.alert("提示", "操作成功！", "info",
										function() {
											window.location.reload();
										});

							}
						}
					});
				}
			});

		};
		
        //部署
		function uploadPic(){

			var fileName = $("#file").val();
		
			var file_typename = fileName.substring(fileName.lastIndexOf('.'),
					fileName.length);
			if(file_typename!= '.zip'){
			
				$.messager.alert("警告","选择流程文件格式为 .zip",'warning');
				return false;
			}
			
			$.messager.confirm('继续操作', '确定导入吗?', function(r) {
				if (r) {
					// 上传设置  

					$('#jvForm').form(
							'submit',
							{
								url : 'deploymentProcessDefinition_zip.do',

								onSubmit : function(data) {

									//导入成功后的要处理的操作
								},
								success : function(data) {
									var data = eval("(" + data + ")");
									if (data.Success) {
										$.messager.alert("提示", data.Msg,
												"info", function() {
													window.location
															.reload(true);
												});
									} else {
										$.messager.alert("提示", data.Msg,
												"error");
									}

								}
							});
				}
			});
		}
			
	
		
		function add() {
			$("#w").window("open");

		}
		//是否编辑结束
		function endEditing() {
			if (editIndex == undefined) {
				return true
			}
			if ($('#nodeID').datagrid('validateRow', editIndex)) {
				$('#nodeID').datagrid('endEdit', editIndex);
				editIndex = undefined;
				return true;
			} else {
				return false;
			}
		}
		function onClickCell(index, field) {

			if (endEditing() && field != "flow_node_processo") {
				$("#nodeID").datagrid('selectRow', index).datagrid('editCell',
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