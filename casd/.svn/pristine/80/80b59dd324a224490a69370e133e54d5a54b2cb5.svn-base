<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ taglib uri="PowerCheck" prefix="shop"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../common/css.jsp"></jsp:include>
<jsp:include page="../common/scripts.jsp"></jsp:include>

<script
	src="<%=request.getContextPath()%>/res/admin/scripts/admin_grid.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/res/admin/scripts/ueditor/third-party/codemirror/codemirror.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/res/js/echarts.common.min.js"
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
<div style="float:left;width:60%;" >
	<fieldset id="fd1" style="width:880px;">
		<legend>
			<span>合同信息</span>
		</legend>
		<div class="fieldset-body">
			<form id="contract" method="post">
			<table class="form-table" border="0" cellpadding="5" cellspacing="2">
				<tr>
					<td class="form-label" style="width:60px;display: none">合同id：</td>
					<td style="width:150px;display: none"><input
						name="manage_contract_id" id="manage_contract_id"
						class="mini-textbox" value="${manage_contract_id}" /></td>
					<td class="form-label" style="width:110px;">合同编号：</td>
					<td style="width:150px"><input type="text" name="manage_contract_num" 
						id="manage_contract_num" class="mini-textbox" 
						value="${manage_contract_num}" /></td>
					<td class="form-label" style="width:110px;">项目名称：</td>
					<td style="width:150px"><input type="text" 
						value="${manage_contract_name}"
						name="manage_contract_name" id="manage_contract_name" class="mini-textbox" /></td>
					<td class="form-label" style="width:110px;">所属公司：</td>
						
					<td style="width:150px"><select  id="manage_contract_company" name="manage_contract_company"  style="width:142px;">
							<option value="0">请选择</option>
							<option value="1">建设公司</option>
							<option value="2">科技公司</option>
							<option value="3">加盟合作</option>
					</select></td>	
						
				</tr>
				<tr>
					<td class="form-label" style="width:110px;">发包方（甲方）：</td>
					<td style="width:150px"><input type="text" 
						value="${manage_contract_firstParty}"
						name="manage_contract_firstParty" id="manage_contract_firstParty" class="mini-textbox" /></td>
					
					<td class="form-label" style="width:110px;">合同金额：</td>
					<td style="width:150px"><input type="text" 
						value="${manage_contract_amount}"
						name="manage_contract_amount" id="manage_contract_amount" class="mini-textbox" /></td>
						
					<td class="form-label" style="width:110px;">签证金额：</td>
					<td style="width:150px"><input type="text" 
						value="${manage_contract_visaAmount}"
						name="manage_contract_visaAmount" id="manage_contract_visaAmount" class="mini-textbox" /></td>		
				</tr>
				
				<tr>
					<td class="form-label" style="width:110px;">合同开始时间：</td>
					<td style="width:150px"><input type="text" class="easyui-datebox"
						value="${manage_contract_startTime}"
						name="manage_contract_startTime" id="manage_contract_startTime" class="mini-textbox" /></td>
					
					<td class="form-label" style="width:110px;">合同结束时间：</td>
					<td style="width:150px"><input type="text" class="easyui-datebox"
						value="${manage_contract_endTime}"
						name="manage_contract_endTime" id="manage_contract_endTime" class="mini-textbox" /></td>
						
					<td class="form-label" style="width:110px;">项目地址：</td>
					<td style="width:150px"><input type="text" 
						value="${manage_contract_address}"
						name="manage_contract_address" id="manage_contract_address" class="mini-textbox" /></td>		
				</tr>
				<tr>
					<td class="form-label" style="width:110px;">备注：</td>
					<td style="width:150px"><input type="text" 
						value="${manage_contract_remark}"
						name="manage_contract_remark" id="manage_contract_remark" class="mini-textbox" /></td>
				
				</tr>
				
			</table>
			</form>
		</div>
	</fieldset>

	<br>
	
	<table id="materialListID" class="easyui-datagrid" title="请款进度"
		style="width:920px;height:auto"
		data-options="
				iconCls: 'icon-edit',
				singleSelect: true,
				toolbar: '#tb',onClickCell:onClickCell,rownumbers:true,
				nowrap:false"
				">
		<thead>
			<tr>
				<th 
					data-options="field:'manage_reqfunds_contractId',width:80,hidden:'hidden',editor:'text'">manage_reqfunds_contractId</th>
				<th 
					data-options="field:'manage_reqfunds_id',width:80,hidden:'hidden',editor:'text'">ItemID</th>
				<th
					data-options="field:'manage_reqfunds_time',width:80,align:'right',editor:'datebox'">请款时间</th>
				<th
					data-options="field:'manage_reqfunds_amount',width:80,align:'right',editor:'text' ">请款金额</th>
				<th
					data-options="field:'manage_reqfunds_ticketDate',width:80,align:'right',">开票日期</th>
				<th
					data-options="field:'manage_reqfunds_ticketAmount',width:80,align:'right',">开票金额</th>
				<th
					data-options="field:'manage_reqfunds_receiveDate',width:80,align:'right',editor:'datebox'">收款日期</th>
				<th
					data-options="field:'manage_reqfunds_receiveAmount',width:80,align:'right',editor:'text' ">收款金额</th>
				<th
					data-options="field:'manage_reqfunds_remark',width:80,align:'right' ,editor:'text' ">备注</th>
				<th
					data-options="field:'operation',width:120,align:'center'" formatter="operate_formatter">操作</th>
			</tr>
		</thead>
	</table>


	<div id="tb" style="height:auto">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true" onclick="add()">添加</a> 
			
			<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-undo',plain:true" onclick="reject()">撤销新增行</a>			
	</div>
	<br/>
	<br/>
	<br/>
	<div style="text-align:center">
		<tr>
			<td style="align:center">
				&nbsp;&nbsp;&nbsp;&nbsp; <a class="easyui-linkbutton"
				href="javascript:;" id="btnSave" onclick="btnSave()">保存</a></td>
		</tr>
	</div>
