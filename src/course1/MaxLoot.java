package course1;

import java.util.Scanner;

public class MaxLoot {

	public static void main(String[] args) {
		MaxLoot ml = new MaxLoot();
		ml.printOptimalValue();
	}
	
    private double optimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        int[] amountLeft = new int[weights.length];
        int i = 0;
        while(i < weights.length) {
        	if(capacity == 0) {
        		return value;
        	}
        	int j = maxUnitValue(values, weights);
        	int amountToPack = Math.min(capacity, weights[j]);
        	value += amountToPack * (double) values[j] / weights[j];
        	values[j] = 0;
        	weights[j] = 0;
        	capacity -= amountToPack;
        	i++;
        }
        return value;
    }
    
    private int maxUnitValue(int[] values, int[] weights) {
    	int index = 0;
    	double maxValue = 0;
    	for(int i = 0; i < weights.length; i++) {
    		double currValue = (double) values[i] / weights[i];
			if(currValue > maxValue) {
				maxValue = currValue;
				index = i;
			}
		}
    	return index;
    }

    public void printOptimalValue() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(optimalValue(capacity, values, weights));
    }
}