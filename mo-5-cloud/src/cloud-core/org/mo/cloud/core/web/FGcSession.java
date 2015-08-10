package org.mo.cloud.core.web;

import com.cyou.gccloud.data.cache.FCacheSystemSessionUnit;
import org.mo.web.core.session.FWebSession;

//============================================================
// <T>会话信息。</T>
//============================================================
public class FGcSession
      extends FWebSession
{
   // 序列化编号
   private static final long serialVersionUID = 1L;

   // 记录编号
   protected long _recordId;

   // 唯一编号
   protected String _guid;

   //============================================================
   // <T>加载数据单元信息。</T>
   //============================================================
   public void loadUnit(FCacheSystemSessionUnit unit){
      _recordId = unit.ouid();
      _id = unit.guid();
      _guid = unit.guid();
   }
}
