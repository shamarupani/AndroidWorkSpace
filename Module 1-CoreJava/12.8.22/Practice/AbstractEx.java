package task128;

abstract class Tops
{
	abstract void studentdetail();
	void a()
	{
		System.out.println("aa");
	}
}
class Tops2 extends Tops
{

	@Override
	void studentdetail() {
		// TODO Auto-generated method stub
		System.out.println("Student data accessed");
	}
	
}
public class AbstractEx
{
	public static void main(String[] args)
	{
		Tops2 t2=new Tops2();
		t2.a();
		t2.studentdetail();
	}
}
