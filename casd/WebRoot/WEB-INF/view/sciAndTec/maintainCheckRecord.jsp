<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="PowerCheck" prefix="shop"%>
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
		<div id="main" region="center"
			style="background: #eee; padding: 5px; overflow-y: hidden;">


			<div class="easyui-layout" fit="true">
				<div region="north" split="false" border="false"
					style="overflow: hidden; padding: 5px 5px 28px 5px;">
					<div class="easyui-panel" title="查询条件" style="margin-bottom: 5px;">

						<div class="search">
							<ul>
								<li><label>系统：</label><input type="text" name="maintain_checkPro_name" id="maintain_checkPro_name"
									class="easyui-validatebox" style="width: 120px" /></li>
								<li>&nbsp;&nbsp; <a class="easyui-linkbutton"
									data-options="iconCls:'icon-search'" href="javascript:;"
									id="btnSearch">查询</a></li>
								<!--  <li>&nbsp;&nbsp; <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true"
									onclick="btnDele();">删除</a></li> --> 
									<%-- <shop:permission code="ADD_PROJECT_AP"> --%>
									<li>&nbsp;&nbsp; <a href="#" class="easyui-linkbutton" iconCls="icon-edit"
									plain="true" onclick="btnUpdate();">修改</a></li>
								<!-- <li>&nbsp;&nbsp; <a href="#" class="easyui-linkbutton" iconCls="icon-add"
									plain="true" onclick="btnAdd();">新增</a></li> -->
								<%-- </shop:permission> --%>
								<!-- <li>&nbsp;&nbsp; <a href="#" class="easyui-linkbutton" iconCls="icon-search"
									plain="true" onclick="btnView();">查看</a></li> -->
							</ul>
							<div class="clear"></div>
						</div>
					</div>
				</div>
				
				<div region="center" split="false" border="false"
					style="overflow: hidden; padding: 0 5px 5px 5px" id="dataList">
					<table id="data" title="" fit="true"
						data-options="collapsible: true,pagination:true,rownumbers:true">
						<thead>
							<tr>
								<th halign="center" field="maintain_checkRecord_entry_id" align="center" hidden="hidden"
									sortable="true" width="60px">编号</th>
								<th halign="center" field="maintain_checkRecord_entry_system" align="center"
									sortable="true" width="200px">系统</th>
								
								<th halign="center" field="maintain_checkRecord_entry_content" align="center"
									sortable="true" width="400px">明细</th>
								<th halign="center" field="maintain_checkRecord_entry_status" align="center"
									sortable="true" width="120px" formatter="status_formatter">运行状态</th>
								<th halign="center" field="maintain_checkRecord_entry_describe" align="center"
									sortable="true" width="120px">故障描述</th>
								<th halign="center" field="maintain_checkRecord_entry_handle" align="center"
									sortable="true" width="120px" formatter="handle_formatter">处理记录</th>
								<th halign="center" field="maintain_checkRecord_entry_reasonNoHandle" align="center"
									sortable="true" width="120px" formatter="noHandle_formatter">未处理原因</th>			
							</tr>
						</thead>
					</table>
				</div>
				
				
				<div id="win" class="easyui-window"
						data-options="region:'center',title:'请选择'" closed="true"
						style="height: auto; width: 420px">
						<div class="easyui-panel"  style="width:400px">
							<div style="padding:10px 60px 20px 60px">
							<form id="entry" method="post">
								<table cellpadding="5">
									<tr>
										<td>运行状态:</td>
										<td><select id="maintain_checkRecord_entry_status" name="maintain_checkRecord_entry_status" style="width:142px;">
												<!-- <option value="1">正常</option> -->
												<option value="2" selected="selected">不正常</option>
										</select></td>
									</tr>	
									<tr>		
										<td>故障描述:</td>
										<td><input   type="text"
											id="maintain_checkRecord_entry_describe" name="maintain_checkRecord_entry_describe" ></input></td>
									</tr>	
									<tr>	
										<td>处理记录:</td>
										<td><select id="maintain_checkRecord_entry_handle" name="maintain_checkRecord_entry_handle" style="width:142px;">
												<option value="1">已处理</option>
												<option value="2">未处理</option>
										</select></td>		
									</tr>	
									<tr>	
										<td>未处理原因:</td>
										<td><select id="maintain_checkRecord_entry_reasonNoHandle" name="maintain_checkRecord_entry_reasonNoHandle" style="width:142px;">
												<option value="1" selected="selected"></option>
												<option value="2">无配件设备</option>
												<option value="3">其他原因</option>
										</select></td>
										
												
									</tr>
									<tr style="display: none">
										<td>id:</td>
										<td><input class="easyui-textbox" type="text"  name="maintain_checkRecord_entry_id" id="maintain_checkRecord_entry_id"></input></td>
									</tr>
								</table>
							</form>


						<div style="text-align:center;padding:5px">
							<a href="javascript:void(0)" class="easyui-linkbutton"
								onclick="submitForm()">确定</a> 
						</div>
					</div>


				</div>
			</div>
				
			</div>
		</div>





	<script type="text/javascript">
		function operate_formatter(value, row, index) {
			/* var html = "";

			html += '<a href="javascript:;" class="opt"    cmd="taskList" i="' + index + '">项目作业</a>';

			return html; */
		}

		//新增
		function btnAdd() {
			location.href = "maintainCheckContent.do?maintain_checkPro_id=";
		}
		
		
		function status_formatter(value, row, index){
			if(value==1){
				return "正常";
			}else{
				return "不正常";
			}
		}	
		
		function noHandle_formatter(value, row, index){
			if(value==1){
				return "";
			}else if(value==2){
				return "无配件设备";
			}else if(value==3){
				return "其他原因";
			}
		}	
	
		function handle_formatter(value, row, index){
			if(value==1){
				return "已处理";
			}else if(value==2){
				return "未处理";
			}
		}	
		
		
		 
		function btnView() {
			var rows = $("#data").datagrid("getSelections");
			if (rows.length == 0) {
				alert("请选择需要查看的行");
				return null;
			}
			if (rows.length > 1) {
				alert("不能选择多行喔");
				return null;
			}
			
			//location.href = "constructView.do?projectDep="+${projectDep}+"&construct_project_id="+rows[0].construct_project_id;
		}
		
		function btnUpdate(){
			var rows = $("#data").datagrid("getSelections");
			if (rows.length == 0) {
				alert("请选择需要修改的行");
				return null;
			}
			if (rows.length > 1) {
				alert("不能选择多行喔");
				return null;
			}
			
			$("#maintain_checkRecord_entry_id").val(rows[0].maintain_checkRecord_entry_id);
			$("#maintain_checkRecord_entry_reasonNoHandle").val(rows[0].maintain_checkRecord_entry_reasonNoHandle==null?1:rows[0].maintain_checkRecord_entry_reasonNoHandle);
			$("#maintain_checkRecord_entry_handle").val(rows[0].maintain_checkRecord_entry_handle==null?1:rows[0].maintain_checkRecord_entry_handle);
			$("#maintain_checkRecord_entry_describe").val(rows[0].maintain_checkRecord_entry_describe);

			$("#win").window("open");
		}
		
		function submitForm(){
			$.messager.confirm('提示！', '你确定提交吗？', function(r) {
				if (r) {	
				$.post("update_record.do",$("#entry").serialize(),function(data) {
					if (data.Success) {
						$.messager.alert("提示", "修改成功","info", function() {
							 location.reload(true);
								});
				      	}else {
						$.messager.alert("提示", data.Msg,
								"error");
					}
							
				
				}); 	
			}});
		}

		/***处理操作列的功能***/
		function cmdHanlder(cmd, row) {
			if (cmd == "taskList") {
				
				location.href = "taskList.do?" + $.param({
					'construct_project_id' : row.construct_project_id, //传参项目部编号
				});

			}
		}

		//批量删除处理
		function btnDele() {
			var rows = $("#data").datagrid("getSelections");//获取表格数据
			if (rows.length == 0) {
				alert("请选择需要删除的行");
				return null;
			}
			if (rows.length > 1) {
				alert("不可选择多行");
				return null;
			}
			$.messager.confirm("操作提示", "您确定要执行操作吗？", function(r) {
				if (r) {
					$.ajax({
						type : 'POST',
						url : 'dele_checkPro.do',
						traditional : true,
						data : {
							'ids' : rows[0].maintain_checkPro_id
						},
						success : function(data) {
							if (data.msg != undefined) {
								//$.messager.alert("提示", data.msg, "error");
								location.reload();
							} else {
								//$.messager.alert("提示", "操作成功！");
								location.reload();
							}
						}
					});
				}
			});
		};
		
		
		$(function() {
			$("#data").admin_grid({
				queryBtn : "#btnSearch",
				excelBtn : "#btnExcel",
				cmdHanlder : cmdHanlder,
				onLoadSuccess: function(data){
					var mark=1;
					for (var i=1; i <data.rows.length; i++) {
						if (data.rows[i]['maintain_checkRecord_entry_system'] == data.rows[i-1]['maintain_checkRecord_entry_system']) {
							mark += 1;
							$(this).datagrid('mergeCells',{ 
								index: i+1-mark, 
								field: 'maintain_checkRecord_entry_system',
								rowspan:mark
							});
						}else{
							mark=1;     
						}
					}
					
				},
			});

		});
	</script>

</body>
</html>