//============================================================
// <T>逻辑共通消息定义。</T>
//
// @version 1.0
// @auto 代码器管理的代码，如需修改请在手动修改标出的地方修改。
//============================================================
package com.cyou.gccloud.define.message.logiccommon;

import com.cyou.gccloud.common.FNetObjects;
import com.cyou.gccloud.common.INetObject;
import com.cyou.gccloud.common.message.ENetMessageGroup;
import com.cyou.gccloud.common.message.ENetMessageType;
import com.cyou.gccloud.common.message.FNetMessage;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>学校列表应答消息。</T>
//============================================================
public class FLgcSchoolListResponse
      extends FNetMessage
      implements
         INetObject
{
   // 名称
   public final static String NAME = "LgcSchoolListResponse";

   // 类型
   public final static int TYPE = ENetMessageType.Response;

   // 代码
   public final static int CODE = ENetMessageGroup.LogicCommon + 0x0002;

   // 版本
   public final static int VERSION = 0x40E3C204;

   //============================================================
   // <T>学校信息定义。</T>
   //============================================================
   public final static class SSchoolInfo
         implements
            INetObject
   {
      // 代码
      public final static String CODE = "School";

      // 编号
      protected long _id;

      // 标签
      protected String _label;

      //============================================================
      // <T>构造学校信息定义。</T>
      //============================================================
      public SSchoolInfo(){
      }

      //============================================================
      // <T>获得编号。</T>
      //
      // @return 个数
      //============================================================
      public long id(){
         return _id;
      }

      //============================================================
      // <T>设置编号。</T>
      //
      // @param value 内容
      // @return 对象
      //============================================================
      public void setId(long value){
         _id = value;
      }

      //============================================================
      // <T>获得标签。</T>
      //
      // @return 个数
      //============================================================
      public String label(){
         return _label;
      }

      //============================================================
      // <T>设置标签。</T>
      //
      // @param value 内容
      // @return 对象
      //============================================================
      public void setLabel(String value){
         _label = value;
      }

      //============================================================
      // <T>从配置节点中读取数据。</T>
      //
      // @param xconfig 配置节点
      //============================================================
      public void loadConfig(FXmlNode xconfig){
         _id = xconfig.getLong("id");
         _label = xconfig.get("label");
      }

      //============================================================
      // <T>保存数据到配置节点中。</T>
      //
      // @param xconfig 配置节点
      //============================================================
      public void saveConfig(FXmlNode xconfig){
         xconfig.set("id", _id);
         xconfig.set("label", _label);
      }

      //============================================================
      // <T>重置内容。</T>
      //============================================================
      public void reset(){
         _id = 0;
         _label = null;
      }
   }

   // 结果类型
   protected String _resultCd;

   // 学校列表
   protected FNetObjects<SSchoolInfo> _schools = new FNetObjects<SSchoolInfo>(SSchoolInfo.class, SSchoolInfo.CODE);

   //============================================================
   // <T>构造消息的实例对象。</T>
   //
   // @return 实例对象
   //============================================================
   public FLgcSchoolListResponse(){
      _head.name = NAME;
      _head.type = TYPE;
      _head.code = CODE;
      _head.version = VERSION;
   }

   //============================================================
   // <T>构造消息的实例对象。</T>
   //
   // @param xconfig 配置节点
   // @return 实例对象
   //============================================================
   public FLgcSchoolListResponse(FXmlNode xconfig){
      this();
      loadConfig(xconfig);
   }

   //============================================================
   // <T>获得结果类型。</T>
   //
   // @return 结果类型
   //============================================================
   public String resultCd(){
      return _resultCd;
   }

   //============================================================
   // <T>设置结果类型。</T>
   //
   // @param resultCd 结果类型
   //============================================================
   public void setResultCd(String resultCd){
      _resultCd = resultCd;
   }

   //============================================================
   // <T>获得学校列表。</T>
   //
   // @return 学校列表
   //============================================================
   public FNetObjects<SSchoolInfo> schools(){
      return _schools;
   }

   //============================================================
   // <T>从配置节点中读取数据。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void loadConfig(FXmlNode xconfig){
      _resultCd = xconfig.get("result_cd");
      _schools.loadConfig(xconfig);
   }

   //============================================================
   // <T>保存数据到配置节点中。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void saveConfig(FXmlNode xconfig){
      xconfig.set("result_cd", _resultCd);
      _schools.saveConfig(xconfig);
   }

   //============================================================
   // <T>重置内容。</T>
   //============================================================
   @Override
   public void reset(){
      super.reset();
      _resultCd = null;
      _schools.reset();
   }
}
