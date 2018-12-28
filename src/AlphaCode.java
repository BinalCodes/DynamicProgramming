import java.util.Scanner;

/*
 * 
 * Alice: “Let’s just use a very simple code: We’ll assign ‘A’ the code word 1, ‘B’ will be 2, and so on down to ‘Z’ being assigned 26.”

Bob: “That’s a stupid code, Alice. Suppose I send you the word ‘BEAN’ encoded as 25114. You could decode that in many different ways!”
Alice: “Sure you could, but what words would you get? Other than ‘BEAN’, you’d get ‘BEAAD’, ‘YAAD’, ‘YAN’, ‘YKD’ and ‘BEKD’. I think you would be able to figure out the correct decoding. And why would you send me the word ‘BEAN’ anyway?”
Bob: “OK, maybe that’s a bad example, but I bet you that if you got a string of length 5000 there would be tons of different decodings and with that many you would find at least two different ones that would make sense.”
Alice: “How many different decodings?”
Bob: “Jillions!”

Input:

25114
1111111111
3333333333
0

Output:

6
89
1
 */
public class AlphaCode {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println("Number of possible decoded strings would be "+getAlphaCodes(s.toCharArray()));

	}
	public static long getAlphaCodes (char[] charArr) {
		Integer x = Integer.parseInt(Character.toString(charArr[0]));
		int[] a = new int[charArr.length +1];
		if (x!= 0) {
			for (int i = 1 ;i < a.length ; i++) {
				a[i] = Integer.parseInt(Character.toString(charArr[i-1]));
			}
		}
			long dp [] = new long [a.length];
			dp[0] = 1; // for i-2 cases
			dp[1] = 1; // for the first letter in the arr
			for (int i = 2 ;i < a.length ; i++) {
				if (a[i] == 0) {
					dp [i] = dp[i-2];
				}
				else if(a[i] <= 6 && (a[i-1] ==1 || a[i-1] == 2)) {
					dp[i] = dp[i-1] + dp[i-2];
				}
				else if ( a[i] > 6 && (a[i-1] ==1)) {
					dp[i] = dp[i-1] + dp[i-2];
				}
				else 
					dp[i] = dp[i-1];
		}
		return dp[a.length -1];
	}

}
