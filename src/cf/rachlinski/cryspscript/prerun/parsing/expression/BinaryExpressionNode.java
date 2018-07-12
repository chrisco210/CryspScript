package cf.rachlinski.cryspscript.prerun.parsing.expression;

/**
 * Node of a binary expression tree.  Note that this can contain variables
 */
class BinaryExpressionNode
{
	/**
	 * Value contained in the field
	 */
	protected Object value;

	/**
	 * Left node
	 */
	protected BinaryExpressionNode left;

	/**
	 * Right Node
	 */
	protected BinaryExpressionNode right;

	/**
	 * Specifies if this node is the root.  False if unspecified
	 */
	private boolean isRootNode;

	/**
	 * Construct a binary expression node given a value.  To specify an operator supply an {@code Operator} type<br>
	 * Valid types are:
	 * <ul>
	 *     <li>{@code Integer}</li>
	 *     <li>{@code Double}</li>
	 *     <li>{@code String}</li>
	 * </ul>
	 * @param value the value to supply the node
	 */
	BinaryExpressionNode(Object value)
	{
		this.value = value;
		this.isRootNode = false;
	}

	/**
	 * Construct a binary expression node given a value.  To specify an operator supply an {@code Operator} type<br>
	 * This constructor also allows you to specify if the node is a root node.
	 * Valid types are:
	 * <ul>
	 *     <li>{@code Integer}</li>
	 *     <li>{@code Double}</li>
	 *     <li>{@code String}</li>
	 * </ul>
	 * @param value the value to supply the node
	 * @param isRootNode if the node is a root node.  This prevents the node from being added as a child
	 */
	public BinaryExpressionNode(Object value, boolean isRootNode)
	{
		this.value = value;
		this.isRootNode = isRootNode;
	}



	/**
	 * Return if the node represents an operator
	 * @return if the node represents an operator
	 */
	public boolean isOperator()
	{
		return value instanceof Operator;
	}

	/**
	 * Return true if this is the root node IE it has no children
	 * @return if the node is the root node
	 */
	public boolean isRootNode()
	{
		return isRootNode;
	}

	/**
	 * Return the number of non {@code null} children
	 * @return the number of non {@code null} children
	 */
	public int childCount()
	{
		return (left == null ? 0 : 1) + (right == null ? 0 : 1);
	}

	/**
	 * Get the value of the current node.  calling this method will evaluate any variable types
	 * @return the value of the current node
	 */
	public Object getValue()
	{
		//TODO make this handle variables
		return value;
	}

	/**
	 * Set the left node
	 * @param left the node to set left to
	 */
	public void setLeft(BinaryExpressionNode left)
	{
		if(left.isRootNode)
			throw new IllegalArgumentException("Cannot set a root node as a child of a node");
		this.left = left;
	}

	/**
	 * Set the right node
	 * @param right the node to set right to
	 */
	public void setRight(BinaryExpressionNode right)
	{
		if(right.isRootNode)
			throw new IllegalArgumentException("Cannot set a root node as a child of a node");
		this.right = right;
	}

	/**
	 * Get the left node
	 * @return the left node
	 */
	public BinaryExpressionNode getLeft()
	{
		return left;
	}

	/**
	 * Get the right node
	 * @return the right node
	 */
	public BinaryExpressionNode getRight()
	{
		return right;
	}
}
