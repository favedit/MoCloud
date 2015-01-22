package org.mo.content.core.database;

import org.mo.com.collections.FDataset;
import org.mo.com.lang.EResult;
import org.mo.eng.data.common.ISqlContext;

//============================================================
// <T>数据控制台接口。</T>
//============================================================
public interface IGcDatabaseConsole
{
   //============================================================
   // <T>导出数据库数据。</T>
   //
   // @param sqlContext 数据环境
   // @return 处理结果
   //============================================================
   EResult export(ISqlContext sqlContext);

   //============================================================
   // <T>获得数据库描述。</T>
   //
   // @param sqlContext 数据环境
   // @return 处理结果
   //============================================================
   FDataset fetch();
}
