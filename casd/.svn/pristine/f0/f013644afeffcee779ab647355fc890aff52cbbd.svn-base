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

	<div style="margin:20px 0;"></div>

	<table id="cont" class="easyui-datagrid" title="评分内容" toolbar="#tb"
		style="width:900px;height:auto"
		data-options="
				iconCls: 'icon-edit',
				singleSelect: true,
				onClickCell: onClickCell
				">

		<thead>
			<tr>
				<th
					data-options="field:'assess_id',width:80,hidden:'hidden',editor:'text'">Item
					ID</th>
				<th data-options="field:'assess_category',width:80,align:'right',editor:{type:'text',options:{required:true}}">分类</th>
				<th data-options="field:'assess_content',width:150,align:'right',editor:{type:'text',options:{required:true}}">评估内容</th>
 				<th data-options="field:'assess_grade',width:80,align:'right',editor:{type:'text',options:{required:true}}">内容项总分</th>
				<th data-options="field:'assess_deduct',width:150,align:'right',editor:{type:'text',options:{required:true}}">扣分情况</th>
				<th
					data-options="field:'assess_entry_score',width:80,align:'right',editor:{type:'text',options:{required:true}}">得分</th>

			</tr>

		</thead>


	</table>
	<div id="tb" style="height:auto">
						<a href="javascript:void(0)" class="easyui-linkbutton"
							 onclick="add()">添加</a>
						<a href="javascript:void(0)" class="easyui-linkbutton"
							onclick="removeit()">删除</a> 
							<a href="javascript:void(0)"
							class="easyui-linkbutton"
							 onclick="reject()">撤销修改</a>
					</div>

	<br />
	<br />
	<br />
	<div style="text-align:center">
		<tr>
			<td style="align:center"><a class="easyui-linkbutton"
				href="javascript:;" id="btnSave" onclick="btnSave()">提交</a>
				&nbsp;&nbsp;&nbsp;&nbsp; <a class="easyui-linkbutton"
				href="javascript:;" id="btnCancel" onclick="btnCancel()">取消</a></td>
		</tr>
	</div>

	<script type="text/javascript">
		var editIndex = undefined;

		$(function() {
			
			//加载数据
			var rows = ${rows}.rows;
			$('#cont').datagrid('loadData', rows);
			
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
		
		function btnSave() {
			var rows=null;
				if (endEditing()){
					$('#cont').datagrid('acceptChanges');
					 rows=$('#cont').datagrid('getRows');
				}
					$.ajax({
						type : 'POST',
						url :'saveCont.do',
							data:{ 'rows':JSON.stringify(rows)
						},
						success : function(data){
							alert("保存成功");
							location.reload(true);
						}});
		}
		
		
		function removeit(){
			var rows=null;
			var ids = [];
			 	rows = $("#cont").datagrid("getSelections");//获取表格数据
				if(rows.length==0){
					alert("请选择需要删除的行");
					return null;
				}
				for (var i = 0; i < rows.length; i++) {
					ids.push(rows[i].assess_id);
				} 
			$.ajax({
				type : 'POST',
				url :"delectCont.do",
				data :{'cid':JSON.stringify(ids),
				},
				success : function(data){
					if(data==""){
					alert("删除成功");
					location.reload(true);
					}
				}
			});
		}
		
		
		//取消
		function btnCancel() {
			location.href="assessList.do";
		}
		
		
		//新增行
		function add(){
			if (endEditing()){
				$('#cont').datagrid('appendRow',{statu:'P'});
				editIndex = $('#cont').datagrid('getRows').length-1;
				
				$('#cont').datagrid('selectRow', editIndex)
						.datagrid('beginEdit', editIndex);
			}
		}
		//是否编辑结束
		function endEditing(){
			if (editIndex == undefined){return true}
			if ($('#cont').datagrid('validateRow', editIndex)){
				$('#cont').datagrid('endEdit', editIndex);
				editIndex = undefined;
				return true;
			} else {
				return false;
			}
		}
		function onClickCell(index, field){
			
			if (endEditing()){
				$("#cont").datagrid('selectRow', index)
						.datagrid('editCell', {index:index,field:field});
				editIndex = index;
			}
		}
		//撤销新增行
		function reject(){
			$('#cont').datagrid('rejectChanges');
			editIndex = undefined;
		}
		
	</script>
</body>
</html>