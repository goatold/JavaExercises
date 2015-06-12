package assignment1;

import java.util.Arrays;

public class EmployeeSavings extends AddressBook {

	private double accountValue;
	private double[] monthlyInterests;
	private double[] monthlySavings;
	public static final double ANNUAL_INTEREST_RATE = 0.05;
	public static final double MONTHLY_INTEREST_RATE = ANNUAL_INTEREST_RATE / 12;
	public static final int ROUND_PREC = 3;

	public EmployeeSavings(String firstName, String lastName) {
		super(firstName, "", lastName);
	}

	public EmployeeSavings(String firstName, String lastName, double[] savings) {
		super(firstName, "", lastName);
		this.monthlySavings = savings;
		this.monthlyInterests = new double[savings.length];
	}

	/**
	 * @return the monthlyInterests
	 */
	public double[] getMonthlyInterests() {
		return monthlyInterests;
	}

	public double[] calculateInterests() {
		accountValue = 0;
		for (int i = 0; i < monthlyInterests.length; i++) {
			accountValue += monthlySavings[i];
			monthlyInterests[i] = round(accountValue * MONTHLY_INTEREST_RATE, ROUND_PREC);
			accountValue += monthlyInterests[i];
		}
		accountValue = round(accountValue, ROUND_PREC);
		return monthlyInterests;
	}

	/**
	 * @return the monthlySavings
	 */
	public double[] getMonthlySavings() {
		return monthlySavings;
	}

	public double[] generateMonthlySavings() {
		for (int i = 0; i < monthlySavings.length; i++) {
			monthlySavings[i] = round(Math.random() * 700 + 100, ROUND_PREC);
		}
		return monthlySavings;
	}

	/**
	 * @return the accountValue
	 */
	public double getAccountValue() {
		return accountValue;
	}

	public static String getReport(EmployeeSavings[] arr) {
		String report = "";
		for (EmployeeSavings aEps : arr) {
			aEps.calculateInterests();
			report += aEps.getFirstName() + " " + aEps.getLastName()
					+ ": \nsaved: " + Arrays.toString(aEps.getMonthlySavings())
					+ "\nInerests: "
					+ Arrays.toString(aEps.getMonthlyInterests())
					+ "\nFinal account value:" + aEps.getAccountValue() + "\n";
		}
		return report;
	}

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}

	public static void main(String[] args) {
		EmployeeSavings[] epSavings = new EmployeeSavings[] {
				new EmployeeSavings("Elena", "Brandon", new double[12]),
				new EmployeeSavings("Thomas", "Molson", new double[12]),
				new EmployeeSavings("Hamilton", "Winn", new double[12]),
				new EmployeeSavings("Suzie", "Sarandin", new double[12]),
				new EmployeeSavings("Philip", "Winne", new double[12]),
				new EmployeeSavings("Alex", "Trebok", new double[12]),
				new EmployeeSavings("Emma", "Pivoto", new double[12]),
				new EmployeeSavings("John", "Lenthen", new double[12]),
				new EmployeeSavings("James", "Lean", new double[12]),
				new EmployeeSavings("Jane", "Ostin", new double[12]),
				new EmployeeSavings("Emily", "Car", new double[12]),
				new EmployeeSavings("Daniel", "Hamshire", new double[12]),
				new EmployeeSavings("Neda", "Bazdar", new double[12]),
				new EmployeeSavings("Aaron", "Smith", new double[12]),
				new EmployeeSavings("Kate", "Hen", new double[12]) };
		for (EmployeeSavings aEps : epSavings) {
			aEps.generateMonthlySavings();
		}
		System.out.println(EmployeeSavings.getReport(epSavings));

		EmployeeSavings eps1 = new EmployeeSavings("test", "tt", new double[]{100,100,100});
		System.out.println(EmployeeSavings.getReport(new EmployeeSavings[] {eps1}));
	}

}
