package org.mo.content.face;

import com.cyou.gccloud.data.data.FDataFinancialDepartmentUnit;
import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.mo.com.lang.FAttributes;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.content.core.product.financial.department.IDepartmentConsole;
import org.mo.core.aop.RAop;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicContext;
import org.mo.eng.data.IDatabaseConsole;
import org.mo.eng.data.common.ISqlContext;

//============================================================
// <P>首页。</P>
//
// @author maocy
// @version 150427
//============================================================
public class FIndexAction
      implements
         IIndexAction
{
   //用户控制器
   @ALink
   protected static IDepartmentConsole _departmentConsole;

   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param page 页面
   //============================================================
   @Override
   public String construct(ISqlContext context,
                           FIndexPage areaPage){

      return "Index";
   }

   public static void main(String[] args){
      try{

         String modeCd = RString.trim(args[0]);
         if(!modeCd.equals("test") && !modeCd.equals("online")){
            throw new FFatalError("Mode type failure.");
         }
         // 设置属性
         FAttributes attributes = RAop.configConsole().defineCollection().attributes();
         attributes.set("application", "/data/eai/eai.batch");
         // 加载配置
         RAop.initialize("/data/eai/eai.batch/webroot/WEB-INF/classes/application-" + modeCd + ".xml");

         //         String filePath = "D:\\Microbject\\MoScript\\data\\ezubo_department.xls";
         String filePath = "/data/eai/eai.batch/webroot/dataezubo_department.xls";

         InputStream fis = new FileInputStream(filePath);
         // 设置属性
         //         FAttributes attributes = RAop.configConsole().defineCollection().attributes();
         //         attributes.set("application", "D:/Microbject/MoCloud/");
         //         RAop.initialize("D:/Microbject/MoCloud/mp-eai-manage/src/config/application-work.xml");

         IDatabaseConsole databaseConsole = RAop.find(IDatabaseConsole.class);
         FLogicContext logicContext = new FLogicContext(databaseConsole);
         IDepartmentConsole console = RAop.find(IDepartmentConsole.class);

         HSSFWorkbook wb = new HSSFWorkbook(fis);
         HSSFSheet s = wb.getSheet("Sheet1");
         int rowLength = s.getLastRowNum() + 1;
         String department = "";
         String temp = "";
         for(int i = 0; i < rowLength; i++){
            HSSFRow row = s.getRow(i + 2);
            if(row != null){
               //获取每一列
               HSSFCell cell0 = row.getCell(0);
               temp = String.valueOf(cell0.getStringCellValue());
               if(temp.length() > 1){
                  department = temp;
               }
               HSSFCell regionCell = row.getCell(1);
               HSSFCell companCell = row.getCell(2);
               HSSFCell provinceCell = row.getCell(3);
               HSSFCell cityCell = row.getCell(4);
               HSSFCell detailCell = row.getCell(5);
               HSSFCell longitudeCell = row.getCell(6);
               HSSFCell latitudeCell = row.getCell(7);
               HSSFCell departmentPhoneCell = row.getCell(8);
               HSSFCell leaderLabelCell = row.getCell(9);
               //生成对象增加数据库
               FDataFinancialDepartmentUnit unit = new FDataFinancialDepartmentUnit();
               unit.setDepartmentLabel(department);
               unit.setRegionLabel(regionCell.getStringCellValue());
               unit.setLabel(companCell.getStringCellValue());
               unit.setProvinceLabel(provinceCell.getStringCellValue());
               unit.setCityLabel(cityCell.getStringCellValue());
               unit.setDetailAddress(detailCell.getStringCellValue());
               unit.setLocationLongitude(longitudeCell != null ? longitudeCell.getNumericCellValue() : 0.00);
               unit.setLocationLatitude(latitudeCell != null ? latitudeCell.getNumericCellValue() : 0.00);
               unit.setDepartmentPhone(String.valueOf(departmentPhoneCell.getStringCellValue()));
               unit.setLeaderLabel(leaderLabelCell.getStringCellValue());
               console.doInsert(logicContext, unit);
            }
         }
      }catch(Exception e){
         e.printStackTrace();
      }
   }
}
