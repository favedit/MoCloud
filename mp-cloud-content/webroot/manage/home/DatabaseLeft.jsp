<!doctype html>
<%@ include file='/cloud/apl/public.inc'%>
<jh:define source="&basePage.user" alias="base"></jh:define>
<html>
<head>
<meta charset="utf-8">
<title>17173游戏学院 - 后台管理系统</title>
<jsp:include page="/manage/common/newIncloud.jsp"></jsp:include>
<script type="text/javascript" src="/cloud/ajs/myselfJs.js" ></script>
<script>
var flag = "<jh:write source='&base.ouid' />";
if(flag == ""){
	 alert("连接超时！");
	 parent.parent.location.href="/manage/home/Frame.wa";	
}

$(function(){	
	initAccordion();
});

function initAccordion(){
	// 清空DatabaseAlias list
	var rootUL = document.getElementById("rootUL"); 
	var childLen = rootUL.childNodes.length;
	for(var i = childLen-1; i >= 0; --i){
		 rootUL.removeChild(rootUL.childNodes[i]);
	}
	
    var url = "/manage/database/Database.wa?do=getAllDatabaseAlias&date="+new Date().valueOf();
	var data = null;
	$.ajax({
		type: "POST",
		url:url,
		data:data,
		success: function(msg){
		  	var temp = $.trim(msg).replaceAll("&nbsp;","");
			var strArray = temp.split("|");
			var rootUL = document.getElementById("rootUL"); 
			
			for(var i =0;i<strArray.length;i++){
				if(strArray[i] == "")
					continue;
				var databaseAlias = strArray[i];
				
				var a = document.createElement("a"); 
				var txt = document.createTextNode(databaseAlias); 
				a.appendChild(txt); 
				
				var ul = document.createElement("ul");   
				ul.className = 'sub-menu'; 
				
				var li = document.createElement("li");   
				li.className = 'common'; 
				li.onclick = function() {onClickDatabase(this);} 
				li.appendChild(a);
				li.appendChild(ul);
				
  				rootUL.appendChild(li); 
			}
			
			
			// Store variables
			var accordion_head = $('.accordion > li > a'),
			accordion_body = $('.accordion li > .sub-menu');
			// Open the first tab on load
			accordion_head.first().addClass('active').next().slideDown('normal');
			// Click function
			accordion_head.on('click', function(event) {
				// Disable header links
				event.preventDefault();
				// Show and hide the tabs on click
				if ($(this).attr('class') != 'active'){
					accordion_body.slideUp('normal');
					$(this).next().stop(true,true).slideToggle('normal');
					accordion_head.removeClass('active');
					$(this).addClass('active');
				}
			});
		},
		fail:function(){
			alert("error");
		}
	});
}


function onClickDatabase(parentLI){
	var databaseAlias = parentLI.innerText;
	var childUL = parentLI.getElementsByTagName("ul")[0];
	var l = childUL.childNodes.length;
	for(var i = childUL.childNodes.length-1; i >= 0; --i){
		childUL.removeChild(i);
	}
	
	var url = "/manage/database/Database.wa?do=getTableNames&date="+new Date().valueOf();
	var data ={"databaseAlias":databaseAlias};
	$.ajax({
		type: "POST",
		url:url,
		data:data,
		success: function(msg){
			var temp = $.trim(msg).replaceAll("&nbsp;","");
			var strArray = temp.split("|");
			
			for(var i =0;i<strArray.length;i++){
				if(strArray[i] == "")
					continue;
				var tableName = strArray[i];
				
				var a = document.createElement("a");
				var txt = document.createTextNode(tableName);  
				a.appendChild(txt); 
				a.target = "right";
				a.href="/manage/database/Database.wa?do=getTableView&databaseAlias="+databaseAlias+"&tableName="+tableName+"&date="+new Date().valueOf();
							
				var li = document.createElement("li"); 
				li.appendChild(a);
				
				childUL.appendChild(li); 
			}
			if(strArray.length > 20){
				childUL.className = 'sub-menu menuscoll'; 
			}
		},
		fail:function(){
			alert("error");
		}
	});
}


</script>
</head>
<body bgcolor="#198bc9">
<div id="cy_left">
  <ul class="accordion">
    <li id="one" class="common"> <a href="#one">数据库操作</a>
      <ul class="sub-menu">
        <li><a id="openQueryView" href="/manage/database/Database.wa?do=getQueryView" target="right">数据查询</a></li>
        <li><a id="openBackupView" href="/manage/database/Database.wa?do=getBackupView" target="right">数据备份</a></li>
      </ul>
    </li>
    <ul id="rootUL" class="accordion">
    </ul>
  </ul>
</div>
</body>
</html>