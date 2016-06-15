package driver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class prints out the first 3 publications if an outfile is provided.
 * 
 * @param googleScholarURL
 * @param file
 */
public class Extract3PublicationsFile {
  // create a new class "Extract3PublicationsFile
  public Extract3PublicationsFile(String googleScholarURL, String file) throws IOException {
    // initialize variables
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
    
    // prints out the first 3 publications to a file
    OutPut.FileOutPutStream("4: Title of the first 3 publications: " + "\n"
        + "      " + "1- " + lst.get(0).toString() + "\n" + "      " + "2- "
        + lst.get(1).toString() + "\n" + "      " + "3- "
        + lst.get(2).toString(), file);
    OutPut.FileOutPutStream("\n", file);
    
    // exception block
  } catch (Exception e) {
    OutPut.FileOutPutStream("malformed URL or cannot open connection to "
        + "given URL", file);
  }
}
}
//end