<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title></title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
     <link rel="stylesheet" href="<%=request.getContextPath()%>/res/layui/css/layui.css?HJ_v=<%=Math.random()%>"  media="all">
	<script src="<%=request.getContextPath()%>/res/layui/layui.js?HJ_v=<%=Math.random()%>" charset="utf-8"></script>
<%-- 	<script src="<%=request.getContextPath()%>/res/layui/jquery-3.3.1.min.js?HJ_v=<%=Math.random()%>" charset="utf-8"></script> --%>
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
  <style type="text/css">
 .layui-table td, .layui-table th{
      font-size: 13px !important;
  }
   table tr:nth-child(2n){
   background-color:#FFF0F5;
   }
 /*  
  .layui-table-view .layui-table td,.layui-table-view .layui-table th {
	padding: 2px 0 !important;
	
} */
   .layui-table-cell .layui-form-checkbox[lay-skin=primary]{
       top: 1px !important;
   }
  th .layui-table-cell {
  text-align:center;
  padding:0 !important;
  }
  
  .layui-input, .layui-select, .layui-textarea{
      height: 35px !important;
  }
  </style>
</head>
<body> 
<div class="demoTable" style="margin:20px 10px 10px 10px">
  用户名：
  <div class="layui-inline">
    <input class="layui-input" name="username" id="demoReload" autocomplete="off">
  </div>
  <button class="layui-btn" data-type="reload" style="margin-left: 10px">搜索</button>
</div>
 <div style="margin: 10px 10px">
  <table class="layui-hide" id="LAY_table_user" lay-filter="demo"></table> 
  </div>   
  


 
  <!-- 格式化性别 -->
  <script type="text/html" id="sexTpl">
  {{#  if(d.sex == '2'){ }}
    <span style="color: #F581B1;">女</span>
  {{#  } else { }}
         男
  {{#  } }}
</script>
  
 <script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">修改密码</a>
</script>
          
<script>
/* document.body.parentNode.style.overflow ="hidden";//禁止纵向滚动条 */
layui.use(['table','laypage','layer','jquery'], function(){
	 var table = layui.table
	   ,$ = layui.$ 
	   ,laypage = layui.laypage
	   ,layer = layui.layer;
  
  //方法级渲染
  table.render({
    elem: '#LAY_table_user'
    ,url: 'userLists.do'
    ,cols: [[
       {field:'psc', title:'',checkbox: true,align:'center',width:30}
      ,{field:'userid', title: '编号',width:40}
      ,{field:'username', title: '用户名', width:80,align:'center'}
      ,{field:'phone_number', title: '电话号码', width:120, align:'center'}
      ,{field:'sex', title: '性别 ', width:40, align:'center',templet: '#sexTpl'}
      ,{field:'email', title: '邮箱 ', width:170,align:'center'}
      ,{field:'user_card', title: '身份证号码',width:200,align:'center'}
      ,{field:'card_address', title: '身份证地址 ', width:200,align:'center'}
      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:110,align:'center',}
      ]]
    ,id: 'testReload'
    ,page: true
    ,limit:15
    ,height: 750
  });
  
  var $ = layui.$, active = {
		    reload: function(){
		      var demoReload = $('#demoReload').val();
		      
		      //执行重载
		      table.reload('testReload', {
		        page: {
		          curr: 1 //重新从第 1 页开始
		        }
		        ,where: {
		         'username':demoReload
		        }
		        
		      });
		    }
		  };
		  
		  $('.demoTable .layui-btn').on('click', function(){
		    var type = $(this).data('type');
		    active[type] ? active[type].call(this) : '';
		  });
		  
		  //监听工具条 table  lay-filter="demo"
		  table.on('tool(demo)', function(obj){
		    var data = obj.data;
		    //修改密码
		      if(obj.event === 'edit'){
		    	location.href = "editUser.do?" + $.param({
					'cid' : data.userid, //获取用户id
				});
		    }
		  });
		});
		
</script>

</body>
</html>