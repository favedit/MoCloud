package org.mo.cloud.common.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.mo.com.lang.RBoolean;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;
import org.mo.com.message.IMessageContext;
import org.mo.com.resource.IResource;
import org.mo.com.resource.RResource;

//============================================================
// <T>字符串校验器。</T>
//============================================================
public class RGcStringValidator
{
   // 资源访问接口
   private static IResource _resource = RResource.find(RGcStringValidator.class);

   // 标签检查空
   public final static String TagValidEmpry = "valid.string.empty";

   // 标签长度小于
   public final static String TagValidLengthMin = "valid.string.length.min";

   // 标签长度小于等于
   public final static String TagValidLengthMinEq = "valid.string.length.min.eq";

   // 标签长度大于
   public final static String TagValidLengthMax = "valid.string.length.max";

   // 标签长度大于等于
   public final static String TagValidLengthMaxEq = "valid.string.length.max.eq";

   // 标签格式
   public final static String TagValidFormat = "valid.string.format";

   // 标签格式邮箱
   public final static String TagValidFormatEmail = "valid.string.format.email";

   // 标签格式电话
   public final static String TagValidFormatPhone = "valid.string.format.phone";

   // 标签格式手机
   public final static String TagValidFormatMobile = "valid.string.format.mobile";

   // 标签格式帐号
   public final static String TagValidFormatPassport = "valid.string.format.passport";

   // 属性代码
   public final static String PtyCode = "code";

   // 属性最小
   public final static String PtyMin = "min";

   // 属性最大
   public final static String PtyMax = "max";

   static final public Pattern PatternMobile = Pattern.compile("^((\\+86)|(86))?(1[3|5|8|7])\\d{9}$");

   //static final private Pattern PartternEmail = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+ ([-.]\\w+)*");

   static final public Pattern PartternAccount = Pattern.compile("^[a-z|A-Z]+[0-9|a-z|A-Z|_|\\-|\\.]*");

   //============================================================
   // <T>检查空字符串。</T>
   //
   // @param context 消息环境
   // @param value 检查内容
   // @param name 显示名称
   // @param label 显示内容
   //============================================================
   public static void checkEmpty(IMessageContext context,
                                 String value,
                                 String name,
                                 String label){
      if(RString.isBlank(value)){
         String text = _resource.findDisplay(TagValidEmpry);
         String code = _resource.findConfigAttribute(TagValidEmpry, PtyCode);
         // 创建消息
         FGcValidMessage message = new FGcValidMessage(code, text, label);
         message.setValues(name);
         context.messages().push(message);
         // 检查例外
         throw new FGcValidError();
      }
   }

   //============================================================
   // <T>检查字符串长度。</T>
   //
   // @param context 消息环境
   // @param lengthMin 长度最小
   // @param lengthMinEq 长度最小包含
   // @param lengthMax 长度最大
   // @param lengthMaxEq 长度最大包含
   // @param value 检查内容
   // @param name 显示名称
   // @param label 显示内容
   //============================================================
   public static void checkLength(IMessageContext context,
                                  String lengthMin,
                                  String lengthMinEq,
                                  String lengthMax,
                                  String lengthMaxEq,
                                  String value,
                                  String name,
                                  String label){
      // 获得长度
      int valueLength = 0;
      if(value != null){
         valueLength = value.length();
      }
      //............................................................
      String text = null;
      String code = null;
      String length = null;
      //............................................................
      // 检查最小长度
      if(RString.isNotEmpty(lengthMin)){
         int min = RInteger.parse(lengthMin);
         if(RBoolean.parse(lengthMinEq)){
            if(valueLength <= min){
               text = _resource.findDisplay(TagValidLengthMinEq);
               code = _resource.findConfigAttribute(TagValidLengthMinEq, PtyCode);
               length = lengthMin;
            }
         }else{
            if(valueLength < min){
               text = _resource.findDisplay(TagValidLengthMin);
               code = _resource.findConfigAttribute(TagValidLengthMin, PtyCode);
               length = lengthMin;
            }
         }
      }
      //............................................................
      // 检查最大长度
      if(RString.isNotEmpty(lengthMax)){
         int max = RInteger.parse(lengthMax);
         if(RBoolean.parse(lengthMaxEq)){
            if(valueLength >= max){
               text = _resource.findDisplay(TagValidLengthMaxEq);
               code = _resource.findConfigAttribute(TagValidLengthMaxEq, PtyCode);
               length = lengthMax;
            }
         }else{
            if(valueLength > max){
               text = _resource.findDisplay(TagValidLengthMax);
               code = _resource.findConfigAttribute(TagValidLengthMax, PtyCode);
               length = lengthMax;
            }
         }
      }
      //............................................................
      // 创建消息
      if(text != null){
         FGcValidMessage message = new FGcValidMessage(code, text, label, length);
         message.setValues(name, lengthMin);
         context.messages().push(message);
         throw new FGcValidError();
      }
   }

