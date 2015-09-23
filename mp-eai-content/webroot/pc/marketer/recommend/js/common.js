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