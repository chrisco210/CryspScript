package cf.rachlinski.cryspScript.prerun.parsing;

import java.util.LinkedList;

/**
 * Represents a sequence of tokens and operators to be evaluated
 */
public class TokenSequence
{
	private LinkedList<ExpressionComponent> links;
	private boolean shouldBeTokenOrNum;

	/**
	 * Construct a new TokenSequence
	 */
	public TokenSequence()
	{
		shouldBeTokenOrNum = false;
		links = new LinkedList<ExpressionComponent>();
	}

	/**
	 * Add something to the end of the list, with alternating evaluable and operators.
	 * If an evaluable is added with an evaluable preceding it, a multiplication operator will be placed in between
	 * If two operators are added next to each other, a zero will be placed in between them
	 * @param c the item to add
	 */
	public void add(ExpressionComponent c)
	{
		if()

	}

	/**
	 * Return the list of tokens and operators
	 * If the list ends with an operator, a zero will be appended to the end of the list
	 * If {@code links.size() % 3 == 0}, a + 0 will be appended to the end
	 * @return the list of tokens and operators
	 */
	public LinkedList<ExpressionComponent> getLinks()
	{
		if(links.getLast().type() == ExpressionComponent.OPERATOR)
			links.

		return links;
	}

	/**
	 * Return the size of the list
	 * @return the size of the list
	 */
	public int size()
	{
		return links.size();
	}
}
