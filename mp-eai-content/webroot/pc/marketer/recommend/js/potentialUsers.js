$(function(){
	// 关注
    $(".imag-container").on("click", ".btn", function(){
        var dataId = $(this).data("id")
        setAjax("/pc/marketer/recommend/Recommend.wa?do=follow",{id:dataId},function(datas){
            
            if(datas){
                // ok
               console.log("-------------------");
               location.href="/pc/marketer/recommend/Recommend.wa?do=memberInfo&id="+dataId;
//                setAjax("url",{},function(data){
//
//                })
            }else{
                // 错误
                $(".prompts").show();
            }
            // location.href = location.href+
        })
    })

})