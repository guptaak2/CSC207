package driver;

import java.util.ArrayList;



public class cd {
  PathHandler handle = new PathHandler();
  
  /**
   * Changes the current directory given a relative or absolute path. If path 
   * does not exist, will return the previous current directory.
   * @param path The relative or absolute path to directory
   * @param dir The root directory
   * @param currentDir The current directory
   * @return The new current directory 
   */
  public File ChangeDirectory(String path, File dir, File currentDir){
    //System.out.println("Path: "+ handle.isPath(path));
      File newCurDir = null;
      if (path.equals("..") && currentDir.getParent() != null){
        return currentDir.getParent();
      }
      else if (path.equals("..") && currentDir.getParent() == null){
        System.out.println("You are in the root directory which does not have a"
            + " parent directory.");
        return currentDir;
      }
      if (path.equals(".")){
        return currentDir;
      }
      if (handle.isPath(path)){

          newCurDir = changeDirectoryPath(path, dir);

      }
      else if (!(handle.isPath(path))){
          newCurDir = changeDirectoryRelative(path, currentDir);
        
      }
      if (newCurDir == null){
        return currentDir;
      }
      return newCurDir;
    }


  private File changeDirectoryRelative(String toChange, File currDir) {
      boolean inDir = false;
      File newCurDirRelative = null;
      for (int i =0; i<currDir.getSubDirs().size();i++){
          if (currDir.getSubDirs().get(i).getName().equals(toChange)){
              inDir = true;
              if (!currDir.getSubDirs().get(i).isDir){
                System.out.println("Cannot change to a file.");
              }
              else{
                newCurDirRelative = currDir.getSubDirs().get(i);
              }  
          }
      }
          
          if(!inDir){
            System.out.println(toChange + " Directory does not exist!");
          }
          return newCurDirRelative;
    
  }

  private File changeDirectoryPath(String path, File dir) {
      File newCurDirPath = null;
      String[] pathList = handle.stringToList(path);
      if (pathList.length == 0){
        return dir;
      }
      if(!handle.pathExists(pathList, dir, 1, pathList.length-1)){
        System.out.println("Directory does not exist.");
      }
      else if(!handle.getDir().isDir){
        System.out.println("Cannot change to a file.");
      }
      else{
        newCurDirPath = handle.getDir();
      }
      return newCurDirPath;
  }

  }