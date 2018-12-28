/**
 * 
 * @author binal
 *
 *  * Given two strings how many minimum edits(update, delete or add) is needed to convert one string to another
 *
 * Time complexity is O(m*n)
 * Space complexity is O(m*n)
 *
 * References:
 * http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 * https://en.wikipedia.org/wiki/Edit_distance
 */

public class EditDistance {

	public static void main(String[] args) {
		String str1 = "azced";
        String str2 = "abcdef";
        EditDistance editDistance = new EditDistance();
        int result = editDistance.dynamicEditDistance(str1.toCharArray(), str2.toCharArray());
        System.out.print(result);

	}
	public int dynamicEditDistance (char[] str1, char[] str2) {
		int [][] tmp = new int[str1.length+1][str2.length+1];
		for(int i =0 ;i< str1.length ; i ++) {
			tmp[i][0] = i;
		}
		for(int i =0 ;i< str2.length ; i ++) {
			tmp[0][i] = i;
		}
		for (int i = 1 ;i <=str1.length ; i++) {
			for (int j = 1; j<=str2.length ; j++) {
				if ( str1[i-1] == str2[j-1]) {
					tmp[i][j] = tmp[i-1][j-1];
				}
				else {
					tmp [i][j]= 1+ min(tmp[i-1][j-1], tmp [i-1][j],tmp[i][j-1]);
				}
			}
		}
		return tmp[str1.length][str2.length];
	}
	private static int min (int x, int y , int z) {
		if (x<y)
			return (x<z) ? x: z;
		 return ( y<z)? y : z;
			
	}
}
