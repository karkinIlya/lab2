package joinData;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class ReportAirportsMapper extends Mapper<LongWritable, Text, TextPair, Text> {
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] data = line.split(",");
        for (int i = 0; i < data.length; i++) {
            if (data[0] != "Code") {
                String tmp = data[0].replace("\"", "");
                context.write(new TextPair(tmp, "0"), new Text(tmp));
            }
        }
    }
}