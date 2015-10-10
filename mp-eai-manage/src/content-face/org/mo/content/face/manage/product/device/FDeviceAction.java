package org.mo.content.face.manage.product.device;

import com.cyou.gccloud.data.data.FDataInfoDeviceBrowserUnit;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.manage.product.device.IDeviceBrowserConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <P>接口。</P>
//
// @author sunhr
// @version 150718
//============================================================
public class FDeviceAction implements IDeviceAction {
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FDeviceAction.class);

   // 用户控制台
   @ALink
   protected IDeviceBrowserConsole _deviceBrowserConsole;

   // ============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param page 页面
   // ============================================================
   @Override
   public String construct(IWebContext context, ILogicContext logicContext, FBasePage basePage) {
      _logger.debug(this, "Construct", "Construct begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }

      return "/manage/product/device/BrowserAccessList";
   }

   @Override
   public String select(IWebContext context, ILogicContext logicContext, FDevicePage devicePage, FBasePage basePage) {
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      FLogicDataset<FDataInfoDeviceBrowserUnit> unitlist = _deviceBrowserConsole.select(logicContext);
      basePage.setJson(unitlist.toJsonListString());
      return "/manage/common/ajax";
   }

   @Override
   public String putMobileInfo(IWebContext context, ILogicContext logicContext, FDevicePage page) {
      String agentCode = context.parameter("agentCode");
      if (RString.isEmpty(agentCode)) {
         throw new FFatalError("agentCode is empty.");
         // page.setResult("userAgent is empty!");
      }
      String capability = context.parameter("capability");
      if (RString.isEmpty(capability)) {
         throw new FFatalError("deviceBrowserInfo is empty.");
         // page.setResult("deviceBrowserInfo is empty!");
      }
      FDataInfoDeviceBrowserUnit deviceBrowserInfo = _deviceBrowserConsole.doPrepare(logicContext);
      deviceBrowserInfo.setAgentCode(agentCode);
      deviceBrowserInfo.setContent(capability);
      EResult result = _deviceBrowserConsole.insert(logicContext, deviceBrowserInfo);
      if (result.equals(EResult.Success)) {
         page.setResult("Success");
      } else {
         throw new FFatalError("insert Failure.");
         // page.setResult("Failure");
      }
      return "/";
   }

   @Override
   public String updateBefore(IWebContext context, ILogicContext logicContext, FDevicePage devicePage, FBasePage basePage) {
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataInfoDeviceBrowserUnit unit = _deviceBrowserConsole.find(logicContext, id);
      devicePage.setUnit(unit);
      return "/manage/product/device/BrowserAccessInfo";
   }

   @SuppressWarnings("resource")
   @Override
   public String expend(IWebContext context, ILogicContext logicContext, FDevicePage page, FBasePage basePage) {
      _logger.debug(this, "Expend", "Expend begin.");
      try {
         FLogicDataset<FDataInfoDeviceBrowserUnit> unitlist = _deviceBrowserConsole.select(logicContext);
         // 创建新的Excel工作薄
         HSSFWorkbook workbook = new HSSFWorkbook();
         HSSFSheet sheet = workbook.createSheet("sheet1");
         // 在索引0的位置创建行（最顶端的行）
         String[] headers = new String[] { "头信息", "设备信息" };
         HSSFRow headerRow = sheet.createRow(0);
         HSSFCell cell = headerRow.createCell(0);
         cell.setCellType(XSSFCell.CELL_TYPE_STRING);
         cell.setCellValue(headers[0]);
         HSSFCell cell0 = headerRow.createCell(1);
         cell0.setCellType(XSSFCell.CELL_TYPE_STRING);
         cell0.setCellValue(headers[1]);

         int index = 0;
         for (FDataInfoDeviceBrowserUnit unit : unitlist) {
            index++;
            HSSFRow row = sheet.createRow(index);
            HSSFCell cell1 = row.createCell(0);
            // 定义单元格为字符串类型
            cell1.setCellType(XSSFCell.CELL_TYPE_STRING);
            // 在单元格中输入一些内容
            cell1.setCellValue(unit.agentCode());
            HSSFCell cell2 = row.createCell(1);
            // 定义单元格为字符串类型
            cell2.setCellType(XSSFCell.CELL_TYPE_STRING);
            // 在单元格中输入一些内容
            cell2.setCellValue(unit.content());
         }
         String filePath = "d:/deviceList_" + RDateTime.currentDateTime() + ".xls";
         // 新建文件输出流
         FileOutputStream fOut = new FileOutputStream(filePath);
         // 将数据写入Excel
         workbook.write(fOut);
         fOut.close();
         basePage.ajax(1, filePath);
         _logger.debug(this, "Expend", "Expend succeed. (path={1})", filePath);
      } catch (Exception e) {
         e.printStackTrace();
         basePage.ajax(0, e.getMessage());
         _logger.debug(this, "Expend", "Expend fail. (message={1})", e);
      }
      return "/manage/common/ajax";
   }
}
