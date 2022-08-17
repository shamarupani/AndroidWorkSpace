package Task;

import java.util.Scanner;

class Complex
{
	int real1,real2,imag1,imag2;
	void print()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter real part of first complex number:");
		real1=sc.nextInt();
		System.out.println("Enter imaginary part of first complex number: ");
		imag1=sc.nextInt();	
		System.out.println("Enter real part of second complex number:");
		real2=sc.nextInt();
		System.out.println("Enter imaginary part of second complex number: ");
		imag2=sc.nextInt();
		System.out.println("First complex number is "+real1+" + "+imag1+" i");
		System.out.println("Second complex number is "+real2+" + "+imag2+" i");
		
		
	}
	void add()
	{
		
		int add1= real1+real2;
		int add2= imag1+imag2;
		
		System.out.println("Addition of two complex number is: "+add1+" + "+add2+" i");
	}
	void sub()
	{
		int sub1=real1-real2;
		int sub2=imag1-imag2;
		System.out.println("Difference between two complex number is: "+sub1+" + "+sub2+" i");
	
	}
	void mul()
	{
		int mul1=real1*real2;
		int mul2=imag1*imag2;
		System.out.println("Multiplication of two complex number is: "+mul1+" + "+mul2+" i");
	}
	void div()
	{
		int div1=real1/real2;
		int div2=imag1/imag2;
		System.out.println("Division of two complex number is: "+div1+" + "+div2+" i");
	}
}
public class ComplexEx 
{
	public static void main(String[] args) 
	{
		
		  Complex c1=new Complex(); 
		  c1.print();
		  c1.add();
		  c1.sub();
		  c1.mul();
		  c1.div();
		 
	}
}
