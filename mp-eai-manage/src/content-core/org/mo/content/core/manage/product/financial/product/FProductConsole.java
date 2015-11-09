package org.mo.content.core.manage.product.financial.product;

import com.cyou.gccloud.data.data.FDataFinancialProductLogic;
import com.cyou.gccloud.data.data.FDataFinancialProductUnit;

import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.RString;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>产品信息控制台</P>
//@class FProductConsole
//@version 1.0.0
//============================================================
public class FProductConsole
      extends 
         FAbstractLogicUnitConsole<FDataFinancialProductLogic, FDataFinancialProductUnit>
      implements
         IProductConsole
{

   // 每页条数
   static final int _pageSize = 20;

   //============================================================
   // <T>构造产品控制台。</T>
   //============================================================

   public FProductConsole(){
      super(FDataFinancialProductLogic.class, FDataFinancialProductUnit.class);
   }

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   // @param logicContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @param pageSize 页面显示的行数
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataFinancialProductUnit> select(ILogicContext logicContext,
                                                          FDataFinancialProductUnit unit,
                                                          int pageNum,
                                                          int pageSize){
      if(pageNum < 0){
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      if(!RString.isEmpty(unit.label())){
         whereSql.append(FDataFinancialProductLogic.LABEL + " LIKE '%{label}%'");
         whereSql.bind("label", RString.parse(unit.label()));
      }
      String orderBy = String.format("%s %s", FDataFinancialProductLogic.LABEL, "ASC");
      FDataFinancialProductLogic logic = logicContext.findLogic(FDataFinancialProductLogic.class);
      FLogicDataset<FDataFinancialProductUnit> moduleList = logic.fetch(whereSql.toString(), orderBy, pageSize, pageNum);
      return moduleList;
   }

   // ============================================================
   // <T>重写，获得分页数据列表</T>
   // @param logicContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @param pageSize 页面显示的行数
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataProductInfo> select(ILogicContext logicContext,
                                                 FDataProductInfo unit,
                                                 int pageNum,
                                                 int pageSize){
      if(pageNum < 0){
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      if(!RString.isEmpty(unit.label())){
         whereSql.append(FDataFinancialProductLogic.LABEL + " LIKE '%{label}%'");
         whereSql.bind("label", RString.parse(unit.label()));
      }
      String orderBy = String.format("%s %s", FDataFinancialProductLogic.LABEL, "ASC");
      FDataFinancialProductLogic logic = logicContext.findLogic(FDataFinancialProductLogic.class);
      FLogicDataset<FDataProductInfo> moduleList = logic.fetchClass(FDataProductInfo.class, null, whereSql.toString(), orderBy, pageSize, pageNum);
      return moduleList;
   }
   // ============================================================
   // <T>根据区号获取对象</T>
   // @param logicContext 链接对象
   // @param code 区号
   // @return 数据对象
   // ============================================================
   @Override
   public FDataFinancialProductUnit findByCode(ILogicContext logicContext,
                                               String code){
      FSql whereSql = new FSql();
      if(!RString.isEmpty(code)){
         whereSql.append(FDataFinancialProductLogic.CODE);
         whereSql.append(" = '{CODE}'");
         whereSql.bind("CODE", RString.parse(code));
      }
      FDataFinancialProductLogic logic = logicContext.findLogic(FDataFinancialProductLogic.class);
      FLogicDataset<FDataFinancialProductUnit> roleList = logic.fetch(whereSql.toString());
      return roleList.first();
   }
   // ============================================================
   // <T>根据ouid查询产品信息</T>
   // @param logicContext 链接对象
   // @param code 区号
   // @return 数据对象
   // ============================================================
   @Override
   public FDataProductInfo findInfo(ILogicContext logicContext,
                                    Long ouid){
      FSql whereSql = new FSql();
      if(ouid!=0){
         whereSql.append(FDataFinancialProductLogic.OUID);
         whereSql.append(" = '{OUID}'");
         whereSql.bind("OUID", RString.parse(ouid));
      }
      FDataFinancialProductLogic logic = logicContext.findLogic(FDataFinancialProductLogic.class);
      FDataFinancialProductUnit unit = logic.fetch(whereSql.toString()).first();
      FDataProductInfo info = new FDataProductInfo();
      info.setOuid(unit.ouid());
      info.setNote(unit.note());
      info.setLabel(unit.label());
      info.setCode(unit.code());
      info.setHorizonCount(unit.horizonCount());
      info.setHorizonClosed(unit.horizonClosed());
      info.setHorizonWait(unit.horizonWait());
      info.setFactor(unit.factor());
      info.setRate(unit.rate());
      info.setHorizonUnit(unit.horizonUnit());
      info.setIconUrl(unit.iconUrl());
      return info;
   }
}
