/*
    Author: Isaih Rios, Juan Murrieta, Madison Clark, Ozzy Barragan
    Description:
    Date: 11/14/19
 */
import java.io.*;
import java.util.*;

public class CSCMatch implements Serializable
{
   static MemberList membership = new MemberList();
    public static void main(String[] args)
    {
        //Introduction to the program
        System.out.println("Welcome to CSC Match, the Java program for finding matches with fellow CSC students!");
        System.out.println("Please use the menu below to navigate the user database. \n");
        System.out.println("Enter one number to select your option");
        System.out.println("Input [regress] to return to menu.");
        //User Menu
        System.out.println("User Menu\n");
        System.out.println("[1] Load the Members");
        System.out.println("[2] Save the Members");
        System.out.println("[3] List All the Members");
        System.out.println("[4] Add a Member");
        System.out.println("[5] Remove a Member");
        System.out.println("[6] List Member");
        System.out.println("[7] Add an Interest to a Member");
        System.out.println("[8] Quit");

        //add membership object


        //Switch case menu

        int select = 0;

        boolean work = true;

        while(work)

            try

            {
                Scanner in = new Scanner(System.in);

                System.out.print("\nMenu Select: ");

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

                        System.out.print("File Input: ");

                        String fileCheck = file.next();

                        if (fileCheck.contains("regress"))

                        {

                            break;

                        }

                       // File  userFile = new File(fileCheck);


                      /*  if(!userFile.exists())
                        {
                            System.out.println("That file was not found, please review file and retry option from menu.");
                        }
                        else if (userFile.exists())
                        {
                            System.out.println("File was found.");
                        membership = MemberList.load(fileCheck);
                            System.out.println("Member Loaded.");
                        }*/
                        membership = MemberList.load(fileCheck);
                        break;



                    case 2:

                        Scanner file1 = new Scanner(System.in);

                        System.out.println("Enter File to be Saved to.");

                        System.out.print("Input: ");

                        String fileName = file1.next();

                       // File  loadingFile = new File(fileName);
                        
                        membership.save(fileName);

                     /*  if (!loadingFile.canWrite())
                        {
                            System.out.println ("File cannot be written to. Please review file or enter other file from menu.");
                        }
                        else if (loadingFile.canWrite())
                        {
                       save(fileName);
                    }*/
                        break;


                    case 3:

                        System.out.println("\nListing All Members\n");

                        for(Member allMembers : membership)

                        {

                            String Grade = " ";

                            if (allMembers.getYear() == 1) { Grade = "Freshman";}

                            else if (allMembers.getYear() == 2) { Grade = "Sophmore";}

                            else if (allMembers.getYear() == 3) { Grade = "Junior";}

                            else if (allMembers.getYear() == 4) { Grade = "Senior";}

                            if (allMembers.getYear() == 5) { Grade = "Graduated";}

                            System.out.println(allMembers.getName() + ": " + Grade);

                        }

                        break;


                    case 4: // Only option that is good

                        System.out.println("Adding Member");

                        Scanner kb = new Scanner(System.in);

                        try {

                            String name = "";

                            do {

                                System.out.println("Enter new member name:"); // A member can have any name, so regress cannot apply here

                                name = kb.nextLine();

                                if (membership.existingMember(name) != null)  // generic test for listing member as well

                                {
                                    System.out.println(" That Name is already Taken, please enter another.");
                                }

                            } while (membership.existingMember(name) != null);

                            int year;

                            do

                                {

                                System.out.println("Enter member year between 1-5");    //Ensure that user input meets parameters

                                year = kb.nextInt();

                                if (year < 0 || year > 5)

                                {

                                    System.out.println("Please enter a year between 1 and 5.");

                                }

                            } while (year < 1 || year > 5);

                            membership.addMember(name, year);

                            System.out.println("Member Successfully Added");
                        }


                        catch(InputMismatchException e)

                        {
                            System.out.println("Only enter integer values.");
                        }

                        break;


                    case 5:

                        System.out.println("Removing Member");

                        Scanner kb2 = new Scanner(System.in);

                        String badName = "";

                        Member m = null;


                        do {

                            System.out.println("Enter Name of Member to be Removed.");

                            badName = kb2.nextLine();

                            m = membership.existingMember(badName);

                            if (m == null)  // generic test for listing member as well

                            {
                                System.out.println("That name is not in the database. Please enter existing member name.");
                            }

                        } while (m == null);

                        membership.removeMember(m);

                        break;


                    case 6:

                        System.out.println("List Member");

                        String idName = "";

                        Scanner kb3 = new Scanner(System.in);


                        do {

                            System.out.println("Enter Name of Member to be Listed:");

                            idName = kb3.nextLine();


                            //if (membership.existingMember(idName) != null)  // generic test for listing member as well

                            {
                            	boolean listFound = false;
                            	for(Member m1 : membership)
                            	{
                            		if(m1.getName().equalsIgnoreCase(idName))
                            		{
                            			listFound = true;
		                            	System.out.println("Member found.");
		                            	
		                            	System.out.println();
		                            	
		                            	System.out.println(m1.getName() + ": ");
		                            	
		                            	for(Interest iList : m1.interestList) {
		                            		System.out.print(iList.getTopic() + ": " + iList.getTopicInterest());	
		                            		System.out.println();
		                            	}
		                            	
		                            	System.out.println();
		                            	
		                                for(Member m2 : membership)
		                                {
		                                	m2.score = m1.calculateCompatability(m2);
		                                	Match newMatch = new Match(m2.getName(),m2.getScore());
		                                	m1.addMatch(newMatch);
		                                }
                            		
		                      
		                                if(m1.top5.isEmpty() == false)
		                                {
		                                	for( int i = 0; i < 5; i++)
			                                {
			                                	System.out.println(m1.top5.get(i).getMatchName());
			                                	
			                                }
		                                }
		                                else {
		                                	System.out.println("Matches list is empty");
		                                }
                            		}                            
                               
                            	}
                            if (listFound == true)
                            {
                            	System.out.println("No member found");
                            	return;
                            }
                            }

                        }

                        while (membership.existingMember(idName) != null);

                        break;


                    case 7:

                        System.out.println("Add Interest to Member");

                        Scanner kb4 = new Scanner(System.in);

                        String newName = "";

                        do {

                            System.out.print("\nEnter Name of the member:");

                            newName = kb4.nextLine();

                            boolean found = false;
                            for(Member findMem : membership)
                            if(findMem.getName().equalsIgnoreCase(newName))	
                            { 
                            	found = true;
                            	try
                            	{
                            	System.out.println("Enter name of interest");
                            	Scanner kb5 = new Scanner(System.in);
                            	
                            	String newInterest = kb5.nextLine();
                            	
                            	Scanner kb6 = new Scanner(System.in); 
                            	System.out.println("Enter the level of interest. 0 - 10");
                            	 boolean valid = false;
                                       
				       while(!valid)
                                       { 
                                    	int interestLevel = kb6.nextInt();
                                    	   
                                    	   if(interestLevel >= 0 && interestLevel <=10)
                                    	   {
                                    	   	   findMem.addInterest(newInterest, interestLevel);
		                                   System.out.println("Interest added! ");    
		                                   valid = true;
                                    	   }
                                    	   else
                                    	   {
                                    		   System.out.println("Not valid, enter input again");
                                    	   }
                                    		   
                                       }  
                                        save = 1; 
					
                            	catch (InputMismatchException e) {}
                            }
                          if(found == false)
                          {
                        	  System.out.println("Member was not found.");
                          }
                          }	
                        
                        while (membership.existingMember(newName) != null);
                        
                            	
                            	break;


                    case 8:

                        //if () {}

                        //else if ()

                        {
                        
                            System.out.println("Thank you for using CSC Match.");

                            System.exit(0);
                            System.out.println();

                        }
                }


            }

            catch (InputMismatchException e)

            {
                System.out.println("Please enter a number 1-8");
            }

            catch(NoSuchElementException e)

            {
                System.out.println("Please enter a number 1-8");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        work = false;
    
    }
    

    
    }

