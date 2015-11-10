package org.mo.content.core.manage.product.organization.department.user;

import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import com.cyou.gccloud.data.data.FDataOrganizationDepartmentLogic;
import com.cyou.gccloud.data.data.FDataOrganizationDepartmentUserLogic;
import com.cyou.gccloud.data.data.FDataOrganizationDepartmentUserUnit;
import com.cyou.gccloud.define.enums.common.EGcRelation;
import com.cyou.gccloud.define.enums.core.EGcEmploy;

//============================================================
//<P>部门用户控制台</P>
//@class FUserConsole
//@version 1.0.0
//============================================================
public class FUserConsole
      extends 
         FAbstractLogicUnitConsole<FDataOrganizationDepartmentUserLogic, FDataOrganizationDepartmentUserUnit>
      implements
         IUserConsole
{
   // 每页条数
   static final int _pageSize = 20;
   
   //============================================================
   // <T>构造部门用户控制台。</T>
   //============================================================
   public FUserConsole(){
      super(FDataOrganizationDepartmentUserLogic.class, FDataOrganizationDepartmentUserUnit.class);
   }

   @Override
   public FLogicDataset<FDataUserInfo> select(ILogicContext logicContext,
                                              FDataUserInfo unit,
                                              int pageNum,
                                              int pageSize){
      if(pageNum < 0){
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      if(!RString.isEmpty(unit.label())){
         whereSql.append(FDataOrganizationDepartmentUserLogic.LABEL + " LIKE '%{label}%'");
         whereSql.bind("label", RString.parse(unit.label()));
      }
      String orderBy = String.format("%s %s", FDataOrganizationDepartmentUserLogic.ENTRY_DATE, "DESC");
      FDataOrganizationDepartmentUserLogic logic = logicContext.findLogic(FDataOrganizationDepartmentUserLogic.class);
      FLogicDataset<FDataUserInfo> moduleList = logic.fetchClass(FDataUserInfo.class, null, whereSql.toString(), orderBy, pageSize, pageNum);
      for(FDataUserInfo info : moduleList){
         info.setStatusCdStr(EGcEmploy.formatLabel(RInteger.parse(info.statusCd())));
         info.setRelationCdStr(EGcRelation.formatLabel(info.relationCd()));
         if(info.user()!=null){
            info.setUserName(info.user().name());
         }
         if(info.department()!=null){
            info.setDepartmentName(info.department().label());
         }
      }
      return moduleList;
   }

   // ============================================================
   // <T>根据ouid查询组织部门用户信息</T>
   // @param logicContext 链接对象
   // @param ouid 唯一标识符
   // @return 数据对象
   // ============================================================
   @Override
   public FDataUserInfo findInfo(ILogicContext logicContext,
                                 Long ouid){
      FSql whereSql = new FSql();
      if(ouid!=0){
         whereSql.append(FDataOrganizationDepartmentLogic.OUID);
         whereSql.append(" = '{OUID}'");
         whereSql.bind("OUID", RString.parse(ouid));
      }
      FDataOrganizationDepartmentUserLogic logic = logicContext.findLogic(FDataOrganizationDepartmentUserLogic.class);
      FDataUserInfo unit = logic.fetchClass(FDataUserInfo.class, whereSql.toString()).first();
      return unit;
   }
}
