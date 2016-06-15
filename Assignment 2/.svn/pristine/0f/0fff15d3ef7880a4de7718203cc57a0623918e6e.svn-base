package driver;
public class Redirection {
  PathHandler handle = new PathHandler();
  Echo addFile;

  /**
   * Redirection of list directories relative to new file
   * @param dir The root directory
   * @param curDir The current directory
   * @param file The new file to make which will contain contents
   * @param type Whether to overwrite or append
   * @param R Recursively print option
   */
  public void RedirectionLSRelative(Directory dir, File curDir,String file,String type, boolean R){
	  ls printDir;
	  printDir = new ls(curDir,R);
	  addFile = new  Echo(printDir.getList(),file,dir,curDir,type);
  }
  /**
   * Redirection of list directories of absolute path to new file
   * @param dir The root directory
   * @param curDir The current directory
   * @param file The new file to make which will contain contents
   * @param type Whether to overwrite or append
   * @param R Recursively print option
   */
  public void RedirectionLSPath(String path,Directory dir, File curDir, String file, String type, boolean R){
	  ls printDir;
	  if(!handle.isPath(path)){
		  path = curDir.toString()+path;
	  }
	  printDir = new ls(path, dir,curDir,R);
	  addFile = new Echo(printDir.getList(),file,dir,curDir,type);
  }
  /**
   * Redirect the contents of print working directory to new file
   * @param path The new file to make which will contain contents
   * @param dir The root directory
   * @param curDir The current directory
   * @param type Whether to overwrite or append
   */
  public void RedirectionPWD(String path, Directory dir, File curDir,
      String type) {
    // PrintDir = new pwd(curDir);

    addFile = new Echo(curDir.toString(), path, dir, curDir, type);

  }

  /**
   * Redirect the contents of cat to a new file
   * @param path The path to which contents will be added to new file
   * @param file The new file which will contain contents
   * @param dir The root directory
   * @param curDir The current directory
   * @param type Whether to overwrite or append
   */
  public void RedirectionCAT(String path, String file, Directory dir,
      File curDir, String type) {
    Cat viewFile;
    viewFile = new Cat();
    viewFile.viewContents(path, dir, curDir);
    addFile = new Echo(viewFile.content, file, dir, curDir, type);


  }

 
  /**
   * Redirect the documentation of a command to a new file
   * @param command The documents of given command
   * @param file The new file which will contain contents
   * @param dir The root directory
   * @param curDir The current directory
   * @param type Whether to overwrite or append
   */
  public void RedirectionCMD(String command, String file, Directory dir,
      File curDir, String type) {
    man Command;
    String content;
    Command = new man(command);
    addFile = new Echo(Command.documentation,file,dir,curDir,type);
  }
}
