package joinData;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ReportOntimeSampleWritable implements Writable {

    private int year;
    private int quarter;
    private int month;
    private int dayOfMonth;
    private int dayOfWeek;
    private String flDate;
    private String uniqueCarrier;
    private int airlineId;
    private String carrier;
    private String tailNum;
    private  int flNum;
    private  int originAirportId;
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
