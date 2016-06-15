package driver;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class prints out the i10-index if no outfile is provided.
 * 
 * @param googleScholarURL
 */
public class Extracti10Index {
  // initialize variables
  String i10Index;
  public String i10IndexTest;

  // create a new class "Extracti10Index"
  public Extracti10Index(String googleScholarURL) {
    // initialize local variables
    try {
      GetHTML googleScholarParser = new GetHTML();
      List<String> lst = new ArrayList<String>();
      String rawHTMLString = googleScholarParser.getHTML(googleScholarURL);
      
      // regex
      String reForCitationExtraction =
          "<td class=\"cit-borderleft cit-data\">(.*?)</td>";
      
      Pattern patternObject = Pattern.compile(reForCitationExtraction);
      Matcher matcherObject = patternObject.matcher(rawHTMLString);
      
      // finds match between regex and URL
      while (matcherObject.find()) {
        lst.add(matcherObject.group(1));
      }
      
      // prints out the i10-index 
      i10Index =
          "3. Number of i10-index after 2009: " + "\n" + "      "
              + lst.get(5).toString();
      i10IndexTest = lst.get(5).toString();
      
      // exception block
    } catch (Exception e) {
      System.out.println("malformed URL or cannot open connection to "
          + "given URL");
    }
  }
}
//end