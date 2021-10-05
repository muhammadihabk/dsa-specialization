package course1;

import java.util.ArrayList;
import java.util.Scanner;

public class ChildrensParty {

	public static void main(String[] args) {
		ChildrensParty cp = new ChildrensParty();
		cp.printGroups();
	}
	
	/*
	 * course algorithm
	*/
	public ArrayList<Double> minGroups2(double[] ages) {
		ArrayList<Double> groups = new ArrayList<Double>();
		int i = 0;
		double l;
		double r;
		while(i < ages.length) {
			l =  ages[i];
			r = ages[i] + 1;
			groups.add(l);
			i++;
			while(i < ages.length && ages[i] <= r) {
				i++;
			}
		}
		return groups;
	}
	
	/*
	 * my algorithm
	*/
	public ArrayList<Double> minGroups1(double[] ages) {
		ArrayList<Double> groups = new ArrayList<Double>();
		double lastAge = ages[0];
		groups.add(0.0);
		for(int i = 0; i < ages.length; i++) {
			if(ages[i] - lastAge > 1) {
				groups.add((double) i);
				lastAge = ages[i];
			}
		}
		return groups;
	}
	
	public void printGroups() {
		Scanner input = new Scanner(System.in);
		System.out.print("Number of childrens: ");
		int size = input.nextInt();
		double[] ages = new double[size];
		System.out.print("Children's ages: ");
		for(int i = 0; i < size; i++) {
			ages[i] = input.nextDouble();
		}

		// my algorithm
		ArrayList<Double> groups = minGroups1(ages);
		System.out.println("Group's starts: " + groups);
		// course algorithm
		ArrayList<Double> groups2 = minGroups2(ages);
		System.out.println("Group's starts: " + groups2);
	}
}
