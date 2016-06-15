package test;

import static org.junit.Assert.*;

import org.junit.Test;

import driver.ExtractCitations;

public class ExtractCitationsTest {
  ExtractCitations function = new ExtractCitations("sample1.html");
  ExtractCitations function2 = new ExtractCitations("sample2.html");
  
  @Test
  public void testCitations1() {
    assertEquals("437", function.CitationsTest); 
  }
  
  @Test
  public void testCitations2() {
    assertEquals("263", function2.CitationsTest);
  }
}
