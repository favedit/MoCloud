package job.reduce;

import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import util.DateUtil;

public class ProductUserCountReduce
      extends Reducer<Text, Text, Text, Text>
{

   @SuppressWarnings("unused")
   @Override
   public void reduce(Text key,
                      Iterable<Text> values,
                      Context context) throws IOException, InterruptedException{

      int num = 0;
      String lastViewTime = "0";
      for(Text val : values){
         num++;
         lastViewTime = Long.parseLong(lastViewTime) >= Long.parseLong(val.toString()) ? lastViewTime + "" : val.toString();
      }

      context.write(key, new Text(num + "\t" + lastViewTime + "\t" + DateUtil.GetDateTime()));
   }
}
