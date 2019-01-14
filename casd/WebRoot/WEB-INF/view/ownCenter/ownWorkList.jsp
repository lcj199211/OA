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
	
<script
	src="<%=request.getContextPath()%>/res/admin/scripts/jquery.ajaxfileupload.js"
	type="text/javascript"></script>
</style>
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
							
							<!-- <li><label>申请时间：</label><input class="easyui-datebox" id="start_time"
									name="start_time" style="width: 90px" /> 至 <input
									class="easyui-datebox" name="end_time"
									id="end_time" style="width: 90px"></li> -->
							<li style="display: none"><label>我的待办：</label><input type="text" name="user_own" id="user_own" value="${userName}"
									class="easyui-validatebox" style="width: 120px" /></li>
							<li style="display: none"><label>已完成的任务：</label><input type="text" name="user_finish" id="user_finish"
									class="easyui-validatebox" style="width: 120px" /></li>
							<li style="display: none"><label>我的创建：</label><input type="text" name="user_creat" id="user_creat"
									class="easyui-validatebox" style="width: 120px" /></li>
												
							<li style="display: none">&nbsp;&nbsp; <a class="easyui-linkbutton"
								data-options="iconCls:'icon-search'" href="javascript:;"
								id="btnSearch">查询</a></li>
							<shop:permission code="Work_Ctrl">
							<li>&nbsp;&nbsp; <a class="easyui-linkbutton"
								data-options="iconCls:'icon-add'" href="javascript:;" onclick="btn_add();"
								id="btn_add">新增</a></li>
							<li>&nbsp;&nbsp; <a class="easyui-linkbutton"
								data-options="iconCls:'icon-edit'" href="javascript:;" onclick="btn_update();"
								id="btn_update">修改添加</a></li>
							<li>&nbsp;&nbsp; <a class="easyui-linkbutton"
								data-options="iconCls:'icon-cut'" href="javascript:;" onclick="btnDele();"
								id="btnDele">删除</a></li>	
							</shop:permission>
							<li> <a href="#" class="easyui-linkbutton"
									 onclick="btnUser('own');">我的待办 <span style="color:red">${dealtCount}</span></a></li>
							<li> <a href="#" class="easyui-linkbutton"
									 onclick="btnUser('finish');">已完成的任务 <span style="color:red">${finishCount}</span></a></li>
							<li> <a href="#" class="easyui-linkbutton"
									 onclick="btnUser('creat');">我的创建 <span style="color:red">${creatCount}</span></a></li>
							
										
						</ul>
						<div class="clear"></div>
						<!-- <div>
							<ul>
								<li> <a href="#" class="easyui-linkbutton"
									 onclick="btnUser('own');">我的待办</a></li>
							</ul>
							<ul>
								<li> <a href="#" class="easyui-linkbutton"
									 onclick="btnUser('finish');">已完成的任务</a></li>
							</ul>
							<ul>
								<li> <a href="#" class="easyui-linkbutton"
									 onclick="btnUser('creat');">我的创建</a></li>
							</ul>
							
						</div> -->
						<div class="clear"></div>
					</div>
				</div>
			</div>


				<div region="center" split="false" border="false"
					style="overflow: hidden; padding: 0 5px 5px 5px" >
					<table id="data" title="" fit="true"
						data-options="collapsible: true,pagination:true,rownumbers:true,showFooter:true,onClickCell:onClickCell">
						<thead>
							<tr>
								<th halign="center" field="own_workArranged_categoryId" align="center"  hidden="hidden"
									sortable="true" width="60px">单据id</th>
								<th halign="center" field="own_workArranged_id" align="center"  hidden="hidden"
									sortable="true" width="60px">分录id</th>	
								<th halign="center" field="own_workArrangHead_category" align="center"
									sortable="true" width="80px">工作分类</th>
								<th halign="center" field="own_workArranged_content" align="center"
									sortable="true" width="150px">工作内容</th>
								<th halign="center" field="arranger" align="center" 
									sortable="true" width="80px" >指令</th>
								<th halign="center" field="sponsor" align="center" 
									sortable="true" width="80px" >主办</th>
								<th halign="center" field="coordinator" align="center" 
									sortable="true" width="80px" >协办</th>
								<th halign="center" field="own_workArranged_current" align="center" 
									sortable="true" width="120px" >目前情况</th>
								<th halign="center" field="own_workArranged_feedback" align="center" 
									sortable="true" width="120px" >问题反馈</th>	
								<th halign="center" field="own_workArranged_assist" align="center" 
									sortable="true" width="120px" >协助备注</th>
								<th halign="center" field="own_workArranged_creatTime" align="center" 
									sortable="true" width="80px" >创建时间</th>		
								<th halign="center" field="own_workArranged_planTime" align="center" 
									sortable="true" width="80px" >计划时间要求</th>	
								<th halign="center" field="own_workArranged_finishTime" align="center" 
									sortable="true" width="80px" >实际完成时间</th>
								<th halign="center" field="own_workArranged_status" align="center" 
									sortable="true" width="80px" formatter="status_formatter" >任务状态</th>
									
								<th halign="center" field="own_workArranged_finishQua" align="center" 
									sortable="true" width="80px" formatter="finishQua_formatter" >完成情况</th>
								<th halign="center" field="own_workArranged_remarks" align="center" 
									sortable="true" width="100px" >备注</th>
								<shop:permission code="Work_Finish">
																	
								<th halign="center" field="psn1" align="center" sortable="true"
									width="100px" formatter="operate_formatter1">操作1</th>
								<th halign="center" field="psn2" align="center" sortable="true"
									width="100px" formatter="operate_formatter2">操作2</th>
								<th halign="center" field="psn3" align="center" sortable="true"
									width="100px" formatter="operate_formatter3">操作3</th>
								</shop:permission>	
								<shop:permission code="Work_Qua">	
								<th halign="center" field="psn4" align="center" sortable="true"
									width="120px" formatter="operate_formatter4">操作4</th>
								</shop:permission>				
							</tr>
						</thead>
					</table>
				</div>
				
				<div id="updateWork" class="easyui-window"
						data-options="region:'center',title:'更新'" closed="true"
						style="height: auto; width: 420px">
						<div class="easyui-panel"  style="width:400px">
							<div style="padding:10px 60px 20px 60px">
							<form id="workData" method="post">
								<table cellpadding="5">
									<tr style="display: none">
										<td>分录id:</td>
										<td><input  type="text"
											id="own_workArranged_id" name="own_workArranged_id" ></input></td>
									</tr>
									<tr id="finish">
										<td>实际完成时间:</td>
										<td><input  type="text" class="easyui-datebox"
											id="own_workArranged_finishTime" name="own_workArranged_finishTime" ></input></td>
										<td style="display: none">状态:</td>
										<td style="display: none"><input  type="text"
											id="own_workArranged_status" name="own_workArranged_status" ></input></td>
									</tr>
									<tr id="coor" >
										<td class="form-label" style="width:110px;"><a
										href="javascript:void(0)" onclick="wen('userListCheck.do?index=0')">协助人(选择):</a>
										</td>
										<td><input  type="text"
											id="username" name="username" ></input></td>
										<td style="display: none"><input  type="text" 
											id="own_workArranged_coordinator" name="own_workArranged_coordinator" ></input></td>	
									</tr>
									<tr id="coor2">
										<td>协助备注:</td>
										<td><input  type="text" name="own_workArranged_assist" id="own_workArranged_assist"></input></td>
									</tr>
									<tr id="feedback">
										<td>问题反馈:</td>
										<td><input  type="text" name="own_workArranged_feedback" id="own_workArranged_feedback"></input></td>
									</tr>
									<tr id="completion">
									<td>完成情况:</td>
									<td><select class="easyui-combobox" style="width:124px;"
											id="own_workArranged_finishQua" name="own_workArranged_finishQua">
												<option value="0"></option>
												<option value="1">A</option>
												<option value="2">B</option>										
												<option value="3">C</option>
										</select></td>
									</tr>
								</table>
						</form>
						<div style="text-align:center;padding:5px">
							<a href="javascript:void(0)" class="easyui-linkbutton"
								onclick="submitWages()">更新</a> 
						</div>
					</div>
				</div>
				
			</div>
				
			<div  id="win" class="easyui-window" data-options="region:'center',title:'请选择值'" closed="true" style="height: 500px; width: 800px" >    
			</div>	
			</div>
		</div>

	<script type="text/javascript">
		var user=${userName};
		function operate_formatter1(value, row, index) {
			if(value!='foot'){
			var html = "";
			html += '<a href="#"  class="easyui-linkbutton" >完成</a>';
			return html;
			}
		}
		function operate_formatter2(value, row, index) {
			if(value!='foot'){
			var html = "";
			html += '<a href="#"  class="easyui-linkbutton" >协助指派</a>';
			
			return html;
			}
		}
		function operate_formatter3(value, row, index) {
			if(value!='foot'){
			var html = "";
			html += '<a href="#"  class="easyui-linkbutton" >反馈</a>';
			return html;
			}
		}
		
		function operate_formatter4(value, row, index) {
			if(value!='foot'){
			var html = "";
			html += '<a href="#"  class="easyui-linkbutton" >完成情况</a>';
			return html;
			}
		}
		
		function overdue(row){
			var now_timestamp = parseInt(new Date().getTime()/1000);    // 当前时间戳
			var date = row.own_workArranged_planTime;
			date = date.substring(0,19);    
			date = date.replace(/-/g,'/'); 
			var timestamp =parseInt( new Date(date).getTime()/1000);
			if(now_timestamp>timestamp){
				return '<span style="color:red" >任务延期</span>';
			}else{
				return "任务发出";
			}
		}
		
		
		function finishQua_formatter(value, row, index) {
			if(value==0){
				return "";
			}else if(value==1){
				return "A";
			}else if(value==2){
				return "B";
			}else if(value==3){
				return "C";
			}
		}
		
		function status_formatter(value, row, index) {
			if(value==0){
				return overdue(row);
			}else if(value==1){
				return "任务完成";
			}
		}
		
		//选择子页面信息	
		function wen(src) {
		    var hrefs = "<iframe id='son' src='"
			+ src
			+ "' allowTransparency='true' style='border:0;width:99%;height:99%;padding-left:2px;' frameBorder='0'></iframe>";
			$("#win").html(hrefs);
			$("#win").window("open");
		}
		
		function pryData(data, index) {
			$("#own_workArranged_coordinator").val(data.userid);
			$("#username").val(data.username);
		}
		
		
		
		function btnUser(obj){
			if(obj==='own'){
				$("#user_finish").val("");
				$("#user_creat").val("");
				$("#user_own").val("'"+user+"'");
			}else if(obj==='finish'){
				$("#user_creat").val("");
				$("#user_own").val("");
				$("#user_finish").val(user);
			}else if(obj==='creat'){
				$("#user_own").val("");
				$("#user_finish").val("");
				$("#user_creat").val(user);
			}
			
			//IE
			if (document.all) {
				document.getElementById("btnSearch").click();
			}
			// 其它浏览器
			else {
				var e = document.createEvent("MouseEvents");
				e.initEvent("click", true, true); //这里的click可以换成你想触发的行为
				document.getElementById("btnSearch").dispatchEvent(e); //这里的clickME可以换成你想触发行为的DOM结点
			}
		}
		
		
		
		function btn_add() {
			location.href = "ownWorkNew.do";
		}
		
		function btn_update() {
			var rows = $("#data").datagrid("getSelections");
			if(rows.length==0){
				alert("请选择要修改行！");
			}else if(rows.length>1){
				alert("只能选中一行！");
			}else{
				location.href = "ownWorkNew.do?own_workArranged_categoryId="+rows[0].own_workArranged_categoryId+"&type='update'";
			}
		}
		
		function submitWages(){
			$.post("update_work.do", $("#workData").serialize(), function(data) {
				if (data == "") {
					alert("操作成功");
					location.reload(true);
				} else {
					alert("操作失败");
				}
			});
		}
		
		
		
		function onClickCell(rowIndex, field, value){
			if(field==="psn1"||field==="psn2"||field==="psn3"||field==="psn4"){
				var row = $('#data').datagrid("selectRow", rowIndex).datagrid("getSelected");
				$("#own_workArranged_id").val(row.own_workArranged_id);
				$("#own_workArranged_status").val(row.own_workArranged_status);
				$("#own_workArranged_coordinator").val(row.own_workArranged_coordinator);

	        	$.messager.confirm('提示！', '你确定执行此操作吗？', function(r) {
					if(field==="psn1"){
						document.getElementById("coor").style.display = "none";
						document.getElementById("coor2").style.display = "none";
						document.getElementById("feedback").style.display = "none";
						document.getElementById("completion").style.display = "none";
						$("#own_workArranged_status").val(1);
						document.getElementById("finish").style.display = "";
						$("#updateWork").window("open");
					}else if(field==="psn2"){
						document.getElementById("feedback").style.display = "none";
						document.getElementById("finish").style.display = "none";
						document.getElementById("completion").style.display = "none";

						document.getElementById("coor").style.display = "";
						document.getElementById("coor2").style.display = "";
						$("#updateWork").window("open");
					}else if(field==="psn3"){
						document.getElementById("coor").style.display = "none";
						document.getElementById("coor2").style.display = "none";
						document.getElementById("finish").style.display = "none";
						document.getElementById("completion").style.display = "none";

						document.getElementById("feedback").style.display = "";

						$("#updateWork").window("open");
					}else if(field==="psn4"){
						document.getElementById("coor").style.display = "none";
						document.getElementById("coor2").style.display = "none";
						document.getElementById("finish").style.display = "none";
						document.getElementById("feedback").style.display = "none";
						document.getElementById("completion").style.display = "";

						$("#updateWork").window("open");
					}
					
	        	});
			}
		}
		//删除处理
		function btnDele() {
			var rows = $("#data").datagrid("getSelections");
			if(rows.length==0){
				alert("请选择要删除行！");
			}else if(rows.length>1){
				alert("只能选中一行！");
			}else{
				var own_workArranged_categoryId = rows[0].own_workArranged_categoryId;
				$.messager.confirm("操作提示", "您确定要执行操作吗？", function(r) {
					if (r) {
						$.ajax({
							type : 'POST',
							url : 'delete_workerHead.do',
							data : {
								'own_workArranged_categoryId' : own_workArranged_categoryId
							},
							success : function(data) {
								if (!data.success) {
									  $.messager.alert("操作提示", data.msg,"error");
								} else {
									 $.messager.alert("操作提示","操作成功！");
									 $('#data').datagrid('reload');
								}
								}
						});
					}
				});
		    }
		}
		
		
		
		
		 $(function() {
			$("#data").admin_grid({
				queryBtn : "#btnSearch",
				excelBtn : "#btnExcel",
				onLoadSuccess: function(data){
					var mark=1;
					for (var i=1; i <data.rows.length; i++) {
						if (data.rows[i]['own_workArrangHead_category'] == data.rows[i-1]['own_workArrangHead_category']) {
							mark += 1;
							$(this).datagrid('mergeCells',{ 
								index: i+1-mark, 
								field: 'own_workArrangHead_category',
								rowspan:mark
							});
						}else{
							mark=1;     
						}
					}
				}
			});
		}); 
		
	</script>

</body>
</html>