</div>

<br>
<div id="main" style=" float:right;width: 25%;height:500px;"></div>



	<script type="text/javascript">
	
	function operate_formatter(value, row, index) {
		var html = "";
	if(row.manage_status==0){
		html += '<a href="javascript:;" class="opt" onclick="contractbtm('+row.manage_reqfunds_id+",'json'"+');" cmd="contract" i="' + index + '">开票</a>&nbsp;';
		html += '<a href="javascript:;" class="opt" onclick="contractbtm('+row.manage_reqfunds_id+",'delete'"+');" plain:true"  i="' + index + '">删除</a>&nbsp;';
	  }else if(row.manage_status==1 ||row.manage_status==3){
			html += '<a href="javascript:;" class="opt" onclick="contractbtm('+row.manage_reqfunds_id+",'view'"+');" plain:true"  i="' + index + '">审核中</a>&nbsp;'; 
			html += '<a href="javascript:;" class="opt" onclick="contractbtm('+row.manage_reqfunds_id+",'delete'"+');" plain:true"  i="' + index + '">删除</a>&nbsp;';
	  }else if(row.manage_status==2){
			html += '<a href="javascript:;" class="opt" onclick="contractbtm('+row.manage_reqfunds_id+",'view'"+');" plain:true"  i="' + index + '">已通过</a>&nbsp;'; 
			
	  }
	return html;
	} 
	//开票
	function contractbtm(obj,type){
	   if(type=="delete"){
			$.messager.confirm('提示！', '确定删除吗?', function(r) {
				if(r){
					$.messager.progress({
						title : '提示',
						msg : '正在处理中，请稍候……',
						text : ''
					});
		   $.ajax({
				type : 'POST',
				url :"delete_Reqfunds.do",
				data :{'bizId':obj        
				},
				success : function(data){
					if (data.Success) {
						$.messager.progress('close');
						$.messager.alert("提示", data.Msg, "info",
								function() {
							window.location.reload();
								});
					} else {
						$.messager.progress('close');
						$.messager.alert("提示", data.Msg, "error");

					}
					
				}
			});
				}
			});
	   }else{
		location.href = "reqfundsView.do?" + $.param({
			'type':type,
		    'biz':obj,
		});
		
	   }
	}
	
		var editIndex = undefined;
		$(function() {
			
			//加载数据
			if(${rows}.rows!=null){
		
			/* var type=${type};
			if(type=='view'){
				document.getElementById("btnSave").style.display = "none";
				document.getElementById("tb").style.display = "none";
			} */
			
			$("#manage_contract_company").val(${manage_contract_company});
			$("#manage_contract_amount").val(${manage_contract_amount});
			
			var datas=${rows}.rows;
			if(datas.length!=0){
				$('#materialListID').datagrid('loadData',datas);
			} 
			var totalAmount=parseFloat(${manage_contract_amount})+parseFloat(${manage_contract_visaAmount});
			var receiveAmt=0;
			for(var i=0;i<datas.length;i++){
				receiveAmt=parseFloat(receiveAmt)+parseFloat(datas[i].manage_reqfunds_receiveAmount);
			}
			var noreceiveAmt=parseFloat(totalAmount)-parseFloat(receiveAmt);
			var classificaOne="已收款";
			var classificaTwo="未收款"; 
			//加载饼图
			var myChart = echarts.init(document.getElementById('main'));
			 option = {
					    title : {
					        text: '合同总金额：'+totalAmount,
					        x:'center'
					    },
					    tooltip : {
					        trigger: 'item',
					        formatter: "{a} <br/>{b} : {c} ({d}%)"
					    },
					    legend: {
					        orient : 'vertical',
					        x : 'left',
					        data:[classificaOne,classificaTwo]
					    },
					    toolbox: {
					        show : true,
					        feature : {
					            mark : {show: true},
					            dataView : {show: true, readOnly: false},
					            magicType : {
					                show: true, 
					                type: ['pie', 'funnel'],
					                option: {
					                    funnel: {
					                        x: '25%',
					                        width: '50%',
					                        funnelAlign: 'left',
					                        max: 1548
					                    }
					                }
					            },
					            restore : {show: true},
					            saveAsImage : {show: true}
					        }
					    },
					    calculable : true,
					    series : [
					        {
					            name:'金额（百分比）',
					            type:'pie',
					            radius : '55%',
					            center: ['50%', '60%'],
					            data:[
					                {value:receiveAmt.toFixed(2), name:'已收款'},
					                {value:noreceiveAmt.toFixed(2), name:'未收款'}
					            ]
					        }
					    ]
					};
			 myChart.setOption(option);
			
			}
			
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
		
		
	/* 	
		//删除处理
		function removeit(){
			rows = $("#materialListID").datagrid("getSelections");//获取表格数据
			if(rows.length==0){
				alert("请选择需要删除的行");
				return null;
			}else if(rows.length>1){
				alert("只能选一行");
				return null;
			}
			var id=rows[0].manage_reqfunds_id;
			$.ajax({
				type : 'POST',
				url :"delete_Reqfunds.do",
				data :{'id':id        
				},
				success : function(data){
					alert("删除成功");
					window.location.reload();
				}
			});
			
		};
		 */
		//新增行
		function add() {
		//	$('#centers').window('open');
			$('#materialListID').datagrid('appendRow', {
				status : 'P'
			});
			editIndex = $('#materialListID').datagrid('getRows').length - 1;

			$('#materialListID').datagrid('selectRow', editIndex).datagrid(
					'beginEdit', editIndex);
		}
		//是否编辑结束
		function endEditing() {
			if (editIndex == undefined) {
				return true;
			}
			if ($('#materialListID').datagrid('validateRow', editIndex)) {
				$('#materialListID').datagrid('endEdit', editIndex);
				editIndex = undefined;
				return true;
			} else {
				return false;
			}
		}
               
		function onClickCell(index, field) {
			$('#materialListID').datagrid('selectRow', index);
			if (endEditing()) {
				$(this).datagrid('beginEdit', index);
			}
		}


		//撤销新增行
		function reject() {
			
			$(materialListID).datagrid('rejectChanges');
			editIndex = undefined;
		
		}
			
			

	
		//保存
		function btnSave() {
			var firstParty=$("#manage_contract_firstParty").val();
			var contract_name=$("#manage_contract_name").val();
			
			if($("#manage_contract_visaAmount").val()===""){
				$("#manage_contract_visaAmount").val("0.00");
			}
			if($("#manage_contract_company").val()==="0"){
				alert("公司不可以为空");
				return false;
			}
			var rows=null;
			if(endEditing()){
				$('#materialListID').datagrid('acceptChanges');
				rows=$('#materialListID').datagrid('getSelected');	
			}
			
			$.post("saveContract.do?"+$("#contract").serialize(),{
				'type':"view",
				'rows':JSON.stringify(rows),
			},function(data) {
				 if (data == "") {
						alert("保存成功");
						location.reload(true);
				} else {
					alert("保存失败");
				}
			}); 	
			
		}


	</script>
</body>
</html>