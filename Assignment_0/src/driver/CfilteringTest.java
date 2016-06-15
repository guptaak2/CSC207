// **********************************************************

// Assignment0:
// UTOR user_name: guptaak2
// UT Student #: 1000357071
// Author: Akhil Gupta
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC 207 and understand the consequences.
// *********************************************************
package driver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import a0.Cfiltering;

public class CfilteringTest {

  /**
   * Reads user movie ratings from a text file, calculates similarity scores and
   * prints a score matrix.
   */
  public static void main(String[] args) {
    try {

      // open file to read
      String fileName;
      Scanner in = new Scanner(System.in);
      System.out.println("Enter the name of input file? ");
      fileName = in.nextLine();
      FileInputStream fStream = new FileInputStream(fileName);
      BufferedReader br = new BufferedReader(new InputStreamReader(fStream));

      // Read dimensions: number of users and number of movies
      int numberOfUsers = Integer.parseInt(br.readLine());
      int numberOfMovies = Integer.parseInt(br.readLine());

      /*
       * create a new Cfiltering object that contains: a) 2d matrix
       * i.e.userMovieMatrix (#users*#movies) b) 2d matrix i.e. userUserMatrix
       * (#users*#users)
       */
      Cfiltering cfObject = new Cfiltering(numberOfUsers, numberOfMovies);


      // this is a blank line being read
      br.readLine();

      // read each line of movie ratings and populate the
      // userMovieMatrix
      String row;
      int row_counter = -1;
      while ((row = br.readLine()) != null) {
        // allRatings is a list of all String numbers on one row
        // make the String number into an integer
        // populate userMovieMatrix
        row_counter += 1;
        String allRatings[] = row.split(" ");
        int column_counter = -1;
        for (String singleRating : allRatings) {
          column_counter += 1;
          cfObject.populateUserMovieMatrix(row_counter, column_counter,
              Integer.parseInt(singleRating));
        }
      }
      // TODO: COMPLETE THIS I.E. POPULATE THE USER_MOVIE MATRIX
      // close the file
      fStream.close();
      
      /*
       * COMPLETE THIS ( I.E. CALL THE APPROPRIATE FUNCTIONS THAT DOES THE
       * FOLLOWING)
       */
      // TODO:1.) CALCULATE THE SIMILARITY SCORE BETWEEN USERS.
      cfObject.calculateSimilarityScore();
      // TODO:2.) PRINT OUT THE userUserMatrix
      cfObject.printUserUserMatrix();
      // TODO:3.) PRINT OUT THE MOST SIMILAR PAIRS OF USER AND THE MOST
      // DISSIMILAR PAIR OF USERS
      cfObject.findMostSimilarPairOfUsers();
      cfObject.findMostDissimilarPairOfUsers();
      
    } catch (FileNotFoundException e) {
      System.err.println("Do you have the input file in the root folder "
          + "of your project?");
      System.err.print(e.getMessage());
    } catch (IOException e) {
      System.err.print(e.getMessage());
    }
  }

}
