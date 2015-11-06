package job.runjob;

import enumtype.Counter;
import job.map.ProductUserCountMap;
import job.reduce.ProductUserCountReduce;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class ProductUserCount
{

   public static void main(String[] args) throws Exception{

      Configuration conf = new Configuration();
      @SuppressWarnings("deprecation") Job job = new Job(conf);
      job.setJarByClass(ProductUserCount.class);
      job.setJobName("productPeriod");

      job.setOutputKeyClass(Text.class);
      job.setOutputValueClass(Text.class);

      job.setMapperClass(new ProductUserCountMap().getClass());
      job.setReducerClass(ProductUserCountReduce.class);

      job.setInputFormatClass(TextInputFormat.class);
      job.setOutputFormatClass(TextOutputFormat.class);

      FileInputFormat.addInputPath(job, new Path(args[0]));
      FileOutputFormat.setOutputPath(job, new Path(args[1]));

      job.waitForCompletion(true);

      System.out.println("跳过的行：" + job.getCounters().findCounter(Counter.LINESKIP).getValue());
      System.out.println("不存在的期次：" + job.getCounters().findCounter(Counter.NOTEXISTPERIOD).getValue());
      //备注:上线之前一定要先同步议一下,产品和期次的最新关系,以免数据统计不准确.
      /**
       * 定时任务脚本:/data/hadoop_job_crontab/productUserCount.sh
       * ##把mysql表中的数据导出一个.txt文件稻城文件之前,/data/mysql_table_conf/cl_fin_month_pv目录分配权限:chmod 777 cl_fin_month_pv:
       *    /usr/bin/mysqldump -uroot -pahyc@h5@hadloop -T /data/mysql_table_conf/product_user_count hadoopdb CL_FIN_PRODUCT_PERIOD --fields-terminated-by=\\, --lines-terminated-by=\\n >/dev/null 2>&1
       * ##把/data/mysql_table_conf/cl_fin_month_pv目录下的CL_FIN_PRODUCT_PERIOD.txt文件导入hdfs:
       *    /data/hadoop/bin/hadoop fs -rmr /eai/config/product_user_count/CL_FIN_PRODUCT_PERIOD.txt >/dev/null 2>&1
       *    /data/hadoop/bin/hadoop fs -put /data/mysql_table_conf/product_user_count/CL_FIN_PRODUCT_PERIOD.txt /eai/config/product_user_count >/dev/null 2>&1
       * ##定时任务运行job计算:
       *   /data/hadoop/bin/hadoop fs -rmr /eai/output/output_productUserCount >/dev/null 2>&1
       *   /data/hadoop/bin/hadoop jar /data/hadoop_job_jar/productUserCount.jar /eai/log/ezubao/ /eai/output/output_productUserCount >/dev/null 2>&1
       *   /usr/bin/mysql -uroot -pahyc@h5@hadloop -D hadoopdb -e 'truncate table CL_FIN_CUSTOMER_PRODUCT_PV' >/dev/null 2>&1
       *   /data/sqoop/bin/sqoop export --connect jdbc:mysql://10.163.226.43:3306/hadoopdb --username root --password ahyc@h5@hadloop --table CL_FIN_CUSTOMER_PRODUCT_PV --export-dir /eai/output/output_productUserCount/part-r-00000  --fields-terminated-by '\t' --update-mode allowinsert --update-key MEMBER_ID,PRODUCT_CODE,FYEAR_MONTH --columns 'MEMBER_ID,PRODUCT_CODE,PV,FYEAR_MONTH,LAST_VIEW_TIME,UPDATE_DATE' >/dev/null 2>&1
       *
       */

   }
}
