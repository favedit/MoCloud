package util;

import org.apache.commons.lang.StringUtils;

/**
 * 根据 user agent string 判断用户的平台、浏览器
 * 参考资料
 * **************************************************************************************************************************************************
 * 
 * 台式机
 * 
 * Linux Ubuntu
 * Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.2.2pre) Gecko/20100225 Ubuntu/9.10 (karmic) Namoroka/3.6.2pre
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * Linux Mandriva 2008.1
 * Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.1) Gecko/2008072403 Mandriva/3.0.1-1mdv2008.1 (2008.1) Firefox/3.0.1
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * Linux suSE 10.1
 * Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.8.0.3) Gecko/20060425 SUSE/1.5.0.3-7 Firefox/1.5.0.31
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * Windows XP SP3
 * Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.1) Gecko/20090624 Firefox/3.5 (.NET CLR 3.5.30729)
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * Windows Vista
 * Mozilla/5.0 (Windows; U; Windows NT 6.1; nl; rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13
 * Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.2.6) Gecko/20100625 Firefox/3.6.6 (.NET CLR 3.5.30729)
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * windows 2000
 * Mozilla/5.0 (Windows; U; Windows NT 5.0; en-GB; rv:1.8.1b2) Gecko/20060821 Firefox/2.0b2
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * Windows 7
 * Mozilla/5.0 (Windows NT 6.1; WOW64; rv:14.0) Gecko/20100101 Firefox/14.0.1
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * Windows Server 2008
 * Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US; rv:1.9.1.5) Gecko/20091102 Firefox/3.5.5 (.NET CLR 3.5.30729)
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * iMac OSX 10.7.4
 * Mozilla/5.0 (Macintosh; Intel Mac OS X 10.7; rv:13.0) Gecko/20100101 Firefox/13.0.1
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * Mac OS X
 * Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.6; en-US; rv:1.9.2.9) Gecko/20100824 Firefox/3.6.9
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * 
 * 手持设备
 * 
 * iPad
 * Mozilla/5.0 (iPad; U; CPU OS 3_2 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Version/4.0.4 Mobile/7B334b Safari/531.21.10
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * iPad 2
 * Mozilla/5.0 (iPad; CPU OS 5_1 like Mac OS X; en-us) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9B176 Safari/7534.48.3
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * iPhone 4
 * Mozilla/5.0 (iPhone; U; CPU iPhone OS 4_0 like Mac OS X; en-us) AppleWebKit/532.9 (KHTML, like Gecko) Version/4.0.5 Mobile/8A293 Safari/6531.22.7
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * iPhone 5
 * Mozilla/5.0 (iPhone; CPU iPhone OS 5_0 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9A334 Safari/7534.48.3
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * Android
 * Mozilla/5.0 (Linux; U; Android 2.2; en-us; Nexus One Build/FRF91) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1
 * **************************************************************************************************************************************************
 * @author Defonds
 */
public class UserAgentUtil
{

