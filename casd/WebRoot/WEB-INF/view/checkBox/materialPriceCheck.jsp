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
					style="overflow: hidden; padding: 5px 5px 28px 5px;">
					<div class="easyui-panel" title="查询条件" style="margin-bottom: 5px;">

						<div class="search">
							<ul>
								<li><label>材料名称：</label><input type="text" name="construct_material_name", id="construct_material_name"
									class="easyui-validatebox" style="width: 120px" /></li>
								<li>&nbsp;&nbsp; <a class="easyui-linkbutton"
									data-options="iconCls:'icon-search'" href="javascript:;"
									id="btnSearch">查询</a></li>
							</ul>
							<div class="clear"></div>
						</div>
					</div>
				</div>
				
				<div region="center" split="false" border="false"
					style="overflow: hidden; padding: 0 5px 5px 5px" id="dataList">
					<table id="data" title="" fit="true"
						data-options="collapsible: true,pagination:true,rownumbers:true,onDblClickRow: onDblClickRow">
						<thead>
							<tr>
								<th id="ds" halign="center" field="construct_material_priceId" align="center"
									sortable="true" width="60px">单价编号</th>
								<th halign="center" field="construct_material_name" align="center"
									sortable="true" width="120px">材料名称</th>
								<th halign="center" field="construct_material_model" align="center" 
									sortable="true" width="120px">型号规格</th>
								<th halign="center" field="construct_material_unit" align="center" 
									sortable="true" width="120px">单位</th>
								<th halign="center" field="construct_material_brand" align="center" 
									sortable="true" width="120px">品牌</th>
								<th halign="center" field="construct_material_supplier" align="center" 
									sortable="true" width="120px">供应商</th>
								<th halign="center" field="construct_material_supplierTel" align="center" 
									sortable="true" width="120px">供应商联系方式</th>			
								<th halign="center" field="construct_material_price" align="center" 
									sortable="true" width="120px">单价</th>	
								<th halign="center" field="construct_material_remarks" align="center" 
									sortable="true" width="120px">备注</th>			
							</tr>
						</thead>
					</table>
				</div>

			</div>
			
			
	<script type="text/javascript">
	   
		/***处理操作列的功能***/
		function cmdHanlder(cmd, row) {
			
		}

		
		function onDblClickRow (rowIndex, rowData){    
	        var construct_material_brand=rowData.construct_material_brand;
	        var construct_material_supplier=rowData.construct_material_supplier;
	        var construct_material_price=rowData.construct_material_price;
	        var construct_material_supplierTel=rowData.construct_material_supplierTel;
	        
			var index=${index};
	        var retVal = JSON.parse("{}");
	        retVal.brand=construct_material_brand;
	        retVal.supplier=construct_material_supplier;
	        retVal.price=construct_material_price;
	        retVal.tel=construct_material_supplierTel;
	        $(window.parent.window.materialPriceData(retVal,index));
	        
	        $(window.parent.$("#win").window("close"));
	        
	    };
		
		$(function() {
			$("#data").admin_grid({
				queryBtn : "#btnSearch",
				excelBtn : "#btnExcel",
				cmdHanlder : cmdHanlder,
			});
			
			
		});
	</script>

</body>
</html>