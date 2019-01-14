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
									<!-- <li><label>用户编号：</label><input type="text" name="userid"
										class="easyui-validatebox" style="width: 120px" /></li> -->
									<li><label> 姓名：</label><input type="text" name="username"
										class="easyui-validatebox" style="width: 120px" /></li>
									<!--<li><label> 电话号码：</label><input type="text"
										name="phone_number" class="easyui-validatebox"
										style="width: 120px" /></li>
									
									<li><label> 审核状态:</label> <select class="easyui-combobox"
										name="status" data-options="editable:false">
											<option value="">--全部--</option>
											<option value="0">申请中</option>
											<option value="1">通过</option>
											<option value="-1">取消</option>
									</select></li>

									 <li><select class="easyui-combobox" style="width: 100px"
										name="searchTimeType" data-options="editable:false">
											<option value="1">申请时间</option>
											<option value="0">审批时间</option>
									</select></li>
									<li><input class="easyui-datebox" id="apply_time_start"
										name="apply_time_start" style="width: 90px" /> 至 <input
										class="easyui-datebox" name="apply_time_end"
										id="apply_time_end" style="width: 90px"></li> -->


								</ul>
								<div class="clear"></div>
							</div>
							<div id="tb">
								<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
								onclick="addNot();">添加公告</a>
						</div>
						</div>
					</div>
					<div region="center" split="false" border="false"
						style="overflow: hidden; padding: 0 5px 5px 5px" id="dataList">
						<table id="data" title="" fit="true"
							data-options="collapsible: true,pagination:true,rownumbers:true">
							<tr>
							</tr>
							<thead>
								<tr>


								   <th halign="center" field="notice_id" align="center"  
										sortable="true" width="60px" hidden="hidden">用户编号</th>
									<th halign="center" field="username" align="center"
										sortable="true" width="120px">起草人</th>
									<th halign="center" field="start_time" align="center"
										sortable="true" width="120px">创建时间</th>
								
									
									<th halign="center" field="status" align="center"
										sortable="true" width="120px" formatter="operate_status">状态</th>
									
									<th halign="center" field="psn" align="center" sortable="true"
										width="120px" formatter="operate_formatter">操作</th>
								</tr>
							</thead>

						</table>
					</div>

				</div>
			</div>
		
	</form>



	<script type="text/javascript">
		function operate_formatter(value, row, index) {
			var html = "";

			html += '<a href="javascript:;" class="opt"  data-options="iconCls:\'icon-cut\',plain:true"  cmd="delete" i="' + index + '">删除</a>';
			if (row.status == 0) {
				//<shop:Auth code="WITHDRAWAL_AUDIT">
			/* 	html += '<a href="javascript:;" class="opt" data-options="iconCls:\'icon-page_break\',plain:true"  cmd="Audit" i="' + index + '">通过</a>'; */

				//</shop:Auth>
			}

			//html += '<a href="javascript:;" class="opt" data-options="iconCls:\'icon-page_break\',plain:true"  cmd="View" i="' + index + '">查看</a>';

			return html;
		}

		
		
		
		function dateformat(value, row, index) {
			if (value == undefined)
				return "";
			var date = new Date(value);
			var pattern = "yyyy-MM-dd hh:mm:ss";
			return date.format(pattern);
		}

		function psn_formatter(value, row, index) {
			var html = (value + "").replace(/\|/g, ";");
			return html.substr(1);
		}
		
		
		function operate_status(value, row, index){
			if(value==0){
				
			}else if(value==1){
				return "审核中";
				
			}else if(value==3){
				return "已发文";
				
			}
			
		}
		
		
		
		/***处理操作列的功能***/
		function cmdHanlder(cmd, row) {
			if (cmd == "delete") {
				$.ajax({
					type : "POST",
					url : "deleteNotice.do",
					data : {
						'bizId' : row.notice_id, //获取用户id
					},
					success : function(data) {
						location.href = "findTaskList.do";
					}
			
			});
			}
		}
		
		/**
		* 跳转添加页面
		*/
	function addNot(){
  	location.href = "noticeNew.do";
	     }		 

		$(function() {
			$("#data").admin_grid({
				queryBtn : "#btnSearch",
			
				cmdHanlder : cmdHanlder,

			});

		});
	</script>

</body>
</html>