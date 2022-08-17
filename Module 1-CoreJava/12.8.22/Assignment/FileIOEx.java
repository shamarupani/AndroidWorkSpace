package corejava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileIOEx
{
	public static void main(String[] args) throws IOException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id:");
		String id=sc.next();
		
		System.out.println("Enter name:");
		String name=sc.next();
		
		System.out.println("Enter mobile number:");
		String num=sc.next();
		
		System.out.println("Enter emailid:");
		String email=sc.next();
		
		System.out.println("Enter city:");
		String city=sc.next();
		
		FileOutputStream fout =new FileOutputStream("D://a.txt");
		
		 String n1="Your id is ";
		 fout.write(n1.getBytes());
		 
		fout.write(id.getBytes());
		String n2="Your Name is ";
		fout.write(n2.getBytes());
		fout.write(name.getBytes());
		String n3="Your mobile number is ";
		fout.write(n3.getBytes());
		fout.write(num.getBytes());
		String n4="Your email id is ";
		fout.write(n4.getBytes());
		fout.write(email.getBytes());
		String n5="Your city is ";
		fout.write(n5.getBytes());
		fout.write(city.getBytes());
	}
}
