package driver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class prints out the Co-Authors if an outfile is provided.
 * 
 * @param URL1
 * @param URL2
 * @param file
 */
public class CoAuthorsFile {
  //initialize variables
  List<String> CoAuthorsList;
  
  // create a new class "CoAuthorsFile"
  public CoAuthorsFile(String googleScholarURL, String file) throws IOException {
    // initialize local variables
    try {
      GetHTML googleScholarParser = new GetHTML();
      String rawHTMLString = googleScholarParser.getHTML(googleScholarURL);
      List<String> lst = new ArrayList<String>();
      
      // regex
      String reForCoAuthors = " title=\"(.*?)\">(.*?)</a>";
      
      Pattern patternObject = Pattern.compile(reForCoAuthors);
      Matcher matcherObject1 = patternObject.matcher(rawHTMLString);
      
      // finds match between regex and URL
      while (matcherObject1.find()) {
        lst.add(matcherObject1.group(2));
      }
      
      // sorts lst alphabetically
      Collections.sort(lst);
      lst = new ArrayList<String>(new LinkedHashSet<String>(lst));
      
      // removes unnecessary words
      lst.remove("Citations");
      lst.remove("h-index");
      lst.remove("i10-index");
      CoAuthorsList = lst;
      
      // exception block
    } catch (Exception e) {
      OutPut.FileOutPutStream("malformed URL or cannot open connection to "
          + "given URL", file);
    }
  }
}
//end
