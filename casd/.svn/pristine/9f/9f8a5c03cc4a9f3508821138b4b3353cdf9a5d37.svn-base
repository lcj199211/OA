<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="../common/css.jsp"></jsp:include>
<jsp:include page="../common/scripts.jsp"></jsp:include>

<script
	src="<%=request.getContextPath()%>/res/admin/scripts/admin_grid.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/res/admin/scripts/ueditor/third-party/codemirror/codemirror.js"
	type="text/javascript"></script>

</head>
<body>
	<div region="north" title="用户基本信息" style="padding: 10px;"
				minHeight="350px">
				<fieldset id="fd1" style="width:860px;">
			<legend>
				<span>项目信息</span>
			</legend>

			<form id="construct" method="post">
				<table width="90%" class="content">
					<tr>
						<td><input type="hidden" class="mini-textbox"
							name="construct_project_id" id="construct_project_id"
							value="${construct.construct.construct_project_id}" /></td>

					</tr>

					<tr>
						<td class="form-label"><a href="javascript:void(0)"
							onclick="wen('contractList.do')">项目名称(选择):</a></td>
						<td><input class="mini-textbox" data-options="required:true"
							readonly="readonly" name="construct_project_name"
							id="construct_project_name"
							value="${construct.construct.manage_contract_name}" style="width: 150px"></td>
						<td style="display: none"><input class="mini-textbox"
							data-options="required:true" readonly="readonly"
							name="construct_project_contractId"
							id="construct_project_contractId"
							value="${construct.construct.construct_project_contractId}"
							style="width: 150px"></td>
						<td class="form-label">工程地址:</td>
						<td><input class="mini-textbox" data-options="required:true"
							readonly="readonly" name="construct_project_addr"
							id="construct_project_addr"
							value="${construct.construct.manage_contract_address}" style="width: 150px"></td>


					</tr>
					<tr>
						<td class="form-label">甲方:</td>
						<td><input class="mini-textbox" data-options="required:true"
							readonly="readonly" name="manage_contract_firstParty"
							id="manage_contract_firstParty"
							value="${construct.construct.manage_contract_firstParty}"
							style="width: 150px"></td>
						<td class="form-label">合同总价:</td>
						<td><input class="mini-textbox" data-options="required:true"
							readonly="readonly" name="total" id="total"
							value="${construct.construct.total}" style="width: 150px"></td>
					</tr>



					<tr>
						<td>合同项目开始日期:</td>
						<td><input class="easyui-datebox"
							name="construct_project_startDate" readonly="readonly"
							value="${construct.construct.manage_contract_startTime}"
							id="construct_project_startDate" style="width: 150px" /></td>
						<td>合同项目结束日期:</td>
						<td><input class="easyui-datebox"
							name="construct_project_endDate" readonly="readonly"
							value="${construct.construct.manage_contract_endTime}"
							id="construct_project_endDate" style="width: 150px" /></td>
					</tr>
					<tr>
						<td class="form-label"><a href="javascript:void(0)"
							onclick="wen('userListCheck.do?index=-3')">项目经理(选择):</a></td>
						<td><input class="mini-textbox" readonly="readonly"
							name="construct_project_leader" id="construct_project_leader"
							value="${construct.construct.construct_project_leader}"
							style="width: 150px" /></td>
						<td>项目经理联系方式:</td>
						<td><input class="mini-textbox" readonly="readonly"
							name="construct_project_leaderTel"
							id="construct_project_leaderTel"
							value="${construct.construct.construct_project_leaderTel}"
							style="width: 150px" data-options="validType:'email'" /></td>
					</tr>

					<tr>
						<td style="display: none">所属项目部:</td>
						<td style="display: none"><input class="mini-textbox"
							readonly="readonly" name="construct_project_dep"
							id="construct_project_dep"
							value="${construct.construct.construct_project_dep}" style="width: 150px" /></td>

						<%-- <td class="form-label"><a href="javascript:void(0)"
							onclick="wen('userListCheck.do?index=-6')">排烟班组(选择):</a></td>
						<td><input class="mini-textbox" readonly="readonly"
							name="construct_project_smoke" id="construct_project_smoke"
							value="${construct.construct_project_smoke}" style="width: 150px" /></td>
						<td class="form-label"><a href="javascript:void(0)"
							onclick="wen('userListCheck.do?index=-4')">水班组(选择):</a></td>
						<td><input class="mini-textbox" readonly="readonly"
							name="construct_project_waterTeam"
							id="construct_project_waterTeam"
							value="${construct.construct_project_waterTeam}"
							style="width: 150px" /></td> --%>
					</tr>
					<%-- <tr>
						<td class="form-label"><a href="javascript:void(0)"
							onclick="wen('userListCheck.do?index=-5')">电班组(选择):</a></td>
						<td><input class="mini-textbox" readonly="readonly"
							name="construct_project_eleTeam" id="construct_project_eleTeam"
							value="${construct.construct_project_eleTeam}"
							style="width: 150px" /></td>
					</tr> --%>
				</table>
			</form>
		</fieldset>

		<table id="materialListID" class="easyui-datagrid" title="班组信息"
			style="width:885px;height:auto"
			data-options="
				iconCls: 'icon-edit',
				singleSelect: true,
				toolbar: '#tb',rownumbers:true
				">
			<thead>
				<tr>
					<th
						data-options="field:'construct_project_workTeam_projectId',width:80,hidden:'hidden',editor:'text'">项目id</th>
					<th
						data-options="field:'construct_project_workTeam_id',width:80,hidden:'hidden',editor:'text'">行id</th>
						
					<th id="status"formatter="category"	data-options="field:'construct_project_workTeam_category',width:80,align:'right',
					editor:{ type:'combobox',options:{data:[{'id':'1','text':'预埋'},{'id':'2','text':'消防水'},{'id':'3','text':'消防电'},
							{'id':'4','text':'防排烟'}], valueField: 'id', textField: 'text' }}">施工项目</th> 
						

					<th
						data-options="field:'construct_project_workTeam_userId',width:80,hidden:'hidden',align:'right'">班组id</th>
					<th data-options="field:'username',width:100,align:'center'">班组</th>
					<th
						data-options="field:'construct_project_workTeam_amount',width:100,align:'center',editor:{type:'text'}">合同金额</th>
					<th
						data-options="field:'construct_project_workTeam_price',width:100,align:'center',editor:{type:'text'}">单价</th>
					<th
						data-options="field:'construct_project_workTeam_departmentId',width:80,hidden:'hidden',align:'right',editor:{type:'numberbox'}">部门id</th>
					

				</tr>
			</thead>
		</table>
				<br/>
	<br />
	<br />
					<div region="south" style="padding: 10px; text-align: center;"
				border="false">
				<a class="easyui-linkbutton"
					iconCls="icon-back" href="javascript:;"
					onclick="btnCancel()">返回</a>
			</div>
			</div>
	
	<script type="text/javascript">
	
	function btnCancel(){
		if(${projectDep}==9999||${projectDep}==10000){
			location.href = "sciAndTecList.do?constuct_project_dep_id="
				+ ${projectDep};
		}else{
			location.href = "constructList.do?constuct_project_dep_id="
				+ ${projectDep};
		}
		
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
	
	$(function() {
		if(${construct}.entry!=""){
			$('#materialListID').datagrid('loadData', ${construct.entry});
		}
	});
	</script>
	
	
</body>
</html>