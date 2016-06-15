package test;

import static org.junit.Assert.*;

import org.junit.Test;
import driver.File;
import driver.fileStack;
import driver.pushd;
import org.junit.Test;

public class pushdTest {

    @Test
      public void testPushAndChange() {
        pushd p = new pushd();
        File t =  new File("/");
        File t2 = new File("t2");
        t.getSubDirs().add(t2);
        t2.setParent(t);
        fileStack fs = new fileStack();
        File curDir = t;
        curDir = p.pushAndChange(t, t, t2.toString(), fs);
        assertEquals(t2, curDir); // TODO
      }

}
