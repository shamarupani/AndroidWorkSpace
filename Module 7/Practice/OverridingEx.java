package task128;

class Printnumber
{
	int printn(int n)
	{
		return n;
	}
	double printn(double d)
	{
		return d;
	}
	float printn(float f)
	{
		return f;
	}
	
}

public class OverridingEx
{
	public static void main(String[] args) 
	{
		Printnumber p=new Printnumber();
	System.out.println(p.printn(5));
	System.out.println(p.printn(5.666));
	System.out.println(p.printn(5.00));
		
	}
	
}
