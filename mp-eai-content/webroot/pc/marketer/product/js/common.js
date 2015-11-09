$(function(){
// 用户名
var $userR = $(".user-r");
var $users = $("#users");
 $userR.mouseenter(function(event) {
    $users.show();
 });
 $users.mouseleave(function(event) {
    $(this).hide();
 });
 $userR.mouseleave(function(event) {
    $users.hide();
 });
 $users.mouseenter(function(event) {
    $(this).show();
 });
})
// 错误提示
function setPrompts(time, callback ,state){
    var prompts = $(".prompts");
    prompts.show();
    if(state){
      $(".hide").show();
      $(".lh200").hide();
    }
    setTimeout(function() {
           prompts.fadeOut();
           callback();
        }, time);
}
// 退出
function loginOut() {
    location.href = "/pc/Index.wa?do=loginOut";
}

 // 取key
function getQueryString(name){
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
}
function doLoading() {
 // var htmlBody = document.body;
 // htmlBody.style.backgroundImage = 'url(../ars/eai/background.jpg)';
 var hImages = document.getElementById("loading_img_div").getElementsByTagName("img");
 var index = [7, 6, 5, 4, 3, 2, 1, 0];
 g_loadingHandle = setInterval(function() {
    for (var i = 0; i < index.length; i++) {
       hImages[index[i]].style.opacity = 0.1 + (0.1 * i);
       if (i == index.length - 1) {
          index.push(index[0]);
          index.splice(0, 1);
       }
    }
 }, 80);
}

// ajax post
function setAjax(url,datas,callback,failure){
     $.ajax({
        type: "post",
        dataType: "json",
        url: url,
        data: datas,
        success:function(data){
            callback(data);
        }
    })
}