   //============================================================
   // <T>检查格式。</T>
   //
   // @param context 消息环境
   // @param format 检查格式
   // @param value 检查内容
   // @param name 显示名称
   // @param label 显示内容
   //============================================================
   public static void checkFormat(IMessageContext context,
                                  String format,
                                  String value,
                                  String name,
                                  String label){
      if(!RString.isPartten(value, format)){
         String text = _resource.findDisplay(TagValidFormat);
         String code = _resource.findConfigAttribute(TagValidFormat, PtyCode);
         // 创建消息
         FGcValidMessage message = new FGcValidMessage(code, text, label);
         message.setValues(name, format);
         context.messages().push(message);
         // 检查例外
         throw new FGcValidError();
      }
   }

   //============================================================
   // <T>检查电子邮箱格式。</T>
   //
   // @param context 消息环境
   // @param value 检查内容
   // @param name 显示名称
   // @param label 显示内容
   //============================================================
   public static void checkFormatEmail(IMessageContext context,
                                       String value,
                                       String name,
                                       String label){
      boolean valid = true;
      // 检查为空
      if(RString.isEmpty(value)){
         valid = false;
      }
      // 检查有效字符
      if(valid && !RString.isPartten(value, "naA@.-_")){
         valid = false;
      }
      // 检查字符位置
      if(valid){
         int indexAt = value.indexOf('@');
         int indexDot = value.indexOf('.');
         if((indexAt == -1) || (indexDot == -1)){
            valid = false;
         }else if(indexAt > indexDot){
            valid = false;
         }
      }
      // 创建消息
      if(!valid){
         String text = _resource.findDisplay(TagValidFormatEmail);
         String code = _resource.findConfigAttribute(TagValidFormatEmail, PtyCode);
         FGcValidMessage message = new FGcValidMessage(code, text, label);
         message.setValues(name);
         context.messages().push(message);
         throw new FGcValidError();
      }
   }

   //============================================================
   // <T>检查电话号码格式。</T>
   //
   // @param context 消息环境
   // @param value 检查内容
   // @param name 显示名称
   // @param label 显示内容
   //============================================================
   public static void checkFormatPhone(IMessageContext context,
                                       String value,
                                       String name,
                                       String label){
      boolean valid = true;
      // 检查为空
      if(RString.isEmpty(value)){
         valid = false;
      }
      // 检查有效字符
      if(valid && !RString.isPartten(value, "n-")){
         valid = false;
      }
      // 检查有效长度
      if(valid){
         int length = value.length();
         int min = RInteger.parse(_resource.findConfigAttribute(TagValidFormatPhone, PtyMin));
         int max = RInteger.parse(_resource.findConfigAttribute(TagValidFormatPhone, PtyMax));
         if((length < min) || (length > max)){
            valid = false;
         }
      }
      // 创建消息
      if(!valid){
         String text = _resource.findDisplay(TagValidFormatPhone);
         String code = _resource.findConfigAttribute(TagValidFormatPhone, PtyCode);
         FGcValidMessage message = new FGcValidMessage(code, text, label);
         message.setValues(name);
         context.messages().push(message);
         throw new FGcValidError();
      }
   }

   //============================================================
   // <T>检查手机号码格式。</T>
   //
   // @param context 消息环境
   // @param value 检查内容
   // @param name 显示名称
   // @param label 显示内容
   //============================================================
   public static void checkFormatMobile(IMessageContext context,
                                        String value,
                                        String name,
                                        String label){
      // 检查为空
      if(RString.isEmpty(value)){
         return;
      }
      // 创建消息
      Matcher m = PatternMobile.matcher(value);
      if(!m.matches()){
         String text = _resource.findDisplay(TagValidFormatMobile);
         String code = _resource.findConfigAttribute(TagValidFormatMobile, PtyCode);
         FGcValidMessage message = new FGcValidMessage(code, text, label);
         message.setValues(name);
         context.messages().push(message);
         throw new FGcValidError();
      }

   }

   //============================================================
   // <T>检查帐号格式。</T>
   //
   // @param context 消息环境
   // @param value 检查内容
   // @param name 显示名称
   // @param label 显示内容
   //============================================================
   public static void checkFormatPassport(IMessageContext context,
                                          String value,
                                          String name,
                                          String label){
      // 检查为空
      if(RString.isEmpty(value)){
         return;
      }

      if(value.length() < 4 || 15 < value.length() || (!PartternAccount.matcher(value).matches())){
         // 创建消息        
         String text = _resource.findDisplay(TagValidFormatPassport);
         String code = _resource.findConfigAttribute(TagValidFormatPassport, PtyCode);
         FGcValidMessage message = new FGcValidMessage(code, text, label);
         message.setValues(name);
         context.messages().push(message);
         throw new FGcValidError();
      }

   }
}
