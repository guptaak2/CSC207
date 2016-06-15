package test;

import static org.junit.Assert.*;

import org.junit.Test;

import driver.Extracti10Index;

public class Extracti10IndexTest {
  Extracti10Index function = new Extracti10Index("sample1.html");
  Extracti10Index function2 = new Extracti10Index("sample2.html");
  
  @Test
  public void testi10Index1() {
    assertEquals("12", function.i10IndexTest); 
  }
  
  @Test
  public void testi10Index2() {
    assertEquals("9", function2.i10IndexTest);
  }

}
