package test;

import static org.junit.Assert.*;
import driver.ExtractAuthorsName;
import org.junit.Test;

public class ExtractAuthorsNameTest {
  ExtractAuthorsName function = new ExtractAuthorsName("sample1.html");
  ExtractAuthorsName function2 = new ExtractAuthorsName("sample2.html");

  @Test
  public void testAuthor1() {
    assertEquals("Ola Spjuth", function.AuthorName); 
  }
  
  @Test
  public void testAuthor2() {
    assertEquals("Yan Xu", function2.AuthorName);
  }

}
