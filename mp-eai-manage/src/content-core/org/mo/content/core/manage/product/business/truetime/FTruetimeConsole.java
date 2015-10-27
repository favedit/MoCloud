package org.mo.content.core.manage.product.business.truetime;

import com.cyou.gccloud.data.data.FDataLogicTruetimeLogic;
import com.cyou.gccloud.data.data.FDataLogicTruetimeUnit;
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
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.RString;
import org.mo.com.lang.type.TDateTime;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.common.FWebUploadFile;

//============================================================
//<P>实时数据制台</P>
//@class FTruetimeConsole
//@author XIAOHUI ZHANG
//@version 1.0.0
//============================================================
public class FTruetimeConsole
      extends FAbstractLogicUnitConsole<FDataLogicTruetimeLogic, FDataLogicTruetimeUnit>
      implements
         ITruetimeConsole
{

   // 每页条数
   static final int _pageSize = 20;

   // 应用名称
   @AProperty
   protected String _applicationName;

   // 服务器地址
   @AProperty
   protected String _servers;

   // 图片保存的位置
   private final static String folderPath = "/webroot/manage/images/truetimeImages/";

   // 页面图片引用的路径
   private final static String imageFolderPath = "/manage/images/truetimeImages/";

   // http协议头
   private final static String serverHeader = "http://";

   // 存储服务器
   @ALink
   protected IGcStorageConsole _storageConsole;

   // ============================================================
   // <T>构造新闻控制台。</T>
   // ============================================================
   public FTruetimeConsole(){
      super(FDataLogicTruetimeLogic.class, FDataLogicTruetimeUnit.class);
   }

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   // @param logicContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataTruetimeInfo> select(ILogicContext logicContext,
                                                  FDataLogicTruetimeUnit unit,
                                                  int pageNum,
                                                  int pageSize){
      if(pageNum < 0){
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      if(!RString.isEmpty(unit.label())){
         whereSql.append(FDataLogicTruetimeLogic.LABEL + " LIKE '%{label}%'");
         whereSql.bind("label", RString.parse(unit.label()));
      }
      String orderBy = String.format("%s %s, %s %s", FDataLogicTruetimeLogic.DISPLAY_ORDER, "DESC", FDataLogicTruetimeLogic.CREATE_DATE, "DESC");
      FDataLogicTruetimeLogic logic = logicContext.findLogic(FDataLogicTruetimeLogic.class);
      FLogicDataset<FDataTruetimeInfo> moduleList = logic.fetchClass(FDataTruetimeInfo.class, null, whereSql.toString(), orderBy, pageSize, pageNum);
      for(Iterator<FDataTruetimeInfo> ite = moduleList.iterator(); ite.hasNext();){
         FDataTruetimeInfo info = ite.next();
         info.setStatusCdStr(EGcResourceStatus.formatLabel(info.statusCd()));
         info.setDisplayCdStr(EGcDisplay.formatLabel(info.displayCd()));
         info.setLinkCdStr(EGcLink.formatLabel(info.linkCd()));
         //         info.setIconUrl(_storageConsole.makeUrl(unit.iconUrl()));
      }
      return moduleList;
   }

   // ============================================================
   // <T>保存图片</T>
   // @param logicContext 链接对象
   // @param unit 保存的数据
   // @param flag 标志
   // @return void
   // ============================================================
   @Override
   public void saveImage(FWebUploadFile file,
                         FDataLogicTruetimeUnit unit,
                         String flag){
      FileInputStream fi;
      FileOutputStream fo;
      try{
         if("1".equals(flag)){
            if(!RString.isEmpty(unit.iconUrl())){
               int ind = unit.iconUrl().indexOf("truetimeImages/");
               String fileName = unit.iconUrl().substring(ind + 15, unit.iconUrl().length());
               File f = new File(_applicationName + folderPath + fileName);
               if(f.exists()){
                  f.delete();
               }
            }
         }
         File fil = new File(_applicationName + folderPath);
         if(!fil.isDirectory()){
            fil.mkdir();
         }
         String contentType = file.contentType();
         String fileName = "truetimeImageShow" + new TDateTime(new Date()).format() + "." + contentType.substring(6, contentType.length());
         String uploadName = file.uploadName();
         fi = new FileInputStream(uploadName);
         fo = new FileOutputStream(_applicationName + folderPath + fileName);
         int len = 0;
         byte[] buffer = new byte[1024];
         while((len = fi.read(buffer)) != -1){
            fo.write(buffer, 0, len);
         }
         fo.close();
         fi.close();
         unit.setIconUrl(serverHeader + _servers + imageFolderPath + fileName);
      }catch(FileNotFoundException e){
         e.printStackTrace();
      }catch(IOException e){
         e.printStackTrace();
      }
   }
}
