package driver;

// **********************************************************
// Assignment3:
// UTORID user_name: guptaak2
//
// Author: Akhil Gupta
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// *********************************************************
import java.io.*;
import java.util.*;

public class MyParser {

  /**
   * @param args
   * @throws Exception
   */
  // main function
  public static void main(String[] args) throws Exception {
    List<String> FinalCoAuthorsList = new ArrayList<String>();
    
    // checks if no arguments are provided
    if (args.length == 0) {
      throw new NullPointerException("No input URL's provided");
    }
    
    try {
      // checks if an outfile is provided, then do the following
      if (args.length == 2) {
        String inputFiles[] = args[0].split(",");
        // for each URL provided, create a new class with input arguments
        for (String inputFile : inputFiles) {
          
          // extract author's name
          ExtractAuthorsNameFile AuthorFile =
              new ExtractAuthorsNameFile(inputFile, args[1]);
          
          // extract total citations
          ExtractCitationsFile CitationsFile =
              new ExtractCitationsFile(inputFile, args[1]);

          // extract i10-index
          Extracti10IndexFile i10IndexFile =
              new Extracti10IndexFile(inputFile, args[1]);

          // extract titles of first 3 publications
          Extract3PublicationsFile ThreePublicationsFile =
              new Extract3PublicationsFile(inputFile, args[1]);
          
          // extract total citations from first 5 papers
          ExtractTotalCitationsFile TotalCitationsFile =
              new ExtractTotalCitationsFile(inputFile, args[1]);
          
          // extract all co-authors
          ExtractCoAuthorsFile CoAuthorsFile =
              new ExtractCoAuthorsFile(inputFile, args[1]);

          // extract sorted list of co-authors
          CoAuthorsFile PrintCoAuthorsFile =
              new CoAuthorsFile(inputFile, args[1]);
          FinalCoAuthorsList.addAll(PrintCoAuthorsFile.CoAuthorsList);
          Collections.sort(FinalCoAuthorsList);
        }
        // writes sorted list of co-authors to file 
        OutPut.FileOutPutStream("7: Co-Author list sorted (Total: "
            + FinalCoAuthorsList.size() + ")", args[1]);
        OutPut.FileOutPutStream("\n", args[1]);
        for (String name : FinalCoAuthorsList) {
          OutPut.FileOutPutStream(name, args[1]);
          OutPut.FileOutPutStream("\n", args[1]);
        }

        // if no outfile is provided, it prints out on the console
      } else {
        String inputFiles[] = args[0].split(",");
        // for each URL provided, create a new class
        for (String inputFile : inputFiles) {
          // extract and print author's name
          ExtractAuthorsName Author = new ExtractAuthorsName(inputFile);
          System.out.println(Author.Author);
          
          // extract and print total number of citations
          ExtractCitations Citations = new ExtractCitations(inputFile);
          System.out.println(Citations.Citations);
          
          // extract and print i10-index
          Extracti10Index i10Index = new Extracti10Index(inputFile);
          System.out.println(i10Index.i10Index);

          // extract and print title of first 3 publications
          Extract3Publications ThreePublications =
              new Extract3Publications(inputFile);
          System.out.println(ThreePublications.ThreePublications);

          // extract and print total citations of first 5 papers
          ExtractTotalCitations TotalCitations =
              new ExtractTotalCitations(inputFile);
          System.out.println(TotalCitations.TotalCitations);

          // extract co-authors and print heading of co-authors list
          ExtractCoAuthors CoAuthors = new ExtractCoAuthors(inputFile);
          System.out.println(CoAuthors.CoAuthors);
          System.out.println(CoAuthors.BlankLine);
          System.out.println();

          // extract and sort CoAuthorsList
          CoAuthors PrintCoAuthors = new CoAuthors(inputFile);
          FinalCoAuthorsList.addAll(PrintCoAuthors.CoAuthorsList);
          Collections.sort(FinalCoAuthorsList);
        }
        // print out sorted list of co-authors
        System.out.println("7: Co-Author list sorted (Total: "
            + FinalCoAuthorsList.size() + ")");
        for (String name : FinalCoAuthorsList) {
          System.out.println(name);
        }
      }
      
      // exception block
    } catch (Exception e) {
      System.out.println("malformed URL or cannot open connection to "
          + "given URL");
    }
  }
}
//end of program