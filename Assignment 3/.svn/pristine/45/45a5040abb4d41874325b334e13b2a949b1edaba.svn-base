package driver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class prints out the total number of citations if an outfile is
 * provided.
 * 
 * @param googleScholarURL
 * @param file
 */
public class ExtractCitationsFile {
  // create a new class "ExtractCitationsFile"
  public ExtractCitationsFile(String googleScholarURL, String file)
      throws IOException {
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
      
      // prints out Citations to a file
      OutPut.FileOutPutStream("2. Number of All Citations: " + "\n" + "      "
          + lst.get(0).toString(), file);
      OutPut.FileOutPutStream("\n", file);
      
      // exception block
    } catch (Exception e) {
      OutPut.FileOutPutStream("malformed URL or cannot open connection to "
          + "given URL", file);
    }
  }
}
//end