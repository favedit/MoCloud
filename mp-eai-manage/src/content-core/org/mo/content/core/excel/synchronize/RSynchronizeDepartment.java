package org.mo.content.core.excel.synchronize;

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

//============================================================
// <T>金融客户统计计算器。</T>
//============================================================
public class RSynchronizeDepartment
{

   //用户控制器
   @ALink
   protected static IDepartmentConsole _departmentConsole;

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

         String filePath = "/data/eai/eai.manage/webroot/data/ezubo_department.xls";
         //         String filePath = "D:\\Microbject\\MoScript\\data\\ezubo_department.xls";

         InputStream fis = new FileInputStream(filePath);
         //设置属性
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
               HSSFCell linkIdCell = row.getCell(3);
               HSSFCell provinceCell = row.getCell(4);
               HSSFCell cityCell = row.getCell(5);
               HSSFCell detailCell = row.getCell(6);
               HSSFCell longitudeCell = row.getCell(7);
               HSSFCell latitudeCell = row.getCell(8);
               HSSFCell departmentPhoneCell = row.getCell(9);
               HSSFCell leaderLabelCell = row.getCell(10);
               //生成对象增加数据库
               FDataFinancialDepartmentUnit unit = new FDataFinancialDepartmentUnit();
               unit.setDepartmentLabel(department);
               unit.setRegionLabel(regionCell.getStringCellValue());
               unit.setLinkId(new Long((long)linkIdCell.getNumericCellValue()));
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
