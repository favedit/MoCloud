package org.mo.eng.data;

import org.mo.com.data.ISqlConnection;
import org.mo.com.lang.FObject;

//============================================================
// <T>数据传输器。</T>
//============================================================
public class FDataTransfer
      extends FObject
{
   // 字符串编码
   protected String _charset = "utf-8";

   // 数据库链接
   protected ISqlConnection _connection;

   //============================================================
   // <T>构造数据传输器。</T>
   //============================================================
   public FDataTransfer(){
   }

   //============================================================
   // <T>构造数据传输器。</T>
   //
   // @param connection 数据库链接
   //============================================================
   public FDataTransfer(ISqlConnection connection){
      _connection = connection;
   }

   //============================================================
   // <T>构造数据传输器。</T>
   //
   // @param connection 数据库链接
   // @param charset 字符串编码
   //============================================================
   public FDataTransfer(ISqlConnection connection,
                        String charset){
      _connection = connection;
      _charset = charset;
   }

   //============================================================
   // <T>获得字符串编码。</T>
   //
   // @return 字符串编码
   //============================================================
   public String charset(){
      return _charset;
   }

   //============================================================
   // <T>设置字符串编码。</T>
   //
   // @param charset 字符串编码
   //============================================================
   public void setCharset(String charset){
      _charset = charset;
   }

   //============================================================
   // <T>获得数据库链接。</T>
   //
   // @return 数据库链接
   //============================================================
   public ISqlConnection connection(){
      return _connection;
   }

   //============================================================
   // <T>设置数据库链接。</T>
   //
   // @param connection 数据库链接
   //============================================================
   public void setConnection(ISqlConnection connection){
      _connection = connection;
   }
}
