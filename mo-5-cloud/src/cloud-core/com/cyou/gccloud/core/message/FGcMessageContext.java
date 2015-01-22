package com.cyou.gccloud.core.message;

import com.cyou.gccloud.common.validator.RGcBooleanValidator;
import com.cyou.gccloud.common.validator.RGcDoubleValidator;
import com.cyou.gccloud.common.validator.RGcFloatValidator;
import com.cyou.gccloud.common.validator.RGcIntegerValidator;
import com.cyou.gccloud.common.validator.RGcLongValidator;
import com.cyou.gccloud.common.validator.RGcStringValidator;
import org.mo.com.lang.RBoolean;
import org.mo.com.lang.RString;
import org.mo.com.message.FMessageContext;
import org.mo.com.resource.IResource;
import org.mo.com.xml.FXmlNode;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>消息环境。</T>
//============================================================
public class FGcMessageContext
      extends FMessageContext
{
   // 关联环境
   protected IWebContext _context;

   // 关联资源
   protected IResource _resource;

   //============================================================
   // <T>构造消息环境。</T>
   //============================================================
   public FGcMessageContext(){
   }

   //============================================================
   // <T>构造消息环境。</T>
   //
   // @param context 网络环境
   // @param resource 关联资源
   //============================================================
   public FGcMessageContext(IWebContext context,
                            IResource resource){
      _context = context;
      _messages = context.messages();
      _resource = resource;
   }

   //============================================================
   // <T>校验空处理。</T>
   //============================================================
   public void validCheck(FXmlNode xconfig,
                          String name,
                          String value,
                          String label){
      // 获得内容
      String type = xconfig.get("type");
      // 检查处理
      switch(type){
      // Boolean
         case "boolean.format":{
            RGcBooleanValidator.checkFormat(_context, value, name, label);
            break;
         }
         // Integer
         case "integer.value":{
            String min = xconfig.get("min", null);
            String minEq = xconfig.get("min_eq", RBoolean.FALSE_STR);
            String max = xconfig.get("max", null);
            String maxEq = xconfig.get("max_eq", RBoolean.FALSE_STR);
            RGcIntegerValidator.checkValue(_context, min, minEq, max, maxEq, value, name, label);
            break;
         }
         case "integer.format":{
            RGcIntegerValidator.checkFormat(_context, value, name, label);
            break;
         }
         // Long
         case "long.value":{
            String min = xconfig.get("min", null);
            String minEq = xconfig.get("min_eq", RBoolean.FALSE_STR);
            String max = xconfig.get("max", null);
            String maxEq = xconfig.get("max_eq", RBoolean.FALSE_STR);
            RGcLongValidator.checkValue(_context, min, minEq, max, maxEq, value, name, label);
            break;
         }
         case "long.format":{
            RGcLongValidator.checkFormat(_context, value, name, label);
            break;
         }
         // Float
         case "float.value":{
            String min = xconfig.get("min", null);
            String minEq = xconfig.get("min_eq", RBoolean.FALSE_STR);
            String max = xconfig.get("max", null);
            String maxEq = xconfig.get("max_eq", RBoolean.FALSE_STR);
            RGcFloatValidator.checkValue(_context, min, minEq, max, maxEq, value, name, label);
            break;
         }
         case "float.format":{
            RGcFloatValidator.checkFormat(_context, value, name, label);
            break;
         }
         // Double
         case "double.value":{
            String min = xconfig.get("min", null);
            String minEq = xconfig.get("min_eq", RBoolean.FALSE_STR);
            String max = xconfig.get("max", null);
            String maxEq = xconfig.get("max_eq", RBoolean.FALSE_STR);
            RGcDoubleValidator.checkValue(_context, min, minEq, max, maxEq, value, name, label);
            break;
         }
         case "double.format":{
            RGcDoubleValidator.checkFormat(_context, value, name, label);
            break;
         }
         // String
         case "string.not.empty":{
            RGcStringValidator.checkEmpty(_context, value, name, label);
            break;
         }
         case "string.length":{
            String min = xconfig.get("min", null);
            String minEq = xconfig.get("min_eq", RBoolean.FALSE_STR);
            String max = xconfig.get("max", null);
            String maxEq = xconfig.get("max_eq", RBoolean.FALSE_STR);
            RGcStringValidator.checkLength(_context, min, minEq, max, maxEq, value, name, label);
            break;
         }
         case "string.format":{
            String format = xconfig.get("format", null);
            RGcStringValidator.checkFormat(_context, format, value, name, label);
            break;
         }
         case "string.format.email":{
            RGcStringValidator.checkFormatEmail(_context, value, name, label);
            break;
         }
         case "string.format.phone":{
            RGcStringValidator.checkFormatPhone(_context, value, name, label);
            break;
         }
         case "string.format.mobile":{
            RGcStringValidator.checkFormatMobile(_context, value, name, label);
            break;
         }
         case "string.format.passport":{
            RGcStringValidator.checkFormatPassport(_context, value, name, label);
            break;
         }
      }
   }

   //============================================================
   // <T>校验空处理。</T>
   //
   // @param xinput 输入信息
   // @param xconfig 配置信息
   //============================================================
   public void validConfig(FXmlNode xinput,
                           FXmlNode xconfig){
      // 处理所有节点
      for(FXmlNode xvalidation : xconfig.nodes()){
         if(xvalidation.isName("Validation")){
            // 获得校验节点
            FXmlNode xvalidationConfig = null;
            String refer = xvalidation.get("refer");
            if(RString.isNotEmpty(refer)){
               FXmlNode xvalidationResource = _resource.findConfig(refer);
               xvalidationConfig = xvalidationResource.nodes().first();
            }else{
               xvalidationConfig = xvalidation;
            }
            // 获得属性
            String name = xvalidationConfig.get("name");
            String label = xvalidationConfig.get("label");
            String value = xinput.nodeText(name);
            // 检查处理
            for(FXmlNode xcheck : xvalidationConfig.nodes()){
               if(xcheck.isName("Check")){
                  validCheck(xcheck, name, value, label);
               }
            }
         }
      }
   }
}
