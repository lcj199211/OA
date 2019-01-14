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
								<li><label>项目名称：</label><input type="text" name="constuct_project_dep_name", id="construct_project_name"
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
								<th id="ds" halign="center" field="construct_project_id" align="center"
									sortable="true" width="60px">项目编号</th>
								<th halign="center" field="construct_project_name" align="center"
									sortable="true" width="220px">项目名称</th>
								
								
								<th halign="center" field="manage_contract_firstParty" align="center"
									sortable="true" width="250px">甲方</th>
									
								<th halign="center" field="construct_project_addr" align="center" 
									sortable="true" width="250px">工程地址</th>
								<th halign="center" field="construct_project_leader" align="center" 
									sortable="true" width="120px">项目经理</th>
								<th halign="center" field="construct_project_leaderTel" align="center" 
									sortable="true" width="120px">项目经理联系方式</th>
							</tr>
						</thead>
					</table>
				</div>

			</div>
		</div>





	<script type="text/javascript">
		function   formatDate(now)   {     
            var   year=now.getFullYear();     
            var   month=now.getMonth()+1;     
            var   date=now.getDate();     
            return   year+"-"+month+"-"+date;
            }     
       
		
		 function endDate(value, row, index) {
			if (value == undefined||value=="")
				return "";
			 var  now=new   Date(value); 
			return formatDate(now); 
		   
		}
		 function startDate(value, row, index) {
				if (value == undefined||value=="")
					return "";
				 var  now=new   Date(value); 
				return formatDate(now); 
			   
			}
		
		 function category(value, row, index) {
				if(value==1)
					return "预埋";
				if(value==2)
					return "消防水";
				if(value==3)
					return "消防电";
				if(value==4)
					return "防排烟";
			}

		 
		 function onDblClickRow (rowIndex, rowData){
				
				$(window.parent.window.constructData(rowData));
		        
		        $(window.parent.$("#win").window("close"));
			}
		
		$(function() {
			$("#data").admin_grid({
				queryBtn : "#btnSearch",
				excelBtn : "#btnExcel",
				//cmdHanlder : cmdHanlder,

			});

		});
	</script>

</body>
</html>