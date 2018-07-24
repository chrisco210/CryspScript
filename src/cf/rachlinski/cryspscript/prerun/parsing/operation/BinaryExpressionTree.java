package cf.rachlinski.cryspscript.prerun.parsing.operation;

public class BinaryExpressionTree
{
	private Node<?> rootNode;

	public BinaryExpressionTree(String tree)


	public class Node<E>
	{
		private Node left;
		private Node right;

		private Node parent;

		protected E value;

		public Node(E value, Node parent)
		{
			this.value = value;
			this.parent = parent;
		}

		/**
		 * return the value of the node
		 */
		public E getValue()
		{
			return value;
		}

		/**
		 * Return the parent node of this node
		 * @return the parent node of this node, null if it is a root node
		 */
		public Node getParent()
		{
			return parent;
		}

		/**
		 * Return the left node of this node
		 * @return the right node, null if it does not exist
		 */
		public Node getLeft()
		{
			return left;
		}

		/**
		 * Return the right node
		 * @return the right node, null if it does not exist
		 */
		public Node getRight()
		{
			return right;
		}

		/**
		 * Set the right node
		 * @param right the node to set right to
		 */
		public void setRight(Node right)
		{
			this.right = right;
		}


		/**
		 * Set the left node
		 * @param left the node to set left to
		 */
		public void setLeft(Node left)
		{
			this.left = left;
		}

		public boolean isValue()
		{
			return this instanceof ValueNode;
		}
	}

	public class ValueNode extends Node<Number>
	{

		public ValueNode(Number value, Node parent)
		{
			super(value, parent);
		}
	}

	public class OperatorNode extends Node<Operator>
	{

		public OperatorNode(Operator value, Node parent)
		{
			super(value, parent);
		}
	}

	public class VariableNode extends Node<>
	{

		public VariableNode(Object value, Node parent)
		{
			super(value, parent);
		}

		public
	}
}
