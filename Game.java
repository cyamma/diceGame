// importing the java Scanner object from utility
import java.util.Scanner;
/**
 * The Game class permits the player to select from the options listed in a menu
 * Players input their names and set maximum score or use the default of 200
 * The user rolls a dice, where two random number is generated and added to total score
 * Bonus score is given to the user if they receive two rolls of the same integer
 * The game ends and winner is assigned to the player once the they receive total score 
 * which is greater than the maximum score, or draw if both players reach maximum score
 * at the same time.
 * 
 * @author Chaiyaporn Yamma
 * @version 22.04.2016
 */
public class Game
{
    private Dice die; // new dice as die
    private int maximumScore; // maximum score of the game
    private Person player1; // new player 1 from Person class
    private Person player2; // new player 2 from Person class
    private String userInput; // declaring user input as a String
    
    /**
     * Constructor for objects of the Game class
     * creates player 1 and 2 from Person class
     * creates a new die from Dice class
     * sets user input as default empty String
     */
    public Game()
    {
        player1 = new Person(); // assign new Person object as player 1
        player2 = new Person();
        die = new Dice(); // assign new Dice object as die
        String userInput = ""; // assign default user input as empty String
    }
    
    /**
     * Method to check the player's score
     * and assign the leading player
     * or draw if both players are currently at tie
     */
    public void checkScore()
    {
        if (player1.getScore() > player2.getScore()) // if player 1 score is greater than player 2 score
            leadingPlayer(" <--THIS PLAYER IS LEADING!", ""); // calling the leadingPlayer method and passing a string
        else if (player1.getScore() < player2.getScore()) 
            leadingPlayer("", " <--THIS PLAYER IS LEADING!");
        else if (player1.getScore() == player2.getScore()) 
            System.out.println("Both players are tie with " + player1.getScore() + " points at the moment");
    }
    
    /**
     * Method to assign the random number generated as
     * variable in respect to the roll number and player.
     * Doubles the score for the player if two numbers produce 
     * by the role are identicals.
     * Prints score results
     */
    public void diceRoll()
    {
        int p1FirstRoll = die.getRandomRoll(); // calls the dice class to generate random number
        int p1SecondRoll = die.getRandomRoll();  
        int p1TotalScore = p1FirstRoll + p1SecondRoll; // assigns the rolls to an overall total variable
        int p2FirstRoll = die.getRandomRoll();
        int p2SecondRoll = die.getRandomRoll(); 
        int p2TotalScore= p2FirstRoll + p2SecondRoll;
        if (p1FirstRoll == p1SecondRoll) // if the first roll is identical to second roll
        {
            p1TotalScore = (p1FirstRoll + p1SecondRoll) * 2; // multiply the identical roll by 2
            player1.setScore(player1.getScore() + p1TotalScore); // stores the score into the player's class, .
        }
        else 
            player1.setScore(player1.getScore() + p1TotalScore);
            
        if (p2FirstRoll == p2SecondRoll)
        {
            p2TotalScore = (p2FirstRoll + p2SecondRoll) * 2;
            player2.setScore(player2.getScore() + p2TotalScore);
        }
        else 
            player2.setScore(player2.getScore() + p2TotalScore);
            
        if (player1.getScore() > maximumScore && player2.getScore() > maximumScore) // both player 1 and 2 exceed maximum score at the same time
            // displays players' name and indicate a draw
            System.out.println(player1.getName() + " and " + player2.getName() + " DREW");
        else if (player2.getScore() > maximumScore)
            System.out.println(player2.getName() + " is the WINNER with " + player2.getScore() +
            " points, while " + player1.getName() + " only have " + player1.getScore() + " points.");
        else if (player1.getScore() > maximumScore)
            System.out.println(player1.getName() + " is the WINNER with " + player1.getScore() +
            " points, while " + player2.getName() + " only have " + player2.getScore() + " points.");
        else 
        {
            if (p1FirstRoll == p1SecondRoll && p2FirstRoll == p2SecondRoll) // the two rolled dice of player 1 are identical and also for player 2
            {
                System.out.println(player1.getName() + " rolled " + p1FirstRoll + " + " + 
                p1SecondRoll + ", and scored " + p1TotalScore + " points (RECEIVE BONUS!)") ;
                System.out.println(player2.getName() + " rolled " + p2FirstRoll + " + " + 
                p2SecondRoll + ", and scored " + p2TotalScore + " points (RECEIVE BONUS!)");
            } 
            else if (p2FirstRoll == p2SecondRoll) // player 2 first roll is identical to player 2 second roll
            {
                System.out.println(player1.getName() + " rolled " + p1FirstRoll + " + " + 
                p1SecondRoll + ", and scored " + p1TotalScore + " points") ;
                System.out.println(player2.getName() + " rolled " + p2FirstRoll + " + " + 
                p2SecondRoll + ", and scored " + p2TotalScore + " points (RECEIVE BONUS!)"); // displays bonus to player 2
            } 
            else if (p1FirstRoll == p1SecondRoll)
            {
                System.out.println(player1.getName() + " rolled " + p1FirstRoll + " + " + 
                p1SecondRoll + ", and scored " + p1TotalScore + " points (RECEIVE BONUS!)");
                System.out.println(player2.getName() + " rolled " + p2FirstRoll + " + " + 
                p2SecondRoll + ", and scored " + p2TotalScore + " points") ; 
            } 
            else 
            {
                System.out.println(player1.getName() + " rolled " + p1FirstRoll + " + " + 
                p1SecondRoll + ", and scored " + p1TotalScore + " points") ;
                System.out.println(player2.getName() + " rolled " + p2FirstRoll + " + " + 
                p2SecondRoll + ", and scored " + p2TotalScore + " points") ; 
            }
        }
    }
    
