package joinData;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;


public class ReportReducer extends Reducer<TextPair, Text, Text, Text> {
    protected void reduce(TextPair key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Iterator<Text> iter = values.iterator();
        System.out.println("        ------------- reducer -----------\nkey: " + key.getFirst() + " " + key.getSecond());
        String sys = iter.next().toString();
        System.out.println(sys);
        float min = -1, max = 0, sum = 0;
        int count = 0;
        while (iter.hasNext()) {
//            System.out.println("              reducer        " + key.getFirst() + key.getSecond());
            String call = iter.next().toString();
            System.out.println(call);
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
        Text outValue = new Text("min: " + min + "\t" + "max: " + max + "\t" + "average: " + sum / count);
        context.write(new Text(sys), outValue);
    }

}