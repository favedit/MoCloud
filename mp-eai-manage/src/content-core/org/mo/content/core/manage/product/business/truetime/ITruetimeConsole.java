package org.mo.content.core.manage.product.business.truetime;

import com.cyou.gccloud.data.data.FDataLogicTruetimeUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.common.FWebUploadFile;
//============================================================
//<P>实时数据信息操作接口</P>
//
//@class ITruetimeConsole
//@version 1.0.0
//============================================================
public interface ITruetimeConsole 
      extends 
         IAbstractLogicUnitConsole<FDataLogicTruetimeUnit> 
{
   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   // @param sqlContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataTruetimeInfo> select(ILogicContext logicContext, 
                                           FDataLogicTruetimeUnit unit, 
                                           int pageNum, 
                                           int pageSize);

   // ============================================================
   // <T>保存图片地址</T>
   // @return void
   // ============================================================
   void saveImage(FWebUploadFile file, 
                  FDataLogicTruetimeUnit unit, 
                  String flag);
}
