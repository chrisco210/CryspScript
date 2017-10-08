package cf.rachlinski.cryspScript.parsing;


/**
 * Class for containing a number symbol in an evaluable expression
 */
public class Symbol implements ExpressionComponent
{
	private int value;

	/**
	 * Construct a new symbol given value
	 * @param value the initial value of the symbol
	 */
	public Symbol(int value)
	{
		this.value = value;
	}

	/**
	 * Return the value of the symbol
	 * @return the value of the symbol
	 */
	public int getValue()
	{
		return value;
	}

	@Override
	public int type()
	{
		return ExpressionComponent.SYMBOL;
	}
}
