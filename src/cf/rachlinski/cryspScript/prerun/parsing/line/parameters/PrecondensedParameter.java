package cf.rachlinski.cryspScript.prerun.parsing.line.parameters;

import cf.rachlinski.cryspScript.runtime.dataStructs.variable.Variable;

/**
 * Represents a parameter in it's pre execution state
 * Parameter TOTYPE represents the predicted type of the parameter
 */
public class PrecondensedParameter
{
	private static final int STR_TYPE = 0;
	private static final int CHR_TYPE = 1;
	private static final int INT_TYPE = 2;
	private static final int DEC_TYPE = 3;
	private String value;

	/**
	 * Construct a PrecondensedParameter with a value and an integer code for type <br>
	 * The accepted type values are:
	 * <ul>
	 *     <li>String - 0</li>
	 *     <li>Char - 1</li>
	 *     <li>Integer - 2</li>
	 *     <li>Decimal - 3</li>
	 * </ul>
	 * @param value the value of the parameter as a string
	 */
	public PrecondensedParameter(String value)
	{
		this.value = value;
	}

	/**
	 * Parses
	 * @return
	 */
	public Variable<?> valueOf()
	{
		switch(evaluateType(value))
		{
		case STR_TYPE:
			return new Variable<String>(value);
		case CHR_TYPE:
			return new Variable<Character>(value.charAt(0));
		case INT_TYPE:
			return new Variable<Integer>(Integer.parseInt(value));
		case DEC_TYPE:
			return new Variable<Double>(Double.parseDouble(value));
		default:
			return Variable.NULL;
		}
	}

	/**
	 * Return if the given parameter is a method
	 * @return
	 */
	public boolean isMethod()
	{
		return false;
	}

	/**
	 * Return the most likely type of a string of text
	 * @param text the text to evaluate
	 * @return an integer code corresponding to the predicted type of the string
	 */
	private int evaluateType(String text)
	{
		if(text.charAt(0) == '\"')
			return STR_TYPE;
		else if(text.charAt(0) == '\'')
			return CHR_TYPE;
		else if(text.contains("."))
			return DEC_TYPE;

		return INT_TYPE;
	}
}
