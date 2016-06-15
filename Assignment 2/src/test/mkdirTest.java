package test;
import static org.junit.Assert.*;
import Directory;
import File;
import mkdir;

import org.junit.Test;

public class mkdirTest {
  mkdir mk = new mkdir();
  String[] a = {"satbir"};
  Directory test = new Directory("/");
  String[] a2 = {"satbir"};
  File cTest = test;
  File s = new File("satbir");
  Directory test2 = new Directory("/");

  @Test
  public void testAddAll() {
    test2.getSubDirs().add(s);
    mk.addAll(a, test, cTest);
    assertEquals(test2.getName(), test.getName());
    assertEquals(test2.getIsDir(), test.getIsDir());
    assertNull(test.getContent());
  }
}