   /**
    * 用途：根据客户端 User Agent Strings 判断其浏览器、操作平台
    * if 判断的先后次序：
    * 根据设备的用户使用量降序排列，这样对于大多数用户来说可以少判断几次即可拿到结果：
    * 	>>操作系统:Windows > 苹果 > 安卓 > Linux > ...
    * 	>>Browser:Chrome > FF > IE > ...
    * @param userAgentStr
    * @return
    */
   public static UserAgent getUserAgent(String userAgent){
      if(StringUtils.isBlank(userAgent)){
         return null;
      }

      if(userAgent.indexOf("Windows") > 0){//主流应用靠前
         /**
          * ******************
          * 台式机 Windows 系列
          * ******************
          * Windows NT 6.2	-	Windows 8
          * Windows NT 6.1	-	Windows 7
          * Windows NT 6.0	-	Windows Vista
          * Windows NT 5.2	-	Windows Server 2003; Windows XP x64 Edition
          * Windows NT 5.1	-	Windows XP
          * Windows NT 5.01	-	Windows 2000, Service Pack 1 (SP1)
          * Windows NT 5.0	-	Windows 2000
          * Windows NT 4.0	-	Microsoft Windows NT 4.0
          * Windows 98; Win 9x 4.90	-	Windows Millennium Edition (Windows Me)
          * Windows 98	-	Windows 98
          * Windows 95	-	Windows 95
          * Windows CE	-	Windows CE
          * 判断依据:http://msdn.microsoft.com/en-us/library/ms537503(v=vs.85).aspx
          */
         if(userAgent.indexOf("Windows NT 6.2") > 0){//Windows 8
            return judgeBrowser(userAgent, "Windows", "8", null);//判断浏览器
         }else if(userAgent.indexOf("Windows NT 6.1") > 0){//Windows 7
            return judgeBrowser(userAgent, "Windows", "7", null);
         }else if(userAgent.indexOf("Windows NT 6.0") > 0){//Windows Vista
            return judgeBrowser(userAgent, "Windows", "Vista", null);
         }else if(userAgent.indexOf("Windows NT 5.2") > 0){//Windows XP x64 Edition
            return judgeBrowser(userAgent, "Windows", "XP", "x64 Edition");
         }else if(userAgent.indexOf("Windows NT 5.1") > 0){//Windows XP
            return judgeBrowser(userAgent, "Windows", "XP", null);
         }else if(userAgent.indexOf("Windows NT 5.01") > 0){//Windows 2000, Service Pack 1 (SP1)
            return judgeBrowser(userAgent, "Windows", "2000", "SP1");
         }else if(userAgent.indexOf("Windows NT 5.0") > 0){//Windows 2000
            return judgeBrowser(userAgent, "Windows", "2000", null);
         }else if(userAgent.indexOf("Windows NT 4.0") > 0){//Microsoft Windows NT 4.0
            return judgeBrowser(userAgent, "Windows", "NT 4.0", null);
         }else if(userAgent.indexOf("Windows 98; Win 9x 4.90") > 0){//Windows Millennium Edition (Windows Me)
            return judgeBrowser(userAgent, "Windows", "ME", null);
         }else if(userAgent.indexOf("Windows 98") > 0){//Windows 98
            return judgeBrowser(userAgent, "Windows", "98", null);
         }else if(userAgent.indexOf("Windows 95") > 0){//Windows 95
            return judgeBrowser(userAgent, "Windows", "95", null);
         }else if(userAgent.indexOf("Windows CE") > 0){//Windows CE
            return judgeBrowser(userAgent, "Windows", "CE", null);
         }

      }else if(userAgent.indexOf("Mac OS X") > 0){

         if(userAgent.indexOf("iPad") > 0 && userAgent.indexOf("mac") > 0){
            return judgeBrowser(userAgent, "iPad", null, null);

         }else if(userAgent.indexOf("iPhone") > 0 && userAgent.indexOf("mac") > 0){

            return judgeBrowser(userAgent, "iPhone", null, null);
         }else if(userAgent.indexOf("android") > 0 && userAgent.indexOf("") > 0){

            return judgeBrowser(userAgent, "android", null, null);

         }
      }
      return judgeBrowser(userAgent, "其他", null, null);//判断浏览器

   }

   //   //根据指定的格式给定指定的正则表达式
   //   public boolean regex(String regex,String str){  
   //       Pattern p =Pattern.compile(regex,Pattern.MULTILINE);  
   //        Matcher m=p.matcher(str);  
   //        return m.find(); 
   //      
   //        
   //   }

