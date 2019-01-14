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
					<td class="form-label" style="width:60px;display: none">评估考核id：</td>
					<td style="width:150px;display: none"><input
						name="assess_head_id" id="assess_head_id" class="mini-textbox"
						value="" /></td>
					<td class="form-label" style="width:60px;" ><a
							href="javascript:void(0)" onclick="wen('userListCheck.do?index=-7')">姓名(选择):</a>
						</td>
					<td style="width:150px"><input type="text"
						name="assess_head_name" id="assess_head_name" class="mini-textbox" readonly="readonly"
						value="" /></td>
					<td class="form-label" style="width:60px;">职位：</td>
					<td style="width:150px"><input type="text" value=""
						name="assess_head_position" id="assess_head_position" readonly="readonly"
						class="mini-textbox" /></td>
					<td class="form-label" style="width:60px;">部门：</td>
					<td style="width:150px"><input type="text" value=""
						name="assess_head_department" id="assess_head_department" readonly="readonly"
						class="mini-textbox" /></td>
					<td class="form-label" style="width:60px;">公司：</td>
					<td style="width:150px"><input type="text"  readonly="readonly"
						name="assess_head_company" id="assess_head_company"
						class="mini-textbox" value="" /></td>
				</tr>
				<tr>
					<td class="form-label" style="width:60px;">评估人：</td>
					<td style="width:150px"><input type="text" value="${head.assess_head_evaluator}"
						name="assess_head_evaluator" id="assess_head_evaluator"  readonly="readonly"
						class="mini-textbox" /></td>
					<td class="form-label" style="width:60px;">总分：</td>
					<td style="width:150px"><input type="text" value="" readonly="readonly"
						name="assess_head_totalscore" id="assess_head_totalscore"
						class="mini-textbox" /></td>
					<td >
						<a class="easyui-linkbutton" href="javascript:;"data-options="iconCls:'icon-sum',plain:true"  onclick="summary()">汇总</a>
					</td>	
				</tr>
			</table>
		</div>
	</fieldset>

	<div style="margin:20px 0;"></div>

	<table id="assess" class="easyui-datagrid" title="评分内容"
		style="width:900px;height:auto"
		data-options="
				iconCls: 'icon-edit',
				singleSelect: true,
				">

		<thead>
			<tr>
				<th
					data-options="field:'assess_id',width:80,hidden:'hidden',editor:'text'">Item
					ID</th>
				<th data-options="field:'assess_category',width:80,align:'right'">分类</th>
<!-- 				<th data-options="field:'assess_content',width:150,align:'right',editor:{type:'text',options:{required:true}}">评估内容</th>
 -->			
 				<th data-options="field:'assess_content',width:150,align:'right'">评估内容</th>	
 				<th data-options="field:'assess_grade',width:80,align:'right'">内容项总分</th>
				<th data-options="field:'assess_deduct',width:150,align:'right'">扣分情况</th>
				<th
					data-options="field:'assess_score',width:80,align:'right',editor:{type:'text',options:{required:true}}">得分</th>

			</tr>

		</thead>


	</table>


	<br />
	<br />
	<br />
	<div style="text-align:center">
		<tr>
			<td style="align:center"><a class="easyui-linkbutton"
				href="javascript:;" id="btnSave" onclick="btnSave()">提交</a>
				&nbsp;&nbsp;&nbsp;&nbsp; <a class="easyui-linkbutton"
				href="javascript:;" id="btnCancel" onclick="btnCancel()">取消</a></td>
		</tr>
	</div>
<div  id="win" class="easyui-window" data-options="region:'center',title:'请选择值'" closed="true" style="height: 500px; width: 800px" >    
				</div>
	<script type="text/javascript">
		var editIndex = undefined;

		$(function() {
			//加载数据合并单元格
			var rows = ${rows}.rows;
			$('#assess').datagrid('loadData', rows);
			if (rows.length != 0) {
				var assess_category = rows[0].assess_category;
				var index = 0;
				var size = 0;
				for (var i = 0; i < rows.length; i++) {
					if (assess_category != rows[i].assess_category) {
						$('#dg').datagrid('mergeCells', {
							index : index,
							field : 'assess_category',
							rowspan : size,
							colspan : 1
						});
						assess_category = rows[i].assess_category;
						index += size;
						size = 0;
					}
					size++;

				}
				$('#assess').datagrid('mergeCells', {
					index : index,
					field : 'assess_category',
					rowspan : size,
					colspan : 1
				});
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

			
			//单击不选中行
			$('#assess').datagrid({
				onClickRow : function(rowIndex, rowData) {
					$(this).datagrid('unselectRow', rowIndex);
				} 
			});
			/** 双击编辑 */
			$('#assess').datagrid({
				onDblClickCell : function(index, field, value) {
					if (endEditing()&&field=='assess_score') {
						$(this).datagrid('beginEdit', index);
						var ed = $(this).datagrid('getEditor', {
							index : index,
							field : field
						});
						$(ed.target).focus();
					}
				}
			});

		});

		//是否编辑结束
		function endEditing() {
			if (editIndex == undefined) {
				return true
			}
			if ($('#assess').datagrid('validateRow', editIndex)) {
				$('#assess').datagrid('endEdit', editIndex);
				editIndex = undefined;
				return true;
			} else {
				return false;
			}
		}

		//取消
		function btnCancel() {
			location.reload(true);
		}
		
		function summary(){
			$('#assess').datagrid('acceptChanges');

			 var count = $('#assess').datagrid('getRows');
				var sum=0;
				for(var i=0;i<count.length;i++){
				    var  grade=count[i].assess_score;
				     if(grade!=undefined){
				    	 sum+=Number(grade);
				     }
				}
				 $("#assess_head_totalscore").val(sum); 
			
		}
		
		
		//保存
		function btnSave() {
			var assess_head_id = $("#assess_head_id").val();
			var assess_head_name = $("#assess_head_name").val();
			var assess_head_position = $("#assess_head_position").val();
			var assess_head_department = $("#assess_head_department").val();
			var assess_head_company = $("#assess_head_company").val();
			var assess_head_totalscore = $("#assess_head_totalscore").val();
			var assess_head_evaluator = $("#assess_head_evaluator").val();

			var rows = null;
			if (endEditing()) {
				$('#assess').datagrid('acceptChanges');
				rows = $('#assess').datagrid('getRows');
			}
			$.ajax({
				type : 'POST',
				url : 'saveAssess.do',
				data : {
					'assess_head_id' : assess_head_id,
					'assess_head_name' : assess_head_name,
					'assess_head_position' : assess_head_position,
					'assess_head_department' : assess_head_department,
					'assess_head_company' : assess_head_company,
					'assess_head_totalscore' : assess_head_totalscore,
					'assess_head_evaluator' : assess_head_evaluator,
					'rows' : JSON.stringify(rows)
				},
				success : function(data) {
					alert("保存成功");
					//location.reload(true);
				}
			});
		}
		
		
		//选择子页面信息	
		function wen(src) {
			var hrefs = "<iframe id='son' src='"
					+ src
					+ "' allowTransparency='true' style='border:0;width:99%;height:99%;padding-left:2px;' frameBorder='0'></iframe>";
			$("#win").html(hrefs);
			$("#win").window("open");
		}
	</script>
</body>
</html>