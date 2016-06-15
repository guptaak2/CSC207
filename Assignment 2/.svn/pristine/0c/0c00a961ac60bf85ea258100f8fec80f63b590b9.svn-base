package driver;
public class Echo {
	PathHandler handle = new PathHandler();
	
	/**
	 * Appends or overwrites the contents in a file. If the file does not exist,
	 * the file is created with the given contents.
	 * @param content The contents that need to be appended/overwrite to file
	 * @param fileName The name of the file where the contents are to be placed
	 * @param directory The directory
	 * @param curDir The current directory 
	 * @param type The case being used, append or overwrite
	 */
	public Echo(String content, String fileName, File directory, File curDir,
			String type) {
		if (handle.isPath(fileName)) {
			EchoPath(content, fileName, directory, type);
		} else {
			EchoRelative(content, fileName, curDir, type);
		}
	}

	private void EchoPath(String content, String FileName, File directory,
			String type) {
		// System.out.println(FileName);
		// System.out.println("path used");

		String[] pathList = handle.stringToList(FileName);
		// System.out.println(pathList.length);

		if (pathList.length == 0) {
			System.out.println("Error: Path is invalid");
		}else 
		if (pathList.length == 2) {
			EchoRelative(content, pathList[1], directory, type);
		
		} else if (!handle.pathExists(pathList, directory, 1,
				pathList.length - 2)) {
			System.out.println("Error: Directory does not exist.");
		}

		else {
			EchoRelative(content, pathList[pathList.length - 1],
					handle.getDir(), type);
		}

	}

	private void EchoRelative(String content, String FileName,
			File currentDirectory, String type) {

		int index = -1;
		boolean inCurrentDir = false;
		boolean isFile = false;

		for (int i = 0; i < currentDirectory.getSubDirs().size(); i++) {
			if (currentDirectory.getSubDirs().get(i).getName().equals(FileName))
			{
				inCurrentDir = true;
				index = i;
				if (!(currentDirectory.getSubDirs().get(i).isDir)) {
					isFile = true;
				}
			}

		}
		if(!currentDirectory.isDir){
			System.out.println("Error: Cannot add file to a file");
		}
		else if (!inCurrentDir) {
			File addFile = new File(FileName, content);

			currentDirectory.appendFile(addFile);
		} else if (inCurrentDir && !isFile) {
			System.out.println("Error: Directory with same name exists");
		} else if (inCurrentDir && isFile && type.equals(">")) {
			currentDirectory.getSubDirs().get(index).content = content;
		} else if (inCurrentDir && isFile && type.equals(">>")) {
			currentDirectory.getSubDirs().get(index).content += content;
		}

	}
}
