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
	<fieldset id="fd1" style="width:880px;">
		<legend>
			<span>基本信息</span>
		</legend>
		<div class="fieldset-body">
			<table class="form-table" border="0" cellpadding="1" cellspacing="2">
				<tr>
					<td class="form-label" style="width:60px;display: none">列表id：</td>
					<td style="width:150px;display: none"><input
						name="gad_paylist_id" id="gad_paylist_id" class="mini-textbox"
						value="${PayList.gad_paylist_id}" /></td>
					<td class="form-label" style="display: none">中心id：</td>
					<td style="display: none"><input type="text" name="gad_paylist_centerid"
						id="gad_paylist_centerid" class="mini-textbox" value="${PayList.gad_paylist_centerid}" /></td>
					<td class="form-label" style="width:60px;"><a
						href="javascript:void(0)" onclick="wen('centerList.do')">中心(选择):</a>
					</td>
					<td data-options="region:'north',title:'North Title',split:true"
						style="height:50px;"><input type="text" name="center_name"
						id="center_name" readonly="readonly" value="${PayList.center_name}" />
					</td>
					<!-- 父页面的文本框 -->

					<td class="form-label" style="width:60px;">月份：</td>
					<td style="width:150px"><input type="text"
						value="${PayList.gad_paylist_month}" name="gad_paylist_month"
						id="gad_paylist_month" class="mini-textbox" /></td>
					<td class="form-label" style="width:60px;">备注：</td>
					<td style="width:150px"><input type="text"
						value="${PayList.gad_paylist_remarks}" name="gad_paylist_remarks"
						id="gad_paylist_remarks" class="mini-textbox" /></td>	
					
				</tr>
				<tr>
					<td class="form-label" style="width:60px;">实发工资：</td>
					<td style="width:150px"><input type="text"
						value="${PayList.gad_paylist_payroll}" name="gad_paylist_payroll"
						id="gad_paylist_payroll" class="mini-textbox" /></td>
					<td class="form-label" style="width:60px;">人数：</td>
					<td style="width:150px"><input type="text"
						value="${PayList.gad_paylist_men_num}" name="gad_paylist_men_num"
						id="gad_paylist_men_num" class="mini-textbox" /></td>
					<td >
						<a class="easyui-linkbutton" href="javascript:;"data-options="iconCls:'icon-sum',plain:true" id="btnSave" onclick="summary()">汇总</a>
					</td>
				</tr>

			</table>
		</div>
	</fieldset>

	<div id="centers" class="easyui-window"
		data-options="region:'center',title:'请选择值'" closed="true"
		style="height: 500px; width: 800px"></div>

	<div style="margin:20px 0;"></div>

	<table id="payroll" class="easyui-datagrid" title="工资明细"
		style="width:1650px;height:auto"
		data-options="
				iconCls: 'icon-edit',
				singleSelect: true,
				toolbar: '#tb',onClickCell: onClickCell,onAfterEdit:onAfterEdit	
				,rownumbers:true">

		<thead>
			<tr class="baidu">
			
				<th
					data-options="field:'finance_paylist_id',width:80,align:'right',hidden:true,editor:{type:'text',options:{required:true}} ">单头id</th>
				<th
					data-options="field:'wages_id',width:80,align:'right',hidden:true,editor:{type:'text',options:{required:true}} ">id</th>
				<th
					data-options="field:'user_name',width:80,align:'right'">员工姓名</th>
				<th
					data-options="field:'role_name',width:80,align:'right'">职位</th>
				<th
					data-options="field:'attendances',width:80,align:'right',editor:{type:'text',options:{required:true}}">出勤数</th>
				<th
					data-options="field:'vacation',width:80,align:'right',editor:{type:'text'}">休假天数</th>
				<th
					data-options="field:'go_out',width:80,align:'right',editor:{type:'text'}">外出</th>
				<th
					data-options="field:'leave_day',width:80,align:'right',editor:{type:'text'}">请假天数</th>
				<th
					data-options="field:'base_pay',width:80,align:'right',editor:{type:'numberbox',options:{required:true}}">基本工资</th>
				<th
					data-options="field:'years_wages',width:80,align:'right',editor:{type:'numberbox'}">工龄工资</th>
				<th
					data-options="field:'post_wage',width:80,align:'right',editor:{type:'numberbox'}">岗位工资</th>
				<th
					data-options="field:'technical_wages',width:80,align:'right',editor:{type:'numberbox'}">技术工资</th>
				<th
					data-options="field:'total_wages',width:80,align:'right',editor:{type:'numberbox',options:{required:true}}">合计工资</th>
				<th
					data-options="field:'meal_supplement',width:80,align:'right',editor:{type:'numberbox'}">餐补</th>
				<th
					data-options="field:'phone_subsidy',width:80,align:'right',editor:{type:'numberbox'}">电话补贴</th>
				<th 
					data-options="field:'deduction',width:80,align:'right',editor:{type:'numberbox'}">扣发事假工资</th>
				<th
					data-options="field:'should_wages',width:80,align:'right',editor:{type:'numberbox',options:{required:true}}">应发工资</th>
				<th
					data-options="field:'social_security',width:80,align:'right',editor:{type:'numberbox'}">社保</th>
				<th
					data-options="field:'any_other',width:80,align:'right',editor:{type:'numberbox'}">其它借支</th>
				<th
					data-options="field:'payroll',width:80,align:'right',editor:{type:'numberbox',options:{required:true}}">实发工资</th>
				<th
					data-options="field:'remarks',width:80,align:'right',editor:{type:'text'}">备注</th>
			</tr>
		</thead>


	</table>


