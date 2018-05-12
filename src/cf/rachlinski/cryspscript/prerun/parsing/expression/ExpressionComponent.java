package cf.rachlinski.cryspscript.prerun.parsing.expression;

/**
 * Interface to tag items that can be used in expressions
 */
public interface ExpressionComponent
{
	/**
	 * Final variable indicating an operator type
	 */
	int OPERATOR = 0;
	/**
	 * Final variable indicating an evaluable type
	 */
	int EVALUABLE = 1;
	/**
	 * Final variable for indicating a symbol type
	 */
	int SYMBOL = 2;

	/**
	 * Method to determine what an ExpressionComponent is
	 * @return 0 if it is an operator, 1 if Evaluable, 2 if symbol
	 */
	int type();
}