   /**
    * 用途：根据客户端 User Agent Strings 判断其浏览器
    * if 判断的先后次序：
    * 根据浏览器的用户使用量降序排列，这样对于大多数用户来说可以少判断几次即可拿到结果：
    * 	>>Browser:Chrome > FF > IE > ...
    * @param userAgent:user agent
    * @param platformType:平台
    * @param platformSeries:系列
    * @param platformVersion:版本
    * @return
    */
   private static UserAgent judgeBrowser(String userAgent,
                                         String platformType,
                                         String platformSeries,
                                         String platformVersion){
      if(userAgent.indexOf("Chrome") > 0){
         /**
          * ***********
          * Chrome 系列
          * ***********
          * Chrome 24.0.1295.0	-	Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.15 (KHTML, like Gecko) Chrome/24.0.1295.0 Safari/537.15
          * Chrome 24.0.1292.0	-	Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.14 (KHTML, like Gecko) Chrome/24.0.1292.0 Safari/537.14
          * Chrome 24.0.1290.1	-	Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_2) AppleWebKit/537.13 (KHTML, like Gecko) Chrome/24.0.1290.1 Safari/537.13
          * 判断依据:http://www.useragentstring.com/pages/Chrome/
          */
         String temp = userAgent.substring(userAgent.indexOf("Chrome/") + 7);//拿到User Agent String "Chrome/" 之后的字符串,结果形如"24.0.1295.0 Safari/537.15"或"24.0.1295.0"
         String chromeVersion = null;
         if(temp.indexOf(" ") < 0){//temp形如"24.0.1295.0"
            chromeVersion = temp;
         }else{//temp形如"24.0.1295.0 Safari/537.15"
            chromeVersion = temp.substring(0, temp.indexOf(" "));
         }
         return new UserAgent("Chrome", chromeVersion, platformType, platformSeries, platformVersion);
      }else if(userAgent.contains("Firefox")){
         /**
          * *******
          * FF 系列
          * *******
          * Firefox 16.0.1	-	Mozilla/5.0 (Windows NT 6.2; Win64; x64; rv:16.0.1) Gecko/20121011 Firefox/16.0.1
          * Firefox 15.0a2	-	Mozilla/5.0 (Windows NT 6.1; rv:15.0) Gecko/20120716 Firefox/15.0a2
          * Firefox 15.0.2	-	Mozilla/5.0 (Windows NT 6.2; WOW64; rv:15.0) Gecko/20120910144328 Firefox/15.0.2
          * 判断依据:http://www.useragentstring.com/pages/Firefox/
          */
         String temp = userAgent.substring(userAgent.indexOf("Firefox/") + 8);//拿到User Agent String "Firefox/" 之后的字符串,结果形如"16.0.1 Gecko/20121011"或"16.0.1"
         String ffVersion = null;
         if(temp.indexOf(" ") < 0){//temp形如"16.0.1"
            ffVersion = temp;
         }else{//temp形如"16.0.1 Gecko/20121011"
            ffVersion = temp.substring(0, temp.indexOf(" "));
         }
         return new UserAgent("Firefox", ffVersion, platformType, platformSeries, platformVersion);
      }else if(userAgent.contains("MSIE")){

         /**
          * IE系列对UserAgent的判断
           IE8
         Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.2; Trident/4.0; .NET CLR 1.1.4322; .NET CLR 2.0.50727; .NET4.0E; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729; .NET4.0C)
         IE7
         Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.2; .NET CLR 1.1.4322; .NET CLR 2.0.50727; .NET4.0E; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729; .NET4.0C)
         
         IE6
         Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 2.0.50727) 
         
         IE9
         Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C; .NET4.0E)
         
            */
         if(userAgent.indexOf("MSIE 9.0") > 0){//Internet Explorer 10
            return new UserAgent("Internet Explorer 9", null, platformType, platformSeries, platformVersion);
         }else if(userAgent.indexOf("MSIE 8.0") > 0){//Internet Explorer 9
            return new UserAgent("Internet Explorer 8", null, platformType, platformSeries, platformVersion);
         }else if(userAgent.indexOf("MSIE 7.0") > 0){//Internet Explorer 8
            return new UserAgent("Internet Explorer 7", null, platformType, platformSeries, platformVersion);
         }else if(userAgent.indexOf("MSIE 6.0") > 0){//Internet Explorer 7
            return new UserAgent("Internet Explorer 6", null, platformType, platformSeries, platformVersion);
         }
      }else if(userAgent.contains("Safari")){

         /**
          * Safari系列对UserAgent的判断
          * Mozilla/5.0 (Windows; U; Windows NT 5.2) AppleWebKit/525.13 (KHTML, like Gecko) Version/3.1 Safari/525.13

          */

      }
      if(userAgent.indexOf("Safari") > 0){
         String temp = userAgent.substring(userAgent.indexOf("Safari/") + 7);
         String chromeVersion = null;
         if(temp.indexOf(" ") < 0){//temp形如"24.0.1295.0"
            chromeVersion = temp;
         }else{//temp形如"24.0.1295.0 Safari/537.15"
            chromeVersion = temp.substring(0, temp.indexOf(" "));
         }
         return new UserAgent("Safari", chromeVersion, platformType, platformSeries, platformVersion);
      }else if(userAgent.contains("Opera")){

         /**
          * Opera系列对UserAgent的判断
          * 
          */
         String temp = userAgent.substring(userAgent.indexOf("Opera/") + 6);
         String chromeVersion = null;
         if(temp.indexOf(" ") < 0){//temp形如"24.0.1295.0"
            chromeVersion = temp;
         }else{//temp形如"24.0.1295.0 Safari/537.15"
            chromeVersion = temp.substring(0, temp.indexOf(" "));
         }
         return new UserAgent("Opera", chromeVersion, platformType, platformSeries, platformVersion);

      }else if(userAgent.contains("360SE")){

         /**
          * User-Agent: Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; 360SE)
          * User-Agent: Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; InfoPath.2; .NET4.0C; .NET4.0E; .NET CLR 2.0.50727; 360SE
          */
      }
      if(userAgent.indexOf("360SE") > 0){

         return new UserAgent("360SE", null, platformType, platformSeries, platformVersion);
      }else if(userAgent.contains("Maxthon")){

         /**
          *遨游游览器
          * User-Agent: Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Maxthon 2.0)
          * 
          * <---Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Maxthon/4.0 Chrome/30.0.1599.101 Safari/537.36--->
          */
         if(userAgent.indexOf("Maxthon") > 0){

            return new UserAgent("Maxthon", null, platformType, platformSeries, platformVersion);
         }else if(userAgent.contains("QQBrowser")){

            if(userAgent.indexOf("QQBrowser") > 0){

               return new UserAgent("QQBrowser", null, platformType, platformSeries, platformVersion);
            }else if(userAgent.contains("BIDUBrowser")){

               if(userAgent.indexOf("BIDUBrowser") > 0){

                  return new UserAgent("BIDUBrowser", null, platformType, platformSeries, platformVersion);

               }else if(userAgent.contains("MetaSr"))

                  if(userAgent.indexOf("MetaSr") > 0){

                     /**
                      * Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US) AppleWebKit/534.3 (KHTML, like Gecko) Chrome/6.0.472.33 Safari/534.3 SE 2.X MetaSr 1.0
                     */

                     return new UserAgent("MetaSr", null, platformType, platformSeries, platformVersion);
                  }else if(userAgent.indexOf("iphone") > 0 && userAgent.indexOf("safari") > 0){
                     String temp = userAgent.substring(userAgent.indexOf("Safari/") + 7);
                     @SuppressWarnings("unused") String chromeVersion = null;
                     if(temp.indexOf(" ") < 0){
                        chromeVersion = temp;
                     }else{
                        chromeVersion = temp.substring(0, temp.indexOf(" "));
                     }

                     return new UserAgent("Safari", null, platformType, platformSeries, platformVersion);
                  }else if(userAgent.indexOf("iphone") > 0 && userAgent.indexOf("opera") > 0){

                     String temp = userAgent.substring(userAgent.indexOf("opera/") + 6);
                     @SuppressWarnings("unused") String chromeVersion = null;
                     if(temp.indexOf(" ") < 0){
                        chromeVersion = temp;
                     }else{
                        chromeVersion = temp.substring(0, temp.indexOf(" "));
                     }

                     return new UserAgent("iphone", null, platformType, platformSeries, platformVersion);

                  }
               if(userAgent.indexOf("android") > 0 && userAgent.indexOf("Linux") > 0){

                  return new UserAgent("android", null, platformType, platformSeries, platformVersion);

                  /***
                   * 
                   * opera/","android","linux","opera mobi/","presto/"
                   */

               }else if(userAgent.indexOf("android") > 0 && userAgent.indexOf("opera") > 0 && userAgent.indexOf("Linux") > 0 && userAgent.indexOf("opera mobi") > 0 && userAgent.indexOf("presto") > 0){

                  String temp = userAgent.substring((userAgent.indexOf("opera/") + 6) + (userAgent.indexOf("opera mobi/") + 11) + (userAgent.indexOf("presto/") + 6));
                  @SuppressWarnings("unused") String chromeVersion = null;
                  if(temp.indexOf(" ") < 0){
                     chromeVersion = temp;
                  }else{
                     chromeVersion = temp.substring(0, temp.indexOf(" "));
                  }

                  return new UserAgent("opera", null, platformType, platformSeries, platformVersion);

               }else if(userAgent.indexOf("android") > 0 && userAgent.indexOf("firefox") > 0){

                  String temp = userAgent.substring(userAgent.indexOf("firefox/") + 7);
                  @SuppressWarnings("unused") String chromeVersion = null;
                  if(temp.indexOf(" ") < 0){
                     chromeVersion = temp;
                  }else{
                     chromeVersion = temp.substring(0, temp.indexOf(" "));
                  }

                  return new UserAgent("firefox", null, platformType, platformSeries, platformVersion);
               }else if(userAgent.indexOf("iPad") > 0 && userAgent.indexOf("Safari") > 0){

                  //Mozilla/5.0 (iPad; U; CPU OS 3_2 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Version/4.0.4 Mobile/7B334b Safari/531.21.10

                  String temp = userAgent.substring(userAgent.indexOf("Safari/") + 7);
                  @SuppressWarnings("unused") String chromeVersion = null;
                  if(temp.indexOf(" ") < 0){
                     chromeVersion = temp;
                  }else{
                     chromeVersion = temp.substring(0, temp.indexOf(" "));
                  }

                  return new UserAgent("Safari", null, platformType, platformSeries, platformVersion);

               }

            }
         }
      }
      return new UserAgent("其他", null, platformType, platformSeries, platformVersion);
   }

