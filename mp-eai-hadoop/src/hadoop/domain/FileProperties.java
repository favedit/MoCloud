package domain;

public class FileProperties
{
   private String fileName;

   private boolean isModify = false;

   public String getFileName(){
      return fileName;
   }

   public boolean isModify(){
      return isModify;
   }

   public void setModify(boolean isModify){
      this.isModify = isModify;
   }

   public void setFileName(String fileName){
      this.fileName = fileName;
   }

   private FileProperties(){

   }

   private static FileProperties fileProperties = new FileProperties();

   public static FileProperties getFileProperties(){
      return fileProperties;
   }
}
