package a277;

import java.util.Scanner;

public class TableEx 
{
	public static void main(String[] args)
	{
		int i;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter any number to print its table:");
		int num=sc.nextInt();
		for(i=1;i<=10;i++)
		{
			
			System.out.println(num+" * "+i+" = " +num*i);
		}
		
	}
}
