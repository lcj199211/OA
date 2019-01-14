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
		<input type="hidden" name="userid" value="${param.userid}">
		<div id="main" region="center"
			style="background: #eee; padding: 5px; overflow-y: hidden;">
			<div class="easyui-layout" fit="true">
				<div region="north" split="false" border="false"
					style="overflow: hidden; padding: 5px 5px 28px 5px;">
					<div class="easyui-panel" title="查询条件" style="margin-bottom: 5px;">
					 <div class="controls">
							<a class="easyui-linkbutton" data-options="iconCls:'icon-search'"
								href="javascript:;" id="btnSearch">查询</a> <a
								class="easyui-linkbutton"
								data-options="iconCls:'icon-page_excel'" id="btnExcel">导出Excel</a>
						</div>

						<div class="search">

							<ul>
								<li><label>中心名称：</label><input type="text" name="flow_name"
									id="flow_name" class="easyui-validatebox" style="width: 120px" /></li>
								<li><label>年/月：</label><input type="text"
									name="gad_paylist_month" id="gad_paylist_month"
									class="easyui-validatebox" style="width: 120px" /></li>


							</ul>
							<div class="clear"></div>
						</div>
						<div id="tb">
							<a href="#" class="easyui-linkbutton" iconCls="icon-cancel"
								plain="true" onclick="btnDele();">删除记录</a> <a href="#"
								class="easyui-linkbutton" iconCls="icon-add" plain="true"
								onclick="addPayroll();">新建工资</a> <a href="#"
								class="easyui-linkbutton" iconCls="icon-edit" plain="true"
								onclick="editPayroll();">修改工资</a>
								 <a href="#"
								class="easyui-linkbutton" iconCls="icon-tip" plain="true"
								onclick="payrollView();">查看</a>
						</div>
					</div>
				</div>


				<div region="center" split="false" border="false"
					style="overflow: hidden; padding: 0 5px 5px 5px" id="dataList">
					<table id="data" title="" fit="true" class="easyui-datagrid"
						data-options="collapsible: true,pagination:true,rownumbers:true,showFooter:true,
						">
						<tr>
							<td><input type="hidden" name="trade_id" value="" /></td>
						</tr>
						<thead>
							<tr>
								<th id="ds" halign="center" field="gad_paylist_id"
									align="center" sortable="true" width="60px">编号</th>
								<th halign="center" field="gad_paylist_centerid" align="center"
									hidden="hidden" sortable="true" width="120px">中心id</th>
								<th halign="center" field="center_name" align="center"
									sortable="true" width="120px">中心名称</th>
								<th halign="center" field="gad_paylist_month" align="center"
									sortable="true" width="120px">月份</th>
								<th halign="center" field="gad_paylist_men_num" align="center"
									sortable="true" width="120px">人数</th>
								<th halign="center" field="gad_paylist_payroll" align="center"
									sortable="true" width="120px">实发工资</th>
								<th halign="center" field="flow_description" align="center"
									sortable="true" width="120px">占整体比率</th>
								<th halign="center" field="gad_paylist_remarks" align="center"
									sortable="true" width="120px">备注</th>
								<!-- <th halign="center" field="psn" align="center" sortable="true"
									width="120px" formatter="operate_formatter">操作</th> -->
							</tr>
						</thead>
					</table>
				</div>

			</div>
		</div>

	</form>




	<script type="text/javascript">
	
		
		function operate_formatter(value, row, index) {
			var html = "";

			html += '<a href="javascript:;" class="opt"  data-options="iconCls:\'icon-cut\',plain:true"  cmd="view" i="' + index + '">查看</a>';

			return html;
		}
	
		function dateformat(value, row, index) {
			if (value == undefined)
				return "";
			var date = new Date(value);
			var pattern = "yyyy-MM-dd hh:mm:ss";
			return date.format(pattern);
		}

		function status_formatter(value, row, index) {
			if (value == 1) {
				return "启用";
			} else if (value == 2) {
				return "禁用";

			}
		}

		function addPayroll() {
			location.href = "payrollNew.do?id=";

		}
		function editPayroll() {
			var rows = $("#data").datagrid("getSelections");//获取表格数据
			if (rows.length == 0) {
				alert("请选择需要修改的行");
				return null;
			} else if (rows.length > 1) {
				alert("一次只能选择一行喔！");
				return null;
			} else {
				var id = rows[0].gad_paylist_id;
				location.href = "payrollNew.do?id=" + id + "";
			}
		}

		/***处理操作列的功能***/
		function cmdHanlder(cmd, row) {
			if (cmd == "view") {
				location.href = "payrollView.do?" + $.param({
					'gad_paylist_id' : row.gad_paylist_id, //
				});
			}
		}
		
		function payrollView() {
			var rows = $("#data").datagrid("getSelections");//获取表格数据
			if (rows.length == 0) {
				alert("请选择需要查看的行");
				return null;
			} else if (rows.length > 1) {
				alert("一次只能选择一行喔！");
				return null;
			}
			location.href = "payrollView.do?" + $.param({
				'gad_paylist_id' : rows[0].gad_paylist_id, //
			});
		}
		
		
		//批量删除处理
		function btnDele() {
			var rows = $("#data").datagrid("getSelections");//获取表格数据
			if (rows.length == 0) {
				alert("请选择需要删除的行");
				return null;
			} else if (rows.length > 1) {
				alert("一次只能选择一行喔！");
				return null;
			}
			$.ajax({
				type : 'POST',
				url : 'delePurchase.do',
				traditional : true,
				data : {
					'cid' : JSON.stringify(rows[0].gad_paylist_id)
				},
				success : function(data) {
					if (data == "") {
						alert("删除成功");
						location.reload();
					} else {
						alert("删除失败");
				}
				}
		});
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