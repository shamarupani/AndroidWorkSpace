package task228;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOEx 
{
	public static void main(String[] args) throws IOException 
	{
		String  s="welcome";
		FileOutputStream fout =new FileOutputStream("D://shama.txt");
		fout.write(s.getBytes());
		System.out.println("success");
	}
}
