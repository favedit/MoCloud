package org.mo.eng.data;

import org.mo.com.collections.FDataset;
import org.mo.com.collections.FRow;
import org.mo.com.data.ISqlConnection;
import org.mo.com.data.RSql;
import org.mo.com.io.FStringFile;
import org.mo.com.lang.FString;
import org.mo.com.lang.IStringPair;
import org.mo.core.aop.RAop;

//============================================================
// <T>数据导出器。</T>
//============================================================
public class FDataExport
      extends FDataTransfer
{
   //============================================================
   // <T>构造数据导出器。</T>
   //============================================================
   public FDataExport(){
   }

   //============================================================
   // <T>构造数据导出器。</T>
   //
   // @param connection 数据库链接
   //============================================================
   public FDataExport(ISqlConnection connection){
      super(connection);
   }

   //============================================================
   // <T>构造数据导出器。</T>
   //
   // @param connection 数据库链接
   // @param charset 字符串编码
   //============================================================
   public FDataExport(ISqlConnection connection,
                      String charset){
      super(connection, charset);
   }

   //============================================================
   // <T>生成表格命令。</T>
   //
   // @param tableName 表名
   // @param outputFileName 输出文件名称
   //============================================================
   public void makeTableSql(String tableName,
                            String outputFileName){
      // 获得列信息
      FDataset columns = _connection.fetchDataset("SHOW COLUMNS FROM " + tableName);
      FString fields = new FString();
      for(FRow column : columns){
         if(!fields.isEmpty()){
            fields.append(",");
         }
         fields.append('`');
         //fields.append(column.get("column_name"));
         fields.append(column.get("field"));
         fields.append('`');
      }
      // 生成查询命令
      FString sql = new FString();
      sql.append("SELECT ", fields, " FROM ", tableName, " ORDER BY OUID");
      // 输出文件
      FStringFile file = new FStringFile();
      FDataset rows = _connection.fetchDataset(sql.toString());
      for(FRow row : rows){
         for(IStringPair pair : row){
            row.set(pair.name(), RSql.formatValue(pair.value()));
         }
         file.appendLine(row.pack());
      }
      file.saveFile(outputFileName, _charset);
   }

   //============================================================
   // <T>生成数据库命令。</T>
   //
   // @param outputDirectory 输出目录
   //============================================================
   public void makeDatabaseSql(String outputDirectory){
      FDataset tables = _connection.fetchDataset("SHOW TABLES");
      for(FRow table : tables){
         String tableName = table.get("table_name");
         makeTableSql(tableName, outputDirectory + "/" + tableName + ".pck");
      }
      RAop.release();
   }
}
