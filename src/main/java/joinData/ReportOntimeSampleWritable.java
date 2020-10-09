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
        doubleData[0] = in.readDouble();
        doubleData[0] = in.readDouble();
    }
}
