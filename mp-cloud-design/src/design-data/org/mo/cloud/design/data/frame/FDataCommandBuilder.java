package org.mo.cloud.design.data.frame;

import org.mo.com.lang.FObjects;
import org.mo.com.lang.FString;

public class FDataCommandBuilder
{
   protected String _dataName;

   protected FObjects<FDataField> _fields = new FObjects<FDataField>(FDataField.class);

   public String dataName(){
      return _dataName;
   }

   public void setDataName(String dataName){
      _dataName = dataName;
   }

   public FObjects<FDataField> fields(){
      return _fields;
   }

   public String makeFetchCommand(){
      FString sql = new FString();
      boolean first = false;
      sql.append("SELECT ");
      for(FDataField field : _fields){
         if(!first){
            first = true;
         }else{
            sql.append(",");
         }
         sql.append(field.dataName());
      }
      sql.append(" FROM ");
      sql.append(_dataName);
      return sql.toString();
   }

}
