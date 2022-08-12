package task128;

class Parent
{
	void display()
	{
		System.out.println("This is parent class");
	}
}
class Child extends Parent
{
	void show()
	{
		System.out.println("This is child class");
	}
}
public class InheritanceEx 
{
	public static void main(String[] args) {
		
	
	Parent p=new Parent();
	Child c=new Child();
	p.display();
	c.show();
	c.display();
}
}
