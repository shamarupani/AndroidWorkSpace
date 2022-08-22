package task228;

public class MyException extends Exception 
{
	public MyException()
	{
		//TODO Auto-generated constructor stub
		System.out.println("Error executed");
	}
	public static void main(String[] args) 
	{
		MyException m1=new MyException();
		
	}
}
