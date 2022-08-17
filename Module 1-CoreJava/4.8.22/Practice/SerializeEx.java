package a158;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializeEx
{
	public static void main(String[] args)
	{
		try
		{
			Student s=new Student(101, "shama");
			FileOutputStream fout=new FileOutputStream("D://shama1.txt");
			ObjectOutputStream out=new ObjectOutputStream(fout);
			out.writeObject(s);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("success");
	}
}
