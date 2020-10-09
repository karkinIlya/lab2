package joinData;

import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.join.CompositeInputFormat;

import java.nio.file.Path;

public class ReportApp {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: HadoopMapReduce.WordCountApp <input path> <output path>");
            System.exit(-1);
        }
        JobConf conf = new JobConf(ReportApp.class);
        conf.setJobName("map join");
        conf.setInputFormat(CompositeInputFormat.class);
        FileOutputFormat.setOutputPath(conf, new Path(args[2]));
        conf.set("mapred.join.expr", CompositeInputFormat.compose("inner",
                KeyValueTextInputFormat.class,
                args[0],
                args[1]
        ));
        conf.setMapperClass(MapJoinMapper.class);
        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(Text.class);
        JobClient.runJob(conf);
    }
}