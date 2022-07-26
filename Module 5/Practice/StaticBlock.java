package a217;

public class StaticBlock
{
	public static void main(String[] args)
	{
		System.out.println("hello");
	}
	static							//static block executes first
	{
		System.out.println("welcome");
	}
}
