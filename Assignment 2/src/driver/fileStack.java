package driver;


import java.util.ArrayList;



public class fileStack {
  private ArrayList<String> st;

  
  public fileStack(){
    st = new ArrayList<String>();
  }
  /**
   * Add file to stack
   * @param file to add to stack
   */
  public void push(String file){
    st.add(file);

  }
  /**
   * Remove top file from stack
   * @return remove top file from stack
   */
  public String pop (){
    
    if (st.size() == 0){
      System.out.println("Stack is empty.");
      return null;
    }
    
    String popped = st.get(st.size()-1);
    this.st.remove(st.size()-1);
    return popped;
    
  }

  
}
