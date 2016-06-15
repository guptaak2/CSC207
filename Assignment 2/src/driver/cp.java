package driver;

public class cp {
  PathHandler handler = new PathHandler();

  
  /**
   * Copy directory or file from one directory to another given OLDPATH and 
   * NEWPATH
   * @param from Directory of file being moved, can be relative or absolute path
   * @param to Directory to move to, can be relative or absolute path
   * @param dir The root directory
   * @param curDir The current directory
   */
  public void copy(String from, String to, File dir, File curDir) {

    if (handler.isPath(from) && handler.isPath(to)) {
      copyPathToPath(handler.getSpecialPath(from, curDir),
          handler.getSpecialPath(to, curDir), dir);
    }
    else if (handler.isPath(from) && !handler.isPath(to)){
      copyPathToRelative(handler.getSpecialPath(from, curDir), to, dir, curDir);
    }
    else if(!handler.isPath(from) && handler.isPath(to)){
     copyRelativeToPath(from, handler.getSpecialPath(to, curDir), dir, curDir);
    }
    else {
      copyRelativeToRelative(from, to, dir, curDir);
    }
  }

  private void copyRelativeToRelative(String from, String to, File dir, File curDir) {
//    int fromIndex = -1;
//    int toIndex = -1;
//    int matchIndex = -1;
//    if (from.equals(to)) {
//      System.out.println("Cannot copy a directory into itself.");
//    }
//    for (int i = 0; i < curDir.getSubDirs().size(); i++) {
//      if (curDir.getSubDirs().get(i).getName().equals(from)) {
//        fromIndex = i;
//      }
//      if (curDir.getSubDirs().get(i).getName().equals(to)) {
//        toIndex = i;
//      }
//    }
//    if (fromIndex == -1 || toIndex == -1) {
//      System.out.println("An invalid path has been given.");
//    } else if (curDir.getSubDirs().get(toIndex).getIsDir()) {
//      for (int i = 0; i < curDir.getSubDirs().get(toIndex).getSubDirs().size();
//          i++) {
//        if (from.equals(curDir.getSubDirs().get(toIndex).getSubDirs().get(i)
//            .getName())) {
//          matchIndex = i;
//        }
//      }
//      if (matchIndex > -1) {
//        System.out.println(from + " is already in " + to);
//      }else{
//      curDir.getSubDirs().get(toIndex).appendDirectory(curDir.getSubDirs().
//          get(fromIndex));
//      }
//    } else {
//      System.out.println(from + " is already in this directory.");
//    }
    
  int fromIndex = -1;
  int toIndex = -1;
  if (from.equals(to)) {
    System.out.println("Cannot copy a directory into itself.");
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
    File fromItem = curDir.getSubDirs().get(fromIndex);
    File toItem = curDir.getSubDirs().get(toIndex);
    mkdir addDir = new mkdir();
    String[] dirCopy = {"", fromItem.getName()};
    addDir.addAll(dirCopy, toItem, toItem);
    if (addDir.getGotMade()){
      for (int subFile = 0; subFile < fromItem.getSubDirs().size(); subFile++){
        copyPathToPath(fromItem.getSubDirs().get(subFile).toString(), 
            toItem.getSubDirs().get(toItem.getSubDirs().size() - 1).toString(), 
            dir);
      }
    }
  }
    
  }
  
  private void copyRelativeToPath(String from, String toPath, File dir,
      File curDir){
    
    String fromPath = curDir.toString();
    for (int i = 0; i < curDir.getSubDirs().size(); i++){
      if (from.equals(curDir.getSubDirs().get(i).getName())){
        fromPath = curDir.getSubDirs().get(i).toString();
      }
    }
    copyPathToPath(fromPath, toPath , dir);
  }
  
  private void copyPathToRelative(String fromPath, String to, File dir, 
      File curDir){
    
    String toPath = curDir.toString();
    for (int i = 0; i < curDir.getSubDirs().size(); i++){
      if (to.equals(curDir.getSubDirs().get(i).getName())){
        toPath = curDir.getSubDirs().get(i).toString();
      }
    }
    copyPathToPath(fromPath, toPath , dir);
  }
  

