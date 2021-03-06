package org.mo.cloud.editor.web.apl.form;

import org.mo.com.lang.FObjectId;
import org.mo.com.lang.RDump;
import org.mo.com.lang.RString;
import org.mo.com.lang.generic.TDumpInfo;

public class FWebFormInfo
      extends FObjectId
{

   private String _action;

   private String _formName;

   private String _formSearch;

   private String _formOrder;

   private String _formValue;

   private String _history;

   @Override
   public TDumpInfo dump(TDumpInfo info){
      RDump.dump(info, this);
      info.append("[history=", _history);
      info.append(",action=", _action);
      info.append(",formName=", _formName);
      info.append(",formSearch=", _formSearch);
      info.append(",formOrder=", _formOrder);
      info.append(",formValue=", _formValue);
      info.append("]");
      return info;
   }

   public boolean equals(FWebFormInfo info){
      if(!RString.equalsNvl(_history, info._history)){
         return false;
      }
      if(!RString.equalsNvl(_action, info._action)){
         return false;
      }
      if(!RString.equalsNvl(_formName, info._formName)){
         return false;
      }
      if(!RString.equalsNvl(_formSearch, info._formSearch)){
         return false;
      }
      if(!RString.equalsNvl(_formOrder, info._formOrder)){
         return false;
      }
      if(!RString.equalsNvl(_formValue, info._formValue)){
         return false;
      }
      return true;
   }

   public String getAction(){
      return _action;
   }

   public String getFormName(){
      return _formName;
   }

   public String getFormOrder(){
      return _formOrder;
   }

   public String getFormSearch(){
      return _formSearch;
   }

   public String getFormValue(){
      return _formValue;
   }

   public String getHistory(){
      return _history;
   }

   public void setAction(String action){
      _action = action;
   }

   public void setFormName(String formName){
      _formName = formName;
   }

   public void setFormOrder(String formOrder){
      _formOrder = formOrder;
   }

   public void setFormSearch(String formSearch){
      _formSearch = formSearch;
   }

   public void setFormValue(String formValue){
      _formValue = formValue;
   }

   public void setHistory(String history){
      _history = history;
   }

}
