package org.mo.eai.country;

import java.util.Comparator;

public class SBoundaryPointComparator
      implements
         Comparator<SBoundaryPoint>
{
   @Override
   public int compare(SBoundaryPoint source,
                      SBoundaryPoint target){
      double sourceLength = source.length;
      double targetLength = target.length;
      if(sourceLength > targetLength){
         return 1;
      }else if(sourceLength < targetLength){
         return -1;
      }else{
         return 0;
      }
   }
}