  private void copyPathToPath(String fromPath, String toPath, File dir) {
    String[] fromPathList = handler.stringToList(fromPath);
    String[] toPathList = handler.stringToList(toPath);
    if (fromPath.equals("/")) {
      System.out.println("Cannot copy root, every directory/file is a sub"
          + " directory/file.");
    } else if (toPath.contains(fromPath)) {
      if (toPath.equals(fromPath)) {
        System.out.println("Cannot copy a directory into itself.");
      } else {
        System.out.println(toPath + " is a sub directory or file of "
            + fromPath);
      }
    } else if (!handler.pathExists(fromPathList, dir, 1,
        fromPathList.length - 1)
        || !handler.pathExists(toPathList, dir, 1, toPathList.length - 1)) {
      System.out.println("An invalid path has been given.");
    } else {
      mkdir addDir = new mkdir();
      handler.pathExists(fromPathList, dir, 1, fromPathList.length - 1);
      File fromItem = handler.getDir();
      handler.pathExists(toPathList, dir, 1, toPathList.length - 1);
      File toItem = handler.getDir();
      String[] dirCopy = {"", fromItem.getName()};
      if (toItem.getIsDir() && !toItem.getSubDirs().contains(fromItem)) {
        copyDirOrFile(fromItem, toItem, dir);
//        if(fromItem.getIsDir()){
//          
//          addDir.addAll(dirCopy, toItem, toItem);
//          if (addDir.getGotMade()){
//            for (int subFile = 0; subFile < fromItem.getSubDirs().size(); subFile++){
//              copyPathToPath(fromItem.getSubDirs().get(subFile).toString(), 
//                  toItem.getSubDirs().get(toItem.getSubDirs().size() - 1).toString(), 
//                  dir);
//            }
//          }
//        }
//        else{
//          toItem.appendFile(new File(fromItem.getName(), fromItem.getContent()));
//        }
      } else if (toItem.getIsDir() && toItem.getSubDirs().contains(fromItem)) {
        System.out.println(fromItem + " is already in " + toItem);
      } 
      else {
        File toParent = toItem.getParent();
        for (int i = 0; i < toItem.getParent().getSubDirs().size(); i++) {
          if (toItem.getParent().getSubDirs().get(i).getName()
              .equals(toItem.getName())) {
            toItem.getParent().getSubDirs().remove(i);
            i = toItem.getParent().getSubDirs().size();
          }
        }
        copyDirOrFile(fromItem, toParent, dir);
//        if(fromItem.getIsDir()){
//          addDir.addAll(dirCopy, toParent, toParent);
//          if (addDir.getGotMade()){
//            for (int subFile = 0; subFile < fromItem.getSubDirs().size(); subFile++){
//              copyPathToPath(fromItem.getSubDirs().get(subFile).toString(), 
//                  toParent.getSubDirs().get(toParent.getSubDirs().size() - 1).toString(), 
//                  dir);
//            }
//          }
//        }
//        else{
//          toParent.appendFile(new File(fromItem.getName(), fromItem.getContent()));
//        }
      }
      
    }
  }

 private void copyDirOrFile(File fromItem, File toItem, File dir){
   mkdir addDir = new mkdir();
   String[] dirCopy = {"", fromItem.getName()};
   if(fromItem.getIsDir()){
     
     addDir.addAll(dirCopy, toItem, toItem);
     if (addDir.getGotMade()){
       for (int subFile = 0; subFile < fromItem.getSubDirs().size(); subFile++){
         copyPathToPath(fromItem.getSubDirs().get(subFile).toString(), 
             toItem.getSubDirs().get(toItem.getSubDirs().size() - 1).toString(), 
             dir);
       }
     }
   }
   else{
     toItem.appendFile(new File(fromItem.getName(), fromItem.getContent()));
   }
 }
}