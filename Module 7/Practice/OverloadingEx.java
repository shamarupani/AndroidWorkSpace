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
