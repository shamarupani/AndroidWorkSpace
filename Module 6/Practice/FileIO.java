package polymorphism287;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIO
{
	public static void main(String[] args) throws IOException
	{
		String s="Welcome";
		FileOutputStream fout=new FileOutputStream("D:\\shama.txt");
		fout.write(s.getBytes());
		System.out.println("success");
	}
}
