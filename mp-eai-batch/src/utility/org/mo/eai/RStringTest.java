package org.mo.eai;

import org.mo.com.encoding.REncryption;

public class RStringTest
{
   public static void main(String[] args){
      String source = REncryption.encodeString("ezubao_ai", "c20c1fc7158f77oBb6d");
      System.out.println(source);
      //      String value = REncryption.decodeString("test", source);
      //      System.out.println(value);
   }

}
