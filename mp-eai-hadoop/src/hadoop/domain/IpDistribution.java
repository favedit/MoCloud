package domain;

public class IpDistribution
{
   private String ip;

   private String country;

   private String area;

   private String region;

   private String county;

   private String isp;

   public String getIp(){
      return ip;
   }

   public void setIp(String ip){
      this.ip = ip;
   }

   public String getCountry(){
      return country;
   }

   public void setCountry(String country){
      this.country = country;
   }

   public String getArea(){
      return area;
   }

   public void setArea(String area){
      this.area = area;
   }

   public String getRegion(){
      return region;
   }

   public void setRegion(String region){
      this.region = region;
   }

   public String getCounty(){
      return county;
   }

   public void setCounty(String county){
      this.county = county;
   }

   public String getIsp(){
      return isp;
   }

   public void setIsp(String isp){
      this.isp = isp;
   }
}
