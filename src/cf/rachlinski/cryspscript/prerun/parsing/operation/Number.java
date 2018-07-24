package cf.rachlinski.cryspscript.prerun.parsing.operation;

/**
 * Represents a number with static methods to perform operations on numbers
 */
public class Number
{
	private double value;

	//True if the number should be treated as an integer
	private boolean isInteger;

	public Number(double value)
	{
		this.isInteger = true;
		this.value = value;
	}

	public Number(int value)
	{
		isInteger = true;
		this.value = value;
	}

	/**
	 * Return true if the number is an integer
	 * @return
	 */
	public boolean isInteger()
	{
		return isInteger;
	}

	/**
	 * Return the double representation of the number
	 * @return the number as a double
	 */
	public double doubleValue()
	{
		return value;
	}

	/**
	 * Return the integer representation of the number using floor rounding method
	 * @return the number as an integer
	 */
	public int intValue()
	{
		return (int) value;
	}

	/**
	 * Returns the integer representation using a specified rounding method.
	 * Uses codes specified in {@code Number.RoundingMode}
	 * @param roundingMode the rounding mode to use
	 * @return the number as an integer
	 */
	public int intValue(int roundingMode)
	{
		switch(roundingMode)
		{
		case 0:		//Floor
			return (int) value;
		case 1:		//Ceil
			final double CEILAUG = 1.0d - Double.MIN_VALUE;
			return (value < 0) ? ((int) (value - CEILAUG)) : ((int) (value + CEILAUG));
		case 2:		//Regular, down on .5
			final double DOHAUG = 0.5d - Double.MIN_VALUE;
			return (value < 0) ? ((int) (value - DOHAUG)) : ((int) (value + DOHAUG));
		case 3:		//Regular, up on .5
			return (value < 0) ? ((int) (value - .5)) : ((int) (value + .5));
		default:
			throw new IllegalArgumentException("Invalid rounding mode: " + roundingMode);
		}
	}

	@Override
	public Number clone()
	{
		if(isInteger)
			return new Number((int) value);
		return new Number(value);
	}

	public static final class RoundingMode
	{
		/**
		 * Round doubles to the floor integer, smallest number greater than or equal to the
		 * non-decimal part. <br>
		 * Examples:
		 * <ul>
		 *     <li>1.2 -> 1</li>
		 *     <li>1.5 -> 1</li>
		 *     <li>1.7 -> 1</li>
		 *     <li>2.0 -> 2</li>
		 *     <li>1.0 -> 1</li>
		 *     <li>1.0001 -> 1</li>
		 * </ul>
		 */
		public static final int FLOOR_ROUNDNING = 0;

		/**
		 * Round doubles to the ceiling number, the largest number less than or equal to the
		 * non-decimal part. <br>
		 * Examples:
		 * <ul>
		 *     <li>1.2 -> 2</li>
		 * 	   <li>1.5 -> 2</li>
		 * 	   <li>1.7 -> 2</li>
		 * 	   <li>2.0 -> 2</li>
		 * 	   <li>2.0001 -> 3</li>
		 * </ul>
		 */
		public static final int CEIL_ROUNDING = 1;
		/**
		 * Regular rounding, .5 rounds down
		 */
		public static final int NEAREST_INT = 2;

		/**
		 * Regular rounding, .5 goes up
		 */
		public static final int NEAREST_INT_UP = 3;
	}

	public static Object valueOf(Number num)
	{
		if(num.isInteger())
		{
			return num.intValue();
		}

		return num.doubleValue();
	}

	public static Number add(Number num1, Number num2)
	{
		if(!num1.isInteger() || !num2.isInteger())
		{
			return new Number(num1.value + num1.value);
		}
	}

	public static Number sub(Number num1, Number num2)
	{

	}

	public static Number mul(Number num1, Number num2)
	{

	}

	public static Number div(Number num1, Number num2)
	{

	}

	public static Number mod(Number num1, Number num2)
	{

	}
}
