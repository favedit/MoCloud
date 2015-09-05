package org.mo.content.face.system.design;

import org.mo.cloud.logic.data.person.FGcUserInfo;
import org.mo.cloud.logic.data.solution.FGcProjectInfo;
import org.mo.com.lang.FObjectId;

//============================================================
// <P>私人页面。</P>
//============================================================
public class FSpacePage
      extends FObjectId
{
   // 用户信息
   protected FGcUserInfo _user;

   // 项目信息
   protected FGcProjectInfo _project;

   //============================================================
   // <P>获得用户信息。</P>
   //
   // @return 用户信息
   //============================================================
   public FGcUserInfo user(){
      return _user;
   }

   //============================================================
   // <P>设置用户信息。</P>
   //
   // @param user 用户信息
   //============================================================
   public void setUser(FGcUserInfo user){
      _user = user;
   }

   //============================================================
   // <P>获得项目信息。</P>
   //
   // @return 项目信息
   //============================================================
   public FGcProjectInfo project(){
      return _project;
   }

   //============================================================
   // <P>设置项目信息。</P>
   //
   // @param project 项目信息
   //============================================================
   public void setProject(FGcProjectInfo project){
      _project = project;
   }
}
