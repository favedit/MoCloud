package org.mo.data.logic.cache;

import org.mo.com.console.FConsole;
import org.mo.com.system.FObjectPool;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;
import org.mo.eng.memorycache.FMemoryChannel;
import org.mo.eng.memorycache.IMemoryCacheConsole;

//============================================================
// <T>逻辑单元缓冲控制台。</T>
// <P>LG(GUID)|database|guid</P>
// <P>LG(GUID)|database(GUID)|table|guid</P>
// <P>LG(GUID)|database(GUID)|table(GUID)|guid</P>
// <P>LG(GUID)|database(GUID)|table(GUID)|row(ID)                     [find]</P>
// <P>LG(GUID)|database(GUID)|table(GUID)|dataset(GUID)|code          [search]</P>
// <P>LG(GUID)|database(GUID)|table(GUID)|dataset(GUID)|pageSize|page [fetch]</P>
// <P>FIND         - 不处理</P>
// <P>SEARCH       - 不处理</P>
// <P>FETCH        - 不处理</P>
// <P>INSERT       - 不处理</P>
// <P>UPDATE       - 删除RowId，更新DatasetGuid</P>
// <P>DELETE       - 删除RowId，更新DatasetGuid</P>
// <P>TABLE-SQL    - 更新TableGuid</P>
// <P>DATABASE-SQL - 更新DatabaseGuid</P>
// <P>RESTART      - 更新LogicGuid</P>
//============================================================
public class FLogicCacheConsole
      extends FConsole
      implements
         ILogicCacheConsole
{
   // 允许缓冲
   @AProperty
   protected boolean _enable;

   // 设置过
   protected boolean _setuped;

   // 逻辑单元缓冲频道集合
   protected FObjectPool<FLogicCacheChannel> _channels = new FObjectPool<FLogicCacheChannel>();

   // 内存缓冲控制台
   @ALink
   protected IMemoryCacheConsole _memoryCacheConsole;

   //============================================================
   // <T>初始化处理。</T>
   //============================================================
   public void initialize(){
   }

   //============================================================
   // <T>测试是否允许。</T>
   //
   // @return 是否允许
   //============================================================
   @Override
   public boolean isEnable(){
      return _enable;
   }

   //============================================================
   // <T>收集一个内存频道。</T>
   //
   // @return 内存频道
   //============================================================
   @Override
   public FLogicCacheChannel alloc(FMemoryChannel memoryChannel){
      // 检查内存缓冲
      if(!_memoryCacheConsole.isEnable()){
         return null;
      }
      // 收集频道
      FLogicCacheChannel channel = null;
      if(_enable){
         // 收集处理
         channel = _channels.alloc();
         if(channel == null){
            channel = new FLogicCacheChannel();
            channel.setConsole(this);
            channel.setup();
         }
         // 链接处理
         channel.connect(memoryChannel);
      }
      return channel;
   }

   //============================================================
   // <T>释放一个内存频道。</T>
   //
   // @param channel 内存频道
   //============================================================
   @Override
   public void free(FLogicCacheChannel channel){
      if(_enable){
         // 断开处理
         channel.disconnect();
         // 回收处理
         _channels.free(channel);
      }
   }
}
