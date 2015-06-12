package assignment1;

import java.util.Scanner;

public class TaxReturn {

	/**
	 * Constructs a TaxReturn object for a given income and marital status, and
	 * computes the tax.
	 * 
	 * @param anIncome
	 *            the taxpayer income
	 * @param aStatus
	 *            either SINGLE or MARRIED
	 */
	public TaxReturn(double anIncome, int aStatus, int children) {
		income = anIncome;
		status = aStatus;
		this.children = children;
	}

	public double getTax() {
		double tax = 0;
		if (status == SINGLE || status == SINGLE_PARENT) {
			if (income <= SINGLE_BRACKET1)
				tax = RATE1 * income;
			else if (income <= SINGLE_BRACKET2)
				tax = RATE1 * SINGLE_BRACKET1 + RATE2
						* (income - SINGLE_BRACKET1);
			else {
				tax = RATE1 * SINGLE_BRACKET1 + RATE2
						* (SINGLE_BRACKET2 - SINGLE_BRACKET1) + RATE3
						* (income - SINGLE_BRACKET2);
				if (income > SINGLE_BRACKET3) {
					tax += (income - SINGLE_BRACKET4) * RATE4;
				}
			}

			tax -= CHILDREN_REDUCTION * children;
		} else if (status == MARRIED) {
			if (income <= MARRIED_BRACKET1)
				tax = RATE1 * income;
			else if (income <= MARRIED_BRACKET2)
				tax = RATE1 * MARRIED_BRACKET1 + RATE2
						* (income - MARRIED_BRACKET1);
			else {
				tax = RATE1 * MARRIED_BRACKET1 + RATE2
						* (MARRIED_BRACKET2 - MARRIED_BRACKET1) + RATE3
						* (income - MARRIED_BRACKET2);
				if (income > MARRIED_BRACKET3) {
					tax += (income - MARRIED_BRACKET4) * RATE5;
				}
			}
		} else {
			tax = income * TaxReturn.RATE6;
		}
		return tax;
	}

	public static final int SINGLE = 1;
	public static final int MARRIED = 2;
	public static final int SINGLE_PARENT = 3;
	public static final int UNKNOWN = 4;
	private static final double RATE1 = 0.15;
	private static final double RATE2 = 0.28;
	private static final double RATE3 = 0.31;
	private static final double RATE4 = 0.25;
	private static final double RATE5 = 0.35;
	private static final double RATE6 = 0.33;
	private static final double SINGLE_BRACKET1 = 21450;
	private static final double SINGLE_BRACKET2 = 51900;
	private static final double SINGLE_BRACKET3 = 249999;
	private static final double SINGLE_BRACKET4 = 150000;
	private static final double MARRIED_BRACKET1 = 35800;
	private static final double MARRIED_BRACKET2 = 86500;
	private static final double MARRIED_BRACKET3 = 349999;
	private static final double MARRIED_BRACKET4 = 200000;
	private static final double CHILDREN_REDUCTION = 5000;
	private double income;
	private int status;
	private int children;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter your income: ");
		double income = in.nextDouble();
		System.out
				.print("Enter S (single) or M (married) or SP (Single Parent): ");
		String input = in.next();
		int status = 0;
		int children = 0;
		if (input.equalsIgnoreCase("S"))
			status = TaxReturn.SINGLE;
		else if (input.equalsIgnoreCase("M"))
			status = TaxReturn.MARRIED;
		else if (input.equalsIgnoreCase("SP")) {
			status = TaxReturn.SINGLE_PARENT;
			System.out.print("Please enter # of children: ");
			children = in.nextInt();
		} else {
			status = TaxReturn.UNKNOWN;
		}
		TaxReturn aTaxReturn = new TaxReturn(income, status, children);
		System.out.println("The tax is " + aTaxReturn.getTax());
		in.close();
	}
}
