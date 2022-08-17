/*
B40. Create a class named Rectangle with two data members length and breadth and two methods to
print the area and perimeter of the rectangle respectively. Its constructor having parameters for
length and breadth is used to initialize the length and breadth of the rectangle. Let class Square
inherit the Rectangle class with its constructor having a parameter for its side (suppose s) calling the
constructor of its parent class as ‘super (s, s)’. Print the area and perimeter of a rectangle and a
square.
*/

package task128;

class Rectangle
{
	double length,breadth;
	
	public Rectangle(double length,double breadth) 
	{
		this.length=length;
		this.breadth=breadth;
	}
	void perimeter()
	{
		double perimeter=length+length+breadth+breadth;
		System.out.println("Perimeter of a rectangle is: "+perimeter );
		
	}
	void area()
	{
		double area=length*breadth;
		System.out.println("Area of a rectangle is: "+area);
	}
}

class Square extends Rectangle
{

	public Square(double length, double breadth) 
	{
		super(length, breadth);
		//TODO Auto-generated constructor stub
	}

	void getside(int side)
	{
		double area=side*side;
		System.out.println("Area of a square is: "+area);
	}
	
}

public class ParameterizedCons
{
	public static void main(String[] args) {
		

	Square s=new Square(5.6, 3.4);
	s.getside(4);
	s.perimeter();
	s.area();
	
	}	
}
