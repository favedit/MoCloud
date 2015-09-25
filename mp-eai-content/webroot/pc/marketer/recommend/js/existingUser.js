var $shadowBg = $(".shadow-bg"),
    $managementPrompt = $(".management-prompt");
    function shutDown(){
      $(".note-setupthe").slideUp();
      $shadowBg.hide();
      // $managementPrompt.removeClass('bounceInDown').addClass('fadeOutDown');
      $managementPrompt.hide();
    // 
    };
    function setManagement(){
        $(".management-prompt").show();
        $shadowBg.show();
    }
$(function(){
	var link = location.href,
	$managementPrompt = $(".management-prompt");
	var inde=0;
    $(".management-prompt").on("click",".remind",function(){
        inde = $(this).index();
        $(this).find("input").prop("checked",true);
    })
    var page = getQueryString("page");
    var data ={};
    var id = null;
    // hover 跳转
    $(".focus").on("click",".trs",function(){
        var url = $(this).attr("href");
         location.href= url;
    })
    // 解除关系
    $(".imag-container").on("click",".remove",function(event){
        event.stopPropagation();
        // event.preventDefault();
        $managementPrompt.show();
        id = $(this).data("id");
        $shadowBg.show();
    })
    var $contentVal = $("#content");
    // 提交
    $(".submits").click(function(){
      var checkedLe = $managementPrompt.find("input:checked");
        if( checkedLe.length != 1){
          alert("请选择");
          return false;
        }
        data = {
          id : id,
          feedbackCd:checkedLe.data("id"),
          feedbackNote:$contentVal.val()
        };
        setAjax("/pc/marketer/recommend/Followed.wa?do=removeRelation",data,function(data){
           if(data){
              location.href="/pc/marketer/recommend/Recommend.wa";
           }else{
              setPrompts();
           }
          // location.href = location.href+
        })
    })


})

