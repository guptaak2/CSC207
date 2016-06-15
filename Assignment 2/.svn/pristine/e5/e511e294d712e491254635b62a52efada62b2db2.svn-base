package driver;
import java.util.*;
public class rm {
	PathHandler handle = new PathHandler();
	Scanner input = new Scanner (System.in);
	
	
	private void removeAbsolute(String dirName, File dir, boolean confirm){
		String[] pathList = handle.stringToList(dirName);
		
		if (pathList.length == 0) {
			System.out.println("Error: Path is invalid");
		}else 
		if (pathList.length == 2) {
			removeRelative( pathList[1], dir, confirm);
		
		} else if (!handle.pathExists(pathList, dir, 1,
				pathList.length - 2)) {
			System.out.println("Error: Directory does not exist.");
		}

		else {
			removeRelative( pathList[pathList.length - 1],
					handle.getDir(), confirm);
		}
		
	}
	
	private void removeRelative(String dirName, File curDir,boolean confirm ){
		
		int index = -1;
		String command;
		boolean contains = false;
		for (int i=0; i< curDir.subDirs.size();i++){
			
			if (curDir.subDirs.get(i).getName().equals(dirName)){
				index = i;
				contains = true;
			}
		}
		if (contains){
			if(confirm){
				do {
				System.out.println("Confirm delete for " + curDir.subDirs.get(index)+ " (Y/N):");
				command = input.nextLine();
				if (!command.equals("Y") && !command.equals("N")){
					System.out.println("Error: Incorrect command entered");//Make it loop
				}
				}while (!command.equals("Y") && !command.equals("N"));
				
				if (command.equals("Y")){
					curDir.subDirs.remove(index);
				} 
				
				
				
			} else {
				curDir.subDirs.remove(index);
			}
		} else {
			System.out.println("Error: File does not exist");
		}
	}
	
	
	/**
	 * Remove directories and all directories within it
	 * @param path Path to directory to remove
	 * @param dir The root directory
	 * @param curDir The current directory
	 * @param confirm Confirm delete
	 */
	public rm (String path, File dir, File curDir, boolean confirm){
		if (handle.isPath(path)){
			removeAbsolute(path,dir,confirm);
		} else{
			removeRelative(path, curDir, confirm);
		}
		
	}
	
}
