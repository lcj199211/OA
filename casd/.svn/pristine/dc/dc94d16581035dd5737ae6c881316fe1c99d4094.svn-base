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


	<fieldset id="fd1" style="width:930px;">
		<legend>
			<span>数据信息</span>
		</legend>
		<div class="fieldset-body">
		<form id="arrive" method="post" >
			<table class="form-table" border="0" cellpadding="5" cellspacing="2">
				<tr>
					<td class="form-label" style="display: none">采购单id：</td>
					<td style="display: none"><input name="construct_purchase_arrived_parentId"
						id="construct_purchase_arrived_parentId" class="mini-textbox"  readonly="readonly"
						value="${head.construct_purchase_arrived_parentId}" /></td>
						
					<td class="form-label" style="width:110px">单据编号：</td>
					<td style="width:150px"><input name="construct_purchase_arrived_id"
						id="construct_purchase_arrived_id" class="mini-textbox"  readonly="readonly"
						value="${head.construct_purchase_arrived_id}" /></td>
							
					<td class="form-label" style="width:110px">到货日期：</td>
					<td style="width:150px"><input
						name="construct_purchase_arrived_data"  
						id="construct_purchase_arrived_data" class="easyui-datebox"
						value="${head.construct_purchase_arrived_data}" /></td>
						
					<td class="form-label" style="width:110px">总金额：</td>
					<td style="width:150px"><input name="construct_purchase_arrived_money"
						id="construct_purchase_arrived_money" class="mini-textbox"  readonly="readonly"
						value="${head.construct_purchase_arrived_money}" /></td>
					<td >
						<a class="easyui-linkbutton" href="javascript:;"data-options="iconCls:'icon-sum',plain:true" id="sum" onclick="summary()">汇总</a>
					</td>		
				</tr>

			</table>
			</form>
		</div>
	</fieldset>


	<div style="margin:20px 0;"></div>
	<table id="materialListID" class="easyui-datagrid" title="材料清单"
		style="width:1500px;height:800px"
		data-options="
				iconCls: 'icon-edit',
				singleSelect: true,
				toolbar: '#tb',
				showFooter: true
				">
		<thead>
		<thead>
			<tr>
				<th
					data-options="field:'construct_purchase_arrived_entry_id',width:80,hidden:'hidden',editor:'text'">分录id</th>
				<th
					data-options="field:'construct_purchase_arrived_entry_parentId',width:80,hidden:'hidden',editor:'text'">单头id</th>	
				<th
					data-options="field:'construct_purchase_arrived_entry_chassId',width:80,hidden:'hidden',editor:'text'">分录父id</th>	
				<th
					data-options="field:'construct_purchase_entryParentId',width:80,hidden:'hidden',editor:'text'">采购单材料id</th>	
				<th
					data-options="field:'construct_purchase_material',width:80,align:'right'">材料名称</th>
				<th
					data-options="field:'construct_purchase_model',width:80,align:'right'">型号规格</th>
				<th
					data-options="field:'construct_purchase_unit',width:80,align:'right'">单位</th>
				<th
					data-options="field:'construct_purchase_quantities',width:80,align:'right'">合同工程量</th>
				<th
					data-options="field:'construct_purchase_approvalNum',width:80,align:'right'">累计审批量</th>
				<th
					data-options="field:'construct_purchase_applyNum',width:80,align:'right'">计划采购量</th>
				<th
					data-options="field:'construct_purchase_contractPrice',width:80,align:'right'">合同单价</th>
				<th
					data-options="field:'construct_purchase_purchasePrice',width:80,align:'right'">采购单价</th>
				<th
					data-options="field:'construct_purchase_purchaseTotal',width:80,align:'right'">采购小计</th>
				<th
					data-options="field:'construct_purchase_brand',width:80,align:'right'">材料品牌</th>
				<th
					data-options="field:'construct_purchase_arriveNum',width:80,align:'right'">已到货量</th>
				<th
					data-options="field:'construct_purchase_noArrive',width:80,align:'right'">未到货量</th>
				<th
					data-options="field:'construct_purchase_arrived_entry_num',width:80,align:'right'">此次到货量</th>
				<th
					data-options="field:'construct_purchase_arrived_entry_money',width:80,align:'right'">结算金额</th>					
				<th
					data-options="field:'construct_purchase_remarks',width:80,align:'right'">备注</th>


			</tr>
		</thead>


	</table>


