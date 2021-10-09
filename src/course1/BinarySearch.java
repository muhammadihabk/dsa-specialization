package course1;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		BinarySearch ls = new BinarySearch();
		ls.printBinarySearch();
	}

	
	// key: 17
	// 2 4 5 8 0 2 4 6 8
	// 1 2 3 4 5 6 7 8 9
	//                 m
	// l         l   l lh
	
	// key: 0
	// 2 4 5 8 0 2 4 6 8
	// 1 2 3 4 5 6 7 8 9
	//   m
	// lh
	public int binarySearch(int[] nums, int low, int high, int key) {
		int mid = (high - low) / 2 + low;
		if(high == low && nums[mid] > key) {
			return mid;
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
