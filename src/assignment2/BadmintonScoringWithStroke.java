package assignment2;

import java.util.ArrayList;
import java.util.Arrays;

public class BadmintonScoringWithStroke {

	private ArrayList<Point> scores;

	public BadmintonScoringWithStroke(ArrayList<Point> scores) {
		super();
		this.scores = scores;
	}

	public String getMostUsedStroke() {
		return "";
	}

	public static void main(String[] args) {
		Point[] sArray = new Point[] { new Point(1, 1, "a"),
				new Point(1, 2, "c") };
		ArrayList<Point> scores = new ArrayList<Point>(Arrays.asList(sArray));
		BadmintonScoringWithStroke aBs = new BadmintonScoringWithStroke(scores);

	}

}
