package joinData;

import org.apache.hadoop.io.WritableComparable;
import org.jetbrains.annotations.NotNull;

public class TextPair implements WritableComparable {
    public TextPair(String first, String second) {
        this.first = first;
        this.second = second;
    }

    private final String first;
    private final String second;

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        return 0;
    }
}
