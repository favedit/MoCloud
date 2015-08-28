package org.mo.eai.logic.data.control.role;

import com.cyou.gccloud.data.data.FDataControlModuleUnit;

//============================================================
// <T>数据控制模块信息。</T>
//============================================================
public class FDataControlModuleInfo
      extends FDataControlModuleUnit
{
   // 查看有效性
   protected int _viewValidCd;

   // 新建有效性
   protected int _insertValidCd;

   // 更新有效性
   protected int _updateValidCd;

   // 删除有效性
   protected int _deleteValidCd;

   //============================================================
   // <T>获得查看有效性。</T>
   //
   // @return 有效性
   //============================================================
   public int viewValidCd(){
      return _viewValidCd;
   }

   //============================================================
   // <T>设置查看有效性。</T>
   //
   // @param viewValidCd 有效性
   //============================================================
   public void setViewValidCd(int viewValidCd){
      _viewValidCd = viewValidCd;
   }

   //============================================================
   // <T>获得新建有效性。</T>
   //
   // @return 有效性
   //============================================================
   public int insertValidCd(){
      return _insertValidCd;
   }

   //============================================================
   // <T>设置新建有效性。</T>
   //
   // @param insertValidCd 有效性
   //============================================================
   public void setInsertValidCd(int insertValidCd){
      _insertValidCd = insertValidCd;
   }

   //============================================================
   // <T>获得更新有效性。</T>
   //
   // @return 有效性
   //============================================================
   public int updateValidCd(){
      return _updateValidCd;
   }

   //============================================================
   // <T>设置更新有效性。</T>
   //
   // @param updateValidCd 有效性
   //============================================================
   public void setUpdateValidCd(int updateValidCd){
      _updateValidCd = updateValidCd;
   }

   //============================================================
   // <T>获得删除有效性。</T>
   //
   // @return 有效性
   //============================================================
   public int deleteValidCd(){
      return _deleteValidCd;
   }

   //============================================================
   // <T>设置删除有效性。</T>
   //
   // @param deleteValidCd 有效性
   //============================================================
   public void setDeleteValidCd(int deleteValidCd){
      _deleteValidCd = deleteValidCd;
   }
}
