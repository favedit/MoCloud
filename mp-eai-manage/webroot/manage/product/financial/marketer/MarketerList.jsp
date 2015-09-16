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
		var url = "/product/financial/marketer/Marketer.wa?do=select&date="
				+ new Date().valueOf();
		var data = null;
		if (page != null) {
			url = "/product/financial/marketer/Marketer.wa?do=select&page="
					+ page + "&date=" + new Date().valueOf();
			data = {
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
					location.href = "/product/financial/marketer/Marketer.wa?do=delete&id="
							+ id + "&date=" + new Date().valueOf();
				});
	}

	//更新配置信息-AnjoyTian
	function edit(id) {
		console.info(id);
		window.location.href = "/product/financial/marketer/Marketer.wa?do=updateBefore&id="
				+ id + "&date=" + new Date().valueOf();

	}
</script>
</HEAD>

<body>
	<div id="cy_right" style="width:100%">
		<div class="right_title">
			<span>理财师信息</span>
		</div>
		<div class="btn_bar">
			<div class="nav_btn">
				<a href="/product/financial/marketer/Marketer.wa?do=insertBefore"
					class="add_btn"></a>
			</div>
			<div class="nav_search">
				<input id="name" name="name" type="text"
					onfocus="if(this.value=='名称'){this.value='';}this.style.color='#000000';"
					onblur="if(this.value=='') {this.value='名称';this.style.color='#ccc';}"
					style="color:#ccc" value="名称"> <a onClick="doSubmit(0)"
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
					width="40px">编号</th>
				<!-- <th data-options="field:'linkId',halign:'center',align:'right'" width="40px">关联编号</th> -->
				<!-- <th data-options="field:'userId',halign:'center',align:'right'" width="40px">用户编号</th> -->
				<!-- <th data-options="field:'guid',halign:'center',align:'right'" width="40px">全局唯一标志</th> -->
				<!-- <th data-options="field:'ovld',halign:'center',align:'right'" width="55px">是否删除</th> -->
				<th
					data-options="field:'name',halign:'center',align:'left',sortable:true"
					width="60px">名称</th>
				<th
					data-options="field:'label',halign:'center',align:'left',sortable:true"
					width="60px">标签</th>
				<th data-options="field:'statusCd',halign:'center',align:'left'"
					width="40px">状态</th>
				<th
					data-options="field:'phone',halign:'center',align:'left',sortable:true"
					width="90px">电话号码</th>
				<th data-options="field:'rankLabel',halign:'center',align:'left'"
					width="40px">职务</th>
				<!-- <th data-options="field:'departmentId',halign:'center',align:'right'" width="40px">部门编号</th> -->
				<th
					data-options="field:'departmentLabel',halign:'center',align:'left'"
					width="100px">所属部门</th>
				<!-- <th data-options="field:'departmentLabels',halign:'center',align:'right'" width="100px">部门集合</th> -->
				<!-- <th data-options="field:'regionId',halign:'center',align:'right'" width="100px">所属区域编号</th> -->


				<th
					data-options="field:'customerInvestmentTotal',halign:'center',align:'left',sortable:true"
					width="90px">客户投资总额</th>
				<th
					data-options="field:'customerInvestmentCount',halign:'center',align:'left',sortable:true"
					width="90px">客户投资次数</th>
				<th
					data-options="field:'customerInvestmentDate',halign:'center',align:'left',sortable:true"
					width="90px">客户投资时间</th>
				<th
					data-options="field:'customerRedemptionTotal',halign:'center',align:'left',sortable:true"
					width="90px">客户赎回总额</th>
				<th
					data-options="field:'customerRedemptionCount',halign:'center',align:'left',sortable:true"
					width="90px">客户赎回次数</th>
				<th
					data-options="field:'customerRedemptionDate',halign:'center',align:'left',sortable:true"
					width="90px">客户赎回时间</th>
				<th
					data-options="field:'customerNetinvestmentTotal',halign:'center',align:'left',sortable:true"
					width="90px">客户净投总额</th>
				<th
					data-options="field:'customerInterestTotal',halign:'center',align:'left',sortable:true"
					width="90px">客户利息总额</th>
				<th
					data-options="field:'customerPerformanceTotal',halign:'center',align:'left',sortable:true"
					width="90px">客户业绩总额</th>
				<th
					data-options="field:'note',halign:'center',align:'left',sortable:true"
					width="200px">备注信息</th>
				<th
					data-options="field:'operation',halign:'center',align:'center',formatter:insert_editAndDelButton"
					width="140px">操作</th>
			</tr>
		</thead>
	</table>
</body>

</HTML>