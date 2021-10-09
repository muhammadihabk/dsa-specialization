package course1;

import java.util.Scanner;

public class LinearSearch {

	public static void main(String[] args) {
		LinearSearch ls = new LinearSearch();
		ls.printLinearSearch();
	}

	public int linearSearch(int[] nums, int low, int high, int key) {
		if(high < low) {
			return -1;
		}
		if(nums[low] == key) {
			return low;
		}
		return linearSearch(nums, low + 1, high, key);
	}
	
	public void printLinearSearch() {
		Scanner input = new Scanner(System.in);
		System.out.print("Key: ");
		int key = input.nextInt();
		System.out.print("Number of elements: ");
        int length = input.nextInt();
        int[] nums = new int[length];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = input.nextInt();
        }
        System.out.println(linearSearch(nums, 0, nums.length-1, key));
    }
}
