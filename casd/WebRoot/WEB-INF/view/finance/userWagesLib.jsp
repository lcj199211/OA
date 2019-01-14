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
							
								<li style="display: none"><label>公司：</label><input type="text" name="finance_wages_company" id="finance_wages_company"
									class="easyui-validatebox" style="width: 120px" /></li>
								<li><label>姓名：</label><input type="text" name="finance_wages_name" id="finance_wages_name"
									class="easyui-validatebox" style="width: 120px" /></li>
								<li><label> 年度：</label> <select id="year" name="year"
										class="easyui-combobox" style="width:120px;">
											<option value="">请选择</option>
											<c:forEach items="${year}" var="y">
												<option value="${y.year}">${y.year}</option>
											</c:forEach>
								</select></li>
								<li><label> 月份：</label> <select id="month" name="month"
										class="easyui-combobox" style="width:120px;">
											<option value="">请选择</option>
											<option value="01">1月份</option>
											<option value="02">2月份</option>
											<option value="03">3月份</option>
											<option value="04">4月份</option>
											<option value="05">5月份</option>
											<option value="06">6月份</option>
											<option value="07">7月份</option>
											<option value="08">8月份</option>
											<option value="09">9月份</option>
											<option value="10">10月份</option>
											<option value="11">11月份</option>
											<option value="12">12月份</option>
								</select></li>	
								<li>&nbsp;&nbsp; <a class="easyui-linkbutton"
									data-options="iconCls:'icon-search'" href="javascript:;"
									id="btnSearch">查询</a></li>
								<li>&nbsp;&nbsp; <a class="easyui-linkbutton"
									data-options="iconCls:'icon-reload'" href="javascript:;"
									id="reload" onclick="reload()" >刷新</a></li>	
							</ul>
							<div class="clear"></div>
							<div >
								<ul>
									<li> <a href="#" class="easyui-linkbutton"
										 onclick="btnCompany('诚安时代');">诚安时代</a></li>
								</ul>
								<ul>
									<li> <a href="#" class="easyui-linkbutton"
										 onclick="btnCompany('诚安建设');">诚安建设</a></li>
								</ul>
								<ul>
									<li> <a href="#" class="easyui-linkbutton"
										 onclick="btnCompany('诚安科技');">诚安科技</a></li>
								</ul>
								<ul>
									<li> <a href="#" class="easyui-linkbutton"
										 onclick="btnCompany('传诚管理');">传诚管理</a></li>
								</ul>
								<ul>
									<li> <a href="#" class="easyui-linkbutton"
										 onclick="btnCompany('诚安教育');">诚安教育</a></li>
								</ul>
							</div>
							<div class="clear"></div>
						</div>
					</div>
				</div>
				
				<div region="center" split="false" border="false"
					style="overflow: hidden; padding: 0 5px 5px 5px" id="dataList">
					<table id="data" title="" fit="true"
						data-options="collapsible: true,pagination:true,rownumbers:true,showFooter: true"">
						<thead>
							<tr>
								
								<!-- <th halign="center" field="manage_contract_num" align="center"
									sortable="true" width="60px" hidden="hidden">合同编码</th>  -->
								<th halign="center" field="finance_wages_center" align="center"
									sortable="true" width="120px"  >中心</th>		
								<th halign="center" field="finance_wages_name" align="center"
									sortable="true" width="120px"  >姓名</th>
								<th halign="center" field="userid" align="center"
									sortable="true" width="120px" hidden="hidden" >姓名id</th>
										
								<!-- <th halign="center" field="department_name" align="center"
									sortable="true" width="120px"  >部门</th> -->
								 <th halign="center" field="finance_wages_company" align="center"
									sortable="true" width="120px" hidden="hidden" >公司</th>	 
								<th halign="center" field="finance_wages_attCount" align="center" 
									sortable="true" width="80px">出勤天数</th>
								<th halign="center" field="finance_wages_vacaCount" align="center" 
									sortable="true" width="80px" >休假天数</th>
								<th halign="center" field="finance_wages_leaveCount" align="center" 
									sortable="true" width="80px">请假天数</th>
								<th halign="center" field="finance_wages_base" align="center" 
									sortable="true" width="80px" >基本工资</th>
								<th halign="center" field="finance_wages_post" align="center" 
									sortable="true" width="80px" >岗位工资</th>
								<th halign="center" field="finance_wages_achieve" align="center" 
									sortable="true" width="80px" >绩效工资</th>
								<th halign="center" field="finance_wages_subsidy" align="center" 
									sortable="true" width="80px" >津贴补助</th>
								<th halign="center" field="finance_wages_baseTotal" align="center" 
									sortable="true" width="80px"  >应发小计</th>
								<th halign="center" field="finance_wages_dedu" align="center" 
									sortable="true" width="80px"  >考勤扣除</th>		
								<th halign="center" field="finance_wages_socSec" align="center" 
									sortable="true" width="80px" >代扣社保</th>
								<th halign="center" field="finance_wages_accFund" align="center" 
									sortable="true" width="80px" >代扣公积金</th>
								<th halign="center" field="deduTotal" align="center" 
									sortable="true" width="80px" formatter="deduTotal" >扣除小计</th>
								<th halign="center" field="finance_wages_wages" align="center" 
									sortable="true" width="80px"  >应税工资</th>
								<th halign="center" field="finance_wages_tax" align="center" 
									sortable="true" width="80px"  >代扣个税</th>
								<th halign="center" field="payTotal" align="center" 
									sortable="true" width="80px" formatter="payTotal" >实发工资</th>
								<th halign="center" field="finance_wages_id" align="center"   hidden="hidden"
									sortable="true" width="80px"  >存档id</th>		
							</tr>
						</thead>
					</table>
				</div>

			</div>
		</div>




	<script type="text/javascript">
		
		function btnCompany(obj){
			
			$("#finance_wages_company").val(obj);
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
		
		function reload(){
			location.reload();
		}
		
		function monDates(){
			var date=new Date;
		 	var year=date.getFullYear(); 
			var month=date.getMonth();
			month = parseInt(month, 10);
			var d= new Date(year, month, 0);
			return d.getDate();
		}
		
		
		
		 function deduTotal(value, row, index) {
			 if(row.finance_wages_name==undefined){
				 return "合计";
			 }else{
			 	return parseFloat(row.finance_wages_dedu)+parseFloat(row.finance_wages_socSec)+parseFloat(row.finance_wages_accFund);
			 }
		}
		 
		 
		function tax(value, row, index) {
			var taxCost=parseFloat(row.finance_wages_wages)-5000;
			if(taxCost>0){
				if(taxCost<3000){
					return (parseFloat(taxCost)*0.03).toFixed(2);
					
				}else if(3000<taxCost<12000){
					return (parseFloat(taxCost)*0.1-210).toFixed(2);
	
				}else if(12000<taxCost<25000){
					return (parseFloat(taxCost)*0.2-1410).toFixed(2);
	
				}else if(25000<taxCost<35000){
					return (parseFloat(taxCost)*0.25-2660).toFixed(2);
	
				}else if(35000<taxCost<55000){
					return (parseFloat(taxCost)*0.3-4410).toFixed(2);
	
				}else if(55000<taxCost<80000){
					return (parseFloat(taxCost)*0.35-7160).toFixed(2);
	
				}else if(80000<taxCost){
					return (parseFloat(taxCost)*0.45-15460).toFixed(2);
	
				}
			
			}else{
				return 0;
			}
		}
		
		function payTotal(value, row, index) {
			
			return (parseFloat(row.finance_wages_wages)-parseFloat(tax(value, row, index))).toFixed(2);
		}
		


		
		$(function() {
			$("#data").admin_grid({
				queryBtn : "#btnSearch",
				excelBtn : "#btnExcel",
				
				
				onLoadSuccess: function(data){
					var mark=1;
					for (var i=1; i <data.rows.length; i++) {
						if (data.rows[i]['finance_wages_center'] == data.rows[i-1]['finance_wages_center']) {
							mark += 1;
							$(this).datagrid('mergeCells',{ 
								index: i+1-mark, 
								field: 'finance_wages_center',
								rowspan:mark
							});
						}else{
							mark=1;     
						}
					}
					
					
				},
				 
				 onClickRow: function (rowIndex, rowData) {
		            $(this).datagrid('unselectRow', rowIndex);
				},
				
			
			});
			
			
				
			
		});
	</script>

</body>
</html>