<%@ include file='/cloud/apl/public.inc'%>
<jh:define source="&basePage.user" alias="base"></jh:define>
<jh:define source="&schoolPage.Unit" alias="school"></jh:define>
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
	
	var oriOvld = $("#oriOvld").val();	
	if(oriOvld =="true"){
		$("#ovld").attr("checked",true);
	}else{
		$("#ovld").attr("checked",false);
	}
	
	var oriIconUrl = $("#oriIconUrl").val();
	$("#oriIcon").attr("src",oriIconUrl);
	
	var url = "/cloud/product/country/Country.wa?do=selectAll&date="+new Date().valueOf();
	var data = null;
	$.ajax({
		type:"POST",
		url:url,
		data:data,
		success:function(msg){
			$('#countryId').combobox('loadData',toJsonObject(msg));
			var oriCountryId = $('#oriCountryId').val();
			if(oriCountryId != 0){
				$('#countryId').combobox("select",oriCountryId);
			}
			
			url = "/cloud/product/area/Area.wa?do=selectByCountryId&date="+new Date().valueOf();
			data ={"countryId":oriCountryId};
			$.ajax({
	   			type:"POST",
	   			url:url,
	   			data:data,
	   			success:function(msg){
		 			$('#areaId').combobox('loadData',toJsonObject(msg));
					var oriAreaId = $('#oriAreaId').val();
					if(oriAreaId != 0){
						$('#areaId').combobox("select",$('#oriAreaId').val());
					}
					
					url = "/cloud/product/province/Province.wa?do=selectByCountryAndAreaId&date="+new Date().valueOf();
					data ={"countryId":oriCountryId,"areaId":oriAreaId};
					$.ajax({
	   					type:"POST",
	   					url:url,
	   					data:data,
	   					success:function(msg){
		 					$('#provinceId').combobox('loadData',toJsonObject(msg));
							var oriProvinceId = $('#oriProvinceId').val();
							if(oriProvinceId != 0){
								$('#provinceId').combobox("select",oriProvinceId);
							}
						},
	   					fail:function(){
	   	 					alert("province error");
	   					}
					});
					},
	   			fail:function(){
	   	 			alert("country error");
	   			}
			});
		}
	});
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
	
	var url = "/cloud/product/school/School.wa?do=canModify&date="+new Date().valueOf();
	var data ={"ouid":$('#ouid').val(),"countryId":$('#countryId').combobox("getValue"),"areaId":$('#areaId').combobox("getValue"),"provinceId":$('#provinceId').combobox("getValue"),"label":$('#label').val()};
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
		 }
		 else{
			 $('#form').submit();
		 }
	   },
	   fail:function(){
	   	 alert("error");
	   }
	});
}
function resetSchoolLabel(){	
	var schoolLabel =$("#label").val();
	if($.trim(schoolLabel).length == 0){
		alert("学校名称不能为空！");
		return;
	}
	progress();
	var url ="/cloud/product/school/School.wa?do=resetSchoolLabel&date="+new Date().valueOf();
	var data={"schoolId":$('#ouid').val(),"schoolLabel":schoolLabel};
	$.ajax({
	   type:"POST",
	   url:url,
	   data:data,
	   success:function(msg){
		 closeProgress();	
		 var result = toJsonObject(msg);		 
		 if(result == '1'){
			alert("重置成功！");
		 }else{
			alert("重置失败！");
		 }	
	   },
	   fail:function(){
	   	 alert("error");
	   }
	});
}

</script>
<body class="body">
<div class="easyui-panel" fit='true'>
  <form id="form" style="position:relative; top:0px; left:0px;" method="post" action="/cloud/product/school/School.wa?do=updateSave" enctype="multipart/form-data">
    <div id="cy_right" style="width:100%">
      <div class="right_title"> <span>编辑学校</span> </div>
      <div class="btn_bar">
        <div class="nav_btn"> 
          <a href="#" onClick="submitForm()" class="sub_btn"></a>
           <a href="/cloud/product/school/School.wa" class="back_btn"></a> 
           <a href="javascript:resetSchoolLabel();">[重置用户学校名称]</a> 
        </div>
      </div>
    </div>
    <div class='cy_edit_panel'>
      <table border="0">
        <tr>
          <td align="left" style="width:60px">编号</td>
          <td align="left">
          <input id="ouid" name="ouid" class="disabled" style="width:80px;text-align:right;" readonly value="<jh:write source='&school.ouid'/>"/>
            <input name="userId" style="display:none" value="<jh:write source='&base.ouid' />"/>
            <input id="oriOvld" style="display:none" value="<jh:write source='&school.ovld'/>"/>
            <input type="checkbox" id="ovld" name="ovld" checked="true" style="position:relative;left:260px"/>
            <label style="position:relative;left:260px;">有效</label>
            <input id="oriCountryId" name="oriCountryId" readonly type="hidden" value="<jh:write source='&school.countryId'/>"/>
            <input id="oriAreaId" name="oriAreaId" readonly type="hidden" value="<jh:write source='&school.areaId'/>"/>
            <input id="oriProvinceId" name="oriProvinceId" readonly type="hidden" value="<jh:write source='&school.provinceId'/>"/></td>
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
          <td align="left" ><input id="label" class="easyui-validatebox textbox notnull" style="width:400px;text-align:left'" validtype="length[1,80]" data-options="required:true" name="label" value="<jh:write source='&school.label'/>"/></td>
        </tr>
        <tr>
          <td align="left">图标</td>
          <td align="left"><img id="oriIcon" onerror="imgNotfind();"/>
            <input id="oriIconUrl" style="display:none" value="<jh:write source='&school.iconUrl' />"/>
            <input id="iconUrl" name="iconUrl" type="file" class="checkImageType"/><font color="#FF0000">(100*100)</font></td>
        </tr>
        <tr>
          <td align="left" colspan="2"><font color="#FF0000">【重置】是将此学校的所有用户与本学校绑定，并将用户下的所有应用与此学校绑定。</font></td>          
        </tr>
      </table>
    </div>
  </form>
</div>
</body>
</HTML>