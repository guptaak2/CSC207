package test;

import static org.junit.Assert.*;
import driver.*;

import org.junit.Test;

public class MyParserTest {

  @Test(expected = NullPointerException.class)
  public void testEmptyArguments() throws Exception {
    MyParser parser = new MyParser();
    parser.main(new String[] {});
  }
  
  @Test
  public void testWrongFileName() throws Exception {
    MyParser parser = new MyParser();
    parser.main(new String[] {"sample5.html"});
  }
}
