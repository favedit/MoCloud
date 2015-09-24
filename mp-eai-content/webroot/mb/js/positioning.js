(function(d) {
var tip = null,
   do_hanlder = {},
   link = location.href,
   geo = window.navigator.geolocation;
do_hanlder.successs = function(p) {
   // tip = d.getElementById("error").innerHTML;
   var resulte = p.coords;
   d.getElementById("location_x").value = resulte.longitude;
   d.getElementById("location_y").value = resulte.latitude;               
   // tip.innerHTML = "您的地理坐标,经度：" + resulte.longitude + "，纬度：" + resulte.latitude;
   // location.assign(url);
};
do_hanlder.error = function(error) {
   switch (error.code) {
      case 1:
      //  "<span>您拒绝了共享地理位置信息</span><a href=\"" + link + "\">重试</a>";   
      break;
      default:
      //  "<span>定位失败,请</span><button type=\"button\" id=\"re_geo\">重试</button>";
   }
};
// Permission denied - 用户不允许地理定位
// Position unavailable - 无法获取当前位置
// Timeout - 操作超时
do_hanlder.options = {
   enableHighAccuracy: true,
   timeout: 10000,
   maximumAge: 2500
};

do_hanlder.init = function () {
   var self = this;
   geo.getCurrentPosition(function(p) {
      self.successs(p);
   }, function(error) {
      self.error(error);
   }, self.options);
};
do_hanlder.init();
})(document);