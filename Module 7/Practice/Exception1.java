package a138;

import java.util.Scanner;


public class Exception1
{
	
	void display()
	{
		try
		{
			int num[]=new int[10];
			Scanner sc = new Scanner(System.in);
			for(int i=0;i<10;i++)
			{
				System.out.println("Enter 10 numbers: ");
				num[i]=sc.nextInt();
				if(num[i]<10 || num[i]>40)
				 {
					 throw new excep(); 
				 }
				  
				 else
				  { 
					  System.out.println(num[i]); 
				  }
			 }		
						   			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			System.out.println("success");
		}
	}

	public static void main(String[] args)
	{
		Exception1 e1=new Exception1();
		e1.display();
	}							
}			