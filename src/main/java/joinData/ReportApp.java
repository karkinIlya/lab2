package joinData;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.join.CompositeInputFormat;
import org.apache.hadoop.mapred.lib.MultipleInputs;
import org.apache.hadoop.mapreduce.Job;


public class ReportApp {
    public static void main(String[] args) throws Exception {
        Job job = Job.getInstance();
        job.setJarByClass(ReportApp.class);
        job.setJobName("Report job");
        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, ReportMapper.class);
        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, SystemsJoinMapper.class);

    }
}