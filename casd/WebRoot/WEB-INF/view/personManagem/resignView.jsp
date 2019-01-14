<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<table>
			<tr>
				<td><a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-back',plain:true" onclick="btnCancel()">返回</a>
				</td>
			</tr>
		</table>

	</div>

	<fieldset id="fd1" style="width:1000px;">
		<legend>
			<span>基本信息</span>
		</legend>
		<div class="fieldset-body">
			<table class="form-table" border="0" cellpadding="1" cellspacing="2">
				<tr>
					<td><input style="display: none" name="userid" id="userid"
						value="${resign.hr_resign_id}" /></td>
				</tr>
				<tr>
					<td class="form-label" style="width:220px;">申请日期：</td>
					<td style="width:150px"><input type="text" name="hr_resign_applyDate"  readonly="readonly"
						id="hr_resign_applyDate" value="${resign.hr_resign_applyDate}" class="mini-textbox" /></td>
					<td class="form-label" style="width:220px;"  >离职类别：</td>
					<td style="width:150px"><input type="text" name="hr_resign_category" readonly="readonly" 
						id="hr_resign_category" value="" class="mini-textbox" /></td>
					<td class="form-label" style="width:220px;">预定离公司日期：</td>
					<td style="width:150px"><input type="text" name="hr_resign_schLeave" readonly="readonly"
						id="hr_resign_schLeave" value="${resign.hr_resign_schLeave}" class="mini-textbox" /></td>
					<td class="form-label" style="width:220px;">实际离公司日期：</td>
					<td style="width:150px"><input type="text" name="hr_resign_realLeave" readonly="readonly"
						id="hr_resign_realLeave" value="${resign.hr_resign_realLeave}" class="mini-textbox" /></td>
				</tr>
				<tr>
					<td class="form-label" style="width:70px;"><a
						href="javascript:void(0)" onclick="wen()">离职原因(点击放大):</a></td>
					<td style="width:150px"><input type="text"
						name="hr_resign_reason" id="hr_resign_reason" readonly="readonly"
						value="${resign.hr_resign_reason}" class="mini-textbox" /></td>
				</tr>

			</table>
		</div>
	</fieldset>




	<div id="tab" class="easyui-tabs" style="width:1024px;height:500px">
		<div title="审核意见" style="padding:10px">
			<table id="history" class="easyui-datagrid"
				style="width:900px;height:auto"
				data-options="
					iconCls: 'icon-edit',
					singleSelect: true,
			        toolbar: '#tb'
					
				">
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

		<div title="交接记录" style="padding:10px">
			<fieldset id="handOne" style="width:900px;">
				<legend>
					<span>部门手续</span>
				</legend>
				<div class="fieldset-body">
					<table class="form-table" border="0" cellpadding="1"
						cellspacing="2">
						<tr>
							<td class="form-label" style="width:160px;">工作交接：</td>
							<td style="width:150px"><input type="text" name="hr_resign_workHandover" readonly="readonly"
								id="hr_resign_workHandover" value="${resign.hr_resign_workHandover}" class="mini-textbox" /></td>
							<td class="form-label" style="width:160px;">资料交接：</td>
							<td style="width:150px"><input type="text" name="hr_resign_dataHandover" readonly="readonly"
								id="hr_resign_dataHandover" value="${resign.hr_resign_dataHandover}" class="mini-textbox" /></td>
							<td class="form-label" style="width:160px;">文具交接：</td>
							<td style="width:150px"><input type="text" name="hr_resign_stationeryHandover" readonly="readonly"
								id="hr_resign_stationeryHandover" value="${resign.hr_resign_stationeryHandover}" class="mini-textbox" /></td>
							<td class="form-label" style="width:160px;">其它事项：</td>
							<td style="width:150px"><input type="text" name="hr_resign_otherHandover" readonly="readonly"
								id="hr_resign_otherHandover" value="${resign.hr_resign_otherHandover}" class="mini-textbox" /></td>
						</tr>

					</table>
				</div>
			</fieldset>

			<br>
			<fieldset id="handTwo" style="width:900px;">
				<legend>
					<span>资源中心手续</span>
				</legend>
				<div class="fieldset-body">
					<table class="form-table" border="0" cellpadding="1"
						cellspacing="2">
						<tr>
							<td class="form-label" style="width:70px;">意见：</td>
							<td style="width:150px"><input type="text" name="hr_resign_hrOpinion" readonly="readonly"
								id="hr_resign_hrOpinion" value="${resign.hr_resign_hrOpinion}" class="mini-textbox" /></td>
						</tr>

					</table>
				</div>
			</fieldset>
			<br>
			<fieldset id="handThree" style="width:900px;">
				<legend>
					<span>财务部手续</span>
				</legend>
				<div class="fieldset-body">
					<table class="form-table" border="0" cellpadding="1"
						cellspacing="2">
						<tr>

							<td class="form-label" style="width:70px;">工资计发：</td>
							<td style="width:150px"><input type="text" name="hr_resign_payroll" readonly="readonly"
								id="hr_resign_payroll" value="${resign.hr_resign_payroll}" class="mini-textbox" /></td>
							<td class="form-label" style="width:70px;">其他事项：</td>
							<td style="width:150px"><input type="text" name="hr_resign_financeOthers" readonly="readonly"
								id="hr_resign_financeOthers" value="${resign.hr_resign_financeOthers}" class="mini-textbox" /></td>
						</tr>

					</table>
				</div>
			</fieldset>


			<br>
			<fieldset id="handFour" style="width:900px;">
				<legend>
					<span>董事长意见</span>
				</legend>
				<div class="fieldset-body">
					<table class="form-table" border="0" cellpadding="1"
						cellspacing="2">
						 <tr>
							<td class="form-label" style="width:70px;">意见：</td>
							<td style="width:150px"><input type="text" name="hr_resign_topOpinion" readonly="readonly"
								id="hr_resign_topOpinion" value="${resign.hr_resign_topOpinion}" class="mini-textbox" /></td>
						</tr> 

					</table>
				</div>
			</fieldset>


			<br>
			<fieldset id="handFive" style="width:900px;">
				<legend>
					<span>申请人确认</span>
				</legend>
				<div class="fieldset-body">
					<table class="form-table" border="0" cellpadding="1"
						cellspacing="2">
						<tr>
							 <td class="form-label" style="width:70px;">确认时间：</td>
							<td style="width:150px"><input type="text" name="hr_resign_confirmTime" readonly="readonly"
								id="hr_resign_confirmTime" value="${resign.hr_resign_confirmTime}" class="mini-textbox" /></td> 
							<!-- <td><a href="#" class="easyui-linkbutton"
								iconCls="icon-image_add" plain="true"
								onclick="$('#findphoto').window('open')">查看签名</a></td> -->
							 <td class="form-label" style="width:80px;">申请人签字：</td>
							 <c:if test="${not empty resign.hr_resign_autoPath}">
							<td><img src="/uploadfile/photo/${resign.hr_resign_autoPath}" id="autoImg" style="width:100px;height:30px" /></td>
							</c:if>	
								 <td><a href="#" class="easyui-linkbutton"
								
								onclick="btnAuto();">签名</a></td> 
								
								<td style="display: none"><input type="text" name="hr_resign_autoPath" readonly="readonly" 
								id="hr_resign_autoPath" value="${resign.hr_resign_autoPath}" class="mini-textbox" /></td>
						</tr>

					</table>
				</div>
			</fieldset>
			<br>
			<fieldset id="handSix" style="width:900px;">
				<legend>
					<span>技术部手续</span>
				</legend>
				<div class="fieldset-body">
					<table class="form-table" border="0" cellpadding="1"
						cellspacing="2">
						 <tr>
							<td class="form-label" style="width:70px;">系统账号管理：</td>
							<td style="width:150px"><input type="text" name="hr_resign_sysManage" readonly="readonly"
								id="hr_resign_sysManage" value="${resign.hr_resign_sysManage}" class="mini-textbox" /></td>
						</tr> 

					</table>
				</div>
			</fieldset>
		</div>

	</div>



	<div id="win" class="easyui-window" id="reason" name="reason"
		data-options="region:'center',title:'查看'" closed="true"
		style="height: 400px; width: 520px;text-align:center">
		<textarea id="dataText" style="height: 300px; width: 500px;"></textarea>
		<br>
		<tr>
			<td style="align:center"><a href="javascript:void(0)"
				class="easyui-linkbutton" onclick="makeSure()">确定</a></td>
		</tr>
	</div>




	<script type="text/javascript">
		$(function() {
			var historys = ${history}.history; 
			$('#history').datagrid('loadData',historys);
			
			$('#autoImg').src="/uploadfile/photo/"+$("#hr_resign_autoPath").val()+"?"+Math.random();
			
			var category=${resign.hr_resign_category};
			
			
			switch (category) {
			case 1:
				$("#hr_resign_category").val("辞职");
				break;
			case 2:
				$("#hr_resign_category").val("辞退");
				break;
			case 3:
				$("#hr_resign_category").val("合同终止");
				break;
		
			default:
				break;
			} 

		});
		
		function category(value, row, index) {

			if (value == 1) {
				return "辞职";
			} else if (value == 2) {
				return "离职";
			} else if (value == 3) {
				return "试用期";
			} else if (value == 4) {
				return "辞退";
			}
		}
		
		
		function btnAuto(){
			
			location.href="auto.do?hr_resign_id="+${resign.hr_resign_id}+"&hr_resign_autoPath="+$("#hr_resign_autoPath").val();

		}
		
		
		function makeSure() {
			$("#hr_resign_reason").val($("#dataText").val());
			$("#win").window("close");
		}

		function wen() {
			$("#dataText").val($("#hr_resign_reason").val());
			
			$("#win").window("open");
		}

		//取消
		function btnCancel() {
			location.href = "pmuserList.do";
		}
	</script>
</body>
</html>