   public static void main(String[] args){
      String ss = "A1\t20150916235959\t113.73.242.143\t911537\tPOST /home/index/hasborrow HTTP/1.0\thttp://www.ezubo.com/index.html\tMozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chromefds/42.0.2311.135 BIDUBrowser/7.6 Safari/537.36";
      String[] arr = ss.split("\\t");
      String a1 = arr[6];
      /**
       * {"message":"A1
         20150916235959
         113.107.24.190
         0
         POST /member/common/newSendPhone/ HTTP/1.0
         https://www.ezubo.com/member/common/register/?invite=ZXpiMDAxMjE%3D&security=a95793bafe41924a8d4a4946671deee1
         Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1)","@timestamp":"2015-09-17T00:00:00.679+08:00","type":"applogs","host":"web8","path":"/data/web/diandiantou/applogs/wisdomCenter/2015-09-16-wisdom.log","dirlogname":"wisdomCenter","year":"2015","month":"09","day":"16","sublogname":"wisdom","client_ip":"10.165.53.99","rootdir":"pc","@version":"1"}

         911537   113.73.242.143 20150916235959 http://www.ezubo.com/index.html

       */
      System.out.println(UserAgentUtil.getUserAgent(a1).getBrowserType() + "\t" + getUserAgent(a1).getPlatformType());
   }
}
