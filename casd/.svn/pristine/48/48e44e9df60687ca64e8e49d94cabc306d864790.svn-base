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

<script
	src="<%=request.getContextPath()%>/res/admin/scripts/jquery.ajaxfileupload.js"
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
							<li><label>材料类别：</label><input type="text"
								name="material_category"
								id="material_category"
								class="easyui-validatebox" style="width: 120px" /></li>

							<li><label>材料名称：</label><input type="text"
								name="material_name"
								id="material_name" class="easyui-validatebox"
								style="width: 120px" /></li>

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
					data-options="collapsible: true,pagination:true,rownumbers:true
						,showFooter: true,onDblClickRow: onDblClickRow">
					<thead>
						<tr>
							<th halign="center" field="construct_Aparty_material_constructId"
								align="center" hidden="hidden" sortable="true" width="60px">项目编号</th>
							<th halign="center" hidden="hidden"
								field="construct_Aparty_material_id" align="center"
								sortable="true" width="60px">编号</th>

							<th halign="center" field="construct_Aparty_material_category"
								align="center" sortable="true" width="120px">材料类别</th>

							<th halign="center" field="construct_Aparty_material_name"
								align="center" sortable="true" width="120px">材料名称</th>
							<th halign="center" field="construct_Aparty_material_model"
								align="center" sortable="true" width="120px">型号规格</th>
							<th halign="center" field="construct_Aparty_material_unit"
								align="center" sortable="true" width="120px">单位</th>
							<th halign="center" field="construct_Aparty_material_num"
								align="center" sortable="true" width="120px">合同量</th>
							<th halign="center" field="construct_Aparty_material_remark"
								align="center" sortable="true" width="120px">备注</th>
						</tr>
					</thead>
				</table>
			</div>

			<div id="addrow" class="easyui-window" title="新增合同工程量" closed="true"
				modal="true" style="width:700px;height:500px;padding:5px;">

				<div region="north" title="用户基本信息" style="padding: 10px;"
					minHeight="350px">
					<form id="aPartyMaterial" action="" method="post">
						<table width="90%" class="content">
							<tr>
								<td hidden="hidden"><input
									name="construct_Aparty_material_id"
									id="construct_Aparty_material_id" value=""
									type="text"></input></td>
								<td hidden="hidden"><input type="text"
									name="construct_Aparty_material_constructId"
									id="construct_Aparty_material_constructId" value="" /></td>
								<td>材料类别</td>
								<td><input name="construct_Aparty_material_category"
									id="construct_Aparty_material_category" type="text"></input></td>
								<td>材料名称</td>
								<td><input name="construct_Aparty_material_name"
									id="construct_Aparty_material_name" type="text"></input></td>
							</tr>

							<tr>
								<td>型号规格:</td>
								<td><input name="construct_Aparty_material_model"
									id="construct_Aparty_material_model" type="text"></input></td>
								<td>单位:</td>
								<td><input class="easyui-validatebox" type="text"
									name="construct_Aparty_material_unit"
									id="construct_Aparty_material_unit" /></td>

							</tr>
							<tr>
								<td>数量:</td>
								<td><input type="text"
									name="construct_Aparty_material_num" id="construct_Aparty_material_num"
									value="0" /></td>
								<td>备注:</td>
								<td><input class="easyui-validatebox" type="text"
									name="construct_Aparty_material_remark"
									id="construct_Aparty_material_remark" /></td>
							</tr>

						</table>
					</form>
					<br /> <br /> <br />
					<div region="south" style="padding: 10px; text-align: center;"
						border="false">
						<a class="easyui-linkbutton"
							data-options="iconCls:'icon-system_save'" href="javascript:;"
							id="btnSave" onclick="save_aPartyMaterial();">保存</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="easyui-linkbutton"
							data-options="iconCls:'icon-system_close'" href="javascript:;"
							id="btnCancel" onclick="$('#addrow').window('close')">取消</a>
					</div>
				</div>
				<div id="uploads" class="easyui-window"
					data-options="region:'center',title:'请选择值'" closed="true"
					style="height: 100px; width: 400px;padding: 10px;">

					<form id="jvForm" action="" method="post"
						enctype="multipart/form-data">
						<table>
							<tbody>
								<tr>
									<td width="80%"><input name="pic" type="file" id="file" />
										<a class="easyui-linkbutton"
										data-options="iconCls:'icon-system_save'"
										onclick="uploadPic();" href="javascript:;" id="btnSaveExp">导入Excel</a>

									</td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>





	<script type="text/javascript">

		function dateformat(value, row, index) {
			if (value == undefined)
				return "";
			var date = new Date(value);
			var pattern = "yyyy-MM-dd hh:mm:ss";
			return date.format(pattern);
		}

		function onDblClickRow (rowIndex, rowData){
			
			
			
			$(window.parent.window.aPartyMateData(rowData,${index}));
	        
	        $(window.parent.$("#win").window("close"));
		}
		

		/***处理操作列的功能***/
		function cmdHanlder(cmd, rows) {

		}



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