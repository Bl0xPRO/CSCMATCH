import java.io.Serializable;
import java.util.LinkedList;
import java.util.Scanner;

public class Interest implements Serializable
{
//public Interest (String topic, int topicInterest)
	
	//NOTES
	/* I was told to use scanner so I did but 
	 * In case we change that I commented out different uses
	 * I also used print line we can remove it if thats not something we want. 
	 * 
	 */
	LinkedList<Interest> interestList = new LinkedList<Interest>(); 
	
	//Variables
	public String topic;
	public int topicInterest;
	
	//Scanner = scnr
	//Scanner scnr = new Scanner(System.in);	
	
	public Interest(String t, int l) {
		this.topic = t;
		this.topicInterest = l;
	}
	
	//Methods below
	public void enterTopicName(String topic) {
		
		//System.out.println("Enter topic name: ");
		//topic = scnr.nextLine();
		this.topic = topic;
	}
	
	public void enterTopicInterest(int TopicInterest) {
		
		//System.out.println("Enter topic Intrest level: ");
		//TopicIntrest = scnr.nextInt();
		this.topicInterest = TopicInterest;
	}
	
	public void changeTopicName(String topic) {
		
		//System.out.println("What would you like to change the topic name to?: ");
		//topic = scnr.nextLine();
		this.topic = topic;
	}
	
	public void changeTopicInterest(int TopicInterest) {
		
		//System.out.println("What would you like to change the Intrest level to?: ");
		//TopicIntrest = scnr.nextInt();
		this.topicInterest = TopicInterest;
	}
	public String getTopic()
	{
		return topic;
	}
	public int getTopicInterest()
	{
		return topicInterest;
	}
}
