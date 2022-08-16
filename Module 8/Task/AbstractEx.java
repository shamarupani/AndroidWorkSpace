package practice;

abstract class Shape
{
	abstract void RectangleArea(int length,int breadth);
	abstract void SquareArea(int side);
	abstract void CircleArea(double radius);
}
class Area extends Shape
{

	@Override
	void RectangleArea(int length, int breadth)
	{
		// TODO Auto-generated method stub
		int area=length*breadth;
		System.out.println("Area of a rectangle is:"+area);
	}

	@Override
	void SquareArea(int side) 
	{
		// TODO Auto-generated method stub
		int area=4*side;
		System.out.println("Area of a square is: "+area);
		
	}

	@Override
	void CircleArea(double radius)
	{
		// TODO Auto-generated method stub
		double area=3.14*radius*radius;
		System.out.println("Area of a circle is: "+area);
		
	}
				
}

public class AbstractEx 
{
	public static void main(String[] args) 
	{
		Area a1=new Area();
		a1.RectangleArea(2, 3);
		a1.SquareArea(3);
		a1.CircleArea(4.4);
	}
}
