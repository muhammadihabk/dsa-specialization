package sort;

import java.util.Scanner;

public class CountSort {

	public static void main(String[] args) {
		CountSort cs = new CountSort();
		cs.printSortedArray();
	}
	
    public void countingSort(int[] nums, int maxNum) {
        int[] counter = new int[maxNum+1];
        for(int i = 0; i < nums.length; i++) {
            counter[nums[i]]++;
        }
        int i = 0;
        int currCount = 1;
        while(currCount < counter.length && i < nums.length) {
            nums[i] = currCount;
            i++;
            counter[currCount]--;
            if(counter[currCount] == 0) {
                currCount++;
            }
        }
    }
    
    public void printSortedArray() {
    	Scanner input = new Scanner(System.in);
    	System.out.print("Largest number in your array: ");
    	int maxNum = input.nextInt();
    	System.out.print("Array length: ");
    	int length = input.nextInt();
    	int[] nums = new int[length];
    	System.out.print("Array: ");
    	for(int i = 0; i < nums.length; i++) {
			nums[i] = input.nextInt();
		}
    	countingSort(nums, maxNum);
    	
    	System.out.println("Answer: ");
    	for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
    }

}
