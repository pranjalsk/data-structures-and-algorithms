package com.starPatterns;

public class StarPatterns {

	public static void main(String[] args) {
		StarPatterns o = new StarPatterns();
		System.out.println("--------1---------");
		o.prettyPattern1();
		System.out.println("--------2---------");
		o.prettyPattern2();
		System.out.println("--------3---------");
		o.prettyPattern3();
		System.out.println("--------4---------");
		o.prettyPattern4();
		System.out.println("--------5---------");
		o.prettyPattern5();
		System.out.println("--------6---------");
		o.prettyPattern6();
		System.out.println("--------7---------");
		o.prettyPattern7();
	}


//    *
//   ***
//  *****
// *******
//*********
	public void prettyPattern1() {
		int i, j, k;
		for (i = 1; i <= 5; i++) { // 5 rows
			for (j = i; j < 5; j++) { // on row 1 we leave 4 blank spots, then
										// 3, 2, 1, 0..
				System.out.print(" ");
			}
			for (k = 1; k <= (2 * i - 1); k++) { // we have stars 1,3,5,7,9 resp
													// => 2i-1
				System.out.print("*");
			}
			System.out.println("");
		}
	}

	
//	*********
//	 *******
//	  *****
//	   ***
//	    *
	public void prettyPattern2() {
		int i, j, k;
		for (i = 5; i >= 1; i--) { // 5 rows
			for (j = 5; j > i; j--) {
				System.out.print(" ");
			}
			for (k = 1; k <= (2 * i - 1); k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	
	
//	*
//	**
//	***
//	****
//	*****
	public void prettyPattern3() {
		int i, j;
		for (i = 1; i <= 5; i++) {
			for (j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	
	
//	*****
//	****
//	***
//	**
//	*
	public void prettyPattern4() {
		int i, j;
		for (i = 5; i >= 1; i--) {
			for (j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	
	
//    *
//   **
//  ***
// ****
//*****
	public void prettyPattern5() {
		int i, j, k;
		for (i = 5; i >= 1; i--) {
			for (j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for (k = 5; k >= i; k--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

//	*****
//	 ****
//	  ***
//	   **
//	    *
	public void prettyPattern6() {
		int i, j, k;
		for (i = 5; i >= 1; i--) {
			for (j = 5; j > i; j--) {
				System.out.print(" ");
			}
			for (k = 1; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	
	
	
//    *
//   ***
//  *****
// *******
//*********
// *******
//  *****
//   ***
//    *
	public void prettyPattern7() {
		int i, j, k;
		for (i = 1; i <= 5; i++) {
			for (j = i; j < 5; j++) {
				System.out.print(" ");
			}
			for (k = 1; k < (i * 2); k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (i = 4; i >= 1; i--) {
			for (j = 5; j > i; j--) {
				System.out.print(" ");
			}
			for (k = 1; k < (i * 2); k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
