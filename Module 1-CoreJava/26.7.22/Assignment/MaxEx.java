package a277;

import java.util.Scanner;

public class MaxEx 
{
	public static void main(String[] args) 
	{
		int num,i,a,max=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of elements you wish to find its greatest: ");
		num=sc.nextInt();
		for(i=1;i<=num;i++)
		{
			System.out.println("Element: ");
			a=sc.nextInt();
			if(max<a)
			{
				max=a;
			}
			
		}
		System.out.println("Your max element is: "+max);
		
	}
}
