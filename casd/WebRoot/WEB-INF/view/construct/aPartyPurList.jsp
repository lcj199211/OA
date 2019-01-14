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

<style type="text/css">
   /* 状态显示颜色  */
.datagrid-cell-c1-construct_Aparty_purchase_status {
    color: red;


</style>

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
							<li><label>订单号：</label><input type="text"
								name="construct_Aparty_purchase_orderNum"
								id="construct_Aparty_purchase_orderNum"
								class="easyui-validatebox" style="width: 120px" /></li>
							<li>&nbsp;&nbsp; <a class="easyui-linkbutton"
								data-options="iconCls:'icon-search'" href="javascript:;"
								id="btnSearch">查询</a></li>

							<li>&nbsp;&nbsp; <a href="#" class="easyui-linkbutton"
								iconCls="icon-cancel" plain="true" onclick="btnDele();">删除订单</a></li>
							<shop:permission code="ADD_PROJECT_AP">
								<li>&nbsp;&nbsp; <a href="#" class="easyui-linkbutton"
									iconCls="icon-edit" plain="true" onclick="btnUpdate();">修改订单</a></li>
								<li>&nbsp;&nbsp; <a href="#" class="easyui-linkbutton"
									iconCls="icon-add" plain="true" onclick="btnAdd();">新增订单</a></li>
							</shop:permission>
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
							<th halign="center" field="construct_Aparty_purchase_id"
								align="center" hidden="hidden" sortable="true" width="60px">ID</th>
							<th halign="center" field="construct_Aparty_purchase_constructId"
								align="center" hidden="hidden" sortable="true" width="60px">项目ID</th>
							<th halign="center" field="construct_Aparty_purchase_orderNum"
								align="center" sortable="true" width="60px">订单编号</th>
							<th halign="center" field="construct_Aparty_purchase_creatTime"
								align="center" sortable="true" width="70px"
								formatter="creatTime">创建时间</th>
							<th halign="center" field="construct_project_name" align="center"
								sortable="true" width="220px">项目名称</th>
							<th halign="center" field="construct_project_addr" align="center"
								sortable="true" width="250px">收货地址</th>
							<th halign="center" field="construct_project_leader"
								align="center" sortable="true" width="120px">项目经理</th>
							<th halign="center" field="construct_project_leaderTel"
								align="center" sortable="true" width="120px">项目经理联系方式</th>
							<th halign="center" field="construct_Aparty_purchase_supplier"
								align="center" sortable="true" width="120px">供货单位</th>
							<th halign="center" field="construct_Aparty_purchase_contacts"
								align="center" sortable="true" width="120px">联系人</th>
							<th halign="center" field="construct_Aparty_purchase_tel"
								align="center" sortable="true" width="120px">联系电话</th>
							<th halign="center" field="construct_Aparty_purchase_status"
								align="center" sortable="true" width="100px" formatter="operate_status">状态</th>	
					
							<th halign="center" field="psn" align="center" sortable="true"
								width="120px" formatter="operate_formatter">操作</th>
						</tr>
					</thead>
				</table>
			</div>

		</div>
	</div>





	<script type="text/javascript">
		function operate_formatter(value, row, index) {
			var html = "";

			html += '<a href="javascript:;" class="opt"    cmd="aPartyPurView" i="' + index + '">查看订单</a>';

			return html;
		}

		function operate_status(value, row, index){
			if(value == 0){
				return "初始录入";
			} else if (value == 1) {
				return "审核中";
			} else if (value ==2) {
				return "审核通过";
			}else if (value ==3) {
				return "驳回";
			}
		}
		
		
		function formatDate(now) {
			
			var year = now.getFullYear();
			var month = now.getMonth() + 1;
			var date = now.getDate();
			return year + "-" + month + "-" + date;
		}
		
		
		 function creatTime(value, row, index) {
			if (value == undefined||value=="")
				return "";
			var  now=new  Date(value); 
			return formatDate(now); 
		}
		
		//新增
		function btnAdd() {

			location.href = "aPartyPurNew.do?construct_project_id="
					+ ${construct_project_id}
					+ "&construct_Aparty_purchase_id=";

		}

		//修改
		function btnUpdate() {

			var rows = $("#data").datagrid("getSelections");//获取表格数据
			if (rows.length == 0) {
				alert("请选择需要修改的行");
				return null;
			} else if (rows.length > 1) {
				alert("只能选一行");
				return null;
			}

			location.href = "aPartyPurNew.do?construct_project_id="
					+ ${construct_project_id}
					+ "&construct_Aparty_purchase_id="
					+ rows[0].construct_Aparty_purchase_id;

		}

		function formatDate(now) {
			var year = now.getFullYear();
			var month = now.getMonth() + 1;
			var date = now.getDate();
			return year + "-" + month + "-" + date;
		}

		function endDate(value, row, index) {
			if (value == undefined || value == "")
				return "";
			var now = new Date(value);
			return formatDate(now);

		}
		function startDate(value, row, index) {
			if (value == undefined || value == "")
				return "";
			var now = new Date(value);
			return formatDate(now);

		}

		/***处理操作列的功能***/
		function cmdHanlder(cmd, row) {
			if (cmd == "aPartyPurView") {
				location.href = "aPartyPurView.do?"
						+ $.param({
									'construct_project_id' : ${construct_project_id},
									'construct_Aparty_purchase_id' : row.construct_Aparty_purchase_id,
								});

			}
		}

		//批量删除处理
		function btnDele() {
			var rows = $("#data").datagrid("getSelections");//获取表格数据
			if (rows.length == 0) {
				alert("请选择需要删除的行");
				return null;
			} else if (rows.length > 1) {
				alert("只能选一行");
				return null;
			}

			$.ajax({
				type : 'POST',
				url : 'dele_apartyPur.do',
				traditional : true,
				data : {
					'id' : rows[0].construct_Aparty_purchase_id
				},
				success : function(data) {
					if (data.Success) {
						$.messager.alert("提示", data.msg, "info", function() {
							location.reload(true);
						});
					} else {
						$.messager.alert("提示", data.msg, "error");

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
	</script>

</body>
</html>