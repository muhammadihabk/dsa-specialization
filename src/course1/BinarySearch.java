package course1;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		BinarySearch ls = new BinarySearch();
		ls.printBinarySearch();
	}
	
	// returns an index of the key
	// if it's not found, returns the index where it should be put
	public int binarySearch(int[] nums, int low, int high, int key) {
		int mid = (high - low) / 2 + low;
        if(high < low) {
            return low - 1;
        }
		if(nums[mid] == key) {
			return mid;
		} else if(nums[mid] > key) {
			return binarySearch(nums, low, mid-1, key);
		} else {
			return binarySearch(nums, mid+1, high, key);
		}
	}

	public void printBinarySearch() {
		Scanner input = new Scanner(System.in);
		System.out.print("Key: ");
		int key = input.nextInt();
		System.out.print("Number of elements: ");
		int length = input.nextInt();
		int[] nums = new int[length];
		for(int i = 0; i < nums.length; i++) {
			nums[i] = input.nextInt();
		}
		System.out.println(binarySearch(nums, 0, nums.length-1, key));
	}
}
