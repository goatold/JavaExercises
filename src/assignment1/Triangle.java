package assignment1;

public class Triangle {

	private double a;
	private double b;
	private double c;
	private boolean rightTriangle;

	public Triangle(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		rightTriangle = this.isRightTriangle();
	}

	public Triangle(double a, double c) {
		super();
		this.a = a;
		this.c = c;
		this.b = 0;
	}

	public boolean isRightTriangle() {
		return a * a + b * b == c * c;
	}

	/**
	 * @return the a
	 */
	public double getA() {
		return a;
	}

	/**
	 * @return the b
	 */
	public double getB() {
		if (b == 0) {
			b = Math.sqrt(c * c - a * a);
		}
		return b;
	}

	/**
	 * @return the c
	 */
	public double getC() {
		return c;
	}

	public static void main(String[] args) {
		Triangle tri1 = new Triangle(48, 80);
		Triangle tri2 = new Triangle(84, 91);
		System.out.printf("a=%.0f, c=%.0f, b=%.0f\n", tri1.getA(), tri1.getC(),
				tri1.getB());
		System.out.printf("a=%.0f, c=%.0f, b=%.0f\n", tri2.getA(), tri2.getC(),
				tri2.getB());
		Triangle tri3 = new Triangle(45, 55, 75);
		Triangle tri4 = new Triangle(28, 45, 53);
		System.out.printf("a=%.0f, c=%.0f, b=%.0f, is RightTriangle: %b\n",
				tri3.getA(), tri3.getC(), tri3.getB(), tri3.isRightTriangle());
		System.out.printf("a=%.0f, c=%.0f, b=%.0f, is RightTriangle: %b\n",
				tri4.getA(), tri4.getC(), tri4.getB(), tri4.isRightTriangle());

	}

}
