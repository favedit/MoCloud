package org.mo.core.bind;

import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObjects;

//============================================================
// <T>绑定信息集合。</T>
//============================================================
public class FBindInfos
      extends FObjects<FBindInfo>
{
   //============================================================
   // <T>构造绑定信息集合。</T>
   //============================================================
   public FBindInfos(){
      super(FBindInfo.class);
   }

   //============================================================
   // <T>检查代码是否存在。</T>
   //
   // @param code 代码
   // @return 是否存在
   //============================================================
   public boolean containsByCode(long code){
      if(code > 0){
         for(int n = 0; n < _count; n++){
            FBindInfo find = _items[n];
            if(find != null){
               if(find.code() == code){
                  return true;
               }
            }
         }
      }
      return false;
   }

   //============================================================
   // <T>获得绑定信息。</T>
   //
   // @param code 代码
   // @return 绑定信息
   //============================================================
   public FBindInfo findByCode(long code){
      if(code <= 0){
         return null;
      }
      for(int n = 0; n < _count; n++){
         FBindInfo info = _items[n];
         if(info != null){
            if(info.code() == code){
               return info;
            }
         }
      }
      return null;
   }

   //============================================================
   // <T>同步绑定信息。</T>
   //
   // @param code 代码
   // @return 绑定信息
   //============================================================
   public FBindInfo syncByCode(long code){
      // 检查参数
      if(code <= 0){
         throw new FFatalError("Code is invalid. (code={1})", code);
      }
      // 查找对象
      FBindInfo info = null;
      for(int n = 0; n < _count; n++){
         FBindInfo find = _items[n];
         if(find != null){
            if(find.code() == code){
               info = find;
               break;
            }
         }
      }
      // 创建对象
      if(info == null){
         info = new FBindInfo();
         info.setCode(code);
         push(info);
      }
      return info;
   }
}
