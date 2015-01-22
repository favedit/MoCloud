<%@ include file='/cloud/apl/public.inc'%>
<jh:define source="&basePage.user" alias="base"></jh:define>
<HTML>
<HEAD>
<jsp:include page="/cloud/manage/common/jeui.jsp"></jsp:include>
<link rel="stylesheet" href="/cloud/acs/btn_title.css" type="text/css" media="screen" />
</HEAD>
<script>

$(function(){	
	var flag = "<jh:write source='&base.ouid' />";
	if(flag == ""){
    alert("连接超时~！");
    parent.parent.location.href="/cloud/home/Frame.wa"; 
  }
	var url = "/cloud/product/country/Country.wa?do=selectAll&date="+new Date().valueOf();
	var data = null;
	$.ajax({
	   type:"POST",
	   url:url,
	   data:data,
	   success:function(msg){
		 $('#countryId').combobox('loadData', toJsonObject(msg));
	   },
	   fail:function(){
	   	 alert("error");
	   }
	});
	
	/*var url = "/cloud/product/area/Area.wa?do=selectByCountryId&date="+new Date().valueOf();
	var data ={"countryId":0};
	$.ajax({
	   type:"POST",
	   url:url,
	   data:data,
	   success:function(msg){
		 $('#areaId').combobox('loadData', toJsonObject(msg));
	   },
	   fail:function(){
	   	 alert("error");
	   }
	});*/
	
	/*var url = "/cloud/product/province/Province.wa?do=selectByCountryAndAreaId&date="+new Date().valueOf();
	var data ={"countryId":0,"areaId":0};
	$.ajax({
	   type:"POST",
	   url:url,
	   data:data,
	   success:function(msg){
		 $('#provinceId').combobox('loadData', toJsonObject(msg));
		
	   },
	   fail:function(){
	   	 alert("error");
	   }
	});*/
	 
})

function onCountrySelect(record){
	// 清空combobox
	$('#areaId').combobox('clear');
	$('#areaId').combobox('loadData',"");
	$('#provinceId').combobox('clear');
	$('#provinceId').combobox('loadData',"");
	
	var url = "/cloud/product/area/Area.wa?do=selectByCountryId&date="+new Date().valueOf();
	var data ={"countryId":$('#countryId').combobox("getValue")};
	$.ajax({
	   type:"POST",
	   url:url,
	   data:data,
	   success:function(msg){
		 $('#areaId').combobox('loadData', toJsonObject(msg));
	   },
	   fail:function(){
	   	 alert("error");
	   }
	});
}

function onAreaSelect(record){
	// 清空combobox
	$('#provinceId').combobox('clear');
	$('#provinceId').combobox('loadData',"");
	
	var url = "/cloud/product/province/Province.wa?do=selectByCountryAndAreaId&date="+new Date().valueOf();
	var data ={"countryId":$('#countryId').combobox("getValue"),"areaId":$('#areaId').combobox("getValue")};
	$.ajax({
	   type:"POST",
	   url:url,
	   data:data,
	   success:function(msg){
		 $('#provinceId').combobox('loadData', toJsonObject(msg));
	   },
	   fail:function(){
	   	 alert("error");
	   }
	});
}


function submitForm(){
	if(!checkValidateboxValid()) 
		return; 	
	if(!checkImageType()) return;
		
	if($('#countryId').combobox("getValue").length == 0){
		alertx("请指定国家");
		return;
	}
	if($('#areaId').combobox("getValue").length == 0){
		alertx("请指定地区");
		return;
	}
	if($('#provinceId').combobox("getValue").length == 0){
		alertx("请指定省份");
		return;
	}
		
	progress();	
	var url = "/cloud/product/school/School.wa?do=isExist&date="+new Date().valueOf();
	var data ={"countryId":$('#countryId').combobox("getValue"),"areaId":$('#areaId').combobox("getValue"),"provinceId":$('#provinceId').combobox("getValue"),"label":$('#label').val()};
	$.ajax({
	   type:"POST",
	   url:url,
	   data:data,
	   success:function(msg){
		 closeProgress();
		 var result = toJsonObject(msg);
		 if(result == '1'){
			 alertx("此学校已存在！","wrning",function(){
				 $('#label').focus();
			 });
		 }else{
			 $("#form").submit();
		 }
	   },
	   fail:function(){
	   	 alert("error");
	   }
	});
}

</script>
<body bgcolor="#198bc9">
<div class="easyui-panel" fit='true'>
  <form id="form" style="position:relative; top:0px; left:0px;" method="post" action="/cloud/product/school/School.wa?do=insert" enctype="multipart/form-data">
    <div id="cy_right" style="width:100%">
      <div class="right_title"> <span>添加学校</span> </div>
      <div class="btn_bar">
        <div class="nav_btn"> <a href="#" onClick="submitForm()" class="add_btn"></a> <a href="/cloud/product/school/School.wa" class="back_btn"></a> </div>
      </div>
    </div>
    <div class='cy_edit_panel'>
      <table border="0">
        <tr>
          <td align="left" style="width:60px">编号</td>
          <td align="left"><input id="ouid" name="ouid" style="width:80px;text-align:right;" class="disabled" disabled/>
            <input name="userId" style="display:none" value="<jh:write source='&base.ouid' />"/>
            <input type="checkbox" id="ovld" name="ovld" checked="true" style="position:relative;left:260px"/>
            <label style="position:relative;left:260px;">有效</label></td>
        </tr>
        <tr>
          <td align="left">国家</td>
          <td align="left"><select class="easyui-combobox" id="countryId" name="countryId" style="width:400px;" data-options="valueField:'ouid',textField:'label',onSelect:onCountrySelect,editable:false"/>
          </td>
        </tr>
        <tr>
          <td align="left">地区</td>
          <td align="left"><select class="easyui-combobox" id="areaId" name="areaId" style="width:400px;" data-options="valueField:'ouid',textField:'label',onSelect:onAreaSelect,editable:false"/>
          </td>
        </tr>
        <tr>
          <td align="left">省份</td>
          <td align="left"><select class="easyui-combobox" id="provinceId" name="provinceId" style="width:400px;" data-options="valueField:'ouid',textField:'label',editable:false"/>
          </td>
        </tr>
        <tr>
          <td align="left">学校名</td>
          <td align="left"><input id="label" class="easyui-validatebox textbox notnull" style="width:400px;text-align:left;" validtype="length[1,80]" data-options="required:true" name="label" value="" /></td>
        </tr>
        <tr>
          <td align="left">图标</td>
          <td align="left"><input id="iconUrl" name="iconUrl" type="file" class="checkImageType"/><font color="#FF0000">(100*100)</font></td>
        </tr>
      </table>
    </div>
  </form>
</div>
</body>
</HTML>