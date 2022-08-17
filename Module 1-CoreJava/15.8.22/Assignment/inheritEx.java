package practice;

import java.sql.SQLClientInfoException;

class Shape1
{
	
	void PrintShape()
	{
		System.out.println("This is Shape");
	}
}

class Rectangle extends Shape1
{
	void PrintRectangle()
	{
		System.out.println("This is rectangular shape");
	}
	
	
}
class Square extends Rectangle
{
	void PrintSquare()
	{
		System.out.println("Square is a Rectangle");
	}
}
class Circle extends Shape1
{
	void PrintCircle()
	{
		System.out.println("This is circular shape");
	}
}
public class inheritEx 
{
	public static void main(String[] args)
	{
		Square s1=new Square();
		s1.PrintShape();
		s1.PrintRectangle();
	}
}
