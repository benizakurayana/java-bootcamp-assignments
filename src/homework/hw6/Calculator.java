package homework.hw6;

public class Calculator {

	public int powerXY(int x, int y) throws CalException {
		/**
		 * Returns the value of the first argument raised to the power of the second
		 * argument.
		 * @param x the base.
		 * @param y the exponent.
		 * @return the value x^y.
		 * @throws CalException if both x and y are equal to 0, as 0^0 is meaningless.
		 */
		if (x == 0 && y == 0) {
			throw new CalException("0的0次方沒有意義！");
		}
		return (int) Math.pow(x, y);
	}
}
