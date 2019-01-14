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
							<li><label>项目部名称：</label><input type="text"
								name="constuct_project_dep_name" id="constuct_project_dep_name"
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
							<th halign="center" hidden="hidden" field="constuct_project_dep_id"
								align="center" sortable="true" width="120px">项目部编号</th>
							<th halign="center" hidden="hidden" field="constuct_project_dep_company"
								align="center" sortable="true" width="120px">公司</th>	
							<th halign="center" field="constuct_project_dep_name"
								align="center" sortable="true" width="120px">项目部名称</th>
							<th halign="center" field="constuct_project_dep_leader"
								align="center" sortable="true" width="120px">项目部负责人</th>
							<!-- <th halign="center" field="psn" align="center" sortable="true"
								width="120px" formatter="operate_formatter">操作</th> -->
						</tr>
					</thead>
				</table>
			</div> 

			<div id="win" class="easyui-window" title='赋值'
				data-options="modal:true,closed:true,iconCls:'icon-save'"
				style="width:800px;height:400px;padding:10px;"></div>
		</div>
	</div>

	

	<script type="text/javascript">
		function operate_formatter(value, row, index) {
			var html = "";

			html += '<a href="javascript:;" class="opt"    cmd="constructList" i="' + index + '">项目列表</a>';

			return html;
		}
		
		
		

		

		 
		/***处理操作列的功能***/
		function cmdHanlder(cmd, row) {
			if (cmd == "constructList") {

				 location.href = "constructList.do?" + $.param({
					'constuct_project_dep_id' : row.constuct_project_dep_id, //传参项目部编号
				}); 
				//addSubPage("项目列表","constructList.do?constuct_project_dep_id="+row.constuct_project_dep_id+"");
				
				
			}
		}
         
		
		
		



		
		function onDblClickRow (rowIndex, rowData){
			
			$(window.parent.window.getDepData(rowData));
	        
	        $(window.parent.$("#win").window("close"));
		}
		
		
		/**
		 *数据初始化
		 */
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