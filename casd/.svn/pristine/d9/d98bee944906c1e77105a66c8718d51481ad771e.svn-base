<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>发送邮件</title>
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
	<div>
		<table width="90%" class="content">

			<tr>
				<td style="display: inline;"><span
					style="display: inline-block; width: 60px">收件人:</span> <input
					id="receive" type="text" name="receive" style="width:940px" value=""></td>
			</tr>
			<tr>
					<td style="display: inline;"><span
					style="display: inline-block; width: 60px">主题:</span> <input
					id="theme" type="text" style="width:940px" name="theme" value=""></td>
			</tr>
			
			<tr>
				<td>正文:</td><br/>
				
					
			</tr>
				<tr>
				<td>
					<textarea id="content" name="content" style="width:1000px;height:500px;">
尊敬的阁下：<br>
     非常荣幸地通知您，您已经顺利通过我司的面试环节，即将正式入职我司。您的入职状态、岗位职级以及薪金标准构成等由我司资源中心亲自通知。<br>
      如仍有任何疑问，请您致电公司资源中心，联系电话：89660456，联系人：谢经理。<br>
<br>
一、入职体检：<br>
	请于您接到该通知后次日前往广州市二级医院进行体检。逾期未去体检，又未能向我司致电说明特殊情况的，视为放弃入职。<br>
	注意事项如下：<br>
	（1）请于上午8：30-11：00之间前去体检，请与体检中心强调：一定要体检乙肝对两对半（需空腹抽血）。体检报告自取。<br>
	（2）取得体检后，请致电89660456资源中心谢经理，我司届时会和您联系，确认入职办理的具体时间。争取一周内办理入职。<br>
<br>
	1.如果您有不超过一年的近期体检报告（有乙肝两对半项体检结果的），请您致电我司资源中心谢小姐说明，则无须再做体检，请于通知办理入职时自带体检报告。<br>
<br>
一、入职资料准备：<br>
	1.您在正式办理入职时须提交的资料包括：<br>
	1）小一寸红底彩色证件照片2张；<br>
	2）请携带体检报告；<br>
	3）身份证、学历证、相关资格证书原件及复印件，原件审核，复印件等证明文件存档备案；<br>
	4）中国银行的存折或者借记卡的帐号复印件一份；<br>
	5）原单位开具的离职证明。<br>
	2.如果您无法提交原单位的离职证明，可以入职办理时填写个人申明，证明与其它单位无任何劳动关系。<br>
二、办理入职须签署的文书<br>
	资源中心向新员工介绍公司的规章制度以及福利待遇等，让员工清晰了解公司的制度执行及员工的岗位职责，并逐一签名确认。<br>
	您在办理入职手续时，须签订以下劳动合同及相关附件：<br>
	1）劳动合同；<br>
	2）岗位说明书；<br>
	3）企业规章制度签认书；<br>
	4）劳动合同签收表。<br>
<br>
<br>
	以上内容如有疑问请及时联络，欢迎您的加入！愿与您共创广东诚安美好的明天！<br>
<br>
<br>
<br>
                                											 广东诚安时代互联网科技有限公司<br>
                                            										  资源中心<br>
<br>
<br>
															公司地址：广州市海珠区新港东路2440号409室<br>
															(地铁4号线万胜围站B出口转乘137.262等到黄埔村下)<br>
					
					
					
					
					
					
					</textarea>
				</td>
			</tr>
		</table>

	</div>



	<br/><br/><br/>
	<div style="padding: 10px; text-align: center;" border="false">
		<a class="easyui-linkbutton" href="javascript:;" id="btnSend">发送</a>
		<a class="easyui-linkbutton"  href="javascript:;"id="btnCancel">取消</a>
	</div>


</body>


<script type="text/javascript">
	
	$(function() {
		$("#btnSend").click(function() {
			var receive = $("#receive").val();
			var theme = $("#theme").val();
			var content = $("#content").val();
			//校验邮箱
			var myReg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/; 
			if(!myReg.test(receive)){
					alert("收件人邮箱格式错咯！");
					$("#receive").focus();
					return false;
			}
			
			$.ajax({
					type : 'POST',
					url :'email.do',
					traditional: true,
					data :{'receive':receive,
					'theme':theme,
					'content':content
					},
					success : function(data){
						if(data==""){
							alert("发送成功");
						}else{
							alert("发送失败");
						} 
					}	
	   			}); 
		});
		
		$("#btnCancel").click(function() {
			window.location.href = "pmHome.do";
		});
	});
	
	
</script>


</html>