package org.mo.content.face.person.user;

import com.cyou.gccloud.data.data.FDataPersonAccessAuthorityUnit;
import org.mo.com.lang.type.TDateTime;
import org.mo.content.core.person.user.IAccessConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>人员账号逻辑。</T>
//
// @author sunhr
// @version 150328
//============================================================
public class FAccessAction
      implements
         IAccessAction
{
   //用户控制台
   @ALink
   protected IAccessConsole _accessConsole;

   //============================================================
   // <T>注册用户</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   @Override
   public String construct(IWebContext context,
                           ILogicContext logicContext,
                           FAccessPage page){
      System.out.println("------------eai----------------construct");
      FLogicDataset<FDataPersonAccessAuthorityUnit> unitlist = _accessConsole.select(logicContext);
      //      for(FDataPersonAccessAuthorityUnit unit : unitlist){
      //         TDateTime beginDate = new TDateTime();
      //         beginDate.parse(unit.beginDate().toString(), "YYYY-MM-DD HH24:mi:ss");
      //         unit.setBeginDate(beginDate);
      //      }
      page.setUnitList(unitlist);
      return "AccessList";
   }

   @Override
   public String delete(IWebContext context,
                        ILogicContext logicContext,
                        FAccessPage page){
      long id = context.parameterAsLong("id");
      FDataPersonAccessAuthorityUnit unit = new FDataPersonAccessAuthorityUnit();
      unit.setOuid(id);
      _accessConsole.doDelete(logicContext, unit);
      return "AccessList";
   }

   @Override
   public String insert(IWebContext context,
                        ILogicContext logicContext,
                        FAccessPage page){
      FDataPersonAccessAuthorityUnit unit = new FDataPersonAccessAuthorityUnit();
      unit.setHostAddress(context.parameter("host_address"));
      unit.setLabel(context.parameter("label"));
      unit.setHostPort(context.parameterAsInteger("host_port"));
      unit.setPassport(context.parameter("passport"));
      unit.setPassword(context.parameter("password"));
      unit.setAccessCd(context.parameterAsInteger("access_cd"));
      unit.setTypeCd(context.parameterAsInteger("type_cd"));
      //时间处理
      String beginDateStr = context.parameter("begin_date");
      TDateTime beginDate = new TDateTime();
      beginDate.parse(beginDateStr, "YYYY-MM-DD HH24:mi:ss");
      unit.setBeginDate(beginDate);
      //结束时间
      String endDateStr = context.parameter("end_date");
      TDateTime endDate = new TDateTime();
      endDate.parse(endDateStr, "YYYY-MM-DD HH24:mi:ss");
      unit.setEndDate(endDate);
      //.....................................
      unit.setNote(context.parameter("note"));
      _accessConsole.doInsert(logicContext, unit);
      return "AccessList";
   }

   @Override
   public String updateBefore(IWebContext context,
                              ILogicContext logicContext,
                              FAccessPage page){
      long id = context.parameterAsLong("id");
      FDataPersonAccessAuthorityUnit unit = _accessConsole.find(logicContext, id);
      page.setUnit(unit);
      return "UpdateUser";
   }

   @Override
   public String update(IWebContext context,
                        ILogicContext logicContext,
                        FAccessPage page){
      long id = context.parameterAsLong("id");
      FDataPersonAccessAuthorityUnit unit = _accessConsole.find(logicContext, id);
      unit.setHostAddress(context.parameter("host_address"));
      unit.setLabel(context.parameter("label"));
      unit.setHostPort(context.parameterAsInteger("host_port"));
      unit.setPassport(context.parameter("passport"));
      unit.setPassword(context.parameter("password"));
      unit.setAccessCd(context.parameterAsInteger("access_cd"));
      unit.setTypeCd(context.parameterAsInteger("type_cd"));
      //时间处理
      String beginDateStr = context.parameter("begin_date");
      TDateTime beginDate = new TDateTime();
      beginDate.parse(beginDateStr, "YYYY-MM-DD HH24:mi:ss");
      unit.setBeginDate(beginDate);
      //结束时间
      String endDateStr = context.parameter("end_date");
      TDateTime endDate = new TDateTime();
      endDate.parse(endDateStr, "YYYY-MM-DD HH24:mi:ss");
      unit.setEndDate(endDate);
      //.....................................
      unit.setNote(context.parameter("note"));
      _accessConsole.doUpdate(logicContext, unit);
      return "AccessList";
   }
}
