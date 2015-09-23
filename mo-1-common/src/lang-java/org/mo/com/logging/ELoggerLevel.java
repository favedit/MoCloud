package org.mo.com.logging;

//============================================================
// <T>日志类型。</T>
//============================================================
public enum ELoggerLevel{
   // @member 禁止日志
   NONE(0x00),

   // @member 输出类型
   PRINT(0x01),

   // @member 调试类型
   DEBUG(0x02),

   // @member 提示类型
   INFO(0x04),

   // @member 警告类型
   WARN(0x08),

   // @member 逻辑错误类型
   ERROR(0x10),

   // @member 系统错误类型
   FATAL(0x20),

   // @member 禁止调试日志
   NO_DEBUG(0xFD);

   // 代码
   private int _value;

   //============================================================
   // <T>构造日志类型。</T>
   //============================================================
   private ELoggerLevel(int value){
      _value = value;
   }

   //============================================================
   // <T>获得内容。</T>
   //
   // @return 内容
   //============================================================
   public int value(){
      return _value;
   }

   //============================================================
   // <T>获得字符内容。</T>
   //
   // @return 字符
   //============================================================
   public static char toChar(ELoggerLevel levelCd){
      switch(levelCd){
         case DEBUG:
            return 'D';
         case INFO:
            return 'I';
         case WARN:
            return 'W';
         case ERROR:
            return 'E';
         case FATAL:
            return 'F';
         default:
            break;
      }
      return 'P';
   }

   //============================================================
   // <T>解析字符内容。</T>
   //
   // @param code 代码
   // @return 级别
   //============================================================
   public static ELoggerLevel parseChar(char code){
      switch(code){
         case 'D':
            return DEBUG;
         case 'I':
            return INFO;
         case 'W':
            return WARN;
         case 'E':
            return ERROR;
         case 'F':
            return FATAL;
         default:
            break;
      }
      return PRINT;
   }

   //============================================================
   // <T>获得字符串内容。</T>
   //
   // @param levelCd 级别
   // @return 代码
   //============================================================
   public static String toCode(ELoggerLevel levelCd){
      switch(levelCd){
         case DEBUG:
            return "debug";
         case INFO:
            return "info";
         case WARN:
            return "warn";
         case ERROR:
            return "error";
         case FATAL:
            return "fatal";
         default:
            break;
      }
      return "print";
   }

   //============================================================
   // <T>解析字符串内容。</T>
   //
   // @param code 代码
   // @return 级别
   //============================================================
   public static ELoggerLevel parseCode(String code){
      switch(code){
         case "debug":
            return DEBUG;
         case "info":
            return INFO;
         case "warn":
            return WARN;
         case "error":
            return ERROR;
         case "fatal":
            return FATAL;
         default:
            break;
      }
      return PRINT;
   }

   //============================================================
   // <T>获得内容字符串。</T>
   //
   // @return 字符串
   //============================================================
   @Override
   public String toString(){
      return super.toString() + "(" + _value + ")";
   }

   //============================================================
   // <T>是否可以输出的。</T>
   //
   // @return 可以输出
   //============================================================
   public static boolean isOutputAble(ELoggerLevel levelCd){
      switch(levelCd){
         case INFO:
         case WARN:
         case ERROR:
         case FATAL:
            return true;
         default:
            break;
      }
      return false;
   }
}
