<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />

<link
	href="<%=request.getContextPath()%>/res/admin/scripts/jquery-easyui/themes/default/easyui.css"
	rel="stylesheet" type="text/css" />
<jsp:include page="../common/scripts.jsp"></jsp:include>


<style>
* {
	margin: 0;
	padding: 0
}

#tableId {
	border-collapse: collapse; /* #tableId表居中 */
	border-spacing: 0;
	margin-right: auto;
	margin-left: auto;
}

#tableId .tableIdtd {
	width: 15%;
	text-align: center;
}

#tableId textarea {
	width: 100%;
	height: 100%;
   display: inline-block;

	
	resize: none;
	ext-align: left;
	font-size: 15px;
	border: none;
}
</style>

</head>
<body>
	<div>
		<div style="margin: 20px"></div>
		<div id="tablehrend">
		<div><input type="hidden" id="taskid" value="${taskid}">
			<input type="hidden" id="taskName" value="${taskName}">
		</div> --%>
	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
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
<style type="text/css">
* {
	margin: 0;
	padding: 0
}


body {
    background:none;
    
}


* {
    font-size: 18px;
}

.right {
    text-align: left;
}

.left {
    text-align: center;
}


table {
	border-collapse: collapse;
	margin: 20px auto;
}

td {
	width: 650px;
	/* height: 50px; */
	position: relative;
	font-size: 17px;
	
}

td.left{
	width:15%;
}

td.out{

	width:15px;
	
}

td textarea {

	width: 100%;
	height: 100%;
	border: 0;
	outline: 0;
	position: absolute;
	z-index: 10;
	left: 0;
	top: 0;
	resize：none;
}
#username{
    font-size: 13px;
}
.easyui-linkbutton{
 background: #d8bfd8 !important;
 }

</style>
</head>
<body>
<div>
	  <div style="margin: 20px"></div>
	    <div>
	        <input type="hidden" id="taskid" value="${taskid}">
			<input type="hidden" id="taskName" value="${taskName}">
		</div>
	<div id="head" style="text-align: center;font-size:25px">
	<strong style="font-size: 25px !important;">费用申请表</strong>
	</div>
	<div>
	<form  id="form1"action="">
	<table border="1">
	<tr height="50px">
			<td class="left" align="center" canEdit="false"><a style="color: red;" href="javascript:void(0)" onclick="wen('orgCheck.do')">公司/部门</a></td>
			<td id="costapp_company" class="right" >${costapp_company}</td>
		<tr height="100px">
			<td class="left" align="center" canEdit="false">申请事项</td>
			<td id="costapp_appitem" class="right" >${costapp_appitem}</td>
		</tr>
		<tr height="50px">
			<td class="left" align="center" canEdit="false">申请类型</td>
			<td class="right" canEdit="select" style="text-align: left;" >
			<a style="color: red;" id="costapp_application" href="#" onclick="changeCom();" >${costapp_application}</a></td>
		</tr>
		<tr height="50px">
			<td class="left" align="center" canEdit="false">费用金额</td>
			<td id="costapp_amount" class="right" >${costapp_amount}</td>
		</tr>
		<tr height="100px">
			<td class="left" align="center" canEdit="false">主办部门意见</td>
			<td id="costapp_majoyview" class="right" >${costapp_majoyview}</td>
		</tr>
		<tr height="60px">
			<td class="left" align="center" canEdit="false">总经理意见</td>
			<td id="costapp_managerview" class="right" >${costapp_managerview}</td>
			
		<tr height="60px">
		<td class="left" align="center" canEdit="false">财务经理意见</td>
		<td id="costapp_financeview" class="right" >${costapp_financeview}</td>
		</tr>
		<tr height="60px">
		<td class="left" align="center" canEdit="false">董事助理意见</td>
		<td id="costapp_assistant" class="right" >${costapp_assistant}</td>
		</tr>		
		<tr height="60px">
			<td class="left" align="center" canEdit="false">董事长意见</td>
			<td id="costapp_chairmanview" class="right" >${costapp_chairmanview}</td>
		</tr>	
	    <tr style="display: none">
			<td id="costapp_id" >${costapp_id}</td>	
		</tr>
	</table>
	</form>
	</div>
		<div style="text-align:center" >
		<c:if test="${taskName !='管理公司'}">
		<select name="username" id="username" style="width:120px;">
				<c:forEach items="${userList}" var="user">
					<option class="usernames" value="${user.userid}">${user.username}</option>
				</c:forEach>
			</select>
			</c:if>
			&nbsp;&nbsp;
			<c:forEach var="bot" items="${bot}">
				<c:if test="${bot=='提交'}">
					<a class="easyui-linkbutton" href="javascript:;" 
						onclick="pass_costapp()" style="color: red;width: 80px;">${bot}</a>
				</c:if>
				<c:if test="${bot=='驳回'}">
					<a class="easyui-linkbutton" href="javascript:;" 
						onclick="rejects()" style="color: red;width: 80px;">${bot}</a>
				</c:if>
				</c:forEach>
					<c:if test="${taskName=='申请人'}">
					<a class="easyui-linkbutton" href="javascript:;" 
						onclick="btnDele()" style="color: red;width: 80px;">删除</a>
				</c:if>
		</div>
	     <div id="centers" class="easyui-window"
			data-options="region:'center',title:'请选择值'" closed="true"
			style="height: 500px; width: 800px"></div>
	
		
		
