public class RaportApp {
    public static void main(String[] args) throws Exception {
        f (args.length != 2) {
            System.err.println("Usage: HadoopMapReduce.WordCountApp <input path> <output path>");
            System.exit(-1);
        }
        Job job = Job.getInstance();
        job.setJarByClass(ReportApp.class);
    }
}