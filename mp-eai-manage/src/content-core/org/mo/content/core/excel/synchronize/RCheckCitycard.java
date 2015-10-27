package org.mo.content.core.excel.synchronize;

import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.mo.com.lang.FAttributes;
import org.mo.content.core.manage.product.common.ICityConsole;
import org.mo.content.core.manage.product.common.ICitycardConsole;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.eng.data.IDatabaseConsole;

//============================================================
// <T>同步excel的城市card。</T>
//============================================================
public class RCheckCitycard
{

   @SuppressWarnings("resource")
   public static void main(String[] args){
      try{

         //         String modeCd = RString.trim(args[0]);
         //         if(!modeCd.equals("test") && !modeCd.equals("online")){
         //            throw new FFatalError("Mode type failure.");
         //         }
         //         // 设置属性
         //         FAttributes attributes = RAop.configConsole().defineCollection().attributes();
         //         attributes.set("application", "/data/eai/eai.manage");
         //         // 加载配置
         //         RAop.initialize("/data/eai/eai.manage/webroot/WEB-INF/classes/application-" + modeCd + ".xml");

         //String filePath = "/data/eai/eai.manage/webroot/data/card.xls";
         String filePath = "D:/Microbject/MoCloud/mp-eai-manage/webroot/data/card1.xls";
         //         String filePath = "D:\\Microbject\\MoScript\\data\\card2.xls";

         InputStream fis = new FileInputStream(filePath);
         //设置属性
         FAttributes attributes = RAop.configConsole().defineCollection().attributes();
         attributes.set("application", "D:/Microbject/MoCloud/");
         RAop.initialize("D:/Microbject/MoCloud/mp-eai-manage/src/config/application-work.xml");

         IDatabaseConsole databaseConsole = RAop.find(IDatabaseConsole.class);
         FLogicContext logicContext = new FLogicContext(databaseConsole);
         //省份
         ICitycardConsole citycardConsole = RAop.find(ICitycardConsole.class);
         //城市
         ICityConsole cityConsole = RAop.find(ICityConsole.class);

         HSSFWorkbook wb = new HSSFWorkbook(fis);
         HSSFSheet s = wb.getSheet("Sheet1");
         int rowLength = s.getLastRowNum() + 1;
         StringBuffer sb = new StringBuffer();
         for(int i = 0; i < rowLength; i++){
            HSSFRow row = s.getRow(i + 1);
            if(row != null){
               //获取每一列
               HSSFCell cardCell = row.getCell(0);
               int card = (int)cardCell.getNumericCellValue();
               boolean exists = citycardConsole.isExsitsByCardcodeandByCityId(logicContext, null, card);
               if(!exists){
                  //                  System.out.println(card);
                  sb.append(card).append(",");
               }
            }
         }
         int count = 0;
         String[] result = sb.toString().split(",");
         for(int i = 0; i < result.length; i++){
            count++;
            System.out.println(result[i]);
         }
         System.out.println(count + "******");
      }catch(Exception e){
         e.printStackTrace();
      }
   }
}
