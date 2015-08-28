package org.mo.eai.logic.data.control.role;

import com.cyou.gccloud.data.data.FDataControlRoleLogic;
import com.cyou.gccloud.data.data.FDataControlRoleModuleLogic;
import com.cyou.gccloud.data.data.FDataControlRoleModuleUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>数据控制角色控制台。</T>
//============================================================
public class FDataControlRoleConsole
      extends FAbstractLogicUnitConsole<FDataControlRoleLogic, FDataControlRoleInfo>
      implements
         IDataControlRoleConsole
{
   // 日志输出接口
   // private static ILogger _logger = RLogger.find(FDataControlRoleConsole.class);

   // 模块控制台
   @ALink
   protected IDataControlModuleConsole _moduleConsole;

   //============================================================
   // <T>构造数据控制角色控制台。</T>
   //============================================================
   public FDataControlRoleConsole(){
      super(FDataControlRoleLogic.class, FDataControlRoleInfo.class);
   }

   //============================================================
   // <T>根据角色编号查找授权的所有模块集合。</T>
   //
   // @param logicContext 逻辑环境
   // @param roleId 角色编号
   // @return 模块集合
   //============================================================
   @Override
   public FLogicDataset<FDataControlModuleInfo> findRoleModules(ILogicContext logicContext,
                                                                long roleId){
      FLogicDataset<FDataControlModuleInfo> dataset = null;
      // 检查参数
      if(roleId == 0){
         return dataset;
      }
      // 查找角色模块集合
      FDataControlRoleModuleLogic roleModuleLogic = logicContext.findLogic(FDataControlRoleModuleLogic.class);
      FSql whereSql = new FSql("ROLE_ID={role_id}");
      whereSql.bindLong("role_id", roleId);
      FLogicDataset<FDataControlRoleModuleUnit> moduleDataset = roleModuleLogic.fetch(whereSql);
      if(!moduleDataset.isEmpty()){
         // 查询模块信息
         dataset = new FLogicDataset<FDataControlModuleInfo>(FDataControlModuleInfo.class);
         for(FDataControlRoleModuleUnit roleModuleUnit : moduleDataset){
            long moduleId = roleModuleUnit.moduleId();
            FDataControlModuleInfo moduleInfo = _moduleConsole.find(logicContext, moduleId);
            if(moduleInfo != null){
               moduleInfo.setViewValidCd(roleModuleUnit.viewValidCd());
               moduleInfo.setInsertValidCd(roleModuleUnit.insertValidCd());
               moduleInfo.setUpdateValidCd(roleModuleUnit.updateValidCd());
               moduleInfo.setDeleteValidCd(roleModuleUnit.deleteValidCd());
               dataset.push(moduleInfo);
            }
         }
      }
      return dataset;
   }
}
