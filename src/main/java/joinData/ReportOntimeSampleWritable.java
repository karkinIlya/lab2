package joinData;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ReportOntimeSampleWritable implements Writable {

    private int code;
    private String description;

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(code);
        out.writeUTF(description);
    }

    @Override
    public void readFields(DataInput in) throws  IOException {
        code = in.readInt();
        description = in.readUTF();
    }
}
