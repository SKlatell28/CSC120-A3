
import java.util.Scanner; //import
import java.util.Random; //import random
import java.util.ArrayList; // import the ArrayList class
//   https://www.geeksforgeeks.org/generating-random-numbers-in-java/  -- How to use randoms in Java

class Conversation implements Chatbot {

  // Attributes 

  /**
   * Constructor 
   */
  Conversation() {
    
  }

  /**
   * Starts and runs the conversation with the user
   */

  ArrayList<String> full_convo = new ArrayList<String>();
  public void chat() {
    System.out.println("Hi there! What's on your mind?");
    for (int i = 0; i <2; i++) {
      Scanner user_response = new Scanner(System.in);
      String line = user_response.nextLine();
      full_convo.add(line);
      String answer = respond(line);
      System.out.println(answer);
      full_convo.add(answer);
      
    }
    System.out.println("See ya!");
    

  }

  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {
    System.out.println("");
    System.out.println("TRANSCRIPT");
    System.out.println("Hi there! What's on your mind?");
    for (String i : full_convo) {
      System.out.println(i);
    }
    System.out.println("See ya!");
  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */
  public String respond(String inputString) {
    Integer counter = 0;
    String responces [] = {"Mhmm", "...Right", "Okay"};


    // Mirrors the users answer while changing pronouns. 
    if (inputString.contains("I")) {
      inputString = inputString.replace("I", "you");
      counter += 1;
    }
    else if (inputString.contains("you")) {
      inputString = inputString.replace("you", "I");
      counter += 1;
    }
    if (inputString.contains("me")) {
      inputString = inputString.replace("me", "you");
      counter += 1;
    }

    if (inputString.contains("am")) {
      inputString = inputString.replace("am", "are");
      counter += 1;
    }

    if (inputString.contains("my")) {
      inputString = inputString.replace("my", "your");
      counter += 1;
    }
    else if (inputString.contains("your")) {
      inputString = inputString.replace("your", "my");
      counter += 1;
    }


    //Checks to make sure the responce isn't mirrored and then chooses a random responce
    if (counter == 0) {
      Random rand = new Random();
      int rand_int1 = rand.nextInt(2);
      inputString = responces[rand_int1];
    }

    String returnString = inputString; 
    return returnString; 
  }


  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();

  }
}
