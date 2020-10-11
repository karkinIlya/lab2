package joinData;

import org.apache.hadoop.io.WritableComparable;

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
}
