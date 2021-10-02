package course1;

import java.util.Scanner;

public class GreatestCommonDivisor {
	public static void main(String[] args) {
		GreatestCommonDivisor gcd = new GreatestCommonDivisor();
    	gcd.printGreatestCommonDivisor();
    }
    
    public int greatestCommonDivisor(int a, int b) {
    	if(b == 0) {
    		return a;
    	}
        int aPrime = a % b;
        return greatestCommonDivisor(b, aPrime);
    }
    
    public void printGreatestCommonDivisor() {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        System.out.println(greatestCommonDivisor(a, b));
    }
}