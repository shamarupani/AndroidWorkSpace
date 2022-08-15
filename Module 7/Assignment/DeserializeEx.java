package a158;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializeEx 
{
	public static void main(String[] args) 
	{
		try
		{
			ObjectInputStream in=new ObjectInputStream(new FileInputStream("D://shama1.txt"));
			Student s=(Student) in.readObject();
			System.out.println(s.id +" "+s.name);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
