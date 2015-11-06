package domain;

public class ProductPeriod
{
   private String product_code;

   private String product_issue;

   public String getProduct_code(){
      return product_code;
   }

   public void setProduct_code(String product_code){
      this.product_code = product_code;
   }

   public String getProduct_issue(){
      return product_issue;
   }

   public void setProduct_issue(String product_issue){
      this.product_issue = product_issue;
   }
}
