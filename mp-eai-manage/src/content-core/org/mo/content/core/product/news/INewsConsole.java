package org.mo.content.core.product.news;

import com.cyou.gccloud.data.data.FDataLogicNewsUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.common.FWebUploadFile;

public interface INewsConsole extends IAbstractLogicUnitConsole<FDataLogicNewsUnit> {

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   // @param sqlContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataNewsInfo> select(ILogicContext logicContext, FDataLogicNewsUnit unit, int pageNum, int pageSize);

   // ============================================================
   // <T>保存图片地址</T>
   // @return void
   // ============================================================
   void saveImage(FWebUploadFile file, FDataLogicNewsUnit unit);
}
