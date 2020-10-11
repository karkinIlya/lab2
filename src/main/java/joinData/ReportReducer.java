package joinData;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;


public class ReportReducer extends Reducer<TextPair, Text, Text, Text> {
    protected void reduce(TextPair key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Iterator<Text> iter = values.iterator();
        int min = -1, max = 0, sum = 0, count = 0;
        while (iter.hasNext()) {
            String call = iter.next().toString();
            int cur = Integer.parseInt(call);
            sum += cur;
            count++;
            max = max >= cur ? max : cur;
            if (min == -1) {
                min = cur;
            } else {
                min = min > cur ? cur : min;
            }

        }
        Text outValue = new Text("min: " + Integer.toString(min) + "\t" + "max: " + Integer.toString(max) +
                "\t" + "average: " + Integer.toString(sum / count));
        context.write(new Text(key.getFirst()), outValue);
    }

}