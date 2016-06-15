package driver;

public class mv {
  PathHandler handler = new PathHandler();

  /**
   * Move directory or file from one directory to another given OLDPATH and 
   * NEWPATH
   * @param from Directory of file being moved, can be relative or absolute path
   * @param to Directory to move to, can be relative or absolute path
   * @param dir The root directory
   * @param curDir The current directory
   */
  public void move(String from, String to, File dir, File curDir) {

    if (handler.isPath(from) && handler.isPath(to)) {
      movePathToPath(handler.getSpecialPath(from, curDir),
          handler.getSpecialPath(to, curDir), dir);
    }
    else if (handler.isPath(from) && !handler.isPath(to)){
      movePathToRelative(handler.getSpecialPath(from, curDir), to, dir, curDir);
    }
    else if(!handler.isPath(from) && handler.isPath(to)){
     moveRelativeToPath(from, handler.getSpecialPath(to, curDir), dir, curDir);
    }
    else {
      moveRelativeToRelative(from, to, curDir);
    }
  }

  private void moveRelativeToRelative(String from, String to, File curDir) {
    int fromIndex = -1;
    int toIndex = -1;
    int matchIndex = -1;
    if (from.equals(to)) {
      System.out.println("Cannot move a directory into itself.");
    }
    for (int i = 0; i < curDir.getSubDirs().size(); i++) {
      if (curDir.getSubDirs().get(i).getName().equals(from)) {
        fromIndex = i;
      }
      if (curDir.getSubDirs().get(i).getName().equals(to)) {
        toIndex = i;
      }
    }
    if (fromIndex == -1 || toIndex == -1) {
      System.out.println("An invalid path has been given.");
    } else if (curDir.getSubDirs().get(toIndex).getIsDir()) {
      for (int i = 0; i < curDir.getSubDirs().get(toIndex).getSubDirs().size();
          i++) {
        if (from.equals(curDir.getSubDirs().get(toIndex).getSubDirs().get(i)
            .getName())) {
          matchIndex = i;
        }
      }
      if (matchIndex > -1) {
        System.out.println(from + " is already in " + to);
      }else{
        curDir.getSubDirs().get(fromIndex).setParent(curDir.getSubDirs().
            get(toIndex));
        curDir.getSubDirs().get(toIndex).getSubDirs()
          .add(curDir.getSubDirs().get(fromIndex));
        curDir.getSubDirs().remove(fromIndex);

      }
    } else {
      System.out.println(from + " is already in this directory.");
    }
  }
  
  private void moveRelativeToPath(String from, String toPath, File dir,
      File curDir){
    
    String fromPath = curDir.toString();
    for (int i = 0; i < curDir.getSubDirs().size(); i++){
      if (from.equals(curDir.getSubDirs().get(i).getName())){
        fromPath = curDir.getSubDirs().get(i).toString();
      }
    }
    movePathToPath(fromPath, toPath , dir);
  }
  
  private void movePathToRelative(String fromPath, String to, File dir, 
      File curDir){
    
    String toPath = curDir.toString();
    for (int i = 0; i < curDir.getSubDirs().size(); i++){
      if (to.equals(curDir.getSubDirs().get(i).getName())){
        toPath = curDir.getSubDirs().get(i).toString();
      }
    }
    movePathToPath(fromPath, toPath , dir);
  }
  

  private void movePathToPath(String fromPath, String toPath, File dir) {
    String[] fromPathList = handler.stringToList(fromPath);
    String[] toPathList = handler.stringToList(toPath);
    if (fromPath.equals("/")) {
      System.out.println("Cannot move root, every directory/file is a sub"
          + " directory/file.");
    } else if (toPath.contains(fromPath)) {
      if (toPath.equals(fromPath)) {
        System.out.println("Cannot move a directory into itself.");
      } else {
        System.out.println(toPath + " is a sub directory or file of "
            + fromPath);
      }
    } else if (!handler.pathExists(fromPathList, dir, 1,
        fromPathList.length - 1)
        || !handler.pathExists(toPathList, dir, 1, toPathList.length - 1)) {
      System.out.println("An invalid path has been given.");
    } else {

      handler.pathExists(fromPathList, dir, 1, fromPathList.length - 1);
      File fromItem = handler.getDir();
      handler.pathExists(toPathList, dir, 1, toPathList.length - 1);
      File toItem = handler.getDir();
      if (toItem.getIsDir() && !toItem.getSubDirs().contains(fromItem)) {
        toItem.getSubDirs().add(fromItem);
        fromItem.getParent().getSubDirs().remove(fromItem.getParent().
            getSubDirs().indexOf(fromItem));
        fromItem.setParent(toItem);
      } else if (toItem.getIsDir() && toItem.getSubDirs().contains(fromItem)) {
        System.out.println(fromItem + " is already in " + toItem);
      } else {
        for (int i = 0; i < toItem.getParent().getSubDirs().size(); i++) {
          if (toItem.getParent().getSubDirs().get(i).getName()
              .equals(toItem.getName())) {
            toItem.getParent().getSubDirs().remove(i);
            i = toItem.getParent().getSubDirs().size();
          }
        }
        toItem.getParent().getSubDirs().add(fromItem);
        fromItem.getParent().getSubDirs().remove(fromItem.getParent().
            getSubDirs().indexOf(fromItem));
        fromItem.setParent(toItem.getParent());
      }
    }
  }


}