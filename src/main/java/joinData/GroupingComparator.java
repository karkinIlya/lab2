package joinData;

import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.io.WritableComparator;

public class GroupingComparator extends WritableComparator  {
    public int compare (TextPair o1, TextPair o2) {
        return o1.getFirst().compareTo(o2.getFirst());
    }
}
