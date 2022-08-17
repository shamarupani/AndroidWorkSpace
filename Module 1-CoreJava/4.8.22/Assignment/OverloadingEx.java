/*
B37. Create a class to print the area of a square and a rectangle. The class has two methods with the
same name but different number of parameters. The method for printing area of a rectangle has two
parameters which are length and breadth respectively while the other method for printing area of
square has one parameter which is side of square.

*/

package task128;

class Area
{
	void area(double length,double breadth)
	{
		double area=length*breadth;
		System.out.println("Area of a rectangle is: "+area );
	}
	void area(double side)
	{
		double area=side*side*side;
		System.out.println("Area of a square is: "+area);
	}
}

public class OverloadingEx 
{
	public static void main(String[] args) 
	{
		Area a=new Area();
		a.area(5.66, 6.77);
		a.area(4.43);
	}
}
