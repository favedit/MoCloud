<%@ include file='/apl/public.inc' %>
   <HTML>
   <HEAD>
      <link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css" media="screen" />
      <jsp:include page="/manage/common/jeui.jsp"></jsp:include>
      <script>
      //显示更新成功
         $(function() {
            doSubmit(null,null);
            var pager = $('#config').datagrid().datagrid('getPager');
            pager.pagination({
               pageSize: 20,
               showPageList: [20,30,40],
               onSelectPage: function(pageNumber,pageSize) {
                  doSubmit(pageNumber,pageSize);
               }
            });
         });

         function doSubmit(page,pageSize) {
            progress();
            var url = "/product/financial/department/Department.wa?do=select&date=" + new Date().valueOf();
            var data = null;
            var code = $.trim($('#code').val()).replaceAll("'", "");
            if (code == "公司名称") code = null;
            if (page != null) {
               url = "/product/financial/department/Department.wa?do=select&page=" + page + "&date=" + new Date().valueOf();
               data = {
                  "code": code,
                  "page": page,
                  "pageSize":pageSize
               };
            }
            $.ajax({
               type: "POST",
               url: url,
               data: data,
               success: function(msg) {
                  closeProgress();
                  $('#config').datagrid('loadData', toJsonObject(msg));
               },
               fail: function() {
                  closeProgress();
                  alert("error");
               }
            });
         }

         function del(id) {
            return confirmx('确定删除?',
               function() {
//                  var url = "/product/configration/Configration.wa?do=delete&date=" + new Date().valueOf();
//                  var data = {
//                     "id": id
//                  };
//                  $.getJSON(url, data, function(d) {
//                     alert(d);
//                     var result = toJsonObject(d);
//                      console.log(result);
//                     if (result.status == "1") {
//                        location.href = result.url;
//                     } else {
//                        alertx(result.url, "warning", function() {
//                           location.href = "/product/configration/Configration.wa";
//                        });
//                     }
//                  });
               location.href = "/product/configration/Configration.wa?do=delete&id=" + id + "&date=" + new Date().valueOf();
               });
         }
         
         //更新配置信息-AnjoyTian
         function edit(id){
         console.info(id);
         window.location.href="/product/configration/Configration.wa?do=updateBefore&id=" + id + "&date=" + new Date().valueOf();
         
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
               <a href="/product/configration/Configration.wa?do=insertBefore" class="add_btn"></a>
            </div>
            <div class="nav_search">
               <input id="code" name="" type="text" onfocus="if(this.value=='公司名称'){this.value='';}this.style.color='#000000';" onblur="if(this.value=='') {this.value='公司名称';this.style.color='#ccc';}" style="color:#ccc" value="公司名称">
               <a onClick="doSubmit(0)" href="#" class="sear_btn"></a>
            </div>
         </div>
      </div>
      <table id="config" class="easyui-datagrid" fit='true' style="align:true" data-options="toolbar:'#cy_right',pagination:true,collapsible:true,singleSelect:true,remoteSort:false,multiSort:false,striped: true">
         <thead>
            <tr>
               <th data-options="field:'ouid',halign:'center',align:'right'" width="60px">编号</th>
<!--               <th data-options="field:'name',halign:'center',align:'left',sortable:true" width="100px">名称</th>-->
<!--               <th data-options="field:'departmentId',halign:'center',align:'right'" width="60px">所属公司编号</th>-->
               <th data-options="field:'departmentLabel',halign:'center',align:'left'" width="100px">所属公司</th>
<!--               <th data-options="field:'regionId',halign:'center',align:'right'" width="60px">所属区域编号</th>-->
               <th data-options="field:'regionLabel',halign:'center',align:'left'" width="150px">所属区域</th>
               <th data-options="field:'label',halign:'center',align:'left',sortable:true" width="100px">公司名称</th>
<!--               <th data-options="field:'level',halign:'center',align:'right'" width="60px">级别</th>-->
<!--               <th data-options="field:'leaderId',halign:'center',align:'right'" width="60px">负责人编号</th>-->
               <th data-options="field:'leaderLabel',halign:'center',align:'left'" width="60px">负责人</th>
<!--               <th data-options="field:'leaderPhone',halign:'center',align:'right'" width="80px">负责人电话</th>-->
<!--               <th data-options="field:'provinceId',halign:'center',align:'right'" width="60px">省份标签编号</th>-->
               <th data-options="field:'provinceLabel',halign:'center',align:'left'" width="80px">省份标签</th>
<!--               <th data-options="field:'cityId',halign:'center',align:'left'" width="60px">城市编号</th>-->
               <th data-options="field:'cityLabel',halign:'center',align:'left'" width="80px">城市标签</th>
               <th data-options="field:'locationLatitude',halign:'center',align:'left'" width="90px">位置维度</th>
               <th data-options="field:'locationLongitude',halign:'center',align:'left'" width="90px">位置经度</th>
               <th data-options="field:'detailAddress',halign:'center',align:'left',sortable:true" width="200px">详细地址</th>
               <th data-options="field:'departmentPhone',halign:'center',align:'left',sortable:true" width="100px">部门电话</th>
               <th data-options="field:'investmentTotal',halign:'center',align:'left',sortable:true" width="100px">投资总额</th>
               <th data-options="field:'investmentCount',halign:'center',align:'left',sortable:true" width="60px">投资次数</th>
               <th data-options="field:'investmentDate',halign:'center',align:'left',sortable:true" width="140px">投资时间</th>
               <th data-options="field:'redemptionTotal',halign:'center',align:'left',sortable:true" width="100px">赎回总额</th>
               <th data-options="field:'redemptionCount',halign:'center',align:'left',sortable:true" width="60px">赎回次数</th>
               <th data-options="field:'redemptionDate',halign:'center',align:'left',sortable:true" width="140px">赎回时间</th>
               <th data-options="field:'netinvestmentTotal',halign:'center',align:'left',sortable:true" width="100px">净投总额</th>
               <th data-options="field:'interestTotal',halign:'center',align:'left',sortable:true" width="100px">利息总额</th>
               <th data-options="field:'performanceTotal',halign:'center',align:'left',sortable:true" width="100px">业绩总额</th>
               <th data-options="field:'note',halign:'center',align:'left',sortable:true" width="200px">备注信息</th>
               <th data-options="field:'updateDate',halign:'center',align:'left'" width="140px">更新时间</th>
               <th data-options="field:'operation',halign:'center',align:'center',formatter:insert_editAndDelButton" width="140px">操作</th>
            </tr>
         </thead>
      </table>
   </body>

   </HTML>