package driver;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class prints out the total number of citations if no outfile is
 * provided.
 * 
 * @param googleScholarURL
 */
public class ExtractCitations {
  // initialize variables
  String Citations;
  public String CitationsTest;

  // create a new class "ExtractCitations
  public ExtractCitations(String googleScholarURL) {
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
      
      // prints out the citations
      Citations =
          "2. Number of All Citations: " + "\n" + "      "
              + lst.get(0).toString();
      CitationsTest = lst.get(0).toString();

      // exception block
    } catch (Exception e) {
      System.out.println("malformed URL or cannot open connection to "
          + "given URL");
    }
  }
}
//end