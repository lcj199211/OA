<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

</head>
<body class="easyui-layout" style="overflow-y: hidden;" scroll="no">

	<div id="main" region="center"
		style="background: #eee; padding: 5px; overflow-y: hidden;">
		<div class="easyui-layout" fit="true">
			<div region="north" split="false" border="false"
				style="overflow: hidden; padding: 5px 5px 2px 3px;">

				<div class="search">
					<ul>
						<li><label>标准查询：</label><input type="text" name="hr_templatel_type"
							id="hr_templatel_type" value="" class="easyui-validatebox"
							style="width: 120px" /></li>

						<li>&nbsp;&nbsp; <a class="easyui-linkbutton"
							data-options="iconCls:'icon-search'" href="javascript:;"
							id="btnSearch">查询</a></li>
					</ul>
				</div>
				<br />

				<div>
					<ul>
						<li style="list-style:none;"><a id="btnNew"
							onclick="btnNew('');" class="easyui-linkbutton"
							iconCls="icon-add" plain="true">新增模板</a>
							
							<a onclick="btnCompany(1);" class="easyui-linkbutton">合同标准</a>&nbsp;&nbsp;
							<a onclick="btnCompany(2);" class="easyui-linkbutton">行政标准</a>&nbsp;&nbsp;
							<a onclick="btnCompany(3);" class="easyui-linkbutton">财务标准</a>&nbsp;&nbsp;
							<a onclick="btnCompany(4);" class="easyui-linkbutton">企业资质</a>&nbsp;&nbsp;
							</li>
							
					</ul>
					
				</div>
			</div>

			<div region="center" split="false" border="false"
				style="overflow: hidden; padding: 0px 5px 5px 5px" id="dataList">
				<table id="data" title="" fit="true"
					data-options="collapsible: true,pagination:true,">
					<thead>
						<tr>
							<th halign="center" field="hr_templatel_id" align="center"
								sortable="true" width="60px">模板号</th>
							<th halign="center" field="hr_template_name" align="center"
								sortable="true" width="120px">模板名称</th>
							<th halign="center" field="hr_templatel_time" align="center"
								sortable="true" width="120px">时间</th>
							<th halign="center" field="hr_template_path" align="center"
								sortable="true"  width="120px">路径</th>
							<th halign="center" field=hr_templatel_describe align="center"
								 sortable="true" width="120px">描述</th>
							<th halign="center" field="hr_templatel_type" align="center"
								 sortable="true" width="120px" formatter="operate_type">类型</th>
							 <th halign="center" field="psn" align="center" sortable="true"
								width="180px" formatter="operate_formatter">操作</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>

	<script type="text/javascript">
	
	function operate_formatter(value, row, index) {
		var html = "";
		html += '<a href="javascript:;" class="opt"  data-options="plain:true" onclick="btnNew('+row.hr_templatel_id+');" cmd="edit" i="' + index + '">编辑</a>';
		html += '<a href="javascript:;" class="opt"  data-options="plain:true"  cmd="delete" i="' + index + '">删除</a>';
		html += '<a href="javascript:;" class="opt"  data-options="plain:true"  cmd="downLoad" i="' + index + '">下载</a>';
		return html;
	}
	
		$(function() {
			$("#data").admin_grid({
				queryBtn : "#btnSearch",

				cmdHanlder : cmdHanlder,

			});

		});
		
       
            //类型格式化 
		function operate_type(value, row, index){
			if (value == 1) {
				return "合同标准";
			  } else if (value == 2) {
				return "行政标准";
			} else if (value ==3) {
				return "财务标准";
			} else if (value ==4) {
				return "企业资质";
			}
			
		   }


		function btnCompany(obj){
			if(obj===1){
				$("#hr_templatel_type").val("1");
			}else if(obj===2){
				$("#hr_templatel_type").val("2");
			}else if(obj===3){
				$("#hr_templatel_type").val("3");
			}else if(obj===4){
				$("#hr_templatel_type").val("4");
			}
			
			//IE
			if (document.all) {
				document.getElementById("btnSearch").click();
			}
			// 其它浏览器
			else {
				var e = document.createEvent("MouseEvents");
				e.initEvent("click", true, true); //这里的click可以换成你想触发的行为
				document.getElementById("btnSearch").dispatchEvent(e); //这里的clickME可以换成你想触发行为的DOM结点
			}
		}
            //
		function btnNew(biz){
				location.href = "templatelNew.do?" + $.param({
					'biz' : biz, //获取id
				});
	          }

		/***处理操作列的功能***/
		function cmdHanlder(cmd,row) {
			/*删除  */
			if (cmd == "delete") {
			 var biz= row.hr_templatel_id;
			
				$.messager.confirm("操作提示", "您确定要删除吗？", function(r) {
					if (r) {
						$.ajax({
							type : 'POST',
							url : 'deleteTemplate.do',
							data : {
								'biz' : biz,
								'hr_template_path':row.hr_template_path,
							},
							success : function(data) {
								if (data.Success) {
									
									  $.messager.alert("提示","操作成功！","info",function() {
											window.location.href = 'templatelList.do';
										   }); 
								} else {
									  $.messager.alert("操作提示", data.Msg,"error",function() {
											window.location.href = 'templatelList.do';
										  }); 
	
								}
								}
						});
					}
				});
				
			//下载
			}else if(cmd=='downLoad'){
				location.href = "downloadTemplate.do?"+$.param({
					hr_template_path:row.hr_template_path
				   });
			}
		}
	</script>

</body>
</html>