import java.util.LinkedList;	
import java.util.Iterator;
import java.util.*;
import java.io.*;
public class MemberList implements Iterable<Member>, Serializable, Comparable<Member>

{	//Create List for members
	//add save and load method for memberList
	LinkedList<Member> memberList = new LinkedList<Member>();
	
public void addMember(String name, int year) 
{
	//Create member object with parameters for name and year
	//If Member name is unique then add, if not then change name
	Member M = new Member(name, year);
		
	memberList.add(M);
		
		
	}
	// Instantiate iterator and get its methods
public Iterator<Member> iterator() 	
	{
		return memberList.iterator();
	}
	//add method for comparing unique name using for each 
public Member existingMember(String name)
{
	Member found = null;
	
	for(Member m: memberList)
		{
			if(name.equals(m.getName()))
			{
				found = m;
			}
		}
		
		return found;
	}
public void removeMember(Member m)
{
	memberList.remove();
}
	//save file
public void save(String fileName) throws IOException
{
	FileOutputStream fos = new FileOutputStream(fileName); 
	ObjectOutputStream oos = new ObjectOutputStream(fos); 
	
	
	
	if (memberList.isEmpty()) {
		System.out.println("The list is empty");
	}
	
	for ( Member x : memberList) {
		System.out.println(" - " + x.getName());
	}
	
	
	
	oos.writeObject(this); 
	oos.flush(); 
	oos.close(); 
	System.out.println("Saved!");
}
	//load members

public static MemberList load(String fileName) throws IOException, ClassNotFoundException
{
	System.out.println("Loading");
	FileInputStream fis = new FileInputStream(fileName);
	ObjectInputStream ois = new ObjectInputStream(fis);
	MemberList m1 = (MemberList) ois.readObject();
	ois.close();
	if (m1.memberList.isEmpty()) {
		System.out.println("The list is empty");
	}
	
	for ( Member x : m1) {
		System.out.println(" - " + x.getName());
	}
	
	
	return m1;
}
@Override
public int compareTo(Member arg0) {
	// TODO Auto-generated method stub
	return 0;
}

}
