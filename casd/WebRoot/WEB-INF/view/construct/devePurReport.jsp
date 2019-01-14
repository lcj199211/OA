<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="PowerCheck" prefix="shop"%>
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
					<div class="easyui-panel" title="操作" style="margin-bottom: 5px;">
						<div class="controls">
							<a class="easyui-linkbutton" data-options="iconCls:'icon-search'"
								href="javascript:;" id="btnSearch">查询</a>

						</div>
						<div class="search">
							<ul>
							<li><label><a href="javascript:void(0)"
										onclick="wen('deveConCheck.do')">项目(选择):</a></label><input type="text" name="construct_project_name" id="construct_project_name" 
								class="easyui-validatebox" style="width: 120px" /></li>
								
								<li><label>材料名称</label><input type="text" name="construct_purchase_material" id="construct_purchase_material" 
								class="easyui-validatebox" style="width: 120px" /></li>
								
								
							<li><label> 状态：</label> <select id="construct_purchase_status" name="construct_purchase_status"
										class="easyui-combobox" style="width:120px;">
											<option value="">请选择</option>
											<option value="0">保存</option>
											<option value="1">项目经理提交</option>
											<option value="2">经营部审核</option>
											<option value="3">总经理审核</option>
											<option value="4">采购核对单价</option>
											<option value="5">财务经理审批</option>
											<option value="6">董事会审核</option>
											<option value="7">下单</option>
											<option value="8">配货</option>
											<option value="9">签收</option>
											<option value="10">财务复核价格及数量</option>
											<option value="11">申请请款</option>
											<option value="12">通知财务审核</option>
											<option value="13">待付款</option>
											
									</select></li>	
									
							</ul>
							<div class="clear"></div>
						</div>

					</div>
				</div>
				<div region="center" split="false" border="false"
					style="overflow: hidden; padding: 0 5px 5px 5px" id="dataList">
					<table id="data" title="" fit="true"
						data-options="collapsible: true,pagination:true,">

						<thead>
							<tr>
								<!-- <th halign="center" field="construct_purchase_id" align="center" sortable="true" 
									width="120px" >编号</th> -->
								
								<th halign="center" field="construct_project_name" align="center" sortable="true"
									width="120px">项目名称</th>
								<th halign="center" field="construct_purchase_creatTime" align="center" sortable="true"
									width="120px">建单时间</th>	
								<th halign="center" field="construct_purchase_status" align="center" sortable="true" formatter="status_formatter"
									width="120px">采购状态</th>
								<th halign="center" field="construct_purchase_material" align="center" sortable="true" 
									width="120px">材料名称</th>	
								<th halign="center" field="construct_purchase_model" align="center" sortable="true" 
									width="120px">规格名称</th>
								<th halign="center" field="construct_purchase_unit" align="center" sortable="true" 
									width="120px">单位</th>	
								<th halign="center" field="construct_purchase_quantities" align="center" sortable="true" 
									width="120px">合同量</th>	
								<th halign="center" field="construct_purchase_applyNum" align="center" sortable="true" 
									width="120px">采购量</th>
								<th halign="center" field="construct_purchase_approvalNum" align="center" sortable="true" 
									width="120px">累计审批量</th>
								<th halign="center" field="construct_purchase_purchasePrice" align="center" sortable="true" 
									width="120px">采购单价</th>
								<th halign="center" field="construct_purchase_purchaseTotal" align="center" sortable="true" 
									width="120px">采购小计</th>											
								<!-- <th halign="center" field="operate" sortable="true" width="100px"align="center"
									formatter="operate_formatter">操作</th> -->

							</tr>
						</thead>

					</table>
				</div>

			</div>
		</div>

	</form>

<div id="win" class="easyui-window"
				data-options="region:'center',title:'请选择值'" closed="true"
				style="height: 400px; width: 700px"></div>


	<script type="text/javascript">
		function operate_formatter(value, row, index) {
			var html = "";
			html += '<a href="javascript:;" class="opt"    cmd="handle" i="' + index + '">查看</a>';

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
		
		function company_formatter(value, row, index) {
			if (value == 1){
				return "建设公司";
			}else{
				return "科技公司";
				
			}
		}
		
		function status_formatter(value, row, index) {
			switch (value) {
			case 0:
				return "保存";
				break;
			case 1:
				return "项目经理提交";
				break;
			case 2:
				return "经营部审核";
				break;
			case 3:
				return "总经理审核";
				break;
			case 4:
				return "采购核对单价";
				break;
			case 5:
				return "财务经理审批";
				break;
			case 6:
				return "董事会审核";
				break;
			case 7:
				return "下单";
				break;
			case 8:
				return "配货";
				break;
			case 9:
				return "签收";
				break;
			case 10:
				return "财务复核价格及数量";
				break;
			case 11:
				return "申请请款";
				break;
			case 12:
				return "通知财务审核";
				break;
			case 13:
				return "待付款";
				break;		
			default:
				break;
			}
			
		}
		
		function wen(src) {
			var hrefs = "<iframe id='son' src='"
					+ src
					+ "' allowTransparency='true' style='border:0;width:99%;height:99%;padding-left:2px;' frameBorder='0'></iframe>";
			$("#win").html(hrefs);
			$("#win").window("open");
		}
		function constructData(rowData) {
			$("#construct_project_name").val(
					rowData.construct_project_name);
		}
		
		/***处理操作列的功能***/
		function cmdHanlder(cmd, row) {
			//办理任务
			if (cmd == "handle") {

				location.href = "Purchase_payment.do?" + $.param({
					'bizId' : row.construct_purchase_id, 
				});

			} 

		}
		/**
		 *  删除流程实例
		 */

		function deleteProcessInstance() {

			var processInstanceId = $("#processInstanceId").val();
			$.ajax({
				url : 'deleteProcessInstance.do',
				type : 'post',
				data : {
					'processInstanceId' : processInstanceId,
				},
				success : function(data) {
					if (data.Success) {
						$.messager.alert("提示", data.Msg, "info", function() {
							location.href = "findTaskList.do";
						});
					} else {
						$.messager.alert("提示", data.Msg, "error");
					}
				}

			})
		};

		$(function() {

			$("#data").admin_grid({
				queryBtn : "#btnSearch",
				excelBtn : "#btnExcel",
				cmdHanlder : cmdHanlder,
				onLoadSuccess: function(data){
					var mark=1;
					for (var i=1; i <data.rows.length; i++) {
						if (data.rows[i]['construct_project_name'] == data.rows[i-1]['construct_project_name']) {
							mark += 1;
							$(this).datagrid('mergeCells',{ 
								index: i+1-mark, 
								field: 'construct_project_name',
								rowspan:mark
							});
						}else{
							mark=1;     
						}
					}
					
				},
			});

		});
	</script>

</body>
</html>