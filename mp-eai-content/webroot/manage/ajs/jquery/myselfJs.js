// ============================================================
// <T>共有fun</T>
// ============================================================
//replaceAll
String.prototype.replaceAll = function(s1, s2) {
   return this.replace(new RegExp(s1, "gm"), s2);
}

function replaceNbsp(temp) {
   return $.trim(temp).replaceAll("&nbsp;", " ");
}

function toJsonObject(str) {
   var temp = replaceNbsp(str);
   return $.parseJSON($.trim(temp).replaceAll("&quot;", "\""));
}

function imgNotfind() {
   var img = event.srcElement;
   img.src = "/cloud/images/noPicture.gif";
   img.onerror = null; // 防止noPicture.gif不存在或者网络环境太循环出发onerror事件
}

function ischinese(str) {
   var reg =  /^[A-Za-z0-9_]*$/g;//字母及数字或下划线组成
   return reg.test(str);
}

function checkNumberBox() {
   var txts = $(".checkNBox");
   for (var i = 0; i < txts.length; i++) {
      var txt = $(txts[i]);
      var txtVal = txt.val();
      if (txtVal.length != 0) {
         if (!/^[0-9]+$/.exec(txtVal)) {
            alert("此输入框必须是数字！");
            txt.val("");
            txt.focus();
            $(txt).css("border", "1px solid #FF0000");
            return false;
         }
      }
   }
   return true;
}

function checkImageType() {
   var images = $(".checkImageType");
   for (var i = 0; i < images.length; i++) {
      var image = $(images[i]);
      var imageVal = image.val();
      if (imageVal.length != 0) {
         var type = imageVal.substring(imageVal.lastIndexOf(".") + 1, imageVal.length).toLowerCase();
         if (type != "jpg" && type != "bmp" && type != "gif" && type != "png" && type != "jpeg") {
            alert("上传文件扩展名是不允许的扩展名。\n只允许[gif,jpg,jpeg,png,bmp]格式。");
            image.focus();
            $(image).css("border", "1px solid #FF0000");
            return false;
         }
      }
   }

   return true;
}

function notNull() {
   var texts = $(".notnull");
   for (var i = 0; i < texts.length; i++) {
      var text = $(texts[i]);
      var textVal = text.val();
      if (textVal.length == 0) {
         alert("不能为空！");
         text.focus();
         $(text).css("border", "1px solid #FF0000");
         return false;
      }
   }

   return true;
}

var kindeditor_items = [
   'source', '|', 'undo', 'redo', '|', 'print', 'template', 'cut', 'copy', 'paste',
   'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
   'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
   'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/',
   'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
   'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image', 'multiimage',
   'media', 'insertfile', 'table', 'hr', 'emoticons', 'baidumap', 'pagebreak',
   'anchor', 'link', 'unlink',
];

function changeStatus(value, row, index) {
   var status = row.statusCdLabel;
   if (status == "未知") {
      return '<font color="#8A8A8A" style="font-weight:bold">未知</font>';
   } else if (status == "申请") {
      return '<font color="#D0BC09" style="font-weight:bold">申请</font>';
   } else if (status == "发布") {
      return '<font color="#006600" style="font-weight:bold">发布</font>';
   } else if (status == "审核未通过") {
      return '<font color="#FF0000" style="font-weight:bold">审核未通过</font>';
   }
}

function insert_infoButton(value, row, index) {
   var edit = '<a href="javascript:void(0)" class="easyui-linkbutton  l-btn l-btn-plain"  plain="true"><span class="l-btn-left" sizset="false" onClick="rowInfo(\'' + row.ouid + '\')"><span class="l-btn-text icon-tip l-btn-icon-left">详情</span></span></a>';
   return edit;
}

function insert_editAndDelButton(value, row, index) {
   var edit = '<a href="javascript:void(0)" class="easyui-linkbutton  l-btn l-btn-plain"  plain="true"><span class="l-btn-left" sizset="false" onClick="edit(\'' + row.ouid + '\')"><span class="l-btn-text icon-edit l-btn-icon-left">编辑</span></span></a>';
   var del = '<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-plain" sizset="true" onClick="del(\'' + row.ouid + '\')" ><span class="l-btn-left" sizset="false"><span class="l-btn-text icon-cancel l-btn-icon-left">删除</span></span></a>';
   return edit + "&nbsp;|&nbsp;" + del;
}

function insert_admin_editButton(value, row, index) {
   var edit = '<a href="javascript:void(0)" class="easyui-linkbutton  l-btn l-btn-plain"  plain="true"><span class="l-btn-left" sizset="false" onClick="edit(\'' + row.ouid + '\')"><span class="l-btn-text icon-edit l-btn-icon-left">编辑</span></span></a>';
   if (row.passport != 'admin') {
      var del = '<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-plain" sizset="true" onClick="del(\'' + row.ouid + '\')" ><span class="l-btn-left" sizset="false"><span class="l-btn-text icon-cancel l-btn-icon-left">删除</span></span></a>';
      return "&nbsp;&nbsp;&nbsp;" + edit + "&nbsp;|&nbsp;" + del;
   } else {
      return "&nbsp;&nbsp;&nbsp;" + edit;
   }
}
//在教程里获取应用列表
function getApplicationJson(page) {
   var url = null;
   if (page != null) {
      url = "/cloud/product/game/Game.wa?do=selectDataByPage&page=" + page + "&date=" + new Date().valueOf();
   } else {
      url = "/cloud/product/game/Game.wa?do=selectDataByPage&date=" + new Date().valueOf();
   }
   $.ajax({
      type: "POST",
      url: url,
      success: function(msg) {
         $("#applicationId").combogrid('grid').datagrid('loadData', toJsonObject(msg));
      },
      fail: function() {
         alert("error");
      }
   });
}