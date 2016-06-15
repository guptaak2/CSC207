// **********************************************************
// Assignment1:
// UTOR1 user_name: guptaak2
// UT1 Student #: 1000357071
// Author1: Akhil Gupta
//
// UTOR2 user_name: abbass13
// UT2 Student #: 1000484157
// Author2: Farjad Abbas
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC 207 and understand the consequences.
// *********************************************************
package a1;

import java.util.Scanner;

public class JShell {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    // initialize variable run_prompt
    boolean run_prompt = true;
    // while loop to continue running command prompt
    while (run_prompt) {
      String user_input;
      // import Scanner
      Scanner in = new Scanner(System.in);
      // asks user to enter command after "/#: "
      System.out.print("/#: ");
      user_input = in.nextLine();
      // splits user_input in a list
      String[] input = user_input.split(" ");

      if (user_input.equals("exit")) {
     // Case 1: "exit", it quits the program
        System.exit(0);

      } else if (input[0].equals("mkdir") && input.length == 2) {
        // Case 2: "mkdir"
        System.out.println(input[0]);
        System.out.println(input[1]);

      } else if (input[0].equals("cd") && input.length == 2) {
        // Case 3: "cd"
        System.out.println(input[0]);
        System.out.println(input[1]);

      } else if (input[0].equals("ls")) {
        // Case 4: "ls"
        System.out.println(input[0]);
        System.out.println(" ");

      } else if (input[0].equals("pwd")) {
        // Case 5: "pwd"
        System.out.println(" ");

      } else if (input[0].equals("mv") && input.length == 3) {
        // Case 6: "mv"
        System.out.println(input[0]);
        System.out.println(input[1] + " " + input[2]);
      } else if (input[0].equals("cp") && input.length == 3) {
        // Case 7: "cp"
        System.out.println(input[0]);
        System.out.println(input[1] + " " + input[2]);
      } else if (input[0].equals("cat") && input.length == 2) {
        // Case 8: "cat"
        System.out.println(input[0]);
        System.out.println(input[1]);
      } else if (input[0].equals("get") && input.length == 2) {
        // Case 9: "get"
        System.out.println(input[0]);
        System.out.println(input[1]);
      } else if (input[0].equals("echo") && input.length == 4
          && input[2].equals(">")) {
        // Case 10: "echo" with ">"
        System.out.println(input[0]);
        System.out.println(input[1] + " " + input[2] + " " + input[3]);
      } else if (input[0].equals("echo") && input.length == 4
          && input[2].equals(">>")) {
        // Case 11: "echo" with ">>"
        System.out.println(input[0]);
        System.out.println(input[1] + " " + input[2] + " " + input[3]);
      } else {
        // Case 12: user enters invalid command
        System.out.println("Invalid command, please try again.");
      }
    }
  }
}

// end of program
