package org.mo.content.core.manage.product.common;

import com.cyou.gccloud.data.data.FDataCommonAreaUnit;
import com.cyou.gccloud.data.data.FDataCommonCountryUnit;
import com.cyou.gccloud.data.data.FDataCommonProvinceLogic;
import com.cyou.gccloud.data.data.FDataCommonProvinceUnit;

import java.util.Iterator;

import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.RString;
import org.mo.core.aop.face.ALink;
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
//@version 1.0.0
//============================================================

public class FProvinceConsole 
      extends 
         FAbstractLogicUnitConsole<FDataCommonProvinceLogic, FDataCommonProvinceUnit>
      implements 
         IProvinceConsole 
{

   // 国家控制台
   @ALink
   protected ICountryConsole _countryConsole;

   // 区域控制台
   @ALink
   protected IAreaConsole _areaConsole;
   
   // 每页条数
   static final int _pageSize = 20;

   // ============================================================
   // <T>构造设备控制台。</T>
   // ============================================================

   public FProvinceConsole() {
      super(FDataCommonProvinceLogic.class, FDataCommonProvinceUnit.class);
   }

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   // @param logicContext 链接对象
   // @param unit 查询条件
   // @param pageNum 页码
   // @param pageSize 页大小
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataProvinceInfo> select(ILogicContext logicContext, 
                                                  FDataCommonProvinceUnit unit, 
                                                  int pageNum, 
                                                  int pageSize) {
      if (pageNum < 0) {
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      if (!RString.isEmpty(unit.label())) {
         whereSql.append(FDataCommonProvinceLogic.LABEL);
         whereSql.append(" like ");
         whereSql.append(" '%{label}%'");
         whereSql.bind("label", unit.label());
      }
      FDataCommonProvinceLogic logic = logicContext.findLogic(FDataCommonProvinceLogic.class);
      FLogicDataset<FDataProvinceInfo> userInfoList = logic.fetchClass(FDataProvinceInfo.class, null, whereSql.toString(), null, pageSize, pageNum);
      for (Iterator<FDataProvinceInfo> iterator = userInfoList.iterator(); iterator.hasNext();) {
         FDataProvinceInfo tempUnit = iterator.next();
         FDataCommonCountryUnit unit2 = _countryConsole.find(logicContext, tempUnit.countryId());
         if (unit2 != null) {
            String _countryLabel = unit2.name();
            tempUnit.setCountryLabel(_countryLabel);
         }
         FDataCommonAreaUnit unit3 = _areaConsole.find(logicContext, tempUnit.areaId());
         if (unit3 != null) {
            String _areaLabel = unit3.label();
            tempUnit.setAreaLabel(_areaLabel);
         }
      }
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
                                             String code) {
      FSql whereSql = new FSql();
      if (!RString.isEmpty(code)) {
         whereSql.append(FDataCommonProvinceLogic.CODE);
         whereSql.append(" = ");
         whereSql.append(" {code}");
         whereSql.bind("code", RString.parse(code));
      }
      FDataCommonProvinceLogic logic = logicContext.findLogic(FDataCommonProvinceLogic.class);
      FLogicDataset<FDataCommonProvinceUnit> roleList = logic.fetch(whereSql.toString());
      return roleList.first();
   }

   @Override
   public FDataCommonProvinceUnit findByLabel(FLogicContext logicContext, 
                                              String provinceLabel) {
      return null;
   }

   // ============================================================
   // <T>根据标签获取对象</T>
   // @param logicContext 链接对象
   // @param label 标签
   // @return 数据对象
   // ============================================================
   @Override
   public FDataCommonProvinceUnit findByProvinceLabel(ILogicContext logicContext, 
                                                      String label) {
      FSql whereSql = new FSql();
      if (!RString.isEmpty(label)) {
         whereSql.append(FDataCommonProvinceLogic.LABEL);
         whereSql.append(" like ");
         whereSql.append(" '%{label}%'");
         whereSql.bind("label", label);
      }
      FDataCommonProvinceLogic logic = logicContext.findLogic(FDataCommonProvinceLogic.class);
      FLogicDataset<FDataCommonProvinceUnit> roleList = logic.fetch(whereSql.toString());
      return roleList.first();
   }

   // ============================================================
   // <T>根据标签,区域id,国家id,判读数据库中是否已存在</T>
   // @param logicContext 链接对象
   // @param label 标签
   // @return boolean
   // ============================================================
   @Override
   public boolean isExistsByLabelandAIdandCId(ILogicContext logicContext, 
                                              String proviceLabel, 
                                              Long areaId, 
                                              Long countryId) {
      FSql whereSql = new FSql();
      if (!RString.isEmpty(proviceLabel) && !RString.isEmpty(countryId + "") && !RString.isEmpty(areaId + "")) {
         whereSql.append(FDataCommonProvinceLogic.LABEL);
         whereSql.append(" like ");
         whereSql.append(" '%{label}%'");
         whereSql.bind("label", proviceLabel);
         whereSql.append(" and ");
         whereSql.append(FDataCommonProvinceLogic.COUNTRY_ID);
         whereSql.append(" = ");
         whereSql.append(" {countryId}");
         whereSql.bind("countryId", RString.parse(countryId));
         whereSql.append(" and ");
         whereSql.append(FDataCommonProvinceLogic.AREA_ID);
         whereSql.append(" = ");
         whereSql.append(" {areaId}");
         whereSql.bind("areaId", RString.parse(areaId));
         FDataCommonProvinceLogic logic = logicContext.findLogic(FDataCommonProvinceLogic.class);
         FLogicDataset<FDataCommonProvinceUnit> provinceList = logic.fetch(whereSql.toString());
         if (provinceList.count() > 0) {
            return true;
         }
      }
      return false;
   }
   
   // ============================================================
   // <T>根据标签,区域id,国家id,ouid判读数据库中是否已重复</T>
   // @param logicContext 链接对象
   // @param label 标签
   // @return boolean
   // ============================================================
   @Override
   public boolean isExistsByLabelandAIdandCIdandOuid(ILogicContext logicContext, 
                                                     String proviceLabel, 
                                                     Long areaId, 
                                                     Long countryId,
                                                     Long ouid) {
      FSql whereSql = new FSql();
      if (!RString.isEmpty(proviceLabel) && !RString.isEmpty(countryId + "") && !RString.isEmpty(areaId + "")) {
         whereSql.append(FDataCommonProvinceLogic.LABEL);
         whereSql.append(" like ");
         whereSql.append(" '%{label}%'");
         whereSql.bind("label", proviceLabel);
         whereSql.append(" and ");
         whereSql.append(FDataCommonProvinceLogic.COUNTRY_ID);
         whereSql.append(" = ");
         whereSql.append(" {countryId}");
         whereSql.bind("countryId", RString.parse(countryId));
         whereSql.append(" and ");
         whereSql.append(FDataCommonProvinceLogic.AREA_ID);
         whereSql.append(" = ");
         whereSql.append(" {areaId}");
         whereSql.bind("areaId", RString.parse(areaId));
         FDataCommonProvinceLogic logic = logicContext.findLogic(FDataCommonProvinceLogic.class);
         FLogicDataset<FDataCommonProvinceUnit> provinceList = logic.fetch(whereSql.toString());
         for(Iterator<FDataCommonProvinceUnit> iter = provinceList.iterator();iter.hasNext();){
            FDataCommonProvinceUnit unit = iter.next();
            if(!RString.equals(unit.ouid(), ouid)){
               return true;
            }
         }
      }
      return false;
   }
   // ============================================================
   // <T>根据区域id获取对象列表</T>
   // @param logicContext 链接对象
   // @param label 标签
   // @return 数据对象
   // ============================================================
   @Override
   public FLogicDataset<FDataCommonProvinceUnit> selectAll(ILogicContext logicContext, 
                                                       Long areaId) {
      FSql whereSql = new FSql();
      if (!RString.isEmpty(areaId + "") && areaId > 0) {
         whereSql.append(FDataCommonProvinceLogic.AREA_ID);
         whereSql.append(" = ");
         whereSql.append(" {areaId}");
         whereSql.bind("areaId", RString.parse(areaId));
         FDataCommonProvinceLogic logic = logicContext.findLogic(FDataCommonProvinceLogic.class);
         return logic.fetch(whereSql.toString());
      }
      FDataCommonProvinceLogic logic = logicContext.findLogic(FDataCommonProvinceLogic.class);
      return logic.fetchAll();
   }
}
