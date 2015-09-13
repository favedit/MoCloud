package org.mo.content.core.excel.synchronize;

import com.cyou.gccloud.data.data.FDataCommonCityCardUnit;
import com.cyou.gccloud.data.data.FDataCommonCityUnit;
import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.mo.com.lang.FAttributes;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.content.core.product.common.ICityConsole;
import org.mo.content.core.product.common.ICitycardConsole;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.eng.data.IDatabaseConsole;

//============================================================
// <T>同步excel的城市card。</T>
//============================================================
public class RSynchronizeCitycard
{

   @SuppressWarnings("resource")
   public static void main(String[] args){
      try{

         String modeCd = RString.trim(args[0]);
         if(!modeCd.equals("test") && !modeCd.equals("online")){
            throw new FFatalError("Mode type failure.");
         }
         // 设置属性
         FAttributes attributes = RAop.configConsole().defineCollection().attributes();
         attributes.set("application", "/data/eai/eai.manage");
         // 加载配置
         RAop.initialize("/data/eai/eai.manage/webroot/WEB-INF/classes/application-" + modeCd + ".xml");

         String filePath = "/data/eai/eai.manage/webroot/data/card.xls";
         //         String filePath = "D:\\Microbject\\MoScript\\data\\card2.xls";

         InputStream fis = new FileInputStream(filePath);
         //设置属性
         //         FAttributes attributes = RAop.configConsole().defineCollection().attributes();
         //         attributes.set("application", "D:/Microbject/MoCloud/");
         //         RAop.initialize("D:/Microbject/MoCloud/mp-eai-manage/src/config/application-work.xml");

         IDatabaseConsole databaseConsole = RAop.find(IDatabaseConsole.class);
         FLogicContext logicContext = new FLogicContext(databaseConsole);
         //省份
         ICitycardConsole citycardConsole = RAop.find(ICitycardConsole.class);
         //城市
         ICityConsole cityConsole = RAop.find(ICityConsole.class);

         HSSFWorkbook wb = new HSSFWorkbook(fis);
         HSSFSheet s = wb.getSheet("Sheet1");
         int rowLength = s.getLastRowNum() + 1;
         for(int i = 0; i < rowLength; i++){
            HSSFRow row = s.getRow(i + 1);
            if(row != null){
               //获取每一列
               HSSFCell cardCell = row.getCell(0);
               HSSFCell codeCell = row.getCell(1);
               FDataCommonCityUnit cityUnit = cityConsole.findByCitycode(logicContext, codeCell.getStringCellValue());
               if(cityUnit != null){
                  FDataCommonCityCardUnit cardUnit = citycardConsole.doPrepare(logicContext);
                  cardUnit.setCityId(cityUnit.ouid());
                  cardUnit.setCardCode((int)cardCell.getNumericCellValue());
                  citycardConsole.doInsert(logicContext, cardUnit);
               }
            }
         }
      }catch(Exception e){
         e.printStackTrace();
      }
   }
}
