package joinData;

import org.apache.hadoop.io.RawComparator;
import org.jetbrains.annotations.NotNull;

public class GroupingComparator implements Comparable<TextPair> {

    @Override
    public int compareTo(@NotNull TextPair o) {
        return 0;
    }
}
