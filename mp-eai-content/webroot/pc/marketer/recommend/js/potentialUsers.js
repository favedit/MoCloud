$(function(){
	// 关注
    var prompts = $(".prompts");
    function setPrompts(){
        prompts.show();
        setTimeout(function() {
               prompts.hide();
            }, 1000);
    }
    $(".imag-container").on("click", ".btn", function(){
        var dataId = $(this).data("id");
        setAjax("/pc/marketer/recommend/Recommend.wa?do=follow",{id:dataId},function(datas){
            if(datas){
               location.href="/pc/marketer/recommend/Recommend.wa?do=memberInfo&id="+dataId;
            }else{
                setPrompts();
            }
        })
    })
})