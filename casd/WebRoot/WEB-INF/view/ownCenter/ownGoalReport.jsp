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
							<li><label>年度：</label><input type="text"
								name="goal_year"  id="goal_year"
								class="easyui-validatebox" style="width: 120px" /></li>
							<li><label>公司：</label><input type="text"
								name="company"  id="company"
								class="easyui-validatebox" style="width: 120px" /></li>
							<li><label>中心：</label><input type="text"
								name="center"  id="center"
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
							<th halign="center" field="company_name"
								align="center" sortable="true" width="120px">公司</th>
							<th halign="center" field="center_name"
								align="center" sortable="true" width="120px">中心</th>	
							
							<th halign="center" field="own_goal_userName"
								align="center" sortable="true" width="120px">姓名</th>	
							<th halign="center" field="own_goal_year"
								align="center" sortable="true" width="120px">年度</th>
								
							<th halign="center" field="goalTotal"
								align="center" sortable="true" width="120px">总数</th>
							<th halign="center" field="workGoalUnfinish"
								align="center" sortable="true" width="120px">未完成工作目标</th>
							<th halign="center" field="workGoalFinish"
								align="center" sortable="true" width="120px">完成工作目标</th>
							<th halign="center" field="lifeGoalFinish"
								align="center" sortable="true" width="120px">完成生活目标</th>
							<th halign="center" field="lifeGoalUnfinish"
								align="center" sortable="true" width="120px">未完成生活目标</th>
							<th halign="center" field="lifePer" formatter="operate_lifePer"
								align="center" sortable="true" width="120px">生活目标完成率</th>
							<th halign="center" field="workPer" formatter="operate_workPer"
								align="center" sortable="true" width="120px">工作目标完成率</th>
							<th halign="center" field="per"  formatter="operate_per"
								align="center" sortable="true" width="120px">目标完成率</th>							
								
						</tr>
					</thead>
				</table>
			</div>

		</div>

</div>




		<script type="text/javascript">
			var date=new Date;
		 	var year=date.getFullYear();
		 	$('#goal_year').val(year);
			
			function operate_type(value, row, index){
				if(value===1){
					return "工作目标";
				}else if(value===2){
					return "生活目标";
				}
			}
			function operate_isFinish(value, row, index){
				if(value===1){
					return "完成";
				}else if(value===0){
					return "未完成";
				}
			}
			
			function operate_lifePer(value, row, index){
				var lifeGoalFinish=row.lifeGoalFinish;
				var lifeGoalUnfinish=row.lifeGoalUnfinish;
				if(Number(lifeGoalFinish)+Number(lifeGoalUnfinish)!=0){
					return (Number(lifeGoalFinish)/(Number(lifeGoalFinish)+Number(lifeGoalUnfinish))).toFixed(4)*100+"%";
				}else{
					return 0;
				}
			}
			
			function operate_workPer(value, row, index){
				
				var workGoalUnfinish=row.workGoalUnfinish;
				var workGoalFinish=row.workGoalFinish;
				if(Number(workGoalFinish)+Number(workGoalUnfinish)!=0){
					return (Number(workGoalFinish)/(Number(workGoalFinish)+Number(workGoalUnfinish))).toFixed(4)*100+"%";
				}else{
					return 0;
				}
				
			}
			function operate_per(value, row, index){
				
				var goalTotal=row.goalTotal;

				var lifeGoalFinish=row.lifeGoalFinish;
				var workGoalFinish=row.workGoalFinish;
				if(goalTotal!=null&& Number(goalTotal)!=0){
					return ((Number(lifeGoalFinish)+Number(workGoalFinish))/Number(goalTotal)).toFixed(4)*100+"%";
				}else{
					return 0;
				}
				
			}
			
			function onDblClickRow (rowIndex, rowData){    
		       
		        
				window.location.href = "ownGoalList.do?userId="+rowData.own_goal_userId+"&goal_year="+rowData.own_goal_year;		        
		        
	   		};
			
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