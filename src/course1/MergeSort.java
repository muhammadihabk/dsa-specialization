package course1;

import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		ms.printMergeSort();
	}
	
	public int[] mergeSort(int[] nums, int l, int h) {
		if(nums.length == 1) {
			return nums;
		}
		int m = nums.length / 2;
		int[] p1 = mergeSort(nums, l, m);
		int[] p2 = mergeSort(nums, m+1, nums.length);
		int[] answer = merge(p1, p2);
		return answer;
	}
	
	public int[] merge(int[] p1, int[] p2) {
		int[] answer = new int[p1.length + p2.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < p1.length && j < p2.length) {
			int a = p1[i];
			int b = p1[i];
			if(a <= b) {
				answer[k] = a;
				i++;
				k++;
			} else {
				answer[k] = b;
				j++;
				k++;
			}
		}
		while(i < p1.length) {
			answer[k] = p1[i];
			k++;
		}
		while(j < p2.length) {
			answer[k] = p2[j];
			k++;
		}
		return answer;
	}
	
	public void printMergeSort() {
		Scanner input = new Scanner(System.in);
		int length = input.nextInt();
		int[] nums = new int[length];
		for(int i = 0; i < nums.length; i++) {
			nums[i] = input.nextInt();
		
		}
		mergeSort(nums, 0, nums.length-1);
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
