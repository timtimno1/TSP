package tsp.tools;
//import java.lang.Math;
import java.util.ArrayList;
import java.util.List;
//import tsp.tools.setData;
/**
* This class is print tool
* @author Tim
* @version 1.0.0
*/
public class disp
{
	/**
	* This method is disply TwoArray
	* @param W Twoarray
	* @return no return
	*/
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
	public static void PrintP(setData d,int[][] P)
	{
		int count=0;
		int i=(int) d.s.get(d.A[d.A.length-1]);
		ArrayList<Integer> temp=new ArrayList<Integer>();
		temp.addAll(d.A[d.A.length-1]);
		System.out.print("V1 -->");
		while(true)
		{
			if(temp.isEmpty())break;
			System.out.print("V" + P[count][i] + "--> ");
			Integer n=P[count][i];
			count=P[count][i]-1;
			temp.remove(n);
			i=(int) (temp.isEmpty()?0:d.s.get(temp));
		}
	}
}
