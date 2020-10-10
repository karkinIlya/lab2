package joinData;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class ReportAirportsMapper extends Mapper<LongWritable, Text, Text, Text> {
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException {
        String line = value.toString();
        String[] data = line.split(",");
        for (int i = 1; i < data.length; i++) {
            context.write(new Text(key.toString()), new Text("0"));
        }
    }
}