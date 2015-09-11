package org.mo.content.face;

import com.cyou.gccloud.data.data.FDataFinancialDepartmentUnit;
import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.mo.content.core.product.financial.IDepartmentConsole;
import org.mo.core.aop.face.ALink;
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
         InputStream fis = new FileInputStream("D:\\Microbject\\MoScript\\data\\ezubo_department.xls");
         HSSFWorkbook wb = new HSSFWorkbook(fis);
         HSSFSheet s = wb.getSheet("Sheet1");
         int rowLength = s.getLastRowNum() + 1;
         String department = "";
         String temp = "";
         for(int i = 1; i < rowLength; i++){
            HSSFRow row = s.getRow(i);
            if(row != null){
               HSSFCell cell1 = row.getCell(0);
               temp = String.valueOf(cell1.getStringCellValue());
               if(temp.length() > 0){
                  department = temp;
               }
               System.out.println(department + "--");
            }
            FDataFinancialDepartmentUnit unit = new FDataFinancialDepartmentUnit();
            unit.setDepartmentLabel(department);
         }
         System.out.println(s.getLastRowNum());
         //         HSSFRow row = s.getFirstRowNum();
      }catch(Exception e){
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
}
