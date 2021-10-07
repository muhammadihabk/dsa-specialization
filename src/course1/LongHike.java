package course1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class LongHike {

	public static void main(String[] args) {
		LongHike lh = new LongHike();
		lh.printMaxValueKnapsack();
	}

	public int[] maxValueKnapsack(int[] itemsToPack) {
		int[] answer = new int[itemsToPack.length+1];
		int totalValue = 0;
		for(int i = 1; i < itemsToPack.length; i+=2) {
			if(itemsToPack[0] == 0) {
				return answer;
			}
			int itemsAmount = Math.min(itemsToPack[i], itemsToPack[0]);
			totalValue += itemsAmount * itemsToPack[i+1] / itemsToPack[i];
			answer[i] += itemsAmount;
			itemsToPack[0] -= itemsAmount;
		}
		answer[answer.length-1] = totalValue;
		return answer;
	}
	
	public void printMaxValueKnapsack() {
		Scanner input = new Scanner(System.in);
		System.out.print("Number of items: ");
		int size = input.nextInt();
		size = size*2+1;
		System.out.print("Size of knapsack, wi and vi separated by space (sorted by value per item): ");
		int[] itemsToPack = new int[size];
		for(int i = 0; i < size; i++) {
			itemsToPack[i] = input.nextInt();
		}

		int[] answer = maxValueKnapsack(itemsToPack);
		for(int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}

	
}
