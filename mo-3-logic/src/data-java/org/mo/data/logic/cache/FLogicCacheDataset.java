package org.mo.data.logic.cache;

import org.mo.com.collections.FCodeLongSet;
import org.mo.com.collections.FRow;
import org.mo.com.lang.FObject;
import org.mo.com.lang.FString;
import org.mo.com.lang.RString;
import org.mo.com.lang.RUuid;
import org.mo.eng.memorycache.FMemoryChannel;

//============================================================
// <T>逻辑单元缓冲。</T>
//============================================================
public class FLogicCacheDataset
      extends FObject
{
   // 缓冲频道
   protected FLogicCacheChannel _channel;

   // 内存缓冲
   protected FMemoryChannel _memoryChannel;

   // 名称
   protected String _name;

   // 名称
   protected String _tableGuid;

   // 名称
   protected String _datasetGuid;

   // 单元集合
   protected FCodeLongSet<FRow> _rows = new FCodeLongSet<FRow>(FRow.class);

   //============================================================
   // <T>构造逻辑单元缓冲。</T>
   //============================================================
   public FLogicCacheDataset(){
   }

   //============================================================
   // <T>获得缓冲频道。</T>
   //
   // @return 缓冲频道
   //============================================================
   public FLogicCacheChannel channel(){
      return _channel;
   }

   //============================================================
   // <T>设置缓冲频道。</T>
   //
   // @return 缓冲频道
   //============================================================
   public void setChannel(FLogicCacheChannel channel){
      _channel = channel;
   }

   //============================================================
   // <T>获得名称。</T>
   //
   // @return 名称
   //============================================================
   public String name(){
      return _name;
   }

   //============================================================
   // <T>设置名称。</T>
   //
   // @return 名称
   //============================================================
   public void setName(String name){
      _name = name;
   }

   //============================================================
   // <T>设置内存频道。</T>
   //
   // @return 内存频道
   //============================================================
   public void connect(FMemoryChannel memoryChannel){
      _memoryChannel = memoryChannel;
   }

   //============================================================
   // <T>生成表格键。</T>
   //
   // @return 表格键
   //============================================================
   public String makeTableKey(){
      // 获得键
      String databaseGuid = _channel.databaseGuid();
      // 生成键
      FString key = new FString();
      key.append("database(");
      key.append(databaseGuid);
      key.append(")|");
      key.append(_name);
      key.append("|guid");
      return key.toString();
   }

   //============================================================
   // <T>生成集合键。</T>
   //
   // @return 集合键
   //============================================================
   public String makeDatasetKey(){
      // 获得键
      String databaseGuid = _channel.databaseGuid();
      String tableGuid = tableGuid();
      // 生成键
      FString key = new FString();
      key.append("database(");
      key.append(databaseGuid);
      key.append(")|");
      key.append(_name);
      key.append("(");
      key.append(tableGuid);
      key.append(")|guid");
      return key.toString();
   }

   //============================================================
   // <T>生成集合键。</T>
   //
   // @return 集合键
   //============================================================
   public String makeRowKey(long rowId){
      // 获得键
      String databaseGuid = _channel.databaseGuid();
      String tableGuid = tableGuid();
      // 生成键
      FString key = new FString();
      key.append("database(");
      key.append(databaseGuid);
      key.append(")|");
      key.append(_name);
      key.append("(");
      key.append(tableGuid);
      key.append(")|row(");
      key.append(rowId);
      key.append(")");
      return key.toString();
   }

   //============================================================
   // <T>生成集合键。</T>
   //
   // @return 集合键
   //============================================================
   public String makeFetchKey(CharSequence code){
      // 获得键
      String databaseGuid = _channel.databaseGuid();
      String tableGuid = tableGuid();
      String datasetGuid = datasetGuid();
      // 生成键
      FString key = new FString();
      key.append("database(");
      key.append(databaseGuid);
      key.append(")|");
      key.append(_name);
      key.append("(");
      key.append(tableGuid);
      key.append(")|dataset(");
      key.append(datasetGuid);
      key.append(")|");
      key.append(code);
      return key.toString();
   }

   //============================================================
   // <T>获得表格代码。</T>
   //
   // @return 代码
   //============================================================
   public String tableGuid(){
      if(RString.isEmpty(_tableGuid)){
         // 获得代码
         String key = makeTableKey();
         _tableGuid = _memoryChannel.getString(key);
         // 写入代码
         if(_tableGuid == null){
            _tableGuid = RUuid.simpleUuid();
            _memoryChannel.set(key, _tableGuid);
         }
      }
      return _tableGuid;
   }

   //============================================================
   // <T>刷新表格处理。</T>
   //
   // @param channel 内存缓冲频道
   //============================================================
   public void tableFlush(){
      String key = makeTableKey();
      String code = RUuid.simpleUuid();
      _memoryChannel.set(key, code);
   }

   //============================================================
   // <T>获得集合代码。</T>
   //
   // @return 代码
   //============================================================
   public String datasetGuid(){
      if(RString.isEmpty(_tableGuid)){
         // 获得代码
         String key = makeDatasetKey();
         _tableGuid = _memoryChannel.getString(key);
         // 写入代码
         if(_tableGuid == null){
            _tableGuid = RUuid.simpleUuid();
            _memoryChannel.set(key, _tableGuid);
         }
      }
      return _tableGuid;
   }

   //============================================================
   // <T>刷新集合处理。</T>
   //============================================================
   public void datasetFlush(){
      String key = makeDatasetKey();
      String code = RUuid.simpleUuid();
      _memoryChannel.set(key, code);
   }

   //============================================================
   // <T>获得记录行集合。</T>
   //
   // @return 记录行集合
   //============================================================
   public FCodeLongSet<FRow> rows(){
      return _rows;
   }

   //============================================================
   // <T>根据代码获得逻辑单元。</T>
   //
   // @param code 代码
   // @return 逻辑单元
   //============================================================
   public FRow get(long code){
      return _rows.get(code);
   }

   //============================================================
   // <T>根据代码设置逻辑单元。</T>
   //
   // @param code 代码
   // @param unit 逻辑单元
   //============================================================
   public void set(long code,
                   FRow row){
      _rows.set(code, row);
   }

   //============================================================
   // <T>清空处理。</T>
   //============================================================
   public void clear(){
      _rows.clear();
   }

   //============================================================
   // <T>断开处理。</T>
   //============================================================
   public void disconnect(){
      _tableGuid = null;
      _datasetGuid = null;
      clear();
   }
}
