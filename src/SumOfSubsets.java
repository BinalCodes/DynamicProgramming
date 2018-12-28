import java.util.HashMap;

import javax.print.attribute.HashAttributeSet;

/*
Given a set of non-negative integers, and a value sum, determine 
if there is a subset of the given set with sum equal to given sum.

Examples: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output:  True  //There is a subset (4, 5) with sum 9.
 */
public class SumOfSubsets {

	public static void main(String[] args) {
		int arr[] = {3,34,4,12,5,2};
		int total = 9;
		HashMap<String, Integer> lookupMap = new HashMap<String,Integer>();
		System.out.println("the number of subsets for a given sum are "+getNumOfSubsets(arr,total,arr.length-1,lookupMap));
	}
	public static int getNumOfSubsets(int arr[],int total,int i,HashMap<String,Integer>lookupMap) {
		String key = String.valueOf(total) + ":"+i;
		int toReturn;
		if (lookupMap.containsKey(key))
			return lookupMap.get(key);
		if( total ==0)
			return 1;
		if (total < 0)
			return 0;
		if ( i < 0)
			return 0;
		if(arr[i] > total)
			toReturn = getNumOfSubsets(arr, total, i-1, lookupMap);
		else {
			toReturn =  getNumOfSubsets(arr, total-arr[i], i-1, lookupMap) + getNumOfSubsets(arr, total, i-1, lookupMap);
		}
		lookupMap.put(key, toReturn);
		System.out.println("hashmap printing "+lookupMap.get(key));
		return toReturn;
	}

}
