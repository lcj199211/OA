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
	<script src="${CASD_PATH}/res/layui/format/dateformat.js?HJ_v=<%=Math.random()%>" charset="utf-8"></script>
<%-- 	<script src="<%=request.getContextPath()%>/res/layui/jquery-3.3.1.min.js?HJ_v=<%=Math.random()%>" charset="utf-8"></script> --%>
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
  <style type="text/css">
 .layui-table td, .layui-table th{
      font-size: 13px !important;
      color: #3a3a3a;
  }
  /*设置隔行颜色  */
   table tr:nth-child(2n){
   background-color:#FFF0F5;
   }
  .layui-input, .layui-select, .layui-textarea{
      height: 35px !important;
  }
  </style>
</head>
<body> 
<div class="demoTable" style="margin:20px 10px 10px 10px">
 <div class="layui-form">
  <div class="layui-form-item">
    <div class="layui-inline">
   
      <div class="layui-input-inline">
        <input type="text" class="layui-input" id="date1" placeholder="申请时间">
      </div> 
      <div class="layui-input-inline">
        <input type="text" class="layui-input" id="date2" placeholder="结束时间">
      </div> 
      <button class="layui-btn" data-type="reload" style="margin-left: 10px">搜索</button>
    </div>
  </div>
</div>
 
</div>
 <div style="margin: 10px 10px">
  <table class="layui-hide" id="LAY_table_user" lay-filter="demo"></table> 
  </div>   
  
  <!-- 表格查看按钮 -->
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="look" >查看</a>
</script>

<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">申请请假</button>

  </div>
</script>

<script>
/* document.body.parentNode.style.overflow ="hidden";//禁止纵向滚动条 */
layui.use(['table','laypage','layer','laydate','jquery'], function(){
	 var table = layui.table
	   ,$ = layui.$ 
	   ,laypage = layui.laypage
	   ,layer = layui.layer
	   ,laydate = layui.laydate;
    //方法级渲染
    

    table.render({
    elem: '#LAY_table_user'
         ,url:'leavePersonals.do'
    	 ,toolbar: '#toolbarDemo'
    	 ,cols: [[ //标题栏
           {field: 'id', title: 'ID', width: 80, sort: true}
           ,{field: 'applicant', title: '用户名', width: 120}
           ,{field: 'position', title: '职位', width: 120}
           ,{field: 'leave_category', title: '请假类别', width: 100,templet:'<div>{{category(d.leave_category)}}</div>'}
           ,{field: 'start_time', title: '起始时间', width: 120,templet:'<div>{{start_time(d.start_time.time)}}</div>'}
           ,{field: 'end_time', title: '结束时间', width: 120,templet:'<div>{{start_time(d.end_time.time)}}</div>'}
           ,{field: 'status', title: '状态', width: 120,templet:'<div>{{status_format(d.status)}}</div>'}
           ,{field: 'reason', title: '原因', minWidth: 150}
           ,{field: 'psn', title: '操作',toolbar:'#barDemo', width:80}
    	 ]]
    ,id:'testReload'
    ,page: true
    ,limit:15
    ,height: 750
  });
  
    
    //常规用法 时间控件
    laydate.render({
      elem: '#date1'
    });
    laydate.render({
        elem: '#date2'
      });
    
       var $ = layui.$, active = {
		    reload: function(){
		      var start_time = $('#date1').val();
		      var end_time = $('#date2').val();
		      //执行重载
		      table.reload('testReload', {
		        page: {
		          curr: 1 //重新从第 1 页开始
		        }
		        ,where: {
		         'end_time':end_time
		        ,'start_time':start_time
		        }
		        
		      });
		    }
		  };
  
		 //监听工具条 table  lay-filter="demo"
		 table.on('tool(demo)', function(obj){
		   var data = obj.data;
		    //办理任务
		     if(obj.event == 'look'){
		   	  location.href = "Leave_flow.do?" + $.param({
					'bizId' : data.id, //获取用户id
				});
		     }
		 });

		  //绑定搜索点击事件
		  $('.demoTable .layui-btn').on('click', function(){
		    var type = $(this).data('type');
		    active[type] ? active[type].call(this) : '';
		  });
		 
		//头工具栏事件
		  table.on('toolbar(demo)', function(obj){
	
		    switch(obj.event){
		      case 'getCheckData':
		    	  location.href = "leave.do";      
		      break;
		      case 'isAll':
		        layer.msg(checkStatus.isAll ? '全选': '未全选');
		      break;
		    };
		  });
		  
		});
		
		//状态格式化
         function status_format(value){
        	 if (value == 1) {
 				return  '<span style="color: red;">审批不通过</span>';
 			} else if (value == 3) {
 				return "审批通过";
 			} else if (value ==2) {
 				return '<span style="color: #F581B1;">审核中</span>';
 			}else if(value==0){
 				return "初始录入";
 			}
         }
		//类型格式话
         function category(value) {
 			if (value == 0) {
 				return "事假";
 			} else if (value == 1) {
 				return "病假";
 			} else if (value == 2) {
 				return "婚假";
 			}else if (value == 3) {
 				return "产假";
 			}else if (value == 4) {
 				return "丧假";
 			}else if (value == 5) {
 				return "年假";
 			}else if (value == 6) {
 				return "其他";
 			}
 		}
		
		//表格时间格式化
		  function start_time(obj){
			   var date=new  Date(obj); 
			   var time=date.Format("yyyy-MM-dd");
			   return time;
		  }
		
		
	  	
		
</script>

</body>
</html>