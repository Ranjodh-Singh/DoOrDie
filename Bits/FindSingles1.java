package edu.princeton.test;
/**
 * finding the not duplicate element out of array of duplicate elements.
 * @author ranjodh_singh
 *
 */
public class FindSingles1 {

	public static void main(String[] args) {
		int input []= {1,3,1,3,5,2,12,15,7,5,2,7,8,8,12};
		int result =0;
		for (int i = 0; i < input.length; i++) {
			// each item will cancel it's duplicate as item^item1 =0 iff item=item1
			result = result^input[i];
		}
		System.out.println(result);

	}

}
