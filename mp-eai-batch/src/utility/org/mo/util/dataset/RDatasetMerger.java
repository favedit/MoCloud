package org.mo.util.dataset;

import org.mo.com.io.FLinesFile;
import org.mo.com.io.FStringFile;
import org.mo.com.lang.FAttributes;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.RString;
import org.mo.com.lang.type.TDateTime;

public class RDatasetMerger
{
   public static void main(String[] args){
      String sourcePath = "D:/Microbject/data";
      FLinesFile file1 = new FLinesFile(sourcePath + "/001.txt");
      FLinesFile file2 = new FLinesFile(sourcePath + "/002.txt");
      FDictionary<FAttributes> rows = new FDictionary<FAttributes>(FAttributes.class);
      // 读取用户数字
      for(String line : file1.lines()){
         if((line != null) && line.startsWith("20")){
            String[] items = RString.split(line, '\t');
            if(items.length == 2){
               String itemName = items[0];
               String registerCount = items[1];
               FAttributes row = rows.get(itemName, null);
               if(row == null){
                  row = new FAttributes();
                  rows.set(itemName, row);
               }
               row.set("register_count", registerCount);
            }
         }
      }
      // 读取用户数字
      for(String line : file2.lines()){
         if((line != null) && line.startsWith("20")){
            String[] items = RString.split(line, '\t');
            if(items.length == 3){
               String itemName = items[0];
               String investmentCount = items[1];
               String investmentAmount = items[2];
               FAttributes row = rows.get(itemName, null);
               if(row == null){
                  row = new FAttributes();
                  rows.set(itemName, row);
               }
               row.set("investment_count", investmentCount);
               row.set("investment_amount", investmentAmount);
            }
         }
      }
      // 写出数据
      FStringFile file = new FStringFile();
      TDateTime currentDate = new TDateTime();
      currentDate.parse("20140701", "YYYYMMDD");
      while(true){
         String date = currentDate.format("YYYYMMDD");
         if(date.equals("20150910")){
            break;
         }
         FAttributes row = rows.get(date, null);
         file.append(date);
         if(row != null){
            file.append("\t" + row.get("register_count", "0"));
            file.append("\t" + row.get("investment_count", "0"));
            file.append("\t" + row.get("investment_amount", "0"));
         }else{
            file.append("\t0\t0\t0");
         }
         file.appendLine();
         currentDate.addDay(1);
      }
      file.saveFile("D:/Microbject/data/sum.txt");
      System.out.println("Success.");
   }
}
