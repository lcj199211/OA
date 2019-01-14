<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ taglib uri="PowerCheck" prefix="shop"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../common/css.jsp"></jsp:include>
<jsp:include page="../common/scripts.jsp"></jsp:include>

<script
	src="<%=request.getContextPath()%>/res/admin/scripts/admin_grid.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/res/admin/scripts/ueditor/third-party/codemirror/codemirror.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/res/js/echarts.common.min.js"
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
	<div style="float:left;">

		<div style="margin: 20px"></div>
		<div style="text-align: center">
			<strong style="font-size:25px">建设公司项目进度计划表</strong>
		</div>
		<div style="margin: 10px"></div>
		<div style="text-align: center">
			<h style="font-size:20px">${construct_project_name}</h>
		</div>
		
		<div style="margin: 10px"></div>
		<table id="materialListID" class="easyui-datagrid" title="计划表"
			style="width:1600px;height:auto"
			data-options="
				iconCls: 'icon-edit',
				singleSelect: true,
				toolbar: '#tb',onClickCell:onClickCell,rownumbers:true
				">
			<thead>
				<tr>
					<th
						data-options="field:'construct_prosch_updatetime',width:120,align:'right'">更新时间</th>
					<th
						data-options="field:'construct_prosch_projectid',width:100,hidden:'hidden',editor:'text'">项目id</th>
					<th
						data-options="field:'construct_prosch_id',width:100,hidden:'hidden',editor:'text'">ItemID</th>
					<th
						data-options="field:'construct_prosch_system',width:150,align:'right',editor:'text'">系统</th>
					<th
						data-options="field:'construct_prosch_teamplan',width:100,align:'right',editor:'text' ">班主计划</th>
					<th
						data-options="field:'construct_prosch_makespan',width:100,align:'right',editor:'datebox'">完工时间</th>
					<th
						data-options="field:'construct_prosch_debugcom',width:100,align:'right',editor:'datebox' ">调试完成</th>
					<th
						data-options="field:'construct_prosch_detectioncom',width:100,align:'right',editor:'datebox'">检测完成</th>
					<th
						data-options="field:'construct_prosch_accepcom',width:100,align:'right',editor:'datebox' ">验收完成</th>
					<th
						data-options="field:'construct_prosch_busyowner',width:100,align:'right' ,editor:'datebox' ">交证业主</th>
					<th
						data-options="field:'construct_prosch_fulfil',width:100,align:'right',editor:'datebox'">竣备完成</th>
					<th
						data-options="field:'construct_prosch_checkupon',width:100,align:'right',editor:'datebox'">业主验收</th>
					<th
						data-options="field:'construct_prosch_turnover',width:100,align:'right',editor:'datebox'">移交物业</th>
					<th
						data-options="field:'construct_prosch_startbusiness',width:100,align:'right',editor:'datebox'">交楼/开业</th>
					<th
						data-options="field:'construct_prosch_settlement',width:100,align:'right',editor:'datebox'">结算</th>

					<th
						data-options="field:'construct_prosch_remark',width:100,align:'right',editor:'text'">备注</th>
					<th
						data-options="field:'_operate',width:80,align:'center',formatter:formatOper">操作</th>
				</tr>
			</thead>
		</table>


		<div id="tb" style="height:auto">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-add',plain:true" onclick="add()">添加</a>

			<a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-undo',plain:true" onclick="reject()">撤销新增行</a>

			<a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-cut',plain:true" onclick="removeit()">删除</a>
		</div>
		<br /> <br /> <br />
		<div style="text-align:center">
			<tr>
				<td style="align:center">
					<!-- &nbsp;&nbsp;&nbsp;&nbsp; <a class="easyui-linkbutton"
				href="javascript:;" id="btnSave" onclick="btnSave()">保存</a> -->&nbsp;&nbsp;&nbsp;&nbsp;
					<a class="easyui-linkbutton" href="javascript:;" id="btnCancel"
					onclick="btnCancel()">返回</a>
				</td>
			</tr>
		</div>

	</div>


	<script type="text/javascript">
		var editIndex = undefined;

		$(function() {

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

			var datas = ${rows}.rows;
			if (datas.length != 0) {
				$('#materialListID').datagrid('loadData', datas);
			}

		});

		function formatOper(val, row, index) {
			
			return '<a href="#" onclick="save_proSch('+index+')">保存</a>';
		}

		function save_proSch(index){
			$('#materialListID').datagrid('acceptChanges');
			var rows =  $('#materialListID').datagrid('getData').rows[index];
			$.messager.confirm('提示！', '你确定保存吗？', function(r) {
				if (r) {
					$.ajax({
						type : 'POST',
						url : "save_proSch.do?proSch=["+encodeURI(JSON.stringify(rows))+"]",
						data : {
						},
						success : function(data) {
							alert("保存成功");
							window.location.reload();
						}
					});
					
					
				}
			});
		}
		
		
		

		//删除处理
		function removeit() {
			rows = $("#materialListID").datagrid("getSelections");//获取表格数据
			if (rows.length == 0) {
				alert("请选择需要删除的行");
				return null;
			} else if (rows.length > 1) {
				alert("只能选一行");
				return null;
			}
			var id = rows[0].construct_prosch_id;
			$.ajax({
				type : 'POST',
				url : "delete_ProSch.do",
				data : {
					'id' : id
				},
				success : function(data) {
					alert("删除成功");
					window.location.reload();
				}
			});

		};

		//新增行
		function add() {
			$('#materialListID').datagrid('appendRow', {
				status : 'P'
			});
			editIndex = $('#materialListID').datagrid('getRows').length - 1;

			$('#materialListID').datagrid('selectRow', editIndex).datagrid(
					'beginEdit', editIndex);
		}
		//是否编辑结束
		function endEditing() {
			if (editIndex == undefined) {
				return true;
			}
			if ($('#materialListID').datagrid('validateRow', editIndex)) {
				$('#materialListID').datagrid('endEdit', editIndex);
				editIndex = undefined;
				return true;
			} else {
				return false;
			}
		}

		function onClickCell(index, field) {
			$('#materialListID').datagrid('selectRow', index);
			if (endEditing()) {
				$(this).datagrid('beginEdit', index);
			}
		}

		//撤销新增行
		function reject() {

			$(materialListID).datagrid('rejectChanges');
			editIndex = undefined;

		}

		//取消
		function btnCancel() {
			location.href = "proSchConList.do?";
		}

	</script>
</body>
</html>