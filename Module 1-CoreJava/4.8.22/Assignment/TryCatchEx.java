/*
B26. W.A.J. P to demonstrate try catch block, Take two numbers from the user and perform the
division operation and handle Arithmetic Exception.

*/

package task128;

import java.util.Scanner;

public class TryCatchEx 
{
	public static void main(String[] args) 
	{
			try
			{
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter first number:");
				int num1=sc.nextInt();
				System.out.println("Enter second number");
				int num2=sc.nextInt();
				int num3=num1/num2;
				System.out.println(num3);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
}
