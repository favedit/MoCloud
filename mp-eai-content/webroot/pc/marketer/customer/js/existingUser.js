var $shadowBg = $(".shadow-bg"),
  $managementPrompt = $(".management-prompt");

function shutDown() {
  $(".note-setupthe").slideUp();
  $shadowBg.hide();
  // $managementPrompt.removeClass('bounceInDown').addClass('fadeOutDown');
  $managementPrompt.hide();
};

function setManagement() {
  $(".management-prompt").show();
  $shadowBg.show();
}
$(function() {
  var link = location.href,
    $managementPrompt = $(".management-prompt");
  var inde = 0;
  $(".management-prompt").on("click", ".remind", function() {
    inde = $(this).index();
    $(this).find("input").prop("checked", true);
  })
  var page = getQueryString("page");
  var data = {};
  var id = null;
  function shutDown() {
    $(".note-setupthe").slideUp();
    $shadowBg.hide();
    $managementPrompt.hide();
  };
  // hover 跳转
  // $(".focus").on("click", ".trs", function() {
  //   var url = $(this).attr("href");
  //   window.open(url, "_blank")
  //   // location.href = url;
  // })
 $(".focus").on("click", ".btns", function(event) {
    event.stopPropagation();
    $(this).parent().find('.note-setupthe').slideDown();
  })
 // 短信设置
   $(".focus").on("click",".confirm",function(){
      var customer=$(this).parent().data("id");
      var selected = $(this).parent().parent().find("input:checked").val()
      var url ="/pc/marketer/customer/Customer.wa?do=settingsSMS";
      var data = {customer:customer,setting:selected};
        setAjax(url, data, function(msg) {
           if(msg){
           location.reload();   
           }
           
        })
       shutDown();
   })
  // 解除关系
  $(".imag-container").on("click", ".remove", function(event) {
    event.stopPropagation();
    // event.preventDefault();
    $managementPrompt.show();
    id = $(this).data("id");
    $shadowBg.show();
  })
  var $contentVal = $("#content"),
    $er = $(".er");
  // 提交
  $(".submits").click(function() {
    var self = $(this);
    var checkedLe = $managementPrompt.find("input:checked");
    if (checkedLe.length != 1 && $contentVal.val() == "") {
      $er.html("请选择,或输入");
      return false;
    }
    self.attr("disabled", "disabled");
    $er.html("");
    data = {
      id: id,
      feedbackCd: checkedLe.data("id"),
      feedbackNote: $contentVal.val()
    };
    setAjax("/pc/marketer/member/Followed.wa?do=removeRelation", data, function(data) {
      if (data) {
        location.href = "/pc/marketer/member/Followed.wa";
      } else {
        self.attr("disabled", false);
        shutDown();
      }
    })
  })
})