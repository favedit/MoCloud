package org.mo.content.core.manage.product.examine.business.salestools;

import com.cyou.gccloud.data.data.FDataLogicNewsLogic;
import com.cyou.gccloud.data.data.FDataLogicSalestoolsLogic;
import com.cyou.gccloud.data.data.FDataLogicSalestoolsUnit;
import com.cyou.gccloud.define.enums.common.EGcDisplay;
import com.cyou.gccloud.define.enums.core.EGcLink;
import com.cyou.gccloud.define.enums.core.EGcResourceStatus;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.RString;
import org.mo.com.lang.type.TDateTime;
import org.mo.core.aop.face.AProperty;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.common.FWebUploadFile;

//============================================================
//<P>销售工具控制台</P>
//@class FSalestoolsConsole
//@author XIAOHUI ZHANG
//@Date 2015.10.10
//@version 1.0.0
//============================================================
public class FSalestoolsConsole extends FAbstractLogicUnitConsole<FDataLogicSalestoolsLogic, FDataLogicSalestoolsUnit>implements ISalestoolsConsole {

   // 每页条数
   static final int _pageSize = 20;
   // 应用名称
   @AProperty
   protected String _applicationName;
   // 服务器地址
   @AProperty
   protected String _servers;
   // 图片保存的位置
   private final static String folderPath = "/webroot/manage/images/salestoolsImages/";
   // 页面图片引用的路径
   private final static String imageFolderPath = "/manage/images/salestoolsImages/";
   // http协议头
   private final static String serverHeader = "http://";

   // ============================================================
   // <T>构造新闻控制台。</T>
   // ============================================================
   public FSalestoolsConsole() {
      super(FDataLogicSalestoolsLogic.class, FDataLogicSalestoolsUnit.class);
   }

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   // @param logicContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataSalestoolsInfo> select(ILogicContext logicContext, FDataLogicSalestoolsUnit unit, int pageNum, int pageSize) {
      if (pageNum < 0) {
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      whereSql.append(FDataLogicNewsLogic.STATUS_CD + " = '{statusCd}'");
      whereSql.bind("statusCd", EGcResourceStatus.Apply + "");// 只查询状态为申请
      if (!RString.isEmpty(unit.label())) {
         whereSql.append(FDataLogicSalestoolsLogic.LABEL + " LIKE '%{label}%'");
         whereSql.bind("label", RString.parse(unit.label()));
      }
      FDataLogicSalestoolsLogic logic = logicContext.findLogic(FDataLogicSalestoolsLogic.class);
      FLogicDataset<FDataSalestoolsInfo> moduleList = logic.fetchClass(FDataSalestoolsInfo.class, null, whereSql.toString(), null, pageSize, pageNum);
      for (Iterator<FDataSalestoolsInfo> ite = moduleList.iterator(); ite.hasNext();) {
         FDataSalestoolsInfo info = ite.next();
         if (RString.equals(EGcResourceStatus.Apply, info.statusCd())) {
            info.setStatusCdStr(EGcResourceStatus.ApplyLabel);
         }
         if (RString.equals(EGcResourceStatus.Publish, info.statusCd())) {
            info.setStatusCdStr(EGcResourceStatus.PublishLabel);
         }
         if (RString.equals(EGcResourceStatus.CheckFail, info.statusCd())) {
            info.setStatusCdStr(EGcResourceStatus.CheckFailLabel);
         }
         if (RString.equals(EGcDisplay.Disable, info.displayCd())) {
            info.setDisplayCdStr(EGcDisplay.DisableLabel);
         }
         if (RString.equals(EGcDisplay.Enabled, info.displayCd())) {
            info.setDisplayCdStr(EGcDisplay.EnabledLabel);
         }
         if (RString.equals(EGcLink.Unknown, info.linkCd())) {
            info.setLinkCdStr(EGcLink.UnknownLabel);
         }
         if (RString.equals(EGcLink.Content, info.linkCd())) {
            info.setLinkCdStr(EGcLink.ContentLabel);
         }
         if (RString.equals(EGcLink.Link, info.linkCd())) {
            info.setLinkCdStr(EGcLink.LinkLabel);
         }
      }
      return moduleList;
   }

   @Override
   public void saveImage(FWebUploadFile file, FDataLogicSalestoolsUnit unit, String flag) {
      FileInputStream fi;
      FileOutputStream fo;
      try {
         if ("1".equals(flag)) {
            if (!RString.isEmpty(unit.iconUrl())) {
               int ind = unit.iconUrl().indexOf("salestoolsImages/");
               String fileName = unit.iconUrl().substring(ind + 17, unit.iconUrl().length());
               File f = new File(_applicationName + folderPath + fileName);
               if (f.exists()) {
                  f.delete();
               }
            }
         }
         File fil = new File(_applicationName + folderPath);
         if (!fil.isDirectory()) {
            fil.mkdir();
         }
         String contentType = file.contentType();
         int ind = file.fileName().indexOf(".");
         String fileName = file.fileName().substring(0, ind) + new TDateTime(new Date()).format() + "." + contentType.substring(6, contentType.length());
         String uploadName = file.uploadName();
         fi = new FileInputStream(uploadName);
         fo = new FileOutputStream(_applicationName + folderPath + fileName);
         int len = 0;
         byte[] buffer = new byte[1024];
         while ((len = fi.read(buffer)) != -1) {
            fo.write(buffer, 0, len);
         }
         fo.close();
         fi.close();
         unit.setIconUrl(serverHeader + _servers + imageFolderPath + fileName);//
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
