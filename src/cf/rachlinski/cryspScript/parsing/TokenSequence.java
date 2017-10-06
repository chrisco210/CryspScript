package cf.rachlinski.cryspScript.parsing;

import java.util.LinkedList;

/**
 * Represents a sequence of tokens and operators to be evaluated
 */
public class TokenSequence implements Evaluable
{
	private LinkedList<Object> links;
	private boolean shouldBeTokenOrNum;

	/**
	 * Construct a new TokenSequence
	 */
	public TokenSequence()
	{
		shouldBeTokenOrNum = false;
		links = new LinkedList<Object>();
	}

	/**
	 * Add something to the end of the list, with alternating tokens and operators
	 * @param o the item to add
	 * @throws IllegalArgumentException if the alternating sequence of tokens and operators is broken
	 */
	public <E> void add(E o)
	{
		//Check if the object is a token
		if(shouldBeTokenOrNum && (o instanceof Token))
		{
			links.add(o);
			return;
		}

		//Check if the object is an operator
		if(!shouldBeTokenOrNum && (o instanceof Operator))
		{
			links.add(o);
			return;
		}

		throw new IllegalArgumentException("Could not find a way to include the specified object.");
	}

	/**
	 * Return the list of tokens and operators
	 * @return the list of tokens and operators
	 */
	public LinkedList<Object> getLinks()
	{
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

	public int eval()
	{
		return 0;
	}
}
