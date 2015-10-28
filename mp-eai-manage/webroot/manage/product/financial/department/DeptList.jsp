<%@ include file='/apl/public.inc'%>
<HTML>
<HEAD>
<link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css"
 media="screen" />
<jsp:include page="/manage/common/jeui.jsp"></jsp:include>
<script>
   //显示更新成功
   $(function() {
      doSubmit(null, null);
      var pager = $('#config').datagrid().datagrid('getPager');
      pager.pagination({
         pageSize : 20,
         showPageList : [ 20, 30, 40 ],
         onSelectPage : function(pageNumber, pageSize) {
            doSubmit(pageNumber, pageSize);
         }
     });
   });

   function doSubmit(page, pageSize) {
      progress();
      var url = "/manage/product/financial/department/Department.wa?do=select&date="
              + new Date().valueOf();
      var data = null;
      var label = $.trim($('#label').val()).replaceAll("'", "");
      
      var cityId =$("#city").combobox('getValue');
   
      
      if (label == "部门名称")
         label = null;
      if (page != null) {
          url = "/manage/product/financial/department/Department.wa?do=select&page="
                  + page + "&date=" + new Date().valueOf();
          data = {
        	  "cityId" : cityId,
              "label" : label,
              "page" : page,
              "pageSize" : pageSize
          };
      }
      $.ajax({
          type : "POST",
          url : url,
          data : data,
          success : function(msg) {
             closeProgress();
             $('#config').datagrid('loadData', toJsonObject(msg));
          },
          fail : function() {
              closeProgress();
              alert("error");
          }
      });
   }

   function del(id) {
      return confirmx(
             '确定删除?',
             function() {
                location.href = "/manage/product/financial/department/Department.wa?do=delete&id="
                     + id + "&date=" + new Date().valueOf();
            });
   }
   //更新配置信息-AnjoyTian
   function edit(id) {
      console.info(id);
      window.location.href = "/manage/product/financial/department/Department.wa?do=updateBefore&id="
             + id + "&date=" + new Date().valueOf();
   }
   //搜索按钮，enter键
   document.onkeydown=function(){
      if(event.keyCode=="13"){
         doSubmit(0);    
      }
   }
   
   $(function() {
       var url = "/manage/product/common/Country.wa?do=selectAll&date=" + new Date().valueOf();
       var data = null;
       $.ajax({
          type: "POST",
          url: url,
          data: data,
          success: function(msg) {
             var result = toJsonObject(msg);
             $('#country').combobox('loadData', result);
             $('#country').combobox('select', result[0].ouid);
          },
          fail: function() {
             alert("error");
           }
        });
       getAData(null);
       getCData(null);
   })
	   function getAData(data){
	      var url = "/manage/product/common/Province.wa?do=selectAll&date=" + new Date().valueOf();
	      $.ajax({
	         type: "POST",
	         url: url,
	         data: data,
	         success: function(msg) {
	               var result = toJsonObject(msg);
	               if(result.length==0){
	               }
	               $('#province').combobox("setValue",null);
	               $('#province').combobox('loadData', result);
	               $('#province').combobox('select', result[0].ouid);
	         },
	         fail: function() {
	            alert("error");
	         }
	      });
	   }
	   function getProvince(){
	      var data = null;
	      var provinceId = $('#province').combobox("getValue");
	      if(provinceId!=null) data={"provinceId":provinceId};
	      getPData(data);
	   }
	   function getPData(data){
	      var url = "/manage/product/common/City.wa?do=selectAll&date=" + new Date().valueOf();
	      $.ajax({
	         type: "POST",
	         url: url,
	         data: data,
	         success: function(msg) {
	               var result = toJsonObject(msg);
	               if(result.length==0){
	               }
	               $('#city').combobox("setValue",null);
	               $('#city').combobox('loadData', result);
	               $('#city').combobox('select', result[0].ouid);
	         },
	         fail: function() {
	            alert("error");
	         }
	      });
	   }
