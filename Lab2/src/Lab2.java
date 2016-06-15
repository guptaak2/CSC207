import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
public class Lab2 {
public static int col,row;
public static double[][] Matrix;
public static double total = 0;
  public static void main(String[] args) 
  {
  try {
  String fileName, input;
  Matrix = new double[4][5];
  Scanner in = new Scanner(System.in);
  System.out.println("Enter the name of input file: ");
  fileName = in.nextLine();
  FileInputStream fStream = new FileInputStream(fileName);
  BufferedReader br = new BufferedReader (new InputStreamReader(fStream));
  br.readLine();
  br.readLine();
  br.readLine();
  row = 0;
  while ((input = br.readLine()) != null)
  {
    System.out.println("\n The line is: " + input);
    String allNumbers[] = input.split(" ");
    col = 0;
    for (String singleNumber : allNumbers)
    {
      Matrix[row][col] = Integer.parseInt(singleNumber);
      col = col + 1;
    }
    row = row + 1;
  }
  fStream.close();
  } 
  catch (Exception e) 
  {
  System.out.print(e.getMessage());
  }
  for (int j = 0; j < Matrix.length; j++)
  {
    System.out.println("\n");
    for (int k = 0; k < Matrix[0].length; k++)
    {
      total = total + Matrix[j][k];
    }
    total = total/(Matrix[0].length*Matrix.length);
    System.out.println("The average of the Matrix is: " + total);
  }
  }
}

