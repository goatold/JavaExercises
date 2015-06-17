package assignment2;

public class Point {
	private int player;
	private int score;
	private String stroke;

	public int getPlayer() {
		return player;
	}

	public int getScore() {
		return score;
	}

	public String getStroke() {
		return stroke;
	}

	public Point(int player, int score, String stroke) {
		super();
		this.player = player;
		this.score = score;
		this.stroke = stroke;
	}
}
