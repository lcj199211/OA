<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>首页</title>
<%-- <jsp:include page="../common/css.jsp"></jsp:include> --%>
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

table {
	border-collapse: collapse;
	margin: 20px auto;
}

td {
	width: 650px;
	/* height: 50px; */
	position: relative;
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
</style>
</head>
<body >
	<div style="margin: 20px"></div>
	<div style="text-align: center;font-size:25px">
	<strong >诚安时代绩效考核评定表</strong>
	</div>
	<div style="margin: 10px"></div>
	<div style="text-align: center;font-size:20px">
	<a id="achReview_month" >${data.achReview_month}</a>
	</div>
	<table border="1">
		<tr height="50px">
			<td class="left" align="center" canEdit="false">被考核公司</td>
			<td class="right" canEdit="select" ><a id="achReview_company" href="#" onclick="changeCom();" >${data.achReview_company}</a></td>
		</tr>
		<tr height="150px">
			<td class="left" align="center" canEdit="false">监察中心<br>考核意见</td>
			<td id="achReview_supCenter" class="right" canEdit="true">${data.achReview_supCenter}</td>
		</tr>
		<tr height="150px">
			<td class="left" align="center" canEdit="false">被考核公司<br>自评意见</td>
			<td id="achReview_comOpinion" class="right" canEdit="true">${data.achReview_comOpinion}</td>
		</tr>
		<tr height="150px">
			<td class="left" align="center" canEdit="false">董事会意见</td>
			<td id="achReview_dirOpinion" class="right" canEdit="true">${data.achReview_dirOpinion}</td>
		</tr>
		<tr height="100px">
			<td class="left" align="center" canEdit="false">备注</td>
			<td class="right" canEdit="false">
			1、以上考核以公司为单位<br>
			2、考核涉及到各公司、各部门的工作执行力、效率、态度、专业技能及管理等综合能力<br>
			3、监察中心每月10日前完成考核意见递交被考核公司自评，被考核公司每月15日前完成自评意见递交董事会考核，董事会每月20日前给出考核意见公示并存档，作为年底绩效依据<br>
			4、公示时间：一个月<br>
  			5、为更好的形成企业的考核文化，请各管理层必须做到由上而下，以身作则
			</td>
		</tr>
	</table>
	
	
	
	<br /> <br /> <br />
		<div style="text-align:center">

			<!--< a class="easyui-linkbutton" href="javascript:;" id="btnSave"
				onclick="btnSave()">保存</a> &nbsp;&nbsp;&nbsp;&nbsp; --> <a
				class="easyui-linkbutton" href="javascript:;" id="btnCancel"
				onclick="btnCancel()">返回</a>
		</div>
	
	<script>
			
			
			/* $(document).ready(function() {
				 var date=new Date;
				 var year=date.getFullYear(); 
				 var month=date.getMonth()+1;
				 month =(month<10 ? "0"+month:month); 
				 var mydate = (year.toString()+"年"+month.toString()+"月");
				 document.getElementById("achReview_month").innerHTML = mydate;
			}); */
			function btnCancel(){
				location.href="achReviewList.do";
			}
			
	</script>

</body>
</html>