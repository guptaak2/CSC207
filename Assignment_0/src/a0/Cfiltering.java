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
package a0;

// import java DecimalFormat
import java.text.DecimalFormat;
import java.util.*;

public class Cfiltering {
  // this is a 2d matrix i.e. user*movie
  private int userMovieMatrix[][];
  // this is a 2d matrix i.e. user*movie
  private float userUserMatrix[][];

  /**
   * Default Constructor.
   */
  public Cfiltering() {
    // this is 2d matrix of size 1*1
    userMovieMatrix = new int[1][1];
    // this is 2d matrix of size 1*1
    userUserMatrix = new float[1][1];
  }

  /*
   * TODO:COMPLETE THIS I.E. APPROPRIATELY CREATE THE userMovieMatrix AND
   * userUserMatrix WITH CORRECT DIMENSIONS.
   */
  /**
   * Constructs an object which contains two 2d matrices, one of size
   * users*movies which will store integer movie ratings and one of size
   * users*users which will store float similarity scores between pairs of
   * users.
   * 
   * @param numberOfUsers Determines size of matrix variables.
   * @param numberOfMovies Determines size of matrix variables.
   */

  public Cfiltering(int numberOfUsers, int numberOfMovies) {
    userMovieMatrix = new int[numberOfUsers][numberOfMovies];
    userUserMatrix = new float[numberOfUsers][numberOfUsers];
  }

  /**
   * The purpose of this method is to populate the UserMovieMatrix. As input
   * parameters it takes in a rowNumber, columnNumber and a rating value. The
   * rating value is then inserted in the UserMovieMatrix at the specified
   * rowNumber and the columnNumber.
   * 
   * @param rowNumber The row number of the userMovieMatrix.
   * @param columnNumber The column number of the userMovieMatrix.
   * @param ratingValue The ratingValue to be inserted in the userMovieMatrix
   */

  public void populateUserMovieMatrix(int rowNumber, int columnNumber,
      int ratingValue) {

    userMovieMatrix[rowNumber][columnNumber] = ratingValue;
  }

  /*
   * TODO:COMPLETE THIS YOU ARE FREE TO CHANGE THE FUNCTION SIGNATURE BUT DO NOT
   * CHANGE THE FUNCTION NAME AND DO NOT MAKE THIS FUNCTION STATIC. Add/remove
   * 
   * @param AND
   * 
   * @return as required below.
   */
  /**
   * Determines how similar each pair of users is based on their ratings. This
   * similarity value is represented with with a float value between 0 and 1,
   * where 1 is perfect/identical similarity. Stores these values in the
   * userUserMatrix.
   * 
   * @param COMPLETE THIS IF NEEDED
   * @param COMPLETE THIS IF NEEDED
   * @return COMPLETE THIS IF NEEDED
   */
  public void calculateSimilarityScore() {
    // initializes variables numberOfUsers, numberOfMovies
    int numberOfUsers = userMovieMatrix.length;
    int numberOfMovies = userMovieMatrix[0].length;
    // calls Get_Score function to calculate SimilarityScore
    Get_Score(numberOfUsers, numberOfMovies);
  }

  /**
   * Determines how similar each pair of users is based on their ratings. This
   * similarity value is represented with with a float value between 0 and 1,
   * where 1 is perfect/identical similarity. Stores these values in the
   * userUserMatrix.
   * 
   * @param Users
   * @param Movies
   */

  public void Get_Score(int Users, int Movies) {
    // for loops to loop through the Users and Movies
    for (int UserOne = 0; UserOne < Users; UserOne++) {
      for (int UserTwo = 0; UserTwo < Users; UserTwo++) {
        float distance = 0;
        for (int Movie = 0; Movie < Movies; Movie++) {
          /*
           * calculates the distance between 2 Users by subtracting the ratings
           * and square the result
           */
          distance +=
              Math.pow(
           (userMovieMatrix[UserOne][Movie] - userMovieMatrix[UserTwo][Movie]),
                  2);
        }
        // variable to store (1 / 1+square root of distance)
        float sqrt_distance = (float) Math.sqrt(distance);
        float SimilarityScore = (float) (1 / (1 + sqrt_distance));
        // stores the SimilarityScore in the userUserMatrix
        userUserMatrix[UserOne][UserTwo] = SimilarityScore;
      }
    }
  }

  /*
   * TODO:COMPLETE THIS YOU ARE FREE TO CHANGE THE FUNCTION SIGNATURE BUT DO NOT
   * CHANGE THE FUNCTION NAME AND DO NOT MAKE THIS FUNCTION STATIC
   */
  /**
   * Prints out the similarity scores of the userUserMatrix, with each row and
   * column representing each/single user and the cell position (i,j)
   * representing the similarity score between user i and user j.
   * 
   * @param COMPLETE THIS IF NEEDED
   * @param COMPLETE THIS IF NEEDED
   * @return COMPLETE THIS IF NEEDED
   */

  public void printUserUserMatrix() {
    // initializes variables numberOfUsersRow, numberOfUsersColumn
    int numberOfUsersRow = userUserMatrix.length;
    int numberOfUsersColumn = userUserMatrix[0].length;
    DecimalFormat dFormat = new DecimalFormat("0.0000");
    System.out.println("userUserMatrix is: ");
    /*
     * for loops to loop through userUserMatrix and prints out the decimal
     * format rating stored at userUserMatrix[j][k] except the last value of a
     * column
     */
    for (int j = 0; j < numberOfUsersRow; j++) {
      System.out.println();
      System.out.print("[");
      for (int k = 0; k < numberOfUsersColumn - 1; k++) {
        System.out.print(dFormat.format(userUserMatrix[j][k]) + ", ");
      }
      // prints out the last value stored to avoid "," (comma) repetition
      System.out.print(dFormat.format(userUserMatrix[j][numberOfUsersRow - 1]));
      System.out.print(']');
    }
    // prints out 2 blank lines
    System.out.println();
    System.out.println();
  }

