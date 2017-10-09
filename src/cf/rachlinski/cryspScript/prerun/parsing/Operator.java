package cf.rachlinski.cryspScript.prerun.parsing;

/**
 * Enum containing operators
 */
public enum Operator implements ExpressionComponent
{
	MUL,
	DIV,
	MOD,
	ADD,
	SUB;

	/**
	 * Perform the operation specified by the enum
	 * @param a the first number to operate on
	 * @param b the second number to operate on
	 * @return the result of the operation specified given int a and b
	 */
	public int op(int a, int b)
	{
		switch(this)
		{
		case ADD:
			return a + b;
		case SUB:
			return a - b;
		case MUL:
			return a * b;
		case DIV:
			return a / b;
		case MOD:
			return a % b;
		}

		throw new RuntimeException("Case not found.");
	}

	public int type()
	{
		return ExpressionComponent.OPERATOR;
	}

}
