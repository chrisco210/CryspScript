package cf.rachlinski.cryspscript.prerun.parsing.operation;

import cf.rachlinski.cryspscript.prerun.parsing.line.parameters.PrecondensedParameter;

import java.util.LinkedList;

public class BinaryExpressionTree
{

	private Node rootNode;


	public BinaryExpressionTree(String tree)
	{
		 tree = tree.replace(" ", "");
		 generateTree(tree, rootNode);
		 //TODO handle wrapped parentheses
	}

	private void generateTree(String remaining, Node toAppendTo)
	{
		if(remaining.length() == 1)
		{
			toAppendTo.setValue(remaining.charAt(0) + "");
		}
		else
		{
			int lastPosition = 0;
			int nesting = 0;
			for(int i = 0; i < remaining.length(); i++)
			{
				if(remaining.charAt(i) == '(')
				{
					nesting++;
				}
				else if(remaining.charAt(i) == ')')
				{
					nesting--;
				}
				else if((nesting == 0) && isOp(remaining.charAt(i)))
				{
					if(Number.OP_HIERARCHY_STR.indexOf(remaining.charAt(lastPosition))
							< Number.OP_HIERARCHY_STR.indexOf(remaining.charAt(i))
							)
					{
						lastPosition = i;
					}
				}
			}
			String leftOp = remaining.substring(0, lastPosition);
			String rightOp = remaining.substring(lastPosition + 1, remaining.length());

			if(leftOp.charAt(0) == '(')
			{
				leftOp = leftOp.substring(1);
			}

			if(rightOp.charAt(rightOp.length() - 1) == ')')
			{
				rightOp = rightOp.substring(0, rightOp.length()- 1);
			}

			toAppendTo.setValue("" + remaining.charAt(lastPosition));

			Node left = new Node(null);
			Node right = new Node(null);

			toAppendTo.setLeft(left);
			toAppendTo.setRight(right);

			generateTree(leftOp, left);
			generateTree(rightOp, right);


		}
	}

	private static boolean isOp(char str)
	{
		for(char c : Number.OP_HIERARCHY)
		{
			if(c == str)
				return true;
		}

		return false;
	}

	private static boolean isNum(String str)
	{
		if(str.contains("$"))
			return false;
		for(char c : Number.OP_HIERARCHY)
		{
			if(str.indexOf(c) != -1)
			{
				return false;
			}
		}

		return true;
	}



	private static int[] indexesOf(String target, char[] values)
	{
		LinkedList<Integer> pos = new LinkedList<>();

		for(char c : values)
		{
			boolean foundAll = false;
			int lastPos = 0;
			do
			{
				int res = target.indexOf(c, lastPos);
				if(res != -1)
				{
					pos.add(res);
				}
				lastPos = res + 1;
			} while(lastPos != 0);
		}

		int[] retArr = new int[pos.size()];

		for(int i = 0; i < pos.size(); i++)
		{
			retArr[i] = pos.get(i);
		}

		return retArr;
	}


	public class Node
	{
		private Node left;
		private Node right;

		private Node parent;

		protected String value;



		public Node(String value)
		{
			this.value = value;
		}

		/**
		 * return the value of the node
		 */
		public String getValue()
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

		public void setValue(String value)
		{
			this.value = value;
		}
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();


	}

	public String reconstructInorder()
	{

	}

	private String inorder(Node current)
	{
		if(current.getLeft() == null && current.getRight() == null)
		{
			return current.getValue();
		}
		else if(current.getRight() == null)
		{
			return inorder(current.getLeft()) + current.getValue();
		}
		else if(current.getLeft() == null)
		{
			return current.getValue() + inorder(current.getRight());
		}
		else
		{
			return inorder(current.getLeft()) + current.getValue() + inorder(current.getRight());
		}
	}
}
