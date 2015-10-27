package org.mo.content.core.product.common;

import com.cyou.gccloud.data.data.FDataCommonProvinceLogic;
import com.cyou.gccloud.data.data.FDataCommonProvinceUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.RString;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.FLogicDataset;
//============================================================
//<P>省份信息操作接口</P>
//
//@class FProvinceConsole
//@author Sunhr
//@Date 2015.09.13  
//@version 1.0.0
//============================================================
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>省会控制台</P>
//@class FProvinceConsole
//@author AnjoyTian
//@Date 2015.09.21  
//@version 1.0.0
//============================================================

public class FProvinceConsole
      extends FAbstractLogicUnitConsole<FDataCommonProvinceLogic, FDataCommonProvinceUnit>
      implements
         IProvinceConsole
{

   // 每页条数
   static final int _pageSize = 20;

   //============================================================
   // <T>构造设备控制台。</T>
   //============================================================

   public FProvinceConsole(){
      super(FDataCommonProvinceLogic.class, FDataCommonProvinceUnit.class);
   }

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   // @param logicContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataProvinceInfo> select(ILogicContext logicContext,
                                                  FDataCommonProvinceUnit unit,
                                                  int pageNum,
                                                  int pageSize){
      if(pageNum < 0){
         pageNum = 0;
      }
      FSql where = new FSql();
      if(!RString.isEmpty(unit.label())){
         where.append(FDataCommonProvinceLogic.LABEL);
         where.append(" LIKE '%");
         where.append(unit.label() + "%'");
      }
      //      String orderBy = String.format("%s %s", FDataCommonProvinceLogic.LABEL, "ASC");
      FDataCommonProvinceLogic logic = logicContext.findLogic(FDataCommonProvinceLogic.class);
      FLogicDataset<FDataProvinceInfo> userInfoList = logic.fetchClass(FDataProvinceInfo.class, null, where.toString(), null, pageSize, pageNum);
      return userInfoList;
   }

   // ============================================================
   // <T>根据区号获取对象</T>
   // @param logicContext 链接对象
   // @param code 区号
   // @return 数据对象
   // ============================================================
   @Override
   public FDataCommonProvinceUnit findByCode(ILogicContext logicContext,
                                             String code){
      FSql whereSql = new FSql();
      if(!RString.isEmpty(code)){
         whereSql.append(FDataCommonProvinceLogic.CODE);
         whereSql.append("='");
         whereSql.append(code + "'");
      }
      FDataCommonProvinceLogic logic = logicContext.findLogic(FDataCommonProvinceLogic.class);
      FLogicDataset<FDataCommonProvinceUnit> roleList = logic.fetch(whereSql.toString());
      return roleList.first();
   }

   @Override
   public FDataCommonProvinceUnit findByLabel(FLogicContext logicContext,
                                              String provinceLabel){
      return null;
   }
}
