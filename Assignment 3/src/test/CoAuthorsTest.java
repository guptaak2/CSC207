package test;

import static org.junit.Assert.*;
import driver.CoAuthors;
import java.util.*;

import org.junit.Test;

public class CoAuthorsTest {
  List<String> AuthorsTest = new ArrayList<String>();
  String[] lst = new String[] {"Abigail Sellen", "Adam Ameur",
      "Andrew D Miller", "Antony John Williams", "Blair MacIntyre",
      "Christoph Steinbeck", "Deepak Jagdish", "E.D. Mynatt",
      "Egon Willighagen", "Elsa Eiriksdottir", "Erika Shehan Poole",
      "Greg Turk", "Iulian Radu", "Janna Hastings", "John Stasko",
      "Jonathan Alvarsson", "Komorowski Jan", "Kurt Luther", "Nina Jeliazkova",
      "Noel M. O'Boyle", "Rajarshi Guha", "Sam Adams", "Samuel Lampa",
      "Sean Ekins", "Thore Graepel", "Valentin Georgiev", "Xiang Cao",
      "Youn-ah Kang", "gilleain torrance"};

  @Test
  public void testCoAuthors() throws Exception {
    CoAuthors Test = new CoAuthors("sample1.html");
    CoAuthors Test2 = new CoAuthors("sample2.html");
    AuthorsTest.addAll(Test.CoAuthorsTest);
    AuthorsTest.addAll(Test2.CoAuthorsTest);
    assertEquals(AuthorsTest, lst);
  }

}
