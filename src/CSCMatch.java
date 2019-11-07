/*
    Author: Isaih Rios, Juan Murrieta, Madison Clark, Ozzy Barragan
    Description:
    Date: 11/14/19
 */

import java.util.*;

import java.io.File;

public class CSCMatch

{

    public static void main (String[] args) {

        // Print out user intro and user menu

        System.out.println("Welcome to CSC Match, the Java program for finding matches with fellow CSC students!");
        System.out.println("Please use the menu below to navigate the user database. \n");


        System.out.println("User Menu\n");
        System.out.println("Load the Members [1]");
        System.out.println("Save the Members [2]");
        System.out.println("List All the Members [3]");
        System.out.println("Add a Member [4]");
        System.out.println("Remove a Member [5]");
        System.out.println("List Member [6]");
        System.out.println("Add an Interest to a Member [7]");
        System.out.println("Quit [8]\n");

        // work keeps the program working when the exception is encountered.

        int work = 1;

        while (work == 1)

        {

        try {

            Scanner in = new Scanner(System.in);

            System.out.print("Input: ");

            int input = in.nextInt();


            // Logic to make sure only menu integers are allowed.

            while (input < 1) {

                System.out.println("Sorry, please input an integer from the menu.");

                input = in.nextInt();

            }

            while (input > 8) {

                System.out.println("Sorry, please input an integer from the menu.");

                input = in.nextInt();

            }

            // Logic to determine navigation of program.

            // Load the members

            if (input == 1)

            {

                Scanner file = new Scanner(System.in);

                System.out.println("Please enter filename to load from.");

                System.out.print("Input: ");

                String fileCheck = file.next();

                File  userFile = new File(fileCheck);

                if (fileCheck.contains("Return to Menu"))

                {



                }

                else if(!userFile.exists())

                {

                System.out.println("That file was not found, please enter another file.");

                }

                else if (userFile.exists())

                {

                    System.out.println("File was found.");

                }

            }


            // Save the Members

            else if (input == 2)

            {

                Scanner file = new Scanner(System.in);

                System.out.println("Enter File to be Saved to.");

                System.out.print("Input: ");

                String fileCheck = file.next();

                File  userFile = new File(fileCheck);

                if (fileCheck.contains("Return to Menu"))

                {



                }

                else if(!userFile.exists())

                {

                    System.out.println("That file was not found, please enter another file.");

                }

                else if (userFile.exists())

                {

                    System.out.println("File was found.");

                }


            }

            // List all Members

            else if (input == 3)

            {

                System.out.println("Listing All Members");

            }

            // Add a Member

            else if (input == 4)

            {

                System.out.println("Adding Member");

                System.out.println("");

            }

            // Remove Member

            else if (input == 5)

            {

                System.out.println("Removing Member");

                System.out.println("Please enter name of member to be removed.");

                System.out.print("input");

            }

            // List Member

            else if (input == 6)

            {

                System.out.println("List Member");

                System.out.println("Please Enter Member Name.");

                System.out.print("Input: ");

            }

            // Add an interest to a member

            else if (input == 7)

            {

                System.out.println("Add Interest to Member");

                System.out.println("Please Enter Member Name:");

            }

            else if (input == 8) {

                System.out.println("Thank you for using CSC Match.");

                System.exit(0);

            }

        }

        catch (InputMismatchException e)

        {

            System.out.println("Error: Only Input Integers for Menu Navigation.\n");

        }


    }


    }
    
}
