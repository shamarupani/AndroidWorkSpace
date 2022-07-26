package a217;

public class StaticVarMethod 
{
	int id;
	String name;
	static String college="Atmiya";
	
	StaticVarMethod(int id,String name)
	{
		this.id=id;
		this.name=name;
	}
	void display()
	{
		System.out.println(id+" "+name +" "+college);
	}
	static void change()
	{
		college="vvp";
	}
	public static void main(String[] args)
	{
	
		StaticVarMethod s1=new StaticVarMethod(101,"shama");		
		StaticVarMethod s2=new StaticVarMethod(102,"yasin");
		change();
		s1.display();
		s2.display();
		
	
		
	}
}
