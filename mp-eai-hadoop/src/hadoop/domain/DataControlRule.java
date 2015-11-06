package domain;

public class DataControlRule
{
   private int ruleCD;

   private int percentage;

   private int scorePoint;

   private String parameters1;

   private String parameters2;

   private String parameters3;

   private String parameters4;

   public int getRuleCD(){
      return ruleCD;
   }

   public void setRuleCD(int ruleCD){
      this.ruleCD = ruleCD;
   }

   public int getPercentage(){
      return percentage;
   }

   public void setPercentage(int percentage){
      this.percentage = percentage;
   }

   public int getScorePoint(){
      return scorePoint;
   }

   public void setScorePoint(int scorePoint){
      this.scorePoint = scorePoint;
   }

   public String getParameters1(){
      return parameters1;
   }

   public void setParameters1(String parameters1){
      this.parameters1 = parameters1;
   }

   public String getParameters2(){
      return parameters2;
   }

   public void setParameters2(String parameters2){
      this.parameters2 = parameters2;
   }

   public String getParameters3(){
      return parameters3;
   }

   public void setParameters3(String parameters3){
      this.parameters3 = parameters3;
   }

   public String getParameters4(){
      return parameters4;
   }

   public void setParameters4(String parameters4){
      this.parameters4 = parameters4;
   }

}
