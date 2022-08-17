/*
B41. Write a program to print the area and perimeter of a triangle having sides of 3, 4 and 5 units by
creating a class named ‘Triangle’ without any parameter in its constructor.

*/


package task128;

class Triangle
{
	double length,breadth,height;
	public Triangle()
	{
		 length=3;
		 breadth=4;
		 height=5;
		

	}
	void area()
	{
		double area=0.5*breadth*height;
		System.out.println("Area of a triangle is: "+area);
		
	}
	void perimeter()
	{
		double perimeter=length+breadth+height;
		System.out.println("Perimeter of a triangle is: "+perimeter);
	}
}


public class DefaultCons 
{
	public static void main(String[] args)
	{
		Triangle t=new Triangle();
		t.area();
		t.perimeter();
	}
}
