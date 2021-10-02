package course1;

import java.util.Scanner;

public class LeastCommonMultiple {
	public static void main(String[] args) {
		LeastCommonMultiple lcd = new LeastCommonMultiple();
    	lcd.printLeastCommonMultiple();
    }
    
    public long leastCommonMultiple(int a, int b) {
    	return  abs(a, b) / (long) greatestCommonDivisor(a, b);
    }
    
    public void printLeastCommonMultiple() {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        System.out.println(leastCommonMultiple(a, b));
    }
    
    private long abs(int a, int b) {
    	if(a < 0 ^ b < 0) {
    		return -a*b;
    	}
    	return (long) a*b;
    }
    
    private int greatestCommonDivisor(int a, int b) {
    	if(b == 0) {
    		return a;
    	}
        int aPrime = a % b;
        return greatestCommonDivisor(b, aPrime);
    }
}