</div>
	<script
		src="<%=request.getContextPath()%>/res/jquery-easyui/wangEditor/release/rejects.js"
		type="text/javascript"></script>
	<script type="text/javascript">
	
		function auditor(){
			var taskName = $("#taskName").val(); //获取节点名称		
			switch (taskName) {
			case "部门经理":
				var edit=document.getElementById("costapp_majoyview");
				edit.setAttribute("canEdit", "true");
				return "costapp_majoyview";
				break;
			case "主管公司总经理":
				var edit=document.getElementById("costapp_managerview");
				edit.setAttribute("canEdit", "true");
				return "costapp_managerview";
				break;	
			case "财务中心经理":
				var edit=document.getElementById("costapp_financeview");
				edit.setAttribute("canEdit", "true");
				return "costapp_financeview";
				break;
			case "助理":
				var edit=document.getElementById("costapp_assistant");
				edit.setAttribute("canEdit", "true");
				return "costapp_assistant";
				break;
			case "董事长":
				var edit=document.getElementById("costapp_chairmanview");
				edit.setAttribute("canEdit", "true");
				return "costapp_chairmanview";
				break;	
			default:
				break;
			}
			
		}
		
		//批量删除处理
		function btnDele() {
			
				
			var costapp_id=document.getElementById("costapp_id").innerText;
			alert(costapp_id)
			if(costapp_id==''){
				 $.messager.alert("提示","无单据编号！");
			    return;
			}	
				$.messager.confirm("操作提示", "您确定要执行操作吗？", function(r) {
					if (r) {
						$.ajax({
							type : 'POST',
							url : 'delect_costapp.do',
							data : {
								'costapp_id' : costapp_id,
							},
							success : function(data) {
								if (data.Success) {
									$.messager.alert("提示", data.Msg, "info", function() {
										location.href="findTaskList.do";
										});	
								} else {
									
									  $.messager.alert("操作提示", data.Msg,"error");
									
								}
								}
						});
					}
				});
		    }
	
		
		//审核
		function pass_costapp() {
            var username=$('#username option:selected').text();//选中的文本("username");
			var userid = $("#username").val();
			var taskName = $("#taskName").val(); //获取节点名称		
			var taskid = $("#taskid").val(); //任务编号
			
			var costapp_id=document.getElementById("costapp_id").innerText;
			var param="";
			
			if(taskName!='申请人'&&taskName!='管理公司'){
				param=document.getElementById(auditor).innerText;
				if(param==''){
					$.messager.alert("提示","请填写意见","info");
					return;
				 }
			}
			if(username!=""){
				if (!confirm("你确定是提交给："+username)) {  
		            return false;
		        }  
			}
			
		  $.messager.confirm('提示!', '你确定审核吗？', function(r) {
			if (r) {
				$.ajax({
					type : 'POST',
					url : 'pass_costapp.do',

					data : {'username' : userid,
						    'taskName' : taskName,
						    'taskid' : taskid,	
						    'costapp_id' : costapp_id,
						    'param' : param,
						    'auditor' : auditor
					},
					success : function(data) {
						if (data.Success) {

							$.messager.alert("提示", data.Msg, "info",
									function() {
										location.href = "findTaskList.do";
									});
						} else {

							$.messager.alert("操作提示", data.Msg, "error");
						}
					}
				});
			}
		});
		}
		

		var auditor=auditor();
		var tds = document.getElementsByTagName('td');
		for (var i = 0; i < tds.length; i++) {
			tds[i].onclick = function(e) {
				if (this.getAttribute('canEdit') === 'true') {
					var textarea = document.createElement("textarea");
					this.appendChild(textarea);
					textarea.focus();
					e.cancelBubble = false;
					textarea.value = this.innerText;
					var _this = this;
					textarea.onblur = function() {
						_this.innerText = this.value;
					};
					
				}
				if(this.getAttribute('canEdit') === 'select'){
					
				}
			};

		}
		

		//取消
		function btnCancel(){
			location.href="costappList.do";
		}
		
		function changeCom(){
			var application=document.getElementById("costapp_application").innerText;
			if(application=="借支申请"){
				document.getElementById("costapp_application").innerHTML = "费用审批";
			}
			if(application=="费用审批"){
				document.getElementById("costapp_application").innerHTML = "报销申请";
			}
			if(application=="报销申请"){
				document.getElementById("costapp_application").innerHTML = "借支申请";
			}
			
		}
		
			
		function wen(src) {
			var hrefs = "<iframe id='son' src='"
					+ src
					+ "' allowTransparency='true' style='border:0;width:99%;height:99%;padding-left:2px;' frameBorder='0'></iframe>";
			$("#centers").html(hrefs);
			$("#centers").window("open");
		}
		
		function data(rowData){
			var company_name= rowData.company_name===undefined?"":rowData.company_name;
			var center_name=  rowData.center_name===undefined?"":rowData.center_name;
			var department_name=  rowData.department_name===undefined?"":rowData.department_name;
			document.getElementById("costapp_company").innerHTML = company_name+center_name+department_name;
		}
		
		
		
		
	</script>
</body>
</html>