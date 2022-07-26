package a217;

public class StaticVariableEx 
{
	static int count=0;
	public StaticVariableEx()
	{
		// TODO Auto-generated constructor stub
		count++;
		System.out.println(count);
	}
	public static void main(String[] args)
	{
		StaticVariableEx s1=new StaticVariableEx();
		StaticVariableEx s2=new StaticVariableEx();
		StaticVariableEx s3=new StaticVariableEx();
		
	}
	
}
