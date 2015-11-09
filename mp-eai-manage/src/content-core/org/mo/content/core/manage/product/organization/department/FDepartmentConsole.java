package org.mo.content.core.manage.product.organization.department;

import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.RLong;
import org.mo.com.lang.RString;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import com.cyou.gccloud.data.data.FDataOrganizationDepartmentLogic;
import com.cyou.gccloud.data.data.FDataOrganizationDepartmentUnit;
import com.cyou.gccloud.define.enums.common.EGcValid;
//============================================================
//<P>部门控制台</P>
//@class FDepartmentConsole
//@version 1.0.0
//============================================================

public class FDepartmentConsole
      extends 
         FAbstractLogicUnitConsole<FDataOrganizationDepartmentLogic, FDataOrganizationDepartmentUnit>
      implements
         IDepartmentConsole
{
   // 每页条数
   static final int _pageSize = 20;
   //============================================================
   // <T>构造部门控制台。</T>
   //============================================================
   public FDepartmentConsole(){
      super(FDataOrganizationDepartmentLogic.class,FDataOrganizationDepartmentUnit.class);
   }

   // ============================================================
   // <T>获得分页数据列表</T>
   // @param logicContext 链接对象
   // @param unit 查询条件
   // @param pageNum 页码
   // @param pageSize 页面显示的行数
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataDepartmentInfo> select(ILogicContext logicContext,
                                                    FDataDepartmentInfo unit,
                                                    int pageNum,
                                                    int pageSize){
      if(pageNum < 0){
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      if(!RString.isEmpty(unit.label())){
         whereSql.append(FDataOrganizationDepartmentLogic.LABEL + " LIKE '%{label}%'");
         whereSql.bind("label", RString.parse(unit.label()));
      }
      String orderBy = String.format("%s %s", FDataOrganizationDepartmentLogic.BUILD_DATE, "DESC");
      FDataOrganizationDepartmentLogic logic = logicContext.findLogic(FDataOrganizationDepartmentLogic.class);
      FLogicDataset<FDataDepartmentInfo> moduleList = logic.fetchClass(FDataDepartmentInfo.class, null, whereSql.toString(), orderBy, pageSize, pageNum);
      for(FDataDepartmentInfo info : moduleList){
         info.setValidCdStr(EGcValid.formatLabel(info.validCd()));
         Long parentId = RLong.parse(info.parentId());//为空
         FDataOrganizationDepartmentUnit unitd = this.findParentUnitByParentId(logicContext, parentId);
         if(unitd!=null){
            info.setParentLable(unitd.label());
         }
      }
      return moduleList;
   }
   // ============================================================
   // <T>根据父级id获取父级名称</T>
   // @param logicContext 链接对象
   // @param parentId 唯一标示
   // @return 数据对象
   // ============================================================
   @Override
   public FDataOrganizationDepartmentUnit findParentUnitByParentId(ILogicContext logicContext,
                                                                   Long parentId){
      FSql whereSql = new FSql();
      if(parentId!=0){
         whereSql.append(FDataOrganizationDepartmentLogic.OUID);
         whereSql.append(" = '{parentId}'");
         whereSql.bind("parentId", RString.parse(parentId));
         FDataOrganizationDepartmentLogic logic = logicContext.findLogic(FDataOrganizationDepartmentLogic.class);
         FLogicDataset<FDataOrganizationDepartmentUnit> departList = logic.fetch(whereSql.toString());
         return departList.first();
      }
      return null;
   }
   
   // ============================================================
   // <T>根据获取组织部门列表</T>
   // @param logicContext 链接对象
   // @return 数据对象
   // ============================================================
   @Override
   public FLogicDataset<FDataOrganizationDepartmentUnit> selectAll(ILogicContext logicContext) {
      FDataOrganizationDepartmentLogic logic = logicContext.findLogic(FDataOrganizationDepartmentLogic.class);
      FLogicDataset<FDataOrganizationDepartmentUnit> list = logic.fetchAll();
      return list;
   }
   // ============================================================
   // <T>根据ouid查询组织部门信息</T>
   // @param logicContext 链接对象
   // @param ouid 唯一标识符
   // @return 数据对象
   // ============================================================
   @Override
   public FDataDepartmentInfo findInfo(ILogicContext logicContext,
                                       Long ouid){
      FSql whereSql = new FSql();
      if(ouid!=0){
         whereSql.append(FDataOrganizationDepartmentLogic.OUID);
         whereSql.append(" = '{OUID}'");
         whereSql.bind("OUID", RString.parse(ouid));
      }
      FDataOrganizationDepartmentLogic logic = logicContext.findLogic(FDataOrganizationDepartmentLogic.class);
      FDataDepartmentInfo unit = logic.fetchClass(FDataDepartmentInfo.class, whereSql.toString()).first();
      unit.setValidCdStr(EGcValid.formatLabel(unit.validCd()));
      return unit;
   }
}
