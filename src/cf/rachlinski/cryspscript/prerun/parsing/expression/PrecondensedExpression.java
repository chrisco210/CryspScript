package cf.rachlinski.cryspscript.prerun.parsing.expression;

import cf.rachlinski.cryspscript.prerun.parsing.line.parameters.PrecondensedParameter;
import cf.rachlinski.cryspscript.runtime.dataStructs.variable.Variable;

/**
 * Represents a pre condensed parameter that contains operations
 */
public class PrecondensedExpression extends PrecondensedParameter
{
	private BinaryExpressionNode<?> root;

	/**
	 * Construct a binary expression tree given an expression and optional variables
	 * @param expression the expression to use
	 */
	public PrecondensedExpression(String expression)
	{
		super(expression);

		//Generate expression tree

	}

	@Override
	public Variable<?> valueOf()
	{

	}

	private Object getTotalRec(BinaryExpressionNode currentNode)
	{
		if(currentNode.isOperator())
		{
			return ((Operator) currentNode.getValue())
					.operate(
							getTotalRec(currentNode.getLeft()),
							getTotalRec(currentNode.getRight())
					);
		}
		else if(currentNode.childCount() == 0)
		{
			return currentNode.getValue();
		}
		else		//This case should never be triggered
		{
			System.err.println("WARN: Non-operator node has children. " +
					"This should not happen, and is most likely an error");
			return 0;
		}
	}

	private static Class<?>[] TYPE_HIERARCHY;

	public static Class<?> calculateResultType(Class<?> left, Class<?> right)
	{

	}
}
