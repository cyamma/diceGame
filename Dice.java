/**
 * The Dice class produces random generated number
 * between 1 and the indicated dice side to 
 * resember the number of faces on the dice.
 * 
 * @author Chaiyaporn Yamma
 * @version 22.04.2016
 */
public class Dice
{
    private int diceSide; // side of dice
    private int randomRoll; // generate random number
    
    /**
     * Default constructor for the Dice class
     * sets the side of dice to default 6
     * Assigns the generated random number as random roll
     */
    public Dice()
    {
        diceSide = 6; // defulat side of dice is 6
        randomRoll = getRandomRoll(); // Assigns the generated number to randomRoll
    }
    
    /**
     * Generate random number between 1 and the 
     * dice side. Returns the generated value
     */
    public int getRandomRoll()
    {
        // generate random number, between 1 and the side of dice (6). Pass it as an integer
        randomRoll = (int)(Math.random()*(diceSide) +1);
        return randomRoll; // returns the value
    }
    /**
     * Set method to set the side of dice as diceSide
     * 
     * @param sideOfDice    sets the side of dice
     */
    public void setDiceSide(int sideOfDice)
    {
        diceSide = sideOfDice;
    }
}
