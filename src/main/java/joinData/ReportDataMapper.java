package joinData;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.join.TupleWritable;

import java.io.IOException;

public class ReportDataMapper extends Mapper<LongWritable, Text, TextPair, Text> {
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] data = line.split(",");
        if (data[19].equals("0.00") && !data[18].equals("0.00") && !data[18].equals("")) {
            System.out.println("              map data        " + " " + data[14] + " " + data[18]);
            context.write(new TextPair(data[14].substring(1, data[14].length() - 1), "1"),
                    new Text(data[18].substring(1, data[18].length() - 1)));
        }
    }
}