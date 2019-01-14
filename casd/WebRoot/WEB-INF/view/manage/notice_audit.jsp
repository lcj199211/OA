<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
    

<link
	href="<%=request.getContextPath()%>/res/jquery-easyui/themes/default/easyui.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/res/admin/css/icon.css"
	rel="stylesheet" type="text/css"/>
<script
	src="<%=request.getContextPath()%>/res/jquery-easyui/jquery.min.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/res/jquery-easyui/jquery.easyui.min.js"
	type="text/javascript"></script>

<script charset="utf-8" src="<%=request.getContextPath()%>/res/jquery-easyui/wangEditor/release/wangEditor.min.js"></script>
</head>
<body style="background-color: #eee;">
     <div id="div1"  style= "width:850px;margin:0 auto;background-color: #fff;padding:0 25px;">
       ${notice_content}
    </div>
   
    <table style="width:362px;margin:20px auto;">
    <tr> <td><input type="hidden" id="taskName" value="${taskName}" /></td></tr>
       <tr ><td style="font-size:12px;">选择审核人:</td><td><select  id="username_id" style="width:120px;font-size:12px;">
        <c:forEach items="${userList}" var="user">
         <option value="${user.userid}">${user.username}</option></c:forEach>
         
         
          </select></td> <c:forEach var="c" items="${masdList}"><td>
	       <input type="checkbox"name=items id="${c.company_id}"/>${c.company_name}

        </td></c:forEach>
        <c:forEach var="bot" items="${bot}"><td>
        <c:if test="${bot=='提交'}">
        <td><a class="easyui-linkbutton"
					href="javascript:;" id="btnBack" onclick="notice_pass()">${bot}</a>
        </td>
        </c:if>
          <c:if test="${bot=='驳回'}">
         <td><a class="easyui-linkbutton"
					href="javascript:;" id="btnBack" onclick="rejects()">${bot}</a>
        </td>
        </c:if>
         </c:forEach>
         
         <td><a class="easyui-linkbutton" href="javascript:;" id="btnBack" onclick="updateNot()">修改内容</a></td>
        </tr>
         </table>
        
 <textarea id="text1" style="width:100%; height:200px;" hidden="hidden"></textarea>

	
	
 
  	
    <script type="text/javascript">
        var E = window.wangEditor
        var editor = new E('#div1')
        var $text1 = $('#text1')
        
        editor.customConfig.onchange = function (html) {
            // 监控变化，同步更新到 textarea
            $text1.val(html)
        }
        editor.create()
        // 初始化 textarea 的值
        $text1.val(editor.txt.html())
        
    
       function notice_pass(){
    	  var  content=$text1.val();
    	
    	  var userid=$("#username_id").val();
    	  var taskName = $("#taskName").val();  //获取节点名称
    	  
    	/*   var ids=[];
    	  $("input[name='items']:checked").each(function(){ 
              ids.push($(this).attr("id"));  
          	//可以将delIds通过jquery ajax传到后台了,在后台采用String接收这个delIds参数,然后采用split(",")分隔得到一个
  			//String[]的id数组。可以参考我的博客：http://blog.csdn.net/u013871100/article/details/52740061
        });
		var delIds=ids.join(","); 
		if(delIds==''){
			alert("请选择请公司"); 
			return false;
	
		} */
		
		if (taskName =='审核签发') {
		}else{
			if(userid==''){
				alert("请选择审核人"); 
				return false;
		
			}
			
		  }
		
            	$.ajax({
				type : 'POST',
				url :'notice_pass.do',
			
				data :{
					
					   'userid':userid,
					   'taskName':taskName,
					   'taskid':${taskid},
					
				},
				success : function(data){
					if (data.Success) {
						alert( data.Msg);
							location.href = "findTaskList.do";
							
				      	}else {
						alert(data.Msg);
					      }
					
				}
			   	 
				});
       }
        
        function updateNot(){
        	
          var  content=$text1.val(); 
          
        	$.ajax({
				type : 'POST',
				url :'updateNot.do',
				data :{
					   'content':content,
					   'taskid':${taskid},
				},success : function(data){
				
					if (data.Success) {
						alert(data.Msg);							
				      window.location.reload(true);
					} else {
						alert(data.Msg);
					}

				
			
				}}); 
        	
        }
        
    
    	//驳回功能
		function rejects() {
			var options = $("#options").val();
			if (options == '') {
				alert("意见不能为空!");
				return false;
			}
			$.ajax({
				type : "POST",
				url : "rejects.do",
				data : {
					'taskid' : ${taskid},

					'options' : options,
				},
				success : function(data) {
					
					var data = eval("(" + data + ")");
					if (data.Success) {
						alert(data.Msg);
						location.href = "findTaskList.do";
							
					} else {
						alert(data.Msg);
					}
				
				}
			});

		}

        
    </script>
</body>
</html>