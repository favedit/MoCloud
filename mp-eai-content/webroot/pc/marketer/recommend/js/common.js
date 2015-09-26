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

function setPrompts(){
    var prompts = $(".prompts");
    prompts.show();
    setTimeout(function() {
           prompts.hide();
        }, 1500);
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
