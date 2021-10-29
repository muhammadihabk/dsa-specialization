package course1;

import java.util.Random;
import java.util.Scanner;

public class QuickSort {

	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
//		qs.printQuickSort();
		
		// delete this
		Random random = new Random();
		while(true) {
			int length = random.nextInt(10) + 1;
			int[] arr1 = new int[length];
			int[] arr2 = new int[length];
			for(int i = 0; i < arr1.length; i++) {
				arr1[i] = random.nextInt(10) + 1;
				arr2[i] = arr1[i];
			}
			qs.selectionSort(arr1, 0);
			qs.quickSort(arr2, 0, length-1);
			for(int i = 0; i < arr1.length; i++) {
				if(arr1[i] != arr2[i]) {
					for(int j = 0; i < arr1.length; j++) {
						System.out.print(arr1[j] + " ");
					}
					for(int j = 0; i < arr1.length; j++) {
						System.out.print("\n" + arr2[j] + " ");
					}
					break;
				}
			}
		}
	}
	
	public void quickSort(int[] nums, int l, int r) {
		if(l >= r) {
			return;
		}
		/*Random random = new Random();
		int k = random.nextInt(r - l + 1) + l;
		int temp = nums[l];
		nums[l] = nums[k];
		nums[k] = temp;*/
		int[] m = partition3(nums, l, r);
		quickSort(nums, l, m[0]-1);
		quickSort(nums, m[1]+1, r);
	}

	public int[] partition3(int[] nums, int l, int r) {
		int x = nums[l];
		int i = l;
		int j = l + 1;
		int m1 = l;
		while(j <= r && i < r) {
			if(nums[j] > x) {
				j++;
			} else if(nums[j] < x) {
				i++;
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				j++;
			} else {
				m1++;
				int temp = nums[m1];
				nums[m1] = nums[j];
				nums[j] = temp;
				if(i < m1) {
					i = m1;
				}
				if(nums[j] < x) {
					i++;
					temp = nums[j];
					nums[j] = nums[i];
					nums[i] = temp;
				}
			}
		}
		int[] answer = new int[2];
		if(m1 == i) {
			answer[0] = answer[1] = i;
			return answer;
		}
		int m2 = i;
		while(m1 >= l) {
			int temp = nums[m1];
			nums[m1] = nums[i];
			nums[i] = temp;
			m1--;
			i--;
		}
		answer[0] = i+1;
		answer[1] = m2;
		return answer;
	}
	// delete this
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
	
	public void printQuickSort() {
		Scanner input = new Scanner(System.in);
		int length = input.nextInt();
		int[] nums = new int[length];
		for(int i = 0; i < nums.length; i++) {
			nums[i] = input.nextInt();
		
		}
		quickSort(nums, 0, nums.length-1);
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
