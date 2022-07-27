package a277;

import java.util.Scanner;

public class SumEx 
{
	public static void main(String[] args)
	{
		int rem,sum=0,num;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number to find its sum: ");
		num=sc.nextInt();
		while(num!=0)
		{
			rem=num%10;
			sum=sum + rem;
			num=num/10;
		}
		System.out.println(sum);
	}
}
