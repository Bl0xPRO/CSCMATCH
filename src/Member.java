import java.io.Serializable;
import java.util.Scanner;
import java.util.LinkedList;

public class Member implements Serializable

{
    public String name;

    public int year;
    
    public int score;
    
	transient Scanner kb = new Scanner(System.in);
    
	LinkedList<Interest> interestList = new LinkedList<Interest>();
	LinkedList<Member> memberList = new LinkedList<Member>();
	LinkedList<Match> top5 = new LinkedList<Match>();
	
    public Member (String name, int year) 

    {

    	this.name = name;
    	this.year = year;
    	this.score = -1000;

    }

   public void changeName(String name) {
	   this.name = name;
   }
   
   public void changeYear(int year) {
	   this.year = year;
   }
   
 
   
   public String getName()
   {
	   return name;
   }
   
   public int getYear() { return year;}
   
   public int getScore()
   {
	   return score;
   }
   
   
   public int calculateCompatability(Member m2)
   {
	   
	   int sum = 0;
	   
	   for( Interest i : m2.interestList) 
	   {
		   
		   boolean found = false;
		   
		 for (Interest i2 : this.interestList)
		 {
			 if(i.getTopic().equalsIgnoreCase(i2.getTopic())) 
			 {
				 sum = sum + (i.getTopicInterest() * i2.getTopicInterest());
				 found = true;
			 }
		 } 
		if(found = false)
		{
			sum = sum + ( i.getTopicInterest() / 2 );
		}
			 
		 }
	  
	  return sum;
   }
   
   public void addMatch(Match newMatch)
   {
	   Match top;
	   int index = 0;
	   if (top5.isEmpty()) {
		   top5.add(newMatch);
	   }
	   else
	   {
		   top = top5.getFirst();
		   
		   while(index < top5.size()) {
			   
		   if(top.getcompScore() > newMatch.getcompScore())
		   {
			top5.add(index, newMatch); 
		   }
		   else if(index == top5.size() - 1)
		   {
			top5.add(newMatch);
		   }
		   else
		   {
			   index ++;
			   top = top5.get(index);
		   }
		 }
	   }
	
   }
   public void addInterest(String interest, int interestLevel)
   {
 	   boolean found = false;
 	for(Interest in : interestList)
 	{
 		
 		if(interest.equalsIgnoreCase(in.getTopic()))
 		{
 			found = true;
 			in.changeTopicInterest(interestLevel);	
 		}
 	}
 	if(!found) {
 		
 		 Interest newI = new Interest(interest, interestLevel);
 		 interestList.add(newI);
 		 
 		 //This code was supposed to order the interest as we added them to a member but was problematic
 		 
 		/* Interest top;
 		   int index = 0;
 		   if (interestList.isEmpty()) {
 			   interestList.add(newI);
 		   }
 		   else
 		   {
 			   top = interestList.getFirst();
 			   
 			   while(index < interestList.size())
 			   {
 				  if(top.getTopicInterest() > newI.getTopicInterest())
 				   {
 					interestList.add(index, newI); 
 				   }
 				   else if(index == top5.size() - 1)
 				   {
 					interestList.add(newI);
 				   }
 				   else
 				   {
 					   index ++;
 					   top = interestList.get(index);
 				   }
 			   }
 		   }
 		*/
 		
 	}
    }
 
   
}
