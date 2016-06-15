package test;
import static org.junit.Assert.*;
import File;
import fileStack;
import popd;

import org.junit.Before;
import org.junit.Test;

public class popdTest {
  @Test
  public void testPopAndChange() {
   popd p = new popd();
   File t =  new File("/");
   File t2 = new File("t2");
   t.getSubDirs().add(t2);
   t2.setParent(t);
   fileStack fs = new fileStack();
   fs.push(t2.toString());
   File curDir = t;
   curDir = p.popAndChange(t, t, fs);
   assertEquals(t2, curDir); // TODO
  }

}
