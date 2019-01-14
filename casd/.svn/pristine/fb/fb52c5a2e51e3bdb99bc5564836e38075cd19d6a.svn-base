<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>首页</title>
  <meta charset="utf-8">
  <title></title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
     <link rel="stylesheet" href="<%=request.getContextPath()%>/res/layui/css/layui.css?HJ_v=<%=Math.random()%>"  media="all">
	<script src="<%=request.getContextPath()%>/res/layui/layui.js?HJ_v=<%=Math.random()%>" charset="utf-8"></script>
	<script src="<%=request.getContextPath()%>/res/layui/jquery-3.3.1.min.js?HJ_v=<%=Math.random()%>" charset="utf-8"></script>
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
</head>
<body style="background: #FFF0F5">

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>修改密码</legend>
</fieldset>
 
<form class="layui-form" action="" >
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">用户名:</label>
      <div class="layui-input-inline">
        <input type="text" id="username" value="${username}" class="layui-input">
        <input type="hidden" name="userid" value="${userid}" id="userid" class="layui-input">
      </div>
    </div>
  </div>

  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">原始密码:</label>
      <div class="layui-input-inline">
        <input type="text" id="old_password" type="password" placeholder="请输入原始密码" class="layui-input">
        <input type="hidden" id="hid_username" value="${password}" class="layui-input">
      </div>
       <div class="layui-form-mid layui-word-aux"><label style="color: red;" id="la1"></label></div>
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">新密码:</label>
    <div class="layui-input-inline">
      <input id="new_password" type="password" placeholder="请输入密码" autocomplete="off" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item" style="margin-left:6.6%">
    <button class="layui-btn layui-btn-sm layui-btn-normal" type="button" onclick="formSub();">确认修改</button>
  </div>
</form>


<script>
document.body.parentNode.style.overflow = "hidden";
$(document).ready(function(){
	  $("#old_password").blur(function(){
		  var hid_username=$("#hid_username").val();
		  var old_password=$("#old_password").val();
		  if(hid_username!=old_password){
			  var label=document.getElementById("la1");  
			  label.innerText="您输入的原始密码不正确";  
		  }else{
			  var label=document.getElementById("la1");  
			  label.innerText="";  
		  }

	  });
	
	});

layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer;
  
});

		
	function formSub() {	
		var hid_username = $("#hid_username").val();//原始密码
		var old_password = $("#old_password").val();//验证密码
		var userid = $("#userid").val();
		var username=$("#username").val();
		var password=$("#new_password").val();//新密码
		
		if(hid_username!=old_password){
			layer.alert('您输入的原始密码不正确!', {icon: 5}); 
			return ;
		}
		if(password.length<3){
			layer.alert('密码长度不能小于3位!', {icon: 5}); 
			return;
		}
		var index = layer.load(0,{shade: [0.3,'#FFDAB9']}); //0.1透明度的白色背景 //0.1透明度的白色背景); //0代表加载的风格，支持0-2
    $.ajax({
         url : "editUser.do",
	         type : "post",
         data:{'username':username,
               'password':password,
                'userid':userid,
       },success : function(data) { 
    	   layer.closeAll('loading');
	   if(data.Success){
			layer.alert(data.Msg, {icon: 6},function () {
				   location.href="userList.do";
	                });
         }else {
		    layer.alert(data.Msg, {icon: 5}); 
	         }
          }
		});
    

}
</script>

</body>
</html>