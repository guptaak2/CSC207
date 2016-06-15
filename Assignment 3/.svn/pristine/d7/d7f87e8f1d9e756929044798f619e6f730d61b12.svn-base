package driver;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractAuthorsNameFile {
  /**
   * This class prints out the Author's Name if an outfile is provided.
   * 
   * @param googleScholarURL
   * @param file
   * @throws IOException
   */
  public ExtractAuthorsNameFile(String googleScholarURL, String file)
      throws IOException {
    try {
      GetHTML googleScholarParser = new GetHTML();
      String rawHTMLString = googleScholarParser.getHTML(googleScholarURL);

      String reForAuthorExtraction =
          "<span id=\"cit-name-display\" "
              + "class=\"cit-in-place-nohover\">(.*?)</span>";
      Pattern patternObject = Pattern.compile(reForAuthorExtraction);
      Matcher matcherObject = patternObject.matcher(rawHTMLString);
      while (matcherObject.find()) {
        OutPut.FileOutPutStream("1. Name of Author: " + "\n" + "      "
            + matcherObject.group(1), file);
        OutPut.FileOutPutStream("\n", file);
      }
    } catch (Exception e) {
      OutPut.FileOutPutStream("malformed URL or cannot open connection to "
          + "given URL", file);
    }
  }
}
