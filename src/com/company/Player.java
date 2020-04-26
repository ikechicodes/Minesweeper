package com.company;

/**
 * The Player represents a single human-player of Minesweeper.
 */

public class Player
{
    private String name;    // The player's name.
    private int flags;      // The player's flags.

    /**
     * Constructor
     * @param name The player's name.
     */

    public Player(String name)
    {
        this.name = name;

        // The number of flags should be equal to the number of mines in the game board.
        // Call setFLags and pass it the value returned from getTotalMines in board class.
        // setFlags();
    }

    /**
     * Copy Constructor
     * @param that An object of type Player.
     */

    public Player(Player that)
    {
        this.name = that.name;
        this.flags = that.flags;
    }

    /**
     * This method stores a value in the name field.
     * @param name The player's name.
     */

    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * This method stores a value in the flags field.
     * @param flags The player's flags.
     */

    public void setFlags(int flags)
    {
        this.flags = flags;
    }

    /**
     * This method retrieves the value stored in the name field.
     * @return The player's name.
     */

    public String getName()
    {
        return name;
    }

    /**
     * This method retrieves the value stored in the flags field.
     * @return The player's flags.
     */

    public int getFlags()
    {
        return flags;
    }

}
