package tsp.tools;
import java.lang.Math;
import java.util.List;
public class disp
{
	public static void printTwoArray(int[][] W)
	{
		for(int[] i:W)
		{
			for(int j:i)
			{
				System.out.printf("%-6d",j);
			}
			System.out.print("\n");
		}
	}
	public static void print(List[] A)
	{
		for(List<Integer> i:A)
		{
			for(Integer j:i)
			{
				System.out.printf(j + " ");
			}
			System.out.print("\n");
		}
	}
}
