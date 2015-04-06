<%@page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HEAD>
  <META charset="utf-8">
  <META name="author" content="maochunyang">
  <TITLE>C3D-网络三维化服务</TITLE>
  <LINK rel="stylesheet" href="acs/default.css?v=2">
</HEAD>
<SCRIPT language='javascript'>
function doPage(){
   var code = this._code;
   var url = null;
   if(code == 'speed'){
      url = 'engine/galaxy.html';
   }else if(code == 'capability'){
      url = 'engine/capacity.html';
   }else{
      url = 'engine/view.html?code=' + code;
   }
   window.location = url;
}
function doLoad(){
   // 定义数据
   var items = [
      {code:'pvw.show.item.007', label:'洗水池'},
      {code:'pvw.show.item.006', label:'照相机'},
      {code:'pvw.show.item.001', label:'陶瓷物件'},
      {code:'pvw.show.item.002', label:'金属罐子'},

      {code:'pvw.show.item.003', label:'金属佛像'},
      {code:'pvw.show.item.008', label:'金属古钟'},
      {code:'pvw.show.item.009', label:'金属水壶'},
      {code:'pvw.sc.house.01.scene', label:'场景-房间设计'},

      {code:'pvw.sc.car.01.001', label:'汽车1'},
      {code:'pvw.sc.car.01.002', label:'汽车2'},
      {code:'pvw.sc.car.01.003', label:'汽车3'},
      {code:'lbl.scene', label:'场景-展览馆'},

      {code:'pvw.show.item.004', label:'人物头像'},
      {code:'pvw.sc.science.item.002', label:'卡通人物'},
      {code:'pvw.show.skeleton.01', label:'游戏角色'},
      {code:'pvw.sc.courtyard.scene', label:'场景-四合院'},

      {code:'lgt.item.01', label:'金蟾蜍'},
      {code:'lgt.item.02', label:'石狮子'},
      {code:'lgt.item.03', label:'财神像'},
      {code:'lgt.scene', label:'场景-古建筑'},

      {code:'pvw.sc.science.item.001', label:'教育-人体骨骼'},
      {code:'pvw.sc.science.item.003', label:'教育-机械设计'},
      {code:'speed', label:'测试-执行效率'},
      {code:'capability', label:'测试-浏览器信息'},
   ];
   // 生成显示
   var count = items.length;
   for(var n = 0; n < count; n++){
      var item = items[n];
      if(n % 4 == 0){
         var hBr = document.createElement('BR');
         id_container.appendChild(hBr);
      }
      // 创建底板
      var hPanel = document.createElement('DIV');
      hPanel._code = item.code;
      hPanel.className = 'ListItem_Panel';
      hPanel.style.background = "url('ars/" + item.code + ".jpg')";
      hPanel.onclick = doPage;
      // 创建标签
      var hLabel = document.createElement('SPAN');
      hLabel.className = 'ListItem_Label';
      hLabel.innerHTML = item.label;
      hPanel.appendChild(hLabel);
      id_container.appendChild(hPanel);
   }
}
</SCRIPT>
<BODY onload='doLoad()'>
   <TABLE width='100%' height='100%' class='head_background'>
      <TR>
         <TD height=60>
            <TABLE width='100%' height='60px' class='head_background'>
               <TR>
                  <TD width='200px'></TD>
                  <TD><IMG src='ars/logo.png' style='width:240px;height:34px;'>v0.1.0</TD>
                  <TD width='200px'>
                     <A href='/person/account/Register.wp' style='color:#999999'>注册</A>
                     |
                     <A href='/person/account/Login.wp' style='color:#999999'>登录</A>
                     |
                     <A href='bbs' style='color:#999999'>论坛</A>
                  </TD>
               </TR>
            </TABLE>
         </TD>
      </TR>
      <TR>
         <TD style='color:#999999' height='40px'>
            HTML5-WEBGL的3D引擎，可以支持PC端Chrome/FireFox/IE11以上浏览器，支持在各种移动设备上运行。<BR>
            <SPAN style='color:#FFFFFF'>未来的网络将进入3D时代。</SPAN><BR>
            （本网站是临时网站，打开可能速度有些慢）<BR>
         </TD>
      </TR>
      <TR>
         <TD valign='top'>
            <DIV id="id_container"/>
         </TD>
      </TR>
      <TR>
         <TD height='20'>
            <TABLE width='100%' height='60px' class='head_background'>
               <TR>
                  <TD style='color:#999999'>
                     浏览器FireFox/Chrome支持，IE浏览器需要IE11以上支持。移动设备上，支持WEBGL的大部分浏览器都可以运行。<BR>
                     复杂的场景，低配置的浏览器可能无法运行。<BR>
                     邮箱： <A href='mailto:favedit@hotmail.com' style='color:#AAAAAA'>favedit@hotmail.com</A> <A href='"http://www.miitbeian.gov.cn/' style='color:#AAAAAA'>京ICP备15014486号</A>
                  </TD>
               </TR>
            </TABLE>
         </TD>
      </TR>
   </TABLE>
</body>
</HTML>
