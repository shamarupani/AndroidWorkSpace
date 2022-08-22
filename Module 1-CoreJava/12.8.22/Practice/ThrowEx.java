package task228;

public class ThrowEx
{
	static void validate(int age)
	{
		if(age>=18)
		{
			System.out.println("Eliglible to vote");
		}
		else
		{
			try
			{
				throw new MyException();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
	public static void main(String[] args) {
		validate(15);
	}
}
