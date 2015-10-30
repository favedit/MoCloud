package org.mo.content.core.excel.synchronize;

import com.cyou.gccloud.data.data.FDataCommonCountryLogic;
import com.cyou.gccloud.data.data.FDataCommonCountryUnit;
import org.mo.com.lang.FAttributes;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.FLogicDataset;
import org.mo.eng.data.IDatabaseConsole;

public class ChangedCountryName
{
   public static void main(String[] args){
      try{
         FAttributes attributes = RAop.configConsole().defineCollection().attributes();
         attributes.set("application", "D:/Microbject/MoCloud/");
         RAop.initialize("D:/Microbject/MoCloud/mp-eai-manage/src/config/application-test.xml");
         IDatabaseConsole databaseConsole = RAop.find(IDatabaseConsole.class);
         @SuppressWarnings("resource") FLogicContext logicContext = new FLogicContext(databaseConsole);
         FDataCommonCountryLogic countryLogic = logicContext.findLogic(FDataCommonCountryLogic.class);
         FLogicDataset<FDataCommonCountryUnit> allUnits = countryLogic.fetchAll();
         for(FDataCommonCountryUnit unit : allUnits){
            String temp = "";
            temp = unit.name();
            unit.setName(unit.label());
            unit.setLabel(temp);
            countryLogic.doUpdate(unit);
            System.out.println("name:" + unit.name() + "    label:" + unit.label());
         }
      }catch(Exception e){
         e.printStackTrace();
      }
   }

}
