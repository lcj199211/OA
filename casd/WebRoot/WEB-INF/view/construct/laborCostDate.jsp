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
								<li><label>日期：</label><input type="text" name="hr_attend_date", id="hr_attend_date"
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
						data-options="collapsible: true,pagination:true,rownumbers:true">
						<thead>
							<tr>
								 
								<th halign="center" field="construct_project_name" align="center"
									sortable="true" width="120px" formatter="name_num" >项目</th>
								<th halign="center" field="manage_contract_num" align="center"
									sortable="true" width="60px" hidden="hidden">合同编码</th>
								<th halign="center" field="construct_project_workTeam_category" align="center"
									sortable="true" width="120px" formatter="category" >施工项目</th>
								<th halign="center" field="hr_attend_workTeamId" align="center"
									sortable="true" width="120px" hidden="hidden" >施工项目id</th>		
								<th halign="center" field="username" align="center" 
									sortable="true" width="120px">班组</th>
								<th halign="center" field="hr_attend_date" align="center" 
									sortable="true" width="120px">日期</th>
								<th halign="center" field="construct_project_workTeam_price" align="center" 
									sortable="true" width="120px">单价</th>
								<th halign="center" field="num" align="center" 
									sortable="true" width="100px" >上班人数</th>	
								<th halign="center" field="jan" align="center" 
									sortable="true" width="100px" formatter="amount">金额</th>
							</tr>
						</thead>
					</table>
				</div>

			</div>
		</div>





	<script type="text/javascript">
		function operate_formatter(value, row, index) {
			var html = "";

			html += '<a href="javascript:;" class="opt"    cmd="taskList" i="' + index + '">项目作业</a>';

			return html;
		}
		
		
		function name_num (value, row, index){
			
			return value+"<br>"+row.manage_contract_num;
			
		}
		
		 function amount(value, row, index) {
			 
			return (parseFloat(row.construct_project_workTeam_price)*parseFloat(row.num)).toFixed(2);
		}
		 
		 
		 function category(value, row, index) {
				switch (value) {
				case 1:
					return "预埋"; 
					break;
				case 2:
					return "消防水"; 
					break;
				case 3:
					return "消防电"; 
					break;
				case 4:
					return "防排烟"; 
					break;	
				default:
					break;
				}
				
				
			   
		}
		 

		/***处理操作列的功能***/
		function cmdHanlder(cmd, row) {
		}

		
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
				
				onClickRow: function (rowIndex, rowData) {
		            $(this).datagrid('unselectRow', rowIndex);
				},
				
				onDblClickCell: function (rowIndex, field, value) {
						 var row = $('#data').datagrid("selectRow", rowIndex)
							.datagrid("getSelected");
						   
						 location.href = "laborCostAttend.do?hr_attend_date="+row.hr_attend_date+"&hr_attend_workTeamId="+row.hr_attend_workTeamId;
					 }
					 
			
			});
			
			
				
			
		});
	</script>

</body>
</html>