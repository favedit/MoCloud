  function CallBackObject() {
    this.XmlHttp = this.GetHttpObject();
  }
  CallBackObject.prototype.GetHttpObject = function() {
    //第一步：创建XMLHttpRequest对象 
    var xmlhttp;

    if (!xmlhttp && typeof XMLHttpRequest != 'undefined') {
      try {
        xmlhttp = new XMLHttpRequest();
      } catch (e) {
        xmlhttp = false;
      }
    }
    return xmlhttp;
  }
  CallBackObject.prototype.DoCallBack = function(URL, data) {
    if (this.XmlHttp) {
      if (this.XmlHttp.readyState == 4 || this.XmlHttp.readyState == 0) {
        var oThis = this;
        //第二步：注册回调方法，当服务器处理结束返回数据以后利用回调方法实现局部的页面刷新数据 
        //这个回调方法实际上在每次XMLHttpRequest对象的readyState属性的值发生变化的时候都会被调用 
        this.XmlHttp.onreadystatechange = function() {
          //根据XmlHttp.readyState返回值不同调用不同的方法。 
          oThis.ReadyStateChange();
        };
        //第三步：设置和服务器交互的相应参数 
        this.XmlHttp.open('POST', URL);
        this.XmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        //第四步：设置向服务器发送的数据，启动和服务器端交互 
        this.XmlHttp.send(data);
      }
    }
  }
  CallBackObject.prototype.AbortCallBack = function() {
    if (this.XmlHttp)
      this.XmlHttp.abort();
  }
  CallBackObject.prototype.ReadyStateChange = function() {
    //第五步：判断和服务器交互是否完成，还要判断服务器端是否正确返回数据 
    //this.XmlHttp.readyState == 0初始化状态。XMLHttpRequest 对象已创建或已被 abort() 方法重置。 
    if (this.XmlHttp.readyState == 1) {
      //open() 方法已调用，但是 send() 方法未调用。请求还没有被发送。 
      this.OnLoading();
    } else if (this.XmlHttp.readyState == 2) {
      //Send() 方法已调用，HTTP 请求已发送到 Web 服务器。未接收到响应。 
      this.OnLoaded();
    } else if (this.XmlHttp.readyState == 3) {
      //Receiving 所有响应头部都已经接收到。响应体开始接收但未完成。 
      this.OnInteractive();
    } else if (this.XmlHttp.readyState == 4) {
      //Loaded HTTP 响应已经完全接收。 
      if (this.XmlHttp.status == 0)
        this.OnAbort();
      else if (this.XmlHttp.status == 200 && this.XmlHttp.statusText == "OK")
        this.OnComplete(this.XmlHttp.responseText, this.XmlHttp.responseXML);
      else
        this.OnError(this.XmlHttp.status, this.XmlHttp.statusText, this.XmlHttp.responseText);
    }
  }
  CallBackObject.prototype.OnLoading = function() {
    // Loading 
  }
  CallBackObject.prototype.OnLoaded = function() {
    // Loaded 
  }
  CallBackObject.prototype.OnInteractive = function() {
    // Interactive 
  }
  CallBackObject.prototype.OnComplete = function(responseText, responseXml) {
    // Complete 
  }
  CallBackObject.prototype.OnAbort = function() {
    // Abort 
  }
  CallBackObject.prototype.OnError = function(status, statusText) {
    // Error 
  }