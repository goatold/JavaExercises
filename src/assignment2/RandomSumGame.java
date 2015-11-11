package assignment2;

import java.util.Scanner;

public class RandomSumGame {

	private int d1;
	private int d2;
	private int sum;
	private int valuePoint;

	public void rollDice() {
		d1 = (int) (Math.round(Math.random() * 5) + 1);
		d2 = (int) (Math.round(Math.random() * 5) + 1);
		sum = d1 + d2;
		System.out.printf("Dice rolled: %d %d Sum: %d\n", d1, d2, sum);
	}

	public boolean play() {
		rollDice();
		switch (sum) {
		case 2:
		case 3:
		case 12:
			System.out.println("You lose!\n");
			return false;
		case 7:
		case 11:
			System.out.println("You Win!\n");
			return true;

		default:
			System.out.printf("Got ValuePoint: %d \n", sum);
			valuePoint = sum;
			do {
				rollDice();
				if (sum == valuePoint) {
					System.out.println("You Win!\n");
					return true;
				} else if (sum == 7) {
					System.out.println("You lose!\n");
					return false;
				}
			} while (true);
		}
	}

	public static void main(String[] args) {
		RandomSumGame agame = new RandomSumGame();
		int lose = 0;
		int win = 0;
		Scanner inp = new Scanner(System.in);
		System.out.println("How many rounds to play?");
		int rnd = inp.nextInt();
		for (int i = 0; i < rnd; i++) {
			if (agame.play())
				win++;
			else
				lose++;
		}
		System.out.printf("You lost %d times and won %d times", lose, win);
		inp.close();
	}
}
