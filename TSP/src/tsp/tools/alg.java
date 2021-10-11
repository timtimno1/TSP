package tsp.tools;

public class alg
{
	public static long bin(int n , int k)
	{
		long[][] b = new long[n + 1][k + 1];
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= Math.min(i, k); j++)
				if (j == 0 || i == 0)
					b[i][j] = 1;
				else
					b[i][j] = b[i - 1][j - 1] + b[i - 1][j];
		return b[n][k];
	}
}
