package driver;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class prints out the first 3 publications if no outfile is provided.
 * 
 * @param googleScholarURL
 */
public class Extract3Publications {
  // initialize variables
  String ThreePublications;
  public String Test1;
  public String Test2;
  public String Test3;

  // create a new class "Extract3Publications"
  public Extract3Publications(String googleScholarURL) {
    // initialize local variables
    try {
      GetHTML googleScholarParser = new GetHTML();
      List<String> lst = new ArrayList<String>();
      String rawHTMLString = googleScholarParser.getHTML(googleScholarURL);
      
      // regex
      String reFor3Publications = " class=\"cit-dark-large-link\">(.*?)</a>";
      
      Pattern patternObject = Pattern.compile(reFor3Publications);
      Matcher matcherObject = patternObject.matcher(rawHTMLString);
      
      // finds match between regex and URL
      while (matcherObject.find()) {
        lst.add(matcherObject.group(1));
      }
      
      // prints out first 3 publications
      ThreePublications =
          "4: Title of the first 3 publications: " + "\n" + "      " + "1- "
              + lst.get(0).toString() + "\n" + "      " + "2- "
              + lst.get(1).toString() + "\n" + "      " + "3- "
              + lst.get(2).toString();
      
      // variables created to TEST
      Test1 = lst.get(0).toString();
      Test2 = lst.get(1).toString();
      Test3 = lst.get(2).toString();

      // exception block
    } catch (Exception e) {
      System.out.println("malformed URL or cannot open connection to "
          + "given URL");
    }
  }
}
//end
