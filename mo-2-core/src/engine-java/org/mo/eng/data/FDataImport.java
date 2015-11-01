package org.mo.eng.data;

import org.mo.com.collections.FDataset;
import org.mo.com.collections.FRow;
import org.mo.com.data.ISqlConnection;
import org.mo.com.io.FLinesFile;
import org.mo.com.io.FStringFile;
import org.mo.com.io.RFile;
import org.mo.com.lang.FString;
import org.mo.com.lang.FStrings;
import org.mo.com.lang.RString;

//============================================================
// <T>数据导入器。</T>
//============================================================
public class FDataImport
      extends FDataTransfer
{
   //============================================================
   // <T>构造数据导入器。</T>
   //============================================================
   public FDataImport(){
   }

   //============================================================
   // <T>构造数据导入器。</T>
   //
   // @param connection 数据库链接
   //============================================================
   public FDataImport(ISqlConnection connection){
      super(connection);
   }

   //============================================================
   // <T>构造数据导入器。</T>
   //
   // @param connection 数据库链接
   // @param charset 字符串编码
   //============================================================
   public FDataImport(ISqlConnection connection,
                      String charset){
      super(connection, charset);
   }

   //============================================================
   // <T>构造行命令。</T>
   //
   // @param tableName 表名
   // @param line 行对象
   // @param columns 列集合
   // @return 行命令
   //============================================================
   public String makeRowSql(String tableName,
                            String line,
                            FDataset columns){
      // 检查空行
      if(RString.isEmpty(line)){
         return null;
      }
      // 生成命令
      FRow row = new FRow();
      row.unpack(line);
      FString fields = new FString();
      FString values = new FString();
      for(FRow column : columns){
         //         String columnName = column.get("column_name").toLowerCase();
         //         String columnType = column.get("column_type");
         String columnName = column.get("field").toLowerCase();
         String columnType = column.get("type");
         if(row.contains(columnName)){
            // 增加字段
            if(!fields.isEmpty()){
               fields.append(',');
            }
            fields.append('`');
            fields.append(columnName.toUpperCase());
            fields.append('`');
            // 增加内容
            if(!values.isEmpty()){
               values.append(',');
            }
            String value = row.get(columnName);
            if(RString.isEmpty(value)){
               values.append("NULL");
            }else if(columnType.equals("datetime")){
               values.append("STR_TO_DATE('", value, "','%Y%m%d%H%i%s')");
            }else if(columnType.startsWith("tinyint(") || columnType.startsWith("int(") || columnType.startsWith("bigint")){
               values.append(value);
            }else{
               values.append("'", value, "'");
            }

         }
      }
      // 返回命令
      FString sql = new FString();
      sql.append("INSERT INTO ", tableName, "(", fields, ") VALUES(", values, ");");
      return sql.toString();
   }

   //============================================================
   // <T>执行命令。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public void executeTable(String fileName){
      // 获得列集合
      String tableName = RFile.shortName(fileName);
      FDataset columns = _connection.fetchDataset("SHOW COLUMNS FROM " + tableName);
      // 生成所有命令
      FLinesFile sourceFile = new FLinesFile(fileName, _charset);
      for(String line : sourceFile.lines()){
         if(RString.isEmpty(line)){
            continue;
         }
         String rowSql = makeRowSql(tableName, line, columns);
         _connection.executeSql(rowSql);
      }
   }

   //============================================================
   // <T>目录执行命令。</T>
   //
   // @param directory 目录
   //============================================================
   public void excutePath(String directory){
      FStrings fileNames = RFile.listFiles(directory);
      for(String fileName : fileNames){
         if(RFile.isDirectory(fileName)){
            continue;
         }
         executeTable(fileName);
      }
   }

   //============================================================
   // <T>生成命令。</T>
   //
   // @param fileName 文件名称
   // @param outputFileName 输出文件名称
   //============================================================
   public void makeTableSql(FStringFile outputFile,
                            String fileName,
                            String outputFileName){
      FStringFile file = new FStringFile();
      // 获得列集合
      String tableName = RFile.shortName(fileName);
      FDataset columns = _connection.fetchDataset("SHOW COLUMNS FROM " + tableName);
      // 生成所有命令
      FLinesFile sourceFile = new FLinesFile(fileName);
      FStrings lines = sourceFile.lines();
      if(lines.hasData()){
         outputFile.appendLine("-- Insert table data:" + tableName);
         for(String line : lines){
            if(RString.isEmpty(line)){
               continue;
            }
            String rowSql = makeRowSql(tableName, line, columns);
            file.appendLine(rowSql);
            outputFile.appendLine(rowSql);
         }
         outputFile.appendLine();
         file.saveFile(outputFileName);
      }
   }

   //============================================================
   // <T>目录生成命令。</T>
   //
   // @param directory 目录
   // @param outputDirectory 输出目录
   //============================================================
   public void makePath(String directory,
                        String outputDirectory){
      FStrings fileNames = RFile.listFiles(directory);
      FStringFile file = new FStringFile();
      for(String fileName : fileNames){
         if(RFile.isDirectory(fileName)){
            continue;
         }
         String tableName = RFile.shortName(fileName);
         String outputFileName = outputDirectory + "/" + tableName + ".sql";
         makeTableSql(file, fileName, outputFileName);
      }
      file.saveFile(outputDirectory + "/all.sql");
   }
}
