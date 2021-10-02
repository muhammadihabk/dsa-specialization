package course1;

import java.util.Scanner;

public class MaximumPairwiseProduct {

	public static void main(String[] args) {
		MaximumPairwiseProduct mpp = new MaximumPairwiseProduct();
		mpp.printMaxPairProduct();
	}

	public long maximumPairwiseProduct(int[] nums) {
		Long max1 = null;
		Long max2 = null;
		for(int i = 0; i < nums.length; i++) {
			if(max1 == null || nums[i] > max1) {
				max2 = max1;
				max1 = (long) nums[i];
			} else if(max2 == null || nums[i] > max2) {
				max2 = (long) nums[i];
			}
		}
		return max1 * max2;
	}
	
	public void printMaxPairProduct() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter input:");
		int length = input.nextInt();
		int[] nums = new int[length];
		for(int i = 0; i < length; i++) {
			nums[i] = input.nextInt();
		}
		input.close();
		System.out.println("Answer: " + maximumPairwiseProduct(nums));
	}
}
