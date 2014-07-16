//============================================================
// <T>游戏场景消息定义。</T>
//
// @enum
//============================================================
package com.cyou.gccloud.service.define.message;

import org.mo.com.xml.*;
import com.cyou.gccloud.service.common.message.*;


//============================================================
public class FNetMessageProvider implements INetMessageProvider
{
   //============================================================
   // <T>根据消息代码号，获得消息对象。</T>
   //
   // @param code 消息代码
   // @return 消息对象
   //============================================================
   public FNetMessage message(int code){
      int group = code & 0xFF00;
      switch(group){
      }
      return null;
   }
}
