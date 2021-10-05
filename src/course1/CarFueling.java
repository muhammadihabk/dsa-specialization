package course1;

import java.util.ArrayList;
import java.util.Scanner;

public class CarFueling {

	public static void main(String[] args) {
		CarFueling cf = new CarFueling();
		cf.printPath();
	}
	public ArrayList<Integer> minRefills(int[] points, int tank) {
		ArrayList<Integer> path = new ArrayList<Integer>();
		int lastRefill = 0;
		int i = 0;
		while(i < points.length) {
		    if(points[i]-lastRefill > tank) {
			lastRefill = points[i-1];
			path.add(i-1);
		    } else {
			i++;
		    }
		}
		return path;
	}
    
	public void printPath() {
		Scanner input = new Scanner(System.in);
		System.out.print("Number of gas stations: ");
		int size = input.nextInt();
		int[] nums = new int[size];
		System.out.print("Distances: ");
		for(int i = 0; i < size; i++) {
		    nums[i] = input.nextInt();
		}

		ArrayList<Integer> path = minRefills(nums, 400);
		System.out.println("Refills at: " + path);
	}
}
