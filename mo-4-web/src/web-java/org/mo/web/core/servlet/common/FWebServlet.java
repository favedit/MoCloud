package org.mo.web.core.servlet.common;

import org.mo.com.lang.reflect.FClass;
import org.mo.com.lang.reflect.RClass;

//============================================================
// <T>网页处理。</T>
//============================================================
public class FWebServlet
{
   // 接口
   private String _face;

   // 接口类
   private FClass<?> _faceClass;

   // 名称
   private String _name;

   //============================================================
   // <T>获得名称。</T>
   //
   // @return 名称
   //============================================================
   public String name(){
      return _name;
   }

   //============================================================
   // <T>获得接口。</T>
   //
   // @return 接口
   //============================================================
   public String face(){
      return _face;
   }

   //============================================================
   // <T>获得接口类。</T>
   //
   // @return 接口类
   //============================================================
   public FClass<?> faceClass(){
      if(_faceClass == null){
         _faceClass = RClass.find(_face);
      }
      return _faceClass;
   }

   //============================================================
   // <T>构造处理。</T>
   //
   // @param xservlet 处理配置
   //============================================================
   public void construct(XAopServlet xservlet){
      _name = xservlet.name();
      _face = xservlet.face();
   }
}
