package org.mo.content.core.product.financial.news;

import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.RString;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

import com.cyou.gccloud.data.data.FDataLogicNewsLogic;
import com.cyou.gccloud.data.data.FDataLogicNewsUnit;

//============================================================
//<P>新闻控制台</P>
//@class FNewsConsole
//@author XIAOHUI ZHANG
//@Date 2015.09.21 
//@version 1.0.0
//============================================================
public class FNewsConsole 
       extends FAbstractLogicUnitConsole<FDataLogicNewsLogic, FDataLogicNewsUnit>
       implements INewsConsole 
{
   
// 每页条数
   static final int _pageSize = 20;
   
   //============================================================
   // <T>构造新闻控制台。</T>
   //============================================================
   public FNewsConsole() {
       super(FDataLogicNewsLogic.class, FDataLogicNewsUnit.class);
   }

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   // @param logicContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataNewsInfo> select(ILogicContext logicContext,
                                                           FDataLogicNewsUnit unit,
                                                           int pageNum,
                                                           int pageSize){
      if(pageNum < 0){
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      if(!RString.isEmpty(unit.label())){
         whereSql.append(FDataLogicNewsLogic.LABEL + " LIKE '%{label}%'");
         whereSql.bind("label", RString.parse(unit.label()));
      }
      FDataLogicNewsLogic logic = logicContext.findLogic(FDataLogicNewsLogic.class);
      FLogicDataset<FDataNewsInfo> moduleList = logic.fetchClass(FDataNewsInfo.class, null, whereSql.toString(), null, pageSize, pageNum);
      return moduleList;
   }
   
}
