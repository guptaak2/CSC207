package driver;
import java.util.ArrayList;



public class mkdir {
  PathHandler handle = new PathHandler();
  private boolean gotMade = true;

  /**
   * Creates one or more directory given a relative or absolute path
   * @param directories The directories that need to be added
   * @param directory The directory
   * @param cDir The current directory
   */
  public void addAll(String[] directories, File directory, File cDir) {
    String invalidChar = "!@$&*()?:[]<>'`|={},;";
    String searchPath;
    boolean skipInput = false;
    for (int d = 1; d < directories.length; d++) {
      //searchPath = directories[d];
      for (int ch = 0; ch < invalidChar.length(); ch++) {
        if (directories[d].contains(invalidChar.charAt(ch) + "")) {
          System.out.println("Cannot use special character in file or directory"
              + " names.");
          gotMade = false;
          skipInput = true;
        }
      }
      if (!skipInput && handle.isPath(directories[d])) {
        searchPath = handle.getSpecialPath(directories[d], cDir);
        addDirectoryPath(searchPath, directory);
      } else if (!skipInput) {
        addDirectoryRelative(directories[d], cDir);
      }
    }
  }

  private void addDirectoryRelative(String toMake, File cDir) {
    boolean incDir = false;
    for (int subDir = 0; subDir < cDir.getSubDirs().size(); subDir++) {
      if (toMake.equals(cDir.getSubDirs().get(subDir).getName())) {
        System.out.println(toMake + " directory already exists.");
        incDir = true;
        gotMade = false;
      }

    }

    if (incDir == false) {

      cDir.appendDirectory(toMake);
    }

  }

  private void addDirectoryPath(String path, File directory) {
    String[] pathList = handle.stringToList(path);

    if (pathList.length == 0) {
      System.out.println("/ directory exists.");
      gotMade = false;
    } else if (handle.pathExists(pathList, directory, 1, pathList.length - 1)) {
      System.out.println(handle.getDir() + " directory exists.");
      gotMade = false;
    } else if (pathList.length == 2 && pathList[0].equals("")) {
      addDirectoryRelative(pathList[1], directory);
    } else if (handle.pathExists(pathList, directory, 1, pathList.length - 2)) {
      addDirectoryRelative(pathList[pathList.length - 1], handle.getDir());
    } else {
      System.out.println(path + " is not a valid directory path.");
      gotMade = false;
    }
  }
  
  public boolean getGotMade(){
    return gotMade;
  }

}