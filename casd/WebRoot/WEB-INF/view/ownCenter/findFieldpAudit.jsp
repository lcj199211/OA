<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

<style type="text/css">
 

</style>
</head>
<body>

	<div>
		<div style="margin:20px 0;"></div>
		<div class="easyui-panel" title="外勤申请表" style="width:800px">
		<div>
			<input type="hidden" id="taskid" value="${taskid}"> 
			<input type="hidden" id="taskName" value="${taskName}"></div>
			<div style="padding:10px 60px 20px 60px">
				<form id="jvForm" method="post">
				<table cellpadding="5" style="margin:0 auto;">
				<tr style="display: none;">
	    			<td>申请人:</td>
	    			<td><input class="easyui-textbox" type="text" value="${userid}" name="field_personnel_userid"></input></td>
	    			<td>单据编号:</td>
	    			<td><input class="easyui-textbox" type="text" value="${field_personnel_id}" id="field_personnel_id" name="field_personnel_id"></input></td>
	    			
	    		</tr>
	    		<tr>
	    			<td>申请人:</td>
	    			<td><input class="easyui-textbox" type="text" style="width:150px" value="${username}"></input></td>
	    			<td>公司:</td>
	    			<td><input class="easyui-textbox" type="text" style="width:150px" value="${company_name}" name="field_personnel_company" ></input></td>
	    		</tr>
	    	<tr>
	    			<td>职位:</td>
	    			<td><input class="easyui-textbox" type="text"  style="width:150px" value="${role_name}" name="field_personnel_rolename" ></input></td>
	    			<td>外出地点:</td>
	    			<td><input class="easyui-textbox" type="text" style="width:150px" name="field_personnel_place" ></input></td>
	    		</tr>
	    		<tr>
	    			<td>车牌号:</td>
	    			<td><input class="easyui-textbox" style="width:150px" type="text" value="${field_personnel_license}" name="field_personnel_license" ></input></td>
	    			<td>是否用车:</td>
	    			<td><input type="radio" name="field_personnel_car"  checked value="1">否</input>
                        <input type="radio" name="field_personnel_car" value="2">是</input></td>
	    		</tr>
	    			<tr>
	    			<td>开始时间:</td>
	    			<td> <input class="easyui-datetimebox csss" style="width:150px" value="${start_time}" name="start_time"></input></td>
	    			<td>结束时间:</td>
	    			<td><input class="easyui-datetimebox"  style="width:150px" value="${end_time}" name="end_time" ></input></td>
	    		</tr>
	    		
	    		<tr>
	    			<!-- <td><a href="javascript:void(0)" onclick="wen('userListCheck.do?index=0')" style="color: red;">驾驶员:</a></td> -->
	    			<td>驾驶员:</td>
	    			<td><input class="easyui-textbox"  style="width:150px"value="${field_personnel_driver}" type="text" name="field_personnel_driver" ></input></td>
	    			
	    		</tr>
	    		<tr>
	    			<td >外出原因:</td>
	    			<td colspan="3"><input class="easyui-textbox" name="field_personnel_cause" value="${field_personnel_cause}" data-options="multiline:true" style="width:370px"></input></td>
	    		</tr>
	    		
	    	 </table>
				</form>
				
			    
				<c:if test="${taskName !='人事备案'}">
				<div style="text-align:  center;margin: 10px;">
                     <select class="easyui-combobox"  name="username" id="username" style="width:120px;">
								<c:forEach items="${userList}" var="user">
									<option value="${user.userid}">${user.username}</option>
								</c:forEach>
						</select></div>
						
				</c:if>		
				<div style="text-align:center;padding:5px">
				<c:if test="${taskName=='申请人' || taskName=='人事备案'}">
					<a href="javascript:void(0)" class="easyui-linkbutton" style="width:50px;"
						onclick="submitForm('true')">同意</a> 
				</c:if>	
				<c:if test="${taskName=='主管公司总经理' || taskName=='管理公司总经理'}">
					<a href="javascript:void(0)" class="easyui-linkbutton" style="width:50px;"
						onclick="submitForm('true')">同意</a> 
					<a href="javascript:void(0)"
						class="easyui-linkbutton" style="width:50px;" onclick="submitForm('false')">不同意</a>	
				</c:if>	
				</div>
			</div>
		</div>
		
		
	
</div>
	
	<script type="text/javascript">
	
   /* function wen(src) {
		var hrefs = "<iframe id='son' src='"
				+ src
				+ "' allowTransparency='true' style='border:0;width:99%;height:99%;padding-left:2px;' frameBorder='0'></iframe>";
		$("#win").html(hrefs);
		$("#win").window("open");
	} */
	
	
	$(function(){
		//单选框赋值
		var car=${field_personnel_car==undefined?1:field_personnel_car};
		$("input[name='field_personnel_car'][value="+car+"]").attr("checked",true);
		
	   });
	
       //提交单据
	function submitForm(sign){	   
      var car = $("input[name='field_personnel_car']:checked").val();
      var biz = $("#field_personnel_id").val();
      var taskid = $("#taskid").val();
      var taskName = $("#taskName").val();
      var userid= $("#username").val(); 
  	$.messager.confirm('提示！', '你确定审核吗？', function(r) {
		if (r) {	
			 $.messager.progress({ 
			       title: '提示', 
			       msg: '正在处理中，请稍候……', 
			       text: '' 
			    });
		$.ajax({
			type : 'POST',
			url : 'fieldPersonnelPass.do',

			data : {
				'car' : car,
				'biz' : biz,
				'taskid' : taskid,
				'taskName' : taskName,
				'username' : userid,
				'sign' : sign,
			   },
			success : function(data) {
				if (data.Success) {
					  $.messager.progress('close');
					$.messager.alert("提示", data.Msg,"info", function() {
								location.href="findTaskList.do";
							});
			      	}else {
			      		$.messager.progress('close');
					$.messager.alert("提示", data.Msg,
							"error");
				}
			}
			});
		}
		
  	});
	
	}

	</script>
</body>
</html>