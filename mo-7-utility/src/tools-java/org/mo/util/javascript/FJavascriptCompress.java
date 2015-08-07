package org.mo.util.javascript;

import org.mo.com.io.FStringFile;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FInts;
import org.mo.com.lang.FString;
import org.mo.com.lang.RHex;

public class FJavascriptCompress
{
   // 字符串
   public static final String STRING_CODE = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

   protected FDictionary<SJavascriptBlock> _blocks = new FDictionary<SJavascriptBlock>(SJavascriptBlock.class);

   protected FInts _indexes = new FInts();

   public void push(String code){
      SJavascriptBlock block = _blocks.find(code);
      if(block == null){
         block = new SJavascriptBlock();
         block.code = code;
         block.index = _blocks.count();
         _blocks.set(code, block);
      }
      block.count++;
      _indexes.append(block.index);
   }

   public void loadFile(String fileName){
      FStringFile file = new FStringFile(fileName);
      String source = file.toString();
      char[] data = source.toCharArray();
      int count = data.length;
      FString block = new FString();
      boolean blockFlag = false;
      for(int n = 0; n < count; n++){
         char value = data[n];
         boolean blockChar = STRING_CODE.indexOf(value) != -1;
         if(blockFlag != blockChar){
            if(!block.isEmpty()){
               push(block.toString());
            }
            block.clear();
            blockFlag = blockChar;
         }
         block.append(value);
      }
      if(!block.isEmpty()){
         push(block.toString());
      }
   }

   public void compress(String fileName){
      System.out.println("Block count:" + _blocks.count());
      FString blockSource = new FString();
      int blockCount = _blocks.count();
      for(int i = 0; i < blockCount; i++){
         SJavascriptBlock block = _blocks.value(i);
         System.out.println("[" + block.code + "] - " + block.count);
         if(i != 0){
            blockSource.append(",");
         }
         blockSource.append("\"" + block.code + "\"");
      }
      FString indexSource = new FString();
      int indexCount = _indexes.length();
      for(int i = 0; i < indexCount; i++){
         int index = _indexes.get(i);
         if(i != 0){
            //indexSource.append(",");
         }
         indexSource.append(RHex.format(index, 4));
         //indexSource.append(index + "");
      }
      FStringFile file = new FStringFile();
      file.append(blockSource);
      file.append(indexSource);
      file.saveFile(fileName);
   }

   public static void main(String[] args){
      FJavascriptCompress compress = new FJavascriptCompress();
      compress.loadFile("D:/Microbject/MoScript/source/ajs/release/me.js");
      compress.compress("D:/Microbject/MoScript/source/ajs/release/me2.js");
      System.out.println("Compress success.");
   }
}