<div id="tb" style="height:auto">
&nbsp;&nbsp;
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="save()">保存</a>
		<a href="javascript:void(0)"
			class="easyui-linkbutton" onclick="enterNum()">录入到货数量</a>
		<a class="easyui-linkbutton"
				href="javascript:;"  onclick="btnCancel()">取消</a>&nbsp;
	</div>



	<div id="enterNum" class="easyui-window" title="选择审核人" closed="true"
		style="width:350px;height:150px;padding:5px;">
		<br />
		<table class="form-table" border="0" cellpadding="5" cellspacing="2">
			<tr>
				<td class="form-label">到货数量：</td>
				<td><input name="arriveNum"
					id="arriveNum" class="mini-textbox" value="" /></td>
			</tr>

		</table>
		<br />
		<div style="text-align:center">
			<tr>
				<td style="align:center"><a class="easyui-linkbutton" 
				href="javascript:;"  id="confirm">确定</a>
					&nbsp;&nbsp;&nbsp;&nbsp; <a class="easyui-linkbutton"
					href="javascript:;" onclick="cancel()">取消</a></td>
			</tr>
		</div>
	</div>




	<script type="text/javascript">
		var editIndex = undefined;
		var construct_purchase_id=${construct_purchase_id};
		$(function() {
			if (${rows} != undefined) {
				var rows = ${rows};
				$('#materialListID').datagrid('loadData', rows);
			}
		});
		
		//录入数据
		var selectRow=[];
		function enterNum() {
			selectRow = $("#materialListID").datagrid("getSelections");//获取表格数据
			if (selectRow.length != 1) {
				alert("请选择需要录入的行");
				return null;
			}
			$("#enterNum").window("open");
		}
		
		//确定填入数据
		$("#confirm").click(function() {
			var index=$('#materialListID').datagrid('getRowIndex',selectRow[0]);
			var  json = eval(${rows}.rows);
			var construct_purchase_arriveNum=json[index].construct_purchase_arriveNum;
			var construct_purchase_noArrive=json[index].construct_purchase_noArrive;  //在分类供应商生成采购单时就已赋值，有问题找auditpurchase
			if(parseInt(construct_purchase_noArrive)<parseInt($("#arriveNum").val())){
				alert("到货数不能大于未到货数");
				return false;
			}
			//未到货量 = 计划-此次到货-已到货
			selectRow[0].construct_purchase_noArrive =parseInt(selectRow[0].construct_purchase_applyNum)-parseInt($("#arriveNum").val())-parseInt(construct_purchase_arriveNum);
			//此次到货
			selectRow[0].construct_purchase_arrived_entry_num = $("#arriveNum").val();
			//已到货量
			selectRow[0].construct_purchase_arriveNum =parseInt($("#arriveNum").val())+parseInt(construct_purchase_arriveNum);
			//结算金额
			selectRow[0].construct_purchase_arrived_entry_money = parseInt(selectRow[0].construct_purchase_purchasePrice)*parseInt($("#arriveNum").val());
				
			$('#materialListID').datagrid('refreshRow', index);
			$("#enterNum").window("close");
		}); 
		
		
		
		
		function save(){
			 if($("#construct_purchase_arrived_money").val()=="0.0"){
				alert("总金额不能为0");
				return false;
			} 
			if($("#construct_purchase_arrived_data").datebox("getValue")==""){
				alert("到货时间不能为空");
				return false;
			}
			$('#materialListID').datagrid('acceptChanges');
			var rows = $('#materialListID').datagrid('getRows');
			
			 $.post("saveArrivePur.do?rows="+encodeURI(JSON.stringify(rows)),$("#arrive").serialize(),function(data) {
				 
				 if (data == "") {
						alert("保存成功");
						location.reload(true);
					} else {
						alert("保存失败");
					}
			}); 
		}
		
		//汇总
		  function summary(){
		  var count = $('#materialListID').datagrid('getRows');
					var allPay=0;
					for(var i=0;i<count.length;i++){
					    var  construct_purchase_arrived_entry_num=count[i].construct_purchase_arrived_entry_num;
					    var  construct_purchase_purchasePrice=count[i].construct_purchase_purchasePrice;

					     if(construct_purchase_arrived_entry_num!=undefined&&construct_purchase_purchasePrice!=undefined){
					    	 allPay+=Number(construct_purchase_arrived_entry_num)*Number(construct_purchase_purchasePrice);
					     }
					}
					 $("#construct_purchase_arrived_money").val(allPay); 
		  }
		
		//取消
		function btnCancel() {
			location.href ="arrivePurchaseList.do?construct_purchase_id="+construct_purchase_id+"";
		}
	</script>
</body>
</html>