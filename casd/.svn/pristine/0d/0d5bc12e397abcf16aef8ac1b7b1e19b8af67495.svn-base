<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

#main{
				
				height:120px;
				border: 1px solid #000;
				margin: 10px auto;	
				float: left;			
			}
			#main .title{
				float: left;
				
			}
			
			#mes-tec{
				height: 120px;
				width:40px;
				border-right: 1px solid #000;
				text-align: center;
			
			}
			
			#person{
				height: 120px;
				width:50px;
				border-right: 1px solid #000;
			}
			
			#person div input{
				height: 120px;
				width:50px;
				border:0;
				padding-left:10px;
				line-height:120px;
			}
			
			
			#option{
				width:170px;
				border-right: 1px solid #000;
				height: 120px;
			}
			#option div input{
				width:170px;
				height: 120px;
				border:0;
				padding-left:10px;
				line-height:120px;
			}

</style>
</head>
<body>
	<fieldset id="fd1" style="width:880px;">
		<legend>
			<span>基本信息</span>
		</legend>
		<div class="fieldset-body">
			<table class="form-table" border="0" cellpadding="1" cellspacing="2">
				<tr>
					<td class="form-label" style="width:60px;display: none">编号id：</td>
					<td style="width:150px;display: none"><input name="purChangeTab_id"
						id="purChangeTab_id" class="mini-textbox" value="${purChange.purChangeTab_id}" /></td>
					<td class="form-label" style="width:60px;">项目名称：</td>
					<td style="width:150px"><input type="text" name="purChangeTab_proName"
						id="purChangeTab_proName" class="mini-textbox" value="${purChange.purChangeTab_proName}"
						readonly="readonly" /></td>
					<td class="form-label" style="width:60px;">事宜：</td>
					<td style="width:150px"><input type="text"
						value="${purChange.purChangeTab_matter}" name="purChangeTab_matter"
						 id="purChangeTab_matter" class="mini-textbox" /></td>
					<td class="form-label" style="width:60px;">申请部门：</td>
					<td style="width:150px"><input type="text"
						value="${purChange.purChangeTab_dep}" name="purChangeTab_dep"
						 id="purChangeTab_dep" class="mini-textbox" /></td>
				</tr>
				<tr>	
					<td class="form-label" style="width:60px;">原因：</td>
					<td style="width:150px"><input type="text"
						value="${purChange.purChangeTab_reason}" name="purChangeTab_reason"
						 id="purChangeTab_reason" class="mini-textbox" /></td>
					<td  class="form-label" style="width:60px;display: none">项目id：</td>
					<td style="width:150px;display: none"><input type="text" 
						value="${construct.construct_project_id}" name="purChangeTab_proId"
						 id="purChangeTab_proId" class="mini-textbox" /></td>			
				</tr>

			</table>
		</div>
	</fieldset>

	<fieldset id="fd1" style="width:880px;">
		<legend>
			<span>变更项</span>
		</legend>
	<div style="margin:20px 0;"></div>

	<table id="Purchange" class="easyui-datagrid" title="流程节点"
		style="width:880px;height:auto"
		data-options="
				iconCls: 'icon-edit',
				singleSelect: true,
				toolbar: '#tb'
				">

		<thead>
			<tr>
				<th data-options="field:'purChangeEntryTab_id',width:80,hidden:true" >分录id</th>
				<th data-options="field:'purChangeEntryTab_material',width:80,align:'right',editor:'text'">材料名</th>
				<th data-options="field:'purChangeEntryTab_model',width:80,align:'right',editor:'text'">规格</th>
				<th data-options="field:'purChangeEntryTab_quarityNum',width:80,align:'right',editor:'text'">合同工程量</th>
				<th data-options="field:'purChangeEntryTab_applyNum',width:80,align:'right',editor:'text'">申请增加工作量</th>
				<th data-options="field:'purChangeEntryTab_price',width:80,align:'right',editor:'text'">单价</th>
				<th data-options="field:'purChangeEntryTab_unit',width:80,align:'right',editor:'text'">单位</th>
				<th data-options="field:'purChangeEntryTab_total',width:80,align:'right',editor:'text'">金额</th>
				<th data-options="field:'purChangeEntryTab_remarks',width:80,align:'right',editor:'text'">备注</th>
			</tr>
		</thead>


	</table>
</fieldset>

<div id="audit"></div>
	<br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />

<br/>
<div>
		<table>
		<tr>
		<td class="form-label" style="width:80px;">审核人：</td>
			<td style="width:150px"><select name="auditor"id="auditor" style="width:120px;">
								<option value="">请选择审批人</option>
								<c:forEach items="${auditor}" var="c">
								<option value="${c.username}">${c.username}</option>
			</c:forEach>
		</select></td>
		<td class="form-label" style="width:80px;">审核意见：</td>
					<td style="width:150px"><input type="text"
						value="" name="options" 
						id="options" class="mini-textbox" /></td>
		</tr>
		</table>			
	</div>

		<br/><br/><br/><br/>
		<div style="text-align:center">
			<a class="easyui-linkbutton" href="javascript:;" id="btnSave"
				onclick="btnAudit()">审核</a> &nbsp;&nbsp;&nbsp;&nbsp; 
			<a class="easyui-linkbutton" href="javascript:;" id="btnBack"
				onclick="btnBack()">退回</a>	&nbsp;&nbsp;&nbsp;&nbsp; 			
			<a class="easyui-linkbutton" href="javascript:;" id="backList"
				onclick="backList()">取消</a>	
		</div>

	<div  id="win" class="easyui-window" data-options="region:'center',title:'请选择值'" closed="true" style="height: 500px; width: 800px" >    
	</div>
	
	<script type="text/javascript">
		var auditID = ${auditID};
		var flow_audit_last_auditid = ${flow_audit_last_auditid};
		var flow_node_order = ${flow_node_order};

		$(function() {
			if (${rows}.rows != undefined) {
				var rows = ${rows}.rows;
				$('#Purchange').datagrid('loadData', rows);
			}
			
			//动态页面
			if(${audit}!=undefined){
				var realWidth=parseInt(41)+parseInt(222)*${audit}.data.length;
				html = "<div style=\"width:"+realWidth+"px\" id=\"main\">";
				html += "<div id=\"mes-tec\" class=\"title\">";
				html += "<br/><br/>审<br/>批<br/>意<br/>见<br/>";
				html += "</div>";
				for (var i = 0; i < ${audit}.data.length; i++) {
					var json = eval(${audit}.data[i]);
					var option=json.flow_audit_option;
					if(option==undefined){
						option="未审核";
					}
					html += "<div id=\"person\" class=\"title\" >";
					html += "<div>";	
					html += "<input id=\"personInput\" value=\""+json.flow_auditer+"\">";	
					html += "</input>";	
					html += "</div>";	
					html += "</div>";	
					html += "<div id=\"option\" class=\"title\">";	
					html += "<div>";
					html += "<input id=\"optionInput\"  value=\""+option+"\" >";
					html += "</input>";
					html += "</div>";	
					html += "</div>";						
				}
				html += "</div>";
				$("#audit").html(html);
			}
		});
		
		
		function btnBack(){
			var option = $("#options").val();
			var purChangeTab_id = $("#purChangeTab_id").val();
			if (option == "") {
				alert("审核意见不能为空!");
				return false;
			} 
			if (confirm("你确定退回申请吗？")) {
				$.ajax({
					type : 'POST',
					url : 'back_purChange.do',
					data : {
						'purChangeTab_id' : purChangeTab_id,
						'option' : option,
						'auditID' : auditID,
						'flow_node_order' : flow_node_order,
						'flow_audit_last_auditid' : flow_audit_last_auditid,
					},
					success : function(data) {
						if (data == "") {
							alert("成功退回申请");
							location.href="auditList.do";
						} else {
							alert("退回失败");
						}
					}
				});
			} else {
				return false;
			}
			
		}
		
		//审核
		function btnAudit() {
			var option = $("#options").val();
			var auditor = $("#auditor").val();
			var purChangeTab_id = $("#purChangeTab_id").val();
			if (option == "") {
				alert("审核意见不能为空!");
				return false;
			}
			if(${length}!=0&&auditor==""){
				alert("审核人不能为空!");
				return false;
			}
			if (confirm("你确定审核通过吗？")) {
				$.ajax({
					type : 'POST',
					url : 'audit_purChange.do',
					data : {
						'purChangeTab_id' : purChangeTab_id,
						'option' : option,
						'auditID' : auditID,
						'auditor' : auditor
					},
					success : function(data) {
						if (data == "") {
							alert("已审批");
							location.href="auditList.do";
						} else {
							alert("审批失败");
						}
					}
				});
			} else {
				return false;
			} 
			
			
		}
		
		function backList(){
			location.href="auditList.do";
		}
	</script>
</body>
</html>