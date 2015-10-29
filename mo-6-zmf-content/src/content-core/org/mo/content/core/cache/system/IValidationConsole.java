package org.mo.content.core.cache.system;

import com.cyou.gccloud.data.cache.FCacheSystemValidationUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.com.lang.EResult;
import org.mo.com.lang.type.TDateTime;
//============================================================
//<P>短信效验操作接口</P>
//
//@class IValidationConsole
//@author Sunhr
//@Date 2015.08.25  
//@version 1.0.0
//============================================================
import org.mo.data.logic.ILogicContext;

public interface IValidationConsole
      extends
         IAbstractLogicUnitConsole<FCacheSystemValidationUnit>
{
   // ============================================================
   // <T>根据账号获取短信验证信息</T>
   //
   // @param logicContext 链接对象
   // @param passport 角色编号
   // ============================================================
   FCacheSystemValidationUnit findByPassport(ILogicContext logicContext,
                                             String passport);

   // ============================================================
   // <T>获取当前时间前5分钟的数据</T>
   //
   // @param logicContext 链接对象
   // @param nowTime 当前时间
   // ============================================================
   FCacheSystemValidationUnit findByTime(ILogicContext logicContext,
                                         TDateTime nowTime,
                                         String passport);

   // ============================================================
   // <T>根据验证码获取数据</T>
   //
   // @param logicContext 链接对象
   // @param code 验证码
   // ============================================================
   FCacheSystemValidationUnit findByCode(ILogicContext logicContext,
                                         String code);

   // ============================================================
   // <T>根据验证码删除数据</T>
   //
   // @param logicContext 链接对象
   // @param code 验证码
   // ============================================================
   EResult deleteByCode(ILogicContext logicContext,
                        String code);

}
