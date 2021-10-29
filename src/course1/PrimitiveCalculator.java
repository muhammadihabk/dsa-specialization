package course1;

import java.util.*;

public class PrimitiveCalculator {

	public static void main(String[] args) {
		PrimitiveCalculator pc = new PrimitiveCalculator();
		pc.printPrimitiveCalculator();
	}
	
	// prints minimum number of operations and prints all stops
    public void primitiveCalculator(int num) {
		int[] prevCalcs = new int[num+1];
		Arrays.fill(prevCalcs, num+1);
		prevCalcs[1] = 0;
		ArrayList<Integer> lastStops = new ArrayList<Integer>();
		lastStops.add(0);
		lastStops.add(0);
		for(int currNum = 2; currNum <= num; currNum++) {
			for(int i = 3; i >= 1; i--) {
				if(i == 1) {
					if(prevCalcs[currNum] > prevCalcs[currNum - 1] + 1) {
						lastStops.add(i);
                         prevCalcs[currNum] = prevCalcs[currNum - 1] + 1;
					}
				} else if(currNum % i == 0) {
					if(prevCalcs[currNum] > prevCalcs[currNum / i] + 1) {
						lastStops.add(i);
						prevCalcs[currNum] = prevCalcs[currNum / i] + 1;
					}
				}
			}
		}
		
		System.out.println(prevCalcs[num]);
		ArrayList<Integer> stops = getStops(num, lastStops);
        for(int stop : stops) {
            System.out.print(stop + " ");
        }
	}
    
	public ArrayList<Integer> getStops(int num, ArrayList<Integer> lastStops) {
		int currNum = num;
		ArrayList<Integer> stops = new ArrayList<Integer>();
		if(num == 1) {
			stops.add(0);
			return stops;
		}
		stops.add(currNum);
		while(currNum > 1) {
			if(lastStops.get(currNum) == 1) {
				currNum--;
			} else {
				currNum = currNum / lastStops.get(currNum);
			}
			stops.add(currNum);
		}
        Collections.reverse(stops);
        
        return stops;
	}

	// old naive and wrong way of getting stops
	public ArrayList<Integer> getStops(int num) {
		ArrayList<Integer> stops = new ArrayList<Integer>();
		stops.add(num);
		while(num > 1) {
			if(num % 3 == 0) {
				stops.add(num / 3);
				num /= 3;
			} else if(num % 2 == 0 && num != 10) {
				stops.add(num / 2);
				num /= 2;
			} else {
				stops.add(num - 1);
				num--;
			}
		}
		Collections.reverse(stops);
		return stops;
	}
	
	// old naive and wrong way of getting the minimum number of operations
    public void primitiveCalculatorNaiveWrong(int num) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int count = 0;
        while(num > 1) {
            count++;
            answer.add(num);
            if(num % 3 == 0) {
                num /= 3;
            } else if(num % 2 == 0 && num != 10) {
                num /= 2;
            } else {
                num--;
            }
        }
        answer.add(num);
        Collections.reverse(answer);
        System.out.println(count);
        for(int i : answer) {
            System.out.print(i + " ");
        }
    }
    
    public void printPrimitiveCalculator() {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        primitiveCalculator(num);
    }
}