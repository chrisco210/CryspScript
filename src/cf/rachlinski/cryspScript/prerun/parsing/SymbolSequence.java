package cf.rachlinski.cryspScript.prerun.parsing;

import java.util.ArrayList;
import java.util.LinkedList;

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
}
