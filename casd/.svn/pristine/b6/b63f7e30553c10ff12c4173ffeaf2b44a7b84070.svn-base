<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="PowerCheck" prefix="shop"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>首页</title>
<jsp:include page="../common/css.jsp"></jsp:include>
<link
	href="<%=request.getContextPath()%>/res/jquery-easyui/themes/default/easyui.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/res/admin/css/icon.css"
	rel="stylesheet" type="text/css" />

<script
	src="<%=request.getContextPath()%>/res/jquery-easyui/jquery.min.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/res/jquery-easyui/jquery.easyui.min.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/res/admin/scripts/jquery-easyui/locale/easyui-lang-zh_CN.js"
	type="text/javascript"></script>

</head>
<body>

	<div>
	      <div calss="taskhendr">
	         <input type="hidden" id="taskid" value="${taskid}">
			 <input type="hidden" id="taskName" value="${taskName}">
			 <input type="hidden" id="apply_userId" value="${userid}">
		 </div>
	<fieldset id="fd1" style="width:880px;">
			<legend>
				<span>变更信息</span>
			</legend>
		<div class="fieldset-body">
				<form id="jvForm" method="post">
					<table class="form-table" border="0"  cellpadding="5"
						cellspacing="2">

						<tr>
							<td class="form-label">姓名：</td>
							<td><input type="text" 
								name="username"  style="width:300px"
								id="username" 
								value="${username}" /></td>
							<td class="form-label">所在项目：</td>
							<td style="width:150px"><input type="text" 
								value="${construct_project_name}"
								name="construct_project_name"
								id="construct_project_name" style="width:300px"/></td>
					 
						</tr>
						<tr>
							<td class="form-label">申请调动项目：</td>
							<td><input type="text" 
								value="${newProjectName}"
								name="newProjectName"
								id="newProjectName" style="width:300px"/></td>
                           	<td class="form-label">申请原因：</td>
							<td><input type="text" 
								name="suppliermod_worker_apply_reason" 
								id="suppliermod_worker_apply_reason" style="width:300px"
								value="${suppliermod_worker_apply_reason}"/>
							</td>
						</tr>
					</table>
				</form>
			</div>
       </fieldset>
         
        <div>  
        <div><h1>审核意见：</h1></div>
             <div>
			 <input class="easyui-textbox" id="options"
				data-options="multiline:true"  style="width:900px;height:60px"></input>
				</div>
			</div>
        <div style="margin: 10px"></div>
      
        <div>
        <select  id="username_id" style="width:199px;height: 25px;">
				      <option value="">请选择审批人</option>
				           <c:forEach items="${userList}" var="c">
						<option value="${c.userid}">${c.username}</option>
					</c:forEach>
				</select>
        </div>
       
         <div style="margin: 10px"></div>
         <div calss="taskroot">
         <a class="easyui-linkbutton" 
						onclick="workerApplyPass(true)" style="color: red;width: 80px;">同意</a>
		 <a class="easyui-linkbutton" 
						onclick="workerApplyPass(false)" style="color: red;width: 80px;">不同意</a>
       
       </div>
       
       <div style="margin:20px 0;">
		
	<table id="history" class="easyui-datagrid" title="审批记录"
			style="width:905px;height:150px"
			data-options="
				iconCls: 'icon-edit',
				singleSelect: true,">
			<thead>
			<tr>
				<th data-options="field:'username',width:80">审核人</th>
				<th data-options="field:'MESSAGE_',width:300">审核意见</th>
				<th data-options="field:'center_name',width:100">中心</th>
			</tr>

			</thead>
		</table>
	</div>
       
	</div>

	
	<script type="text/javascript">
	$(function(){
		//加载历史记录
		var historys = ${history}.history;
		$('#history').datagrid('loadData', historys);
		
	});
	
		//保存
		function workerApplyPass(obj) {
			var userid = $("#username_id").val();
			var taskName = $("#taskName").val(); //获取节点名称
			var options = $("#options").val();
			var taskid = $("#taskid").val();
			var apply_userId = $("#apply_userId").val();
			
			if (options == "" ||options==null) {
				$.messager.alert("提示", "请填写审核意见");
				return false;
			}
			
			if(obj){
				if(taskName !='主管公司总经理'){
			     if(userid =='' ||userid==null){
			    	
			    	 $.messager.alert("提示", "请选择审核人");
			    		return;
			    	 }
			      }
				}
			$.messager.confirm('提示！','你确定提交吗？', function(r) {
				if (r) {
					$.ajax({
						type : 'POST',
						url : 'workerApplyPass.do',
		
						data : {
							'options' : options,
							'username' : userid,
							'taskName' : taskName,
							'taskid' : taskid,
							'obj':obj,
							'apply_userId':apply_userId
		
						},
				success : function(data) {

					if (data.Success) {

						$.messager.alert("提示", data.Msg,"info", function() {
							location.href = "findTaskList.do";
						});
					} else {

						$.messager.alert("操作提示", data.Msg, "error");
					}

				}

			});}
				});
		}

		
	
	</script>
</body>
</html>