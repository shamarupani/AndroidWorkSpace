package practice;

import java.util.Scanner;

class Complexno
{
	
	float real,img;
	Complexno()
	{
		real=0;
		img=0;
	}
	Complexno(float a,float b)
	{
		real=a;
		img=b;
	}
	void display(Complexno c1,Complexno c2)
	{
		System.out.println("First complex number is"+c1.real+"+"+c1.img+"i");
		System.out.println("Second complex number is"+c2.real+"+"+c2.img+"i");
	}
	void add(Complexno c1,Complexno c2)
	{
		
		real=c1.real+c2.real;
		img=c1.img+c2.img;
		System.out.println("Addition of two numbers is: "+real+"+"+img+"i");
	}
	void sub(Complexno c1,Complexno c2)
	{
		real=c1.real-c2.real;
		img=c1.img-c2.img;
		System.out.println("Substraction of two numbers is: "+real+"+"+img+"i");
	}
	void mul(Complexno c1,Complexno c2)
	{
		real=c1.real*c2.real;
		img=c1.img*c2.img;
		System.out.println("Multiplication of two numbers is: "+real+"+"+img+"i");
	}
	void div(Complexno c1,Complexno c2)
	{
		real=c1.real/c2.real;
		img=c1.img/c2.img;
		System.out.println("Division of two numbers is: "+real+"+"+img+"i");
	}
}



public class ComplexNumberusingConstructor
{
	public static void main(String[] args) 
	{
		
		
		float num1,num2;
		Complexno cal=new Complexno();
		 Scanner Sc = new Scanner(System.in);
		 System.out.println("Enter the Complex number in a+bi format : "); //taking
	
		 System.out.print("Enter real part of First Number: a : ");
		 num1 = Sc.nextFloat();
		 System.out.print("Enter img part of First Number: b : ");
		 num2 = Sc.nextFloat();
		 Complexno Com1 = new Complexno(num1, num2); 
	
		 System.out.print("Enter real part of Second Number: a : ");
		 num1 = Sc.nextFloat();
		 System.out.print("Enter img part of Second Number: b : ");
		 num2 = Sc.nextFloat();
		 Complexno Com2 = new Complexno(num1, num2);
		 cal.display(Com1, Com2);
		 cal.add(Com1, Com2);
		 cal.sub(Com1, Com2);
		 cal.mul(Com1, Com2);
		 cal.div(Com1, Com2);
	}
}
