package practice;

import java.util.Scanner;

class Grade
{
	void show(int marks)
	{
		if(marks>=90 && marks<=100)
		{
			System.out.println("Grade AA");
		}
		else if(marks>=81 && marks<=90)
		{
			System.out.println("Grade AB");
		}
		else if(marks>=71 && marks<=80)
		{
			System.out.println("Grade BB");
		}
		else if(marks>=61 && marks<=70)
		{
			System.out.println("Grade BC");
		}
		else if(marks>=51 && marks<=60)
		{
			System.out.println("Grade CD");
		}
		else if(marks>=41 && marks<=50)
		{
			System.out.println("Grade DD");
		}
		else if(marks<=40)
		{
			System.out.println("Fail");
		}
	}
}


public class Marks

{
	public static void main(String[] args) 
	{
		Grade g1=new Grade();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the marks (out of 100): ");
		int marks=sc.nextInt();
		g1.show(marks);
	}
}
