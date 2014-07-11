package org.mo.jfa.face.logic.webform;

import org.mo.web.core.container.AContainer;

import org.mo.eng.data.common.ISqlContext;
import org.mo.jfa.face.inc.form.IFormAble;
import org.mo.web.protocol.context.IWebContext;

/**
 * 显示数据操作用的表单
 * 
 * @author maocy
 */
public interface IWebFormAction
      extends
         IFormAble
{

   String back(IWebContext context,
               ISqlContext sqlContext,
               @AContainer(name = "page") FWebFormPage page);

   /**
    * 在数据库内删除一条记录的表单显示操作。
    * →form_search(pack格式)：数据库内要删除的记录。
    * 
    * @param context WEB环境对象
    * @param sqlContext SQL环境对象
    * @param page 数据页面
    * @return 转向地址
    */
   String delete(IWebContext context,
                 ISqlContext sqlContext,
                 @AContainer(name = "page") FWebFormPage page);

   /**
    * 在数据库内插入一条记录的表单显示操作
    * 
    * @param context WEB环境对象
    * @param sqlContext SQL环境对象
    * @param page 数据页面
    * @return 转向地址
    */
   String insert(IWebContext context,
                 ISqlContext sqlContext,
                 @AContainer(name = "page") FWebFormPage page);

   String list(IWebContext context,
               ISqlContext sqlContext,
               @AContainer(name = "page") FWebFormPage page);

   /**
    * 一条记录的表单显示操作
    * 
    * @param context WEB环境对象
    * @param sqlContext SQL环境对象
    * @param page 数据页面
    * @return 转向地址
    */
   String show(IWebContext context,
               ISqlContext sqlContext,
               @AContainer(name = "page") FWebFormPage page);

   /**
    * 在数据库内修改一条记录的表单显示操作
    * →form_search(pack格式)：数据库内要修改的记录。
    * 
    * @param context WEB环境对象
    * @param sqlContext SQL环境对象
    * @param page 数据页面
    * @return 转向地址
    */
   String update(IWebContext context,
                 ISqlContext sqlContext,
                 @AContainer(name = "page") FWebFormPage page);

}
