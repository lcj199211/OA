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
<h1>合同信息录入</h1>
	</br>
	<div>
		<tr>
				<td class="form-label" style="width:60px;">甲方(用人单位)：</td>
					<td  style="width:150px"><input type="text" name="company" id="company" value=""
						class="mini-textbox" /></td>
		</tr>
	</div>
	</br>
	
	<fieldset id="fd1" style="width:880px;">
		<legend>
			<span>乙方（员工）信息：</span>
		</legend>
		<div class="fieldset-body">
			<table class="form-table" border="0" cellpadding="1" cellspacing="2">
			<tr><td><input type="hidden" name="userid" id="userid" value=""/></td></tr>
				<tr>
					<td class="form-label" style="width:60px;">姓名：</td>
					<td  style="width:150px"><input type="text" name="name" id="name" value=""
						class="mini-textbox" /></td>
					<td class="form-label" style="width:60px;">性别：</td>
					<td style="width:150px"><select id="sex" name="sex" style="width:60px;">
							<option value="1">男</option>
							<option value="2">女</option>
					</select></td>
						<td class="form-label">出生日期：</td>
					<td><input value="" class="easyui-datebox" name="birth_date" id="birth_date" 
						value="" ></td>
					
				</tr>
				<tr>
					<td class="form-label">工龄：</td>
					<td><input name="workTime" id="workTime"  value="" class="mini-spinner" /></td>
					<td class="form-label" style="width:80px;">户口所在地：</td>
					<td><input name="registeredAdd" id="registeredAdd" value=""
						class="mini-textbox" /></td>
					<td class="form-label">身份证号码：</td>
					<td><input name="idCard" id="idCard"  value="" class="mini-spinner" /></td>
				</tr>
				<tr>
					<td class="form-label">现住址：</td>
					<td><input name="nowLived" id="nowLived" value=""
						class="mini-textbox" /></td>
					
				<td class="form-label" style="width:60px;">联系电话：</td>
					<td style="width:150px"><input name="phone_number" id="phone_number" value=""
						class="mini-textbox" /></td>
			</table>
		</div>
	</fieldset>
	<br />
	<fieldset id="fd1" style="width:880px;">
		<legend>
			<span>工作内容：</span>
		</legend>
		<div class="fieldset-body">
			<table class="form-table" border="0" cellpadding="1" cellspacing="2">
			<tr><td><input type="hidden" name="userid" id="userid" value=""/></td></tr>
				<tr>
					<td class="form-label" style="width:60px;">部门：</td>
					<td  style="width:150px"><input type="text" name="department" id="department" value=""
						class="mini-textbox" /></td>
						<td class="form-label" style="width:80px;">职位：</td>
					<td  style="width:150px"><input type="text" name="position" id="position" value=""
						class="mini-textbox" /></td>
						<td class="form-label" style="width:60px;">工作地点：</td>
					<td  style="width:150px"><input type="text" name="workPlace" id="workPlace" value=""
						class="mini-textbox" /></td>
					
				</tr>
			</table>
		</div>
	</fieldset>
	<br />
	<fieldset id="fd1" style="width:880px;">
		<legend>
			<span>合同内容：</span>
		</legend>
		<div class="fieldset-body">
			<table class="form-table" border="0" cellpadding="1" cellspacing="2">
			<tr><td><input type="hidden" name="userid" id="userid" value=""/></td></tr>
				<tr>
					<td class="form-label" style="width:60px;">固定期限：</td>
					<td  style="width:150px"><input type="text" name="fixedTerm" id="fixedTerm" value=""
						class="mini-textbox" /></td>
						<td class="form-label" style="width:80px;">合同期：</td>
					<td><input value="" class="easyui-datebox" name="startContractTime" id="startContractTime" 
						value="" ></td>
						<td class="form-label" style="width:60px;">至：</td>
					<td><input value="" class="easyui-datebox" name="endContractTime" id="endContractTime" 
						value="" ></td>
					</tr>
					<tr>	
					<td class="form-label" style="width:60px;">试用期：</td>
					<td  style="width:150px"><input type="text" name="probationary" id="probationary" value=""
						class="mini-textbox" /></td>
					<td class="form-label" style="width:60px;">使用期工资：</td>
					<td  style="width:150px"><input type="text" name="proWages" id="proWages" value=""
						class="mini-textbox" /></td>
					<td class="form-label" style="width:90px;">使用期满工资：</td>
					<td  style="width:150px"><input type="text" name="endProWages" id="endProWages" value=""
						class="mini-textbox" /></td>		
				</tr>
			</table>
		</div>
	</fieldset>
	
	<br /><br /><br />
			<div style="text-align:center">
				<tr>
					<td style="align:center"><a class="easyui-linkbutton"
				href="javascript:;" id="btnPrint">打印</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
				class="easyui-linkbutton" href="javascript:;" id="btnBack">取消</a></td>
				</tr>
			</div>
	
	<script type="text/javascript">
	$(function(){
		
		$("#btnPrint").click(function() {
			var company  = $("#company").val();
			var name  = $("#name").val();
			var sex  = $("#sex").val();
			var birth_date = $("#birth_date").datebox("getValue");
			var workTime = $("#workTime").val();
			var registeredAdd = $("#registeredAdd").val();
			var idCard  = $("#idCard").val();
			var nowLived  = $("#nowLived").val();
			var phone_number = $("#phone_number").val();
			var department   = $("#department").val();
			var position   = $("#position").val();
			var workPlace   = $("#workPlace").val();
			var fixedTerm   = $("#fixedTerm").val();
			var startContractTime   = $("#startContractTime").datebox("getValue");
			var endContractTime   = $("#endContractTime").datebox("getValue");
			var probationary   = $("#probationary").val();
			var proWages   = $("#proWages").val();
			var endProWages  = $("#endProWages").val();

			if (confirm("你确定要打印吗？")) {
				$.ajax({
					type : 'POST',
					url : 'print.do',
					data : {
						'company' : company,
						'name' : name,
						'sex' : sex,
						'birth_date' : birth_date,
						'workTime' : workTime,
						'registeredAdd' : registeredAdd,
						'idCard' : idCard,
						'nowLived' : nowLived,
						'phone_number' : phone_number,
						'department' : department,
						'position' : position,
						'workPlace' : workPlace,
						'fixedTerm' : fixedTerm,
						'startContractTime' : startContractTime,
						'endContractTime' : endContractTime,
						'probationary' : probationary,
						'proWages' : proWages,
						'endProWages' : endProWages
					},
					success : function(data) {
						if (data == "") {
							alert("打印成功");
							//location.reload(true);
						} else {
							alert("打印失败");
						}
					}
				});
			} else {
				return false;
			}
		
		});
	});
		
		
	
	</script>
</body>
</html>