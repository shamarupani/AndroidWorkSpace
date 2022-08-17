package a277;

import java.util.Scanner;

public class FactorialEx 
{
	public static void main(String[] args)
	{
		int i,fact=1;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter any number to find its factorial:");
		int num=sc.nextInt();
		
		for(i=1;i<=num;i++)
		{	
			fact=i*num;
			
		}
		System.out.println(fact);
	}
}
