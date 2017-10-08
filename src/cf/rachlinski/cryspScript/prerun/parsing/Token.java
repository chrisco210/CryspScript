package cf.rachlinski.cryspScript.prerun.parsing;

/**
 * A evaluable token
 */
public class Token implements Evaluable, ExpressionComponent
{
	private Operator operator;
	private Symbol leftOp;
	private Symbol rightOp;

	/**
	 * Create a new token with an operator
	 * @param leftOp the number on the left side of the operator
	 * @param op the operator
	 * @param rightOp the number on the right side of the operator
	 */
	public Token(Symbol leftOp, Operator op, Symbol rightOp)
	{
		this.leftOp = leftOp;
		this.rightOp = rightOp;
		this.operator = op;
	}

	public int eval()
	{
		return operator.op(leftOp.getValue(), rightOp.getValue());
	}

	public int type()
	{
		return ExpressionComponent.EVALUABLE;
	}
}
