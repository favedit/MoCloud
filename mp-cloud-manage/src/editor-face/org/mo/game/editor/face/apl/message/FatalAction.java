/*
 * @(#)FatalAction.java
 *
 * Copyright 2005 microbject, All Rights Reserved.
 *
 */
package org.mo.game.editor.face.apl.message;

import org.mo.com.lang.FError;
import org.mo.web.protocol.context.IWebContext;

/**
 * <p>系统错误页面</p>
 * 
 * @author ALEX
 * @version 1.00 - 2005/11/03
 */
public class FatalAction{

   /**
    * <p>执行业务逻辑</p>
    * <p>create date:2005/04/06</p>
    * 
    * @param iContext 环境对象
    * @exception FError 业务逻辑例外
    * @exception Exception 例外
    */
   public void doAction(IWebContext iContext){
      //      FMessageForm oMsgForm = (FMessageForm) iContext.form(FMessageForm.class);
      //      FFatalMessage oMessage = oMsgForm.fatalMessage();
      //      if(oMessage != null){
      //         oMsgForm.set("message", oMessage.message());
      //         oMsgForm.set("description", oMessage.description());
      //         oMsgForm.commit();
      //      }
   }

}
