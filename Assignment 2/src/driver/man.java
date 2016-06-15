 package driver;
public class man {
  String documentation;
  public man(String command) {
    if (command.equals("mkdir")) {
      getMkdir();
    } else if (command.equals("exit")) {
      getExit();
    } else if (command.equals("cd")) {
      getCd();
    } else if (command.equals("ls")) {
      getLs();
    } else if (command.equals("mv")) {
      getMv();
    } else if (command.equals("cp")) {
      getCp();
    } else if (command.equals("cat")) {
      getCat();
    } else if (command.equals("echo")) {
      getEcho();
    } else if (command.equals("pwd")) {
      getPwd();
    } else if (command.equals("man")) {
      getMan();
    } else if(command.equals("get")){
      getURL();
    } else if(command.equals("pushd")){
      getPushd();
    } else if(command.equals("popd")){
      getPopd();
    } else if(command.equals("rm")){
      getRm();
    } else if(command.equals("grep")){
      getGrep();
    } else {
      documentation =("Invalid command, please try again.");
    }
  }

  public void getExit() {
    documentation =("Quit the program.");
  }

  public void getMkdir() {
    documentation =("Create directories, each of which may be relative "
        + "to the current directory or may be a full path.");
  }

  public void getCd() {
    documentation =("Change directory to DIR, which may be "
        + "relative to the current directory or may be a full path\n"
        + "As with Unix, .. means a parent directory "
        + "and a . mean the current directory");
  }

  public void getLs() {
    documentation =("If no paths are given, print the contents "
            + "(file or directory) of the current directory\n"
            + "with a  new line following each of the content (file or "
            + "directory). If –R is present,recursively list all \n"
            + "subdirectories. If no paths are given, print the contents "
            + "(file or directory) of the current directory, with a new \n"
            + "line following each f the content (file or directory).");
  }

  public void getPwd() {
    documentation =("Print the current working directory path (i.e. the"
        + " whole absolute path)");
  }

  public void getMv() {
    documentation =("Move item OLDPATH to NEWPATH. Both OLDPATH  "
            + "and NEWPATH may be relative to the current directory or may be full paths.\n"
            + "If NEWPATH is a directory, move the item into the directory");
  }

  public void getCp() {
    documentation =("Move item OLDPATH to NEWPATH. Both OLDPATH and NEWPATH may be "
            + "relative to the current directory or may be full paths.\n"
            + "If NEWPATH is a directory, move the item into the directory. "
            + "Doesn't remove item OLDPATH.");
  }

  public void getCat() {
    documentation =("Display the contents of FILE in the shell.");
  }

  public void getEcho() {
    documentation =("If OUTFILE is not provided, print STRING on the "
            + "on the shell. Otherwise, put STRING into file OUTFILE. STRING is a \n"
            + "string of characters surrounded by double quotation marks. This "
            + "creates a new file if OUTFILE does not exists and erases the old \n"
            + "contents if OUTFILE already exists. In either case, the only in "
            + "OUTFILE should be STRING.\n If >> is an argument, it would have the same"
            + " procedure except it would append to existing conent.");
  }

  public void getMan() {
    documentation = "Print documentation for CMD";
  }
  
  public void getURL(){
    documentation = "URL is a web address. Retrieve the file at that URL and \n"
        + "add it to the current working directory.";  
  }
  
  public void getPushd(){
    documentation = "Saves the current working directory onto stack and then "
        + "changes the new current working directory to DIR. The pushd /n"
        + "command saves the old current working directory in memory so that /n"
        + "it can be returned to at any time (via the popd command).";  
  }
  
  public void getPopd(){
    documentation = "Remove the top entry from the directory stack, and cd to "
        + "the new top directory. The popd command removes the top most /n"
        + "directory onto the stack and makes it the current working directory."
        + " If there is no directory onto the stack, then give appropriate \n"
        + "error message.";
  }
  
  public void getRm(){
    documentation = "Confirm with the user that they want to delete PATH, and"
        + " if so, remove it from the JShell file system. If PATH is a \n"
        + "directory, recursively remove all files and directories in it, "
        + "prompting for confirmation for each one. If –f is supplied, do \n"
        + "not confirm: just remove.";
  }
  
  public void getGrep(){
    documentation = "If –R is not supplied, print any lines containing  "
        + "REGEX in PATH, which must be a file. If –R is supplied, and PATH \n"
        + "is a directory, recursively traverse the directory and, for all "
        + "lines in all files that contain REGEX, print the path to the \n"
        + "file (including the filename), then a colon, then the line that "
        + "contained REGEX.";
  }
  
  public String getDocumentation(){
    return documentation;
  }

}
