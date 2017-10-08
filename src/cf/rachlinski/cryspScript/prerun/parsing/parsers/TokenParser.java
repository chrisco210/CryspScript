package cf.rachlinski.cryspScript.prerun.parsing.parsers;

import cf.rachlinski.cryspScript.prerun.parsing.ExpressionComponent;
import cf.rachlinski.cryspScript.prerun.parsing.Operator;
import cf.rachlinski.cryspScript.prerun.parsing.Symbol;
import cf.rachlinski.cryspScript.prerun.parsing.Token;

public class TokenParser extends Parser<Token>
{
	private static final int MAX_TOKEN_LENGTH = 3;

	@Override
	public Token parse(String args)
	{
		SymbolParser symbolParser = new SymbolParser();		//Symbol parser for later use

		args = args.trim();
		String[] s = args.split(" ");		//Array of potential tokens

		if(s.length == 1)
		{
			return new Token(symbolParser.getNumberParser().parse(s[0]), Operator.ADD, new Symbol(0));
		}

		//Make sure that there are not too many items in the sequence
		if(s.length > MAX_TOKEN_LENGTH)
		{
			throw new IllegalArgumentException("Maximum length of tokens is 3.  2 numbers separated by 1 operator");
		}

		ExpressionComponent[] components = new ExpressionComponent[3];

		components[0] = symbolParser.getNumberParser().parse(s[0]);
		components[1] = symbolParser.getOperatorParser().parse(s[1]);
		components[2] = symbolParser.getOperatorParser().parse(s[2]);


		try
		{
			return new Token((Symbol) components[0], (Operator) components[1], (Symbol) components[2]);
		}
		catch (Exception e)
		{
			throw new IllegalArgumentException("Improper order of arguments found.");
		}
	}
}
