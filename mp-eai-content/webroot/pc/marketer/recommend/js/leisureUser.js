var $shadowBg = $(".shadow-bg"),
$managementPrompt = $(".management-prompt");
function shutDown(){
  $(".note-setupthe").slideUp();
  $shadowBg.hide();
  $managementPrompt.hide();
};
function setManagement (){
    $managementPrompt.show();
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
    $managementPrompt.on("click",".remind",function(){
        inde = $(this).index();
        $(this).find("input").prop("checked",true);
    })
   
    var data ={},
    $contentVal = $("#content");
    
    // 提交
    $(".submits").click(function(){

        var checkedLe = $managementPrompt.find("input:checked");
        if( checkedLe.length != 1){
            alert("请选择");
            return false;
        }
        // $(this).attr("disabled","disabled");
        data = {
            id : id,
            feedbackCd:checkedLe.data("id"),
            feedbackNote:$contentVal.val()
        };
         setAjax("/pc/marketer/member/Followed.wa?do=removeRelation",data,function(data){
           if(data){
              location.href="/pc/marketer/recommend/Recommend.wa";
           }else{
              setPrompts();
           }
          // location.href = location.href+
        })
    })

})
