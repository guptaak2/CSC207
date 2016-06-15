package test;
import static org.junit.Assert.*;
import File;
import ls;

import org.junit.Test;


public class lsTest {

  
  @Test
  public void testGetList() {
    File t = new File("/");
    File t2 = new File("a");
    t2.setParent(t);
    File curDir = t;
    ls list = new ls(curDir,false);
    assertNotEquals("a", list.getList());
  }

  @Test
  public void testLsFileBoolean() {
    fail("Not yet implemented"); // TODO
  }
/*
  @Test
  public void testLsStringDirectoryFileBoolean() {
    fail("Not yet implemented"); // TODO
  }
*/
}
