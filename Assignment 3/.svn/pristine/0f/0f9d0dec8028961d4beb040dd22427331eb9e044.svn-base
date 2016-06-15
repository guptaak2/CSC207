package driver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class prints out the total number of Co-Authors if an outfile is
 * provided.
 * 
 * @param googleScholarURL
 * @param file
 */
public class ExtractCoAuthorsFile {
  // create a new class "ExtractCoAuthorsFile"
  public ExtractCoAuthorsFile(String googleScholarURL, String file)
      throws IOException {
    // initialize variables
    try {
    GetHTML googleScholarParser = new GetHTML();
    String rawHTMLString = googleScholarParser.getHTML(googleScholarURL);
    List<String> lst = new ArrayList<String>();
    List<String> sub_lst = new ArrayList<String>();
    
    // regex
    String reForCoAuthors = " title=\"(.*?)\">(.*?)</a>";
    
    Pattern patternObject = Pattern.compile(reForCoAuthors);
    Matcher matcherObject = patternObject.matcher(rawHTMLString);
    
    // finds match between regex and URL
    while (matcherObject.find()) {
      lst.add(matcherObject.group(2));
    }
    
    // reduces the size of sub_lst by 3 to account for unnecessary words
    sub_lst = lst.subList(0, lst.size() - 3);
    
    // prints out the Co-Authors to a file
    OutPut.FileOutPutStream(
        "6: Total Co-Authors: " + "\n" + "      " + sub_lst.size(), file);
    OutPut.FileOutPutStream("\n", file);
    OutPut.FileOutPutStream("--------------------------------------------",
        file);
    OutPut.FileOutPutStream("\n", file);
    
    // exception block
  } catch (Exception e) {
    OutPut.FileOutPutStream("malformed URL or cannot open connection to "
        + "given URL", file);
  }
}
}
//end