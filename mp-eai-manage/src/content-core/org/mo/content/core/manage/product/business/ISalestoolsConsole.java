package org.mo.content.core.manage.product.business;

import com.cyou.gccloud.data.data.FDataLogicSalestoolsUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.common.FWebUploadFile;

public interface ISalestoolsConsole
      extends
         IAbstractLogicUnitConsole<FDataLogicSalestoolsUnit>
{

   // ============================================================
   // <T>获得分页数据列表</T>
   // @param sqlContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataSalestoolsInfo> select(ILogicContext logicContext,
                                             FDataLogicSalestoolsUnit unit,
                                             int pageNum,
                                             int pageSize);

   // ============================================================
   // <T>保存图片地址</T>
   // @return void
   // ============================================================
   void saveImage(FWebUploadFile file,
                  FDataLogicSalestoolsUnit unit,
                  String flag);
}
