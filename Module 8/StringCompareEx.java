package a168;

public class StringCompareEx 
{
	public static void main(String[] args)
	{
		String s1="Tops";
		String s2="Tops";
		String s3=new String("Tops");
		String s4="Spot";
		
		
		System.out.println("--------------Equals-------------");
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s1.equals(s4));
		
		
		System.out.println("--------- ==  -----------");
		System.out.println(s1==s2);
		System.out.println(s1==s3);		//false because one string is string literal and other is with new keyword
		
		
		
		String s5="mouse";
		String s6="mouse";
		String s7="MOUSE";
		
		
		System.out.println("---------Equals Ignorecase-----------");
		System.out.println(s5.equals(s6));
		System.out.println(s5.equalsIgnoreCase(s7));
		
		
		String s8="sachin";
		String s9="saurav";
		String s10="sachin";
		
		System.out.println("--------- CompareTo-----------");
		System.out.println(s8.compareTo(s10));
		System.out.println(s8.compareTo(s9));
		
		
	}
}
