package driver;

public class AddFile {
	/**
	 * Add a file in the directory
	 * @param file The file that needs to be added 
	 * @param dir The directory 
	 */
  public void addFile(File file, File dir){
    dir.getSubDirs().add(file);
  }
}
