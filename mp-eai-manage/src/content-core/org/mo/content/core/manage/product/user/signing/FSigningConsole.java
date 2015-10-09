package org.mo.content.core.manage.product.user.signing;

import com.cyou.gccloud.data.data.FDataPersonUserSigningLogic;
import com.cyou.gccloud.data.data.FDataPersonUserSigningUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.RLong;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
//<P>签到控制台</P>
//@class FNewsConsole
//@author XIAOHUI ZHANG
//@Date 2015.10.09
//@version 1.0.0
//============================================================
public class FSigningConsole extends FAbstractLogicUnitConsole<FDataPersonUserSigningLogic, FDataPersonUserSigningUnit>implements ISigningConsole {

   // 每页条数
   static final int _pageSize = 20;

   // ============================================================
   // <T>构造新闻控制台。</T>
   // ============================================================
   public FSigningConsole() {
      super(FDataPersonUserSigningLogic.class, FDataPersonUserSigningUnit.class);
   }

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   // @param logicContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataPersonUserSigningUnit> select(ILogicContext logicContext, FDataPersonUserSigningUnit unit, int pageNum, int pageSize) {
      if (pageNum < 0) {
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      if (unit.userId() > 0l) {
         whereSql.append(FDataPersonUserSigningLogic.USER_ID + " = '{userId}'");
         whereSql.bind("userId", RLong.parse(unit.userId()) + "");
      }
      FDataPersonUserSigningLogic logic = logicContext.findLogic(FDataPersonUserSigningLogic.class);
      FLogicDataset<FDataPersonUserSigningUnit> moduleList = logic.fetchClass(FDataPersonUserSigningUnit.class, null, whereSql.toString(), null, pageSize, pageNum);
      return moduleList;
   }
}
