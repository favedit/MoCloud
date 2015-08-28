package org.mo.content.core.cache.system;

import com.cyou.gccloud.data.cache.FCacheSystemValidationLogic;
import com.cyou.gccloud.data.cache.FCacheSystemValidationUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.com.lang.type.TDateTime;
import org.mo.data.logic.FLogicDataset;
//============================================================
//<P>短信效验操作控制器</P>
//
//@class FValidationConsole
//@author Sunhr
//@Date 2015.08.25  
//@version 1.0.0
//============================================================
import org.mo.data.logic.ILogicContext;

public class FValidationConsole

      extends FAbstractLogicUnitConsole<FCacheSystemValidationLogic, FCacheSystemValidationUnit>
      implements
         IValidationConsole
{

   //============================================================
   // <T>构造设备控制台。</T>
   //============================================================
   public FValidationConsole(){
      super(FCacheSystemValidationLogic.class, FCacheSystemValidationUnit.class);
   }

   // ============================================================
   // <T>根据账号获取短信验证信息</T>
   //
   // @param logicContext 链接对象
   // @param passport 角色编号
   // ============================================================
   @Override
   public FCacheSystemValidationUnit findByPassport(ILogicContext logicContext,
                                                    String passport){
      FSql where = new FSql();
      if(RString.isEmpty(passport)){
         throw new FFatalError("passport is empty.");
      }
      where.append(FCacheSystemValidationLogic.PASSPORT);
      where.append(" = {passport}");
      where.bindString("passport", passport);
      FCacheSystemValidationLogic logic = logicContext.findLogic(FCacheSystemValidationLogic.class);
      FLogicDataset<FCacheSystemValidationUnit> user = logic.fetch(where, "CREATE_DATE");
      if(user == null){
         return null;
      }
      return user.first();
   }

   // ============================================================
   // <T>获取当前时间前5分钟的数据</T>
   //
   // @param logicContext 链接对象
   // @param nowTime 当前时间
   // ============================================================
   @Override
   public FCacheSystemValidationUnit findByTime(ILogicContext logicContext,
                                                TDateTime nowTime){

      TDateTime nowTimeBefore = new TDateTime(nowTime);
      nowTimeBefore.addMinute(-5);

      FSql where = new FSql();
      if(nowTime == null){
         throw new FFatalError("nowTime is empty.");
      }
      where.append(nowTimeBefore + " < " + FCacheSystemValidationLogic.CREATE_DATE);
      where.append(" AND ");
      where.append(nowTime + " > " + FCacheSystemValidationLogic.CREATE_DATE);
      FCacheSystemValidationLogic logic = logicContext.findLogic(FCacheSystemValidationLogic.class);

      FLogicDataset<FCacheSystemValidationUnit> user = logic.fetch(where, "CREATE_DATE");
      if(user == null){
         return null;
      }
      return user.first();
   }

   // ============================================================
   // <T>根据验证码删除数据</T>
   //
   // @param logicContext 链接对象
   // @param code 验证码
   // ============================================================
   @Override
   public EResult deleteByCode(ILogicContext logicContext,
                               String code){
      if(RString.isEmpty(code)){
         throw new FFatalError("code is empty.");
      }
      FCacheSystemValidationLogic logic = logicContext.findLogic(FCacheSystemValidationLogic.class);
      FCacheSystemValidationUnit unit = findByCode(logicContext, code);
      if(unit == null){
         return EResult.Failure;
      }
      EResult result = logic.doDelete(unit);
      return result;
   }

   // ============================================================
   // <T>根据验证码获取数据</T>
   //
   // @param logicContext 链接对象
   // @param code 验证码
   // ============================================================
   @Override
   public FCacheSystemValidationUnit findByCode(ILogicContext logicContext,
                                                String code){
      FSql where = new FSql();
      if(RString.isEmpty(code)){
         throw new FFatalError("code is empty.");
      }
      where.append(FCacheSystemValidationLogic.CHECK_CODE);
      where.append(" = {CHECK_CODE}");
      where.bindString("CHECK_CODE", code);
      FCacheSystemValidationLogic logic = logicContext.findLogic(FCacheSystemValidationLogic.class);
      FLogicDataset<FCacheSystemValidationUnit> user = logic.fetch(where);
      if(user == null){
         return null;
      }
      return user.first();
   }
}
