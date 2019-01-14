
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="PowerCheck" prefix="shop"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
	response.flushBuffer();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">

<title>首页</title>
<link
	href="${CASD_PATH}/res/jquery-easyui/themes/default/easyui.css"
	rel="stylesheet" type="text/css" />
<link href="${CASD_PATH}/res/admin/css/icon.css"
	rel="stylesheet" type="text/css" />
<script
	src="${CASD_PATH}/res/jquery-easyui/jquery.min.js"
	type="text/javascript"></script>
<script
	src="${CASD_PATH}/res/jquery-easyui/jquery.easyui.min.js"
	type="text/javascript"></script>
<script
	src="${CASD_PATH}/res/go/go.js"
	type="text/javascript">
</script>
    
	<link href="${CASD_PATH}/res/go/style.css" rel="stylesheet" type="text/css" />
	<script src="${CASD_PATH}/res/layui/layui.js?HJ_v=<%=Math.random()%>" charset="utf-8"></script>
	<link href="${CASD_PATH}/res/layui/css/layui.css" rel="stylesheet" type="text/css" />
</head>

<body class="easyui-layout" style="overflow-y: hidden;" scroll="no">

	
<div id="myDiagramDiv">
    </div>
</body>
	<script type="text/javascript">
	var data=${data};
	var $ = go.GraphObject.make;
	var myDiagram =
	  $(go.Diagram, "myDiagramDiv",
	    {
	      initialContentAlignment: go.Spot.Center, // 居中显示Diagram内容
	      "undoManager.isEnabled": true, // 打开Ctrl-Z撤销和Ctrl-Y重做功能
	      isReadOnly: true,
	      layout: $(go.TreeLayout, // 1个特殊的树形排列 Diagram.layout布局
	        { angle: 90, layerSpacing: 35 })
	    });
	// 定义个简单的 Node 模板
	myDiagram.nodeTemplate =
	  $(go.Node, "Horizontal",
	    // 为整个Node背景设置为浅蓝色
	    { background: "#0190a0" },
	      
	    $(go.TextBlock,
	      "Default Text",  // 初始化默认文本
	      // 文字周围的空隙, 大号字体, 白色笔画:
	      { margin: 18, stroke: "white", font: "bold 14px sans-serif" },
	      // TextBlock.text参数值与模型数据中的"name"字段绑定
	      new go.Binding("text", 'name')) 
	  );


	// 定义一个直角路由形式的连线模板, 去掉箭头
	myDiagram.linkTemplate =
	$(go.Link,
	  { routing: go.Link.Orthogonal, corner: 5 },
	  $(go.Shape, { strokeWidth: 2, stroke: "#888" })); // the link shape

	var model = $(go.TreeModel);
	model.nodeDataArray = data;



	myDiagram.model = model;

	//监听节点点击事件
	myDiagram.addDiagramListener("ObjectSingleClicked", function(e) {
		//e.subject.part.$d 当前节点数据
		var domData = e.subject.part.$d;
		console.log(domData)
		//加载layer弹出层
		layui.use('layer',function(){
			 var layer = layui.layer;
			//点击弹出
			 layer.open({
				  type: 1,
				  title:domData.name,
				  skin: '', 
				  area: ['420px', '240px'], //宽高
				  content: '<div style="padding:20px 15px;">'+'<p>'+domData.desc+'</p>'+'</div>'
				});
			 
		})
		
	});

	</script>
</html>