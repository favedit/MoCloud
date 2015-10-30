package org.mo.data.logic;

import org.mo.com.lang.FDictionary;
import org.mo.com.lang.reflect.RClass;
import org.mo.eng.data.IDatabaseConsole;
import org.mo.eng.data.common.FSqlContext;

//============================================================
// <T>逻辑环境。</T>
//============================================================
public class FLogicContext
      extends FSqlContext
      implements
         ILogicContext
{
   // 逻辑表格集合
   protected FDictionary<ILogicTable> _tables;

   //============================================================
   // <T>构造逻辑环境。</T>
   //============================================================
   public FLogicContext(){
   }

   //============================================================
   // <T>构造逻辑环境。</T>
   //
   // @param databaseConsole 数据库控制台
   //============================================================
   public FLogicContext(IDatabaseConsole databaseConsole){
      _databaseConsole = databaseConsole;
   }

   //============================================================
   // <T>根据类对象获得逻辑表格接口。</T>
   //
   // @param clazz 类对象
   // @return 逻辑表格接口
   //============================================================
   @Override
   @SuppressWarnings("unchecked")
   public <T extends ILogicTable> T findLogic(Class<T> clazz){
      if(_tables == null){
         _tables = new FDictionary<ILogicTable>(ILogicTable.class);
      }
      String className = clazz.getName();
      FLogicTable table = (FLogicTable)_tables.find(className);
      if(table == null){
         table = (FLogicTable)RClass.newInstance(clazz);
         table.linkLogicContext(this);
         _tables.set(className, table);
      }
      return (T)table;
   }

   //============================================================
   // <T>根据类对象获得逻辑表格接口。</T>
   //
   // @param clazz 类对象
   // @return 逻辑表格接口
   //============================================================
   @Override
   @SuppressWarnings("unchecked")
   public <T extends ILogicTable> T findLogic(Class<T> clazz,
                                              String connectionName){
      if(_tables == null){
         _tables = new FDictionary<ILogicTable>(ILogicTable.class);
      }
      String className = clazz.getName();
      FLogicTable table = (FLogicTable)_tables.find(className + "@" + connectionName);
      if(table == null){
         table = (FLogicTable)RClass.newInstance(clazz);
         table.linkLogicContext(this, connectionName);
         _tables.set(className, table);
      }
      return (T)table;
   }

   //============================================================
   // <T>释放处理。</T>
   //============================================================
   @Override
   public void release(){
      if(_tables != null){
         _tables.clear();
         _tables = null;
      }
      super.release();
   }
}
