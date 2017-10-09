package cf.rachlinski.cryspScript.prerun.parsing.expression;

import java.util.ArrayList;

/**
 * Represents a sequence of symbols and operators to be evaluated
 */
public class SymbolSequence
{
	private ArrayList<ExpressionComponent> links;

	/**
	 * Construct a new TokenSequence
	 */
	public SymbolSequence(ArrayList<ExpressionComponent> a)
	{
		links = a;
	}

	public ArrayList<ExpressionComponent> getLinks()
	{
		return links;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		for(ExpressionComponent s : links)
			sb.append(s.toString());

		return sb.toString();
	}
}
