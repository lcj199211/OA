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
	<script src="<%=request.getContextPath()%>/res/layui/jquery.min.js?HJ_v=<%=Math.random()%>" charset="utf-8"></script>
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
      <select id="company_id" name="company_id">    
        <c:forEach var="company" items="${companyList}">
        <c:if test="${company.company_id !=17}">
        <option value="${company.company_id}">${company.company_name}</option>
        </c:if>
        </c:forEach>
      </select>
    </div>
   
      <div class="layui-input-inline">
        <input type="text" class="layui-input" id="date1">
      </div> 
      <div class="layui-input-inline">
        <input type="text" class="layui-input" id="date2">
      </div> 
       <div class="layui-input-inline">
        <input type="text" class="layui-input" id="username" placeholder="输入用户名">
      </div> 
      <button class="layui-btn" data-type="reload" style="margin-left: 10px;height: 37px">搜索</button>
      <button class="layui-btn"  onclick="induceExcle()" style="margin-left: 10px;height: 37px">导出</button>
  
    </div>
  </div>
</div>
 
</div>
 <div style="margin: 10px 10px">
  <table class="layui-hide" id="LAY_table_user" lay-filter="demo"></table> 
  </div>   

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
         ,url:'workerAttendLists.do'
    	 ,cols: [[ //标题栏
           {field: 'hr_attend_id', title: 'ID', width: 60, sort: true}
           ,{field: 'username', title: '姓名', width: 80}
           ,{field: 'hr_attend_date', title: '打卡日期', width: 100}
           ,{field: 'hr_attend_workAddress', title: '上班打卡地址', width: 300}
           ,{field: 'hr_attend_offWorkAddress', title: '下班打卡地址', width: 300,}
           ,{field: 'hr_attend_startWork', title: '上班打卡时间', width: 110}
           ,{field: 'hr_attend_knockOff', title: '下班打卡时间', width: 110}
           ,{field: 'hr_attend_workingState', title: '上班打卡状态', width: 110}
           ,{field: 'hr_attend_restState', title: '下班打卡状态', width: 110}
           ,{field: 'hr_attend_overtime', title: '是否加班', width: 85,templet:'<div>{{overTime_formatter(d.hr_attend_overtime)}}</div>'}
           ,{field: 'hr_attend_overtimeDate', title: '加班时长(分钟)', width: 95}
           ,{field: 'hr_attend_WTLength', title: '工作时长(天)', width: 95}
           ,{field: 'replace', title: '是否补卡', width: 90,templet:'<div>{{replace_formatter(d.hr_attend_apply_reason)}}</div>'}
           ,{field: 'hr_attend_apply_reason', title: '补卡原因', width: 150}
         
    	 ]]
    ,id:'testReload'
    ,page: true
    ,limit:15
    ,height: 750
  });
  
    
    //常规用法 时间控件
    laydate.render({
      elem: '#date1'
     ,value: new Date()
    });
    laydate.render({
        elem: '#date2'
        ,value: new Date()
      });
    
       var $ = layui.$, active = {
		    reload: function(){
		      var company_id=$('#company_id').val();
		      var start_time = $('#date1').val();
		      var end_time = $('#date2').val();
		      var username=$('#username').val();
		      //执行重载
		      table.reload('testReload', {
		        page: {
		          curr: 1 //重新从第 1 页开始
		        }
		        ,where: {
		         'end_time':end_time
		        ,'start_time':start_time
		        ,'company_id':company_id
		        ,'username':username
		        }
		        
		      });
		    }
		  };
  

		  //绑定搜索点击事件
		  $('.demoTable .layui-btn').on('click', function(){
		    var type = $(this).data('type');
		    active[type] ? active[type].call(this) : '';
		  });
		 
		  
		});
		
		//加班格式化
         function overTime_formatter(value){
        	 if (value == 0) {
 				return  '<span>否</span>';
 			} else if(value == 1) {
 				return '<span style="color: red;">是</span>';
 			}
         }
		//补卡格式化
         function replace_formatter(value) {
 			if (value != null) {
 				return '<span style="color: red;">是</span>';
 			}else {
 				return "否";
 			}
 		}
		
        function  induceExcle(){
        	var company_id=$("#company_id").val();
        	var start_time=$("#date1").val();
        	var end_time=$("#date2").val();
        	var username=$("#username").val();
            location.href="hrattendExcel.do?company_id="+company_id+"&start_time="+start_time+"&end_time="+end_time+"&username="+username;
        }
		
		
	  	
		
</script>

</body>
</html>