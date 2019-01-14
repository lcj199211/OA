<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>人事管理</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<jsp:include page="../common/css.jsp"></jsp:include>
<jsp:include page="../common/scripts.jsp"></jsp:include>

<style type="text/css">
#menu {
	font-size: 20px;
	font-weight: bolder;
}

#menu li {
	margin: 30px;
	list-style-image: none;
	list-style-type: none;
	background-color: #999999;
	border-right-width: 50px;
	border-right-style: solid;
	border-right-color: #eee;
	float: left;
}

#menu li a {
	display: block;
	color: #FFFFFF;
	text-decoration: none;
	margin: 0px;
	padding-top: 60px;
	display: block; /* 作为一个块 */
	padding-right: 60px; /* 设置块的属性 */
	padding-bottom: 40px;
	padding-left: 60px;
	font-size: 15px
}

#menu li a:hover {
	background-color: #0099CC;
}
</style>

</head>

<body>
	<div style="text-align: left">
		<h style="font-size:60px">人事管理</h>
	</div>
	<hr />
	<div style="text-align: center">
		<ul id="menu">
			<li><a href="admin/sendEmail.do">发送入职邀请函</a></li>
			<li><a href="admin/leaveList.do">请假记录</a></li>
			<li><a href="admin/labContract.do">打印纸质合同</a></li>
			
			<li><a href="admin/assessList.do">评估管理</a></li>
		</ul>
		<ul id="menu">
			<li><a  href="admin/pmuserList.do">职员信息</a></li>
			<li><a>打印入职申请表</a></li>
			<li><a  href="admin/companyList.do">公司记录</a></li>
			<li><a  href="admin/departmentList.do">部门记录</a></li>
			<li><a  href="admin/centerHome.do">中心记录</a></li>
		</ul>
	</div>
	<div style="position:absolute;left:60px;top:480px;">
		<h2
			style="width:500px; font-size:30px ;border-bottom: 	#97CBFF 2px solid;">
			<span style="font-size:30px">消息提醒</span> <a href="www.baidu.com"
				target="_blank" style="float: right;text-decoration: none"></a>
		</h2>
	</div>

	

	<script type="text/javascript">

	</script>

	<script type="text/javascript">
	</script>


</body>
</html>
