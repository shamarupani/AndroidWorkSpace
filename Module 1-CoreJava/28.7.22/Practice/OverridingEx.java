package polymorphism287;

class Bank
{
	int rate()
	{
		return 0;
	}
}
class Sbi extends Bank
{
	int rate()
	{
		return 7;
	}
}
class Icici extends Bank
{
	int rate()
	{
		return 8;
	}
}
class Bob extends Bank
{
	int rate()
	{
		return 6;	
	}
}
class Hdfc extends Bank
{
	int rate()
	{
		return 5;
	}
}
public class OverridingEx 
{
	public static void main(String[] args) 
	{
		Bank b;
		b=new Sbi();
		System.out.println(b.rate());
		b=new Icici();
		System.out.println(b.rate());
		b=new Hdfc();
		System.out.println(b.rate());
		b=new Bob();
		System.out.println(b.rate());
	}
}
