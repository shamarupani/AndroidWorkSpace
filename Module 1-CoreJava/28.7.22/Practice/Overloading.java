package polymorphism287;

public class Overloading
{
	static int calex(int a,int b)
	{
		return a+b;
	}
	static int calex(int a,int b,int c)
	{
		return a*b*c;
	}
	public static void main(String[] args)
	{
		
		System.out.println(calex(2,3));
		
		System.out.println(calex(2, 3, 5));
	}
}
