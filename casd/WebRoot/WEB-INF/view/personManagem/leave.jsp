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
	<h1></h1>
	<fieldset id="fd1" style="width:880px;">
		<legend>
			<span>请假单</span>
		</legend>

		<div class="fieldset-body">
			<form id="form1" method="post">
				<table class="form-table" border="0" style="margin: 10px">

					<tr>
						<td class="form-label" style="width:60px;">申请人：</td>
						<td style="width:150px"><input name="applicant"
							id="Applicant" class="mini-textbox" value="${leave.applicant}" /></td>

						<td class="form-label" style="width:70px;">岗位/职位：</td>
						<td style="width:150px"><input name="position" id="position"
							class="mini-textbox" value="${leave.position}" /></td>
					</tr>
					<tr style="display:none">
						<td class="form-label" style="width:60px;">部门：</td>
						<td style="width:150px"><input name="department"
							id="department" class="mini-textbox" value="${leave.department}" /></td>


					</tr>

					<tr>
						<td>开始时间:</td>
						<td><input class="easyui-datebox" id="start_time"
							name="start_time" value="${leave.start_time}"
							data-options="onChange:onSelectT" /></input></td>
						<td>结束时间:</td>
						<td><input class="easyui-datebox" id="end_time"
							name="end_time" value="${leave.end_time}"
							data-options="onChange:onSelectT" /></input></td>




					</tr>
					<tr>

						<td class="form-label" style="width:60px;">请假类别：</td>
						<td style="width:150px"><select name="leave_category"
							id="leave_category" style="width:120px;">
								<option name="" value="0">事假</option>
								<option name="" value="1">病假</option>
								<option name="" value="2">婚假</option>
								<option name="" value="3">产假</option>
								<option name="" value="4">丧假</option>
								<option name="" value="5">年假</option>
								<!-- <option name="" value="6">其他</option> -->
						</select></td>


						<td>共计(天数):</td>
						<td><input style="width:50" name="day_count" id="day_count"
							type="number" class="mini-textbox" value="${leave.day_count}" /><%--  <input style="width:50"
							name="time_count" id="time_count" class="mini-textbox"
							value="${leave.time_count}"/> 时</td> --%>
							</td>
					</tr>
					<tr>
						<td class="form-label" style="width:60px;">事由：</td>
						<td colspan="3"><textarea style="width:370px;height:100px"
								name="reason" id="reason">${leave.reason}</textarea></td>
					</tr>
					
					<tr>
						<td class="form-label" style="width:60px;">请选择：</td>
						<td style="width:150px"><select id="username_id"
							style="width:120px;">
								<option value="">请选择审批人</option>
								<c:forEach items="${userList}" var="c">
									<option value="${c.userid}">${c.username}</option>
								</c:forEach>
						</select></td>

						<!-- <td><input type="button" onclick="btnSave();" value="提交" /></td> -->
					</tr>
				</table>
				<table>
				<tr>
									
						<td class="form-label" style="display: none">附件地址：</td>
						<td style="display: none"><input type="text" value="${leave.leaveFile}"
							name="leaveFile" id="leaveFile" class="mini-textbox" /></td>
						<td width="80%" ><input name="leaveFile" type="file"/> 
						<a class="easyui-linkbutton" 
							onclick="btnSave();" href="javascript:;" id="btnSaveExp">提交</a>
						</td>				
					</tr>
				</table>
				
			</form>


		</div>



		<div>
			<tr>
				<td style="width:0px;" class="form-label"></td>

				<td class="form-label" style="width:500px">注:<br />
					1、事假、婚假、产假、年假必须提前写好请假单,待批准后方可休假;<br />
					2、如病假或特殊情况的事假者应先电话请假,并于假后补上有效证明;<br /> 3、凡未办理请假手续休假者按相关规定处理;<br />
					4、婚假，产假，丧假，年假为带薪休假，请与事假、病假分开写.
				</td>
			</tr>

		</div>


	</fieldset>
	<script type="text/javascript">
		function onSelectT(d) {

			var sd = $('#start_time').datebox('getValue').replace(/-/g, '/'), ed = $(
					'#end_time').datebox('getValue').replace(/-/g, '/');
			if (sd != '' && ed != '') {
				if (sd > ed) {
					$.messager.alert('警告', '结束时间要 大于 开始时间', 'warning');
				} else {
					/*    var date3 = new Date(ed).getTime() - new Date(sd).getTime();//得到相差的毫秒数 
					   var days=Math.floor(date3/(24*3600*1000)); 
					      
					   //计算出小时数  
					     
					   var leave1=date3%(24*3600*1000);    //计算天数后剩余的毫秒数  
					   var hours=Math.floor(leave1/(3600*1000)); 
					   //计算相差分钟数  
					   var leave2=leave1%(3600*1000);        //计算小时数后剩余的毫秒数  
					   var minutes=Math.floor(leave2/(60*1000));  
					   
					   //计算相差秒数  
					   var leave3=leave2%(60*1000);      //计算分钟数后剩余的毫秒数  
					   var seconds=Math.round(leave3/1000);  
					   alert(" 相差 "+days+"天 "+hours+"小时 "+minutes+" 分钟"+seconds+" 秒");  
					   var day=days+"."+hours;
					   $("#day_count").val(day); *///所用天数 */ 
				}
			}
		}

		function btnSave() {
			var sd = $('#start_time').datebox('getValue').replace(/-/g, '/'), ed = $(
					'#end_time').datebox('getValue').replace(/-/g, '/');
			if (sd == '') {
				$.messager.alert("警告", "开始时间不能为空!", "warning");
				return false;
			}
			if (ed == '') {
				$.messager.alert("警告", "结束时间不能为空!", "warning");
				return false;
			}
			if (sd > ed) {
				$.messager.alert('警告', '结束时间要 大于 开始时间', 'warning');
				return false;
			}
			//数据提
			var nextUser = $("#username_id").val();
			var day_count = $("#day_count").val();
			var position = $("#position").val();

			if (day_count == '') {
				$.messager.alert("提示", "请选择请假的天数");
				return false;
			}
			if (position == '') {
				$.messager.alert("提示", "职位为空,请到人事部填写完整信息后方可请假!");
				return false;
			}
			if (nextUser == '') {
				$.messager.alert("提示", "审核人不能为空");
				return;
			}

			var formData = new FormData(document.getElementById("form1"));

			$.messager.confirm('提示！', '你确定提交吗?', function(r) {

				if (r) {
					$.messager.progress({
						title : '提示',
						msg : '正在处理中，请稍候……',
						text : ''
					});
					// exit action;
					/* $.post("save_Leave.do?" + $("#form1").serialize(), {
						'nextUser' : nextUser,
					},  */
					$.ajax({
						url : "save_Leave.do?nextUser=" + nextUser,
						type : 'POST',
						data : formData,
						async : false,
						cache : false,
						contentType : false,
						processData : false,

						success : function(data) {
							$.messager.progress('close');
							if (data.Success) {
								$.messager.alert("提示", data.Msg, "info",
										function() {
											location.href = "leavePersonal.do";
										});

							} else {
								$.messager.alert("提示", data.Msg, "error");
								$('#data').datagrid('reload');

							}
						}
					});
				}
			});
		}

		/*    function choice(){
			   var day_count=$("#day_count").val();
			   if(day_count==''){
					$.messager.alert("提示", "请选择请假的天数"); 
					return false;
			    }
				$.ajax({
					type : 'GET',
					url : 'choice_examine.do',
					data : {'day_count':day_count,
					
					},
					success : function(data) {
						$('#w').window('open');
						var list = eval(data);
						for (var i = 0; i < list.length; i++) {
						    $("#username_id").append("<option value='" + list[i].username + "'>" + list[i].username + "</option>"); 
						}
						
						
					}
			   
				});
		   } */
		function quxiao() {

			location.href = "personal_task.do";
		}
	</script>

</body>