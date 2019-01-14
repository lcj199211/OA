<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title></title>
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
/*demo styles*/
table {
	margin: 0 auto;
	border-collapse: collapse;
}

td,th {
	width: 10%;
	font-size: 14px;
	padding: 5px 0;
	border: 2px solid #ddd;
	font-weight: bold;
}

th {
	background-color: #f4f4f4;
}
/* input */
td.textarea {
	position: relative;
}

td textarea {
    resize:none; 
	width: 100%;
	height:20px;
	border: 1px solid white;
	border-radius: 4px;
	display: block;
	font-size: 14px;
	left: 0;
	top: 0;
	padding: 11px 0;
	margin: -1px 0 0 -1px;
}
 .tdinput{
 
  width: 100%;
  height:10px;
  border: 1px solid white;
  border-radius: 4px;
	display: block;
	font-size: 14px;
	left: 0;
	top: 0;
	padding: 11px 0;
	margin: -1px 0 0 -1px;
 }
 .userselect{
	width:  120px;
	height: 30px;
	border: 1px solid red; 
	margin-left:100px;
 }
  .easybnt{ 
     height: 30px;
     line-height: 30px;
     padding: 0 10px;
     font-size: 12px;
    
  }
</style>


</head>
<body>
<div style="margin-left: 20%">
  <label><h2>广东诚安时代-发展公司</h2></label>
</div>
  <div style="margin:20px 0;"></div>
<div>
     <form id="jvform" action="">
	<table border="1"  width="900" style="margin-left: 20px">
		<thead>
			<tr>
                <td hidden="hidden">
                 <input type="text" id="taskid" value="${taskid}"/>任务编号
                 <input type="text" id="taskName" value="${taskName}"/>任务名称
                <input type="text" name="construct_draw_id" id="construct_draw_id" value="${construct_draw_id}"/>领款单编号 
                </td>
                <th hidden="hidden">
                <input type="text" name="construct_project_id" value="${construct_project_id}"/>项目编号</th>
				<th scope="col" width="30">项目名称</th>
			    <td style="padding:0px 0px;width: 100px">
			    <textarea  id="construct_project_name">${construct_project_name}
			    </textarea></td>
				<th scope="col">项目总造价</th>
				<td style="padding:0px 0px;width: 200px">
				<textarea name="construct_project_cost" value="${construct_project_cost}">${construct_project_cost}</textarea></td>
			</tr>
			<tr>
			   <th scope="col">领款单位</th>
			  <td  style="padding:0px 0px;width: 200px"><textarea  name="construct_draw_unit">${construct_draw_unit}</textarea></td>
				<th scope="col">领  款  人</th>
			  <td  style="padding:0px 0px;width: 200px"><textarea  name="construct_draw_payee">${construct_draw_payee}</textarea></td>
			</tr>
			 <tr>
				<th scope="col">结算方式</th>
			    <th  colspan="3">
			    <input type="radio" name="construct_draw_type" value="1">按项目款
			    <input type="radio" name="construct_draw_type" value="2">结算支付
			    <input type="radio" name="construct_draw_type" value="3">其中预留款    
                </th>
			</tr>
			<tr>
			 <th scope="col">现申领款</th>
			    <td  style="padding:0px 0px;">
			    <input  type="text" class="tdinput" name="construct_draw_cash" value="${construct_draw_cash}"/>
			    </td>
				<th scope="col">累计已领款</th>
			    <td style="padding:0px 0px;">
			    <input type="text" class="tdinput" name="construct_accumulated_money" value="${construct_accumulated_money}"></td>
			</tr>
			<tr>
				<th scope="col">实付款</th>
			    <td style="padding:0px 0px;height: 20px">
			    <input class="tdinput"  type="text" name="construct_actual_payment" value="${construct_actual_payment}"></td>
				<th scope="col">支付方式</th>
			 <th colspan="3">
			    <input type="radio" name="construct_payment_method" checked value="1">支票
			    <input type="radio" name="construct_payment_method" value="2">现金
			   
                </th>
			</tr>
		
			<tr>
				<th scope="col">科技公司意见</th>
			   <td  style="padding:0px 0px;width: 200px" colspan="3">
			   <textarea name="construct_draw_fopinion">${construct_draw_fopinion}</textarea></td>
			</tr>
			<tr>
				<th scope="col">财务中心意见</th>
			    <td  style="padding:0px 0px;width: 200px" colspan="3">
			   <textarea name="construct_draw_copinion">${construct_draw_copinion}</textarea></td>
				
			</tr>
			<tr>
				<th scope="col">董事长意见</th>
			    <td  style="padding:0px 0px;width: 200px" colspan="3">
			   <textarea name="construct_draw_zopinion">${construct_draw_zopinion}</textarea></td>
			</tr>
		</thead>
	</table>
	</form>
	<br>
	<div>
	    <div>
	      <div style="float: left;">
	      <c:if test="${taskName!='董事长意见'}">
		 <select class="userselect" name="userid" id="userid">
		 	<c:forEach items="${userList}" var="user">
			<option value="${user.userid}">${user.username}</option>
			</c:forEach>
	     </select>
	     </c:if>
	        </div>
	     <div style="margin-left: 40px">
	           <input type="button" class="easybnt" onclick="drawmoneyPass(true);"  value="提交"/>
	           <c:if test="${taskName!='重新调整'}">
	           <input type="button" class="easybnt" onclick="drawmoneyPass(false);" value="驳回"/>
	           </c:if>
	           </div>
		</div>

	</div>
	</div>
        <!-- 打开子框开始 -->
		<div id="centers" class="easyui-window"
			data-options="region:'center',title:'请选择值'" closed="true"
			style="height: 500px; width: 800px"></div>
		<!-- 打开子框结束 -->
		<br>
	
	<script type="text/javascript">
	
	 $(function(){
	    	//单选赋值
	    	var method = "${construct_payment_method}";
	    	var draw_type = "${construct_draw_type}";
	    if(method !='' && draw_type !=''){
	    	$('input[name=construct_payment_method][value='
			+ method + ']').attr('checked', 'checked');//很简单就不说了哦
			$('input[name=construct_draw_type][value='
					+ draw_type + ']').attr('checked', 'checked');//很简单就不说了哦
	      }
			
	    });


	 function drawmoneyPass(sign){
			 var userid=$("#userid").val();
			 var bizId=$("#construct_draw_id").val();	 
			 var taskid=$("#taskid").val();
			 var taskName=$("#taskName").val();
			
		  $.messager.confirm('提示！', '你确定提交吗？', function(r){
					if (r){
						$.messager.progress({
							title : '提示',
							msg : '正在处理中，请稍候……',
							text : ''
						});
				$.ajax({
					url : "drawmoneyPass.do?=" + $("#jvform").serialize(),
					type : 'POST',
					data : {'username':userid,
						    'sign':sign,
						    'bizId':bizId,
						    'taskid':taskid,
						    'taskName':taskName,	
					},
					success : function(data) {
					
						
						 $.messager.progress('close');
						 if (data.Success) {
							 location.href="findTaskList.do";
								
							} else {
								$.messager.alert("操作提示", data.Msg, "error");
							}

					}
				  
			      });
				}
			});
			
	}
	
	
	
	</script>
</body>
</html>
