package org.mo.content.face.chart;

import com.cyou.gccloud.data.data.FDataPersonAccessHostLogic;
import com.cyou.gccloud.data.data.FDataPersonAccessHostUnit;
import com.cyou.gccloud.define.enums.core.EGcHostAccess;
import org.mo.com.lang.FFatalError;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <P>首页。</P>
//
// @author maocy
// @version 150427
//============================================================
public class FLiveAction
      implements
         ILiveAction
{
   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param page 页面
   //============================================================
   @Override
   public String construct(FLivePage page){
      return "Login";
   }

   //============================================================
   // <T>登录逻辑处理。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @Override
   public String login(IWebContext context,
                       ILogicContext logicContext,
                       FLivePage page){
      // 获得参数
      String passport = page.passport();
      String password = page.password();
      String host = context.remoteAddress();
      System.out.println(passport + " - " + password + " - " + host);
      // 获得数据
      FDataPersonAccessHostLogic logic = logicContext.findLogic(FDataPersonAccessHostLogic.class);
      FLogicDataset<FDataPersonAccessHostUnit> dataset = logic.fetch(FDataPersonAccessHostLogic.HOST + "='" + host + "'");
      if(dataset.isEmpty()){
         page.setMessage("Invalid host.");
         return "Login";
      }else if(dataset.count() > 1){
         throw new FFatalError("Host count is too many. (count={1})", dataset.count());
      }
      // 检查设置
      FDataPersonAccessHostUnit unit = dataset.first();
      if(unit.accessCd() == EGcHostAccess.Allow){
         return "Live2";
      }
      // 非法设置
      page.setMessage("Host is forbid.");
      return "Login";
   }
}
