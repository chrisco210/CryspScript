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

	private Object operate(BinaryExpressionNode<?> opNode)
	{
		if()
	}

	private static Class<?>[] TYPE_HIERARCHY;

	public static Class<?> calculateResultType(Class<?> left, Class<?> right)
	{

	}
}
