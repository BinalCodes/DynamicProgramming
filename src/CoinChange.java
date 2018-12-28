import java.util.Arrays;

/*
 * 
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.

For example, for N = 4 and S = {1,2,3}, 
there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. 
So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. 
So the output should be 5.
 */
public class CoinChange {

	public static void main(String[] args) {
		int arr [] = {8,3,1,2};
		int total = 4;
		//System.out.println("The number of sets of coins required for total "+total + " is "+getSetOfCoins(arr,total));

		System.out.println("The number of sets of coins required for total "+total + " is "+countWaysToSaveSpace(arr,arr.length,total));
		

	}
	public static int getSetOfCoins (int arr[], int total) {
		int[][] tmp = new int[arr.length+1][total+1];
		
		for(int i =0;i< arr.length ; i++) {
			tmp[i][0] = 1;
		}
		Arrays.sort(arr);
		for (int i = 1; i<= arr.length ; i++ ) {
			for (int j = 1 ; j <= total ;j ++) {
				if (j >= arr[i-1]) {
					tmp[i][j] = tmp[i-1][j] + tmp [i][j-arr[i-1]];
				}
				else
					tmp[i][j] = tmp[i-1][j];
			}
		}
		return tmp[arr.length][total];
	}
	static long countWaysToSaveSpace(int S[], int m, int n)
    {
        //Time complexity of this function: O(mn)
        //Space Complexity of this function: O(n)
 
        // table[i] will be storing the number of solutions
        // for value i. We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)
        long[] table = new long[n+1];
 
        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)
 
        // Base case (If given value is 0)
        table[0] = 1;
 
        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i=0; i<m; i++)
            for (int j=S[i]; j<=n; j++)
                table[j] += table[j-S[i]];
 
        return table[n];
    }

}
