/*
    Author: Isaih Rios, Juan Murrieta, Madison Clark, Ozzy Barragan
    Description:
    Date: 11/14/19
 */
import java.io.File;
import java.util.*;

public class CSCMatch 
{

	public static void main(String[] args) 
	{
		//Introduction to the program
	System.out.println("Welcome to CSC Match, the Java program for finding matches with fellow CSC students!");
        System.out.println("Please use the menu below to navigate the user database. \n");
        System.out.println("Enter one number to select your option");
        //User Menu
        System.out.println("User Menu\n");
        System.out.println("Load the Members [1]");
        System.out.println("Save the Members [2]");
        System.out.println("List All the Members [3]");
        System.out.println("Add a Member [4]");
        System.out.println("Remove a Member [5]");
        System.out.println("List Member [6]");
        System.out.println("Add an Interest to a Member [7]");
        System.out.println("Quit [8]\n");

        //add membership object
        MemberList membership = new MemberList();
        
        //Switch case menu
        
        int select = 0;
       
    	  boolean work = true;
    	  
       while(work)
        try 
        {
            Scanner in = new Scanner(System.in);

            System.out.print("Select: ");

            select = in.nextInt();
            if(select > 8) //Instructs user to enter correct input
            {
            	System.out.println("Enter a number 1-8");
            	System.out.println();
            	select = in.nextInt();
            }
            
        	switch(select)
	        {
	        case 1:
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
		   break;
	        case 2: 
	                Scanner file1 = new Scanner(System.in);
	                System.out.println("Enter File to be Saved to.");
	                System.out.print("Input: ");

	                String fileCheck1 = file1.next();
	                File  userFile1 = new File(fileCheck1);

	                if (fileCheck1.contains("Return to Menu"))
	                {
	                	
	                }
	                else if(!userFile1.exists())
	                {
	                    System.out.println("That file was not found, please enter another file.");
	                }
	                else if (userFile1.exists())
	                {
	                    System.out.println("File was found.");
	                }
	            	
	           break;
	        case 3: 
	        	System.out.println("Listing All Members");	
	           break;
	        case 4: 
	        	System.out.println("Adding Member");
            	
	        	Scanner kb = new Scanner(System.in);
	      	  try 
		   {
	            	System.out.println("Enter new member name");	
	            	String name = kb.nextLine();
	            	
	            	System.out.println("Enter member year 1-5");	//Ensure that user input meets parameters
	            	int year = kb.nextInt();
	            	if(year < 0 || year > 5)
	            	{
	            		System.out.println("Enter a year 1-5");
	            		year = kb.nextInt();
	            	}
	            	
	                membership.addMember(name, year);
	                System.out.println("");
            	   } 
	           catch(InputMismatchException e)
            	   {
            		System.out.println("Enter only integer values!");
            	   }
	           break;	
	        case 5: 
                	System.out.println("Removing Member");
                	System.out.println("Please enter name of member to be removed.");
                	System.out.print("input");
	             break;
	        case 6:
	        	System.out.println("List Member");
                	System.out.println("Please Enter Member Name.");
                	System.out.print("Input: ");
	            break;
	        case 7:
	        	System.out.println("Add Interest to Member");
	                System.out.println("Please Enter Member Name:");
	        	break;
	        case 8: 
	        	System.out.println("Thank you for using CSC Match.");
	                System.exit(0);	
	            break;
	        }
        }
        catch (InputMismatchException e)
        	{
        		System.out.println("Please enter a number 1-8");
        	}
       	catch(NoSuchElementException e)
       		{
       			System.out.println("Please enter a number 1-8");
       		}
        work = false;
	}

}


