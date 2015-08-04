package com.ahyc.eai.batch.common;

import com.cyou.gccloud.data.statistics.FStatisticsControllerLogic;
import com.cyou.gccloud.data.statistics.FStatisticsControllerUnit;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.data.logic.FLogicContext;

//============================================================
// <T>统计计算器。</T>
//============================================================
public class FStatisticsCalculater
      extends FObject
{
   // 处理代码
   protected String _processCode;

   // 控制单元
   protected FStatisticsControllerUnit _controllerUnit;

   // 处理总数
   protected long _processTotal;

   // 处理次数
   protected long _processCount;

   //============================================================
   // <T>获得处理总数。</T>
   //============================================================
   public long processTotal(){
      return _processTotal;
   }

   //============================================================
   // <T>获得处理次数。</T>
   //============================================================
   public long processCount(){
      return _processCount;
   }

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param logicContext 逻辑环境
   //============================================================
   public void processOnce(){
      _processTotal++;
      _processCount++;
   }

   //============================================================
   // <T>开始处理。</T>
   //
   // @param logicContext 逻辑环境
   //============================================================
   public void processBegin(FLogicContext logicContext){
      _processCount = 0;
   }

   //============================================================
   // <T>逻辑准备。</T>
   //
   // @param logicContext 逻辑环境
   //============================================================
   public void processPrepare(FLogicContext logicContext){
   }

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param logicContext 逻辑环境
   //============================================================
   public void processLogic(FLogicContext logicContext){
   }

   //============================================================
   // <T>结束处理。</T>
   //
   // @param logicContext 逻辑环境
   //============================================================
   public void processEnd(FLogicContext logicContext){
   }

   //============================================================
   // <T>查找统计控制单元。</T>
   //============================================================
   public FStatisticsControllerUnit controllerFind(FLogicContext logicContext){
      FStatisticsControllerLogic logic = logicContext.findLogic(FStatisticsControllerLogic.class);
      FStatisticsControllerUnit unit = logic.search("CODE='" + _processCode + "'");
      if(unit == null){
         // 创建对象
         unit = logic.doPrepare();
         unit.setCode(_processCode);
         unit.setIsValid(true);
         unit.setProcessClass(getClass().getCanonicalName());
         logic.doInsert(unit);
         // 查找对象
         unit = logic.search("CODE='" + _processCode + "'");
      }
      return unit;
   }

   //============================================================
   // <T>更新统计控制单元。</T>
   //============================================================
   public void controllerUpdate(FLogicContext logicContext,
                                FStatisticsControllerUnit unit){
      FStatisticsControllerLogic logic = logicContext.findLogic(FStatisticsControllerLogic.class);
      unit.setProcessCount(unit.processCount() + 1);
      unit.setProcessUnitTotal((int)(unit.processUnitTotal() + _processCount));
      unit.setProcessUnitCount((int)_processCount);
      logic.doUpdate(unit);
   }

   //============================================================
   // <T>逻辑处理。</T>
   //============================================================
   public boolean process(FLogicContext logicContext){
      if(RString.isEmpty(_processCode)){
         // 处理逻辑
         processBegin(logicContext);
         processLogic(logicContext);
         processEnd(logicContext);
      }else{
         FStatisticsControllerUnit controllerUnit = _controllerUnit = controllerFind(logicContext);
         if(controllerUnit.isValid()){
            // 处理逻辑
            processBegin(logicContext);
            try{
               processLogic(logicContext);
            }catch(Exception error){
               controllerUnit.setIsValid(false);
               controllerUnit.setProcessResult(error.getMessage());
            }
            processEnd(logicContext);
            // 更新处理
            controllerUpdate(logicContext, controllerUnit);
         }
      }
      // 返回结果
      return (_processCount > 0);
   }
}
