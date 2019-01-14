
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="PowerCheck" prefix="shop"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%response.setHeader("Pragma","No-cache"); 
response.setHeader("Cache-Control","no-cache"); 
response.setDateHeader("Expires", 0); 
response.flushBuffer();%>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache"> 
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"> 
<META HTTP-EQUIV="Expires" CONTENT="0">

<title>首页</title>
<link
	href="<%=request.getContextPath()%>/res/jquery-easyui/themes/default/easyui.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/res/admin/css/icon.css"
	rel="stylesheet" type="text/css"/>
<script
	src="<%=request.getContextPath()%>/res/jquery-easyui/jquery.min.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/res/jquery-easyui/jquery.easyui.min.js"
	type="text/javascript"></script>

</head>

<body class="easyui-layout" style="overflow-y: hidden;" scroll="no">

	<div id="main" region="center"
		style="background: #eee; padding: 5px; overflow-y: hidden;">
		<div class="easyui-layout" fit="true">
			<div region="north" split="false" border="false"
				style="overflow: hidden; padding: 5px 5px 28px 5px;">
			<!--	<div style="text-align:center">
		 <tr>
			<td style="align:center">
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a class="easyui-linkbutton" href="javascript:;" id="btnCancel"
				onclick="btnCancel()">返回</a></td>
		</tr> 
	</div>-->

		<div region="center" split="false" border="false"
				style="overflow: hidden; padding: 0 5px 5px 5px" id="dataList">
				 <object data="/uploadfile/photo/LaborDivision/${data.supplierform_fileway}"
				 type="application/pdf" width="90%" height="100%">    
                </object> 
				<!-- <iframe src="/uploadfile/photo/pdf/address_list.pdf" align="middle"
					width="90%" height="100%"></iframe> -->
			</div>

		</div>
	</div>

	<script type="text/javascript">
	function btnCancel() {
		location.href = "supplierformList.do?";}
	

	</script>

</body>
</html>