<div  id="win" class="easyui-window" data-options="region:'center',title:'请选择值'" closed="true" style="height: 500px; width: 800px" >    
				</div>


	<div id="tb" style="height:auto">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true" onclick="add()">添加</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-cut',plain:true"
			onclick="removeit()">删除</a> <a href="javascript:void(0)"
			class="easyui-linkbutton"
			data-options="iconCls:'icon-undo',plain:true" onclick="reject()">撤销修改</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-filesave',plain:true" onclick="btnSave()">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-cancel',plain:true" onclick="btnCancel()">取消</a>
	</div>

	<script type="text/javascript">
		var editIndex = undefined;
		//列表数据加载
		/***处理操作列的功能***/
		/* function cmdHanlder(cmd, row) {
		} */
		$(function() {

			var d = new Date(), str = '';
			//获取当前月份（0——11）
			if(d.getMonth()==0){
				str += d.getFullYear()-1 + '-';
				str += 12;
			}else{
				str += d.getFullYear() + '-';
				str += d.getMonth();
			}
			$("#gad_paylist_month").val(str);
			
			if(${rows}.rows!=undefined){
			var rows = ${rows}.rows; 
			$('#payroll').datagrid('loadData',rows);
			}
			/* $("#payroll").admin_grid({
				queryBtn : "#btnSearch",
				excelBtn : "#btnExcel",
			
				cmdHanlder : cmdHanlder,

			}); */
			//单元格编辑
			$.extend($.fn.datagrid.methods, {
				editCell : function(jq, param) {
					return jq.each(function() {
						var fields = $(this).datagrid('getColumnFields', true)
								.concat($(this).datagrid('getColumnFields'));
						for (var i = 0; i < fields.length; i++) {
							var col = $(this).datagrid('getColumnOption',
									fields[i]);
							col.editor1 = col.editor;
							if (fields[i] != param.field) {
								col.editor = null;
							}
						}
						$(this).datagrid('beginEdit', param.index);
						for (var i = 0; i < fields.length; i++) {
							var col = $(this).datagrid('getColumnOption',
									fields[i]);
							col.editor = col.editor1;
						}
					});
				}
			});

		});

		//删除处理
		function removeit() {
			var rows = null;
			var ids=[];
			rows = $("#payroll").datagrid("getSelections");//获取表格数据
			if (rows.length == 0) {
				alert("请选择需要删除的行");
				return null;
			}else if(rows.length > 1){
				alert("一次只能选择一行喔");
				return null;
			}else{
				ids.push(rows[0].wages_id);
			$.ajax({
				type : 'POST',
				url : "delePayRoll.do",
				data : {
					'cid' : JSON.stringify(ids),
				},
				success : function(data) {
					alert("删除成功");
					window.location.reload();
				}
			});
			}
		};
		//新增行
		function add() {
			if (endEditing()) {
				$('#payroll').datagrid('appendRow', {
					status : 'P'
				});
				editIndex = $('#payroll').datagrid('getRows').length - 1;

				$('#payroll').datagrid('selectRow', editIndex).datagrid(
						'beginEdit', editIndex);
			}
		}
		//是否编辑结束
		function endEditing(){
			if (editIndex == undefined){return true}
			if ($("#payroll").datagrid('validateRow', editIndex)){
				$("#payroll").datagrid('endEdit', editIndex);
				editIndex = undefined;
				return true;
			} else {
				return false;
			}
		}
		function onClickCell(index, field) {
				if(field=="user_name"){
					
					var hrefs = "<iframe id='son' src='userListCheck.do?index="+index+"' allowTransparency='true' style='border:0;width:99%;height:99%;padding-left:2px;' frameBorder='0'></iframe>";    
		            $("#win").html(hrefs); 
		            $("#win").window("open"); 
		            
				}else if (endEditing()){
				
				
					$("#payroll").datagrid('selectRow', index)
							.datagrid('editCell', {index:index,field:field});
					       editIndex = index;
				}
		}

		//子窗口调用
		function pryData(data,index){
			$('#payroll').datagrid('acceptChanges');
			var rows=$('#payroll').datagrid('getRows');
		 	var row = $('#payroll').datagrid("selectRow", index).datagrid("getSelected");
			row.finance_paylist_id = rows[index].finance_paylist_id;
			row.wages_id = rows[index].wages_id;
			row.user_name = data.username;
			row.role_name = data.role_name;
			row.attendances = rows[index].attendances;
			row.vacation = rows[index].vacation;
			row.go_out = rows[index].go_out;
			row.leave_day = rows[index].leave_day;
			row.base_pay = rows[index].base_pay;
			row.years_wages = rows[index].years_wages;
			row.post_wage = rows[index].post_wage;
			row.technical_wages = rows[index].technical_wages;
			row.total_wages = rows[index].total_wages;
			row.meal_supplement = rows[index].meal_supplement;
			row.phone_subsidy = rows[index].phone_subsidy;
			row.deduction = rows[index].deduction;
			row.should_wages = rows[index].should_wages;
			row.social_security = rows[index].social_security;
			row.any_other = rows[index].any_other;
			row.payroll = rows[index].payroll;
			row.remarks = rows[index].remarks;

			$('#payroll').datagrid('refreshRow', index);	
		}
		
		
		
		//撤销新增行
		function reject() {
			$('#payroll').datagrid('rejectChanges');
			editIndex = undefined;
		}

		//取消
		function btnCancel() {
			location.href = "payrollList.do";
		}
		//保存
		function btnSave() {
		var paylist_id=$("#gad_paylist_id").val();
		var	centerid=$("#gad_paylist_centerid").val();
		var	month=$("#gad_paylist_month").val();
		var	men_num=$("#gad_paylist_men_num").val();
		var	payroll=$("#gad_paylist_payroll").val();
		var	remarks=$("#gad_paylist_remarks").val();
			
		if(payroll<=0){
			 $.messager.alert("操作提示", "请你先汇总，再执行提交操作！");  
			return false;
		}
		var rows=null;
		if (endEditing()){
			$('#payroll').datagrid('acceptChanges');
			rows=$('#payroll').datagrid('getRows');
		}
	
		if(rows.length>0){
			$.messager.confirm("提示", "确定执行此操作吗?", function(){  
				$.ajax({
					type : 'POST',
					url : 'addPayroll.do',
					data : {'paylist_id':paylist_id,
						    'centerid':centerid,
						    'month':month,
						    'men_num':men_num,
						    'payroll':payroll,
						    'remarks':remarks,
						    'rows' : JSON.stringify(rows)
					},
					success : function(data) {
						 $.messager.alert("操作提示", "操作成功！","info");  
						//window.location="pmuserList.do";
					}
				});
			     
			});  
		    
			}else{
				  $.messager.alert("操作提示", "你没有添加任何数据！","error");  
				
			}
		
		}


         //工资计算程序
		function onAfterEdit(rowIndex, rowData, changes) {

			var go_out = rowData.go_out == undefined ? 0 : rowData.go_out;
			var leave_day = rowData.leave_day == undefined ? 0
					: rowData.leave_day;
			var total_wages = rowData.total_wages == undefined ? 0 : rowData.total_wages;
			var meal_supplement = rowData.meal_supplement == undefined ? 0
					: rowData.meal_supplement;
			var deduction = rowData.deduction == undefined ? 0
					: rowData.deduction;
			var should_wages = rowData.should_wages == undefined ? 0
					: rowData.should_wages;
			var social_security = rowData.social_security == undefined ? 0
					: rowData.social_security;
			var any_other = rowData.any_other == undefined ? 0
					: rowData.any_other;
			var payroll = rowData.payroll == undefined ? 0 : rowData.payroll;

			
			//计算请假扣除
				var row = $('#payroll').datagrid("selectRow", rowIndex).datagrid("getSelected");
			if (total_wages != '' && total_wages != undefined&&total_wages>0) {
					if (leave_day != undefined&&leave_day>0) {
						
						var date = getEndDay();
						
						deduction = (Number(leave_day).toFixed(2)) * (parseInt(total_wages) / date);
						row.deduction = deduction;
					
						$('#payroll').datagrid('refreshRow', rowIndex);
	
					   }else{
						   row.deduction = '0';
							
							$('#payroll').datagrid('refreshRow', rowIndex);
					   }
				//计算餐补
					if (go_out != undefined&&go_out>0) {
	
						meal_supplement = parseInt(go_out) * 15;
						row.meal_supplement = meal_supplement;
						
						$('#payroll').datagrid('refreshRow', rowIndex);
	
					}else{
						row.meal_supplement = '0';
						
						$('#payroll').datagrid('refreshRow', rowIndex);
					}
				//计算应发工资
					if (should_wages != undefined) {
						should_wages = parseInt(total_wages) + parseInt(meal_supplement);
						row.should_wages = should_wages;
						
						$('#payroll').datagrid('refreshRow', rowIndex);
	
					}else{	
						
					}
				    //计算实发工资
					if (total_wages != undefined) {				
					social_security=(rowData.social_security == "")||(rowData.social_security==undefined) ? 0:rowData.social_security;	
				    any_other = (rowData.any_other == "")||(rowData.any_other ==undefined) ? 0 : rowData.any_other;
					payroll = Number(should_wages) - Number(social_security)-Number(any_other)-Number(deduction);
					row.payroll = payroll.toFixed(2);
					
					$('#payroll').datagrid('refreshRow', rowIndex);
					
				
					}

			} else {
			
				row.meal_supplement ='0';
			
				$('#payroll').datagrid('refreshRow', rowIndex);
				row.should_wages = '0';
				
				$('#payroll').datagrid('refreshRow', rowIndex);
			
			}

		}

		//获取上一个月的天数
		function getEndDay() {
			//构造当前日期对象
			var date = new Date();
			var year = date.getFullYear();
			//获取当前月份
			var mouth = date.getMonth();
			var days;
			if (mouth == 2) {
				days = year % 4 == 0 ? 29 : 28;
			} else if (mouth == 1 || mouth == 3 || mouth == 5 || mouth == 7
					|| mouth == 8 || mouth == 8 || mouth == 12) {
				days = 31;
			} else {
				days = 30;
			}
			return days;
		}
      
		  //汇总
		  function summary(){
		  var count = $('#payroll').datagrid('getRows');
					var payroll1=0;
					for(var i=0;i<count.length;i++){
					    var  payroll2=count[i].payroll;
					     if(payroll2!=undefined){
					     payroll1+=Number(payroll2);
					     }
					}
					 $("#gad_paylist_payroll").val(payroll1); 
					 $("#gad_paylist_men_num").val(count.length);
		  }
		 
		/* 引用子页面index1.html */
		function wen(src) {
			var hrefs = "<iframe id='son' src='"
					+ src
					+ "' allowTransparency='true' style='border:0;width:99%;height:99%;padding-left:2px;' frameBorder='0'></iframe>";
			$("#centers").html(hrefs);
			$("#centers").window("open");
		}
	</script>
</body>
</html>