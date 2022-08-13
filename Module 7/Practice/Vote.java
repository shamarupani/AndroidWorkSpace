
/*
I2. W.A.J.P to create the validate method that takes integer value as a parameter. If the age is less
than 18, then throw an ArithmeticException otherwise print a message welcome to vote.
*/

package a138;


public class Vote 
{
	static void validate(int age)
	{
		if(age>=18)
		{
			System.out.println("welcome to vote");
		}
		else
		{
			try
			{
				throw new MyExcep();
				
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		System.out.println("success");
	}
	public static void main(String[] args) 
	{
		validate(12);
	}
}

