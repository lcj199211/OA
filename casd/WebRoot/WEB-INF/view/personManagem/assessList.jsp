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

</head>
<body class="easyui-layout" style="overflow-y: hidden;" scroll="no">
	<form id="form1" method="post">
		<input type="hidden" name="userid" value="${param.userid}">
		<div id="main" region="center"
			style="background: #eee; padding: 5px; overflow-y: hidden;">


			<div class="easyui-layout" fit="true">
				<div region="north" split="false" border="false"
					style="overflow: hidden; padding: 5px 5px 28px 5px;">
					<div class="easyui-panel" title="绩效考核记录"
						style="margin-bottom: 5px;">

						<div class="search">

							<ul>
								<li><label>评估时间：</label><input class="easyui-datebox"
									id="start_time" name="start_time" style="width: 90px" /> 至 <input
									class="easyui-datebox" name="end_time" id="end_time"
									style="width: 90px"></li>
								<li>&nbsp;&nbsp; <a class="easyui-linkbutton"
									data-options="iconCls:'icon-search'" href="javascript:;"
									id="btnSearch">查询</a></li>
								<li>&nbsp;&nbsp; <a href="#" class="easyui-linkbutton"
									id="start" onclick="start();">一键启动评估</a></li>
								<li>&nbsp;&nbsp; <a href="#" class="easyui-linkbutton"
									id="stop" onclick="stop();">一键停止评估</a></li>
								<li>&nbsp;&nbsp; <a href="#" class="easyui-linkbutton"
									onclick="updateEva();">修改评估人</a></li>
								<li>&nbsp;&nbsp; <a href="#" class="easyui-linkbutton"
									onclick="updateCon();">修改评估内容项</a></li>
								<li>&nbsp;&nbsp; <a href="#" class="easyui-linkbutton"
									onclick="delectData();">删除</a></li>	
							</ul>
							<div class="clear"></div>
						</div>
					</div>
				</div>

<
				<div region="center" split="false" border="false"
					style="overflow: hidden; padding: 0 5px 5px 5px" id="dataList">
					<table id="data" title="" fit="true"
						data-options="collapsible: true,pagination:true,rownumbers:true">
						<tr>
							<td><input type="hidden" name="trade_id" value="" /></td>
						</tr>
						<thead>
							<tr>
								<th id="ds" halign="center" field="assess_head_id"
									align="center" sortable="true" width="60px"
									style="display: none">评估考核id</th>
								<th halign="center" field="assess_head_name" align="center"
									sortable="true" width="120px">姓名</th>
								<th halign="center" field="assess_head_department"
									align="center" sortable="true" width="120px">部门</th>
								<th halign="center" field="assess_head_position" align="center"
									sortable="true" width="120px">职位</th>
								<th halign="center" field="assess_head_company" align="center"
									sortable="true" width="120px">公司</th>
								<th halign="center" field="assess_head_creatdate" align="center"
									sortable="true" width="120px" formatter="dateformat">评估时间</th>
								<th halign="center" field="assess_head_totalscore"
									align="center" sortable="true" width="120px">总分</th>
								<th halign="center" field="assess_head_evaluator" align="center"
									sortable="true" width="120px">评估人</th>
								<th halign="center" field="psn" align="center" sortable="true"
									width="120px" formatter="operate_formatter">操作</th>
							</tr>
						</thead>

					</table>
				</div>


				<div id="eva" class="easyui-window" title="修改评估人" closed="true"
					style="width:600px;height:400px;padding:5px;">

					<table id="evaTable" class="easyui-datagrid" 
						toolbar="#tb" style="width:575px;height:auto"
						data-options="
				iconCls: 'icon-edit',
				singleSelect: true,
				onClickCell: onClickCell
				">
						<thead>
							<tr>
								<th 
								data-options="field:'evaluator_id',width:80,hidden:'hidden',editor:'text'">ItemID</th>
								<th
									data-options="field:'evaluator',width:80,align:'right' ">评估人</th>
								<th id="status" 
								formatter="statusformat"	data-options="field:'status',width:80,align:'right',
								editor:{ type:'combobox',options:{data:[{'value':1,'text':'可用'},{'value':2,'text':'禁用'}], valueField: 'value', textField: 'text' }}">状态</th> 
							</tr>
						</thead>
					</table>
					<div id="tb" style="height:auto">
						<a href="javascript:void(0)" class="easyui-linkbutton"
							 onclick="add()">添加</a>
						<a href="javascript:void(0)" class="easyui-linkbutton"
							onclick="removeit()">删除</a> <a href="javascript:void(0)"
							class="easyui-linkbutton"
							 onclick="reject()">撤销修改</a>
					</div>
					<br /> <br /> <br />
					<div style="text-align:center">
						<tr>
							<td style="align:center"><a class="easyui-linkbutton"
								href="javascript:;" id="btnSave" onclick="btnSaveEva()">提交</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a class="easyui-linkbutton"
								href="javascript:;" id="btnCancel" onclick="btnCancel()">取消</a></td>
						</tr>
					</div>


				</div>
			</div>
		</div>
	</form>

