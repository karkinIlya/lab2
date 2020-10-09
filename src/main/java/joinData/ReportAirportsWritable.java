import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ReportAirportsWritable implements Writable {

    private int code;
    private String description;


    public void write(DataOutput out) throws IOException {
        out.writeInt(code);
        out.writeUTF(description);
    }

    public void readFields(DataInput in) throws  IOException {

    }

}