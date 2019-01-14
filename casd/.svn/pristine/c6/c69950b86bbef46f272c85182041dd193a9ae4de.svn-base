<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>首页</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/res/layui/css/layui.css"  media="all">
	<script src="<%=request.getContextPath()%>/res/layui/layui.js" charset="utf-8"></script>
	<script src="<%=request.getContextPath()%>/res/jquery-easyui/jquery.min.js" charset="utf-8"></script>

<style type="text/css">
body{
     background:#c2c2c2;
}
.layui-input{
  border: 0 solid #c2c2c2;
  
}
  .tableth{
	 padding: 0px 0px 0px 0px !important;
	 background: white;
  }

</style>
</head>
<body class="layui-layout-body" style="width: 877px">  
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
  <legend>转正申请</legend>
</fieldset> 
 <div class="layui-form" style="margin-left: 50px">
 <div hidden="hidden">
 	<tr><td><input type="hidden" name="bc_id" id="bc_id" value="${mpaList.bc_id}"/></td></tr>
	<tr><td><input type="hidden"  id="taskName" value="${taskName}"/></td></tr>
	<tr><td><input type="hidden"  id="taskid" value="${taskid}"/></td></tr>
 </div>
<table class="layui-table" lay-size="lg">
  <colgroup>
    <col width="150">
    <col width="300">
    <col width="150">
    <col width="300">
 </colgroup>
  <thead>
    <tr>
      <th>姓名</th>
      <th class="tableth">
      <input type="text" name="username " id="username" value="${mpaList.username}" autocomplete="off" class="layui-input"></th>
      <th>职位</th>
       <th class="tableth">
       <input type="text" name="role_name " id="role_name" value="${mpaList.role_name}" autocomplete="off" class="layui-input"></th>
    </tr> 
     <tr>
      <th>试用期</th>
     <th class="tableth"><input type="text" name="incorporation_date " id="incorporation_date" value="${mpaList.incorporation_date}" autocomplete="off" class="layui-input"></th>
      <th>至</th>
      <th class="tableth"><input type="text" name="close_time" id="close_time" value="${mpaList.close_time}" autocomplete="off" class="layui-input"></th>
    </tr> 
     <tr>
      <th>部门</th>
     <th class="tableth"><input type="text" name="bc_department " id="bc_department" value="${mpaList.bc_department}" autocomplete="off" class="layui-input"></th>
      <th>试用待遇</th>
      <th class="tableth"><input type="text" name="on_trial" id="on_trial" value="${mpaList.on_trial}" autocomplete="off" class="layui-input"></th>
    </tr> 
     <tr>
      <th>自我评价</th>
     <th class="tableth" colspan="3">
         <textarea id="personal" style="border: 0px solid #c2c2c2;" class="layui-textarea">${mpaList.bc_personal}</textarea>
      </th>
    </tr> 
   <tr>
      <th>请选择</th>
   <th class="tableth">
     <div class="layui-input-inline">
      <select id="username_id">
      <option value="">请选择审批人</option>
     <c:forEach items="${userList}" var="user">
		 <option value="${user.userid}">${user.username}</option>
      </c:forEach>
      </select>
       </div>  
    </th>
   <th class="tableth">
        <div class="layui-input-inline">
          <select id="category" name="category">
		    <option value="1">正常转正</option>
			<option value="2">延迟转正</option>
			<option value="3">辞退</option>
          </select>
        </div>  
     </th >
    <th class="tableth">
    	<c:if test="${taskName!='当事人'}">
    <input type="number" id="bc_worker" placeholder="请输入转正待遇" class="layui-input">
    </c:if>
    </th>
   </tr> 
    <tr>
      <th>审核意见</th>
     <th class="tableth" colspan="3">
     	<c:if test="${taskName!='当事人'}">
       <input type="text" id="options" autocomplete="off" class="layui-input">
       </c:if>
      </th>
    </tr> 
  </thead>
</table>
   <div  class="layui-form-item">
      <button class="layui-btn" type="button" onclick="becomepass();" >立即提交</button>
  </div>
  
  <!--展现审核记录  -->
   <div class="layui-boy">
      <table class="layui-hide" id="history" lay-filter="history"></table>
  </div>
</div>
<script type="text/html" id="indexTpl">
    {{d.LAY_TABLE_INDEX+1}}
 </script>
<script>
layui.use(['table','form','layedit','laydate'], function(){
	var table = layui.table
	  ,form = layui.form
	  ,layer = layui.layer
	  ,layedit = layui.layedit
	  ,laydate = layui.laydate;
 
	//展示历史记录
		table.render({
			elem : '#history',
			width : 830,
			cols : [[
			         {field:'',width:88,title:'步骤序号',align:'center',templet : '#indexTpl'}
			        ,{field:'name_',title:'步骤名称',width:120}
			        ,{field:'username',title:'相关人员',width:90,}
			        ,{field:'MESSAGE_',title:'审核意见',minWidth:150}
			        ,{field:'description_',title:'转正待遇',width:150,}
			        ]]
		           ,data:${history}
		           ,even:true
           });

  });
  
  
  
function becomepass() {
	
	var username = $("#username_id").val();//获取审核人
	var taskName = $("#taskName").val(); //获取节点名称
	var option = $("#options").val(); //获取审核意见
	var taskid = $('#taskid').val();
	var category = $('#category').val();
	var personal = $('#personal').val();
	var bc_worker = $('#bc_worker').val();
	var bc_id = $("#bc_id").val();//获取单据id
	if(taskName=='当事人'){
		if(personal==''){
			layer.msg('请填写自我评价!', {icon: 5}); 
			return false;
		}
      
	}
	
	if (option == '') {
		if (taskName != '提交申请' || taskName != '当事人') {
			layer.msg('请填写审核意见',{icon: 5}); 
			return false;
		}
	}
	if (username == '') {
		if (taskName != '董事会') {
			layer.msg('请选择审核人!',{icon: 5}); 
			return false;
		}
	}
	if(taskName!='当事人'){
		if(bc_worker==''){
			layer.msg('请填写转正待遇',{icon: 5});
			return false;
		}

	}
	$.post("become_pass.do", {
		'username' : username,
		'taskName' : taskName,
		'option' : option,
		'taskid' : taskid,
		'category' : category,
		'personal' : personal,
		'bc_worker' : bc_worker,
		'bc_id' : bc_id,		
	}, function(data) {
		if (data.Success) {
			layer.alert(data.Msg, {icon: 6},function () {
				location.href = "findTaskList.do";
	           
			    });
		 }else {
			    layer.alert(data.Msg, {icon:5}); 
		}

	});
}
</script>

</body>
</html>