<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

</head>
<body>
	<div style="margin:20px 0;"></div>
	<div>
		
		<div class="easyui-panel" title="模板" style="width:400px">
			<div style="padding:10px 60px 20px 60px">
				<form id="jvForm" action="" method="post" enctype="multipart/form-data">
					<table>
						<tr>
							<td>模板名称:</td>
							<td><input class="easyui-filebox" name="pic"
								id="uploadFileid"
								data-options="prompt:'选择文件',buttonText:'&nbsp;选&nbsp;择&nbsp;',required:true"
								style="width:200px"></td>
						</tr>	
						<tr>
							<td>模板编号:</td>
							<td><input class="easyui-textbox" style="width:200px" id="hr_templatel_id"
								type="text" name="hr_templatel_id" readonly="readonly" value="${hr_templatel_id==null?0:hr_templatel_id}"></input></td>
						</tr>	
						<tr style="display: none;">
							<td>模板路径:</td>
							<td><input class="easyui-textbox" style="width:200px" id="hr_template_path"
								type="text" value="${hr_template_path}"></input></td>
						</tr>	
						<tr>
							<td>模板名称:</td>
							<td><input class="easyui-textbox" style="width:200px"
								type="text" name="hr_template_name" value="${hr_template_name}"></input></td>
						</tr>
						<tr>
							<td>类型:</td>
							<td>
							<select class="easyui-combobox" id="hr_templatel_type"  name="hr_templatel_type" style="width:200px;">
							    <option value="1">合同标准</option>
							    <option value="2">行政标准</option>
							    <option value="3">财务标准</option>
							    <option value="4">企业资质</option>
							</select>
<%-- 
							<input class="easyui-textbox" style="width:200px"
								type="text" name="hr_templatel_type" value="${hr_templatel_type}"></input> --%></td>
						</tr>
						<tr>
							<td>描述:</td>
							<td><input class="easyui-textbox" name="hr_templatel_describe"
								data-options="multiline:true" value="${hr_templatel_describe}" style="width:200px;height:60px"></input></td>
						 </tr>
					</table>
				</form>
				<div style="text-align:center;padding:5px">
					<a href="javascript:void(0)" class="easyui-linkbutton" style="width: 60px;"
						onclick="uploadPic();">提交</a><a href="javascript:void(0)"
						class="easyui-linkbutton" onclick="clearForm()"style="width: 60px;">取消</a>
				</div>
			</div>
		</div>
	</div>
	<script>
	$(function(){
		
		 var hr_templatel_id =$("#hr_templatel_id").val();
		if(hr_templatel_id!=0)
           $('#hr_templatel_type').combobox('setValue',${hr_templatel_type});
		 });
	
	/**
	*上传模板
	*/
	function uploadPic() {
	  var	hr_template_path=$("#hr_template_path").val();// 获取路径

	     $.messager.confirm('提示','确定操作吗?',function(r) {
	      	if (r) {
	      		   $.messager.progress();
			        $('#jvForm').form(
					          'submit',{
				                url :'saveTemplatel.do',
						    	onSubmit : function(param){
						    		param.hr_template_path = hr_template_path; 
						    	
							   },
							   success : function(data) {	
								var data = eval('('	+ data+ ')');
						         if (data.Success) {
									$.messager.alert("提示","操作成功！","info",function() {
										$.messager.progress("close");
										window.location.href = 'templatelList.do';
									   });
									}else {
									$.messager.alert("系统提示",data.Msg,"error",function() {
											$.messager.progress("close");
											window.location.href = 'templatelList.do';
									});
							} 
						}
				     })
				   }          
	        	});
	       }
	
	function clearForm(){
		
		location.href="templatelList.do";
	}
	
	</script>
</body>
</html>