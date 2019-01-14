<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<style>
#div_leftmenu div {
	font-size: 15px;
}

#div_leftmenu div ul {
	margin: 10px 10px 10px 10px;
	padding: 0;
	overflow: hidden;
	line-height: 40px;
}

#div_leftmenu div ul li {
	list-style-type: none;
	background-color: #DFE2E3;
	text-align: center;
	margin-bottom: 2px;
}

#div_leftmenu div ul li:last-of-type {
	margin-bottom: 0;
}
</style>

</head>
<body class="easyui-layout" style="overflow-y: hidden;" scroll="no">
	<form id="form1" method="post">

		<div id="main" region="center"
			style="background: #eee; padding: 5px; overflow-y: hidden;">


			<div class="easyui-layout" fit="true">
				<div region="north" split="false" border="false"
					style="overflow: hidden; padding: 5px 5px 28px 5px;">
					<div class="easyui-panel" title="查询条件" style="margin-bottom: 5px;">
						<div class="controls">
							<a class="easyui-linkbutton" data-options="iconCls:'icon-search'"
								href="javascript:;" id="btnSearch">查询</a>

						</div>
						<div class="search">
							<ul>
								<li><label>流程实例Id：</label><input type="text" name="processInstanceId"
									class="easyui-validatebox" style="width: 120px" /></li>

							</ul>
							<div class="clear"></div>
							<div id="tb"></div>
						</div>

					</div>
				</div>
				<div region="center" split="false" border="false"
					style="overflow: hidden; padding: 0 5px 5px 5px" id="dataList">
					<table id="data" title="" fit="true"
						data-options="collapsible:true,pagination:true,rownumbers:true">

						<thead>
							<tr>
								<th halign="center" field="PROC_INST_ID_" align="center"
									sortable="true" width="80px">流程实例ID</th>
								<th halign="center" field=rdtName align="center" sortable="true"
									width="80px">待办类型</th>
								<th halign="center" field="BUSINESS_KEY_" align="center"
									sortable="true" width="130px">单据关联ID</th>
								<th halign="center" field="NAME_" align="center" sortable="true"
									width="80px">节点名称</th>

								<th halign="center" field="START_TIME_" align="center"
									sortable="true" width="200px" formatter="dateformat">开始时间</th>
								<th halign="center" field="END_TIME_" align="center"
									sortable="true" width="200px" formatter="dateformat">结束时间</th>
								<th halign="center" field="DELETE_REASON_" align="center"
									sortable="true" width="200px">删除流程原因</th>

								<th id="ds" halign="center" field="caozuo" sortable="true"
									width="200px" formatter="operate_formatter">操作</th>

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
			html += '<a href="javascript:;" class="opt"    cmd="handle" i="' + index + '">查看单据</a>';
			return html;
		}
		function formatDate(now) {
			var date = new Date(now);
			var year = date.getFullYear();
			var month = (date.getMonth() + 1);
			var day = date.getDate();
			var hour = date.getHours();
			var minutes = date.getMinutes();
			var seconds = date.getSeconds();
			return year + "-" + month + "-" + day + " " + hour + ":" + minutes
					+ ":" + seconds;
		}
		function dateformat(value, row, index) {
			if (value == undefined)
				return "";
			var now = new Date(value);
			return formatDate(now);

		}
		/***处理操作列的功能***/
		function cmdHanlder(cmd, row) {
			if (cmd == 'handle') {
				var rows = row.BUSINESS_KEY_;

				var str = rows.split('.');

				location.href = str[0] + ".do?bizId=" + str[1];
			}

		}
		$(function() {

			$("#data").admin_grid({
				queryBtn : "#btnSearch",

				cmdHanlder : cmdHanlder,
			});

		});
	</script>

</body>
</html>