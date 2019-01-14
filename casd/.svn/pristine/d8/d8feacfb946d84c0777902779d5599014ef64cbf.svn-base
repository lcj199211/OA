
var Log = {
  elem: false,
  write: function(text){
    if (!this.elem) 
      this.elem = document.getElementById('orgchartloader');
    this.elem.innerHTML = text;
    this.elem.style.left = (480 - this.elem.offsetWidth/2) + 'px';
  }
};


function init(json,url){
    
	//Create node line
    $jit.ST.Plot.NodeTypes.implement({
        'nodeline': {
          'render': function(node, canvas, animating) {
                if(animating === 'expand' || animating === 'contract') {
                  var pos = node.pos.getc(true), nconfig = this.node, data = node.data;
                  var width  = nconfig.width, height = nconfig.height;
                  var algnPos = this.getAlignedPos(pos, width, height);
                  var ctx = canvas.getCtx(), ort = this.config.orientation;
                  ctx.beginPath();
                  if(ort == 'left' || ort == 'right') {
                      ctx.moveTo(algnPos.x, algnPos.y + height / 2);
                      ctx.lineTo(algnPos.x + width, algnPos.y + height / 2);
                  } else {
                      ctx.moveTo(algnPos.x + width / 2, algnPos.y);
                      ctx.lineTo(algnPos.x + width / 2, algnPos.y + height);
                  }
                  ctx.stroke();
              } 
          }
        }
          
    });
	
    //Create a new instance
    var st = new $jit.ST({
        'injectInto': 'orgchart',
        //set duration for the animation
        duration: 1000,
        //set animation transition type
        transition: $jit.Trans.Quart.easeInOut,
        levelDistance: 60,
        levelsToShow: 3,
        Node: {
            height: 65,
            width: 180,
            type: 'nodeline',
            color:'#23A4FF',
            lineWidth: 2,
            align:"center",
            overridable: false
        },
        
        Edge: {
            type: 'bezier',
            lineWidth: 2,
            color:'#23A4FF',
            overridable: true
        },
        
		//Retrieve the json data from database and create json objects for org chart
        request: function(nodeId, level, onComplete) {
			console.info($("#"+nodeId));
			//Generate sample data
			/*if(nodeId!='peter wang'&&nodeId!='William chen'){
				var data= [{fullname:'peter wang',title:'engineer'},{fullname:'William chen',title:'senior engineer'}];
				var objs = [];
				for(var i=0;i<data.length;i++) {
					var tmp = data[i];
					var obj = {"id":data[i].fullname, "name": "<div class='orgchartnode'>" + data[i].fullname+"</div>("+data[i].title + ")"};
					objs.push(obj);
				}
				 
				var nodeobjs={};
				nodeobjs.id =  nodeId;
				nodeobjs.children =  objs;
				onComplete.onComplete(nodeId, nodeobjs);  
			}else{*/
				var nodeobjs={};
				
				$.post(url+"?type=Json", function(data) {
				
					
    				if (eval(data.Success)) {
    					nodeobjs.id =  nodeId;
    					nodeobjs.children = data.result ;
    					var stt = data.result;
    					var objsT =stt.split(";");
    					
    					var objs = [];
    					for(var i=0;i<objsT.length;i++) {
    						var tmp =eval('(' +  objsT[i] + ')'); 
    						objs.push(tmp);
    					}
    					
    					console.info(objs);
    					nodeobjs.children =  objs;
    					onComplete.onComplete(nodeId, nodeobjs);  
    				} else {
    					 $.messager.alert("系统提示", data.Msg, "info");
    				}
    			});
				
				
			

        },
        
        onBeforeCompute: function(node){
            Log.write("<div style=\"text-align:center;color:#CCC;background:#202020;padding:10px;border-radius:8px;\">Loading ...</div>");
			$("#orgchartori").fadeOut();
        },
        
        onAfterCompute: function(){
            Log.write("");
			$("#orgchartori").fadeIn();
        },
        
        onCreateLabel: function(label, node){
            label.id = node.id;            
            label.innerHTML = node.name;
            label.onclick = function(){
                st.onClick(node.id);
            };
            //set label styles

            var style = label.style;
            style.width = 180 + 'px';
            style.height = 60 + 'px';            
            style.cursor = 'pointer';
            style.color = '#3D3D3D';
			style.border = '1px solid #888';
            style.backgroundColor = '#CDD1D1';
            style.fontSize = '10px';
			style.fontweight = 'bold';
            style.textAlign= 'center';
            style.textDecoration = 'none';
            style.paddingTop = '3px';

        },
        
        onBeforePlotNode: function(node){
			//alert('onbefore');
            if (node.selected) {
                node.data.$color = "#000";
            }
            else {
                delete node.data.$color;
            }
        },
        
        onBeforePlotLine: function(adj){
            if (adj.nodeFrom.selected && adj.nodeTo.selected) {
                adj.data.$color = "#333333";
                adj.data.$lineWidth = 3;
            }
            else {
                delete adj.data.$color;
                delete adj.data.$lineWidth;
            }
        }
    });
	
//var json = "{id:\"terry li\", name:\"<div class='orgchartnode'>Terry Li</div>(General Manager)\", data:{}, children:[{id:\"Jack lu\", name:\"<div class='orgchartnode'>Jack Lu</div>(QA Manager)\", data:{},children:[]},{id:\"Michelle lu\", name:\"<div class='orgchartnode'>Michelle Lu</div>(Dev Manager)\", data:{},children:[]}]}";   
	
	//st.loadJSON(eval( '(' + json + ')' ));
    st.loadJSON(json );
    //compute node positions and layout
    st.compute();
    //emulate a click on the root node.
    st.onClick(st.root);
    //end
   
	//Change chart direction
	$("#top").click(function(){
			$("#orgchartori").fadeOut();
            st.switchPosition($("#top").attr("id"), "animate", {
                onComplete: function(){
                    $("#orgchartori").fadeIn();
                }
            });	
	});
	
	$("#bottom").click(function(){
			$("#orgchartori").fadeOut();
            st.switchPosition($("#bottom").attr("id"), "animate", {
                onComplete: function(){
                    $("#orgchartori").fadeIn();
                }
            });	
	});

	$("#right").click(function(){
			$("#orgchartori").fadeOut();
            st.switchPosition($("#left").attr("id"), "animate", {
                onComplete: function(){
                    $("#orgchartori").fadeIn();
                }
            });	
	});

	$("#left").click(function(){
			$("#orgchartori").fadeOut();
            st.switchPosition($("#right").attr("id"), "animate", {
                onComplete: function(){
					$("#orgchartori").fadeIn();
                }
            });	
	});	
    //end

}
