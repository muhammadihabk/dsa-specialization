package course1;

import java.util.Scanner;

public class LastDigitFib {
    public static void main(String[] args) {
    	LastDigitFib fdf = new LastDigitFib();
    	fdf.printLastDigitFib();
    }
    
    public int lastDigitFib(int num) {
        int[] fibs = new int[num+1];
        if(num == 0) {
            return 0;
        }
        fibs[0] = 0;
        fibs[1] = 1;
        for(int i = 2; i < fibs.length; i++) {
            fibs[i] = (fibs[i-1] + fibs[i-2]) % 10;
        }
        return fibs[num];
    }
    
    public void printLastDigitFib() {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        System.out.println(lastDigitFib(num));
    }
}