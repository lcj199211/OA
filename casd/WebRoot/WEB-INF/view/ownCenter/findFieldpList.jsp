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
	
<script
	src="<%=request.getContextPath()%>/res/admin/scripts/jquery.ajaxfileupload.js"
	type="text/javascript"></script>
<style type="text/css">

  .datagrid-cell-c1-field_personnel_status{
    color:red;
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

					<div class="search">
						<ul>
							<li><label>申请人：</label><input type="text"
								name="username" id="username" 
								class="easyui-validatebox" style="width: 120px" /></li>	
								<li><label>公司：</label><input type="text"
								name="field_personnel_company" id="field_personnel_company" 
								class="easyui-validatebox" style="width: 120px" /></li>	
								
							<li>&nbsp;&nbsp; <a class="easyui-linkbutton"
								data-options="iconCls:'icon-search'" href="javascript:;"
								id="btnSearch">查询</a></li>
					
							<li>&nbsp;&nbsp; <a href="#" class="easyui-linkbutton"
								iconCls="icon-add" plain="true" onclick="btnAdd('add');">新增</a></li>
						</ul>
						<div class="clear"></div>
					</div>
				</div>
			</div>


				<div region="center" split="false" border="false"
					style="overflow: hidden; padding: 0 5px 5px 5px" >
					<table id="data" title="" fit="true"
						data-options="collapsible: true,pagination:true,rownumbers:true">
						<thead>
							<tr>
									
								<th  halign="center" field="field_personnel_id" align="center"
									sortable="true"  hidden="hidden" width="80px">单据编号</th>
								<th  halign="center" field="username" align="center"
									sortable="true" width="80px">申请人</th>
								<th halign="center" field="field_personnel_company" align="center"
									sortable="true" width="150px">公司名称</th>
								<th halign="center" field="field_personnel_rolename" align="center"
									sortable="true" width="150px">职位/岗位</th>
								<th halign="center" field="field_personnel_place" align="center"
									sortable="true" width="150px">外出地址</th>
								<th halign="center" field="field_personnel_license" align="center"
									sortable="true" width="150px">车牌号</th>
								<th halign="center" field="field_personnel_car" align="center"
									sortable="true" width="55px" formatter="operate_car">是否用车</th>
								<th halign="center" field="field_personnel_driver" align="center"
									sortable="true" width="80px">驾驶员</th>
								<th halign="center" field="field_personnel_cause" align="center"
									sortable="true" width="150px">外出事由</th>
								<th halign="center" field="start_time" align="center"
									sortable="true" width="150px">开始时间</th>
								<th halign="center" field="end_time" align="center"
									sortable="true" width="150px">结束时间</th>
								<th halign="center" field="field_personnel_status" align="center"
									sortable="true" width="100px" formatter="operatestatus">状态</th>							
							    		
								<th halign="center" field="psn" sortable="true"
									width="180px" formatter="operate_formatter">操作</th>
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

		/* html += '<a href="javascript:;" class="opt"    cmd="view" i="' + index + '">查看</a> &nbsp;'; */
		html += '<a href="javascript:;" class="opt"  data-options="iconCls:\'icon-cut\',plain:true"  cmd="edit" i="' + index + '">编辑</a>';
		
		html += '<a href="javascript:;" class="opt"  data-options="plain:true"  cmd="delete" i="' + index + '">删除</a>';
		if(row.field_personnel_status==0){
			html += '<a href="javascript:;" class="opt"  data-options="plain:true"  cmd="cancel" i="' + index + '">取消申请</a>';
		}
	
	
		return html;
    	}
     
	//格式化是否用车
	function operate_car(value){
        if(value==1){
        	return "否";
        }else if(value==2){
        	return "是";
        }
	}
	
	  //格式化状态
	function operatestatus(value){
		if(value==0){
			return "单据审核中";
		 }else if(value==2){
			return "审核通过";
		 }else if(value==3){
			return "审核不通过";
		 }else if(value==4){
		    return "外勤结束";
	      }
		
	}
	
	  //添加页面跳转
      function btnAdd(obj){
		  
    	  $.ajax({
				type : 'get',
				url : 'findaddofp.do',
				data : {},
				success : function(data) {
						if (data.Success) {
                           if(data.ofpList<=0){
							 location.href="newFieldPersonnel.do?biz="+obj;	
							}else{
								$.messager.alert("提示", "该用户有外勤单据未结束，不可再申请", "info");
								return;
							}
						} else {
							$.messager.alert("操作提示", data.Msg, "error");
							return;
						}
					}
				});
    	/*   location.href="newFieldPersonnel.do?biz="+obj; */
 
         }

	/***处理操作列的功能***/
	function cmdHanlder(cmd, row) {
		//编辑页面
		if(cmd=='edit'){
			location.href="newFieldPersonnel.do?biz="+row.field_personnel_id;
			
		//删除单据	
		}else if(cmd=='delete'){
			var biz =+row.field_personnel_id;
			 $.messager.confirm('提示！', '你确定提交吗？', function(r) {
					if (r) {	
			 $.post("deleteFieldPersonne.do",{'biz':biz},
					function(data) {
				  if (data.Success) {	 			
					$.messager.alert("提示", data.Msg,"info", function() {
						$("#data").datagrid("reload");
				          });
					}else {
					$.messager.alert("提示", data.Msg,
							"error");
			     }
			});}
		  });	
			//取消外请申请
		}else if(cmd=='cancel'){
			 $.messager.confirm('提示！', '你确定取消申请吗？', function(r) {
					if (r) {	
			 $.post("cancelofps.do",
				 {'bizId':row.field_personnel_id
				 },function(data) {
					 if (data.Success) {	 			
						$.messager.alert("提示", data.Msg,"info", function() {
								$("#data").datagrid("reload");
						          });
							}else {
							$.messager.alert("提示", data.Msg,
									"error");
					     }
		  
		          });}	
			 });
		}
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