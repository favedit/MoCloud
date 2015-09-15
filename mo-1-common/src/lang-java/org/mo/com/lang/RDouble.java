package org.mo.com.lang;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import org.mo.com.lang.type.RBaseDouble;

//============================================================
// <T>双精度数据类型工具类。</T>
//
// @history 051012 MAOCY 创建
//============================================================
public class RDouble
      extends RBaseDouble
{
   // 存储位长度
   public final static int BIT_LENGTH = 64;

   // 存储字节长度
   public final static int BYTE_LENGTH = 8;

   // 内存容量
   public final static int CAPACITY = 32;

   // 内存增长率
   public final static int MULTIPLIER = 2;

   //============================================================
   // <T>判断字符串是否为双精度数。</T>
   //
   // @param value 字符串
   // @return 双精度数
   //============================================================
   public static boolean isDouble(String value){
      return RString.isPartten(value, "+-.n");
   }

   //============================================================
   // <T>将一个字符串变换为双精度数。</T>
   // <P>如果变换失败，将得到双精度类型的默认值，不会产生错误。</P>
   //
   // @param value 字符串
   // @return 双精度数
   //============================================================
   public static double parse(String value){
      if(value != null){
         return parse(value, DEFAULT);
      }
      return DEFAULT;
   }

   //============================================================
   // <T>将一个字符串变换为双精度数。</T>
   // <P>如果变换失败，将得到双精度类型的默认值，不会产生错误。</P>
   //
   // @param sValue 字符串
   // @param defaultValue 默认值
   // @return 双精度数
   //============================================================
   public static double parse(String value,
                              double defaultValue){
      // 检查错误
      if("NaN".equals(value)){
         return defaultValue;
      }
      // 解析浮点数
      try{
         return Double.parseDouble(value);
      }catch(Exception exception){
      }
      return defaultValue;
   }

   //============================================================
   // <T>将一个对象变换为双精度数。</T>
   // <P>如果变换失败，将得到双精度类型的默认值，不会产生错误。</P>
   //
   // @param item 对象
   // @return 双精度数
   //============================================================
   public static double parse(Object item){
      if(item != null){
         // 是否为数字
         if(item instanceof Double){
            return ((Double)item).doubleValue();
         }
         // 转换为字符串
         String value = null;
         if(item instanceof String){
            value = (String)item;
         }else{
            value = item.toString();
         }
         // 解析数字
         value = value.trim();
         if(value.length() > 0){
            return Double.parseDouble(value);
         }
      }
      return DEFAULT;
   }

   //============================================================
   // <T>将一个对象变换为双精度数。</T>
   // <P>如果变换失败，将得到双精度类型的默认值，不会产生错误。</P>
   //
   // @param item 对象
   // @param defaultValue 默认值
   // @return 双精度数
   //============================================================
   public static double parse(Object item,
                              double defaultValue){
      if(null != item){
         return parse(item.toString(), defaultValue);
      }
      return defaultValue;
   }

   //============================================================
   // <T>将一个字符串数组变换为双精度数组。</T>
   // <P>如果变换失败，将得到双精度类型的默认值，不会产生错误。</P>
   //
   // @param values 字符串数组
   // @return 双精度数组
   //============================================================
   public static double[] toDoubles(String[] values){
      double[] result = null;
      if(values != null){
         int count = values.length;
         result = new double[count];
         for(int n = 0; n < count; n++){
            result[n] = parse(values[n]);
         }
      }
      return result;
   }

   //============================================================
   // <T>计算百分比</T>
   //
   // @param use 已使用
   // @param total 总量
   // @return percent 百分比
   //============================================================
   public static double calculatePercent(long used,
                                         long total){
      double per = ((total - used) * 1.0) / (total * 1.0) * 100;
      DecimalFormat df = new DecimalFormat("#####0.00");
      double percent = RDouble.parse(df.format(per).toString());
      return percent;
   }

   //============================================================
   // <T>获得长整数的字符串。</T>
   //
   // @param value 内容
   // @return 字符串
   //============================================================
   public final static String toString(double value){
      return Double.toString(value);
   }

   //============================================================
   // <T>四舍五入方式截取浮点数精度。</T>
   //
   // @param value 双精度数
   // @param length 格式化长度
   // @return 字符串
   //============================================================
   public static double roundHalf(double value,
                                  int length){
      BigDecimal decimal = new BigDecimal(value);
      double result = decimal.setScale(length, BigDecimal.ROUND_HALF_UP).doubleValue();
      return result;
   }

   //============================================================
   // <T>将一个双精度数值格式化为字符串。</T>
   //
   // @param value 双精度数
   // @param length 格式化长度
   // @return 字符串
   //============================================================
   public static String format(double value,
                               int length){
      String valueString = Double.toString(value);
      return RString.leftPad(valueString, length, "0");
   }

   //============================================================
   // <T>将一个双精度数值格式化为字符串。</T>
   //
   // @param value 双精度数
   // @param length 格式化长度
   // @param pad 补足长度用的字符串
   // @return 字符串
   //============================================================
   public static String format(String value,
                               int length){
      return RString.leftPad(value, length, "0");
   }

   //============================================================
   // <T>将一个双精度数值格式化为字符串。</T>
   //
   // @param value 双精度数
   // @param length 格式化长度
   // @param pad 补足长度用的字符串
   // @return 字符串
   //============================================================
   public static String format(double value,
                               int length,
                               String pad){
      return RString.leftPad(Double.toString(value), length, pad);
   }

   //============================================================
   // <T>将一个双精度数值格式化为字符串。</T>
   //
   // @param value 双精度数
   // @param length 格式化长度
   // @param pad 补足长度用的字符串
   // @return 字符串
   //============================================================
   public static String format(String value,
                               int length,
                               String pad){
      return RString.leftPad(value, length, pad);
   }
}
