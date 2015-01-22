<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="/manage/ajs/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="/manage/ajs/themes/icon.css">
<link rel="stylesheet" type="text/css" href="/manage/ajs/themes/euiStyle.css">
<script type="text/javascript" src="/manage/ajs/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="/manage/ajs/jquery.min.js"></script>
<script type="text/javascript" src="/manage/ajs/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/manage/ajs/easyui-lang-zh_CN.js"></script>

<script type="text/javascript" src="/manage/ajs/myselfJs.js" ></script>
<link rel="stylesheet" type="text/css" href="/manage/acs/myselfCs.css">
</link>
<script>
	function msg(m){
		$.messager.show({
			title:"提示信息",
			timeout:3000,
			msg:m
		});		
	}
	function alertx(msg,info,fun){
		$.messager.alert("提示信息",msg,info,fun);
	}
	
	function confirmx(msg,fun){
		$.messager.confirm("提示信息",msg,function(b){
			if(b){
				fun();
			}
		});
	}
	
	function progress(){
		var win = $.messager.progress({
			title:'请稍等...',
			msg:'数据正在处理中...'
		});
	}
	
	function closeProgress(){
		$.messager.progress('close');
	}
		
	function isValid(){
		var txts=$(".notnull");
		for(var i=0;i<txts.length;i++){
			var txt=$(txts[i]);				
			if(txt.validatebox("isValid")==false){					
				txt.focus();
				return false;
			}
		}		
		return true;
	}
	
	function checkValidateboxValid(){
		var txts=$(".easyui-validatebox");
		for(var i=0;i<txts.length;i++){
		var txt=$(txts[i]);
		if(txt.validatebox("isValid")==false){					
			txt.focus();
			return false;
			}
		}
		return true;
	}
	
	
</script>
