package a168;

public class MultiDimEx
{
	public static void main(String[] args)
	{
		int marks[][]= {{1,2,3,4},{4,5,6,7},{7,8,9,1}};
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<4;j++)
			{
				System.out.print(marks[i][j]);
			}
			System.out.println();
		}
	}
}
