/**
 * Extends AddressBook to add more info
 */
package assignment1;

/**
 * @author Leo Wang
 * 
 */
public class BanffMarathonRunner extends AddressBook {

	private int time;
	private int years;

	public BanffMarathonRunner(String firstName, String lastName, int time,
			int years) {
		super(firstName, "", lastName);
		this.time = time;
		this.years = years;
	}

	public static BanffMarathonRunner getFastestRunner(
			BanffMarathonRunner[] runners) {
		BanffMarathonRunner fastesRunner = runners[0];
		for (int i = 1; i < runners.length; i++) {
			if (runners[i].getTime() < fastesRunner.getTime())
				fastesRunner = runners[i];
		}
		return fastesRunner;
	}

	public static BanffMarathonRunner getSecondFastestRunner(
			BanffMarathonRunner[] runners) {
		BanffMarathonRunner fastesRunner = runners[0];
		BanffMarathonRunner fastesRunner2 = fastesRunner;
		for (int i = 1; i < runners.length; i++) {
			if (runners[i].getTime() < fastesRunner.getTime()) {
				fastesRunner2 = fastesRunner;
				fastesRunner = runners[i];
			} else if (runners[i].getTime() >= fastesRunner.getTime()
					&& runners[i].getTime() < fastesRunner2.getTime()) {
				fastesRunner2 = runners[i];
			} else if (fastesRunner == fastesRunner2) {
				// if we reach here, it implies that runners[i].getTime() >=
				// fastesRunner2.getTime()
				fastesRunner2 = runners[i];
			}
		}
		return fastesRunner2;
	}

	public static String getAboveAverageRunners(BanffMarathonRunner[] runners) {
		String runnerLstStr = "";
		double avgTime = BanffMarathonRunner.getAverageTime(runners);
		for (BanffMarathonRunner aRunner : runners) {
			if (aRunner.getTime() <= avgTime)
				runnerLstStr += aRunner.getFirstName() + " "
						+ aRunner.getLastName() + " " + aRunner.getYears()
						+ "\n";
		}
		return runnerLstStr;
	}

	public static double getAverageTime(BanffMarathonRunner[] runners) {
		if (runners == null || runners.length == 0)
			return 0;
		double totalTime = 0;
		for (BanffMarathonRunner aRunner : runners) {
			totalTime += aRunner.getTime();
		}
		return totalTime / runners.length;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BanffMarathonRunner[] runners = new BanffMarathonRunner[] {
				new BanffMarathonRunner("Elena", "Brandon", 341, 1),
				new BanffMarathonRunner("Thomas", "Molson", 273, 2),
				new BanffMarathonRunner("Hamilton", "Winn", 278, 5),
				new BanffMarathonRunner("Suzie", "Sarandin", 329, 7),
				new BanffMarathonRunner("Philip", "Winne", 445, 9),
				new BanffMarathonRunner("Alex", "Trebok", 275, 3),
				new BanffMarathonRunner("Emma", "Pivoto", 275, 4),
				new BanffMarathonRunner("John", "Lenthen", 243, 1),
				new BanffMarathonRunner("James", "Lean", 334, 1),
				new BanffMarathonRunner("Jane", "Ostin", 412, 1),
				new BanffMarathonRunner("Emily", "Car", 393, 4),
				new BanffMarathonRunner("Daniel", "Hamshire", 299, 4),
				new BanffMarathonRunner("Neda", "Bazdar", 343, 3),
				new BanffMarathonRunner("Aaron", "Smith", 317, 6),
				new BanffMarathonRunner("Kate", "Hen", 265, 8) };
		for (BanffMarathonRunner aRunner : runners) {
			aRunner.setHomeAddress(aRunner.getFirstName() + "'s Home");
		}
		BanffMarathonRunner fastestR = BanffMarathonRunner
				.getFastestRunner(runners);
		System.out.printf("%s %s\n%s\n%d\n", fastestR.getFirstName(),
				fastestR.getLastName(), fastestR.getHomeAddress(),
				fastestR.getTime());
		BanffMarathonRunner fastestR2 = BanffMarathonRunner
				.getSecondFastestRunner(runners);
		System.out.printf("%s %s\n%s\n%d %d\n", fastestR2.getFirstName(),
				fastestR2.getLastName(), fastestR2.getHomeAddress(),
				fastestR2.getTime(), fastestR2.getTime() - fastestR.getTime());
		System.out.printf("Runners above average %.2f:\n%s",
				BanffMarathonRunner.getAverageTime(runners), BanffMarathonRunner.getAboveAverageRunners(runners));
	}

}
