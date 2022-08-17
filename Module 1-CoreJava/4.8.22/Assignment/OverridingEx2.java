/*
B36. Create a class to print an integer and a character with two methods having the same name but
different sequence of the integer and the character parameters.
For example, if the parameters of the first method are of the form (int n, char c), then that of the
second method will be of the form (char c, int n).
*/

package task128;

class Sequence
{
	void display(int n,char c)
	{
		System.out.println("Value of integer is "+n+"  Value of character is "+c);
	}
	void display(char c,int n)
	{
		System.out.println("Value of character is "+c+" Value of integer is "+n);
	}
}
public class OverridingEx2 
{
	public static void main(String[] args)
	{
		Sequence s=new Sequence();
		s.display(3, 'a');
		s.display('d', 2);
	}

}
