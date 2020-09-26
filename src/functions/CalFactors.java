/**
 * Write a Java program to list out the first 1500 natural numbers whose factor(s) is/are either ONLY 2, 3, or 5.
 */
package functions;

import java.util.ArrayList;
import java.util.Arrays;

public class CalFactors {
	/**
	 * To store the factors
	 */
	private ArrayList<Integer> pflist = new ArrayList<Integer>();

	public ArrayList<Integer> getPflist() {
		return pflist;
	}

	public void setPflist(ArrayList<Integer> pflist) {
		this.pflist = pflist;
	}

	/**
	 * Check whether it is Prime num
	 * 
	 * @param suspectPrime pass in number
	 * @return True if it s prime number, otherwise false
	 */
	private boolean isPrimeNum(int suspectPrime) {
		for (int i = 2; i < suspectPrime; i++) {
			if (suspectPrime % i == 0)
				return false;
		}
		return true;
	}

	/**
	 * Main function to find the prime number
	 * 
	 * @param n Pass in number
	 */
	public void executePrimeFact(int n) {
		executePrimeFactRR(n, n - 1);
	}

	/**
	 * Recursive function to find all the prime number
	 * 
	 * @param n Pass in number
	 * @param m Pass in number where m = n -1
	 */
	private void executePrimeFactRR(int n, int m) {

		if (isPrimeNum(n)) {
			pflist.add(n);
		} else if (n % m == 0) {
			executePrimeFactRR(m, m - 1);
			executePrimeFactRR(n / m, (n / m) - 1);
		} else {
			executePrimeFactRR(n, m - 1);
		}

	}

	/**
	 * The Main function
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Integer[] selectedFactor = { 2, 3, 5 };

		for (int i = 1; i <= 1500; i++) {
			CalFactors pf = new CalFactors();
			pf.executePrimeFact(i);
			ArrayList<Integer> list = pf.getPflist();

			if (isFactorOnly(list, selectedFactor)) {
				System.out.print("\n" + i + " : ");
				list.sort(null);
				for (int fvalue : list) {
					System.out.print(fvalue + " ");
				}
			}

		}

	}

	/**
	 * Check whether the factor list is found in the s list
	 * @param thelist factor list
	 * @param s selected factor
	 * @return True if the all items in the factor list are found in s
	 */
	public static boolean isFactorOnly(ArrayList<Integer> thelist, Integer[] s) {

		boolean result = false;
		for (int f : thelist) {
			result = Arrays.asList(s).contains(f);
			if (!result){
				break;
			}
		}
		return result;
	}

}
