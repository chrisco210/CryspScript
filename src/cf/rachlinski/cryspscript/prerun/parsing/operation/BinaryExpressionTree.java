package cf.rachlinski.cryspscript.prerun.parsing.operation;

public class BinaryExpressionTree
{


	class Node
	{
		private Node left;
		private Node right;

		private Node parent;

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

	class ValueNode extends Node
	{
		private
	}

	class OperatorNode extends Node
	{

	}
}
