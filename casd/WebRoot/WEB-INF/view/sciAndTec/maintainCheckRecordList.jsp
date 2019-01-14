<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="PowerCheck" prefix="shop"%>
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
		<div id="main" region="center"
			style="background: #eee; padding: 5px; overflow-y: hidden;">


			<div class="easyui-layout" fit="true">
				<div region="north" split="false" border="false"
					style="overflow: hidden; padding: 5px 5px 28px 5px;">
					<div class="easyui-panel" title="查询条件" style="margin-bottom: 5px;">

						<div class="search">
							<ul>
								<li><label>时间：</label><input type="text" name="maintain_checkRecord_head_date" id="maintain_checkRecord_head_date"
									class="easyui-validatebox" style="width: 120px" /></li>
								<li>&nbsp;&nbsp; <a class="easyui-linkbutton"
									data-options="iconCls:'icon-search'" href="javascript:;"
									id="btnSearch">查询</a></li>
								 <li>&nbsp;&nbsp; <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true"
									onclick="btnDele();">删除</a></li> 
									<%-- <shop:permission code="ADD_PROJECT_AP"> --%>
									<!-- <li>&nbsp;&nbsp; <a href="#" class="easyui-linkbutton" iconCls="icon-edit"
									plain="true" onclick="btnUpdate();">修改</a></li> -->
								<li>&nbsp;&nbsp; <a href="#" class="easyui-linkbutton" iconCls="icon-add"
									plain="true" onclick="btnAdd();">新增</a></li>
									
								<li>&nbsp;&nbsp; <a href="#" class="easyui-linkbutton" 
									 onclick="sciAndTecPrint();">打印</a></li>
							
							</ul>
							<div class="clear"></div>
						</div>
					</div>
				</div>
				
				<div region="center" split="false" border="false"
					style="overflow: hidden; padding: 0 5px 5px 5px" id="dataList">
					<table id="data" title="" fit="true"
						data-options="collapsible: true,pagination:true,rownumbers:true,onDblClickRow:onDblClickRow">
						<thead>
							<tr>
								<th halign="center" field="maintain_checkRecord_head_id" align="center" hidden="hidden"
									sortable="true" width="60px">编号</th>
								<th halign="center" field="maintain_checkRecord_head_proId" align="center" hidden="hidden"
									sortable="true" width="60px">项目编号</th>	
								
								<th halign="center" field="manage_contract_name" align="center"
									sortable="true" width="200px">项目名称</th>
									
								<th halign="center" field="manage_contract_firstParty" align="center"
									sortable="true" width="200px">业主单位</th>	
									
								<th halign="center" field="maintain_checkRecord_head_date" align="center"
									sortable="true" width="120px">保养时间</th>
									
								
							</tr>
						</thead>
					</table>
				</div>
				
				<div id="win" class="easyui-window"
						data-options="region:'center',title:'请选择'" closed="true"
						style="height: auto; width: 420px">
						<div class="easyui-panel"  style="width:400px">
							<div style="padding:10px 60px 20px 60px">
							<form id="head" method="post">
								<table cellpadding="5">
									<tr>
										<td>保养日期:</td>
										<td><input  class="easyui-datebox" type="text"
											id="maintain_checkRecord_head_date" name="maintain_checkRecord_head_date" ></input></td>
									</tr>
									<tr style="display: none">
										<td>项目id:</td>
										<td><input class="easyui-textbox" type="text" value="${maintain_checkRecord_head_proId}" name="maintain_checkRecord_head_proId" id="maintain_checkRecord_head_proId"></input></td>
										<td>合同id:</td>
										<td><input class="easyui-textbox" type="text" value="${maintain_checkRecord_head_contractId}" name="maintain_checkRecord_head_contractId" id="maintain_checkRecord_head_contractId"></input></td>
										<td>id:</td>
										<td><input class="easyui-textbox" type="text" value="${maintain_checkRecord_head_id}" name="maintain_checkRecord_head_id" id="maintain_checkRecord_head_id"></input></td>
									</tr>
								</table>
							</form>


						<div style="text-align:center;padding:5px">
							<a href="javascript:void(0)" class="easyui-linkbutton"
								onclick="submitForm()">确定</a> 
						</div>
					</div>


				</div>
			</div>

			</div>
		</div>





	<script type="text/javascript">
		function operate_formatter(value, row, index) {
			var html = "";

			html += '<a href="javascript:;" class="opt"   data-options="plain:true"  cmd="taskList" i="' + index + '">打印</a>';

			return html;
		}
		
		function onDblClickRow(rowIndex, rowData) {
			location.href = "maintainCheckRecord.do?maintain_checkRecord_head_id="+rowData.maintain_checkRecord_head_id;

		};
		
		  function sciAndTecPrint(){
				var rows = $("#data").datagrid("getSelections");
				if (rows.length == 0) {
					alert("请选择需要打印的行");
					return ;
				}else if (rows.length > 1) {
					alert("不能选择多行");
					return ;
				}else{
				//	alert(rows[0].maintain_checkRecord_head_id)
					location.href = "sciAndTecPrint.do?bizId="+rows[0].maintain_checkRecord_head_id;
				}
   		 }
		
		
		
		//新增
		function btnAdd() {
			
			
			$("#win").window("open");
		}
		
		function submitForm(){
			$.messager.confirm('提示！', '你确定提交吗？', function(r) {
				if (r) {	
				$.post("add_record.do",$("#head").serialize(),function(data) {
					if (data.Success) {
						$.messager.alert("提示", "保存成功","info", function() {
							 location.reload(true);
								});
				      	}else {
						$.messager.alert("提示", data.Msg,
								"error");
					}
							
				
				}); 	
			}});
		}
		
		function   formatDate(now)   {     
            var   year=now.getFullYear();     
            var   month=now.getMonth()+1;     
            var   date=now.getDate();     
            return   year+"-"+month+"-"+date;
        }     
       
		
		 function endDate(value, row, index) {
			if (value == undefined||value=="")
				return "";
			 var  now=new   Date(value); 
			return formatDate(now); 
		   
		}
		 function startDate(value, row, index) {
				if (value == undefined||value=="")
					return "";
				 var  now=new   Date(value); 
				return formatDate(now); 
			   
			}
		
		
		function btnView() {
			var rows = $("#data").datagrid("getSelections");
			if (rows.length == 0) {
				alert("请选择需要查看的行");
				return null;
			}
			if (rows.length > 1) {
				alert("不能选择多行喔");
				return null;
			}
			
			//location.href = "constructView.do?projectDep="+${projectDep}+"&construct_project_id="+rows[0].construct_project_id;
		}
		
		function btnUpdate(){
			var rows = $("#data").datagrid("getSelections");
			if (rows.length == 0) {
				alert("请选择需要修改的行");
				return null;
			}
			if (rows.length > 1) {
				alert("不能选择多行喔");
				return null;
			}
			
			location.href = "maintainCheckContent.do?maintain_checkPro_id="+rows[0].maintain_checkPro_id;
		}
		
		

		/***处理操作列的功能***/
		function cmdHanlder(cmd, row) {
			if (cmd == "taskList") {
				
				location.href = "taskList.do?" + $.param({
					'construct_project_id' : row.construct_project_id, //传参项目部编号
				});

			}
		}

		//批量删除处理
		function btnDele() {
			var rows = $("#data").datagrid("getSelections");//获取表格数据
			if (rows.length == 0) {
				alert("请选择需要删除的行");
				return null;
			}
			if (rows.length > 1) {
				alert("不可选择多行");
				return null;
			}
			$.messager.confirm("操作提示", "您确定要执行操作吗？", function(r) {
				if (r) {
					$.ajax({
						type : 'POST',
						url : 'dele_checkRecord.do',
						traditional : true,
						data : {
							'ids' : rows[0].maintain_checkRecord_head_id
						},
						success : function(data) {
							if (!data.Success ) {
								$.messager.alert("提示", data.Msg, "error");
								//location.reload();
							} else {
								$.messager.alert("提示", "操作成功！");
								location.reload();
							}
						}
					});
				}
			});
		};
		
		
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