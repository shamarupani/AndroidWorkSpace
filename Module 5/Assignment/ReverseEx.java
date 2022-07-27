package a277;

import java.util.Scanner;

public class ReverseEx 
{
	public static void main(String[] args) 
	{
		int rev=0,rem,num;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter any number:");
		num=sc.nextInt();
		while(num!=0)
		{
			rem=num%10;
			rev=rev*10+rem;
			num=num/10;
		}
		System.out.println(rev);
	}
}
  