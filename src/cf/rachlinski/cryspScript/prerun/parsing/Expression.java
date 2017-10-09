package cf.rachlinski.cryspScript.prerun.parsing;

import cf.rachlinski.cryspScript.prerun.parsing.parsers.ExpressionParser;

import java.util.ArrayList;

/**
 * An evaluable expression containing a series of tokens and operators
 */
public class Expression implements Evaluable
{
	private SymbolSequence sequence;

	/**
	 * Construct a new expression given a list of tokens
	 * @param tokens the list of tokens to supply
	 */
	public Expression(SymbolSequence tokens)
	{
		sequence = tokens;
	}

	public int eval()
	{
		//Evaluate, according to the order of operations specified by the operator codes, the token

		ArrayList<ExpressionComponent> syms = sequence.getLinks();

		System.out.println(syms);		//TODO DEBUG

		for(int j = 0; j < ExpressionParser.NUM_OPS; j++)
		{
			for(int i = 1; i < syms.size(); i += 2)
			{
				if(((Operator) syms.get(i)).ordinal() == j)
				{
					Token tempToken = new Token((Symbol) syms.get(i - 1), (Operator) syms.get(i), (Symbol) syms.get(i + 1));
					syms.remove(i - 1);
					syms.remove(i - 1);
					syms.remove(i - 1);
					syms.add(i - 1, new Symbol(tempToken.eval()));
				}
			}
		}

		return ((Symbol) syms.get(0)).getValue();
	}

	@Override
	public String toString()
	{
		return "Expression{" + sequence + "}";
	}
}
