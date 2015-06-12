package assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class HailstoneSequence {

	public static ArrayList<Integer> getHailStoneSequence(int n){
		 ArrayList<Integer> hsq = new ArrayList<Integer>();
		 hsq.add(new Integer(n));
		 while (n>1){
			 if (n%2 == 0){
				 n /= 2;
			 } else {
				 n = n*3 +1;
			 }
			 hsq.add(new Integer(n));
		 }
		 return hsq;
	}
	
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		System.out.println("Please input an initial number fo Hailstone Sequenc:");
		ArrayList<Integer> hsq = HailstoneSequence.getHailStoneSequence(inp.nextInt());
		System.out.printf("corresponding Hailstone Sequence:\n%s\ntook %d steps to reach 1", hsq.toString(), hsq.size()-1);
		inp.close();

	}

}
