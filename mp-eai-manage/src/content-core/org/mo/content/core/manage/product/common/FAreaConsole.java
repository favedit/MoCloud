package org.mo.content.core.manage.product.common;

import com.cyou.gccloud.data.data.FDataCommonAreaLogic;
import com.cyou.gccloud.data.data.FDataCommonAreaUnit;
import com.cyou.gccloud.data.data.FDataCommonCountryUnit;
import java.util.Iterator;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.RString;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>区域信息控制台</P>
//@class FAreaConsole
//@version 1.0.0
//============================================================
public class FAreaConsole 
      extends 
         FAbstractLogicUnitConsole<FDataCommonAreaLogic, FDataCommonAreaUnit>
      implements 
         IAreaConsole
{
   // 国家控制台
   @ALink
   protected ICountryConsole _countryConsole;

   // ============================================================
   // <T>构造区域控制台。</T>
   // ============================================================
   public FAreaConsole() {
      super(FDataCommonAreaLogic.class, FDataCommonAreaUnit.class);
   }

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   // @param logicContext 链接对象
   // @param unit 查询条件
   // @param pageNum 页码
   // @param pageSize 每页显示的行数
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataAreaInfo> select(ILogicContext logicContext, 
                                              FDataCommonAreaUnit unit, 
                                              int pageNum, 
                                              int pageSize) {
      if (pageNum < 0) {
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      if (!RString.isEmpty(unit.label())) {
         whereSql.append(FDataCommonAreaLogic.LABEL);
         whereSql.append(" like ");
         whereSql.append(" '%{label}%'");
         whereSql.bind("label", unit.label());
      }
      String orderBy = String.format("%s %s", FDataCommonAreaLogic.DISPLAY_ORDER, "DESC");
      FDataCommonAreaLogic logic = logicContext.findLogic(FDataCommonAreaLogic.class);
      FLogicDataset<FDataAreaInfo> userInfoList = logic.fetchClass(FDataAreaInfo.class, null, whereSql.toString(), orderBy, pageSize, pageNum);
      for (Iterator<FDataAreaInfo> iterator = userInfoList.iterator(); iterator.hasNext();) {
         FDataAreaInfo tempUnit = iterator.next();
         FDataCommonCountryUnit unit2 = _countryConsole.find(logicContext, tempUnit.countryId());
         if (unit2 != null) {
            String _countryLabel = unit2.name();
            tempUnit.setCountryLabel(_countryLabel);
         }
      }
      return userInfoList;
   }

   // ============================================================
   // <T>根据标签获取对象</T>
   // @param logicContext 链接对象
   // @param label 标签
   // @return 数据对象
   // ============================================================
   @Override
   public FDataCommonAreaUnit findByLable(ILogicContext logicContext, 
                                          String label) {
      FSql whereSql = new FSql();
      if (!RString.isEmpty(label)) {
         whereSql.append(FDataCommonAreaLogic.LABEL);
         whereSql.append(" like ");
         whereSql.append(" '%{label}%'");
         whereSql.bind("label", label);
      }
      FDataCommonAreaLogic logic = logicContext.findLogic(FDataCommonAreaLogic.class);
      FLogicDataset<FDataCommonAreaUnit> roleList = logic.fetch(whereSql.toString());
      return roleList.first();
   }

   // ============================================================
   // <T>根据区域标签和国家id，判断是否存在</T>
   // @param logicContext 链接对象
   // @param label 标签
   // @param countryId 国家id
   // @return 数据对象
   // ============================================================
   @Override
   public boolean isExistByAreaLabelandCountryId(ILogicContext logicContext, 
                                                 String areaLabel, 
                                                 Long countryId) {
      FSql whereSql = new FSql();
      if (!RString.isEmpty(areaLabel) && !RString.isEmpty(countryId + "")) {
         whereSql.append(FDataCommonAreaLogic.LABEL);
         whereSql.append(" like ");
         whereSql.append(" '%{label}%'");
         whereSql.bind("label", areaLabel);
         whereSql.append(" and ");
         whereSql.append(FDataCommonAreaLogic.COUNTRY_ID);
         whereSql.append(" = ");
         whereSql.append(" {countryId}");
         whereSql.bind("countryId", RString.parse(countryId));
         FDataCommonAreaLogic logic = logicContext.findLogic(FDataCommonAreaLogic.class);
         FLogicDataset<FDataCommonAreaUnit> areaList = logic.fetch(whereSql.toString());
         if (areaList.count() > 0) {
            return true;
         }
      }
      return false;
   }

   // ============================================================
   // <T>根据区域标签和国家id，ouid判断是否重复</T>
   // @param logicContext 链接对象
   // @param areaLabel 区域标签
   // @param countryId 国家id
   // @param ouid ouid
   // @return 数据对象
   // ============================================================
   @Override
   public boolean isExistByAreaLabelandCountryIdandOuid(ILogicContext logicContext, 
                                                        String areaLabel, 
                                                        Long countryId,
                                                        Long ouid) {
      FSql whereSql = new FSql();
      if (!RString.isEmpty(areaLabel) && !RString.isEmpty(countryId + "")) {
         whereSql.append(FDataCommonAreaLogic.LABEL);
         whereSql.append(" like ");
         whereSql.append(" '%{label}%'");
         whereSql.bind("label", areaLabel);
         whereSql.append(" and ");
         whereSql.append(FDataCommonAreaLogic.COUNTRY_ID);
         whereSql.append(" = ");
         whereSql.append(" {countryId}");
         whereSql.bind("countryId", RString.parse(countryId));
         FDataCommonAreaLogic logic = logicContext.findLogic(FDataCommonAreaLogic.class);
         FLogicDataset<FDataCommonAreaUnit> areaList = logic.fetch(whereSql.toString());
         for(FDataCommonAreaUnit unit : areaList){
            if(!RString.equals(unit.ouid(),ouid)){
               return true;
            }
         }
      }
      return false;
   }
   // ============================================================
   // <T>根据标签获取对象列表</T>
   // @param logicContext 链接对象
   // @param countryId 国家id
   // @return 数据对象
   // ============================================================
   @Override
   public FLogicDataset<FDataCommonAreaUnit> selectAll(ILogicContext logicContext, 
                                                       Long countryId) {
      FSql whereSql = new FSql();
      if (!RString.isEmpty(countryId + "") && countryId > 0) {
         whereSql.append(FDataCommonAreaLogic.COUNTRY_ID);
         whereSql.append(" = ");
         whereSql.append(" {countryId}");
         whereSql.bind("countryId", RString.parse(countryId));
         FDataCommonAreaLogic logic = logicContext.findLogic(FDataCommonAreaLogic.class);
         return logic.fetch(whereSql.toString());
      }
      FDataCommonAreaLogic logic = logicContext.findLogic(FDataCommonAreaLogic.class);
      return logic.fetchAll();
   }
}
