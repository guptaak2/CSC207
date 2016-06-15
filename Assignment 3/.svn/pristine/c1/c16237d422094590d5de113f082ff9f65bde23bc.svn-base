package driver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class prints out the total citations (5 papers) if an outfile is
 * provided.
 * 
 * @param googleScholarURL
 * @param file
 */
public class ExtractTotalCitationsFile {
  // create a new class "ExtractTotalCitationsFile"
  public ExtractTotalCitationsFile(String googleScholarURL, String file)
      throws IOException {
    // initialize local variables
    try {
      GetHTML googleScholarParser = new GetHTML();
      String rawHTMLString = googleScholarParser.getHTML(googleScholarURL);
      List<String> lst = new ArrayList<String>();
      
      // regex
      String reForTotalCitations = "cites=(.*?)\\\">(.*?)</a>";
      
      Pattern patternObject = Pattern.compile(reForTotalCitations);
      Matcher matcherObject = patternObject.matcher(rawHTMLString);
      
      // finds match between regex and URL
      while (matcherObject.find()) {
        lst.add(matcherObject.group(2));
      }
      
      // adds up the total number of citations
      int Total =
          Integer.parseInt(lst.get(0)) + Integer.parseInt(lst.get(1))
              + Integer.parseInt(lst.get(2)) + Integer.parseInt(lst.get(3))
              + Integer.parseInt(lst.get(4));
      
      // prints out the total citations to a file
      OutPut.FileOutPutStream("5: Total paper citation (first 5 papers): "
          + "\n" + "      " + Total, file);
      OutPut.FileOutPutStream("\n", file);
      
      // exception block
    } catch (Exception e) {
      OutPut.FileOutPutStream("malformed URL or cannot open connection to "
          + "given URL", file);
    }
  }
}
//end