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
							<li><label>采购单号：</label><input type="text"
								name="construct_purchase_id" id="construct_purchase_id"
								class="easyui-validatebox" style="width: 100px" /></li>
							<li><label>材料类别：</label><input type="text"
								name="construct_purchase_materialSerName" id="construct_purchase_materialSerName"
								class="easyui-validatebox" style="width: 100px" /></li>	
							<li><a class="easyui-linkbutton"
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
					data-options="collapsible: true,pagination:true,rownumbers:true,onDblClickRow:onDblClickRow">
					<thead>
						<tr>
							<th halign="center" field="construct_purchase_id" align="center"
								sortable="true" width="60px">采购单号</th>
							<th halign="center" field="construct_purchase_materialSerName" align="center"
								sortable="true" width="60px">材料分类</th>
							<th halign="center" field="construct_purchase_planMan" align="center"
								sortable="true" width="60px">计划员</th>
							<th halign="center" field="construct_purchase_reviewer" align="center"
								sortable="true" width="120px">复核员</th>
							<th halign="center" field="construct_purchase_supplier"
								align="center" sortable="true" width="120px">供应商</th>
							<th halign="center" field="construct_project_name"
								align="center" sortable="true" width="120px">项目</th>
							<th halign="center" field="construct_project_id"
								align="center" sortable="true" width="120px" hidden="hidden">项目id</th>	
							<th halign="center" field="arrived_money"
								align="center" sortable="true" width="120px">结算金额</th>
							<!-- <th halign="center" field="psn" align="center" sortable="true"
								width="120px" formatter="operate_formatter">操作</th> -->
						</tr>
					</thead>
				</table>
			</div>

		</div>
	</div>





	<script type="text/javascript">
		function operate_formatter(value, row, index) {
			var html = "";

			html += '<a href="javascript:;" class="opt"    cmd="view" i="' + index + '">查看</a>';

			return html;
		}

		function formatDate(now) {
			var year = now.getFullYear();
			var month = now.getMonth() + 1;
			var date = now.getDate();
			return year + "-" + month + "-" + date;
		}

		function dateformat(value, row, index) {
			if (value == undefined)
				return "";
			var now = new Date(value);
			return formatDate(now);

		}
		function status_formatter(value, row, index) {
			if (value == 0) {
				return "保存";
			} else if (value == 1) {
				return "审批不通过";
			} else if (value == 2) {
				return "审核中";
			} else if (value == 3) {
				return "审批通过、未采购";

			} else if (value == 4) {
				return "采购确认中";

			} else if (value == 5) {
				return "已采购确认、未到货";

			} else if (value == 6) {
				return "部分到货";

			} else if (value == 7) {
				return "全部到货";

			}
		}

		/***处理操作列的功能***/
		function cmdHanlder(cmd, row) {
			if (cmd == "view") {

				location.href = "updateArrivePurchaseNum.do?"
						+ $
								.param({
									'construct_purchase_arrived_id' : row.construct_purchase_arrived_id,
									'construct_purchase_id' : row.construct_purchase_id
								});

			}
		}

		//双击选择
		function onDblClickRow(rowIndex, rowData) {
			var index = ${index};
			$(window.parent.window.purData(rowData, index));
			$(window.parent.$("#win").window("close"));
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