package test;

import static org.junit.Assert.*;
import driver.ExtractCoAuthors;

import org.junit.Test;

public class ExtractCoAuthorsTest {
  ExtractCoAuthors function = new ExtractCoAuthors("sample1.html");
  ExtractCoAuthors function2 = new ExtractCoAuthors("sample2.html");
  
  @Test
  public void testCoAuthors1() {
    assertEquals(15, function.CoAuthorsTest);
  }
  
  @Test
  public void testCoAuthors2() {
    assertEquals(14, function2.CoAuthorsTest);
  }

}
