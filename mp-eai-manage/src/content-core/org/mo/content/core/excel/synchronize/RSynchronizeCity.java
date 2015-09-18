package org.mo.content.core.excel.synchronize;

import com.cyou.gccloud.data.data.FDataCommonAreaUnit;
import com.cyou.gccloud.data.data.FDataCommonCityUnit;
import com.cyou.gccloud.data.data.FDataCommonCountryUnit;
import com.cyou.gccloud.data.data.FDataCommonProvinceUnit;
import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.mo.com.lang.FAttributes;
import org.mo.content.core.product.common.IAreaConsole;
import org.mo.content.core.product.common.ICityConsole;
import org.mo.content.core.product.common.ICountryConsole;
import org.mo.content.core.product.common.IProvinceConsole;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.eng.data.IDatabaseConsole;

//============================================================
// <T>同步城市。</T>
//============================================================
public class RSynchronizeCity
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

         //         String filePath = "/data/eai/eai.manage/webroot/data/citys.xls";
         String filePath = "D:\\Microbject\\MoCloud\\mp-eai-manage\\webroot\\data\\citys.xls";

         InputStream fis = new FileInputStream(filePath);
         //         //设置属性
         FAttributes attributes = RAop.configConsole().defineCollection().attributes();
         attributes.set("application", "D:/Microbject/MoCloud/");
         RAop.initialize("D:/Microbject/MoCloud/mp-eai-manage/src/config/application-work.xml");

         IDatabaseConsole databaseConsole = RAop.find(IDatabaseConsole.class);
         FLogicContext logicContext = new FLogicContext(databaseConsole);
         //国家
         ICountryConsole countryConsole = RAop.find(ICountryConsole.class);
         FDataCommonCountryUnit country = countryConsole.doPrepare(logicContext);
         country.setCode("CN");
         country.setName("china");
         country.setLabel("中国");
         countryConsole.doInsert(logicContext, country);
         //地区
         IAreaConsole areaConsole = RAop.find(IAreaConsole.class);
         FDataCommonAreaUnit area = areaConsole.doPrepare(logicContext);
         area.setLabel("华东地区");
         areaConsole.doInsert(logicContext, area);
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
               HSSFCell proCodeCell = row.getCell(0);
               HSSFCell provinceCell = row.getCell(1);
               provinceLabel = provinceCell.getStringCellValue();
               if(i == 0 || !provinceLabel.equals(provinceTemp)){
                  //增加省份
                  FDataCommonProvinceUnit province = new FDataCommonProvinceUnit();
                  provinceTemp = provinceLabel.trim();
                  province.setCountryId(country.ouid());
                  province.setAreaId(area.ouid());
                  province.setCode(proCodeCell.getStringCellValue());
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
               city.setCountryId(country.ouid());
               city.setAreaId(area.ouid());
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
         System.out.println("======================================================同步完成");
      }catch(Exception e){
         e.printStackTrace();
      }
   }
}
