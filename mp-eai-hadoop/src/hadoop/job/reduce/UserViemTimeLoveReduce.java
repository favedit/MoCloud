package job.reduce;

import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class UserViemTimeLoveReduce
      extends Reducer<Text, Text, Text, Text>
{
   @SuppressWarnings("unused")
   @Override
   public void reduce(Text key,
                      Iterable<Text> values,
                      Context context) throws IOException, InterruptedException{

      int num = 0;
      for(Text val : values){
         num++;
      }

      context.write(key, new Text(num + ""));
   }
}
