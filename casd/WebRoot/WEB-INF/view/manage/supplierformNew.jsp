
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="PowerCheck" prefix="shop"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
	response.flushBuffer();
%>
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
	rel="stylesheet" type="text/css" />
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
				<div>
					<form id="jvForm" action="" method="post"
						enctype="multipart/form-data">
						<table>
							<tr>
								<td><input class="easyui-filebox" name="pic"
									id="uploadFileid"
									data-options="prompt:'选择文件',buttonText:'&nbsp;选&nbsp;择&nbsp;',required:true"
									style="width:20%px"> <a class="easyui-linkbutton"
									onclick="uploadPic();" href="javascript:;" id="btnSaveExp">上传</a>
									<a class="easyui-linkbutton" href="javascript:;" id="btnCancel"
									onclick="btnCancel()">返回</a>
							</tr>

						</table>
					</form>
				</div>




				<div region="center" split="false" border="false"
					style="overflow: hidden; padding: 0 5px 5px 5px" id="dataList">
					<c:if test="${!empty supplierform.supplierform_fileway}">
						<object
							data="/uploadfile/photo/LaborDivision/${supplierform.supplierform_fileway}"
							type="application/pdf" width="90%" height="100%"> </object>
					</c:if>
					<input type="text" style="display: none"
						value="${supplierform.supplierform_id}"
						name="supplierform_id" id="supplierform_id" class="mini-textbox" />
				</div>
				</div>

			</div>
		</div>

		<script type="text/javascript">
	
	
	//取消
	function btnCancel() {
		location.href = "supplierformList.do?";
	}

	
	
	function uploadPic() {

		var fileName = $("#uploadFileid").filebox('getValue');
		if (fileName == "") {
			$.messager.alert("提示", "请选择文件！");
			return false;
		}
		var file_typename = fileName.substring(fileName.lastIndexOf('.'),
				fileName.length);

		if (file_typename != '.pdf') {
			$.messager.alert("提示", "文件格式错误，请选择文件格式为.pdf");
			return false;
		}
		$.messager.confirm('继续操作', '确定导入吗?', function(r) {
			if (r) {
				// 上传设置  
				$.messager.progress();
				$('#jvForm').form(
						'submit',{
							url : 'uup.do?supplierform_id='+${supplierform.supplierform_id},
							onSubmit : function(data) {
							},
							success : function(data) {
								$.messager.progress("close");
								var data = eval('(' + data + ')');
								if (data.Success) {
									$.messager.alert("提示", "操作成功！", "info");
									location.href = "supplierformNew.do?supplierform_id="+data.ID;
								} else {
									$.messager.alert("系统提示", "上传出错，"
											+ data.Msg, "info");
								}
							}
						});
			}
		});
	}

	</script>
</body>
</html>