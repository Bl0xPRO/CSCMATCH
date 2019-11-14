import java.io.Serializable;
import java.util.Scanner;
import java.util.LinkedList;

public class Member implements Serializable

{
    public String name;

    public int year;
    
    public int sum;
    
	Scanner kb = new Scanner(System.in);
    
	LinkedList<Interest> interestList = new LinkedList<Interest>();
	LinkedList<Member> memberList = new LinkedList<Member>();
	LinkedList<Member> topFive = new LinkedList<Member>();
	
    public Member (String name, int year) 

    {

    	this.name = name;
    	this.year = year;

    }

   public void changeName(String name) {
	   this.name = name;
   }
   
   public void changeYear(int year) {
	   this.year = year;
   }
   
   public void addInterest(String topic, int topicInterest)
  {
	for(Interest in : interestList)
	{
		if(topic.equalsIgnoreCase(in.getTopic()))
		{
			in.changeTopicIntrest(topicInterest);
		}
	}
   }
   
   public String getName()
   {
	   return name;
   }
   
   
   public double calculateCompatability(Member m2)
   {
	   for( Interest i : this.interestList) 
	   {
		 for (Interest i2 : m2.interestList)
		 {
			 if(i.getTopic().equalsIgnoreCase(i2.getTopic())) 
			 {
				 sum = sum + (i.getTopicInterest() * i2.getTopicInterest());
			 }
			 else
			 {
				sum = sum + (i2.getTopicInterest() / 2); 
			 }
		 }
	   }
	  
	   
   }
   
   
   
}