    /**
     * Method to allow user view the main menu
     * and allow user to input one of the five options.
     * Option 2 and 3 validates if player name had been entered
     */
    public void playGame()
    {
        do // loop to display the menu
        {
            mainMenu(); // calls the mainMenu method to display the menu of the game
            Scanner sc = new Scanner(System.in); // creates new Scanner object, assign it as variable sc, gets input from the keyboard
            userInput = sc.nextLine(); // stores the input as a String from the Scanner as userInput
            switch (userInput) // the input from the user is the expression
            {
                case "1": // If user enters 1
                    player1.setScore(0); //sets the player score to 0
                    player2.setScore(0); 
                    player1.setName(""); //sets the player name as empty String
                    player2.setName("");
                    maximumScore = 200; // sets default maximum score to 200       
                    playerName(); // calls the playerName method
                    setGameScore();
                    break;
                case "2":
                    if (player1.getName().length() > 0) // player's name is an empty String
                    {
                        if (player1.getScore() > maximumScore || player2.getScore() > maximumScore) // player 1 or player 2 has score greater than maximum score
                            System.out.println("Please Start a New Game");
                        else
                            diceRoll();
                    } 
                    else 
                        System.out.println("Error: players have not been set up, start a new game first!"); // displays error if player's name is an empty String
                    break;       
                case "3":
                    if (player1.getName().length() > 0) 
                    {
                        if (player1.getScore() > maximumScore && player2.getScore() > maximumScore) // when player 1 and 2 has a score greater than maximum score
                            System.out.println("Game had ended, " + player1.getName() + 
                            " and " + player2.getName() + " DREW!");
                        else if (player1.getScore() > maximumScore) // or else if player 1 score is greater than maximum score
                            System.out.println("Game had ended, " + player1.getName() + " WON!");
                        else if (player2.getScore() > maximumScore) 
                            System.out.println("Game had ended, " + player2.getName() + " WON!");
                        else
                            checkScore();
                    } 
                    else
                        System.out.println("Error: players have not been set up, start a new game first!");
                    break;
                case "4": gameHelp(); break;
                case "5": System.out.print(""); break;
                default: 
                    System.out.println("Error: Please select the options listed"); break;
            }
        } while (!userInput.equals("5")); //exits the loop if the user's input is 5
        System.exit(0); //exits the game, deletes the class's object
    }
    
    /**
     * Method to print out the game's help
     */
    public void gameHelp()
    {
        System.out.println("These are the instructions to the Dice-and-Roll Game!");
        System.out.println("The main aim of the goal is for each players to roll");
        System.out.println("the dice twice, simultaneously, until the default or");
        System.out.println("the set maximum score is reached, in which the person");
        System.out.println("who reaches the maximum score first is declared as the");
        System.out.println("winner of the game.");
        System.out.println("");
        System.out.println("Since the dice is rolled simultaneously by the game");
        System.out.println("for all players, two players can reach the maximum score");
        System.out.println("at the same time, hence the game results to a draw.");
        System.out.println("Below are the set instructions:");
        System.out.println("");
        System.out.println("Start a new game by selecting option 1 then proceed to");
        System.out.println("set the players name and the score, or press enter for");
        System.out.println("the default score of 200. Roll the dice until either");
        System.out.println("one of the players or both reaches the maximum score");
        System.out.println("Note: if a player rolls the dice and it results to");
        System.out.println("any integer of the same value, that player earns a");
        System.out.println("bonus score, which is the sum of the integer multiplied");
        System.out.println("by two.");
        System.out.println("");
        System.out.println("Have fun, and enjoy the Dice-and-roll game!");
    }
    
    /**
     * Method to print out the main menu for the game
     */
    public void mainMenu()
    {
        System.out.println("Welcome to Jeno's Roll the Dice Game!");
        System.out.println("=================================");
        System.out.println("(1) Start a New Game");
        System.out.println("(2) Play One Round");
        System.out.println("(3) Who is leading now?");
        System.out.println("(4) Display Game Help");
        System.out.println("(5) Exit Game");
        System.out.print("Choose an option : ");
    }
    
    /**
     * Method to print the the player's name and their score
     * 
     * @param p1Leading, p2Leading      adds a String to the end of the print for both players
     */
    public void leadingPlayer(String p1Leading, String p2Leading)
    {
        System.out.println(player1.getName() + " have " + player1.getScore() + " points" + p1Leading);
        System.out.println(player2.getName() + " have " + player2.getScore() + " points" + p2Leading);
    }
    
    /**
     * Method to request user to input String for the name.
     * Assigns the name to the player from the Person class.
     * Validates and does not permits user to enter an empty String 
     */
    public void playerName()
    {
        Scanner sc = new Scanner(System.in);
        while (player1.getName().trim().equals("")) // user input is an empty String or has spaces with no characters keep requesting for the user to enter valid String
        {
            System.out.print("Enter First Player's Name: ");
            String player1Name = sc.nextLine(); // assigns user input of String type to player1Name variable
            player1.setName(player1Name); // assigns the user input as
        }
        while(player2.getName().trim().equals("")) 
        {
            System.out.print("Enter Second Player's Name: ");
            String player2Name = sc.nextLine();
            player2.setName(player2Name);
        }   
    }
    
    /**
     * Method to assign the maximum score of the game
     */
    public void setGameScore()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Maximum score to win (<Enter> to use default 200): ");
        String inputScore = sc.nextLine();
        if (!inputScore.equals("")) // input is not an empty String from the user entering the <enter key>
        {
           int intInputScore = Integer.parseInt(inputScore); // pass the user input of type string as integer
           maximumScore = intInputScore; // stores user input as maximum score           
        }
    }
}

