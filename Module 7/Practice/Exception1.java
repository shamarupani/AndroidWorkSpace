/*
I1. W.A.J.P to read 10 integer values using Scanner class from keyboard. Generate the exception if
the entered value is less than 10 and or greater than 40. Program should display appropriate message
as and when this exception occurs otherwise it will display all the entered values.
*/

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
