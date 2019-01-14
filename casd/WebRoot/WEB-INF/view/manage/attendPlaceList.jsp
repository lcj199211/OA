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
						<div class="easyui-panel" title="查询条件" style="margin-bottom: 5px;">
							<div class="controls">
								<a class="easyui-linkbutton"
									data-options="iconCls:'icon-search'" href="javascript:;"
									id="btnSearch">查询</a>
						
							</div>

							<div class="search">

								<ul>
									<li><label>项目名称：</label><input type="text" name="construct_project_name"
										class="easyui-validatebox" style="width: 120px" /></li>
									<li><a href="#" class="easyui-linkbutton" iconCls="icon-add"
									plain="true" onclick="open_add()">新增地址</a> <a href="#"
									class="easyui-linkbutton" iconCls="icon-cancel" plain="true"
									onclick="btnDele();">删除地址</a>
									<a href="#"
									class="easyui-linkbutton" iconCls="icon-edit" plain="true"
									onclick="edit()">修改地址</a>	</li>
								</ul>
								<div class="clear"></div>
							</div>
						</div>
					</div>
					<div region="center" split="false" border="false"
						style="overflow: hidden; padding: 0 5px 5px 5px" id="dataList">
						<table id="data" title="" fit="true"
							data-options="collapsible: true,pagination:true">
							<tr>
								
							</tr>
							<thead>
								<tr>
									<th halign="center" field="hr_attend_place_id" align="center" hidden="hidden"
										sortable="true" width="60px">地址编号</th>
									<th halign="center" field="construct_project_name" align="center"
										sortable="true" width="120px">项目名称</th>
										<th halign="center" field="hr_attend_place_project" align="center" hidden="hidden"
										sortable="true" width="120px">项目id</th>
										
												<th halign="center" field="hr_attend_place_name" align="center"
										sortable="true" width="120px">地址</th>
												<th halign="center" field="hr_attend_place_remarks" align="center"
										sortable="true" width="120px">备注</th>
										<th halign="center" field=hr_attend_place_status align="center" formatter="status_formatter"
										sortable="true" width="120px">状态</th>	
								
								</tr>
							</thead>

						</table>
					</div>
                        
				</div>
			</div>
		
	</form>

	<div id="addPlace" class="easyui-window" title="地址信息" closed="true"
			modal="true" style="width:700px;height:500px;padding:5px;">
			<div region="north" style="padding: 10px;"
				minHeight="350px">
				<form id="place" method="post">
					<table width="90%" class="content">
						<tr>
							<td style="display: none">id:</td>
							<td style="display: none"><input class="easyui-validatebox"
								type="text" name="hr_attend_place_id" 
								id="hr_attend_place_id" value="" /></td>
							<td style="width:80px;">地址:</td>
							<td ><input class="easyui-validatebox"
								type="text" name="hr_attend_place_name" style="width: 150px"
								id="hr_attend_place_name" value="" /></td>
	
							<td class="form-label" style="width:100px;"><a
								href="javascript:void(0)" onclick="wen('constructCheck.do')">项目名称(选择):</a>
							</td>
							<td data-options="region:'north',title:'North Title',split:true"
								style="height:50px;"><input class="easyui-validatebox"
								type="text" name="project"
								id="project" value="" readonly="readonly"
								style="width: 150px"></td>
								
							<td style="display: none"><input class="easyui-validatebox" type="text"
								name="hr_attend_place_project"
								id="hr_attend_place_project" value=""
								style="width: 150px"></td>
							
						</tr>
						
						<tr>
							
							<td style="width:80px;">状态:</td>
							<td>
							<select class="easyui-combobox" id="hr_attend_place_status"  name="hr_attend_place_status" style="width:150px;" >
								    <option value="1">启用</option>
								    <option value="2">禁用</option>
							</select>
							</td>
							<td style="width:80px;">备注:</td>
							<td ><input class="easyui-validatebox"
								type="text" name="hr_attend_place_remarks" style="width: 150px"
								id="hr_attend_place_remarks" value="" /></td>
						</tr>
					</table>
				</form>
				<br /> <br /> <br />
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


			<div id="win" class="easyui-window"
				data-options="region:'center',title:'请选择值'" closed="true"
				style="height: 330px; width: 600px"></div>
		</div>
	

	<script type="text/javascript">

       //初始化数据
		$(function() {
			$("#data").admin_grid({
				queryBtn : "#btnSearch",
				excelBtn : "#btnExcel",
			
			});
			$("#hr_attend_place_status").val(2);

		});
       
       
		function status_formatter(value, row, index) {
			if (value == 1) {
				return "启用";
			} else if (value == 2) {
				return "禁用";
			}
		} 
       
		function constructData(rowData){
			
			$("#hr_attend_place_project").val(rowData.construct_project_id);
			$("#project").val(rowData.construct_project_name);
			
		}
		
		
		//保存
		function btnSave() {
	 		var hr_attend_place_name=$("#hr_attend_place_name").val();
			
			if(hr_attend_place_name=="" || hr_attend_place_name == null){
				alert("地址不能为空!");
				return false;
			} 
			$.messager.confirm('提示！', '你确定提交吗？', function(r) {
				if (r) {	
					$.post("save_place.do", $("#place").serialize(),
							function(data) {
					if (data.success) {
						$.messager.alert("提示", data.Msg, "info", function() {
							$('#data').datagrid('reload');
						});

					} else {
						$.messager.alert("提示", data.Msg, "error");

					}
			});
			
				}
			});
		}

				  
		
			
			
		
		
		function btnCancel() {
			location.reload();
		};
		

		//批量删除处理
		function btnDele() {
			var rows = $("#data").datagrid("getSelections");
			if (rows.length == 0) {
				alert("请选择需要删除的行");
				return null;
			}

			var ids = [];
			for (var i = 0; i < rows.length; i++) {
				ids.push(rows[i].hr_attend_place_id);
			}

			$.ajax({
				type : 'POST',
				url : 'dele_place.do',
				traditional : true,
				data : {
					'ids' : JSON.stringify(ids)
				},
				success : function(data) {
					if (data.success) {
						alert(data.msg);
						location.reload();
					} else {
						alert(data.msg);
					}
				}
			});
		}
       
		
		function open_add(){
			$("#hr_attend_place_project").attr("value",0);
			$("#hr_attend_place_id").attr("value",0);
			$("#project").attr("value","");
			$("#hr_attend_place_name").attr("value","");
			$("#hr_attend_place_remarks").attr("value","");
			$("#hr_attend_place_status").attr("value",1);
			$('#addPlace').window('open');
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
			
			$("#hr_attend_place_project").attr("value",
					rows[0].hr_attend_place_project);
			$("#hr_attend_place_id").attr("value",
					rows[0].hr_attend_place_id);
			$("#project").attr("value",
					rows[0].construct_project_name);
			$("#hr_attend_place_name").attr("value",
					rows[0].hr_attend_place_name);
			$("#hr_attend_place_remarks").attr("value",
					rows[0].hr_attend_place_remarks);
			
			$('#hr_attend_place_status').combobox('setValue',rows[0].hr_attend_place_status);
			$('#addPlace').window('open');
		}
		
		function wen(src) {
			var hrefs = "<iframe id='son' src='"
					+ src
					+ "' allowTransparency='true' style='border:0;width:99%;height:99%;padding-left:2px;' frameBorder='0'></iframe>";
			$("#win").html(hrefs);
			$("#win").window("open");
		}
		
       
		
	</script>

</body>
</html>