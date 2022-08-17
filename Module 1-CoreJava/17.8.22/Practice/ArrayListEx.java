package a178;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListEx
{
	public static void main(String[] args) 
	{
		ArrayList arraylist=new ArrayList<>();  // <> anglular bracket is generic <E> E is Entity
		arraylist.add("Android");	// add is method
		arraylist.add("Java");
		arraylist.add("PHP");
		
		ArrayList arraylist2=new ArrayList<>();
		arraylist2.add("Python");
		arraylist2.add("GD");
		arraylist2.add("IOS");
		arraylist2.add("Kotlin");
		
		arraylist.addAll(arraylist2);  //addall adds all the values of both list
		/*
	  	arraylist.remove(0);		//removes by index value
		arraylist.remove("GD");		//removes by name
		arraylist.removeAll(arraylist2);	//removes all values
		*/
		
		Iterator i=arraylist.iterator(); //Iterator is an interface
		while(i.hasNext())			// hasNext prints all values in a loop
		{
			System.out.println(i.next());
		}
	}
}
