package cf.rachlinski.cryspscript.prerun.parsing.expression;

/**
 * Node of a binary expression tree
 * @param <E>
 */
class BinaryExpressionNode<E>
{
	protected E value;
	protected BinaryExpressionNode<?> left;
	protected BinaryExpressionNode<?> right;

	public BinaryExpressionNode(E value)
	{
		this.value = value;
	}

	public E getValue()
	{
		return value;
	}

	public BinaryExpressionNode<?> getLeft()
	{
		return left;
	}

	public BinaryExpressionNode<?> getRight()
	{
		return right;
	}
}
