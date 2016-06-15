package driver;
public class ls {
    //String[] filesDir;
    PathHandler handle = new PathHandler();
    /**
     * Lists all the directories and files in the current directory.
     * @param curDir The current directory
     */
    String AllStrings="";
    public String getList(){        
        return AllStrings.replace("\n\n", "\n");
    }
    public ls(File curDir, boolean R){
          for (int x=0;x<curDir.getSubDirs().size();x++){
               if (!R || !curDir.getSubDirs().get(x).getIsDir()){
                   if(x!=curDir.getSubDirs().size()-1){
                 this.AllStrings += curDir.getSubDirs().get(x).getName() + "\n";
                   } else {
                       this.AllStrings += curDir.getSubDirs().get(x).getName();
                   }
               }
               else{
                   if (AllStrings.equals("")){
                       this.AllStrings+=(curDir.getSubDirs().get(x).getName() + ":\n");
                   } else {
                 this.AllStrings+=("\n"+curDir.getSubDirs().get(x).getName() + ":\n");
                   }
                   this.AllStrings+=new ls(curDir.getSubDirs().get(x), false).getList() + "\n";
                // System.out.println("");
               }
          }
        
    }
       /**
        * List all the directories and files in the absolute path
        * @param path The path given to directory
        * @param dir The root directory
        */
       public ls(String path, Directory dir, File curDir, boolean R){
           
         if(!handle.isPath(path)){
           boolean isInCurDir = false;
           for (int x=0;x<curDir.getSubDirs().size();x++){
             if(curDir.getSubDirs().get(x).getName().equals(path)){
               isInCurDir = true;
               if(curDir.getSubDirs().get(x).getIsDir()){
                 //System.out.println(curDir.getSubDirs().get(x).getName() + ":");
                 ls printDir =  new ls(curDir.getSubDirs().get(x), R);
                 //System.out.println("");
               }
               else{
                 System.out.println(curDir.getSubDirs().get(x).getName());
               }
             }
          }
           if (!isInCurDir){
             System.out.println(path + " is not a valid entry.");
           }
         }
         else{
           ListPath(path,dir, R);
         }
        }
       
       private void ListPath(String Path, Directory dir, boolean R){
           
           
           String[] pathList = handle.stringToList(Path);
          
           if (pathList.length == 0){
               ls PrintDir = new ls (dir, R);
               this.AllStrings= PrintDir.AllStrings;
                
              }
           else if(!handle.pathExists(pathList, dir, 1, pathList.length-1)){
                System.out.println("Path is not valid");
              }
           else {
               ls PrintDir = new ls (handle.getDir(), R);
               this.AllStrings= PrintDir.AllStrings;
               
           }
           
    
}
}
