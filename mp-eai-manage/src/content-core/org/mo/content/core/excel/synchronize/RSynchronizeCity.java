package org.mo.content.core.excel.synchronize;

import com.cyou.gccloud.data.data.FDataCommonCityUnit;
import com.cyou.gccloud.data.data.FDataCommonProvinceUnit;
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
import org.mo.content.core.product.common.IProvinceConsole;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.eng.data.IDatabaseConsole;

//============================================================
// <T>金融客户统计计算器。</T>
//============================================================
public class RSynchronizeCity
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

         String filePath = "/data/eai/eai.manage/webroot/data/citys.xls";
         //         String filePath = "D:\\Microbject\\MoScript\\data\\citys2.xls";

         InputStream fis = new FileInputStream(filePath);
         //设置属性
         //         FAttributes attributes = RAop.configConsole().defineCollection().attributes();
         //         attributes.set("application", "D:/Microbject/MoCloud/");
         //         RAop.initialize("D:/Microbject/MoCloud/mp-eai-manage/src/config/application-work.xml");

         IDatabaseConsole databaseConsole = RAop.find(IDatabaseConsole.class);
         FLogicContext logicContext = new FLogicContext(databaseConsole);
         //省份
         IProvinceConsole provinceConsole = RAop.find(IProvinceConsole.class);
         //城市
         ICityConsole cityConsole = RAop.find(ICityConsole.class);

         HSSFWorkbook wb = new HSSFWorkbook(fis);
         HSSFSheet s = wb.getSheet("Sheet1");
         int rowLength = s.getLastRowNum() + 1;
         String provinceLabel = null;
         String provinceTemp = null;
         long provinceId = 0;
         for(int i = 0; i < rowLength; i++){
            HSSFRow row = s.getRow(i + 1);
            if(row != null){
               //获取每一列
               HSSFCell provinceCell = row.getCell(1);
               provinceLabel = provinceCell.getStringCellValue();
               if(i == 0 || !provinceLabel.equals(provinceTemp)){
                  //增加省份
                  FDataCommonProvinceUnit province = new FDataCommonProvinceUnit();
                  provinceTemp = provinceLabel.trim();
                  province.setCountryId(1);
                  province.setAreaId(1);
                  province.setLabel(provinceLabel);
                  provinceConsole.doInsert(logicContext, province);
                  provinceId = province.ouid();
               }

               HSSFCell codeCell = row.getCell(2);
               HSSFCell labelCell = row.getCell(3);
               HSSFCell levelCell = row.getCell(5);
               HSSFCell locationCell = row.getCell(7);

               //增加城市
               FDataCommonCityUnit city = new FDataCommonCityUnit();
               city.setCountryId(1);
               city.setAreaId(1);
               city.setProvinceId(provinceId);
               city.setLabel(labelCell.getStringCellValue());
               city.setCityCode(codeCell.getStringCellValue());
               city.setLevel((int)levelCell.getNumericCellValue());
               String locationstr = locationCell.getStringCellValue();
               String[] locations = locationstr.split(",");
               city.setLocationLongitude(Double.parseDouble(locations[0]));
               city.setLocationLatitude(Double.parseDouble(locations[1]));
               cityConsole.doInsert(logicContext, city);
            }
         }
      }catch(Exception e){
         e.printStackTrace();
      }
   }
}
