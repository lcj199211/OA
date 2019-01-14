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
							
							<li><label>姓名：</label><input class="easyui-validatebox" id="userName"
									name="userName" style="width: 90px" /> 
							<li style="display: none"><label>公司名称：</label><input type="text"
								name="company" id="company"
								class="easyui-validatebox" style="width: 120px" /></li>
												
							<li >&nbsp;&nbsp; <a class="easyui-linkbutton"
								data-options="iconCls:'icon-search'" href="javascript:;"
								id="btnSearch">查询</a></li>
							<li >&nbsp;&nbsp; <a class="easyui-linkbutton"
								data-options="iconCls:'icon-reload'" href="javascript:;" onclick="reload();"
								id="btnReload">刷新</a></li>
										
						</ul>
						<div class="clear"></div>
						<div>
							<ul>
								<li> <a href="#" class="easyui-linkbutton"
									 onclick="btnUser('builder');">建设公司</a></li>
							</ul>
							<ul>
								<li> <a href="#" class="easyui-linkbutton"
									 onclick="btnUser('science');">科技公司</a></li>
							</ul>
							<ul>
								<li> <a href="#" class="easyui-linkbutton"
									 onclick="btnUser('education');">教育公司</a></li>
							</ul>
							<ul>
								<li> <a href="#" class="easyui-linkbutton"
									 onclick="btnUser('manage');">传诚管理</a></li>
							</ul>
							
						</div>
						<div class="clear"></div>
					</div>
				</div>
			</div>


				<div region="center" split="false" border="false"
					style="overflow: hidden; padding: 0 5px 5px 5px" >
					<table id="data" title="" fit="true"
						data-options="collapsible: true,pagination:true,rownumbers:true,showFooter:true">
						<thead>
							<tr>
								<th halign="center" field="own_workArranged_categoryId" align="center"  hidden="hidden"
									sortable="true" width="60px">单据id</th>
								<th halign="center" field="own_workArranged_id" align="center"  hidden="hidden"
									sortable="true" width="60px">分录id</th>
								<th halign="center" field="company_name" align="center" hidden="hidden"
									sortable="true" width="80px">公司</th>
								<th halign="center" field="center_name" align="center" hidden="hidden"
									sortable="true" width="80px">中心</th>
								<th halign="center" field="sponsor" align="center" 
									sortable="true" width="80px" >主办</th>	
								<th halign="center" field="own_workArrangHead_category" align="center"
									sortable="true" width="80px">工作分类</th>
								<th halign="center" field="own_workArranged_content" align="center"
									sortable="true" width="150px">工作内容</th>
								<th halign="center" field="arranger" align="center" 
									sortable="true" width="80px" >指令</th>
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
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>

	<script type="text/javascript">
		
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
				return '<span style="color:#0190a0" >任务完成</span>';
			}
		}
		
		function reload(){
			window.location.reload();
		}
		
		function btnUser(obj){
			
			
			if(obj==='builder'){
				$("#company").val("诚安建设（6）");
			}else if(obj==='science'){
				$("#company").val("诚安科技（3）");
			}else if(obj==='education'){
				$("#company").val("传诚教育（5）");
			} else if(obj==='manage'){
				$("#company").val("传诚管理（2）");
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
		
		
		$(function() {
			$("#data").admin_grid({
				queryBtn : "#btnSearch",
				excelBtn : "#btnExcel",
				onLoadSuccess: function(data){
					var mark=1;
					for (var i=1; i <data.rows.length; i++) {
						if (data.rows[i]['sponsor'] == data.rows[i-1]['sponsor']) {
							mark += 1;
							$(this).datagrid('mergeCells',{ 
								index: i+1-mark, 
								field: 'sponsor',
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