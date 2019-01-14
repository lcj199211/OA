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
<title></title>
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
#menu li{

	margin: 30px;
	list-style-image: none;
	list-style-type: none;
	background-color: #999999;
	border-right-width: 0px;
	border-right-style: solid;
	border-right-color: #eee;
	float: left;
}
#menu li a{
	display:block;
	color: #FFFFFF;
	text-decoration: none;
	margin: 0px;
	padding-top: 60px;
	display: block; /* 作为一个块 */
	padding-right: 40px; /* 设置块的属性 */
	padding-bottom: 40px;
	padding-left: 40px;
	font-size:30px
}
#menu li a:hover{
	background-color: #0099CC;
}

</style>

</head>

<body>
	<div style="text-align: left">
		<h style="font-size:60px"></h>
	</div>
	<hr />
	<div style="text-align: center">
		<ul id="menu">
			<li><a href="admin/purchaseList.do">采购申请单列表</a></li>
			<li><a href="admin/finalPurchaseList.do">采购单列表</a></li>
		</ul>
	</div>
	
	<script type="text/javascript">
	</script>

</body>
</html>
