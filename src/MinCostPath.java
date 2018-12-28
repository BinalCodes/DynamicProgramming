
public class MinCostPath {

	public static void main(String[] args) {
		int [][] a = new int[][] {{1,2,3},{4,8,2},{1,5,3}};
		System.out.println("The minimum cost to reach a[2][2] is "+getMinCost(a,2,2));

	}
	public static int getMinCost (int[][] a , int m, int n) {
		int dp [][] = new int[m+1][n+1];
		dp[0][0] = 0;
		for (int i =1;i<= m ;i++) {
			dp[i][0] = dp[i-1][0] + a[i][0];
		}
		for (int j = 1 ; j<= n ;j++) {
			dp[0][j] = dp[0][j-1] + a [0][j];
		}
		for ( int i = 1 ; i<= m; i++) {
			for(int j =1; j<= n ; j++) {
				dp [i][j] = min(dp[i-1][j] , dp [i-1][j-1] ,dp [i][j-1]) + a[i][j];
			}
		}
		return dp[m][n];
	}
	private static int min (int x, int y , int z) {
		if (x<y)
			return (x<z) ? x: z;
		 return ( y<z)? y : z;
			
	}
}
