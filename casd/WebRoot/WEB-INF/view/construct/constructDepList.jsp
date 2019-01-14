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
							<li><label>项目部名称：</label><input type="text"
								name="dep_name" id="dep_name"
								class="easyui-validatebox" style="width: 120px" /></li>
							<li style="display: none"><label>项目部所属公司：</label><input type="text"
								name="dep_company" id="dep_company"
								value="1"
								class="easyui-validatebox" style="width: 120px" /></li>	
							<li>&nbsp;&nbsp; <a class="easyui-linkbutton"
								data-options="iconCls:'icon-search'" href="javascript:;"
								id="btnSearch">查询</a></li>
								
							
							<!-- 不要删，暂时隐藏
							<li>&nbsp;&nbsp; <a href="#" class="easyui-linkbutton"
								iconCls="icon-cancel" plain="true" onclick="btnDele();">删除项目部</a></li> -->
							<shop:permission code="ADD_PROJECT">	
							<li>&nbsp;&nbsp; <a href="#" class="easyui-linkbutton"
								iconCls="icon-edit" plain="true" onclick="edit();">修改项目部</a></li>
							<li>&nbsp;&nbsp; <a href="#" class="easyui-linkbutton"
								iconCls="icon-add" plain="true" onclick="addFlow();">新增项目部</a></li>
					    	</shop:permission>

						</ul>
						<div class="clear"></div>
						<!-- <div >
							<ul>
								<li> <a href="#" class="easyui-linkbutton"
									 onclick="btnType('2');">改造项目</a></li>
								<li> <a href="#" class="easyui-linkbutton"
									 onclick="btnType('3');">加盟项目</a></li>
								<li> <a href="#" class="easyui-linkbutton"
									 onclick="btnType('4');">保养项目</a></li>
								<li> <a href="#" class="easyui-linkbutton"
									 onclick="btnType('5');">检测项目</a></li>
							</ul>
						</div>
						<div class="clear"></div> -->
					</div>
				</div>
			</div>

			  <div region="center" split="false" border="false"
				style="overflow: hidden; padding: 0 5px 5px 5px" id="dataList">
				
				<table id="data" title="" fit="true" 
					data-options="collapsible: true,pagination:true,rownumbers:true">
					<thead>
						<tr>
							<th halign="center" hidden="hidden" field="constuct_project_dep_id"
								align="center" sortable="true" width="120px">项目部编号</th>
							<th halign="center" hidden="hidden" field="constuct_project_dep_company"
								align="center" sortable="true" width="120px">公司</th>	
							<th halign="center" field="constuct_project_dep_name"
								align="center" sortable="true" width="120px">项目部名称</th>
							<th halign="center" field="constuct_project_dep_leader"
								align="center" sortable="true" width="120px">项目部负责人</th>
							<th halign="center" field="psn" align="center" sortable="true"
								width="120px" formatter="operate_formatter">操作</th>
						</tr>
					</thead>
				</table>
			</div> 


			<div id="w" class="easyui-window"
						data-options="region:'center',title:'信息'" closed="true"
						style="height: auto; width: 420px">
						<div class="easyui-panel"  style="width:400px">
							<div style="padding:10px 60px 20px 60px">
				<form id="form1" method="post">

					<div style="margin:10px 0;">
						<table>
						<tr>
						<td  >分类：</td>
						<td ><select id="constuct_project_dep_company" name="constuct_project_dep_company" style="width: 143px">
								<option value="1">建设项目</option>
						</select></td>
						</tr>
						<tr>	
						<td style="display: none" >项目部编号:</td>
							<td style="display: none"><input 
							readonly="readonly" name="constuct_project_dep_id" value="0"
							id="constuct_project_dep_id" style="width: 150px"></td>
						</tr>
						<tr>	
						<td >项目部名称:</td>
						<td><input 
							name="constuct_project_dep_name"
							id="constuct_project_dep_name" ></td>
							</tr>
						<tr>	
						<td class="form-label">负责人:</td>
						<td><input 
							name="constuct_project_dep_leader"
							id="constuct_project_dep_leader" ></td>	
						</table>
					</div>

				</form>
				<!-- <table class="easyui-datagrid" id="datas" toolbar="#tb"
					data-options="singleSelect:true,collapsible:true,onDblClickRow:onDblClickRow">
					<thead>
						<tr>
							<th data-options="field:'userid',width:80">访问人编号</th>
							<th data-options="field:'username',width:80,align:'right'">允许访问人</th>
						</tr>
					</thead>
				</table>

				<div id="tb" style="padding:5px;">
					<a href="javascript:void(0)" class="easyui-linkbutton"
						onclick="add()">添加</a> <a href="javascript:void(0)"
						class="easyui-linkbutton" onclick="removeit()">删除</a>
				</div> -->

				<br /> <br /> <br />
				<div style="text-align:center">
					<a class="easyui-linkbutton" href="javascript:;" id="btnSave"
						onclick="btnSaveEva()">提交</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
						class="easyui-linkbutton" href="javascript:;" id="btnCancel"
						onclick="closeDown()">取消</a>
				</div>

			</div>

			<!-- <div id="win" class="easyui-window" title='赋值'
				data-options="modal:true,closed:true,iconCls:'icon-save'"
				style="width:800px;height:400px;padding:10px;"></div> -->
		</div>
	</div>

	

	<script type="text/javascript">
		var editIndex = undefined;
		function operate_formatter(value, row, index) {
			var html = "";

			html += '<a href="javascript:;" class="opt"    cmd="constructList" i="' + index + '">项目列表</a>';

			return html;
		}
		
		
		function btnType(obj){
			
			$("#dep_company").val(obj);
			//IE
			if (document.all) {
				document.getElementById("btnSearch").click();
			}
			// 其它浏览器
			else {
				var e = document.createEvent("MouseEvents");
				e.initEvent("click", true, true); //这里的click可以换成你想触发的行为
				document.getElementById("btnSearch").dispatchEvent(e); //这里的clickME可以换成你想触发行为的DOM结点
			}
				
		}

		function addFlow() {
			
			//$("#constuct_project_dep_company").val(company);
			$('#w').window('open');
			
		}
		function closeDown(){
			$('#w').window('close');
			location.reload(true);
		}
		function mytest(){	
			location.href="mytest.do";
		}
		
		//打开用户子页面
		function onDblClickRow(index, field) {

			var hrefs = "<iframe id='son' src='userListCheck.do?index="
					+ index
					+ "' allowTransparency='true' style='border:0;width:99%;height:99%;padding-left:2px;' frameBorder='0'></iframe>";
			$("#win").html(hrefs);
			$("#win").window("open");

		}

		/**
		     项目修改时数据初始化
		 */
		function edit() {
			var rows = $("#data").datagrid("getSelections");//获取表格数据
			if (rows.length == 0) {
				alert("请选择需要修改的行");
				return false;
			} else if (rows.length > 1) {
				alert("一次只能选择一行喔！");
				return false;
			}
			
			$("#constuct_project_dep_id").val(rows[0].constuct_project_dep_id);
			$("#constuct_project_dep_name").val(rows[0].constuct_project_dep_name);
			$("#constuct_project_dep_leader").val(rows[0].constuct_project_dep_leader);
			$("#constuct_project_dep_company").val(rows[0].constuct_project_dep_company);
			
			$('#w').window('open');
			
			/* $.ajax({
				type : 'GET',
				url : 'queryId_dep.do',
				data : {
					'cid' : rows[0].constuct_project_dep_id,

				},
				success : function(data) {
					var rows = data.dep;
					$("#dep_id").val(rows.constuct_project_dep_id);
					$("#dep_name").val(rows.constuct_project_dep_name);
					$("#dep_leader").val(rows.constuct_project_dep_leader);
					$("#constuct_project_dep_company").val(rows.constuct_project_dep_company);
					var listMap = data.listMap;

					$('#datas').datagrid('loadData', listMap);
				}
			}); */

		}

		function removeit() {
			var row = $('#datas').datagrid('getSelected');
			if (row) {
				var rowIndex = $('#datas').datagrid('getRowIndex', row);
				$('#datas').datagrid('deleteRow', rowIndex);

			} else {
				$.messager.alert("提示", "请选择删除行!");

			}

		}

		//修改 、保存
		function btnSaveEva() {
			/* var rows = $("#datas").datagrid("getRows");
			var ids = [];
				if (rows.length > 0 && rows[0].userid != undefined) {
				for (var i = 0; i < rows.length; i++) {
					ids.push(rows[i].userid);
				}
			} else {
				ids.push(0);
			} */
			   //数据提交
				$.post("updata_dep.do", $("#form1").serialize(),function(data) {
					
					if (data.msg != undefined) {
						$.messager.alert("提示", data.msg,"error");
					} else {
						$.messager.alert("提示", "操作成功!");
						$("#w").window("close");
						location.reload(true);
					}
				});
		}
        
		 
		/***处理操作列的功能***/
		function cmdHanlder(cmd, row) {
			if (cmd == "constructList") {

				 location.href = "constructList.do?" + $.param({
					'constuct_project_dep_id' : row.constuct_project_dep_id, //传参项目部编号
				}); 
				//addSubPage("项目列表","constructList.do?constuct_project_dep_id="+row.constuct_project_dep_id+"");
				
				
			}
		}
         
		
		
		
		//批量删除处理
		function btnDele() {
			var rows = $("#data").datagrid("getSelections");//获取表格数据
				if (rows.length == 0) {
					$.messager.alert("提示","请选择需要删除的行");
					return false;
				} else if (rows.length > 1) {
					$.messager.alert("提示","一次只能选择一行喔！");
					return false;
				}
			
				$.post("delete_Dep.do", {
					dep_id:rows[0].constuct_project_dep_id,
				},function(data) {
					if (data.msg != undefined) {
					    $.messager.alert("提示",data.msg,"error");
					}else{
						$.messager.alert("提示","操作成功！");
						$("#data").datagrid("reload");
					}
				});
		}

		//子页面赋值
		function pryData(data, index) {
			$('#datas').datagrid('acceptChanges');
			var row = $('#datas').datagrid("selectRow", index).datagrid(
					"getSelected");
			row.userid = data.userid;
			row.username = data.username;
			$('#datas').datagrid('refreshRow', index); //刷新当前行
		}

		//是否编辑结束
		function endEditing() {
			if (editIndex == undefined) {
				return true
			}
			if ($('#datas').datagrid('validateRow', editIndex)) {
				$('#datas').datagrid('endEdit', editIndex);
				editIndex = undefined;
				return true;
			} else {
				return false;
			}
		}

		//新增行
		function add() {
			if (endEditing()) {
				$('#datas').datagrid('appendRow', {
					statu : 'P'
				});
				editIndex = $('#datas').datagrid('getRows').length - 1;
				
				$('#datas').datagrid('selectRow', editIndex).datagrid(
						'beginEdit', editIndex);
			}
		}
		
		
		/**
		 *数据初始化
		 */
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