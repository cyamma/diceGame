/**
 * The Person class receives the player name
 * and the score of the player. It also
 * returns the name and score received from
 * the inputs.
 * 
 * @author Chaiyaporn Yamma
 * @version 22.04.2016
 */
public class Person
{
    private String name; // player's name
    private int score; // player's score
    
    /**
     * Sets the default constructor of the Person class.
     * Sets name to blank and score as default 0
     */
    public Person()
    {
        name = "";
        score = 0;
    }
    
    /**
     * Get method to return the player's name
     */
    public String getName()
    {
        return name; // returns the String name
    }
    
    /**
     * Get method to return the player's score value
     */
    public int getScore()
    {
       return score; // returns the score value
    }
    
    /**
     * Set method to replace the name inputed as name
     * @param nameInput     set input name as name
     */
    public void setName(String nameInput)
    {
        name = nameInput;
    }
    
    /**
     * Set method to replace the score inputed as score
     * @param inputScore    set input score to score
     */
    public void setScore(int inputScore)
    {
        score = inputScore;
    }
}