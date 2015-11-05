<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"+"manage/mobile/";
%>
<!DOCTYPE >
<html>
<head>
<base href="<%=basePath%>">
   <meta name="viewport" charset="UTF-8" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
   <link rel="stylesheet" type="text/css" href="<%=basePath%>/salestools/grouphonorinfo/css/index4.css">
</head>
<body>
  <div class="box pr" id="box">
    <ul id="titles" class="pf titles clearfix">
      <li class="z-active" data="0">高管荣誉</li>
      <li data="1">获奖情况</li>
      <li data="2">知识产权</li>
      <li data="3">企业资质</li>
    </ul>
    <div class="h50"></div>
    <div class="area">
      <h3>高管荣誉</h3>
      <div class="p10 area-container " >
        <img src="<%=basePath%>/salestools/grouphonorinfo/images/honor/0.jpg"/>
        <img src="<%=basePath%>/salestools/grouphonorinfo/images/honor/1.jpg"/>
        <img src="<%=basePath%>/salestools/grouphonorinfo/images/honor/2.jpg"/>
        <img src="<%=basePath%>/salestools/grouphonorinfo/images/honor/3.jpg"/>
        <img src="<%=basePath%>/salestools/grouphonorinfo/images/property/5.jpg"/>
      </div>
    </div>
    <div class="area hide"  >
      <h3>获奖情况</h3>
      <div class="p10 area-container " >
        <img src="<%=basePath%>/salestools/grouphonorinfo/images/Awards/0.jpg"/>
        <img src="<%=basePath%>/salestools/grouphonorinfo/images/Awards/1.jpg"/>
        <img src="<%=basePath%>/salestools/grouphonorinfo/images/Awards/2.jpg"/>
        <img src="<%=basePath%>/salestools/grouphonorinfo/images/Awards/3.jpg"/>
        <img src="<%=basePath%>/salestools/grouphonorinfo/images/Awards/4.jpg"/>
        </div>
    </div>
    <div class="area hide" >
      <h3>知识产权</h3>
      <div class="p10 area-container " >
       <img src="<%=basePath%>/salestools/grouphonorinfo/images/property/0.jpg"/>
        <img src="<%=basePath%>/salestools/grouphonorinfo/images/property/1.jpg"/>
        <img src="<%=basePath%>/salestools/grouphonorinfo/images/property/13.jpg"/>
        <img src="<%=basePath%>/salestools/grouphonorinfo/images/property/11.jpg"/>
        <img src="<%=basePath%>/salestools/grouphonorinfo/images/property/12.jpg"/>
        </div>
    </div>
    <div class="area hide">
      <h3>企业资质</h3>
      <div class="p10 area-container " >
      <img src="<%=basePath%>/salestools/grouphonorinfo/images/aptitude/0.jpg"/>
      <img src="<%=basePath%>/salestools/grouphonorinfo/images/aptitude/1.jpg"/>
      <img src="<%=basePath%>/salestools/grouphonorinfo/images/aptitude/2.jpg"/>
      <img src="<%=basePath%>/salestools/grouphonorinfo/images/aptitude/3.jpg"/>
      <img src="<%=basePath%>/salestools/grouphonorinfo/images/aptitude/4.jpg"/>
      </div>
    </div>
  </div> 
  <script type="text/javascript">
  function Jump(){
    that = this;
    this.timer2 = null;
    that.hs = 10;
    this.trigger = function(id){
      var node = this.$(id),
          thiss = this,
          arr = [0],
          arr2 = [0],
          nodeLis = node.getElementsByTagName("li"),
          nodeLe = nodeLis.length,
          areas = document.getElementsByClassName("area"),
          bodyDemo = document.getElementsByTagName("body")[0];

          for( var i = 0; i < nodeLe ; i++ ){
               (function(arg){         
                 nodeLis[i].onclick = function() {   
                    thiss.setClassName(nodeLe, nodeLis, areas);
                    this.className = "z-active";    
                    areas[arg].style.display = "block";
                    thiss.animate();
                 };     
             })(i);//调用时参数     
            }
          window.onscroll = function(){
            clearInterval(that.timer2);
          }
    };
   this.setClassName = function(le, demos, demo2){
       for( var j=0; j < le ; j++ ){
        demos[j].className = "";
        demo2[j].style.display = "none";
      }
    };
     this.animate = function ( h , index ,areas){
        document.getElementsByTagName("body")[0].scrollTop  = 0;
      }
  } 
  Jump.prototype.$ = function(id) {
    return typeof id === 'string' ? document.getElementById(id) : id;
  };
  window.onload = function() {
      var jump = new Jump();
      jump.trigger("titles");
  };
  </script>
</body>
</html>