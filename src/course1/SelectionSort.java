package course1;

import java.util.Scanner;

public class SelectionSort {

	public static void main(String[] args) {
		SelectionSort ss = new SelectionSort();
		ss.printSelectionSort();
	}
	
	public void selectionSort(int[] nums, int l) {
		if(l > nums.length-1) {
			return;
		}
		int min = min(nums, l);
		int temp = nums[l];
		nums[l] = nums[min];
		nums[min] = temp;
		selectionSort(nums, l+1);
	}
	
	public int min(int[] nums, int l) {
		int min = l;
		for(int i = l+1; i < nums.length; i++) {
			if(nums[i] < nums[min]) {
				min = i;
			}
		}
		return min;
	}
	
	public void printSelectionSort() {
		Scanner input = new Scanner(System.in);
		int length = input.nextInt();
		int[] nums = new int[length];
		for(int i = 0; i < nums.length; i++) {
			nums[i] = input.nextInt();
		
		}
		selectionSort(nums, 0);
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
