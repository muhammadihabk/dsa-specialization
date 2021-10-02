package course1;

import java.util.Scanner;

public class SumTwoDigits {

	public static void main(String[] args) {
		SumTwoDigits sotd = new SumTwoDigits();
		sotd.sum();
	}
	
	public int sumOfTwoDigits(int a, int b) {
		return a + b;
	}
	
	public void sum() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter 2 numbers:");
		int a = input.nextInt();
		int b = input.nextInt();
		input.close();
		System.out.println("Answer: " + sumOfTwoDigits(a, b));
	}

}
