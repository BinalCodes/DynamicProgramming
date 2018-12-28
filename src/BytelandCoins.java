import java.util.*;
import java.lang.*;

public class BytelandCoins {
		static int NIL = -1;
		static int MAX = 100;
		static int lookup[] = new int[MAX+1];
		static{
			initialize();
		}
		public static void main (String[] args) throws java.lang.Exception
		{
			int n = 7;
			
			System.out.println("Number of coins "+getCoins(n));
		}
		public static void initialize(){
			for (int i =0; i< MAX ; i++){
				lookup[i] = NIL;
			}
		}
		public static int getCoins(int n ){
			if (lookup[n] == NIL){
				if (n <=4)
					lookup[n] = n;
				else
					lookup[n] = getCoins(n/2) + getCoins(n/3) + getCoins(n/4);
			}
			return (n >lookup[n])? n : lookup[n] ;
		}
		public static int getIterativeCoins (int n){
			int coins [] = new int[n+1];
			coins [0] = 0;
			coins [1] = 1;
			coins [2]= 2;
			coins[3] = 3;
			for (int i = 4; i<= n; i++ ){
				coins [i] = coins[i]/2 + coins[i] /3 + coins[i]/4;
			}
			return coins[n];
		}
}
