package a178;

import java.util.HashSet;

public class HashSetEx
{
	public static void main(String[] args)
	{
		HashSet set=new HashSet<>();
		
		set.add("A");
		set.add("B");
		set.add("C");
		set.add("C");			//HashSet doesn't take duplicate values
		set.add("S");			//HashSet takes values in random order
		System.out.println(set);
	}
}
