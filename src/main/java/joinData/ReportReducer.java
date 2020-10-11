package joinData;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;


public class ReportReducer extends Reducer<TextPair, Text, Text, Text> {
    protected void reduce(TextPair key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Iterator<Text> iter = values.iterator();
        String sys = iter.next().toString();
        if (!iter.hasNext())
            return;
        float min = -1, max = 0, sum = 0;
        int count = 0;
        while (iter.hasNext()) {
            String call = iter.next().toString();
            float cur = Float.parseFloat(call);
            sum += cur;
            count++;
            max = max >= cur ? max : cur;
            if (min == -1) {
                min = cur;
            } else {
                min = min > cur ? cur : min;
            }

        }
        Text outValue = new Text(String.format("min: %.3f\t max: %.3f\t average: %.3f\t", min, max, sum / count));
        context.write(outValue, new Text(sys));
    }

}