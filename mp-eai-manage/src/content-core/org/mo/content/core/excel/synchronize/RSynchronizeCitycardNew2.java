package org.mo.content.core.excel.synchronize;

import com.cyou.gccloud.data.data.FDataCommonCityCardLogic;
import com.cyou.gccloud.data.data.FDataCommonCityCardUnit;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.TreeSet;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.mo.com.lang.FAttributes;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.FLogicDataset;
import org.mo.eng.data.IDatabaseConsole;

//============================================================
// <T>同步excel的城市card。</T>
//============================================================
public class RSynchronizeCitycardNew2 {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        try {
            String filePath = "D:/Microbject/MoCloud/mp-eai-manage/webroot/data/unknown.xls";
            // String filePath = "D:\\Microbject\\MoScript\\data\\card2.xls";

            InputStream fis = new FileInputStream(filePath);
            // 设置属性
            FAttributes attributes = RAop.configConsole().defineCollection()
                    .attributes();
            attributes.set("application", "D:/Microbject/MoCloud/");
            RAop.initialize("D:/Microbject/MoCloud/mp-eai-manage/src/config/application-work.xml");
            IDatabaseConsole databaseConsole = RAop
                    .find(IDatabaseConsole.class);
            FLogicContext logicContext = new FLogicContext(databaseConsole);
            FDataCommonCityCardLogic cityCardLogic = logicContext
                    .findLogic(FDataCommonCityCardLogic.class);
            HSSFWorkbook wb = new HSSFWorkbook(fis);
            HSSFSheet s = wb.getSheet("Sheet1");
            int rowLength = s.getLastRowNum() + 1;
            FLogicDataset<FDataCommonCityCardUnit> allUnits = cityCardLogic
                    .fetchAll();
            // System.out.println("----------->" +
            // allUnits.count());11031TreeSet<String> set = new
            // TreeSet<String>();
            int k = 0;
            TreeSet<String> set = new TreeSet<String>();
            for (int i = 0; i < rowLength; i++) {
                HSSFRow row = s.getRow(i);
                if (row != null) { // 获取每一列
                    HSSFCell cardCell = row.getCell(0);
                    cardCell.setCellType(Cell.CELL_TYPE_STRING);
                    if (cardCell.getStringCellValue().length() > 4) {
                        set.add(cardCell.getStringCellValue().substring(0, 4));
                        // System.out.println(cardCell.getStringCellValue()
                        // .substring(0, 4));
                    }
                }
            }
            for (Iterator iterator = set.iterator(); iterator.hasNext();) {
                String string = (String) iterator.next();
                k++;
                System.out.println(string);
            }
            System.out.println("一共插入-------->" + k);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
