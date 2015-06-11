/**
 * Calculating Bonus according to given savings
 */
package assignment1;

import java.util.Arrays;

/**
 * @author Leo Wang
 * 
 */
public class BonusOnSavings {

	/**
	 * test calculation
	 * 
	 */
	public static void main(String[] args) {
		BonusOnSavings.computeBonus(2000,
				new double[] { 5000, 7000, 4000, 8000 });
		BonusOnSavings.computeBonus(3000, new double[] { 6000, 9000, 10000,
				17000 });
	}

	/**
	 * Calculate total bonus Bonus would be given if: savings of the quarter >=
	 * monthly commitment * 3; savings of the year >= monthly commitment * 12;
	 * 
	 * Bonus ratio to savings: quarterly 0.03, annualy 0.05
	 * 
	 * extra bonus: annual savings - (monthly commitment * 12 * 1.25), if it
	 * positive
	 * 
	 * @param cmmt
	 *            committed monthly savings
	 * @param qs
	 *            array of quarterly savings
	 * 
	 */
	public static double computeBonus(double cmmt, double[] qs) {
		if (qs.length < 4) {
			System.out
					.println("savings of 4 quarters are required to calculate bonus.");
			return 0;
		}
		double bonus = 0;
		double anSavings = 0;
		double[] qb = new double[] { 0, 0, 0, 0 };
		for (int i = 0; i < 4; i++) {
			if (qs[i] >= cmmt * 3) {
				qb[i] = qs[i] * 0.03;
				bonus += qb[i];
			}
			anSavings += qs[i];
		}
		if (anSavings >= cmmt * 12) {
			bonus += anSavings * 0.05;
		}
		bonus += (anSavings > cmmt * 12 * 1.25) ? (anSavings - cmmt * 12 * 1.25)
				: (0);
		System.out.printf(
				"Given monthly commitment %.2f, quarterly savings: %s\n", cmmt,
				Arrays.toString(qs));
		System.out.printf("Bonus will be %.2f\n", bonus);
		return bonus;
	}
}
