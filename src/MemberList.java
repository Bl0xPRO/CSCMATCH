import java.util.LinkedList;	
import java.util.Iterator;
import java.util.*;
import java.io.*;
public class MemberList implements Iterable<Member>, Serializable

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
public void removeMember()
{
	memberList.remove();
}
	//save file (Taken from POS)
public void save(String fileName) throws IOException
{
	FileOutputStream fos = new FileOutputStream(fileName); 
	ObjectOutputStream oos = new ObjectOutputStream(fos); 
	oos.writeObject(this); 
	oos.flush(); 
	oos.close(); 
}
	//load members (Taken from POS)
public static MemberList load(String fileName) throws IOException, ClassNotFoundException
{
	FileInputStream fis = new FileInputStream(fileName);
	ObjectInputStream ois = new ObjectInputStream(fis);
	MemberList ml = (MemberList) ois.readObject();
	ois.close();
		
	return ml;
}

}
