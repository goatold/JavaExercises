/**
 * Calculating distance of 2 points.
 */
package assignment1;

/**
 * @author Leo Wang
 *
 */
public class CartesianCoordinateSystem {

	/**
	 * test calculateDistance
	 */
	public static void main(String[] args) {
		System.out.printf("Given points: (%d, %d), (%d, %d)\n", -2, -3, -4, 4);
		System.out.printf("Distance: %.2f\n", CartesianCoordinateSystem.calculateDistance(-2, -3, -4, 4));
	}
	
	public static double calculateDistance(double x1, double y1, double x2, double y2){
		return Math.pow(Math.pow((x2-x1),2)+Math.pow((y2-y1), 2), 0.5);
	}

}
