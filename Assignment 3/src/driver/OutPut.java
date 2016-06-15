package driver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This method is used to print data to a file.
 * 
 * @param content
 * @param outfile
 * @throws IOException
 */
public class OutPut {
  public static void FileOutPutStream(String content, String outfile)
      throws IOException {
    // create a new .txt file
    File file = new File(outfile + ".txt");
    file.createNewFile();
    FileWriter writer = new FileWriter(file, true);
    // write content to the file
    writer.write(content);
    writer.flush();
    writer.close();
  }
}
//end