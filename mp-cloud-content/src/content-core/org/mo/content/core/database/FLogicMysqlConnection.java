package org.mo.content.core.database;

import java.sql.Connection;
import org.mo.core.aop.RAop;
import org.mo.data.driver.FSqlMysqlConnection;
import org.mo.data.logic.cache.FLogicCacheChannel;
import org.mo.data.logic.cache.ILogicCacheConsole;
import org.mo.data.logic.cache.ILogicCacheVendor;

//============================================================
// <T>逻辑MySQL数据库链接。</T>
//============================================================
public class FLogicMysqlConnection
      extends FSqlMysqlConnection
      implements
         ILogicCacheVendor
{
   // 逻辑单元缓冲频道
   protected FLogicCacheChannel _channel;

   // 逻辑单元缓冲控制台
   protected ILogicCacheConsole _cacheConsole;

   //============================================================
   // <T>构造逻辑MySQL数据库链接。</T>
   //============================================================
   public FLogicMysqlConnection(){
   }

   //============================================================
   // <T>构造逻辑MySQL数据库链接。</T>
   //
   // @param sqlConnection 数据库链接
   //============================================================
   public FLogicMysqlConnection(Connection sqlConnection){
      super(sqlConnection);
   }

   //============================================================
   // <T>获得逻辑单元缓冲频道。</T>
   //
   // @return 逻辑单元缓冲频道
   //============================================================
   @Override
   public FLogicCacheChannel channel(){
      if(_channel == null){
         _cacheConsole = RAop.find(ILogicCacheConsole.class);
         _channel = _cacheConsole.alloc();
      }
      return _channel;
   }

   //============================================================
   // <T>释放处理。</T>
   //============================================================
   @Override
   public void free(){
      if(_channel != null){
         _cacheConsole.free(_channel);
      }
   }
}
