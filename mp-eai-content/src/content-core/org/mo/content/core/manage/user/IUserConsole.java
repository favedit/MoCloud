package org.mo.content.core.manage.user;

import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>用户逻辑数据库操作接口</P>
//
//@class IUserConsole
//@author Sunhr
//@Date 2012.11.05  
//@version 1.0.0
//============================================================

public interface IUserConsole
      extends
         IAbstractLogicUnitConsole<FDataPersonUserUnit>
{

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   //
   // @param con 链接对象
   // @pageNum 指定页面
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataPersonUserUnit> selectDataByPageAndSomerow(ILogicContext logicContext,
                                                                 FDataPersonUserUnit userUnit,
                                                                 int pageNum);

   // ============================================================
   // <T>用户登陆</T>
   //
   // @param cnn 链接对象
   // @param row 登陆对象
   // @return 用户数据
   // ============================================================
   FLogicDataset<FDataPersonUserUnit> loginUser(ILogicContext logicContext,
                                                FDataPersonUserUnit userUnit);

   // ============================================================
   // <T>根据帐号查找数据</T>
   //
   // @param sqlContext 链接对象
   // @param passport 帐号
   // @return 模块数据
   // ============================================================
   FLogicDataset<FDataPersonUserUnit> checkPassportIsExist(ILogicContext logicContext,
                                                           String passport);

   // ============================================================
   // <T>根据ouid修改用户</T>
   //
   // @param sqlContext 链接对象
   // @param ouid 主键
   // @return 数据信息
   // ============================================================
   void updateByOuid(ILogicContext logicContext,
                     FDataPersonUserUnit user);

}
