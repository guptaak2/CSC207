package aircraft;
import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;
public class FlightDataRecorderTest {
  public FlightDataRecorder f1=new FlightDataRecorder();
  public void populateRec(){
    f1.record(1.0);
    f1.record(2.0);
    f1.record(3.0);
    f1.record(4.0);
    f1.record(5.0);
    f1.record(6.0);
    f1.record(7.0);
    f1.record(8.0);
    f1.record(9.0);
    f1.record(10.0);
  }
  @Test
  public void testFlightDataRecorder() {
    populateRec();
    assertEquals("It should be", "1.0", f1.getRecordedData().get(0).toString());
    assertEquals("It should be", "10.0", f1.getRecordedData().get(9).toString());
    f1.record(11.0);
    assertEquals("It should be","11.0",f1.getRecordedData().get(0).toString());
  }
  @Test
  public void testRecord() {
    populateRec();
    assertEquals("It should be", "1.0", f1.getRecordedData().get(0).toString());
    assertEquals("It should be", "10.0", f1.getRecordedData().get(9).toString());
    f1.record(11.0);
    assertEquals("It should be","11.0",f1.getRecordedData().get(0).toString());
  }
  @Test
  public void testGetRecordedData() {
    populateRec();
    for (int i =0; i<f1.getRecordedData().size();i++){
      assertEquals("It should be", i+1+".0", f1.getRecordedData().get(i).toString());
    }
    f1.record(11.0);
    for (int i =1; i<f1.getRecordedData().size();i++){
      assertEquals("It should be", i+1+".0", f1.getRecordedData().get(i).toString());
    }
    assertEquals("It should be", 11+".0", f1.getRecordedData().get(0).toString());
  }
  @Test
  public void testGetLastDataPoints() {
    populateRec();
    f1.record(11.0);
    List l1=f1.getLastDataPoints(1);
    assertEquals("It should be","10.0",l1.get(0).toString());
    l1=f1.getLastDataPoints(4);
    assertEquals("It should be","7.0",l1.get(3).toString());
    
  }
  @Test
  public void testAverage() {
    populateRec();
    assertEquals("It should be ","5.5", Double.toString(f1.average()));
  }
}