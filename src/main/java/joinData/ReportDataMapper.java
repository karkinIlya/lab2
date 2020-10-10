package joinData;


import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.join.TupleWritable;

import java.io.IOException;

public class ReportDataMapper extends Mapper<Text, TupleWritable, Text, Text> {
    @Override
    public void map(Text key, TupleWritable value, OutputCollector<Text, Text> output,
                    Reporter reporter) throws IOException {

    }
}