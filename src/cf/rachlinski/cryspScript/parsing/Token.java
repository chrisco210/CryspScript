package cf.rachlinski.cryspScript.parsing;

/**
 * A evaluable token
 */
public class Token implements Evaluable
{
	private Operator operator;
	private int leftOp;
	private int rightOp;

	/**
	 * Create a new token with an operator
	 * @param leftOp the number on the left side of the operator
	 * @param op the operator
	 * @param rightOp the number on the right side of the operator
	 */
	public Token(int leftOp, Operator op, int rightOp)
	{
		this.leftOp = leftOp;
		this.rightOp = rightOp;
		this.operator = op;
	}

	public int eval()
	{
		return operator.op(leftOp, rightOp);
	}
}
