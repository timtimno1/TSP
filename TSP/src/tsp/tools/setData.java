package tsp.tools;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import tsp.main.main;
import tsp.tools.alg;
public class setData extends main
{
	public List<Integer> T=new ArrayList<Integer>();
	public List[] A=new List[(int) (Math.pow(2,vnearNumber-1))-1];
	public HashMap s=new HashMap();
	public List[] init()
	{
		int count=0;
		for(int i=1;i<=main.vnearNumber;i++)
		{
			T.add(i);
		}
		for(int i=0;i<A.length;i++)
		{
			A[i]=new ArrayList<Integer>();
		}
		for(int k=1;k<main.vnearNumber;k++)
		{
			int temp[]=new int[k];
			for(int i=0;i<temp.length;i++)
			{
					temp[i]=i+2;
					A[k==1?count++:count].add(temp[i]);
			}
			if(k!=1)count++;
			while(k<main.vnearNumber-1)
			{
				temp[temp.length-1]++;
				int i=1;
				while(k>1 && k<main.vnearNumber-1)
				{
					if(temp[temp.length-i]>main.vnearNumber-(i-1))
					{
						temp[temp.length-(++i)]++;
						if(temp.length-i==0)break;
					}
					else
					{
						
						break;
					}
				}
				for(int j=k-i+1;j<temp.length;j++)
				{
					temp[j]=temp[j-1]+1;
				}
				for(int j:temp)
				{
					A[count].add(j);
				}
				count++;
				if(temp[temp.length-1]==main.vnearNumber && temp[0]==temp[temp.length-1]-(k-1))break;
			}
		}
		count=0; //­ì¥»¬°0
		for(List<Integer> i:A)
		{
			s.put(i, count++);	
		}
		return A;
	}
	
}
