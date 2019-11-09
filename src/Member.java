import java.io.Serializable;
import java.util.Scanner;
import java.util.LinkedList;

public abstract class Member implements Serializable

{
    public String name;

    public int year;
    
	Scanner kb = new Scanner(System.in);
    
	LinkedList<Interest> interestList = new LinkedList<Interest>();
	
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
   
//   public void addInterest(String topic, int topicInterest)
//  {
//	   
//  }
   
}
