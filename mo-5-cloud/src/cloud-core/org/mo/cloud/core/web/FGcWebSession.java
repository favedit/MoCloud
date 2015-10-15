package org.mo.cloud.core.web;

import org.mo.cloud.logic.data.person.FGcUserInfo;
import org.mo.cloud.logic.data.system.FGcSessionInfo;
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

   // 用户标签
   protected String _userLabel;

   // 用户信息
   protected FGcUserInfo _userInfo;

   // 会话信息
   protected FGcSessionInfo _sessionInfo;

   // 用户登录x坐标
   protected double _locationLongitude;

   // 用户登录y坐标
   protected double _locationLatitude;

   // 应用id
   protected long _applicationId;

   //逻辑码
   protected String _logicCode;

   //
   //============================================================
   // <T>登录逻辑码</T>
   //
   // @return 登录逻辑码
   //============================================================
   public String logicCode(){
      return _logicCode;
   }

   public void setLogicCode(String _logicCode){
      this._logicCode = _logicCode;
   }

   //
   //============================================================
   // <T>登录应用id</T>
   //
   // @return 登录x坐标
   //============================================================
   public long applicationId(){
      return _applicationId;
   }

   public void setApplicationId(long _applicationId){
      this._applicationId = _applicationId;
   }

   //
   //============================================================
   // <T>登录x坐标。</T>
   //
   // @return 登录x坐标
   //============================================================
   public double locationLongitude(){
      return _locationLongitude;
   }

   //============================================================
   // <T>登录x坐标。</T>
   //
   // @return 登录x坐标
   //============================================================
   public void setLocationLongitude(double _locationLongitude){
      this._locationLongitude = _locationLongitude;
   }

   //============================================================
   // <T>登录y坐标。</T>
   //
   // @return 登录y坐标
   //============================================================
   public double locationLatitude(){
      return _locationLatitude;
   }

   //============================================================
   // <T>登录y坐标。</T>
   //
   // @return 登录y坐标
   //============================================================
   public void setLocationLatitude(double _locationLatitude){
      this._locationLatitude = _locationLatitude;
   }

   //============================================================
   // <T>记录编号。</T>
   //
   // @return 记录编号
   //============================================================
   public long recordId(){
      return _recordId;
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
   // <T>获得用户标签。</T>
   //
   // @return 用户标签
   //============================================================
   public String userLabel(){
      return _userLabel;
   }

   //============================================================
   // <T>设置用户标签。</T>
   //
   // @param userLabel 用户标签
   //============================================================
   public void setUserLabel(String userLabel){
      _userLabel = userLabel;
   }

   //============================================================
   // <T>获得会话信息。</T>
   //
   // @return 会话信息
   //============================================================
   public FGcSessionInfo sessionInfo(){
      return _sessionInfo;
   }

   //============================================================
   // <T>获得用户信息。</T>
   //
   // @return 用户信息
   //============================================================
   public FGcUserInfo userInfo(){
      return _userInfo;
   }

   //============================================================
   // <T>加载会话数据。</T>
   //
   // @param info 会话数据
   //============================================================
   public void loadInfo(FGcSessionInfo info){
      // 加载信息
      _recordId = info.ouid();
      _id = info.sessionCode();
      _fromCode = info.fromCode();
      _userId = info.userId();
      _userLabel = info.userLabel();
      _locationLongitude = info.locationLongitude();
      _locationLatitude = info.locationLatitude();
      _applicationId = info.applicationId();
      // 设置会话
      _sessionInfo = info;
   }

   //============================================================
   // <T>保存会话数据。</T>
   //
   // @param info 会话数据
   //============================================================
   public void saveInfo(FGcSessionInfo info){
      // 保存信息
      info.setFromCode(_fromCode);
      info.setUserId(_userId);
      info.setUserLabel(_userLabel);
      info.setApplicationId(_applicationId);
   }
}
