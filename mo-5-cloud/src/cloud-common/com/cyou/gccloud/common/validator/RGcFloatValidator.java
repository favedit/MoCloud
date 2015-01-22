package com.cyou.gccloud.common.validator;

import org.mo.com.lang.RBoolean;
import org.mo.com.lang.RFloat;
import org.mo.com.lang.RString;
import org.mo.com.message.IMessageContext;
import org.mo.com.resource.IResource;
import org.mo.com.resource.RResource;

//============================================================
// <T>浮点数校验器。</T>
//============================================================
public class RGcFloatValidator
{
   // 资源访问接口
   private static IResource _resource = RResource.find(RGcFloatValidator.class);

   // 标签内容小于
   public final static String TagValidValueMin = "valid.value.min";

   // 标签内容小于等于
   public final static String TagValidValueMinEq = "valid.value.min.eq";

   // 标签内容大于
   public final static String TagValidValueMax = "valid.value.max";

   // 标签内容大于等于
   public final static String TagValidValueMaxEq = "valid.value.max.eq";

   // 标签内容格式
   public final static String TagValidFormat = "valid.format";

   // 属性代码
   public final static String PtyCode = "code";

   // 属性最小
   public final static String PtyMin = "min";

   // 属性最大
   public final static String PtyMax = "max";

   //============================================================
   // <T>检查数据内容。</T>
   //
   // @param context 消息环境
   // @param valueMin 长度最小
   // @param valueMinEq 长度最小包含
   // @param valueMax 长度最大
   // @param valueMaxEq 长度最大包含
   // @param value 检查内容
   // @param name 显示名称
   // @param label 显示内容
   //============================================================
   public static void checkValue(IMessageContext context,
                                 String valueMin,
                                 String valueMinEq,
                                 String valueMax,
                                 String valueMaxEq,
                                 String value,
                                 String name,
                                 String label){
      // 获得内容
      float valueInteger = RFloat.parse(value);
      //............................................................
      String text = null;
      String code = null;
      String length = null;
      //............................................................
      // 检查最小长度
      if(RString.isNotEmpty(valueMin)){
         float min = RFloat.parse(valueMin);
         if(RBoolean.parse(valueMinEq)){
            if(valueInteger <= min){
               text = _resource.findDisplay(TagValidValueMinEq);
               code = _resource.findConfigAttribute(TagValidValueMinEq, PtyCode);
               length = valueMin;
            }
         }else{
            if(valueInteger < min){
               text = _resource.findDisplay(TagValidValueMin);
               code = _resource.findConfigAttribute(TagValidValueMin, PtyCode);
               length = valueMin;
            }
         }
      }
      //............................................................
      // 检查最大长度
      if(RString.isNotEmpty(valueMax)){
         float max = RFloat.parse(valueMax);
         if(RBoolean.parse(valueMaxEq)){
            if(valueInteger >= max){
               text = _resource.findDisplay(TagValidValueMaxEq);
               code = _resource.findConfigAttribute(TagValidValueMaxEq, PtyCode);
               length = valueMax;
            }
         }else{
            if(valueInteger > max){
               text = _resource.findDisplay(TagValidValueMax);
               code = _resource.findConfigAttribute(TagValidValueMax, PtyCode);
               length = valueMax;
            }
         }
      }
      //............................................................
      // 创建消息
      if(text != null){
         FGcValidMessage message = new FGcValidMessage(code, text, label, length);
         message.setValues(name, valueMin);
         context.messages().push(message);
         throw new FGcValidError();
      }
   }

   //============================================================
   // <T>检查格式。</T>
   //
   // @param context 消息环境
   // @param value 检查内容
   // @param name 显示名称
   // @param label 显示内容
   //============================================================
   public static void checkFormat(IMessageContext context,
                                  String value,
                                  String name,
                                  String label){
      if(!RString.isPartten(value, "n+-.")){
         String text = _resource.findDisplay(TagValidFormat);
         String code = _resource.findConfigAttribute(TagValidFormat, PtyCode);
         // 创建消息
         FGcValidMessage message = new FGcValidMessage(code, text, label);
         message.setValues(name);
         context.messages().push(message);
         // 检查例外
         throw new FGcValidError();
      }
   }
}
