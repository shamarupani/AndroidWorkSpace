package corejava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ReadEx 
{
	public static void main(String[] args) throws FileNotFoundException {
		
		try
		{
			FileInputStream fin =new FileInputStream("D://a.txt");
			int i=0;
			while((i=fin.read())!=-1)
			{
				System.out.println((char)i);
			}
			fin.close();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		}
	}

