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

<style type="text/css">
fieldset {
	border: solid 1px #aaa;
}

.hideFieldset {
	border-left: 0;
	border-right: 0;
	border-bottom: 0;
}

.hideFieldset .fieldset-body {
	display: none;
}
</style>
</head>
<body>
	<div>
		    <div>
			<input type="hidden" id="taskid" value="${taskid}"> 
			<input type="hidden" id="taskName" value="${taskName}">
			</div>
	  <div>
	<form id="head">
	<fieldset id="fd1" style="width:1150px;">
		<legend>
			<span>项目信息</span>
		</legend>
		<div class="fieldset-body">
			<table class="form-table" border="0" cellpadding="5" cellspacing="2">
				<tr>
					<td class="form-label" style="width:60px;display: none">项目编号：</td>
					<td style="width:150px;display: none"><input
						name="construct_Aparty_purchase_constructId" id="construct_project_id"
						class="mini-textbox" value="${aParty.construct_project_id}" /></td>
					<td class="form-label" style="width:110px;">项目名称：</td>
					<td style="width:150px"><input type="text" name="construct_project_name" readonly="readonly"
						id="construct_project_name" class="mini-textbox"
						value="${aParty.construct_project_name}" /></td>
					<td class="form-label" style="width:110px;">收货地址：</td>
					<td style="width:150px"><input type="text" readonly="readonly"
						value="${aParty.construct_project_addr}"
						name="construct_project_addr" id="construct_project_addr" class="mini-textbox" /></td>
					<td class="form-label" style="width:110px;">收货人：</td>
					<td style="width:150px"><input type="text" readonly="readonly"
						value="${aParty.construct_project_leader}"
						name="construct_project_leader" id="construct_project_leader" class="mini-textbox" /></td>
					<td class="form-label" style="width:110px;">联系电话：</td>
					<td style="width:150px"><input type="text" readonly="readonly"
						value="${aParty.construct_project_leaderTel}"
						name="flow_description" id="flow_description" class="mini-textbox" /></td>	
				</tr>

			</table>
		</div>
	</fieldset>


	<fieldset id="fd1" style="width:1150px;">
		<legend>
			<span>订单信息</span>
		</legend>
		<div class="fieldset-body">
			<table class="form-table" border="0" cellpadding="5" cellspacing="2">
				<tr>
					<td class="form-label" style="display: none">headId：</td>
					<td style="display: none"><input name="construct_Aparty_purchase_id"
						id="construct_Aparty_purchase_id" class="mini-textbox"
						value="${aParty.construct_Aparty_purchase_id}" /></td>
					<td class="form-label" style="width:110px">订单号：</td>
					<td style="width:150px"><input
						name="construct_Aparty_purchase_orderNum"
						id="construct_Aparty_purchase_orderNum" class="mini-textbox"
						value="${aParty.construct_Aparty_purchase_orderNum}" /></td>
					<td class="form-label" style="width:110px;">供货单位：</td>
					<td style="width:150px"><input type="text"
						name="construct_Aparty_purchase_supplier"
						id="construct_Aparty_purchase_supplier" class="mini-textbox"
						value="${aParty.construct_Aparty_purchase_supplier}" /></td>
					
					<td class="form-label" style="width:110px;">联系人：</td>
					<td style="width:150px"><input type="text" 
						value="${aParty.construct_Aparty_purchase_contacts}"
						name="construct_Aparty_purchase_contacts"
						id="construct_Aparty_purchase_contacts" class="mini-textbox" /></td>
					<td class="form-label" style="width:110px;">联系电话：</td>
					<td style="width:150px"><input type="text" 
						value="${aParty.construct_Aparty_purchase_tel}"
						name="construct_Aparty_purchase_tel"
						id="construct_Aparty_purchase_tel" class="mini-textbox" /></td>
					
				</tr>
			</table>
		</div>
	</fieldset>

