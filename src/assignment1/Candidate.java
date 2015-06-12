package assignment1;

import java.util.ArrayList;

public class Candidate extends AddressBook {

	private boolean innovation;
	private double grade;
	private double regulation;
	private String communication;

	public Candidate(String firstName, String lastName, boolean innovation,
			double grade, double regulation, String communication) {
		super(firstName, "", lastName);
		this.innovation = innovation;
		this.grade = grade;
		this.regulation = regulation;
		this.communication = communication;
	}

	public boolean isInnovation() {
		return innovation;
	}

	public void setInnovation(boolean innovation) {
		this.innovation = innovation;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public double getRegulation() {
		return regulation;
	}

	public void setRegulation(double regulation) {
		this.regulation = regulation;
	}

	public String getCommunication() {
		return communication;
	}

	public void setCommunication(String communication) {
		this.communication = communication;
	}

	public static ArrayList<Candidate> getElligibleCandidates(Candidate[] cands) {
		ArrayList<Candidate> eCands = new ArrayList<>();
		for (Candidate aCand : cands) {
			if ((aCand.getGrade() >= 85)
					|| (aCand.getRegulation() >= 0.5 && ((!aCand
							.getCommunication().equals("poor")) || aCand
							.isInnovation()))) {
				eCands.add(aCand);
			}
		}
		return eCands;
	}

	public String toString() {
		return String.format("\n%s %s: %b, %.2f, %.1f, %s", getFirstName(),
				getLastName(), isInnovation(), getGrade(), getRegulation(),
				getCommunication());
	}

	public static void main(String[] args) {
		Candidate[] cands = new Candidate[] {
				new Candidate("Elena", "Brandon", true, 82.30, 0.5, "poor"),
				new Candidate("Thomas", "Molson", false, 85.10, 1.0, "poor"),
				new Candidate("Hamilton", "Winn", false, 77.77, 0.8, "average"),
				new Candidate("Suzie", "Sarandin", false, 69.93, 0.0, "average"),
				new Candidate("Philip", "Winne", true, 93.03, 1.0, "average"),
				new Candidate("Alex", "Trebok", true, 88.61, 0.7, "poor"),
				new Candidate("Emma", "Pivoto", false, 55.99, 0.8, "excellent"),
				new Candidate("John", "Lenthen", true, 87.49, 0.9, "excellent"),
				new Candidate("James", "Lean", false, 88.00, 0.5, "excellent"),
				new Candidate("Jane", "Ostin", true, 91.20, 0.6, "average"),
				new Candidate("Emily", "Car", false, 66.79, 0.3, "excellent"),
				new Candidate("Daniel", "Hamshire", true, 76.65, 0.2, "average"),
				new Candidate("Neda", "Bazdar", true, 55.89, 0.5, "excellent"),
				new Candidate("Aaron", "Smith", false, 90.01, 0.3, "excellent"),
				new Candidate("Kate", "Hen", false, 87.9, 0.8, "poor") };
		ArrayList<Candidate> eCands = Candidate.getElligibleCandidates(cands);
		System.out.printf(eCands.toString());
	}

}
