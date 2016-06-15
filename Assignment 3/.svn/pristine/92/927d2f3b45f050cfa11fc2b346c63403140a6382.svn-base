package driver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class prints out the Author's name if no outfile is provided.
 * 
 * @param googleScholarURL
 */
public class ExtractAuthorsName {
  // initialize variables
  String Author;
  public String AuthorName;

  // create a new class ExtractAuthorsName
  public ExtractAuthorsName(String googleScholarURL) {
    // initalize local variables
    try {
      GetHTML googleScholarParser = new GetHTML();
      String rawHTMLString = googleScholarParser.getHTML(googleScholarURL);
      
      // regex
      String reForAuthorExtraction =
          "<span id=\"cit-name-display\" "
              + "class=\"cit-in-place-nohover\">(.*?)</span>";
      
      Pattern patternObject = Pattern.compile(reForAuthorExtraction);
      Matcher matcherObject = patternObject.matcher(rawHTMLString);
      
      // finds match between regex and URL
      while (matcherObject.find()) {
        // prints out the author's name
        Author =
            "1. Name of Author: " + "\n" + "      " + matcherObject.group(1);
        AuthorName = matcherObject.group(1);
      }
      
      // exception block
    } catch (Exception e) {
      System.out.println("malformed URL or cannot open connection to "
          + "given URL");
    }
  }
}
//end