  /*
   * TODO:COMPLETE THIS YOU ARE FREE TO CHANGE THE FUNCTION SIGNATURE BUT DO NOT
   * CHANGE THE FUNCTION NAME AND DO NOT MAKE THIS FUNCTION STATIC
   */
  /**
   * This function finds the most similar pair of users in the userUserMatrix.
   * 
   * @param COMPLETE THIS IF NEEDED
   * @param COMPLETE THIS IF NEEDED
   * @return COMPLETE THIS IF NEEDED
   */

  public void findMostSimilarPairOfUsers() {
    {
      // initialize variable Users, max_score, SimilarUsers
      int Users = userUserMatrix.length;
      float max_score = (float) 0.0;
      ArrayList<String> SimilarUsers = new ArrayList<String>();
      // for loops to loop through Users to find the max_score
      for (int i = 0; i < Users; i++) {
        for (int j = 0; j < Users; j++) {
          // checks if current score is greater than max_score
          if ((i < j) && (userUserMatrix[i][j] > max_score)) {
            max_score = userUserMatrix[i][j];
            SimilarUsers.clear();
            // adds User( ) and User( ) to the ArrayList SimilarUsers
            SimilarUsers.add("User" + (i + 1) + " and User" + (j + 1));
            // checks if current score is equal to max_score
          } else if ((i < j) && (userUserMatrix[i][j] == max_score)) {
            // adds User() and User( ) to the ArrayList SimilarUsers
            SimilarUsers.add("User" + (i + 1) + " and User" + (j + 1));
          }
        }
      }
      // calls Print_Similar_Users to print SimilarUsers and max_score
      Print_Similar_Users(SimilarUsers, max_score);
    }
    // prints a blank line
    System.out.println();
  }

  /**
   * This function prints the most similar pairs in the userUserMatrix
   * 
   * @param arraylist
   * @param score
   */

  public void Print_Similar_Users(ArrayList arraylist, float score) {
    DecimalFormat df = new DecimalFormat("0.0000");
    System.out.println("The most similar pairs of users from above"
        + " userUserMatrix are: ");
    /*
     * for loop to loop through scores stored in ArrayList SimilarUsers and
     * print them on a new line except the last one
     */
    for (int x = 0; x < arraylist.size() - 1; x++) {
      System.out.println(arraylist.get(x) + ",");
    }
    // prints out the last stored score to avoid "," (comma) repetition
    System.out.println(arraylist.get(arraylist.size() - 1));
    System.out.println("with a similarity score of " + df.format(score));
  }

  /*
   * TODO:COMPLETE THIS YOU ARE FREE TO CHANGE THE FUNCTION SIGNATURE BUT DO NOT
   * CHANGE THE FUNCTION NAME AND DO NOT MAKE THIS FUNCTION STATIC
   */
  /**
   * This function finds the most dissimilar pair of users in the
   * userUserMatrix.
   * 
   * @param COMPLETE THIS IF NEEDED
   * @param COMPLETE THIS IF NEEDED
   * @return COMPLETE THIS IF NEEDED
   */
  public void findMostDissimilarPairOfUsers() {
    {
      // initialize variables Users, min_score, DissimilarUsers
      int Users = userUserMatrix.length;
      float min_score = (float) 1.0;
      ArrayList<String> DissimilarUsers = new ArrayList<String>();
      // for loops to loop through Users to find the min_score
      for (int i = 0; i < Users; i++) {
        for (int j = 0; j < Users; j++) {
          // checks if current score is less than max_score
          if ((i < j) && (userUserMatrix[i][j] < min_score)) {
            min_score = userUserMatrix[i][j];
            DissimilarUsers.clear();
            // adds User( ) and User( ) to the ArrayList DissimilarUsers
            DissimilarUsers.add("User" + (i + 1) + " and User" + (j + 1));
            // checks if current score is equal to min_score
          } else if ((i < j) && (userUserMatrix[i][j] == min_score)) {
            // adds User( ) and User( ) to the ArrayList DissimilarUsers
            DissimilarUsers.add("User" + (i + 1) + " and User" + (j + 1));
          }
        }
      }
      // calls Print_Dissimilar_Users to print DissimilarUsers and min_score
      Print_Dissimilar_Users(DissimilarUsers, min_score);
    }
  }

  /**
   * This function prints the most dissimilar users in the userUserMatrix
   * 
   * @param arraylist
   * @param score
   */

  public void Print_Dissimilar_Users(ArrayList arraylist, float score) {
    DecimalFormat df = new DecimalFormat("0.0000");
    System.out.println("The most dissimilar pairs of users from above"
        + " userUserMatrix are: ");
    /*
     * for loop to loop through scores stored in ArrayList DissimilarUsers and
     * print them on a new line except the last one
     */
    for (int x = 0; x < arraylist.size() - 1; x++) {
      System.out.println(arraylist.get(x) + ",");
    }
    // prints out the last stored score to avoid "," (comma) repetition
    System.out.println(arraylist.get(arraylist.size() - 1));
    System.out.println("with a similarity score of " + df.format(score));
  }
}

// End of Program
