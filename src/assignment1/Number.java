package assignment1;

import java.util.ArrayList;

public class Number {

	public static ArrayList<String> iterate(int n) {
		ArrayList<String> al = new ArrayList<String>();
		String str;
		for (int i = 0; i <= n; i++) {
			str = String.format("\n%d", i);

			if (Number.isOdd(i))
				str += ", is odd";
			if (Number.isDivisibleBy5(i))
				str += ", hi five";
			if (Number.isDivisibleBy7(2 * i + 1))
				str += ", wow";
			if (Number.isPrime(i))
				str += ", prime";
			al.add(str);
		}
		return al;
	}

	public static boolean isDivisibleBy5(int n) {
		return n % 5 == 0;
	}

	public static boolean isDivisibleBy7(int n) {
		return n % 7 == 0;
	}

	public static boolean isOdd(int n) {
		return n % 2 != 0;
	}

	public static boolean isPrime(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i < Math.sqrt(n) + 1 && i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(Number.iterate(103).toString());
	}

}
