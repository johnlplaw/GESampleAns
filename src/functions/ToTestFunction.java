/**
 * Question 1 and 2
 */
package functions;

import java.util.ArrayList;
import java.util.Arrays;

public class ToTestFunction {

	public static void main(String[] args) {

		int[] listNumber = { 1, 5, 3, -5, 7, 9, -2, 4, -4, 6, 2, -1 };

		System.out.println("Q1. Sum of 2 largest int: " + sumOfTwoLargestElements(listNumber));

		System.out.println("=============");

		System.out.println("Q2. The nearest value to zero: " + getClosestToZero(listNumber));

		System.out.println("=============");

	}

	/**
	 * Please implement this method to return the sum of the 
	 * two largest integer numbers in a given array.
	 * 
	 * @param s Pass in integer in array form
	 * @return the result of sum of two largest elements
	 */
	public static int sumOfTwoLargestElements(int[] s) {
		int result = -1;
		Arrays.sort(s);
		System.out.println("largest: " + s[s.length - 1]);
		System.out.println("2nd largest: " + s[s.length - 2]);
		result = s[s.length - 1] + s[s.length - 2];

		return result;
	}

	/**
	 * Please implement this method to return the integer number in a
     * given array that is closest to zero.
     * If there are two equally closest to zero elements like 2 and -2
     * consider the positive element, i.e. 2, to be "closer" to zero.
	 * 
	 * @param a Pass in integer in array form
	 * @return the result of sum of two largest elements
	 */
	public static int getClosestToZero(int[] a) {
		int result = 0;
		int[] distanceToZero = new int[a.length];

		// find the distance
		for (int i = 0; i < a.length; i++) {
			int dist = Math.abs(a[i] - 0);
			distanceToZero[i] = dist;
		}

		// To get the min distance
		int minD = distanceToZero[0];
		for (int dist : distanceToZero) {
			if (minD > dist) {
				minD = dist;
			}
		}
		System.out.println("Min distance: " + minD);

		// find the min distance value
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < a.length; i++) {
			if (minD == distanceToZero[i]) {
				list.add(minD);
			}
		}

		// sort from min to max
		list.sort(null);
		result = list.get(list.size() - 1);

		return result;
	}

	

}
