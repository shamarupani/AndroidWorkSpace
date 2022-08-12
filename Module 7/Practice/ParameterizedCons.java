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
