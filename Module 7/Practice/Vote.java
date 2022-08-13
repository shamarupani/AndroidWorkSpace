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