</form>
	<br>
	<table id="materialListID" class="easyui-datagrid" title="材料清单"
		style="width:1170px;height:auto" 
		data-options="nowrap :false,
				iconCls: 'icon-edit',
				singleSelect: true,
				toolbar: '#tb'
				">
		<thead>
			<tr>
				<th 
					data-options="field:'construct_Aparty_purEntry_parentId',width:80,hidden:'hidden',editor:'text'">采购单id</th>
				<th 
					data-options="field:'construct_Aparty_purEntry_id',width:80,hidden:'hidden',editor:'text'">ItemID</th>
				<th 
					data-options="field:'construct_Aparty_purEntry_materialId',width:80,hidden:'hidden',editor:'text'">材料id</th>	
				<th
					data-options="field:'construct_Aparty_material_category',width:150,align:'center'">材料分类</th>
				<th
					data-options="field:'construct_Aparty_material_name',width:300,align:'center'">材料名称</th>
				<th
					data-options="field:'construct_Aparty_material_model',width:80,align:'center'">型号规格</th>
				<th
					data-options="field:'construct_Aparty_material_unit',width:80,align:'center'">单位</th>
				<th
					data-options="field:'construct_Aparty_material_num',width:80,align:'center'">合同工程量</th>
				<th
					data-options="field:'construct_aParty_byedNum',width:80,align:'right'">累计审批量</th>
				<th
					data-options="field:'construct_Aparty_purEntry_num',width:80,align:'center',editor:{type:'numberbox'}">计划采购量</th>
				
				<th
					data-options="field:'construct_Aparty_purEntry_remark',width:300,align:'center',editor:{type:'text',options:{required:true}}">备注</th>
			</tr>
		</thead>
	</table>
	</div>
		<div>
			<table>
				<tr>
				<c:if test="${taskName !='管理公司总经理' && taskName !='项目经理打印'}">
					<td class="form-label" style="width:80px;"><h2>下一审核人：</h2></td>
					<td style="width:150px"><select name="username" id="username"
						style="width:120px;">
                    
					<c:forEach items="${userList}" var="user">
								<option value="${user.userid}">${user.username}</option>
							</c:forEach>
					</select></td>
					</c:if>
					<c:if test="${taskName=='项目经理申请'}">
					<td><c:forEach var="bot" items="${bot}">
						<c:if test="${bot=='提交'}">
							<a class="easyui-linkbutton" href="javascript:;" id="btnSave"
								onclick="pass_seal()">${bot}</a>
						</c:if>
						<c:if test="${bot=='驳回'}">
							<a class="easyui-linkbutton" href="javascript:;" id="btnBack"
								onclick="rejects()">${bot}</a>
						</c:if>
					</c:forEach> 
					</td>
					</c:if>
				</tr>

	        <c:if test="${taskName !='项目经理申请'}">
	        
	          <c:if test="${taskName !='项目经理打印'}">
				<tr>
					<td><h2>审核意见:</h2></td>
				</tr>
				<tr>
					<td style="width:150px" colspan="4"><textarea
							style="width:818px;height:60px; resize:none;" type="text"
							name="options" id="options"></textarea></td>
				</tr>
				  </c:if>
				<tr>
				<td colspan="7" style="padding-left: 90%;"><c:forEach var="bot" items="${bot}">
						<c:if test="${bot=='提交'}">
							<a class="easyui-linkbutton" href="javascript:;" id="btnSave" style="width: 35px;"
								onclick="pass_seal()">${bot}</a>
						</c:if>
						<c:if test="${bot=='驳回'}">
							<a class="easyui-linkbutton" href="javascript:;" id="btnBack"
								onclick="rejects()">${bot}</a>
						</c:if>
					</c:forEach></td>
			</tr>
		</c:if>
			</table>
		</div>
	
		<div style="margin:5px 0;">
			<table id="history" class="easyui-datagrid" title="审批记录"
				style="width:830px;height:150px"
				data-options="
				iconCls: 'icon-edit',
				singleSelect: true,">
				<thead>
					<tr>
						<th data-options="field:'username',width:80">审核人</th>
						<th data-options="field:'MESSAGE_',width:300">审核意见</th>
						<th data-options="field:'center_name',width:100">中心</th>
						<th data-options="field:'department_name',width:200">部门</th>
					</tr>
				</thead>
			</table>
		</div>
		
		<div id="tb">
	    <a href="#" class="easyui-linkbutton" iconCls="icon-add" style="color: red" onclick="printing()">采购单打印</a>
        </div>
	</div>

<!-- 驳回js调用 -->
	<script
		src="<%=request.getContextPath()%>/res/jquery-easyui/wangEditor/release/rejects.js"
		type="text/javascript"></script>
	<script type="text/javascript">
	var off = false;  //打印采购单  开关提示
	function printing(){
		var biz=$("#construct_Aparty_purchase_id").val();
		if (biz=='' && biz==null){
			$.messager.alert("提示", "数据异常", "error");
			return false;
		}
		location.href ="aPartyPurPass.do?"+$.param({
			'biz':biz,
		});
		off = true;
		
	}
	
		$(function() {
			//加载历史记录
			var historys = ${history}.history;
			$('#history').datagrid('loadData', historys);
			
			var data = ${entries}.entries;
			$('#materialListID').datagrid('loadData', data);

		});

		   
		//审核
		function pass_seal() {

			var userid = $("#username").val();
			var taskName = $("#taskName").val(); //获取节点名称
			var options = $("#options").val();
			var taskid = $("#taskid").val();
			
			if (taskName != '项目经理申请' && taskName != '项目经理打印') {
				if (options == '' || options == null) {
					$.messager.alert("提示", "请填写审核意见", "info");
					return false;
				}
			}
			if(taskName == '项目经理打印'){
				if(!off){
					$.messager.alert("提示", "请打印采购单", "info");
					return false;
				}
				
			}
		

		/* 	if (taskName != '项目经理申请' || taskName != '管理公司总经理' ) {
				if (userid == '' || userid == null) {
					$.messager.alert("提示", "审核人不能为空", "info");
					return false;
				}

			} */

			$.messager.confirm('提示！', '你确定审核吗？', function(r) {
				if (r) {
					$.ajax({
						type : 'POST',
						url : 'aPartyPurPass.do',

						data : {
							'options' : options,
							'username' : userid,
							'taskName' : taskName,
							'taskid' : taskid,
				

						},
						success : function(data) {
							if (data.Success) {

								$.messager.alert("提示", data.Msg, "info",
										function() {
											location.href = "findTaskList.do";
										});
							} else {

								$.messager.alert("操作提示", data.Msg, "error");
							}

						}

					});
				}
			});
		}
		
	
	</script>
</body>
</html>