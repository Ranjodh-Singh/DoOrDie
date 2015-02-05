 package edu.princeton.test;

/**
 * The Class BitOff.
 * @see <a href="http://geeksquiz.com/algorithms/bit-algorithms/">link</a>
 */
public class BitOff {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		int number = 4;
		int bitOff = 3;
		int modified = bitoff(number, bitOff);
		System.out.println("Originatl : " + number + " off by " + bitOff + " new number : " + modified);

	}

	/**
	 * Bitoff.
	 *
	 * @param number the number
	 * @param bitOff the bit off
	 * @return the int
	 */
	private static int bitoff(int number, int bitOff) {
		return (number & (~(1 << (bitOff - 1))));

	}

}
