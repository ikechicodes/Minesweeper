/**
 * This class represents the game of Minesweeper.
 */

package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Game
{
    boolean gameOver;   // Game over status.

    /**
     * Constructor
     * @param args The parameters that are passed to the command line.
     */

    public Game(String[] args)
    {
        this.gameOver = false;
        boolean firstClick = true;

        // Read the file that was passed as a command line argument.
        try
        {
            File file = new File(args[0]);
            Scanner inputFile = new Scanner(file);
            String[] parameters = inputFile.nextLine().split(" ");  // Scanner object for file input.

            Scanner in = new Scanner(System.in);    // Scanner object for keyboard input.

            // Create the game board.
            int rows = Integer.parseInt(parameters[0]);
            int columns = Integer.parseInt(parameters[1]);
            int mines = Integer.parseInt(parameters[2]);

            if (rows < 1 || columns < 1)
                throw new IllegalArgumentException();

            Board board = new Board(rows, columns, mines);

            // Ask the player for his/her name.
            System.out.print("Enter your name: ");

            // Create a Player object with name.
            Player player = new Player(in.nextLine().trim());
            player.setFlags(mines);

            // Print the board.
            board.printBoard();

            // Gameplay loop.
            do
            {
                // Ask the player for the location that they want to sweep.
                System.out.print("Enter the location that you want to sweep in the form row,column.\n");
                System.out.println("Append a space \" \" followed by F to place flag at location.");

                String[] input = in.nextLine().split("[\\s,]+");

                // Verify input is correct.
                while (!verifyInput(input))
                {
                    System.out.print("The following arguments are not valid: ");
                    for (int index = 0; index < input.length; index++)
                    {
                        System.out.print(input[index] + " ");
                    }
                    System.out.print("\nEnter the location that you want to sweep in the form row,column.\n");
                    System.out.println("Append a space \" \" followed by F to place flag at location.");
                    input = in.nextLine().split("[\\s,]+");
                }

                Integer[] location = {Integer.parseInt(input[0]), Integer.parseInt(input[1])};

                if (firstClick)
                {
                    // Place the flag or sweep the location.

                    // If there is a mine at first location, move it.
                    while (board.getMineLocations().contains(location))
                    {
                        int index = board.getMineLocations().indexOf(location);

                        // Remove the mine at that position.
                        board.getMineLocations().remove(index);

                        // Add another mine at random position.
                        board.addMine();
                    }

                    // Open up all connecting spots that don't have mines.

                    firstClick = false;
                }
                else
                {
                    // If the player clicks on a mine, the game is over.
                    if (board.getMineLocations().contains(location))
                        gameOver = true;

                }




            }
            while (!gameOver);

        }
        catch(FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

    }

    /**
     * This method verifies that the input entered by the user is correct.
     * @return True if the input is correct, false if otherwise.
     */

    public boolean verifyInput(String[] input)
    {
        // If the length of the input is less than 2 or greater than 3, the input is incorrect.
        if (input.length < 2 || input.length > 3)
            return false;

        // If the first or second value is not an integer, the input is incorrect.
       if (!Character.isDigit(input[0].charAt(0)) || !Character.isDigit(input[1].charAt(0)))
           return false;

       // If the third value is not the letter F, the input is incorrect.
       if (input.length > 2 && !input[2].toUpperCase().equals("F"))
           return false;


       return true;

    }

}
