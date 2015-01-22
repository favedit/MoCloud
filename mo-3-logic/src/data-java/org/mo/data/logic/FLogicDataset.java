package org.mo.data.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONObject;
import org.mo.com.collections.FDataset;
import org.mo.com.collections.FRow;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.reflect.RClass;

//============================================================
// <T>逻辑数据集合。</T>
//============================================================
public class FLogicDataset<T extends FLogicUnit>
      extends FObjects<T>
{
   // 逻辑环境
   protected ILogicContext _logicContext;

   // 总记录数
   protected int _total;

   // 分页记录数
   protected int _pageSize = RInteger.SIZE_4K;

   // 总页数
   protected int _pageCount;

   // 页号
   protected int _page;

   //============================================================
   // <T>构造逻辑数据集合。</T>
   //============================================================
   public FLogicDataset(){
   }

   //============================================================
   // <T>构造逻辑数据集合。</T>
   //
   // @param clazz 类对象
   //============================================================
   public FLogicDataset(Class<T> clazz){
      super(clazz);
   }

   //============================================================
   // <T>构造逻辑数据集合。</T>
   //
   // @param clazz 类对象
   // @param capacity 容量
   //============================================================
   public FLogicDataset(Class<T> clazz,
                        int capacity){
      super(clazz, capacity);
   }

   //============================================================
   // <T>构造逻辑数据集合。</T>
   //
   // @param clazz 类对象
   //============================================================
   public FLogicDataset(Class<T> clazz,
                        ILogicContext logicContext){
      super(clazz);
      _logicContext = logicContext;
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
   // <T>设置逻辑环境。</T>
   //
   // @param logicContext 逻辑环境
   //============================================================
   public void linkLogicContext(ILogicContext logicContext){
      _logicContext = logicContext;
   }

   //============================================================
   // <T>获得总记录数。</T>
   //
   // @return 总记录数
   //============================================================
   public int total(){
      return _total;
   }

   //============================================================
   // <T>设置总记录数。</T>
   //
   // @param total 总记录数
   //============================================================
   public void setTotal(int total){
      _total = total;
   }

   //============================================================
   // <T>获得分页记录数。</T>
   //
   // @return 分页记录数
   //============================================================
   public int pageSize(){
      return _pageSize;
   }

   //============================================================
   // <T>设置分页记录数。</T>
   //
   // @param pageSize 分页记录数
   //============================================================
   public void setPageSize(int pageSize){
      _pageSize = pageSize;
   }

   //============================================================
   // <T>获得总页数。</T>
   //
   // @return 总页数
   //============================================================
   public int pageCount(){
      return _pageCount;
   }

   //============================================================
   // <T>设置总页数。</T>
   //
   // @param pageCount 总页数
   //============================================================
   public void setPageCount(int pageCount){
      _pageCount = pageCount;
   }

   //============================================================
   // <T>获得页号。</T>
   //
   // @return 页号
   //============================================================
   public int page(){
      return _page;
   }

   //============================================================
   // <T>获得首页号。</T>
   //
   // @return 页号
   //============================================================
   public int firstPage(){
      return 1;
   }

   //============================================================
   // <T>获得前一页号。</T>
   //
   // @return 页号
   //============================================================
   public int priorPage(){
      if(_page > 1){
         return _page - 1;
      }
      return _page;
   }

   //============================================================
   // <T>获得前一页号。</T>
   //
   // @return 页号
   //============================================================
   public int nextPage(){
      if(_page < _pageCount - 1){
         return _page + 1;
      }
      if(_pageCount > 1){
         return _pageCount - 1;
      }
      return 1;
   }

   //============================================================
   // <T>获得前一页号。</T>
   //
   // @return 页号
   //============================================================
   public int lastPage(){
      if(_pageCount > 1){
         return _pageCount - 1;
      }
      return 1;
   }

   //============================================================
   // <T>设置页号。</T>
   //
   // @param page 页号
   //============================================================
   public void setPage(int page){
      _page = page;
   }

   //============================================================
   // <T>加载数据集合。</T>
   //
   // @param dataset 数据集合
   //============================================================
   public void loadDataset(FDataset dataset){
      // 设置属性
      _total = dataset.total();
      _pageSize = dataset.pageSize();
      _pageCount = dataset.pageCount();
      _page = dataset.page();
      // 设置数据
      int count = dataset.count();
      for(int n = 0; n < count; n++){
         FRow row = dataset.get(n);
         T unit = RClass.newInstance(_clazz);
         unit.linkLogicContext(_logicContext);
         unit.load(row);
         push(unit);
      }
   }

   //============================================================
   // <T>创建页码数据集。</T>
   //
   // @param dataset 数据集合
   //============================================================
   public FLogicDataset<T> makePage(int page,
                                    int pageSize){
      int total = this.count();
      int pageCount = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
      // 设置数据
      FLogicDataset<T> pageDataset = new FLogicDataset<T>(_clazz);
      pageDataset.setPage(page);
      pageDataset.setPageSize(pageSize);
      pageDataset.setTotal(total);
      pageDataset.setPageCount(pageCount);
      //填充数据
      if(page < pageCount){
         int beginIndex = page * pageSize;
         //判断当页结尾索引是否大于当前dataset的最大索引
         int endIndex = beginIndex + pageSize - 1;
         int datasetEndIndex = total - 1;
         if(endIndex <= datasetEndIndex){
            for(int n = beginIndex; n <= endIndex; n++){
               T unit = this.get(n);
               pageDataset.push(unit);
            }
         }else{
            for(int n = beginIndex; n <= datasetEndIndex; n++){
               T unit = this.get(n);
               pageDataset.push(unit);
            }
         }
      }
      return pageDataset;
   }

   //============================================================
   // <T>获得JSON字符串。</T>
   //
   // @return JSON字符串
   //============================================================
   @SuppressWarnings({"rawtypes", "unchecked"})
   public String toJsonListString(){
      List list = new ArrayList();
      for(int n = 0; n < _count; n++){
         FLogicUnit unit = _items[n];
         Map<String, String> map = new HashMap<>();
         unit.saveMap(map);
         JSONObject jsonObject = JSONObject.fromObject(map);
         list.add(jsonObject);
      }
      return "{\"total\":" + _total + ",\"rows\":" + list + "}";
   }

   //============================================================
   // <T>获得JSON字符串。</T>
   //
   // @return JSON字符串
   //============================================================
   @SuppressWarnings({"rawtypes", "unchecked"})
   public String toJsonString(){
      List list = new ArrayList();
      for(int n = 0; n < _count; n++){
         FLogicUnit unit = _items[n];
         Map<String, String> map = new HashMap<>();
         unit.saveMap(map);
         JSONObject jsonObject = JSONObject.fromObject(map);
         list.add(jsonObject);
      }

      return list.toString();
   }
}
