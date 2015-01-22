package org.mo.data.logic.cache;

import org.mo.com.collections.FCodeLongSet;
import org.mo.com.collections.FRow;
import org.mo.com.lang.FObject;

//============================================================
// <T>逻辑单元缓冲。</T>
//============================================================
public class FLogicUnitCache
      extends FObject
{
   // 单元集合
   protected FCodeLongSet<FRow> _rows = new FCodeLongSet<FRow>(FRow.class);

   //============================================================
   // <T>构造逻辑单元缓冲。</T>
   //============================================================
   public FLogicUnitCache(){
   }

   //============================================================
   // <T>获得记录行集合。</T>
   //
   // @return 记录行集合
   //============================================================
   public FCodeLongSet<FRow> rows(){
      return _rows;
   }

   //============================================================
   // <T>根据代码获得逻辑单元。</T>
   //
   // @param code 代码
   // @return 逻辑单元
   //============================================================
   public FRow get(long code){
      return _rows.get(code);
   }

   //============================================================
   // <T>根据代码设置逻辑单元。</T>
   //
   // @param code 代码
   // @param unit 逻辑单元
   //============================================================
   public void set(long code,
                   FRow row){
      _rows.set(code, row);
   }

   //============================================================
   // <T>清除全部数据内容。</T>
   //============================================================
   public void clear(){
      _rows.clear();
   }
}
