package joinData;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ReportOntimeSampleWritable implements Writable {

    private int[] intData = new int[13];
    private double[] doubleData = new double[5];
    private String[] stringData = new String[5];
    /*
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
    private int flNum;
    private int originAirportId;
    private int originAirportSeoId;
    private int originCityMarketId;
    private int destAirportId;
    private int wheelsOn;
    private int arrTime;
    private double arrDelay;
    private double arrDelayNew;
    private double cancelled;
    private String cancellationCode;
    private double airTime;
    private double distance;
    */

    private String description;

    @Override
    public void write(DataOutput out) throws IOException {
        for(int i = 0; i < 5; i++) {
            out.writeInt(intData[i]);
        }
        out.writeUTF(stringData[0]);
        out.writeUTF(stringData[1]);
        out.writeInt(intData[5]);
        out.writeUTF(stringData[2]);
        out.writeUTF(stringData[3]);
        for(int i = 0; i < 7; i++) {
            out.writeInt(intData[i + 6]);
        }
        out.writeDouble(doubleData[0]);
        out.writeDouble(doubleData[1]);
        out.writeDouble(doubleData[2]);
        out.writeUTF(stringData[4]);
        out.writeDouble(doubleData[3]);
        out.writeDouble(doubleData[4]);
    }

    @Override
    public void readFields(DataInput in) throws  IOException {
        for(int i = 0; i < 5; i++) {
            intData[i] = in.readInt();
        }
        stringData[0] = in.readUTF();
        stringData[1] = in.readUTF();
        intData[5] = in.readInt();
        stringData[2] = in.readUTF();
        stringData[3] = in.readUTF();
        for(int i = 0; i < 7; i++) {
            intData[i + 6] = in.readInt();
        }
        doubleData[0] = in.readDouble();
        doubleData[1] = in.readDouble();
        doubleData[2] = in.readDouble();
        stringData[4] = in.readUTF();
        doubleData[3] = in.readDouble();
        doubleData[4] = in.readDouble();
    }

    @Override
    public String toString() {
        return "Samples []";
    }
}
