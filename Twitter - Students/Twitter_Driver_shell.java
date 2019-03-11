// Name:
// Date:

import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import twitter4j.*;       //set the classpath to lib\twitter4j-core-4.0.7.jar

public class Twitter_Driver
{
   private static PrintStream consolePrint;

   public static void main (String []args) throws TwitterException, IOException
   {
      consolePrint = System.out; // this preserves the standard output so we can get to it later      
   
      // PART III - Connect
      // set classpath, edit properties file
          
      TJTwitter bigBird = new TJTwitter(consolePrint);
      
   	// Part III - Tweet
      // Create and set a String called message below
   	// Uncomment this line to test, but then recomment so that the same
   	// tweet does not get sent out over and over.
   
      /*
      String message="Gooooooooo Colonials!";
      bigBird.tweetOut(message);
      */
       
   
      // PART III - Test
      // Choose a public Twitter user's handle 
      
      Scanner scan = new Scanner(System.in);
      consolePrint.print("Please enter a Twitter handle, do not include the @symbol --> ");
      String twitter_handle = scan.next();
       
      // Find and print the most popular word they tweet 
      while (!twitter_handle.equals("done"))
      {
         bigBird.queryHandle(twitter_handle);
         consolePrint.println("The most common word from @" + twitter_handle + " is: " + bigBird.getMostPopularWord()+ ".");
         consolePrint.println("The word appears " + bigBird.getFrequencyMax() + " times.");
         consolePrint.println();
         consolePrint.print("Please enter a Twitter handle, do not include the @ symbol --> ");
         twitter_handle = scan.next();
      }
      
      // PART IV
      //bigBird.investigate();
      
   }        
}        
      
class TJTwitter 
{
   private Twitter twitter;
   private PrintStream consolePrint;
   private List<Status> statuses;
   private int numberOfTweets; 
   private List<String> terms;
   private String popularWord;
   private int frequencyMax;
  
   public TJTwitter(PrintStream console)
   {
      // Makes an instance of Twitter - this is re-useable and thread safe.
      // Connects to Twitter and performs authorizations.
      twitter = TwitterFactory.getSingleton(); 
      consolePrint = console;
      statuses = new ArrayList<Status>();
      terms = new ArrayList<String>();
   }
	
   public List<String> getTerms()
   {
      return terms;
   }
	
   public int getNumberOfTweets()
   {
      return numberOfTweets;
   }
	
   public String getMostPopularWord()
   {
      return popularWord;
   }
	
   public int getFrequencyMax()
   {
      return frequencyMax;
   }
	   
  /******************  Part III - Tweet *******************/
  /** 
   * This method tweets a given message.
   * @param String  a message you wish to Tweet out
   */
   public void tweetOut(String message) throws TwitterException, IOException
   {
      
   }

   
  /******************  Part III - Test *******************/
  /** 
   * This method queries the tweets of a particular user's handle.
   * @param String  the Twitter handle (username) without the @sign
   */
   @SuppressWarnings("unchecked")
   public void queryHandle(String handle) throws TwitterException, IOException
   {
      statuses.clear();
      terms.clear();
      fetchTweets(handle);
      splitIntoWords();	
      removeCommonEnglishWords();
      sortAndRemoveEmpties();
      mostPopularWord(); 
   }
	
   /** 
    * This method fetches the most recent 2,000 tweets of a particular user's handle and 
    * stores them in an arrayList of Status objects.  Populates statuses.
    * @param String  the Twitter handle (username) without the @sign
    */
   public void fetchTweets(String handle) throws TwitterException, IOException
   {
      // Creates file for dedebugging purposes
      PrintStream fileout = new PrintStream(new FileOutputStream("tweets.txt")); 
      Paging page = new Paging (1,200);
      int p = 1;
      while (p <= 10)
      {
         page.setPage(p);
         statuses.addAll(twitter.getUserTimeline(handle,page)); 
         p++;        
      }
      numberOfTweets = statuses.size();
      fileout.println("Number of tweets = " + numberOfTweets);
   }   

   /** 
    * This method takes each status and splits them into individual words.   
    * Store the word in terms.  
    */
   public void splitIntoWords()
   {
   
   
   
   }

   /** 
     * This method removes common punctuation from each individual word.
     * This method changes everything to lower case.
     * Consider reusing code you wrote for a previous lab.     
     * Consider if you want to remove the # or @ from your words. Could be interesting to keep (or remove).
     * @ param String  the word you wish to remove punctuation from
     * @ return String the word without any punctuation, all lower case  
     */
   public String removePunctuation( String s )
   {
      
      return "";
   	
   }

   /** 
    * This method removes common English words from the list of terms.
    * Remove all words found in commonWords.txt  from the argument list.    
    * The count will not be given in commonWords.txt. You must count the number of words in this method.  
    * This method should NOT throw an excpetion.  Use try/catch.   
    */
   @SuppressWarnings("unchecked")
   public void removeCommonEnglishWords()
   {  
      
   	
   }

   /** 
    * This method sorts the words in terms in alphabetically (and lexicographic) order.  
    * You should use your sorting code you wrote earlier this year.
    * Remove all empty strings while you are at it.  
    */
   @SuppressWarnings("unchecked")
   public void sortAndRemoveEmpties()
   {
      
   	
   	
   }
   
   /** 
	 * This method calculates the word that appears the most times
    * Consider case - should it be case sensitive?  The choice is yours.
    * @post will popopulate the frequencyMax variable with the frequency of the most common word 
    */
   @SuppressWarnings("unchecked")
   public void mostPopularWord()
   {
      
   	
   }

  /******************  Part IV *******************/
   public void investigate ()
   {
      //Enter your code here
   }
 
  /** 
   * This method determines how many people in Arlington, VA 
   * tweet about the Miami Dolphins.  Hint:  not many. :(
   */
   public void sampleInvestigate ()
   {
      Query query = new Query("Miami Dolphins");
      query.setCount(100);
      query.setGeoCode(new GeoLocation(38.8372839,-77.1082443), 5, Query.MILES);
      query.setSince("2015-12-1");
      try {
         QueryResult result = twitter.search(query);
         System.out.println("Count : " + result.getTweets().size()) ;
         for (Status tweet : result.getTweets()) {
            System.out.println("@"+tweet.getUser().getName()+ ": " + tweet.getText());  
         }
      } 
      catch (TwitterException e) {
         e.printStackTrace();
      } 
      System.out.println(); 
   }  
}