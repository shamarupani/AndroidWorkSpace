package a178;

import java.util.Vector;

public class VectorEx
{
	public static void main(String[] args)
	{
		Vector v=new Vector<>(5);	//(5) is the capacity <> is the size
		
		v.add("A");
		v.add("B");
		v.add("C");
		v.add("D");
		v.addElement("E"); // vector can add values using both methods add and addElement
		v.add("F");
		v.add("G");		//vector can increase its capacity dynamically if we take more values 
		
		System.out.println(v.size());
		System.out.println(v.capacity());
		
		if(v.contains("D"))
		{
			System.out.println("True");
		}
		else
		{
			System.out.println("False");
		}
		
		System.out.println(v.firstElement());
		System.out.println(v.lastElement());
	}
}
