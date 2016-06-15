package test;

import static org.junit.Assert.*;
import driver.Extract3Publications;

import org.junit.Test;

public class Extract3PublicationsTest {
  Extract3Publications function = new Extract3Publications("sample1.html");
  Extract3Publications function2 = new Extract3Publications("sample2.html");
  String First1 =
      "Bioclipse: an open source workbench for chemo-and bioinformatics";
  String Second1 = "The LCB data warehouse";
  String Third1 =
      "XMPP for cloud computing in bioinformatics supporting discovery "
          + "and invocation of asynchronous web services";
  String First2 = "Face-tracking as an augmented input in video games: "
      + "enhancing presence, role-playing and control";
  String Second2 =
      "Art of defense: a collaborative handheld augmented reality board game";
  String Third2 = "Sociable killers: understanding social relationships in"
      + "" + " an online first-person shooter game";

  @Test
  public void testFirst1() {
    assertEquals(First1, function.Test1);
  }
  
  @Test
  public void testSecond1() {
    assertEquals(Second1, function.Test2);
  }
  
  @Test
  public void testThird1() {
    assertEquals(Third1, function.Test3);
  }
  
  @Test
  public void testFirst2() {
    assertEquals(First2, function2.Test1);
  }
  
  @Test
  public void testSecond2() {
    assertEquals(Second2, function2.Test2);
  }
  
  @Test
  public void testThird2() {
    assertEquals(Third2, function2.Test3);
  }
}
