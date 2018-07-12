package cf.rachlinski.cryspscript.prerun.parsing.expression.types;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

public abstract class Type<T>
{
	protected T value;

	public Type(T value)
	{
		this.value = value;
	}
	/* Some utility interfaces*/

	/**
	 * Provides basic math functionality
	 * @param <T> type
	 */
	public interface BasicMath<T> extends
			Addable<T>,
			Subtractable<T>,
			Multiplicable<T>,
			Divisible<T>,
			Modulus<T>
	{}

	/**
	 * Comparisons
	 * @param <T>
	 * @param <R>
	 */
	public interface Comparisons<T, R> extends
			LT<T, R>,
			GT<T, R>,
			LTEQ<T, R>,
			GTEQ<T, R>,
			Equals<T, R>
	{}


	/**
	 * Boolean logic operations
	 * @param <T>
	 * @param <R>
	 */
	public interface BooleanLogic<T, R> extends
			And<T, R>,
			Or<T, R>,
			Xor<T, R>,
			Not<T, R>
	{}



	/* Math ones */

	/**
	 * Use if things are addable
	 * @param <T> type to use
	 */
	public interface Addable<T>
	{
		T add(T o);
	}

	/**
	 * Use if things are subtractable
	 * @param <T> type to use
	 */
	public interface Subtractable<T>
	{
		T sub(T o);
	}

	/**
	 * Use if things can multiply
	 * @param <T> type to use
	 */
	public interface Multiplicable<T>
	{
		T mult(T o);
	}

	/**
	 * Use if things are divisible
	 * @param <T> type to use
	 */
	public interface Divisible<T>
	{
		T div(T o);
	}

	/**
	 * Use if things are modable
	 * @param <T> type to use
	 */
	public interface Modulus<T>
	{
		T mod(T o);
	}

	/* Comparison */

	/**
	 * Use if things can be =d
	 * @param <T> type to use
	 * @param <R> return type
	 */
	public interface Equals<T, R>
	{
		R eq(T o);
	}

	/**
	 * Less than
	 * @param <T>
	 * @param <R> return type
	 */
	public interface LT<T, R>
	{
		R lt(T o);
	}

	/**
	 * Greater than
	 * @param <T>
	 * @param <R> return type
	 */
	public interface GT<T, R>
	{
		R gt(T o);
	}

	/**
	 * Less Than Equal To
	 * @param <T>
	 * @param <R> return type
	 */
	public interface LTEQ<T, R>
	{
		R lteq(T o);
	}

	/**
	 * Greater Than Equal To
	 * @param <T>
	 * @param <R> return type
	 */
	public interface GTEQ<T, R>
	{
		R lteq(T o);
	}

	/**
	 * Use if things can be compared
	 * @param <T> type to use
	 * @param <R> return type
	 */
	public interface Cmpr<T, R>
	{
		R cmpr(T o);
	}

	/* Boolean */

	/**
	 * Use if things can be ANDed
	 * @param <T> type to use
	 * @param <R> return type
	 */
	public interface And<T, R>
	{
		R and(T o);
	}

	/**
	 * Use if things cna be ORed
	 * @param <T> type to use
	 * @param <R> return type
	 */
	public interface Or<T, R>
	{
		R or(T o);
	}

	/**
	 * Use if things can be NOTed
	 * @param <T> type to use
	 * @param <R> return type
	 */
	public interface Not<T, R>
	{
		R not(T o);
	}

	/**
	 * Use if things can be XORed
	 * @param <T> type to use
	 * @param <R> return type
	 */
	public interface Xor<T, R>
	{
		R xor(T o);
	}








}
