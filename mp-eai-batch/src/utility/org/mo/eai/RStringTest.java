package org.mo.eai;

import org.mo.com.lang.FObjects;

public class RStringTest
{
   public static void main(String[] args){
      FObjects<String> items = new FObjects<String>(String.class);
      items.push("1");
      items.push("2");
      items.push("3");
      items.revert();
      // System.out.println(RUuid.simpleUuid());
      // String value = REncryption.decodeString("test", source);
      // System.out.println(value);
   }
}