<div  id="win" class="easyui-window" data-options="region:'center',title:'请选择值'" closed="true" style="height: 500px; width: 800px" >    
				</div>


	<script type="text/javascript">
	var editIndex = undefined;
		function operate_formatter(value, row, index) {
			var html = "";
			html += '<a href="javascript:;" class="opt"    cmd="view" i="' + index + '">查看</a>';
			return html;
		}

		function dateformat(value, row, index) {
			if (value == undefined)
				return "";
			var unixTimestamp = new Date(value);
			return unixTimestamp.toLocaleString();
		}
		
		function statusformat(value, row, index) {
			if(value==1)
			return "可用";
			else
			return "禁用";	
		}
		
		
		/***处理操作列的功能***/
		function cmdHanlder(cmd, row) {
			if (cmd == "view") {
				location.href = "assessView.do?" + $.param({
					'id' : row.assess_head_id, //获取用户id
				});
			}
		}

		$(function() {
			$("#data").admin_grid({
				queryBtn : "#btnSearch",
				excelBtn : "#btnExcel",
				cmdHanlder : cmdHanlder,
			});
			
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

		function start() {
			if (confirm("你确定要开启评估吗？")) {
				$.ajax({
					type : 'POST',
					url : 'startAssess.do',
					success : function(data) {
						if (data == "") {
							alert("启动成功");
							location.reload(true);
						} else {
							alert("启动失败");
						}
					}
				});
			}
		}
		function stop() {
			if (confirm("你确定要停止评估吗？")) {
				$.ajax({
					type : 'POST',
					url : 'stopAssess.do',
					success : function(data) {
						if (data == "") {
							alert("停止成功");
							location.reload(true);
						} else {
							alert("停止失败");
						}
					}
				});
			}
		}
		
		//修改内容项
		function updateCon(){
			location.href = "assessContEdit.do";
		}
		
		
		
		//修改评估人
		function updateEva() {
			$.ajax({
				type : 'POST',
				url : 'initEva.do',
				success : function(data) {
					var rows=data.rows;
					$('#evaTable').datagrid('loadData',rows);
					
				}
			});
			$('#eva').window('open');
		}
		
		
		//新增行
		function add(){
			if (endEditing()){
				$('#evaTable').datagrid('appendRow',{statu:'P'});
				editIndex = $('#evaTable').datagrid('getRows').length-1;
				
				$('#evaTable').datagrid('selectRow', editIndex)
						.datagrid('beginEdit', editIndex);
			}
		}
		//是否编辑结束
		function endEditing(){
			if (editIndex == undefined){return true}
			if ($('#evaTable').datagrid('validateRow', editIndex)){
				$('#evaTable').datagrid('endEdit', editIndex);
				editIndex = undefined;
				return true;
			} else {
				return false;
			}
		}
		function onClickCell(index, field){
			if(field=="evaluator"){
				var hrefs = "<iframe id='son' src='userListCheck.do?index="+index+"' allowTransparency='true' style='border:0;width:99%;height:99%;padding-left:2px;' frameBorder='0'></iframe>";    
	            $("#win").html(hrefs); 
	            $("#win").window("open"); 
	            
			}else if (endEditing()){
				$("#evaTable").datagrid('selectRow', index)
				.datagrid('editCell', {index:index,field:field});
				editIndex = index;
			}
		}
		
		//子窗口调用
		function pryData(data,index){
			
			
			
			$('#evaTable').datagrid('acceptChanges');
			var rows=$('#evaTable').datagrid('getRows');
		 	var row = $('#evaTable').datagrid("selectRow", index).datagrid("getSelected");
			row.status = rows[index].status;
			row.evaluator = data.username;
			$('#evaTable').datagrid('refreshRow', index);	
			
		}
		
		
		//撤销新增行
		function reject(){
			$('#evaTable').datagrid('rejectChanges');
			editIndex = undefined;
		}
		
		//保存评估人
		function btnSaveEva() {
			var rows=null;
				if (endEditing()){
					//$('#eva').datagrid('acceptChanges');
					 rows=$('#evaTable').datagrid('getRows');
				}
					$.ajax({
						type : 'POST',
						url :'saveEva.do',
							data:{ 'rows':JSON.stringify(rows)
						},
						success : function(data){
							if(data==""){
								alert("保存成功");
								updateEva();
						}
						}});
		}
		
		
		function removeit(){
			var rows=null;
			var ids = [];
			 	rows = $("#evaTable").datagrid("getSelections");//获取表格数据
				if(rows.length==0){
					alert("请选择需要删除的行");
					return null;
				}
				for (var i = 0; i < rows.length; i++) {
					ids.push(rows[i].evaluator_id);
				} 
			$.ajax({
				type : 'POST',
				url :"delectEva.do",
				data :{'cid':JSON.stringify(ids),
				},
				success : function(data){
					if(data==""){
					alert("删除成功");
					updateEva();
					}
				}
			});
		}
		
		function delectData(){
			var rows=null;
			var ids = [];
			 	rows = $("#data").datagrid("getSelections");//获取表格数据
				if(rows.length==0){
					alert("请选择需要删除的行");
					return null;
				}
				for (var i = 0; i < rows.length; i++) {
					ids.push(rows[i].assess_head_id);
				} 
			$.ajax({
				type : 'POST',
				url :"delectData.do",
				data :{'cid':JSON.stringify(ids),
				},
				success : function(data){
					if(data==""){
					alert("删除成功");
					window.location.reload(true);
					}
				}
			});
		}
		
		
		function btnCancel(){
			$('#eva').window('close');
		}
		
		
	</script>

</body>
</html>