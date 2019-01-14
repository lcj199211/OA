
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
								<li><label>单据名称：</label><input type="text" name="constuct_project_dep_name", id="constuct_project_dep_name"
									class="easyui-validatebox" style="width: 120px" /></li>
								<li>&nbsp;&nbsp; <a class="easyui-linkbutton"
									data-options="iconCls:'icon-search'" href="javascript:;"
									id="btnSearch">查询</a></li>
							</ul>
							<div class="clear"></div>
						</div>
					</div>
				</div>
			
				<div region="center" split="false" border="false"
					style="overflow: hidden; padding: 0 5px 5px 5px" id="dataList">
					<table id="data" title="" fit="true"
						data-options="collapsible: true,pagination:true,rownumbers:true">
						
		<div style="margin-bottom:5px">
			
		
		
						<thead>
							<tr>
								<th  halign="center" field="flow_bill_id" align="center"
									sortable="true" width="60px" hidden="hidden">单据id</th>
								<th  halign="center" field="flow_audit_next_auditid" align="center"
									sortable="true" width="60px" hidden="hidden">下一节点</th>	
									
								<th  halign="center" field="flow_audit_last_auditid" align="center"
									sortable="true" width="60px" hidden="hidden">上一节点</th>		
								<th  halign="center" field="flow_node_order" align="center"
									sortable="true" width="60px" hidden="hidden">节点顺序</th>	
									
								<th  halign="center" field="flow_bill_url" align="center"
									sortable="true" width="60px" hidden="hidden">单据url</th>
								<th id="num" halign="center" field="flow_audit_id" align="center"
									sortable="true" width="60px">流程编号</th>
								<th halign="center" field="flow_submitter" align="center"
									sortable="true" width="120px">申请人</th>
								<th halign="center" field="flow_bill_type" align="center"
									sortable="true" width="120px">单据类型</th>
								<th halign="center" field="flow_status" align="center"
									sortable="true" width="120px" formatter="status_formatter" >状态</th>
								<th halign="center" field="flow_submit_time" align="center"
									sortable="true" width="120px" formatter="dateformat">申请时间</th>
								<th halign="center" field="flow_audit_time"  align="center"
									sortable="true" width="120px" formatter="dateformat">审核时间</th>	
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

			html += '<a href="javascript:;" class="opt"    cmd="audit" i="' + index + '">查看单据</a>';

			return html;
		}
		
		
		function   formatDate(now)   {     
            var   year=now.getFullYear();     
            var   month=now.getMonth()+1;     
            var   date=now.getDate();     
            return   year+"-"+month+"-"+date;
            }     
       
		
		 function dateformat(value, row, index) {
			if (value == undefined)
				return "";
			 var  now=new   Date(value); 
			return formatDate(now); 
		   
		}

		function status_formatter(value, row, index) {
			if (value == 1) {
				return "待审批";
			} else if (value == 3) {//2 没轮到审批
				return "已审批";
			}else if (value == 0) {//2 没轮到审批
				return "不批准,已退回";
		}
		}

		/***处理操作列的功能***/
		function cmdHanlder(cmd, row) {
			
			if (cmd == "audit") {
				location.href = ""+row.flow_bill_url+"?" + $.param({
					'auditID' : row.flow_audit_id, 	//流程id，单据id 
					'flow_bill_id' : row.flow_bill_id,
					'flow_status' : row.flow_status,
					'flow_bill_url' : row.flow_bill_url,
					'flow_audit_next_auditid' : row.flow_audit_next_auditid,
					'flow_audit_last_auditid' : row.flow_audit_last_auditid,
					'flow_node_order' : row.flow_node_order,
					'bill_type' : row.flow_bill_type,
					
				});
			}
		}

		$(function() {
			$("#data").admin_grid({
				queryBtn : "#btnSearch",
				excelBtn : "#btnExcel",
				cmdHanlder : cmdHanlder,

			});

		});
	</script>

</body>
</html>