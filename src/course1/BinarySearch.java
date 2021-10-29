package course1;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		BinarySearch ls = new BinarySearch();
		ls.printBinarySearch();
	}
	
	// 2 4 4 4 7 7 9
	// 1 2 3 4 5 6 7
	//       m
	// l
	//             h
	// returns an index of the key
	// if it's not found, returns the index where it should be put
	public int binarySearch(int[] nums, int low, int high, int key) {
		if(high < low) {
//			return low - 1;
            return -1;
		}
		int mid = (high - low) / 2 + low;
		if(mid > 0 && nums[mid-1] == key) {
			return binarySearch(nums, low, mid-1,key);
		}
		if(nums[mid] > key) {
			return binarySearch(nums, low, mid-1, key);
		} else if(nums[mid] < key) {
			return binarySearch(nums, mid+1, high, key);
		} else {
			return mid;
		}
	}

	public void printBinarySearch() {
		Scanner input = new Scanner(System.in);
//		System.out.print("Key: ");
		int n = input.nextInt();
//		System.out.print("Number of elements: ");
		int[] nums = new int[n];
		for(int i = 0; i < nums.length; i++) {
			nums[i] = input.nextInt();
		}
		int k = input.nextInt();
		int[] keys = new int[k];
		for(int i = 0; i < keys.length; i++) {
			keys[i] = input.nextInt();
		}
		for(int i = 0; i < keys.length; i++) {
			System.out.print(binarySearch(nums, 0, nums.length-1, keys[i]) + " ");
		}
	}
}
