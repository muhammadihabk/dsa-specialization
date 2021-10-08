package course1;

import java.util.Scanner;

public class MoneyChange {

	public static void main(String[] args) {
		MoneyChange mc = new MoneyChange();
		mc.printMinCoins();
	}

	public int minCoins(int m) {
		int count = 0;
		while(m > 0) {
			if(m >= 10) {
				m -= 10;
				count++;
			} else if(m >= 5) {
				m -= 5;
				count++;
			} else if(m > 0) {
				m -= 1;
				count++;
			}
		}
		return count;
	}
	
	public void printMinCoins() {
		Scanner input = new Scanner(System.in);
		System.out.print("Money: ");
		int money = input.nextInt();
		System.out.print("coins: " + minCoins(money));
		System.out.print(minCoins(money));
	}
}
