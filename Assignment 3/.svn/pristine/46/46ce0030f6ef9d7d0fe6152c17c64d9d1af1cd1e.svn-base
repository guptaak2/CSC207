package driver;

import java.util.ArrayList;
import java.io.*;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class prints out the Co-Authors if no outfile is provided.
 * 
 * @param URL1
 * @param URL2
 */
public class CoAuthors {
  // initialize variables
  List<String> CoAuthorsList;
  public static List<String> CoAuthorsTest;
  
  // create a new class "CoAuthors"
  public CoAuthors(String googleScholarURL) {
    // initialize local variables
    try {
      GetHTML googleScholarParser = new GetHTML();
      String rawHTMLString = googleScholarParser.getHTML(googleScholarURL);
      List<String> lst = new ArrayList<String>();
      
      //regex
      String reForCoAuthors = " title=\"(.*?)\">(.*?)</a>";
      
      Pattern patternObject = Pattern.compile(reForCoAuthors);
      Matcher matcherObject = patternObject.matcher(rawHTMLString);
      
      // finds match between regex and URL
      while (matcherObject.find()) {
        lst.add(matcherObject.group(2));
      }
      // sorts lst alphabetically
      Collections.sort(lst);
      lst = new ArrayList<String>(new LinkedHashSet<String>(lst));
      
      //removes unnecessary words
      lst.remove("Citations");
      lst.remove("h-index");
      lst.remove("i10-index");
      CoAuthorsList = lst;
      CoAuthorsTest = lst;
      
      // exception block
    } catch (Exception e) {
      System.out.println("malformed URL or cannot open connection to "
          + "given URL");
    }
  }
}
//end