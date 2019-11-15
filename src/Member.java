import java.io.Serializable;
import java.util.Scanner;
import java.util.LinkedList;

public class Member implements Serializable

{
    public String name;

    public int year;
    
    public int score;
    
	Scanner kb = new Scanner(System.in);
    
	LinkedList<Interest> interestList = new LinkedList<Interest>();
	LinkedList<Member> memberList = new LinkedList<Member>();
	ArrayOrderedList<Member> top5 = new ArrayOrderedList<Member>();
	
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
   
   public void addInterest(String topic, int topicInterest)
  {
	   boolean found = false;
	for(Interest in : interestList)
	{
		
		if(topic.equalsIgnoreCase(in.getTopic()))
		{
			found = true;
			in.changeTopicInterest(topicInterest);	
		}
	}
	if(!found) {
		Interest newI = new Interest(topic, topicInterest);
		interestList.add(newI);
	}
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
   
   public void oderList()
   {
	   for(Member match : this.top5)
	   {
		   match.getScore(); 
	   }
   }
}
