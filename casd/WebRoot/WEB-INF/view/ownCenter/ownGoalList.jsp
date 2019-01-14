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

							<li>&nbsp;&nbsp; <a class="easyui-linkbutton"
								data-options="iconCls:'icon-search'" href="javascript:;"
								id="btnSearch">查询</a></li>
							<!-- <li>&nbsp;&nbsp; <a href="#" class="easyui-linkbutton"
								iconCls="icon-cancel" plain="true" onclick="btnDele();">删除记录</a> -->
							<!-- <li>&nbsp;&nbsp; <a href="javascript:void(0)" plain="true"
								iconCls="icon-edit" class="easyui-linkbutton" onclick="edit()">编辑</a>
							</li> -->
							 <li>&nbsp;&nbsp; <a href="javascript:void(0)" plain="true"
								iconCls="icon-add" class="easyui-linkbutton" onclick="btnNew()">新增记录</a></li> 
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
							<th halign="center" field="own_goal_id"
								align="center" sortable="true" width="60px">编号</th>
								
							<th halign="center" field="own_goal_userName"
								align="center" sortable="true" width="120px">姓名</th>	
							<th halign="center" field="own_goal_type"
								align="center" sortable="true" width="120px" formatter="operate_type">类型</th>
							<th halign="center" field="own_goal_year"
								align="center" sortable="true" width="120px">年度</th>
							<th halign="center" field="own_goal_details"
								align="center" sortable="true" width="350px">诚安梦</th>
							<th halign="center" field="own_goal_creatTime"
								align="center" sortable="true" width="120px">创建时间</th>
							<th halign="center" field="own_goal_finishTime"
								align="center" sortable="true" width="120px">完成时间</th>
							<th halign="center" field="own_goal_isFinish" align="center"
								sortable="true" width="120px" formatter="operate_isFinish">是否完成</th>
							<th halign="center" field="psn" align="center" sortable="true"
								width="120px" formatter="operate_formatter" >操作</th>	
						</tr>
					</thead>
				</table>
			</div>

		</div>



		<div id="addrow" class="easyui-window" title="新增" closed="true"
			modal="true" style="width:300px;height:300px;padding:5px;">
			<div region="north" title="用户基本信息" style="padding: 10px;"
				minHeight="350px">
				<form id="ownGoal" method="post">
				<table width="90%" class="content">
					<tr>
						<td style="display: none">id:</td>
						<td style="display: none"><input class="easyui-validatebox"
							type="text" name="own_goal_id" value="0"
							id="own_goal_id"  /></td>

						<!-- <td style="display: none">userId:</td>
						<td style="display: none"><input class="easyui-validatebox"
							type="text" name="own_goal_userId"
							id="own_goal_userId" value="" style="width: 150px"></td> -->

						<td>类型:</td>
						<td><select id="own_goal_type" name="own_goal_type" style="width:148px;">
								<option value="1">工作目标</option>
								<option value="2">生活目标</option>
						</select></td>
							
					</tr>
					<tr>
						
						<td>年度:</td>
						<td><input class="easyui-validatebox" type="number"
							name="own_goal_year"
							id="own_goal_year" value="2019"
							style="width: 150px" /></td>
					</tr>
					<tr>
						
						<td>诚安梦:</td>
						<td><textarea class="easyui-validatebox"  rows="5" cols="20"
							name="own_goal_details" 
							id="own_goal_details" style="width: 150px" ></textarea></td>
					</tr>

				</table>
			</form>
				<div region="south" style="padding: 10px; text-align: center;"
					border="false">
					<a class="easyui-linkbutton"
						data-options="iconCls:'icon-system_save'" href="javascript:;"
						id="btnSave" onclick="btnSave()">保存</a>&nbsp;&nbsp;&nbsp;&nbsp; <a
						class="easyui-linkbutton"
						data-options="iconCls:'icon-system_close'" href="javascript:;"
						id="btnCancel" onclick="btnCancel()">取消</a>
				</div>
			</div>

		</div>



		<script type="text/javascript">
			
			var date=new Date;
		 	var year=date.getFullYear();
		 	$('#goal_year').val(year);	
		
			function operate_formatter(value, row, index) {
				var html = "";
				html += '<a href="javascript:;" class="opt"    cmd="finish" i="' + index + '">点击完成</a>';
				return html;
			}
			//新增
			function btnSave() {
				$.post("save_ownGoal.do",$("#ownGoal").serialize(), function(data) {
							if (data.success) {
								alert("保存成功");
								$('#data').datagrid();
							} else {
								alert(data.erro);
						}
				});
				
			}
			
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
			
			function btnNew() {
				//clear();
				$('#addrow').window('open');
			}
			
			

			function clear() {
				
				$("#construct_material_modelId").val("");
				$("#construct_material_priceId").val("");
				$("#construct_material_name").val("");
				$("#construct_material_model").val("");
				$("#construct_material_unit").val("");
				$("#construct_material_remarks").val("");
				$("#material_brand").val("value", "");
				$("#supplier").val("value", "");
				$("#price").val("");
				$("#construct_lowest_price").val("");
				$("#construct_latest_price").val("");

			}

			function btnCancel() {
				window.location.href = "ownGoalList.do";
			}

			/***处理操作列的功能***/
			function cmdHanlder(cmd, row) {
				if(cmd=='finish'){
					
					 $.ajax({
						url : "finishOwnGoal.do",
						type : 'POST',
						data : { 
								'id':row.own_goal_id
							    },
						success : function(data) {
								if (data.success) {
									alert("更新成功");
									$('#data').datagrid();
									
								} else {
									alert(data.erro);
								}
						}
				        });
					
				}
				
			}

			function edit() {

				var rows = $("#data").datagrid("getSelections");
				if (rows.length == 0) {
					alert("请选择需要修改的行");
					return null;
				}
				if (rows.length > 1) {
					alert("不能选择多行喔");
					return null;
				}
				clear();
				$("#construct_material_priceId").val(
						rows[0].construct_material_priceId);
				$("#construct_material_name").val(
						rows[0].construct_material_name);
				$("#construct_material_model").val(
						rows[0].construct_material_model);
				$("#construct_material_unit").val(
						rows[0].construct_material_unit);
				$("#material_brand").val("value",
						rows[0].construct_material_brand);
				$("#supplier").val("value",
						rows[0].construct_material_supplier);
				$("#price").val(rows[0].construct_material_price);
				$("#construct_material_remarks").val(
						rows[0].construct_material_remarks);
				$("#construct_material_supplierTel").val(
						rows[0].construct_material_supplierTel);
				$("#construct_latest_price")
						.val(rows[0].construct_latest_price);
				$("#construct_lowest_price")
						.val(rows[0].construct_lowest_price);
				$("#construct_material_modelId").val(
						rows[0].construct_material_modelId);
				$('#addrow').window('open');
			}

			//删除处理
			function btnDele() {
				var rows = $("#data").datagrid("getSelections");
				if (rows.length == 0) {
					$.messager.alert("提示", "请选择需要修改的行", "info");
					return false;
				}
				if (rows.length > 1) {
					$.messager.alert("提示", "不能选择多行", "info");
					return false;
				}
				$
						.ajax({
							type : 'POST',
							url : 'deleprice.do',
							data : {
								'material_priceId' : rows[0].construct_material_priceId,
							},
							success : function(data) {
								if (data.msg != undefined) {
									$.messager.alert("提示", data.msg, "error");
									$('#data').datagrid('reload');
								} else {

									$('#data').datagrid('reload');
									$.messager.alert("提示", "删除成功！");
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