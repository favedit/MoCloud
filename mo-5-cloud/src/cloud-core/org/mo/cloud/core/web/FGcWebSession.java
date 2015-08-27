package org.mo.cloud.core.web;

import com.cyou.gccloud.data.cache.FCacheSystemSessionUnit;
import org.mo.web.core.session.FWebSession;

//============================================================
// <T>会话信息。</T>
//============================================================
public class FGcWebSession
      extends FWebSession
{
   // 序列化编号
   private static final long serialVersionUID = 1L;

   // 记录编号
   protected long _recordId;

   // 用户编号
   protected long _userId;

   //============================================================
   // <T>记录编号。</T>
   //
   // @return 记录编号
   //============================================================
   public long recordId(){
      return _userId;
   }

   //============================================================
   // <T>获得用户编号。</T>
   //
   // @return 用户编号
   //============================================================
   public long userId(){
      return _userId;
   }

   //============================================================
   // <T>设置用户编号。</T>
   //
   // @param userId 用户编号
   //============================================================
   public void setUserId(long userId){
      _userId = userId;
   }

   //============================================================
   // <T>加载数据单元信息。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void loadUnit(FCacheSystemSessionUnit unit){
      _recordId = unit.ouid();
      _id = unit.sessionCode();
      _userId = unit.userId();
   }
}
