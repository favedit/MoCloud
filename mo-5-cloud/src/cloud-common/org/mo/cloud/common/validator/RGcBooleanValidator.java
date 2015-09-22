package org.mo.cloud.common.validator;

import org.mo.com.lang.RString;
import org.mo.com.message.IMessageContext;
import org.mo.com.resource.IResource;
import org.mo.com.resource.RResource;

//============================================================
// <T>整数校验器。</T>
//============================================================
public class RGcBooleanValidator
{
   // 资源访问接口
   private static IResource _resource = RResource.find(RGcBooleanValidator.class);

   // 标签内容格式
   public final static String TagValidFormat = "valid.format";

   // 属性代码
   public final static String PtyCode = "code";

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
      if(!RString.isPartten(value, "yYnN")){
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
