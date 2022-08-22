package task228;

import java.io.IOException;

class M
{
	void m() throws IOException
	{
		System.out.println("m executed");
	}
}
class N extends M
{
	void n() throws IOException
	{
		m();
		System.out.println("n executed");
	}
}
class P extends N
{
	void p() throws IOException
	{
		n();
		System.out.println("p executed");
	}
}
public class ThrowsEx 
{
	public static void main(String[] args) throws IOException {
		
	
	P p1=new P();
	p1.m();
	p1.n();
	p1.p();
	
	}
}
