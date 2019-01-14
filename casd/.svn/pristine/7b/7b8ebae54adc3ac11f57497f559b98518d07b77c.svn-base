<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title></title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet"
	href="${CASD_PATH}/res/layui/css/layui.css?HJ_v=<%=Math.random()%>"
	media="all">
<script src="${CASD_PATH}/res/layui/layui.js?HJ_v=<%=Math.random()%>"
	charset="utf-8"></script>
<script
	src="${CASD_PATH}/res/layui/jquery.min.js?HJ_v=<%=Math.random()%>"
	charset="utf-8"></script>

<style type="text/css">
.layui-form-item {
	margin-bottom: 10px !important;
}
.layui-table{
    color: #333 !important;
}
.layui-input{
  border: 1px solid #c2c2c2;
}
.layui-textarea{
  border: 1px solid #c2c2c2;
}

</style>
</head>
<body style="background:white">

	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>请假申请</legend>
	</fieldset>
	<div style="margin-left: 30px">
		<form class="layui-form" action="">

			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">申请人</label>
					<div class="layui-input-inline">
						<input type="text" value="${leave.applicant}" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">岗位/职位</label>
					<div class="layui-input-inline">
						<input type="text" value="${leave.position}" autocomplete="off"
							class="layui-input">
					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">请假类别</label>
					<div class="layui-input-inline">
						<input type="text" id="leave_category"
							value="${leave.leave_category}" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">公司名称</label>
					<div class="layui-input-inline">
						<input type="text" value="${leave.company_name}"
							autocomplete="off" class="layui-input">
					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">开始时间</label>
					<div class="layui-input-inline">
						<input type="text" value="${leave.start_time}" id="start_time"
							autocomplete="off" class="layui-input time">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">结束时间</label>
					<div class="layui-input-inline">
						<input type="text" value="${leave.end_time}" id="end_time"
							autocomplete="off" class="layui-input">
					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">请假天数</label>
				<div class="layui-input-inline">
					<input type="text" value="${leave.day_count}" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label">事由：</label>
				<div class="layui-input-block">
					<textarea class="layui-textarea" style="width: 515px">${leave.reason}</textarea>
				</div>
			</div>
		</form>
	</div>
	<div>
		<table class="layui-table" lay-size="sm" id="demo"></table>
	</div>
	<script type="text/html" id="indexTpl">
    {{d.LAY_TABLE_INDEX+1}}
   </script>
	<script type="text/html" id="createTime">
	 {{dateformat(d.START_TIME_,"yyyy-MM-dd HH:mm:ss")}}
    </script>
	<script>
		$(document).ready(function() {
			//加载审核历史数据
			var leave_category = $("#leave_category").val();
			if (leave_category == 0) {
				$("#leave_category").val("事假");
			} else if (leave_category == 1) {
				$("#leave_category").val("病假");
			} else if (leave_category == 2) {
				$("#leave_category").val("婚假");
			} else if (leave_category == 3) {
				$("#leave_category").val("产假");
			} else if (leave_category == 4) {
				$("#leave_category").val("丧假");
			} else if (leave_category == 5) {
				$("#leave_category").val("年假");
			} else if (leave_category == 6) {
				$("#leave_category").val("其他");
			}

		});

		layui.use([ 'table', 'form', 'layedit', 'laydate' ],function() {
				var table = layui.table;
				var form = layui.form
				   ,layer = layui.layer
				   ,layedit = layui.layedit
				   ,laydate = layui.laydate;

				var start_time = $("#start_time").val();//开始时间
				var end_time = $("#end_time").val();//结束时间
				//重载时间
				laydate.render({
					elem : '#end_time',
					value : new Date(end_time)
				//参数即为：2018-08-20 20:08:08 的时间戳
				});

				laydate.render({
					elem : '#start_time',
					value : new Date(start_time)
				//参数即为：2018-08-20 20:08:08 的时间戳

				});
				//展示历史记录
				table.render({
					elem : '#demo',
					width : 800,
					cols : [[
					         {field:'',width:88,title:'步骤序号',align:'center',templet : '#indexTpl'}
					        ,{field:'name_',title:'步骤名称',width:120}
					        ,{field:'username',title:'相关人员',width:90,}
					        ,{field:'START_TIME_',title:'发生时间',width:160,templet:'#createTime'}
					        ,{field:'MESSAGE_',title:'审核意见',width:200,}
					        ,{field:'description_',title:'内容',width:200,}
					        ]]
				           ,data:${history}
				           ,even:true
                       });
	                  });

		//时间格式化工具
		Date.prototype.Format = function(fmt) {
			var o = {
				"M+" : this.getMonth() + 1,//月份
				"d+" : this.getDate(),//日
				"H+" : this.getHours(),//小时
				"m+" : this.getMinutes(),//分
				"s+" : this.getSeconds(),//秒
				"q+" : Math.floor((this.getMonth() + 3) / 3),//季度
				"S+" : this.getMilliseconds()
			//毫毛
			};
			if (/(y+)/.test(fmt))
				fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
						.substr(4 - RegExp.$1.length));
			for ( var k in o)
				if (new RegExp("(" + k + ")").test(fmt))
					fmt = fmt.replace(RegExp.$1,
							(RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k])
									.substr(("" + o[k]).length)));
			return fmt;
		};
		//时间格式化
		function dateformat(value, fmt) {
			if (value == undefined)
				return "";
			var date = new Date(value.time);
			var time = date.Format(fmt);
			return time;
		}
	</script>
</body>
</html>