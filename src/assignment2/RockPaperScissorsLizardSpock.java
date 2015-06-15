package assignment2;

import java.util.Scanner;

public class RockPaperScissorsLizardSpock {

	public static final int ROCK = 1;
	public static final int PAPER = 2;
	public static final int SCISSORS = 3;
	public static final int LIZARD = 4;
	public static final int SPOCK = 5;

	public static final int PLAYER1 = 1;
	public static final int PLAYER2 = 2;

	public static final String[] PLAYERS = new String[] { "Rock", "Paper",
			"Scissors", "Lizard", "Spock" };

	private int consecutiveWins;
	private int lastWiner;

	public int random() {
		return (int) (Math.round(Math.random() * 4) + 1);
	}

	public int getConsecutiveWins() {
		return consecutiveWins;
	}

	public int getLastWiner() {
		return lastWiner;
	}

	public void play(int p1, int p2) {
		if (p1 < 1 || p1 > 5 || p2 < 1 || p2 > 5) {
			System.out.printf("invalid input:%d %d\n", p1, p2);
			return;
		}
		System.out.printf("Player1: %s, Player2: %s\n", PLAYERS[p1 - 1],
				PLAYERS[p2 - 1]);
		if (p1 == p2) {
			System.out.println("Tie!\n");
			// we do not reset lastWiner or consecutiveWins on Tie
		} else if ((p1 == ROCK && (p2 == SCISSORS || p2 == LIZARD))
				|| (p1 == PAPER && (p2 == ROCK || p2 == SPOCK))
				|| (p1 == SCISSORS && (p2 == PAPER || p2 == LIZARD))
				|| (p1 == LIZARD && (p2 == PAPER || p2 == SPOCK))
				|| (p1 == SPOCK && (p2 == ROCK || p2 == SCISSORS))) {
			System.out.println("Player1 Win!\n");
			if (lastWiner == PLAYER1)
				consecutiveWins++;
			else
				consecutiveWins = 1;
			lastWiner = PLAYER1;
		} else {
			System.out.println("Player2 Win!\n");
			if (lastWiner == PLAYER2)
				consecutiveWins++;
			else
				consecutiveWins = 1;
			lastWiner = PLAYER2;
		}
	}

	public static void main(String[] args) {
		RockPaperScissorsLizardSpock agame = new RockPaperScissorsLizardSpock();
		Scanner inp = new Scanner(System.in);
		System.out.println("How many consecutive wins needed?");
		int cw = inp.nextInt();
		while (agame.getConsecutiveWins() < cw) {
			agame.play(agame.random(), agame.random());
		}
		System.out.printf("Game Over! LastWiner: Player %d\n",
				agame.getLastWiner());
	}

}
