package org.mo.eai.logic.session;

import org.mo.cloud.core.web.FGcWebSession;
import org.mo.cloud.logic.person.FGcUserInfo;
import org.mo.cloud.logic.system.FGcSessionInfo;

//============================================================
// <T>会话信息。</T>
//============================================================
public class FEaiSession
      extends FGcWebSession
{
   // 序列化编号
   private static final long serialVersionUID = 1L;

   // 记录编号
   protected long _recordId;

   // 用户编号
   protected long _userId;

   // 用户信息
   protected FGcUserInfo _userInfo;

   // 会话信息
   protected FGcSessionInfo _sessionInfo;

   //============================================================
   // <T>记录编号。</T>
   //
   // @return 记录编号
   //============================================================
   @Override
   public long recordId(){
      return _recordId;
   }

   //============================================================
   // <T>获得用户编号。</T>
   //
   // @return 用户编号
   //============================================================
   @Override
   public long userId(){
      return _userId;
   }

   //============================================================
   // <T>设置用户编号。</T>
   //
   // @param userId 用户编号
   //============================================================
   @Override
   public void setUserId(long userId){
      _userId = userId;
   }

   //============================================================
   // <T>获得会话信息。</T>
   //
   // @return 会话信息
   //============================================================
   @Override
   public FGcSessionInfo sessionInfo(){
      return _sessionInfo;
   }

   //============================================================
   // <T>获得用户信息。</T>
   //
   // @return 用户信息
   //============================================================
   @Override
   public FGcUserInfo userInfo(){
      return _userInfo;
   }

   //============================================================
   // <T>加载数据单元信息。</T>
   //
   // @param unit 数据单元
   //============================================================
   @Override
   public void loadInfo(FGcSessionInfo info){
      // 加载信息
      _recordId = info.ouid();
      _id = info.sessionCode();
      _userId = info.userId();
      // 设置会话
      _sessionInfo = info;
   }
}