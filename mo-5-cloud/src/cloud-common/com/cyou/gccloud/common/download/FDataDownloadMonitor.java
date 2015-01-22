package com.cyou.gccloud.common.download;

import com.cyou.gccloud.data.data.FDataBatchDownloadLogic;
import com.cyou.gccloud.data.data.FDataBatchDownloadUnit;
import com.cyou.gccloud.data.data.FDataResourceResourceLogic;
import com.cyou.gccloud.data.data.FDataResourceResourceUnit;
import com.cyou.gccloud.define.enums.core.EGcBatchDownloadStatus;
import com.cyou.gccloud.define.enums.core.EGcBatchStorageStatus;
import com.cyou.gccloud.define.enums.core.EGcResourceDeploy;
import org.mo.com.lang.FString;
import org.mo.core.monitor.common.FAbstractMonitor;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.data.IDatabaseConsole;

public class FDataDownloadMonitor
      extends FAbstractMonitor
{
   private IDatabaseConsole _databaseConsole;

   protected ILogicContext _logicContext;

   public FDataDownloadMonitor(){
      _name = "download.monitorr";
      _interval = 1000 * 60;
      _valid = true;
   }

   public void setDatabaseConsole(IDatabaseConsole console){
      _databaseConsole = console;
   }

   @Override
   public void initialize(){
      _logicContext = new FLogicContext(_databaseConsole);
      tick();
      super.initialize();
   }

   @Override
   public boolean onExecute(){
      tick();
      return super.onExecute();
   }

   private void tick(){
      FDataBatchDownloadLogic downloadLogic = new FDataBatchDownloadLogic(_logicContext);
      //检查下载完成的应用信息
      FString batchSql = new FString();
      batchSql.append(" (OVLD = 1) ");
      FLogicDataset<FDataBatchDownloadUnit> units = downloadLogic.fetch(batchSql.toString(), -1, 0);
      //更新设置资源部署状态为完成状态
      FDataResourceResourceLogic resouceLogic = new FDataResourceResourceLogic(_logicContext);
      //查询下载表中的合法数据（OVLD = 1）,按照下载成功失败分组，如果下载失败设置资源状态为 下载失败，更新下载表数据为OVLD = 0
      //如果下载成功，则判断是否部署成功，部署成功则更新资源状态为部署完成，失败则更新资源为部署失败，更新下载表数据为  OVLD = 0
      //当查询下载表中OVLD=1的数据中含有正在下载和准备下载的数据，这中数据不在更新范围内
      for(FDataBatchDownloadUnit unit : units){
         //下载状态为完成
         if(unit.statusCd() == EGcBatchDownloadStatus.Finish){
            //获得下载表中对应资源准备更新
            long resourceId = unit.linkId();
            FDataResourceResourceUnit applicationUnit = resouceLogic.find(resourceId);
            //如果下载表部署状态为成功，更新资源表为完成
            if(unit.storageStatusCd() == EGcBatchStorageStatus.Success){
               applicationUnit.setResourceDeployCd(EGcResourceDeploy.Complete);
            }else if(unit.storageStatusCd() == EGcBatchStorageStatus.Failure){
               //如果下载表部署状态为失败，更新资源表为部署 失败
               applicationUnit.setResourceDeployCd(EGcResourceDeploy.DeployFailure);
            }
            //更新当前下载表中数据，标记OVLD=0
            unit.setOvld(false);
            downloadLogic.doUpdate(unit, unit.ouid());
            //更新资源数据
            resouceLogic.doUpdate(applicationUnit, applicationUnit.ouid());
         }else if(unit.statusCd() == EGcBatchDownloadStatus.Failure){
            //下载状态为失败
            //获得下载表中对应资源准备更新
            long resourceId = unit.linkId();
            FDataResourceResourceUnit applicationUnit = resouceLogic.find(resourceId);
            //设置资源部署状态为下载失败
            applicationUnit.setResourceDeployCd(EGcResourceDeploy.DownloadFailure);
            //更新当前下载表中数据，标记OVLD=0
            unit.setOvld(false);
            downloadLogic.doUpdate(unit, unit.ouid());
            //更新资源数据
            resouceLogic.doUpdate(applicationUnit, applicationUnit.ouid());
         }
      }
   }
}
