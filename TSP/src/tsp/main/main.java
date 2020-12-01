package tsp.main;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;
import tsp.tools.disp;
import tsp.tools.setData;
public class main
{
	protected static int start;
	protected static int vnearNumber;
	public static void main(String[] args) 
	{
		HashSet<String> v=new HashSet<String>();
		HashMap s=new HashMap();
		Scanner in=new Scanner(System.in);
		long time1,time2;
		time1=System.currentTimeMillis();
		
		vnearNumber=in.nextInt();
		start=in.nextInt()-1;
		String cas=in.nextLine();
		int[][] W=new int[vnearNumber][vnearNumber];
		int[][] D=new int[vnearNumber][(int) (Math.pow(2,vnearNumber-1))];
		int[][] P=new int[vnearNumber][(int) (Math.pow(2,vnearNumber-1))];
		
		for(int i=0;i<vnearNumber;i++)
		{
			int j=0;
			String temp=in.nextLine();
			for(String str:temp.split(","))
			{
				W[i][j++]=Integer.valueOf(str);
			}
		}
		for(int i=0;i<vnearNumber;i++)												//*
		{																			//*
			if(i==start) continue;													//*初始化任意點到V1的距離
			D[i][(int) (Math.pow(2,vnearNumber-1))-1]=W[i][start];					//*
		}																			//*
		setData d1=new setData();
		d1.init();
		/*for(int i=0;i<d1.A.length;i++)
		{
			System.out.println(d1.s.get(d1.A[i]));
		}*/

		for(int k=0;k<d1.A.length;k++)
		{
			ArrayList<Integer> temp=new ArrayList<Integer>();
			temp.addAll(d1.T);
			temp.removeAll(d1.A[k]);
			for(Integer i:temp)
			{
				if(i==start+1)continue;
				//System.out.println(i);
				int min=999_999;
				for(int j=0;j<d1.A[k].size();j++)
				{
					ArrayList<Integer> temp1=new ArrayList<Integer>();
					temp1.addAll(d1.A[k]);
					temp1.remove(d1.A[k].get(j));
					if(min>W[i-1][(int) d1.A[k].get(j)-1]+D[(int) d1.A[k].get(j)-1][temp1.isEmpty()?(int) (Math.pow(2,vnearNumber-1))-1:(int)d1.s.get(temp1)])
					{
						min=W[i-1][(int) d1.A[k].get(j)-1]+D[(int) d1.A[k].get(j)-1][temp1.isEmpty()?(int) (Math.pow(2,vnearNumber-1))-1:(int)d1.s.get(temp1)];
						P[i-1][(int) d1.s.get(d1.A[k])]=(int) d1.A[k].get(j);
					}
				}
				D[i-1][(int) d1.s.get(d1.A[k])]=min;
			}
		}
		int min=Integer.MAX_VALUE;
		for(int i=0;i<d1.A[d1.A.length-1].size();i++)
		{
			ArrayList<Integer> temp1=new ArrayList<Integer>();
			temp1.addAll(d1.A[d1.A.length-1]);
			temp1.remove(d1.A[d1.A.length-1].get(i));
			if(min>W[0][(int) d1.A[d1.A.length-1].get(i)-1]+D[(int) d1.A[d1.A.length-1].get(i)-1][temp1.isEmpty()?(int) (Math.pow(2,vnearNumber-1))-1:(int)d1.s.get(temp1)])
			{
				min=W[0][(int) d1.A[d1.A.length-1].get(i)-1]+D[(int) d1.A[d1.A.length-1].get(i)-1][temp1.isEmpty()?(int) (Math.pow(2,vnearNumber-1))-1:(int)d1.s.get(temp1)];
				P[0][(int) d1.s.get(d1.A[d1.A.length-1])]=(int) d1.A[d1.A.length-1].get(i);
			}
		}
		D[0][(int) d1.s.get(d1.A[d1.A.length-1])]=min;
		//disp.printTwoArray(P);
		int count=0;
		int i=(int) d1.s.get(d1.A[d1.A.length-1]);
		ArrayList<Integer> temp=new ArrayList<Integer>();
		temp.addAll(d1.A[d1.A.length-1]);
		System.out.print("V1 -->");
		while(true)
		{
			if(temp.isEmpty())break;
			System.out.print("V" + P[count][i] + "--> ");
			Integer n=P[count][i];
			count=P[count][i]-1;
			temp.remove(n);
			i=(int) (temp.isEmpty()?0:d1.s.get(temp));
		}
		time2=System.currentTimeMillis();
		System.out.print("V1");
		System.out.print("\n");
		System.out.println(min);
		System.out.println("計算時間為: " + (time2-time1)/1000.0 + "秒");
		System.out.println("請按任意鍵繼續");
		String str = in.next();
		//d1.A[6].remove(0);
		//System.out.println(d1.s.get(d1.A[6]));
		//d1.A[6].removeAll(d1.A[0]);
		//disp.print(d1.A);
		/*v.add("V2");
		v.add("V3");
		int i=0;
		for(String str:v)
		{
			s.put(str, i++);
		}
		for(String str:v)
		{
			data[(int) (s.get(str))]=5;
		}
		for(int j:data)
		{
			System.out.print(j+ " ");
		}*/
	}

}
