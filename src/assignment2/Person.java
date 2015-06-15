package assignment2;

import java.util.ArrayList;

public class Person {

	private String name;
	private double height;
	private double weight;
	private double bmi;
	private String category;// not used at all

	public Person(String name, double weight, double height) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	public String getCategory() {
		return getCategory(bmi);
	}

	public double getBmi() {
		bmi = (weight * 703) / (height * height);
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public String getCategory(double bmi) {
		if (bmi < 18.5) {
			return "Underweight";
		} else if (bmi >= 18.5 && bmi < 25) {
			return "Normal weight";
		} else if (bmi >= 25 && bmi < 30) {
			return "Overweight";
		} else if (bmi >= 30) {
			return "Obese";
		} else {
			return "Unkown";
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public static void main(String[] args) {
		ArrayList<Person> pl = new ArrayList<Person>();
		pl.add(new Person("Andrew", 125.5, 55.1));
		pl.add(new Person("Boyd", 150.0, 67));
		pl.add(new Person("Cathy", 135, 72.3));
		pl.add(new Person("Donna", 190, 64));
		for (Person ap : pl) {
			System.out.printf("%s:\tH%.1f, W%.1f, BMI%.1f, Category %s\n",
					ap.getName(), ap.getHeight(), ap.getWeight(), ap.getBmi(),
					ap.getCategory());
		}
	}

}
