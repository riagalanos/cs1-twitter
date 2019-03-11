// Name:
// Date:

import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class Twitter_Warmup
{
   public static void main (String []args) throws IOException
   {      
      TJTwitter2 twitter = new TJTwitter2();
      
      //  testing remove punctuation
      String s1 = "abcd?";
      String s2 = "!abc$d";
      String s3 = "ab:cd..";
      String s4 = "abc'd";
      System.out.println( s1 + " without puncutation is " + twitter.removePunctuation(s1) );
      System.out.println( s2 + " without puncutation is " + twitter.removePunctuation(s2) );
      System.out.println( s3 + " without puncutation is " + twitter.removePunctuation(s3) );
      System.out.println( s4 + " without puncutation is " + twitter.removePunctuation(s4) );
      
      System.out.println();
      
      String f1 = "test.txt";
      String f2 = "story.txt";
      System.out.println("For the file: " + f1);
      twitter.queryHandle(f1);
      System.out.println("Most popular word: " + twitter.getMostPopularWord());
      System.out.println("Frequency: " + twitter.getFrequencyMax());
      System.out.println();
      
      System.out.println("For the file: " + f2);
      twitter.queryHandle(f2);
      System.out.println("Most popular word: " + twitter.getMostPopularWord());
      System.out.println("Frequency: " + twitter.getFrequencyMax());     
   }             
}        

class TJ_Status2
{
   private String text;
   
   public TJ_Status2(String s)
   {
      text = s;
   }
   public String getText()
   {
      return text;
   }   
}
      
class TJTwitter2 
{
   private List<TJ_Status2> statuses;
   private int numberOfTweets; 
   private List<String> terms;
   private String popularWord;
   private int frequencyMax;
   
