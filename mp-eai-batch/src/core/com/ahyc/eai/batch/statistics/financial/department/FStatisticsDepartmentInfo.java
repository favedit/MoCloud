package com.ahyc.eai.batch.statistics.financial.department;

import org.mo.com.lang.FObject;
import org.mo.com.lang.FObjects;

//============================================================
// <T>部门信息。</T>
//============================================================
public class FStatisticsDepartmentInfo
      extends FObject
{
   // 编号
   protected long _id;

   // 关联
   protected long _linkId;

   // 标签
   protected String _label;

   // 级别信息
   protected FObjects<SDepartmentInfo> _levels = new FObjects<SDepartmentInfo>(SDepartmentInfo.class);

   //============================================================
   // <T>获得编号。</T>
   //============================================================
   public long id(){
      return _id;
   }

   //============================================================
   // <T>设置编号。</T>
   //============================================================
   public void setId(long id){
      _id = id;
   }

   //============================================================
   // <T>获得关联编号。</T>
   //============================================================
   public long linkId(){
      return _linkId;
   }

   //============================================================
   // <T>设置关联编号。</T>
   //============================================================
   public void setLinkId(long linkId){
      _linkId = linkId;
   }

   //============================================================
   // <T>获得标签。</T>
   //============================================================
   public String label(){
      return _label;
   }

   //============================================================
   // <T>设置标签。</T>
   //============================================================
   public void setLabel(String label){
      this._label = label;
   }

   //============================================================
   // <T>获得层级集合。</T>
   //============================================================
   public FObjects<SDepartmentInfo> levels(){
      return _levels;
   }
}
