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
	<form id="form1" method="post">
		<div id="main" region="center"
			style="background: #eee; padding: 5px; overflow-y: hidden;">
			<div class="easyui-layout" fit="true">
				<div region="north" split="false" border="false"
					style="overflow: hidden; padding: 5px 5px 2px 3px;">

					<div class="search">
						<ul>
							<li><label>供应商名称：</label><input type="text" name="construct_suppliername"
								id="construct_suppliername" value="" class="easyui-validatebox"
								style="width: 120px" /></li>
							

							<li>&nbsp;&nbsp; <a class="easyui-linkbutton"
								data-options="iconCls:'icon-search'" href="javascript:;"
								id="btnSearch">查询</a></li>
						</ul>
					</div>
					<br />

				</div>

				<div region="center" split="false" border="false"
					style="overflow: hidden; padding: 0px 5px 5px 5px" id="dataList">
					

					<table id="data" title="" fit="true"
						data-options="collapsible: true,pagination:true,onDblClickRow: onDblClickRow">
						<thead>
							<tr>
								<th halign="center" field="construct_supplier_id" align="center"
									sortable="true" width="60px">供应商编号</th>
								<th halign="center" field="construct_supplier_name" align="center"
									sortable="true" width="120px">供应商名称</th>
								<th halign="center" field=construct_supplier_addr align="center" 
									sortable="true" width="150px">供应商地址</th>
								<th halign="center" field="construct_supplier_tel" align="center" 
									sortable="true" width="150px">供应商电话</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>

		</div>
	</form>

				
				


	<script type="text/javascript">
		
			
		/***处理操作列的功能***/
		function cmdHanlder(cmd, row) {
		}

		$(function() {
			$("#data").admin_grid({
				queryBtn : "#btnSearch",
				excelBtn : "#btnExcel",
				cmdHanlder : cmdHanlder,

			});

		});
		
		
		function onDblClickRow (rowIndex, rowData){
			
	        $(window.parent.$("#supplier").val(rowData.construct_supplier_name)); //给父页面赋值
	        $(window.parent.$("#construct_material_supplierTel").val(rowData.construct_supplier_tel));
	        
	        $(window.parent.window.supplierData(rowData));
	        
	        $(window.parent.$("#win").window("close"));
	        
    };
		
	</script>

</body>
</html>