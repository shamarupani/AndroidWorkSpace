package a217;

class B
{
	String color="red";
}
class C extends B
{
	String color="blue";
	void display()
	{
		System.out.println(color);
		System.out.println(super.color);
		
	}
}

public class SuperEx 
{
	public static void main(String[] args)
	{
		C c1=new C();
		c1.display();
	}
	
	
}
