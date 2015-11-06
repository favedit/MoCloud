package job.runjob;

import job.map.UserViemTimeLoveMap;
import job.reduce.UserViemTimeLoveReduce;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class UserViemTimeLove
{

   public static void main(String[] args) throws Exception{
      //System.out.println("main***************************");

      Configuration conf = new Configuration();
      @SuppressWarnings("deprecation") Job job = new Job(conf);
      job.setJarByClass(UserViemTimeLove.class);
      job.setJobName("productPeriod");

      job.setOutputKeyClass(Text.class);
      job.setOutputValueClass(Text.class);

      job.setMapperClass(UserViemTimeLoveMap.class);
      job.setReducerClass(UserViemTimeLoveReduce.class);

      job.setInputFormatClass(TextInputFormat.class);
      job.setOutputFormatClass(TextOutputFormat.class);

      FileInputFormat.addInputPath(job, new Path(args[0]));
      FileOutputFormat.setOutputPath(job, new Path(args[1]));

      job.waitForCompletion(true);

      //System.out.println("跳过的行：" + job.getCounters().findCounter(Counter.LINESKIP).getValue());
      //System.out.println("不存在的期次：" + job.getCounters().findCounter(Counter.NOTEXISTPERIOD).getValue());
      /**
       * 定时任务脚本:/data/hadoop_job_crontab/userViemTimeLove.sh
       * ##把mysql表中的数据导出一个.txt文件稻城文件之前,/data/mysql_table_conf/cl_fin_prefe目录分配权限:chmod 777 cl_fin_prefe
       *    /usr/bin/mysqldump -uroot -pahyc@h5@hadloop -T /data/mysql_table_conf/cl_fin_prefer hadoopdb CL_FIN_PRODUCT_PERIOD --fields-terminated-by=\\, --lines-terminated-by=\\n >/dev/null 2>&1
       * ##把/data/mysql_table_config/cl_fin_prefer/目录下的CL_FIN_PRODUCT_PERIOD.txt文件导入hdfs:
       *    /data/hadoop/bin/hadoop fs -rmr /eai/config/cl_fin_prefer/CL_FIN_PRODUCT_PERIOD.txt >/dev/null 2>&1
       *    /data/hadoop/bin/hadoop fs -put /data/mysql_table_conf/cl_fin_prefer/CL_FIN_PRODUCT_PERIOD.txt /eai/config/cl_fin_prefer >/dev/null 2>&1
       * ##定时任务运行job计算:
       *   /data/hadoop/bin/hadoop fs -rmr /eai/output/output_userViemTimeLove  >/dev/null 2>&1
       *   /data/hadoop/bin/hadoop jar /data/hadoop_job_jar/userViemTimeLove.jar /eai/log/ezubao/ /eai/output/output_userViemTimeLove >/dev/null 2>&1
       *   /usr/bin/mysql -uroot -pahyc@h5@hadloop -D hadoopdb -e 'truncate table CL_FIN_PREFER' >/dev/null 2>&1
       *   /data/sqoop/bin/sqoop export --connect jdbc:mysql://10.163.226.43:3306/hadoopdb --username root --password ahyc@h5@hadloop --table CL_FIN_PREFER --export-dir /eai/output/output_userViemTimeLove/part-r-00000  --fields-terminated-by '\t' >/dev/null 2>&1
       * - -查询产品的pv
       * SELECT product_code,SUM(pv) FROM cl_member_month_pv GROUP BY product_code;
       *
       *
       */
   }
}
