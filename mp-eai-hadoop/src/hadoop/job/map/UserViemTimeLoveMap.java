package job.map;

import enumtype.Counter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import util.DateUtil;

public class UserViemTimeLoveMap
      extends Mapper<LongWritable, Text, Text, Text>
{
   private static Map<String, String> dataMap = new HashMap<String, String>();

   static{
      //要打成jar运行的map-reduce程序，最好不要和关系型数据库交互,先导出一个txt文件,把txt文件上传到hdfs中，通过FileSystem的api解析txt文件
      /*SimpleDataSource dataSource = new SimpleDataSource("com.mysql.jdbc.Driver", "jdbc:mysql://114.215.133.77:3306/hadoopdb", "root", "ahyc@h5@hadloop");
      SimpleJdbc jdbc = new SimpleJdbc(dataSource);
      List<ProductPeriod> list = null;
      try{
         list = (List<ProductPeriod>)jdbc.queryForBean("SELECT p.product_code,p.product_issue FROM cl_product_period p", new RowMapper<ProductPeriod>(){
            ProductPeriod productPeriod = null;

            @Override
            public ProductPeriod mapRow(ResultSet rs) throws SQLException{
               productPeriod = new ProductPeriod();
               productPeriod.setProduct_code(rs.getString("product_code"));
               productPeriod.setProduct_issue(rs.getString("product_issue"));
               return productPeriod;
            }
         });
      }catch(Exception e){
         e.printStackTrace();
      }

      for(ProductPeriod productPeriod : list){
         //System.out.println(productPeriod.getProduct_issue() + ":::" + productPeriod.getProduct_code());
         dataMap.put(productPeriod.getProduct_issue(), productPeriod.getProduct_code());
      }*/
      String hdfsPath = "hdfs://gagcluster/eai/config/cl_fin_prefer/CL_FIN_PRODUCT_PERIOD.txt";
      Configuration conf = new Configuration();
      InputStream in = null;
      try{
         FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
         in = fs.open(new Path(hdfsPath));
         BufferedReader read = new BufferedReader(new InputStreamReader(in));
         String line = null;
         try{
            while((line = read.readLine()) != null){
               //System.out.println("读一行****************:" + line.trim());
               String[] splitStr = line.split("\\,");
               dataMap.put(splitStr[2].trim(), splitStr[1].trim());
            }
         }catch(IOException e){
            e.printStackTrace();
         }
      }catch(IOException e){
         e.printStackTrace();
      }finally{
         try{
            in.close();
         }catch(IOException e){
            e.printStackTrace();
         }
      }
   }

   @Override
   public void map(LongWritable key,
                   Text value,
                   Context context) throws IOException, InterruptedException{
      //{"message":"A1\t20150916235959\t113.73.242.143\t911537\tPOST /home/index/hasborrow HTTP/1.0\thttp://www.ezubo.com/index.html\tMozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.135 BIDUBrowser/7.6 Safari/537.36","@timestamp":"2015-09-17T00:00:00.135+08:00","type":"applogs","host":"web6","path":"/data/web/diandiantou/applogs/wisdomCenter/2015-09-16-wisdom.log","dirlogname":"wisdomCenter","year":"2015","month":"09","day":"16","sublogname":"wisdom","client_ip":"10.173.241.55","rootdir":"pc","@version":"1"}

      /**
       * {"message":"A1
         20150916235959
         113.107.24.190
         0
         POST /member/common/newSendPhone/ HTTP/1.0
         https://www.ezubo.com/member/common/register/?invite=ZXpiMDAxMjE%3D&security=a95793bafe41924a8d4a4946671deee1
         Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1)","@timestamp":"2015-09-17T00:00:00.679+08:00","type":"applogs","host":"web8","path":"/data/web/diandiantou/applogs/wisdomCenter/2015-09-16-wisdom.log","dirlogname":"wisdomCenter","year":"2015","month":"09","day":"16","sublogname":"wisdom","client_ip":"10.165.53.99","rootdir":"pc","@version":"1"}

         911537   113.73.242.143 20150916235959 http://www.ezubo.com/index.html

       */
      String line = value.toString();
      try{

         String[] arrStr = line.split("\\\\t|\\t");

         String url = arrStr[5];

         Pattern p = Pattern.compile(".*/invest/\\d{3,}.html.*");//期号最少是三位数字
         Matcher m = p.matcher(url);

         if(!m.matches()){
            return;
         }
         if("0".equals(arrStr[3])){//userid=0,跳过,较少io
            return;
         }
         /*if(Long.parseLong(arrStr[1]) <= Long.parseLong(startTime)){
            return;
         }*/

         String productNum = url.split("/invest/|.html")[1];//取到期号对应的数字
         if(!dataMap.containsKey(productNum)){
            context.getCounter(Counter.NOTEXISTPERIOD).increment(1);
            return;
         }
         context.write(new Text(arrStr[3] + "\t" + dataMap.get(productNum) + "\t" + DateUtil.getTimeSegment(arrStr[1].substring(8, 10))), new Text("1"));
      }catch(Exception e){
         context.getCounter(Counter.LINESKIP).increment(1);
         return;
      }

   }
}
