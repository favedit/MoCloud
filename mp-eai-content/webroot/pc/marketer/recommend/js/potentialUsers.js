$(function(){
	// 关注
    $(".imag-container").on("click", ".btn", function(){

        setAjax("",{ :$(this).data("id")},function(datas){
            if(datas){
                // ok
                setAjax("url",{},function(data){

                })
            }else{
                // 错误
                $(".prompts").show();
            }
            // location.href = location.href+
        })
    })

})