var $shadowBg = $(".shadow-bg"),
$managementPrompt = $(".management-prompt");
function shutDown(){
  $(".note-setupthe").slideUp();
  $shadowBg.hide();
  $managementPrompt.hide();
};
function setManagement (){
    $(".management-prompt").show();
    $shadowBg.show();
}
$(document).ready(function(){
var ctrl = {},
    index = 0,
    id = null,
    $noteSetupthe = $(".note-setupthe");
    function settings(){
       $noteSetupthe.slideDown();
       $shadowBg.show();
    }
     // 短信
     $(".sms-settings").on("click",function(){
        settings();
     })
     // 解除
     $(".removes").on("click",function(){
        id = $(this).data("id");
        $managementPrompt.show();
     })
     // 关闭
     $(".shut-down").click(function(){
        shutDown();
     })
     // 确定
     $(".determine").click(function(){
        shutDown();
     })

     $noteSetupthe.on("click","p",function(){
       index=$(this).index();
       $(this).find("input").prop("checked",true);
     })
     
    var inde=0;
    $(".management-prompt").on("click",".remind",function(){
        inde = $(this).index();
        $(this).find("input").prop("checked",true);
    })
     // $managementPrompt 
     // $(".shut-down").
    var data ={};
  

    // 提交
    $(".submits").click(function(){
     data = {
        id : id,
        type:$(".remind").data("id")
     };
    setAjax("",data,function(datas){
      console.log(datas);
      // location.href = location.href+
      })
    })



})
