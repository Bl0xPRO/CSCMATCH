import java.util.LinkedList;	
import java.util.Iterator;
import java.util.Scanner;
import java.io.Serializable;
public class MemberList implements Iterator<String>, Serializable

{
	LinkedList<Member> MemberList = new LinkedList<Member>();
	

	public boolean hasNext() 
	{
		
		return false;
	}

	@Override
	public String next() 
	{
		return null;
	}
	
	
	public void addMember(String name, int year) 
	{
	
		Member M = new Member("", 5);
		
	}

}

