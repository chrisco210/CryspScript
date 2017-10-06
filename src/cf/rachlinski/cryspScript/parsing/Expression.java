package cf.rachlinski.cryspScript.parsing;

import java.util.LinkedList;

/**
 * An evaluable expression containing a series of tokens and operators
 */
public class Expression implements Evaluable
{
	private TokenSequence sequence;

	/**
	 * Construct a new expression given a list of tokens
	 * @param tokens the list of tokens to supply
	 */
	public Expression(TokenSequence tokens)
	{
		sequence = tokens;
	}

	public int eval()
	{
		int sum = 0;
		LinkedList<Object> s = sequence.getLinks();

		if(s.size() < 3)		//If there is only one expression
		{
			return ((Token) s.get(0)).eval();
		}

		//TODO This is broken, will not work, fix
		for(int i = 0; i < s.size(); i += 2)
		{
			int tempSum = ((Operator) s.get(i + 1)).op(((Token)s.get(i)).eval(), ((Token) s.get(i + 2)).eval());		//Evaluate the operator and tokens
			s.set(i + 2, new Token(tempSum, Operator.ADD, 0));		//We need to add the result of the previous operation to the next slot that will be added

		}

		return sum;
	}
}
