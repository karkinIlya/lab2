package joinData;

import org.apache.hadoop.mapreduce.Partitioner;

public class FirstPartitioner extends Partitioner {
    public FirstPartitioner() {
    }

    @Override
    public int getPartition(Object o, Object o2, int i) {
        return 0;
    }
}