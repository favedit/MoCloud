package org.mo.content.face.chart;

import com.cyou.gccloud.data.data.FDataPersonAccessAuthorityLogic;
import com.cyou.gccloud.data.data.FDataPersonAccessAuthorityUnit;
import com.cyou.gccloud.define.enums.core.EGcAuthorityType;
import com.cyou.gccloud.define.enums.core.EGcHostAccess;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.RString;
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
      String address = context.head("x-real-ip");
      if(RString.isEmpty(address)){
         address = context.head("x-forwarded-for");
         if(RString.isEmpty(address)){
            address = context.remoteAddress();
         }
      }
      // 获得数据
      FDataPersonAccessAuthorityLogic logic = logicContext.findLogic(FDataPersonAccessAuthorityLogic.class);
      FLogicDataset<FDataPersonAccessAuthorityUnit> dataset = logic.fetch(FDataPersonAccessAuthorityLogic.HOST_ADDRESS + "='" + address + "'");
      if(dataset.isEmpty()){
         page.setMessage("Invalid host.");
         return "Login";
      }else if(dataset.count() > 1){
         throw new FFatalError("Host count is too many. (count={1})", dataset.count());
      }
      // 检查设置
      FDataPersonAccessAuthorityUnit unit = dataset.first();
      if(unit.accessCd() == EGcHostAccess.Allow){
         return "Live";
      }else{
         FDataPersonAccessAuthorityUnit passportUnit = logic.search(FDataPersonAccessAuthorityLogic.PASSPORT + "='" + passport + "'");
         if(passportUnit != null){
            if(password.equals(passportUnit.password())){
               int typeCd = passportUnit.typeCd();
               if(typeCd == EGcAuthorityType.Permanent){
                  return "Live";
               }
               if(typeCd == EGcAuthorityType.Temporary){
                  long current = RDateTime.currentDate().get();
                  long begin = passportUnit.beginDate().get();
                  long end = passportUnit.endDate().get();
                  if((current >= begin) && (current < end)){
                     return "Live";
                  }else{
                     page.setMessage("Period is invliad.");
                     return "Login";
                  }
               }
            }
         }
      }
      // 非法设置
      page.setMessage("Host is forbid.");
      return "Login";
   }
}