   public TJTwitter2() throws IOException
   {
      statuses = new ArrayList<TJ_Status2>();
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
   
   @SuppressWarnings("unchecked")
   public void queryHandle(String handle)throws IOException   
   {
      statuses.clear();
      terms.clear();
      fetchTweets(handle);
      System.out.println("Number of tweets: " + getNumberOfTweets());
      splitIntoWords(); 
      System.out.println("All the words: " + terms);
      removeCommonEnglishWords();
      System.out.println("Remove common words: " +terms);
      sortAndRemoveEmpties();
      System.out.println("Sorted: " + terms);
      mostPopularWord();
   }
    
   /** 
    * This method reads a file of tweets and 
    * stores them in an arrayList of TJ_Status2 objects.  
    * Populates statuses.
    * @param String  the text file
    */
   public void fetchTweets(String handle) throws IOException
   {
      Scanner scan = new Scanner(new File(handle));
      while(scan.hasNext())
         statuses.add(new TJ_Status2(scan.nextLine()));
      numberOfTweets = statuses.size();  
   }   

   /** 
    * This method takes each status and splits them into individual words.   
    * Store each word in terms.  
    */
   public void splitIntoWords()
   {
      //your code goes here      
      
   }

   /** 
    * This method removes common punctuation (but not apostrophes) from each individual word.
    * This method changes everything to lower case.
    * Consider reusing code you wrote for a previous lab.     
    * Consider if you want to remove the # or @ from your words. Could be interesting to keep (or remove).
    * @ param String  the word you wish to remove punctuation from
    * @ return String the word without any punctuation, all lower case  
    */
   public String removePunctuation( String s )
   {
      //your code goes here  
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
      //your code goes here      
      
   }

   /** 
    * This method sorts the words in terms in alphabetically (and lexicographic) order.  
    * You should use your sorting code you wrote earlier this year.
    * Remove all empty strings while you are at it.  
    */
   @SuppressWarnings("unchecked")
   public void sortAndRemoveEmpties()
   {
      //your code goes here      
      
      
   }
   private static void sort(Comparable[] array)
   {
   	//you will want additional helper methods
   }
  
   /** 
    * This method calculates the word that appears the most times
    * Consider case - should it be case sensitive?  The choice is yours.
    * @post will popopulate the frequencyMax variable with the frequency of the most common word 
    */
   @SuppressWarnings("unchecked")
   public void mostPopularWord()
   {
      //your code goes here  
   }
}	  

/****************** Sample output ******************
 
abcd? without puncutation is abcd
!abc$d without puncutation is abc$d
ab:cd.. without puncutation is abcd
abc'd without puncutation is abcd

For the file: test.txt
Number of tweets: 6
All the words: [this, is, a, test, to, check, mia, if, mia, its, working, or, a, a, a, not, mia, mia]
Remove common words: [test, check, mia, mia, working, mia, mia]
Sorted: [check, mia, mia, mia, mia, test, working]
Most popular word: mia
Frequency: 4

For the file: story.txt
Number of tweets: 28
All the words: [as, a, 20yearold, pfc, in, the, air, force, oct, 27, 1949, was, a, day, , ill, always, remember, i, was, stationed, at, chanute, field, illinois, after, finishing, basic, training, at, sheppard, air, force, base, in, texas, i, was, transferred, to, chanute, to, attend, aircraft, , engine, and, general, aircraft, training, while, on, barracks, cleanup, duty, i, found, a, copy, of, the, , vancouver, sun, newspaper, from, , british, columbia, the, frontpage, article, was, about, the, pacific, national, exhibition, beauty, contest, with, a, photo, of, the, winner, miss, vancouver, the, article, also, listed, the, 11, other, contestants, and, the, cities, they, represented, well, , i, got, the, bright, idea, of, writing, a, letter, to, the, winner, hoping, to, get, some, mail, in, return, since, i, had, been, away, from, home, for, almost, a, year, the, highlight, of, my, day, was, mail, call, i, wrote, to, two, other, contestants, as, well, but, had, only, their, , cities, to, use, for, the, address, i, was, shocked, when, i, got, return, letters, from, all, three, contestants, i, was, very, impressed, with, the, letter, from, miss, port, moody, kay, ronco, and, we, began, writing, regularly, by, this, time, , i, had, finished, the, tech, school, programs, and, was, transferred, to, a, base, in, omaha, nebraska, , kay, and, i, continued, to, write, after, seven, months, i, was, made, a, crew, member, on, a, b29, bomber, , scheduled, to, fly, to, seattle, washington, for, modification]
Remove common words: [20yearold, pfc, air, force, oct, 27, 1949, day, , ill, always, remember, stationed, chanute, field, illinois, after, finishing, basic, training, sheppard, air, force, base, texas, transferred, chanute, attend, aircraft, , engine, general, aircraft, training, while, barracks, cleanup, duty, found, copy, , vancouver, sun, newspaper, , british, columbia, frontpage, article, pacific, national, exhibition, beauty, contest, photo, winner, miss, vancouver, article, also, listed, 11, other, contestants, cities, represented, well, , got, bright, idea, writing, letter, winner, hoping, mail, return, since, away, home, almost, year, highlight, day, mail, call, wrote, other, contestants, well, only, , cities, address, shocked, got, return, letters, three, contestants, very, impressed, letter, miss, port, moody, kay, ronco, began, writing, regularly, time, , finished, tech, school, programs, transferred, base, omaha, nebraska, , kay, continued, write, after, seven, months, made, crew, member, b29, bomber, , scheduled, fly, seattle, washington, modification]
Sorted: [11, 1949, 20yearold, 27, address, after, after, air, air, aircraft, aircraft, almost, also, always, article, article, attend, away, b29, barracks, base, base, basic, beauty, began, bomber, bright, british, call, chanute, chanute, cities, cities, cleanup, columbia, contest, contestants, contestants, contestants, continued, copy, crew, day, day, duty, engine, exhibition, field, finished, finishing, fly, force, force, found, frontpage, general, got, got, highlight, home, hoping, idea, ill, illinois, impressed, kay, kay, letter, letter, letters, listed, made, mail, mail, member, miss, miss, modification, months, moody, national, nebraska, newspaper, oct, omaha, only, other, other, pacific, pfc, photo, port, programs, regularly, remember, represented, return, return, ronco, scheduled, school, seattle, seven, sheppard, shocked, since, stationed, sun, tech, texas, three, time, training, training, transferred, transferred, vancouver, vancouver, very, washington, well, well, while, winner, winner, write, writing, writing, wrote, year]
Most popular word: contestants
Frequency: 3
 
***************************************************/
