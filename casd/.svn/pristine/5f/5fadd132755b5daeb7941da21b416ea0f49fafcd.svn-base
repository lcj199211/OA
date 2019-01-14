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
						value="${head.assess_head_id}" /></td>
					<td class="form-label" style="width:60px;">姓名：</td>
					<td style="width:150px"><input type="text"
						name="assess_head_name" id="assess_head_name" class="mini-textbox"
						value="${head.assess_head_name}" /></td>
					<td class="form-label" style="width:60px;">职位：</td>
					<td style="width:150px"><input type="text" value="${head.assess_head_position}"
						name="assess_head_position" id="assess_head_position"
						class="mini-textbox" /></td>
					<td class="form-label" style="width:60px;">部门：</td>
					<td style="width:150px"><input type="text" value="${head.assess_head_department}"
						name="assess_head_department" id="assess_head_department"
						class="mini-textbox" /></td>
					<td class="form-label" style="width:60px;">公司：</td>
					<td style="width:150px"><input type="text"
						name="assess_head_company" id="assess_head_company"
						class="mini-textbox" value="${head.assess_head_company}" /></td>
				</tr>
				<tr>
					<td class="form-label" style="width:60px;">评估时间：</td>
					<td style="width:150px"><input type="text" value="${head.assess_head_creatdate}"
						name="assess_head_creatdate" id="assess_head_creatdate"
						class="mini-textbox" /></td>
					<td class="form-label" style="width:60px;">评估人：</td>
					<td style="width:150px"><input type="text" value="${head.assess_head_evaluator}"
						name="assess_head_evaluator" id="assess_head_evaluator"
						class="mini-textbox" /></td>
					<td class="form-label" style="width:60px;">总分：</td>
					<td style="width:150px"><input type="text" value="${head.assess_head_totalscore}"
						name="assess_head_totalscore" id="assess_head_totalscore"
						class="mini-textbox" /></td>
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
					data-options="field:'assess_entry_score',width:80,align:'right'">得分</th>

			</tr>

		</thead>


	</table>


	<br />
	<br />
	<br />
	<div style="text-align:center">
		<tr>
			<td style="align:center"><a class="easyui-linkbutton"
				href="javascript:;" id="btnCancel" onclick="btnCancel()">返回</a></td>
		</tr>
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
			
			
			

		});


		//取消
		function btnCancel() {
			location.href="assessList.do";
		}
		
	</script>
</body>
</html>