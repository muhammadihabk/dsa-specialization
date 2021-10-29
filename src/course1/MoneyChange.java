package course1;

import java.util.Arrays;
import java.util.Scanner;

public class MoneyChange {

	public static void main(String[] args) {
		MoneyChange mc = new MoneyChange();
		mc.printMoneyChange();
	}
	
	
	// dynamic programming approach
	public int moneyChangeDP(int money, int[] denominations) {
		int[] numCoins = new int[money+1];
		Arrays.fill(numCoins, money+1);
		numCoins[0] = 0;
		for(int currMoney = 1; currMoney <= money; currMoney++) {
			for(int i = 0; i < denominations.length; i++) {
				if(currMoney >= denominations[i]) {
					numCoins[currMoney] = Math.min(numCoins[currMoney], numCoins[currMoney - denominations[i]] + 1);
				}
			}
		}
		return numCoins[money];
	}
	
	// slow recursive
	public int moneyChangeRecursion(int money, int[] denominations) {
		Integer minCoins = null;
		if(money == 0) {
			return 0;
		}
		for(int i = 0; i < denominations.length; i++) {
			if(money >= denominations[i]) {
				int change = moneyChangeRecursion(money-denominations[i], denominations);
				if(minCoins == null || (change + 1) < minCoins) {
					minCoins = change + 1;
				}
			}
		}
		return minCoins;
	}
	
	// greedy approach 2
	public int moneyChangeGreedy2(int money, int[] denominations) {
		int[] minNumCoins = new int[money+1];
		for(int currMoney = 0; currMoney <= money; currMoney++) {
			minNumCoins[currMoney] = 0;
			for(int j = 0; j < denominations.length; j++) {
				if(currMoney >= denominations[j]) {
					int numCoins = minNumCoins[currMoney-denominations[j]] + 1;
					if(numCoins < minNumCoins[currMoney]) {
						minNumCoins[currMoney] = numCoins;
					}
				}
			}
		}
		return minNumCoins[money];
	}

	// greedy approach 1
	public int moneyChangeGreedy(int m) {
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
	
	public void printMoneyChange() {
		Scanner input = new Scanner(System.in);
		int money = input.nextInt();
		int[] denominations = {4, 3, 1};
		System.out.print(moneyChangeDP(money, denominations));
	}
}
