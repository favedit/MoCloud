package org.mo.eai;

import org.mo.com.io.FLinesFile;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RFloat;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;
import org.mo.eai.history.FHistoryCityData;
import org.mo.eai.history.FHistoryData;

public class RJsonExport
{
   public static void main(String[] args){
      FHistoryData history = new FHistoryData();
      FLinesFile file = new FLinesFile();
      file.loadFile("D:/Microbject/MoScript/data/investment.txt");
      for(String line : file.lines()){
         if(!RString.isEmpty(line)){
            String[] items = RString.split(line, ' ');
            if(items.length != 4){
               throw new FFatalError("Invalid count.");
            }
            String dateValue = RString.removeChar(items[0], '-');
            FHistoryCityData city = new FHistoryCityData();
            city.setCode(RInteger.parse(items[1]));
            city.setInvestmentDay(RFloat.parse(items[2]));
            city.setInvestmentTotal(RFloat.parse(items[3]));
            history.push(dateValue, city);
            System.out.println(items[0]);
         }
      }
      history.serializeFile("D:/Microbject/MoScript/source/ars/eai/investment.dat");
   }
}
