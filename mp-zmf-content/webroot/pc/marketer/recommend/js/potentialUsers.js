$(function(){
	// 关注
    $(".imag-container").on("click", ".btn", function(){
        var dataId = $(this).data("id");
        setAjax("/pc/marketer/recommend/Recommend.wa?do=follow",{id:dataId},function(datas){
            if(datas){
                // alert($(".prompts").find("a").attr("href"));
                $(".prompts").find("a").attr("href","/pc/marketer/recommend/Recommend.wa?do=memberInfo&id="+dataId);
                setPrompts(1500, function(){
                    window.location.reload();
                },true) 
               // location.href="/pc/marketer/recommend/Recommend.wa?do=memberInfo&id="+dataId;
            }else{
                setPrompts(1500, function(){
                    window.location.reload();
                });
            }
        })
    })
})