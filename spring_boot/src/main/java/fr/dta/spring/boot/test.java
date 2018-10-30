package fr.dta.spring.boot;

public class test {
	public static void main()
	{
		int[][] nums = new int[3][3];
		for(int a[] : nums)
		{
			for(int b : a)
			{
				System.out.println(b);
			}
		}
	}
}
