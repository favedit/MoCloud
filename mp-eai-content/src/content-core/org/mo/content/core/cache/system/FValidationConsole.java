package org.mo.content.core.cache.system;

import com.cyou.gccloud.data.cache.FCacheSystemValidationLogic;
import com.cyou.gccloud.data.cache.FCacheSystemValidationUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
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
      FCacheSystemValidationUnit user = logic.search(FCacheSystemValidationUnit.class, where);
      return user;
   }
}
