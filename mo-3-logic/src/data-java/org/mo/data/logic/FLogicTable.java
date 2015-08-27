package org.mo.data.logic;

import org.mo.com.collections.FDataset;
import org.mo.com.collections.FRow;
import org.mo.com.data.ISqlConnection;
import org.mo.com.data.ISqlDatasetReader;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.FString;
import org.mo.com.lang.reflect.RClass;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.RAop;
import org.mo.core.bind.IBindConsole;
import org.mo.data.logic.cache.FLogicCacheChannel;
import org.mo.data.logic.cache.FLogicCacheDataset;
import org.mo.data.logic.cache.ILogicCacheVendor;
import org.mo.eng.data.FDataOperator;
import org.mo.eng.memorycache.FMemoryChannel;

//============================================================
// <T>逻辑数据表。</T>
// <P>修改记录时，是否所有Search和fetchDataset内容。</P>
//============================================================
public abstract class FLogicTable
      extends FObject
      implements
         ILogicTable
{
   // 数据超时时间[1分钟]
   public static int DATASET_CACHE_TIMEOUT = 60;

   // 日志输出接口
   private static ILogger _logger = RLogger.find(FLogicTable.class);

   // 名称
   protected String _name;

   // 单元类对象
   protected Class<?> _classUnit;

   // 逻辑环境
   protected ILogicContext _logicContext;

   // 数据库链接
   protected ISqlConnection _connection;

   // 逻辑单元缓冲提供商
   protected ILogicCacheVendor _cacheVendor;

   // 逻辑单元缓冲频道
   protected FLogicCacheChannel _cacheChannel;

   // 逻辑单元缓冲
   protected FLogicCacheDataset _cacheDataset;

   // 内存单元缓冲
   protected FMemoryChannel _memoryChannel;

   // 记录行超时
   protected int _timeout = DATASET_CACHE_TIMEOUT;

   //============================================================
   // <T>构造逻辑数据集合。</T>
   //============================================================
   public FLogicTable(){
   }

   //============================================================
   // <T>构造逻辑数据集合。</T>
   //
   // @param context 逻辑环境
   //============================================================
   public FLogicTable(ILogicContext context){
      linkLogicContext(context);
   }

   //============================================================
   // <T>获得逻辑环境。</T>
   //
   // @return 逻辑环境
   //============================================================
   public ILogicContext logicContext(){
      return _logicContext;
   }

   //============================================================
   // <T>获得数据链接。</T>
   //
   // @return 数据链接
   //============================================================
   public ISqlConnection connection(){
      return _connection;
   }

   //============================================================
   // <T>设置逻辑环境。</T>
   //
   // @param logicContext 逻辑环境
   //============================================================
   public void linkLogicContext(ILogicContext logicContext){
      _logicContext = logicContext;
      SLogicConnectionInfo connectionInfo = connectionInfo();
      _connection = logicContext.activeConnection(connectionInfo.name());
      if(_connection instanceof ILogicCacheVendor){
         _cacheVendor = (ILogicCacheVendor)_connection;
         if(_cacheVendor != null){
            _cacheChannel = _cacheVendor.channel();
            if(_cacheChannel != null){
               _cacheChannel.memoryChannel();
            }
         }
      }
   }

   //============================================================
   // <T>获得数据链接信息。</T>
   //
   // @return 数据链接
   //============================================================
   public SLogicConnectionInfo connectionInfo(){
      throw new FFatalError("Not implement method.");
   }

   //============================================================
   // <T>获得数据集合信息。</T>
   //
   // @return 数据集合链接
   //============================================================
   public SLogicTableInfo tableInfo(){
      throw new FFatalError("Not implement method.");
   }

   //============================================================
   // <T>获得本地缓冲集合。</T>
   //
   // @return 本地缓冲集合
   //============================================================
   protected FLogicCacheDataset innerCacheDataset(){
      if(_cacheDataset == null){
         if(_cacheVendor != null){
            FLogicCacheChannel channel = _cacheVendor.channel();
            if(channel != null){
               _cacheDataset = channel.syncCache(_name);
            }
         }
      }
      return _cacheDataset;
   }

   //============================================================
   // <T>根据主键获得行记录。</T>
   //
   // @param code 代码
   // @return 行记录
   //============================================================
   protected FRow innerCacheFindRow(long code){
      FLogicCacheDataset dataset = innerCacheDataset();
      if(dataset != null){
         FRow unit = dataset.get(code);
         if(unit != null){
            _logger.debug(this, "innerCacheFindRow", "Find row from cache. (code={1})", code);
         }
         return unit;
      }
      return null;
   }

   //============================================================
   // <T>根据主键设置行记录。</T>
   //
   // @param code 代码
   // @param row 行记录
   //============================================================
   protected void innerCacheSetRow(long code,
                                   FRow row){
      FLogicCacheDataset dataset = innerCacheDataset();
      if(dataset != null){
         dataset.set(code, row);
      }
   }

   //============================================================
   // <T>根据主键删除行记录。</T>
   //
   // @param code 代码
   //============================================================
   protected void innerCacheDeleteRow(long code){
      FLogicCacheDataset dataset = innerCacheDataset();
      if(dataset != null){
         dataset.set(code, null);
      }
   }

   //============================================================
   // <T>清空本地缓冲。</T>
   //============================================================
   protected void innerCacheClear(){
      FLogicCacheDataset dataset = innerCacheDataset();
      if(dataset != null){
         dataset.clear();
      }
   }

   //============================================================
   // <T>生成内存缓冲主键。</T>
   //
   // @param fields 字段集合
   // @param whereSql 查询命令
   // @param groupSql 分组命令
   // @param orderSql 排序命令
   // @return 主键
   //============================================================
   protected String innerMemcacheKey(CharSequence fields,
                                     CharSequence whereSql,
                                     CharSequence groupSql,
                                     CharSequence orderSql){
      FString key = new FString();
      key.append(fields);
      key.append('|');
      key.append(whereSql);
      key.append('|');
      key.append(groupSql);
      key.append('|');
      key.append(orderSql);
      return key.toString();
   }

   //============================================================
   // <T>清空内存缓冲。</T>
   //============================================================
   protected void innerMemcacheClear(){
      // 缓冲内容
      FLogicCacheDataset cacheDataset = innerCacheDataset();
      cacheDataset.tableFlush();
   }

   //============================================================
   // <T>根据主键查询行记录。</T>
   //
   // @param id 编号
   // @return 行记录
   //============================================================
   protected FRow innerFindRow(long id,
                               CharSequence sql){
      FRow row = null;
      if(_cacheChannel == null){
         row = _connection.find(sql);
      }else{
         // 查找数据
         FLogicCacheDataset cacheDataset = innerCacheDataset();
         String key = cacheDataset.makeRowKey(id);
         String value = _memoryChannel.getString(key);
         if(value != null){
            // 解析数据
            row = new FRow();
            row.unpack(value);
            _logger.debug(this, "innerFindRow", "Find row from memcache. (key={1}, sql={2})", key, sql);
         }
         // 查询数据
         if(row == null){
            row = _connection.find(sql);
            // 存储数据
            if(row != null){
               String pack = row.pack();
               _memoryChannel.setString(key, pack, _timeout);
            }else{
               _memoryChannel.delete(key);
            }
         }
      }
      return row;
   }

   //============================================================
   // <T>根据主键查询行记录。</T>
   //
   // @param code 代码
   // @param sql 命令
   // @return 行记录
   //============================================================
   protected FRow innerFindRow(CharSequence code,
                               CharSequence sql){
      FRow row = null;
      if(_cacheChannel == null){
         row = _connection.find(sql);
      }else{
         // 查找数据
         FLogicCacheDataset cacheDataset = innerCacheDataset();
         String key = cacheDataset.makeFetchKey(code);
         String value = _memoryChannel.getString(key);
         if(value != null){
            // 解析数据
            row = new FRow();
            row.unpack(value);
            _logger.debug(this, "innerFindRow", "Find row from memcache. (key={1}, sql={2})", key, sql);
         }
         // 查询数据
         if(row == null){
            row = _connection.find(sql);
            // 存储数据
            if(row != null){
               String pack = row.pack();
               _memoryChannel.setString(key, pack, _timeout);
            }else{
               _memoryChannel.delete(key);
            }
         }
      }
      return row;
   }

   //============================================================
   // <T>根据主键查询行记录。</T>
   //
   // @param id 编号
   // @return 行记录
   //============================================================
   protected void innerDeleteRow(long id){
      // 检查记录编号
      if(id == 0){
         throw new FFatalError("Record is invalid.");
      }
      // 删除本地缓冲
      innerCacheDeleteRow(id);
      // 删除内存缓冲
      if(_cacheChannel != null){
         // 清空记录缓冲
         FLogicCacheDataset cacheDataset = innerCacheDataset();
         String key = cacheDataset.makeRowKey(id);
         _memoryChannel.delete(key);
         // 清空search和fetch缓冲内容
         cacheDataset.tableFlush();
      }
   }

   //============================================================
   // <T>查询数据集合。</T>
   //
   // @param sql 查询命令
   // @param pageSize 页大小
   // @param page 页号
   // @return 数据集合
   //============================================================
   protected FDataset innerFindDataset(CharSequence code,
                                       CharSequence sql,
                                       int pageSize,
                                       int page){
      FDataset dataset = null;
      String key = null;
      if(_cacheChannel != null){
         // 查找数据
         FLogicCacheDataset cacheDataset = innerCacheDataset();
         key = cacheDataset.makeFetchKey(code + "|" + pageSize + "|" + page);
         String value = _memoryChannel.getString(key);
         if(value != null){
            // 解析数据
            dataset = new FDataset();
            dataset.unpack(value);
            _logger.debug(this, "innerFindDataset", "Find dataset from memcache. (key={1}, sql={2})", key, sql);
         }
      }
      // 查询数据
      if(dataset == null){
         if(pageSize > 0){
            dataset = _connection.fetchDataset(sql, pageSize, page);
         }else{
            dataset = _connection.fetchDataset(sql);
         }
         // 存储结果集合
         if(_cacheChannel != null){
            if(dataset != null){
               String pack = dataset.pack();
               _memoryChannel.setString(key, pack, _timeout);
            }else{
               _memoryChannel.delete(key);
            }
         }
      }
      return dataset;
   }

   //============================================================
   // <T>执行一个数据命令，清空所有缓存。</T>
   //
   // @param sql 数据命令
   // @return 处理结果
   //============================================================
   public EResult executeSql(CharSequence sql){
      // 删除本地缓冲
      innerCacheClear();
      // 删除内存缓冲
      innerMemcacheClear();
      // 执行SQL内容
      boolean result = _connection.executeSql(sql);
      // 执行SQL文
      return result ? EResult.Success : EResult.Failure;
   }

   //============================================================
   // <T>执行一个数据命令，清空所有缓存。</T>
   //
   // @param sql 数据命令
   // @return 处理结果
   //============================================================
   public ISqlDatasetReader fetchReader(CharSequence sql){
      return _connection.fetchReader(sql);
   }

   //============================================================
   // <T>根据编号获得一个数据单元。</T>
   //
   // @param id 记录编号
   // @return 数据单元
   //============================================================
   @SuppressWarnings("unchecked")
   public <T extends FLogicUnit> T find(long id){
      return (T)find(null, null, id);
   }

   //============================================================
   // <T>根据编号获得一个数据单元。</T>
   //
   // @param clazz 类对象
   // @param id 记录编号
   // @return 数据单元
   //============================================================
   public <T extends FLogicUnit> T find(Class<T> clazz,
                                        long id){
      return find(null, clazz, id);
   }

   //============================================================
   // <T>根据编号获得一个数据单元。</T>
   //
   // @param unit 数据单元
   // @param id 记录编号
   // @return 是否获得
   //============================================================
   public boolean find(FLogicUnit unit,
                       long id){
      Object result = find(unit, null, id);
      return (result != null);
   }

   //============================================================
   // <T>根据编号获得一个数据单元。</T>
   //
   // @param unit 数据单元
   // @param clazz 类对象
   // @param recordId 记录编号
   // @return 是否获得
   //============================================================
   public abstract <T extends FLogicUnit> T find(T unit,
                                                 Class<T> clazz,
                                                 long recordId);

   //============================================================
   // <T>根据唯一编号获得一个数据单元。</T>
   //
   // @param clazz 类对象
   // @param guid 唯一编号
   // @return 数据单元
   //============================================================
   public <T extends FLogicUnit> T findByGuid(Class<T> clazz,
                                              CharSequence guid){
      return findByGuid(null, clazz, guid);
   }

   //============================================================
   // <T>根据唯一编号获得一个数据单元。</T>
   //
   // @param unit 数据单元
   // @param clazz 类对象
   // @param guid 唯一编号
   // @return 是否获得
   //============================================================
   public abstract <T extends FLogicUnit> T findByGuid(T unit,
                                                       Class<T> clazz,
                                                       CharSequence guid);

   //============================================================
   // <T>根据条件获得一个数据单元。</T>
   //
   // @param clazz 类对象
   // @param whereSql 条件
   // @return 数据单元
   //============================================================
   public <T extends FLogicUnit> T search(Class<T> clazz,
                                          CharSequence whereSql){
      return search(null, clazz, whereSql);
   }

   //============================================================
   // <T>根据条件获得一个数据单元。</T>
   //
   // @param unit 数据单元
   // @param clazz 类对象
   // @param whereSql 条件
   // @return 是否获得
   //============================================================
   public abstract <T extends FLogicUnit> T search(T unit,
                                                   Class<T> clazz,
                                                   CharSequence whereSql);

   //============================================================
   // <T>根据查询获得一个数据单元。</T>
   //
   // @param unit 数据单元
   // @param code 代码
   // @param whereSql 条件
   // @return 是否获得
   //============================================================
   public boolean searchSql(FLogicUnit unit,
                            CharSequence code,
                            CharSequence sql){
      FLogicUnit result = searchSql(unit, null, code, sql);
      return (result != null);
   }

   //============================================================
   // <T>根据查询获得一个数据单元。</T>
   //
   // @param clazz 类对象
   // @param code 代码
   // @param whereSql 条件
   // @return 行记录
   //============================================================
   public <T extends FLogicUnit> T searchSql(Class<T> clazz,
                                             CharSequence code,
                                             CharSequence sql){
      return searchSql(null, clazz, code, sql);
   }

   //============================================================
   // <T>根据查询获得一个数据单元。</T>
   //
   // @param unit 数据单元
   // @param clazz 类对象
   // @param code 代码
   // @param whereSql 条件
   // @return 行记录
   //============================================================
   public <T extends FLogicUnit> T searchSql(T unit,
                                             Class<T> clazz,
                                             CharSequence code,
                                             CharSequence sql){
      // 获得数据
      FRow row = innerFindRow(code, sql);
      // 检查结果
      if(row == null){
         return null;
      }
      // 获得数据
      if(unit == null){
         unit = RClass.newInstance(clazz);
      }
      // 加载行数据
      if(unit == null){
         throw new FFatalError("Unit is empty. (unit={1}, class={2})", unit, clazz);
      }
      unit.linkLogicContext(_logicContext);
      unit.load(row);
      return unit;
   }

   //============================================================
   // <T>根据条件获得数据单元集合。</T>
   //
   // @param clazz 单元类型
   // @param fields 选取字段
   // @param whereSql 条件命令
   // @param groupSql 分组命令
   // @param orderSql 排序命令
   // @param position 位置
   // @param count 总数
   // @return 数据单元集合
   //============================================================
   public abstract <T extends FLogicUnit> FLogicDataset<T> fetchClass(Class<T> clazz,
                                                                      CharSequence fields,
                                                                      CharSequence whereSql,
                                                                      CharSequence groupSql,
                                                                      CharSequence orderSql,
                                                                      int position,
                                                                      int count);

   //============================================================
   // <T>获得当前操作者。</T>
   //
   // @return 处理结果
   //============================================================
   public long currentOperatorId(){
      IBindConsole bindConsole = RAop.find(IBindConsole.class);
      if(bindConsole != null){
         FDataOperator operator = bindConsole.find(FDataOperator.class);
         if(operator != null){
            return operator.userId();
         }
      }
      return 0;
   }

   //============================================================
   // <T>删除一个数据单元。</T>
   //
   // @param recordId 记录编号
   // @return 处理结果
   //============================================================
   @Override
   public EResult doDelete(long recordId){
      return doDelete(null, recordId);
   }
}
