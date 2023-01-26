/*
 * TCSS 305 Autumn 2022
 * Assignment 5
 */
package model;

/**
 * Model of the Game of Craps.
 *
 * @author Rainie Chi
 * @version 9 Dec 2022
 */
public class CrapsModel {

    /** The bank balance. */
    private int myBalance;
    /** Value of dice 1. */
    private int myDice1;
    /** Value of dice 2. */
    private int myDice2;
    /** Value of dice 1 + dice 2. */
    private int mySum;
    /** Value of the point */
    private int myPoint;
    /** Player's wins count. */
    private int myWinsCount;
    /** House's wins count. */
    private int myHouseWinsCount;
    /** The current bet value. */
    private int myBet;
    /** Whether the current roll is an initial roll. */
    private boolean myInitialRoll;

    /**
     * Constructor of the Craps Model.
     */
    public CrapsModel() {
        myBalance = 0;
        myInitialRoll = true;
        myWinsCount = 0;
        myHouseWinsCount = 0;
    }

    /**
     * Adds 1 to player's wins count.
     */
    public void addMyWinsCount() {
        myWinsCount ++;
    }

    /**
     * Gets current player wins count.
     * @return player's wins count
     */
    public int getMyWinsCount() {
        return myWinsCount;
    }

    /**
     * Adds 1 to house's wins count.
     */
    public void addMyHouseWinsCount() {
        myHouseWinsCount ++;
    }

    /**
     * Gets current house wins count.
     * @return house's wins count
     */
    public int getMyHouseWinsCount() {
        return myHouseWinsCount;
    }

    /**
     * Set if the following roll will be an initial roll.
     * @param theInitialRoll whether the following roll will be an initial roll
     */
    public void setMyInitialRoll(boolean theInitialRoll) {
        myInitialRoll = theInitialRoll;
    }

    /**
     * If the following roll will be an initial roll.
     * @return whether the following roll will be an initial roll
     */
    public boolean getMyInitialRoll() {
        return myInitialRoll;
    }

    /**
     * Gets the current point.
     * @return the current point
     */
    public int getMyPoint() {
        return myPoint;
    }

    /**
     * Sets myBalance.
     * @param theBalance the value to add to current balance
     */
    public void setMyBalance(final int theBalance) {
        myBalance += theBalance;
    }

    /**
     * Sets myPoint.
     * @param thePoint the point value
     */
    public void setMyPoint(final int thePoint) {
        myPoint = thePoint;
    }

    /**
     * Sets myBet.
     * @param theBet the bet value
     */
    public void setMyBet(final int theBet) {
        if (theBet <= 0) {
            throw new IllegalArgumentException("Bet must be greater than 0");
        } else {
            myBet = theBet;
        }
    }

    /**
     * Rolls the dice.
     */
    public void rollDice() {
        myDice1 = (int)(Math.random()*6+1);
        myDice2 = (int)(Math.random()*6+1);
        mySum = myDice1 + myDice2;
    }

    /**
     * Gets the sum of the dice.
     * @return the sum of the dice
     */
    public int getMyDiceSum() {
        return mySum;
    }

    /**
     * Gets the value of dice 1
     * @return the value of dice 1
     */
    public int getMyDice1() {
        return myDice1;
    }

    /**
     * Gets the value of dice 2
     * @return the value of dice 2
     */
    public int getMyDice2() {
        return myDice2;
    }

    /**
     * Gets the value of the current bet.
     * @return value of the current bet
     */
    public int getMyBet() {
        return myBet;
    }

    /**
     * Gets the value of current balance.
     * @return the value of current balance.
     */
    public int getMyBalance() {
        return myBalance;
    }

    /**
     * Resets the game and all values.
     */
    public void resetGame() {
        myBalance = 0;
        myDice1 = 0;
        myDice2 = 0;
        mySum = 0;
        myPoint = 0;
        myBet = 0;
        myWinsCount = 0;
        myHouseWinsCount = 0;
        myInitialRoll = true;
    }

}