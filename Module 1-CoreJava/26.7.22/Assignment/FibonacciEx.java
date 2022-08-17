package a277;

import java.util.Scanner;

public class FibonacciEx
{
	public static void main(String[] args)
	{
		int i,a=0,b=1,c;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter limit: ");
		int num=sc.nextInt();
		
		for(i=1;i<=num;i++)
		{
			System.out.println(a);
			c=a+b;
			a=b;
			b=c;
		}
	}
}
