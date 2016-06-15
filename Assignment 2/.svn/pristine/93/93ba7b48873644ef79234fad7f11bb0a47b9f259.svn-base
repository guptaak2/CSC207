package driver;

public class Cat {
  PathHandler handle = new PathHandler();
  String content;

  /**
   * View the contents of a file given a relative or absolute path
   * @param fileName The name of the file
   * @param directory The root directory
   * @param curDir The current directory
   */
  public void viewContents(String fileName, File directory, File curDir) {
    if (handle.isPath(fileName)) {
      catPath(fileName, directory);
    } else {
      catRelative(fileName, curDir);
    }
  }
  public String getContent(){
	  return this.content;
  }


  private void catRelative(String FileName, File currentDirectory) {
    
    int index = -1;
    boolean isFile = false;
    for (int i = 0; i < currentDirectory.getSubDirs().size(); i++) {
      if (currentDirectory.getSubDirs().get(i).getName().equals(FileName)) {

        index = i;
        if (!(currentDirectory.getSubDirs().get(i).getIsDir())) {
          isFile = true;
        }
      }
    }
    
    if (index >= 0 && isFile == true) {
      this.content=currentDirectory.getSubDirs().get(index).getContent();
    } else if (index >= 0 && isFile == false) {
      System.out.println(FileName + " is not a File");
    } else if (index == -1) {
      System.out.println(FileName + " File does not exist");
      
      
    }


  }

  private void catPath(String FileName, File directory) {
    // System.out.println(FileName);
    // System.out.println("path used");

    String[] pathList = handle.stringToList(FileName);

    if (pathList.length == 0) {
      System.out.println("/ is not a file.");
    } else if (!handle.pathExists(pathList, directory, 1, pathList.length - 1)) {
      System.out
          .println(pathList[pathList.length - 2] + "File does not exist.");
    } else if (handle.getDir().isDir) {
      System.out.println(pathList[pathList.length - 2] + " is not a file.");
    } else {
   
      System.out.println(handle.getDir().content);
    }

  }
}