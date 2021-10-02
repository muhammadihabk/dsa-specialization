package course1;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
        f.printFib();
    }
    
    public long fib(int num) {
        long[] fibs = new long[num+1];
        if(num == 0) {
            return 0;
        }
        fibs[0] = 0;
        fibs[1] = 1;
        for(int i = 2; i < fibs.length; i++) {
            fibs[i] = fibs[i-1] + fibs[i-2];
        }
        return fibs[num];
    }
    
    public void printFib() {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        System.out.println(fib(num));
    }
}