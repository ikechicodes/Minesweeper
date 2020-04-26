/**
 * The Board class models the board in the popular game Minesweeper.
 */

package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Board
{
    private int rows;       // The number of rows the board has.
    private int columns;    // The number of columns the board has.
    private int mines;      // The number of mines the board initially has.
    private ArrayList<Integer[]> flagLocations; // The flag locations.
    private ArrayList<Integer[]> mineLocations; // The mine locations.
    private String[][] board;  // A two-dimensional array representing the board.
    private Random random;

    /**
     * Constructor
     * @param rows The number of rows the board has.
     * @param columns The number of columns the board has.
     * @param mines The number of mines the board initially has.
     */

    public Board(int rows, int columns, int mines)
    {
        this.rows = rows;
        this.columns = columns;
        this.mines = mines;

        board = new String[rows][columns];
        flagLocations = new ArrayList<Integer[]>();
        mineLocations = new ArrayList<Integer[]>();

        // Populate the board with asterisks to represent spaces.
        for (int index = 0; index < rows; index++)
        {
            for (int index2 = 0; index2 < columns; index2++)
                board[index][index2] = "*";
        }

        // Create random mine location.
        random = new Random();
        int randomRow, randomColumn;

        for (int index = 0; index < mines; index++)
        {
            randomRow = random.nextInt(rows);
            randomColumn = random.nextInt(columns);
            Integer[] randomLocation = {randomRow, randomColumn};

            while (mineLocations.contains(randomLocation))
            {
                randomRow = random.nextInt(rows);
                randomColumn = random.nextInt(columns);
                randomLocation[0] = randomRow;
                randomLocation[1] = randomColumn;
            }

            mineLocations.add(randomLocation);
        }
    }

    /**
     * Copy Constructor
     * @param that An object of type board.
     */

    public Board(Board that)
    {
        this.rows = that.rows;
        this.columns = that.columns;
        this.mines = that.mines;
    }

    /**
     * This method stores a value in the rows field.
     * @param rows The number of rows the board has.
     */

    public void setRows(int rows)
    {
        this.rows = rows;
    }

    /**
     * This method stores a value in the columns field.
     * @param columns The number of columns the board has.
     */

    public void setColumns(int columns)
    {
        this.columns = columns;
    }

    /**
     * This method stores a value in the mines field.
     * @param mines The number of mines the board has.
     */

    public void setMines(int mines)
    {
        this.mines = mines;
    }

    /**
     * This method retrieves the value stored in the rows field.
     * @return The number of rows the board has.
     */

    public int getRows()
    {
        return rows;
    }

    /**
     * This method retrieves the value stored in the columns field.
     * @return The number of columns the board has.
     */

    public int getColumns()
    {
        return columns;
    }

    /**
     * This method retrieves the value stored in the mines field.
     * @return The number of mines the board has.
     */

    public int getMines()
    {
        return mines;
    }

    /**
     * This method stores a flag position on the game board.
     * @param flagPosition A flag position in as a row, col pair.
     */

    public void setFlagPosition(Integer[] flagPosition)
    {
        if (!flagLocations.contains(flagPosition) && flagPosition.length == 2)
            flagLocations.add(flagPosition);
    }

    /**
     * This method prints all flag positions on the game board.
     */

    public void printFlagPositions()
    {
        for (Integer[] flagLocation: flagLocations)
        {
            System.out.printf("{%d, %d}\n", flagLocation[0], flagLocation[1]);
        }
    }

    /**
     * This method prints the board.
     */

    public void printBoard()
    {
        // Print column numbers;
        System.out.print(" ");
        for (int index = 0; index < columns; index++)
            System.out.print(" " + index);

        System.out.println();

        // Print the row numbers and the board contents.
        for (int index = 0; index < rows; index++)
        {
            System.out.print(index);

            for (int index2 = 0; index2 < columns; index2++)
                System.out.print(" " + board[index][index2]);

            System.out.println();
        }

    }

    /**
     * This method retrieves the mine locations.
     * @return The mine locations.
     */

    public ArrayList<Integer[]> getMineLocations()
    {
        return mineLocations;
    }

    /**
     * This method adds a mine to the mine locations.
     * @param row The row the mine is to be added at.
     * @param column The column the mine is to be added at.
     */

    public void addMine()
    {
        int randomRow = random.nextInt(rows);
        int randomColumn = random.nextInt(columns);
        Integer[] randomLocation = {randomRow, randomColumn};

        while (mineLocations.contains(randomLocation))
        {
            randomRow = random.nextInt(rows);
            randomColumn = random.nextInt(columns);
            randomLocation[0] = randomRow;
            randomLocation[1] = randomColumn;
        }

        mineLocations.add(randomLocation);
    }




}
