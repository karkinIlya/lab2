package joinData;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class ReportAirportsMapper extends Mapper<LongWritable, Text, TextPair, Text> {
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        if (!line.equals("Code,Description")) {
            String[] data = line.split(",\"");
            String tmp = data[0].substring(1, data[0].length() - 1);
            System.out.println("              mapairports        " + " " + tmp);
            context.write(new TextPair(tmp, "0"), new Text(data[1]));
        }
    }
}