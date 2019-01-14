<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="PowerCheck" prefix="shop"%>

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
							<li><label>材料名称：</label><input type="text"
								name="construct_material_name"  id="material_name"
								class="easyui-validatebox" style="width: 120px" /></li>
							<li><label>型号规格：</label><input type="text"
								name="construct_material_model" , id="material_model"
								class="easyui-validatebox" style="width: 120px" /></li>

							<li>&nbsp;&nbsp; <a class="easyui-linkbutton"
								data-options="iconCls:'icon-search'" href="javascript:;"
								id="btnSearch">查询</a></li>
							<!-- <li>&nbsp;&nbsp; <a href="#" class="easyui-linkbutton"
								iconCls="icon-cancel" plain="true" onclick="btnDele();">删除记录</a> -->
								<shop:permission code="Ledger_Edit">
							<li>&nbsp;&nbsp; <a href="javascript:void(0)" plain="true"
								iconCls="icon-edit" class="easyui-linkbutton" onclick="edit()">编辑</a>
							</li>
							</shop:permission>
							<!--停用，别删
							 <li>&nbsp;&nbsp; <a href="javascript:void(0)" plain="true"
								iconCls="icon-add" class="easyui-linkbutton" onclick="btnNew()">新增记录</a></li> -->
						</ul>
						<div class="clear"></div>
					</div>
				</div>
			</div>

			<div region="center" split="false" border="false"
				style="overflow: hidden; padding: 0 5px 5px 5px" id="dataList">
				<table id="data" title="" fit="true"
					data-options="collapsible: true,pagination:true,rownumbers:true">
					<thead>
						<tr>
							<th id="ds" halign="center" field="construct_material_priceId"
								align="center" sortable="true" width="60px">单价编号</th>
								
							<th halign="center" field="construct_material_seriesName"
								align="center" sortable="true" width="120px">材料系列</th>	
							<th halign="center" field="construct_material_name"
								align="center" sortable="true" width="120px">材料名称</th>
							<th halign="center" field="construct_material_model"
								align="center" sortable="true" width="120px">型号规格</th>
							<th halign="center" field="construct_material_modelId"
								hidden="hidden" align="center" sortable="true" width="120px">型号规格id</th>
							<th halign="center" field="construct_material_unit"
								align="center" sortable="true" width="120px">单位</th>
							<!-- <th halign="center" field="construct_material_brand"
								align="center" sortable="true" width="120px">品牌</th> -->
							<th halign="center" field="construct_supplier_name"
								align="center" sortable="true" width="120px">供应商</th>
							<th halign="center" field="construct_supplier_tel" align="center"
								sortable="true" width="120px">供应商电话</th>
							<th halign="center" field="construct_material_price"
								align="center" sortable="true" width="120px">最新单价</th>
							<th halign="center" field="construct_lowest_price" align="center"
								sortable="true" width="120px">最低单价</th>
							<th halign="center" field="construct_latest_price" align="center"
								sortable="true" width="120px">原价</th>
							<th halign="center" field="construct_material_remarks"
								align="center" sortable="true" width="120px">备注</th>
							<!-- <th halign="center" field="psn" align="center" sortable="true"
								width="120px" >操作</th> -->
						</tr>
					</thead>
				</table>
			</div>

		</div>



		<div id="addrow" class="easyui-window" title="修改" closed="true"
			modal="true" style="width:700px;height:500px;padding:5px;">

			<div region="north" title="用户基本信息" style="padding: 10px;"
				minHeight="350px">
				<table width="90%" class="content">

					<tr>
						<td style="display: none">单价id:</td>
						<td style="display: none"><input class="easyui-validatebox"
							type="text" name="construct_material_priceId"
							id="construct_material_priceId"  /></td>

						<td class="form-label" style="width:60px;"><a
							href="javascript:void(0)" onclick="wen('materialListCheck.do')">材料名称(选择):</a>
						</td>
						<td data-options="region:'north',title:'North Title',split:true"
							style="height:50px;"><input class="easyui-validatebox"
							type="text" name="construct_material_name"
							id="construct_material_name" value=""
							readonly="readonly" style="width: 150px"></td>

						<td style="display: none">型号规格id:</td>
						<td style="display: none"><input class="easyui-validatebox"
							type="text" name="construct_material_modelId"
							id="construct_material_modelId" value="" style="width: 150px"></td>


						<td>型号规格:</td>
						<td><input class="easyui-validatebox" type="text"
							readonly="readonly" name="construct_material_model"
							id="construct_material_model" value=""
							style="width: 150px"></td>
					</tr>

					<tr>
						<td>单位:</td>
						<td><input class="easyui-validatebox" type="text"
							readonly="readonly" name="construct_material_unit"
							id="construct_material_unit" value=""
							style="width: 150px" /></td>
						<td>备注:</td>
						<td><input class="easyui-validatebox" type="text"
							name="construct_material_remarks" value=""
							id="construct_material_remarks" style="width: 150px" /></td>
						<!-- <td>品牌:</td>
						<td><input class="easyui-validatebox" type="text"
							name="construct_material_brand" id="material_brand" value=""
							style="width: 150px" /></td> -->
					</tr>

					<!-- <tr>
						<td class="form-label" style="width:60px;"><a
							href="javascript:void(0)" onclick="wen('supplierCheck.do')">供应商(选择):</a>
						</td>
						<td><input class="easyui-validatebox" type="text"
							name="construct_material_supplier" value="" id="supplier"
							style="width: 150px" /></td>
						<td>供应商电话:</td>
						<td><input class="easyui-validatebox" type="text"
							name="construct_material_supplierTel" value="" id="construct_material_supplierTel"
							style="width: 150px" /></td>

					</tr> -->
					<tr>
						<td>最新单价:</td>
						<td><input class="easyui-validatebox" type="number"
							name="construct_material_price" value="" id="price"
							style="width: 150px" /></td>
						<td>原价:</td>
						<td><input class="easyui-validatebox" type="number"
							name="construct_latest_price" value=""
							id="construct_latest_price" style="width: 150px" /></td>
					</tr>

					<tr>
						<td>最低单价:</td>
						<td><input class="easyui-validatebox" type="number"
							name="construct_lowest_price" value=""
							id="construct_lowest_price" style="width: 150px" /></td>

					</tr>

				</table>

				<br /> <br /> <br />
				<div region="south" style="padding: 10px; text-align: center;"
					border="false">
					<a class="easyui-linkbutton"
						data-options="iconCls:'icon-system_save'" href="javascript:;"
						id="btnSave" onclick="btnSave()">保存</a>&nbsp;&nbsp;&nbsp;&nbsp; <a
						class="easyui-linkbutton"
						data-options="iconCls:'icon-system_close'" href="javascript:;"
						id="btnCancel" onclick="btnCancel()">取消</a>
				</div>
			</div>


			<div id="win" class="easyui-window"
				data-options="region:'center',title:'请选择值'" closed="true"
				style="height: 330px; width: 600px"></div>


		</div>



		<script type="text/javascript">
			var construct_supplier_id = ${construct_supplier_id};

			//新增
			function btnSave() {
				var construct_material_priceId = $("#construct_material_priceId").val();
				var construct_material_name = $("#construct_material_name").val();
				var construct_material_model = $("#construct_material_model").val();
				var construct_material_unit = $("#construct_material_unit").val();
				var material_brand = $("#material_brand").val();
				var supplier = $("#supplier").val();
				var price = $("#price").val();
				var construct_lowest_price = $("#construct_lowest_price").val();
				var construct_latest_price = $("#construct_latest_price").val();
				var material_remarks = $("#construct_material_remarks").val();
				var construct_material_supplierTel = $("#construct_material_supplierTel").val();
				var construct_material_modelId = $("#construct_material_modelId").val();

				$.ajax({
							type : 'POST',
							url : 'addmaterialprice.do',
							data : {
								'construct_material_name' : construct_material_name,
								'construct_material_model' : construct_material_model,
								'construct_material_unit' : construct_material_unit,
								'material_brand' : material_brand,
								'supplier' : supplier,
								'price' : price,
								'construct_lowest_price' : construct_lowest_price,
								'construct_latest_price' : construct_latest_price,
								'material_remarks' : material_remarks,
								'construct_material_priceId' : construct_material_priceId,
								'construct_supplier_id' : construct_supplier_id,
								'construct_material_supplierTel' : construct_material_supplierTel,
								'construct_material_modelId' : construct_material_modelId

							},

							success : function(data) {
								if (data.msg != undefined) {
										$.messager.alert("提示", data.msg,"error");
										$('#data').datagrid('reload'); 
								} else {
									$.messager.alert("提示", "操作成功！");
									$('#addrow').window('close');
									$('#data').datagrid('reload'); 
								}
							}
						});
			}

			function btnNew() {

				clear();
				$('#addrow').window('open');
			}
			
			

			function clear() {
				
				$("#construct_material_modelId").val("");
				$("#construct_material_priceId").val("");
				$("#construct_material_name").val("");
				$("#construct_material_model").val("");
				$("#construct_material_unit").val("");
				$("#construct_material_remarks").val("");
				$("#material_brand").val("value", "");
				$("#supplier").val("value", "");
				$("#price").val("");
				$("#construct_lowest_price").val("");
				$("#construct_latest_price").val("");

			}

			function btnCancel() {
				window.location.href = "materialPrice.do?construct_supplier_id="
						+ construct_supplier_id;
			}

			/***处理操作列的功能***/
			function cmdHanlder(cmd, row) {

			}

			function edit() {

				var rows = $("#data").datagrid("getSelections");
				if (rows.length == 0) {
					alert("请选择需要修改的行");
					return null;
				}
				if (rows.length > 1) {
					alert("不能选择多行喔");
					return null;
				}
				clear();
				$("#construct_material_priceId").val(
						rows[0].construct_material_priceId);
				$("#construct_material_name").val(
						rows[0].construct_material_name);
				$("#construct_material_model").val(
						rows[0].construct_material_model);
				$("#construct_material_unit").val(
						rows[0].construct_material_unit);
				$("#material_brand").val("value",
						rows[0].construct_material_brand);
				$("#supplier").val("value",
						rows[0].construct_material_supplier);
				$("#price").val(rows[0].construct_material_price);
				$("#construct_material_remarks").val(
						rows[0].construct_material_remarks);
				$("#construct_material_supplierTel").val(
						rows[0].construct_material_supplierTel);
				$("#construct_latest_price")
						.val(rows[0].construct_latest_price);
				$("#construct_lowest_price")
						.val(rows[0].construct_lowest_price);
				$("#construct_material_modelId").val(
						rows[0].construct_material_modelId);
				$('#addrow').window('open');
			}

			//删除处理
			function btnDele() {

				var rows = $("#data").datagrid("getSelections");
				if (rows.length == 0) {
					$.messager.alert("提示", "请选择需要修改的行", "info");
					return false;
				}
				if (rows.length > 1) {
					$.messager.alert("提示", "不能选择多行", "info");
					return false;
				}
				$
						.ajax({
							type : 'POST',
							url : 'deleprice.do',
							data : {
								'material_priceId' : rows[0].construct_material_priceId,
							},
							success : function(data) {
								if (data.msg != undefined) {
									$.messager.alert("提示", data.msg, "error");
									$('#data').datagrid('reload');
								} else {

									$('#data').datagrid('reload');
									$.messager.alert("提示", "删除成功！");
								}

							}
						});
			};

			$(function() {
				$("#data").admin_grid({
					queryBtn : "#btnSearch",
					excelBtn : "#btnExcel",
					cmdHanlder : cmdHanlder,

				});

			});
			//选择子页面信息	
			function wen(src) {
				var hrefs = "<iframe id='son' src='"
						+ src
						+ "' allowTransparency='true' style='border:0;width:99%;height:99%;padding-left:2px;' frameBorder='0'></iframe>";
				$("#win").html(hrefs);
				$("#win").window("open");
			}
		</script>
</body>
</html>