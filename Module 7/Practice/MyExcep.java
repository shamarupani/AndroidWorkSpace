package a138;

public class MyExcep extends Exception 
{
	public MyExcep() 
	{
		// TODO Auto-generated constructor stub
		System.out.println("error executed");
	}
	public static void main(String[] args)
	{
		MyExcep m1=new MyExcep();
	}
}
