
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="PowerCheck" prefix="shop"%>
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

<script
	src="<%=request.getContextPath()%>/res/admin/scripts/jquery.ajaxfileupload.js"
	type="text/javascript"></script>


<style type="text/css">

</style>
</head>
<body>
	<div>
		<div>
			<table>
				<tr>
					<c:choose>
						<c:when test="${not empty data.own_seal_filePath}">
							<a id="loadfied" class="easyui-linkbutton" onclick="loadSeries()">下载附件</a>
						</c:when>
						<c:otherwise>
							<a id="loadfied" class="easyui-linkbutton">无附件</a>
						</c:otherwise>
					</c:choose>
				</tr>
			</table>
		</div>

		<div>
			<fieldset id="fd1" style="width:800px;">
				<form id="jvForm" action="" method="post">
					<legend>
						<span>基本信息</span>
					</legend>
					<div class="fieldset-body">
						<table class="form-table" border="0" cellpadding="1"
							cellspacing="2">
							<tr>
								<td><input type="hidden" name="own_seal_id"
									id="own_seal_id" value="${data.own_seal_id}" /></td>
							</tr>
							<tr>
								<td>文件名称：</td>
								<td><input style="width:250px" type="text"
									name="own_seal_fileName" id="own_seal_fileName"
									value="${data.own_seal_fileName}" /></td>
								<td>预结算金额：</td>
								<td><input type="text" name="own_seal_settle"
									id="own_seal_settle" value="${data.own_seal_settle}" /></td>
								<td>用章公司:</td>
								<td><input type="text" name="own_seal_companyName"
									id="own_seal_companyName" value="${data.company_name}"
									readonly="readonly" /></td>

								<td style="display: none"><input type="text"
									name="own_seal_company" id="own_seal_company"
									value="${data.own_seal_company}" class="mini-textbox" /></td>
							</tr>
							<tr>

								<td>主送单位：</td>
								<td><input style="width:250px" type="text"
									name="own_seal_sender" id="own_seal_sender"
									value="${data.own_seal_sender}"/></td>

								<td class="form-label" style="display: none">文件路径：</td>
								<td style="display: none"><input type="text"
									name="own_seal_filePath" id="own_seal_filePath"
									value="${data.own_seal_filePath}" /></td>
								<td class="form-label" style="display: none">创建时间:</td>
								<td style="display: none"><input type="text"
									name="own_seal_creatTime" id="own_seal_creatTime"
									value="${data.own_seal_creatTime}" /></td>
								<td>用章类别：</td>
								<td colspan="3"><input type="checkbox"
									name="own_seal_chapCategory" value="1" />公章 <input
									type="checkbox" name="own_seal_chapCategory" value="2"/>业务章 <input
									type="checkbox" name="own_seal_chapCategory" value="3"/>出图章 <input
									type="checkbox" name="own_seal_chapCategory" value="4"/>竣工章 <input
									type="checkbox" name="own_seal_chapCategory" value="5"/>项目章</td>
							</tr>

							<tr>
								<td>盖章用途：</td>
								<td colspan="10"><textarea type="text"
										style="width:100%;height:60px;resize:none;"
										name="own_seal_remark" id="own_seal_remark">${data.own_seal_remark}</textarea></td>
							</tr>
						</table>
					</div>
				</form>
			</fieldset>
		</div>

		<div>
		<div style="margin:20px 0;">
			<table id="history" class="easyui-datagrid" title="审批记录"
				style="width:825px;height:400px"
				data-options="
				iconCls: 'icon-edit',
				singleSelect: true,">
				<thead>
				<tr>
				<th data-options="field:'name_',width:100">步骤名称</th>
				<th data-options="field:'username',width:80">相关人员</th>
				<th data-options="field:'MESSAGE_',width:300">审核意见</th>
				<th data-options="field:'TIME_',width:180" formatter="dateformat">审核时间</th>			
				<th data-options="field:'center_name',width:100">中心</th>	
				<th data-options="field:'department_name',width:200">部门</th>

			</tr>
				</thead>
			</table>
		</div>
		</div>

	</div>

	<br>
	<div style="text-align:center">
		 &nbsp; <a class="easyui-linkbutton"
			href="javascript:;" id="btnCancel" onclick="btnCancel()">返回</a>
		</td>
	</div>
	
	
	<script type="text/javascript">
		
	$(function(){
		  //加载历史记录
		var historys = ${history}.history;
		$('#history').datagrid('loadData', historys);
		
		category();
		
	});
	
	
	//给公章类型赋值
	function category() {
		var category = "${data.own_seal_chapCategory}".split(",");
		for (var i = 0; i < category.length; i++) {
			$('input[name=own_seal_chapCategory][value='
							+ category[i] + ']').attr('checked', 'checked');//很简单就不说了哦

		}
	}
	

	Date.prototype.Format=function(fmt){
        var o={
            "M+":this.getMonth()+1,//月份
            "d+":this.getDate(),//日
            "H+":this.getHours(),//小时
            "m+":this.getMinutes(),//分
            "s+":this.getSeconds(),//秒
            "q+":Math.floor((this.getMonth()+3)/3),//季度
            "S+":this.getMilliseconds()//毫毛
        };
        if(/(y+)/.test(fmt)) fmt=fmt.replace(RegExp.$1,(this.getFullYear()+"").substr(4-RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    };
	
	 function dateformat(value, row, index) {

		if (row.END_TIME_ == undefined)
			return "";	
	  var  date=new  Date(row.END_TIME_.time); 
      var time=date.Format("yyyy-MM-dd HH:mm:ss");
			return time;
            }
	
		//取消
		function btnCancel() {
			location.href = "sealList.do";
		}
		
	
		
		//下载附件
		function loadSeries() {
			var own_seal_filePath = $('#own_seal_filePath')
					.val();
			if (own_seal_filePath == "") {
				alert("没有附件！");
				return false;
			}
			var form = $("<form>");
			$('body').append(form);
			form.attr('style', 'display:none');
			form.attr('target', '');
			form.attr('method', 'post');
			form.attr('action', "downloadseal.do?own_seal_filePath="+ own_seal_filePath);//下载文件的请求路径  
			form.submit();
		}
		
	</script>
</body>
</html>