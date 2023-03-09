package studio6;

import java.util.Arrays;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {
		
			// FIXME compute the geometric sum for the first n terms recursively
		if (n == 0) {
			return 0;
		}
		else {
			return Math.pow(0.5, n) + geometricSum(n - 1);
		}
	}

	/**
	 * This method uses recursion to compute the greatest common divisor
	 * for the two input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	
	public static int gcd(int p, int q) {
		
			// FIXME compute the gcd of p and q using recursion
		if (q == 0) {
			return 0;
		}
		else {
			if (p % q == 0) {
				return q;
			}
			else {
				return gcd(q, p % q);
			}
		}
	}

	

	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	public static int[] toReversed(int[] array) {
		
			// FIXME create a helper method that can recursively reverse the given array
		if (array.length == 0) {
			return new int[0];
		}
		else if (array.length == 1) {
			int[] newArray = new int[1];
			newArray[0] = array[0];
			return newArray;
		}
		else {
			int[] reversed = new int[array.length];
			int lastIndex = array.length - 1;
			int index = 0;
			int mirrorIndex = lastIndex - index;
			return toReversedHelp(array, reversed, index, mirrorIndex);
		}
	}
	
	public static int[] toReversedHelp(int[] array, int[] reversed, int index, int mirrorIndex) {
		if (index == array.length / 2) {
			if (array.length % 2 == 0) {
				return reversed;
			}
			reversed[array.length / 2] = array[array.length / 2];
			return reversed;
		}
		else {
			reversed[index] = array[mirrorIndex];
			reversed[mirrorIndex] = array[index];
			return toReversedHelp(array, reversed, index + 1, mirrorIndex - 1);
		}
	}

	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius,
			double radiusMinimumDrawingThreshold) {
		
		// FIXME
		if (radius <= radiusMinimumDrawingThreshold) {
			return;
		}
		else {
			StdDraw.circle(xCenter, yCenter, radius);
		}
		
		circlesUponCircles(xCenter - radius, yCenter, radius/3.0, radiusMinimumDrawingThreshold);
		circlesUponCircles(xCenter, yCenter + radius, radius/3.0, radiusMinimumDrawingThreshold);
		circlesUponCircles(xCenter + radius, yCenter, radius/3.0, radiusMinimumDrawingThreshold);
		circlesUponCircles(xCenter, yCenter - radius, radius/3.0, radiusMinimumDrawingThreshold);

	}
	
	public static void main(String args[]) {
		System.out.println(gcd(48, 14));
	}

}
