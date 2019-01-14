<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script
	src="<%=request.getContextPath()%>/res/admin/scripts/jquery-1.11.0.min.js"
	type="text/javascript"></script>
<script src="http://www.jq22.com/jquery/jquery-migrate-1.2.1.min.js"></script>
<script language="javascript"
	src="<%=request.getContextPath()%>/res/js/jquery.jqprint-0.3.js"></script>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/res/css/prints.css" >
</head>
<body>

	<div id="ddd">  
	    <div id="haden"><th id="biaoti">广州传诚投资有限公司</th><br>
	    <th>——————————————————————————————————————————————————————————————————————————————————————————————</th><br>
	    <h3>求职登记表</h3>
	    
	    </div>
     <div id="toushijian">
        <th>应聘职位（岗位）：___________________</th>
        </div>
        <div >
        <th>时&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;间：______年______月______日</th>
        </div>
		<table border="1" cellspacing="0">
		   <thead>
			<tr>
				    <th>姓&nbsp;&nbsp;名</th>
					<th></th>
					<th>性&nbsp;&nbsp;别</th>
					<th></th>
					<th>出生日期</th>
					<th></th>
					<th rowspan="5"></th>
			</tr>
			<tr>
				  <th>民&nbsp;&nbsp;族</th>
					<th></th>
					<th>婚姻状况</th>
					<th></th>
					<th>健康状况</th>
					<th></th>
			</tr>
			<tr>
				 <th>毕业学校</th>
					<th></th>
					<th>专&nbsp;&nbsp;业</th>
					<th></th>
					<th>学&nbsp;&nbsp;历</th>
					<th></th>
			</tr>
			<tr>
				 <th>籍&nbsp;&nbsp;贯</th>
					<th></th>
					<th>特&nbsp;&nbsp;&nbsp;长</th>
					<th></th>
					<th>社&nbsp;保&nbsp;号</th>
					<th></th>
			</tr>
			<tr>
				 <th>住址</th>
					<th colspan="3"></th>
					<th>联系电话</th>
                    <th></th>
			</tr>
			<tr>
				 <th>身份证号</th>
					<th colspan="3"></th>
					<th>身份证地址</th>
                    <th colspan="2"></th>
			</tr>
			<tr>
				    <th>紧急联系人</th>
					<th></th>
					<th>联系电话</th>
                    <th></th>
                    <th>住址或单位</th>
                    <th colspan="2"></th>
  
			</tr>
			<tr>
				    <th rowspan="3">最高教育<br>简历</th>
					
					<th>起止时间</th>
				
					<th colspan="2">学校名称</th>
				
					<th>学制</th>
				
					<th>取得的学位</th>
			
					<th>获得的奖励</th>
					<tr>
					<th></th>
					<th colspan="2"></th>
		
					<th></th>
					<th></th>
					<th></th>
					</tr>
					<tr>
					<th></th>
					<th colspan="2"></th>
					<th></th>
			 
					<th></th>
					<th></th>
					</tr>
			</tr>
			<tr>
				    <th rowspan="3">工作<br>经历</th>
					
					<th>起止时间</th>
				
					<th colspan="2">工作单位</th>
				
					<th>职务</th>
				
					<th>主要工作</th>
			
					<th>离职原因</th>
					<tr>
					<th></th>
					<th colspan="2"> </th>
					
					<th></th>
					<th></th>
					<th></th>
					</tr>
					<tr>
					<th></th>
					<th colspan="2"></th>
					<th></th>
			 
					<th></th>
					<th></th>
					</tr>
			</tr>
			<tr>
				    <th rowspan="3">直属<br>关系</th>
					
					<th>关系</th>
				
					<th>姓名</th>
				
					<th>年龄</th>
				
					<th colspan="2">工作单位</th>
			
					<th>联系电话</th>
					<tr>
					<th></th>
					<th></th>
					<th></th>
				
					<th colspan="2"></th>
					<th></th>
					</tr>
					<tr>
					<th></th>
					
					<th></th>
					<th></th>
					<th colspan="2"></th>
					<th></th>
					</tr>
					
					<tr><th rowspan="2">自我<br>综合评价</th>
					<th rowspan="2" colspan="6"></th>
					</tr>
					<tr>
					</tr>
					
					<tr>
					<td colspan="3" rowspan="2">用人部门意见：<br>
					拟用 &nbsp;&nbsp;岗位：
					<br>
					 试用期工资：
					<br>
					转正&nbsp;工资:
					<br>
					其&nbsp;&nbsp;&nbsp;它:
					<br>
					&nbsp;
					<br>
					
					评定结果:
					<br>
					签名:
					<br>
						</td>
					<th  valign="top" colspan="2" rowspan="2">资源中心意见</th>
					<th  valign="top" colspan="2" rowspan="2">公司领导审批</th>
					<tr>
					
					
					<tr  style="font-size:1.3em"><td colspan="7">本人承诺：<br>
					 1、本人承诺在入职公司前,已解除与其它公司、企业、事业单位、社会团体的劳动关系并且不承担任何竞业限<br>
					 止义务,否则所产生的一切责任由本人承担。<br>
					 2、公司已按国家有关规定对本人进行安全生产知识、操作规程的培训,本人承诺严格遵守相关安全法规、规章、<br>
					 制度和操作规程,否则所产生的一切责任由本人承担;<br>
					 3、公司已组织学习国家法律、法规 ,公司依法制定的各项规章制度,本人承诺严格遵守国家的各项法律、法规,<br>
					遵守公司制定的各项规章制度和劳动纪律,服从公司的管理,否则所产生的一切责任有本人承担。<br>
					4、以上所登记的资料属实,身心健康,并对其真实性负全部责任。<br>
					5、并熟读公司《员工手册》<br>
					&nbsp;
					<br>
					
					<br>
					  
					</td></tr>
					<td  colspan="7" rowspan="2" style="padding-left :500px; border-top:none;" >
				    本人签名:____________&nbsp;&nbsp;日期:___________年___________月___________日
					
					</td></tr>
			</tr>
			

<thead>
		</table>

	</div>
	<input type="button" onclick=" a()" value="打印" />


	<script language="javascript">
	
		function a() {
		  if(confirm("确定要打印吗?")){
			
			
			$("#ddd").jqprint({
				debug : false,
				importCSS : true, //true表示引进原来的页面的css，默认是true。（如果是true，先会找$("link[media=print]")，若没有会去找$("link")中的css文件）
				printContainer : true, //表示如果原来选择的对象必须被纳入打印（注意：设置为false可能会打破你的CSS规则）。
				operaSupport : false
			//表示如果插件也必须支持歌opera浏览器，在这种情况下，它提供了建立一个临时的打印选项卡。默认是true
			});}
			
		}
	</script>
</body>
</html>