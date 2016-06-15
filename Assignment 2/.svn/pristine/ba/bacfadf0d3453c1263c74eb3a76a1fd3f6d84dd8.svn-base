package driver;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class grep {
  PathHandler handle = new PathHandler();
  
  /**
   * Print any lines containing regex in the files given
   * @param dir The root directory
   * @param curDir The current directory
   * @param regex The regex to find
   * @param path Path to file
   * @param R Recursively print all directories
   */
  public void doGrep(File dir, File curDir, String regex, String path, boolean R){
    if (regex.charAt(0) == '"' && regex.charAt(regex.length()-1) == '"'){
      if (handle.isPath(path)){
        grepPath(dir, curDir, regex.substring(1, regex.length()-1), path, R);
      }else{
        grepRelative(curDir, regex.substring(1, regex.length()-1), path, R);
      }
    }else{System.out.println("Invalid regex");}

  }
  

  
  private void grepRelative(File curDir, String regex, String relativeFile, boolean R){
    File file = null;
    for(int f = 0; f < curDir.getSubDirs().size(); f++){
      File match = curDir.getSubDirs().get(f);
      if (match.getName().equals(relativeFile)){
        if(match.getIsDir() && !R){
          System.out.println(relativeFile + " is a directory.");
        }
        else if((match.getIsDir() && R)){
          int counter = 0;
          for(int i = 0; i < match.getSubDirs().size(); i++){
            if (!match.getSubDirs().get(i).getIsDir()){
              counter++;
              System.out.print(match.getSubDirs().get(i).toString() + ": ");
              grepRelative(match, regex, match.getSubDirs().get(i).getName(), false);
            }
          }
          if (counter == 0){
              System.out.println("");
          }
        }
        else{
          file = match;
        }
      }
    }
    if (file != null){
      Pattern p = Pattern.compile(regex);
      Matcher m;
      String[] lines = file.getContent().split("\n");
      for (int line = 0; line < lines.length; line++){
        m = p.matcher(lines[line]);
        if (m.find()){
          System.out.println(lines[line]);
        }
      }
    }
    }
  
  private void grepPath(File dir, File curDir, String regex, String path, boolean R){
    String[] pathList = handle.stringToList(path);

    if (pathList.length == 0 && !R) {
      System.out.println("/ is a directory.");
    }else if(pathList.length == 0 && R){
      int counter = 0;  
      System.out.print("/: ");
      for(int i = 0; i < dir.getSubDirs().size(); i++){
          if (!dir.getSubDirs().get(i).getIsDir()){
              counter++;
              grepRelative(dir, regex, dir.getSubDirs().get(i).getName(), false);
          }
      }
      if (counter == 0){
          System.out.println("");
      }
    }
    
    else if (handle.pathExists(pathList, dir, 1, pathList.length - 1)) {
      grepRelative(handle.getDir().getParent(), regex, handle.getDir().getName(), R);
    } else {
      System.out.println(path + " is not a valid directory path.");
    }
  }

}
