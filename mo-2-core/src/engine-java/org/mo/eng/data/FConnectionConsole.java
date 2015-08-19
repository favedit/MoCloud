package org.mo.eng.data;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import org.mo.com.collections.FAttributesList;
import org.mo.com.collections.FObjectDictionary;
import org.mo.com.collections.FSlots;
import org.mo.com.console.FConsole;
import org.mo.com.data.ISqlConnection;
import org.mo.com.data.MSqlConnection;
import org.mo.com.encoding.REncryption;
import org.mo.com.lang.FAttributes;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FList;
import org.mo.com.lang.RBoolean;
import org.mo.com.lang.RString;
import org.mo.com.lang.generic.TDumpInfo;
import org.mo.com.lang.reflect.RClass;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.system.RThread;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;
import org.mo.core.monitor.IMonitorConsole;

//============================================================
// <T>数据库链接控制台。</T>
// <P>
//    1. 根据配置信息初始化缓冲池。
//    2. 当链接不够用时，创建新的数据库链接。
//    3. 根据间隔时间检查缓冲池中的数据库链接超时和错误链接。
// </P>
//
// @history 130422 MAOCY 创建
//============================================================ 
public class FConnectionConsole
      extends FConsole
      implements
         IConnectionConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FConnectionConsole.class);

   // 激活字符串
   public static String IDF_ACTIVE = "IDENTIFY:ACTIVE";

   // 链接鉴定字符串
   public static String IDF_CONNECTION = "IDENTIFY:CONNECTION";

   // 工作器鉴定字符串
   public static String IDF_WORKER = "IDENTIFY:WORKER";

   // 名称
   @AProperty
   protected String _name;

   // 驱动名称
   @AProperty
   protected String _driverName;

   // 驱动类名称
   @AProperty
   protected String _driverClass;

   // 链接地址
   @AProperty
   protected String _url;

   // 登录名称
   @AProperty
   protected String _passport;

   // 登录密码[未加密]
   @AProperty
   protected String _password;

   // 登录密码[加密]
   @AProperty
   protected String _encryptPassword;

   // 是否支持事务
   @AProperty
   protected boolean _optionTransactions;

   // 链接初始化个数
   @AProperty
   protected int _initConnectionNumber;

   // 链接最大个数
   @AProperty
   protected int _maxConnectionNumber = 256;

   // 执行业务的最长时间
   @AProperty
   protected long _activeTimeLimit = 60 * 1000;

   // 一个链接使用的最长时间
   @AProperty
   protected long _connectionTimeLimit = 600 * 1000;

   // 数据库链接用户名
   @AProperty
   protected String _user;

   // 测试命令
   @AProperty
   protected String _testSqlCmd;

   // 测试间隔
   @AProperty
   protected long _testTime = 30 * 1000;

   // 关闭链接时等待时间
   @AProperty
   protected int _closeTimeLimit;

   // 数据库监视器
   protected FConnectionMonitor _monitor;

   // 监视器控制台
   @ALink
   protected IMonitorConsole _monitorConsole;

   // 关闭链接时等待时间
   // 创建次数
   protected int _createCount;

   // 收集次数
   protected int _allocCount;

   // 释放次数
   protected int _freeCount;

   // 释放次数
   protected int _releaseCount;

   // 数据库驱动集合
   protected static FDictionary<Driver> _drivers = new FDictionary<Driver>(Driver.class);

   // 数据库使用链接集合
   protected FList<FConnectionWorker> _busyWorkers = new FList<FConnectionWorker>();

   // 数据库未使用链接集合
   protected FList<FConnectionWorker> _freeWorkers = new FList<FConnectionWorker>();

   // 数据库链接列表
   protected FSlots<FConnectionWorker> _pools = new FSlots<FConnectionWorker>(FConnectionWorker.class);

   //============================================================
   // <T>构造数据库链接控制台。</T>
   //============================================================ 
   public FConnectionConsole(){
   }

   //============================================================
   // <T>获得名称。</T>
   //
   // @return 名称
   //============================================================ 
   @Override
   public String name(){
      return _name;
   }

   //============================================================
   // <T>设置名称。</T>
   //
   // @param name 名称
   //============================================================ 
   public void setName(String name){
      _name = name;
   }

   //============================================================
   // <T>获得驱动类名称。</T>
   //
   // @return 驱动类名称
   //============================================================ 
   @Override
   public String driverClass(){
      return _driverClass;
   }

   //============================================================
   // <T>设置驱动类名称。</T>
   //
   // @param driverClass 驱动类名称
   //============================================================ 
   public void setDriverClass(String driverClass){
      _driverClass = driverClass;
   }

   //============================================================
   // <T>获得驱动名称。</T>
   //
   // @return 驱动名称
   //============================================================ 
   @Override
   public String driverName(){
      return _driverName;
   }

   //============================================================
   // <T>设置驱动名称。</T>
   //
   // @param driverName 驱动名称
   //============================================================ 
   public void setDriverName(String driverName){
      _driverName = driverName;
   }

   //============================================================
   // <T>获得链接地址。</T>
   //
   // @return 链接地址
   //============================================================ 
   @Override
   public String url(){
      return _url;
   }

   //============================================================
   // <T>设置链接地址。</T>
   //
   // @param url 链接地址
   //============================================================ 
   public void setUrl(String url){
      _url = url;
   }

   //============================================================
   // <T>获得登录名称。</T>
   //
   // @return 登录名称
   //============================================================ 
   @Override
   public String passport(){
      return _passport;
   }

   //============================================================
   // <T>设置登录名称。</T>
   //
   // @param passport 登录名称
   //============================================================ 
   public void setPassport(String passport){
      _passport = passport;
   }

   //============================================================
   // <T>获得登录密码。</T>
   //
   // @return 登录密码
   //============================================================ 
   public String password(){
      return _password;
   }

   //============================================================
   // <T>设置登录密码。</T>
   //
   // @param passport 登录密码
   //============================================================ 
   public void setPassword(String password){
      _password = password;
   }

   //============================================================
   // <T>获得链接初始化个数。</T>
   //
   // @return 链接初始化个数
   //============================================================ 
   @Override
   public int initConnectionNumber(){
      return _initConnectionNumber;
   }

   //============================================================
   // <T>设置链接初始化个数。</T>
   //
   // @param initConnectionNumber 链接初始化个数
   //============================================================ 
   public void setInitConnectionNumber(int initConnectionNumber){
      _initConnectionNumber = initConnectionNumber;
   }

   //============================================================
   // <T>获得链接最大个数。</T>
   //
   // @return 链接最大个数
   //============================================================ 
   @Override
   public int maxConnectionNumber(){
      return _maxConnectionNumber;
   }

   //============================================================
   // <T>设置链接最大个数。</T>
   //
   // @param maxConnectionNumber 链接最大个数
   //============================================================ 
   public void setMaxConnectionNumber(int maxConnectionNumber){
      _maxConnectionNumber = maxConnectionNumber;
   }

   //============================================================
   // <T>获得设置信息。</T>
   //
   // @return 设置信息
   //============================================================ 
   @Override
   public FAttributes config(){
      FAttributes config = new FAttributes();
      config.set("name", _passport);
      config.set("driver", _driverName);
      config.set("url", _url);
      config.set("active_time_limit", Long.toString(_activeTimeLimit));
      config.set("user", _user);
      return config;
   }

   //============================================================
   // <T>获得链接信息。</T>
   //
   // @return 链接信息
   //============================================================ 
   @Override
   public FAttributesList connectionInfos(){
      FConnectionWorker[] workers = null;
      synchronized(_pools){
         workers = _pools.toObjects();
      }
      FAttributesList list = new FAttributesList();
      if(workers != null){
         for(FConnectionWorker worker : workers){
            list.push(worker.config());
         }
      }
      return list;
   }

   //============================================================
   // <T>创建一个新的数据库链接工作器。</T>
   //
   // @return 数据库链接工作器
   //============================================================ 
   @SuppressWarnings("resource")
   protected FConnectionWorker createWorker(){
      try{
         int count = 0;
         int cycleLimit = 4;
         long beginTick = System.nanoTime();
         boolean isClosed = true;
         Connection sqlConnection = null;
         // 注册数据库链接使用的类
         synchronized(_drivers){
            if(!_drivers.contains(_driverName)){
               Driver driver = RClass.newInstance(_driverName);
               DriverManager.registerDriver(driver);
               _drivers.set(_driverName, driver);
            }
         }
         // 获得类对象
         MSqlConnection connection = RClass.newInstance(_driverClass);
         String url = connection.makeUrl(_url);
         // 获得数据库链接
         _logger.debug(this, "createWorker", "Create sql connection begin. (url={1}, passport={2})", _url, _passport);
         while((sqlConnection == null) || isClosed){
            if(count > cycleLimit){
               sqlConnection = null;
               break;
            }
            try{
               if(RString.isEmpty(_passport)){
                  // 使用URL登录
                  sqlConnection = DriverManager.getConnection(url);
               }else{
                  // 使用用户名和密码登录
                  String password = _password;
                  if(!RString.isEmpty(_encryptPassword)){
                     password = REncryption.decodeString(_passport, _encryptPassword);
                  }
                  sqlConnection = DriverManager.getConnection(url, _passport, password);
               }
               if(sqlConnection != null){
                  isClosed = sqlConnection.isClosed();
               }
            }catch(Exception e){
               _logger.error(this, "createWorker", e);
            }finally{
               count++;
            }
         }
         if(sqlConnection == null){
            throw new FFatalError("Create sql connection error. (url={1}, passport={2})", _url, _passport);
         }
         connection.setSqlConnection(sqlConnection);
         // 获得数据库链接
         FConnectionWorker worker = new FConnectionWorker();
         worker.connection = connection;
         worker.user = _user;
         worker.testSqlCmd = _testSqlCmd;
         if(_logger.debugAble()){
            long endTick = System.nanoTime();
            _logger.debug(this, "createWorker", endTick - beginTick, "Create sql connection success. (url={1}, connection={2}, native={3})", _url, worker.connection, sqlConnection);
         }
         _createCount++;
         // 设置关联信息
         FObjectDictionary attributes = connection.attributes();
         attributes.set(IDF_CONNECTION, this);
         attributes.set(IDF_WORKER, worker);
         return worker;
      }catch(Exception e){
         throw new FFatalError(e);
      }
   }

   //============================================================
   // <T>收集一个工作器。</T>
   //
   // @return 工作器
   //============================================================ 
   protected synchronized FConnectionWorker allocateWorker(){
      FConnectionWorker allocWorker = null;
      // 收集一个链接
      if(_freeWorkers.isEmpty()){
         allocWorker = createWorker();
      }else{
         allocWorker = _freeWorkers.pop();
      }
      // 激活工作器
      if(allocWorker != null){
         allocWorker.active();
         _busyWorkers.push(allocWorker);
      }
      return allocWorker;
   }

   //============================================================
   // <T>释放一个工作器。</T>
   //
   // @param worker 工作器
   //============================================================ 
   protected synchronized void freeWorker(FConnectionWorker worker){
      if(worker != null){
         // 释放繁忙的链接
         _busyWorkers.removeFirst(worker);
         // 释放链接自由化
         worker.free();
         _freeWorkers.push(worker);
         _freeCount++;
      }
   }

   //============================================================
   // <T>释放一个数据库链接工作器。</T>
   //
   // @param worker 工作器
   //============================================================ 
   public synchronized void releaseWorker(FConnectionWorker worker){
      if(worker != null){
         // 释放繁忙的链接
         _busyWorkers.removeFirst(worker);
         // 释放自由的链接
         _freeWorkers.removeFirst(worker);
         // 释放链接
         try{
            _releaseCount++;
            worker.release();
         }catch(Throwable t){
            _logger.fatal(this, "releaseWorker", t);
         }
      }
   }

   //============================================================
   // <T>收集一个数据库链接。</T>
   // <P>
   //    如果有空闲的数据库链接，则使用。
   //    如果没有空闲的数据库链接，则新建一个数据库链接。
   // </P>
   //
   // @return 数据库链接
   //============================================================ 
   @Override
   public ISqlConnection alloc(){
      long beginTick = System.nanoTime();
      // 创建链接
      FConnectionWorker worker = allocateWorker();
      if(!worker.isConnect()){
         throw new FFatalError("Can't allocate connection");
      }
      if(_logger.debugAble()){
         long endTick = System.nanoTime();
         _logger.debug(this, "alloc", endTick - beginTick, "Allocate sql connection. (active={1}, create={2}, alloc={3}, free={4}, release={5}, connection={6})", _createCount - _releaseCount, _createCount, _allocCount, _freeCount, _releaseCount,
               worker.connection);
      }
      _allocCount++;
      // 激活链接
      MSqlConnection connection = worker.connection;
      connection.attributes().set(IDF_ACTIVE, RBoolean.TRUE_STR);
      return connection;
   }

   //============================================================
   // <T>回收一个数据库链接。</T>
   //
   // @param connection 数据库链接
   //============================================================ 
   @Override
   public void free(ISqlConnection connection){
      // 检查标志
      String activeFlag = (String)connection.attributes().find(IDF_ACTIVE);
      if(!RBoolean.TRUE_STR.equals(activeFlag)){
         return;
      }
      // 提交之前数据
      long beginTick = System.nanoTime();
      connection.commit();
      // 释放工作器
      FConnectionWorker worker = (FConnectionWorker)connection.attributes().get(IDF_WORKER);
      freeWorker(worker);
      _freeCount++;
      connection.attributes().set(IDF_ACTIVE, RBoolean.FALSE_STR);
      if(_logger.debugAble()){
         long endTick = System.nanoTime();
         _logger.debug(this, "free", endTick - beginTick, "Free sql connection. (connection={1})", connection);
      }
   }

   //============================================================
   // <T>释放一个数据库链接。</T>
   //
   // @param connection 数据库链接
   //============================================================ 
   @Override
   public void release(ISqlConnection connection){
      FConnectionWorker worker = (FConnectionWorker)connection.attributes().get(IDF_WORKER);
      releaseWorker(worker);
   }

   //============================================================
   // <T>初始化监视器。</T>
   //============================================================
   public void initializeMonitor(){
      _monitor = new FConnectionMonitor(this);
      _monitor.setInterval(1);
      _monitorConsole.register(_monitor);
   }

   //============================================================
   // <T>初始化所有链接。</T>
   //============================================================
   public void initializeConnections(){
      // 增加缓冲池的大小
      for(int n = 0; n < _initConnectionNumber; n++){
         _freeWorkers.push(createWorker());
      }
   }

   //============================================================
   // <T>刷新所有数据库链接。</T>
   //============================================================ 
   @Override
   public synchronized void refresh(){
      long currentTime = System.currentTimeMillis();
      // 获得个数
      int count = _freeWorkers.count();
      if(count > 0){
         // 复制所有工作器
         FConnectionWorker[] workers = new FConnectionWorker[count];
         _freeWorkers.copy(workers, 0, count);
         // 刷新处理
         for(int n = 0; n < count; n++){
            FConnectionWorker worker = workers[n];
            // 测试链接失败时释放当前链接
            if((currentTime - worker.testTime) > _testTime){
               if(!worker.connectTest()){
                  releaseWorker(worker);
               }
            }
         }
      }
      //      // 释放超时链接
      //      if(currentTime - worker.activeTime > _activeTimeLimit){
      //         releaseWorker(worker);
      //      }
   }

   //============================================================
   // <T>释放所有的数据库链接。</T>
   //============================================================ 
   @Override
   public void release(){
      if(_logger.debugAble()){
         _logger.debug(this, "release", "Begin release sql connection");
      }
      int releaseCount = 0;
      int timeout = _closeTimeLimit;
      boolean forced = false;
      while(true){
         int used = 0;
         // Release connections
         synchronized(_pools){
            int count = _pools.count();
            for(int n = 0; n < count; n++){
               FConnectionWorker worker = _pools.get(n);
               if(null != worker){
                  if(worker.inUsing && !forced && worker.isConnect()){
                     used++;
                  }else{
                     _pools.set(n, null);
                     try{
                        releaseCount++;
                        worker.release();
                     }catch(Exception e){
                        _logger.fatal(this, "release", e);
                     }
                  }
               }
            }
         }
         // Release result check
         if(used == 0){
            break;
         }else{
            timeout -= 500;
            if(timeout < 0){
               // Force release all
               forced = true;
            }else{
               // Wait for used connection
               RThread.sleep(500);
               if(_logger.debugAble()){
                  _logger.debug(this, "release", "Wait for sql connection (count={1} timeout={2})", used, timeout);
               }
            }
         }
      }
      _pools.clear();
      if(_logger.debugAble() && releaseCount > 0){
         _logger.debug(this, "release", "End release sql connection. (count={1})", releaseCount);
      }
   }

   //============================================================
   // <T>生成运行信息。</T>
   //
   // @param info 运行信息
   // @return 运行信息
   //============================================================
   @Override
   public TDumpInfo dump(TDumpInfo info){
      FConnectionWorker[] workers = null;
      synchronized(_pools){
         workers = _pools.toObjects();
      }
      if(null != workers){
         info.append(" Connection count:");
         info.appendInt(workers.length);
         info.appendLine();
         for(FConnectionWorker worker : workers){
            info.append(" --- ");
            info.append(" CTime: " + worker.createTime);
            info.append(" ATime: " + worker.activeTime);
            info.appendLine();
         }
      }
      return info;
   }
}
