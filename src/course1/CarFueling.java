package course1;

import java.util.Scanner;

public class CarFueling {

	public static void main(String[] args) {
		CarFueling cf2 = new CarFueling();
		cf2.printMinRefills();

	}
	
	// return -1 if city is unreachable
	public int minRefills(int tankCapacity, int[] stops) {
		int lastRefill;
		int numRefills = 0;
		int i = 0;
		while(i < stops.length-1) {
			lastRefill = i;
			while(i < stops.length-1 && stops[i+1] - stops[lastRefill] <= tankCapacity) {
				i++;
			}
			if(i == lastRefill) {
				return -1;
			}
			if(i < stops.length-1) {
				numRefills++;
			}
		}
		return numRefills;
	}

	public void printMinRefills() {
		Scanner input = new Scanner(System.in);
		int cityLoc = input.nextInt();
		int tankCapacity = input.nextInt();
		int numStops = input.nextInt();
		int[] stops = new int[numStops+2];
		for(int i = 1; i < stops.length-1; i++) {
			stops[i] = input.nextInt();
		}
		stops[stops.length-1] = cityLoc;
		
		System.out.println(minRefills(tankCapacity, stops));
	}
}
