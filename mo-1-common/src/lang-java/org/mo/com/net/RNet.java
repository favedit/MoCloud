package org.mo.com.net;

import java.net.InetAddress;
import org.mo.com.lang.FFatalError;

//============================================================
// <T>网络工具。</T>
//============================================================
public class RNet
{
   //============================================================
   // <T>获得主机名称。</T>
   //
   // @return 主机名称
   //============================================================
   public static String hostName(){
      try{
         InetAddress address = InetAddress.getLocalHost();
         return address.getHostName();
      }catch(Exception exception){
         throw new FFatalError(exception);
      }
   }
}
