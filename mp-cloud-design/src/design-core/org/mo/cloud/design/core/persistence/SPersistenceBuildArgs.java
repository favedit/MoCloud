package org.mo.cloud.design.core.persistence;

//============================================================
// <T>构建参数。</T>
//============================================================
public class SPersistenceBuildArgs
{
   // 命令
   protected EPersistenceAction _actionCd;

   // 类型
   protected EPersistenceType _typeCd;

   // 容器名称
   protected String _containerName;

   // 组件名称
   protected String _compenentName;

   //============================================================
   // <T>获得命令。</T>
   //
   // @return 命令
   //============================================================
   public EPersistenceAction actionCd(){
      return _actionCd;
   }

   //============================================================
   // <T>设置命令。</T>
   //
   // @param actionCd 命令
   //============================================================
   public void setActionCd(EPersistenceAction actionCd){
      _actionCd = actionCd;
   }

   //============================================================
   // <T>获得类型。</T>
   //
   // @return 类型
   //============================================================
   public EPersistenceType typeCd(){
      return _typeCd;
   }

   //============================================================
   // <T>设置类型。</T>
   //
   // @param typeCd 类型
   //============================================================
   public void setTypeCd(EPersistenceType typeCd){
      _typeCd = typeCd;
   }

   //============================================================
   // <T>获得容器名称。</T>
   //
   // @return 容器名称
   //============================================================
   public String containerName(){
      return _containerName;
   }

   //============================================================
   // <T>设置容器名称。</T>
   //
   // @param containerName 容器名称
   //============================================================
   public void setContainerName(String containerName){
      _containerName = containerName;
   }

   //============================================================
   // <T>获得组件名称。</T>
   //
   // @return 组件名称
   //============================================================
   public String compenentName(){
      return _compenentName;
   }

   //============================================================
   // <T>设置组件名称。</T>
   //
   // @param compenentName 组件名称
   //============================================================
   public void setCompenentName(String compenentName){
      _compenentName = compenentName;
   }
}