</script>
</HEAD>
<body>
 <div id="cy_right" style="width:100%">
  <div class="right_title">
   <span>部门信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
    <a
     href="/manage/product/financial/department/Department.wa?do=insertBefore"
     class="add_btn"></a>
   </div>
 <div style="float: left; margin-top:5px; margin-left: 480px;">
 <span>所属省份</span>  
   <span onclick="getArea()" style="width:140px;"><input class="easyui-combobox" style="width:140px;" id="province" name="province" data-options="valueField:'ouid',textField:'label',editable:false" /></span>
       <input name="areaId" id="provinceId" type="hidden">
   <span>所属城市</span>
       <span onclick="getProvince()" style="width:140px;"><input class="easyui-combobox" style="width:140px;" id="city" name="city" data-options="valueField:'ouid',textField:'label',editable:false" /></span>
</div>
   <div class="nav_search">
    <input id="label" name="label" type="text"
     onfocus="if(this.value=='部门名称'){this.value='';}this.style.color='#000000';"
     onblur="if(this.value=='') {this.value='部门名称';this.style.color='#ccc';}"
     style="color:#ccc" value="部门名称"> <a onClick="doSubmit(0)"
     href="#" class="sear_btn"></a>
   </div>
  </div>
 </div>
 <table id="config" class="easyui-datagrid" fit='true'
  style="align:true"
  data-options="toolbar:'#cy_right',pagination:true,collapsible:true,singleSelect:true,remoteSort:false,multiSort:false,striped: true">
  <thead>
   <tr>
    <th data-options="field:'ouid',halign:'center',align:'right'"
     width="60px">编号</th>
    <th
     data-options="field:'departmentLabel',halign:'center',align:'left'"
     width="100px">所属公司</th>
    <th data-options="field:'regionLabel',halign:'center',align:'left'"
     width="110px">所属区域</th>
    <th
     data-options="field:'label',halign:'center',align:'left',sortable:true"
     width="100px">部门名称</th>
    <th data-options="field:'leaderLabel',halign:'center',align:'left'"
     width="70px">负责人</th>
    <th data-options="field:'leaderPhone',halign:'center',align:'left'"
     width="100px">负责人电话</th>
    <th
     data-options="field:'provinceLabel',halign:'center',align:'left'"
     width="80px">省份</th>
    <th data-options="field:'cityLabel',halign:'center',align:'left'"
     width="80px">城市</th>
    <th
     data-options="field:'detailAddress',halign:'center',align:'left',sortable:true"
     width="200px">详细地址</th>
    <th
     data-options="field:'locationLatitude',halign:'center',align:'left',sortable:true"
     width="100px">位置维度</th>
    <th
     data-options="field:'locationLongitude',halign:'center',align:'left',sortable:true"
     width="100px">位置经度</th>
    <th
     data-options="field:'departmentPhone',halign:'center',align:'left',sortable:true"
     width="110px">部门电话</th>
    <th
     data-options="field:'investmentTotal',halign:'center',align:'left',sortable:true"
     width="80px">投资总额</th>
    <th
     data-options="field:'investmentCount',halign:'center',align:'right',sortable:true"
     width="60px">投资次数</th>
    <th
     data-options="field:'investmentDate',halign:'center',align:'left',sortable:true"
     width="140px">投资时间</th>
    <th
     data-options="field:'redemptionTotal',halign:'center',align:'left',sortable:true"
     width="80px">赎回总额</th>
    <th
     data-options="field:'redemptionCount',halign:'center',align:'right',sortable:true"
     width="60px">赎回次数</th>
    <th
     data-options="field:'redemptionDate',halign:'center',align:'left',sortable:true"
     width="140px">赎回时间</th>
    <th
     data-options="field:'netinvestmentTotal',halign:'center',align:'left',sortable:true"
     width="80px">净投总额</th>
    <th
     data-options="field:'interestTotal',halign:'center',align:'left',sortable:true"
     width="80px">利息总额</th>
    <th
     data-options="field:'performanceTotal',halign:'center',align:'left',sortable:true"
     width="80px">业绩总额</th>
    <th data-options="field:'updateDate',halign:'center',align:'left',sortable:true"
     width="140px">更新时间</th>
    <th
     data-options="field:'operation',halign:'center',align:'center',formatter:insert_editAndDelButton"
     width="140px">操作</th>
   </tr>
  </thead>
 </table>
</body>

</HTML>