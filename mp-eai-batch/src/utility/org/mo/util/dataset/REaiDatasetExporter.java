package org.mo.util.dataset;

import org.mo.com.collections.FDataset;
import org.mo.com.collections.FRow;
import org.mo.com.data.ISqlConnection;
import org.mo.core.aop.RAop;
import org.mo.eng.data.IDatabaseConsole;
import org.mo.mime.csv.FCsvFile;
import org.mo.mime.csv.FCsvLine;

public class REaiDatasetExporter
{
   public static void main(String[] args){
      String targetPath = "/data/eai/data";
      RAop.configConsole().defineCollection().attributes().set("application", "/data/eai/eai.batch");
      RAop.initialize("/data/eai/eai.batch/webroot/WEB-INF/classes/application-online.xml");
      IDatabaseConsole databaseConsole = RAop.find(IDatabaseConsole.class);
      ISqlConnection connection = databaseConsole.alloc("ezubao");
      FDataset tableDataset = connection.fetchDataset("SHOW TABLES");
      for(FRow tableRow : tableDataset){
         FCsvFile file = new FCsvFile();
         // 创建表名
         String tableName = tableRow.value(0);
         FCsvLine line = new FCsvLine();
         line.push(tableName);
         file.lines().push(line);
         file.lines().push(new FCsvLine());
         // 创建列名
         FDataset columnsDataset = connection.fetchDataset("SHOW FULL COLUMNS FROM " + tableName);
         for(FRow columnRow : columnsDataset){
            String fieldName = columnRow.get("column_name");
            String fieldType = columnRow.get("column_type");
            String fieldKey = columnRow.get("column_key");
            String fieldNull = columnRow.get("is_nullable");
            String fieldDefault = columnRow.get("column_default");
            String fieldExtra = columnRow.get("extra");
            String fieldComment = columnRow.get("column_comment");
            //String fieldCoollation = columnRow.get("collation_name");
            //String fieldPrivileges = columnRow.get("privileges");
            //file.columns().set(name, value);
            // 创建行对象
            FCsvLine fieldLine = new FCsvLine();
            fieldLine.push(fieldName);
            fieldLine.push(fieldType);
            fieldLine.push(fieldKey);
            fieldLine.push(fieldNull);
            fieldLine.push(fieldDefault);
            fieldLine.push(fieldExtra);
            fieldLine.push(fieldComment);
            //fieldLine.push(fieldCoollation);
            file.lines().push(fieldLine);
         }
         file.lines().push(new FCsvLine());
         // 创建记录(10条)
         FDataset dataDataset = connection.fetchDataset("SELECT * FROM " + tableName + " LIMIT 10");
         FCsvLine headLine = new FCsvLine();
         for(FRow columnRow : columnsDataset){
            String fieldName = columnRow.get("column_name");
            headLine.push(fieldName);
         }
         file.lines().push(headLine);
         for(FRow dataRow : dataDataset){
            FCsvLine dataLine = new FCsvLine();
            for(FRow columnRow : columnsDataset){
               String fieldName = columnRow.get("column_name");
               String dataValue = dataRow.get(fieldName.toLowerCase());
               dataLine.push(dataValue);
            }
            file.lines().push(dataLine);
         }
         // 获得记录
         file.saveFile(targetPath + "/" + tableName + ".csv", "gb2312");
      }
   }
}
