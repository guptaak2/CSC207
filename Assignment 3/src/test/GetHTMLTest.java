package test;

import static org.junit.Assert.*;
import driver.*;

import org.junit.Test;

public class GetHTMLTest {

  @Test(expected = Exception.class)
  public void testGetHTMLWrong() throws Exception {
    GetHTML html = new GetHTML();
    html.getHTML("sample5.html");
  }
  
  @Test(expected = Exception.class)
  public void testGetHTMLEmpty() throws Exception {
    GetHTML html = new GetHTML();
    html.getHTML(null);
  }
}
