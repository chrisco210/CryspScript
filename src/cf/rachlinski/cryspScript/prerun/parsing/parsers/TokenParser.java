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
		args = args.trim();
		String[] s = args.split(" ");		//Array of potential tokens

		//Make sure that there are not too many items in the sequence
		if(s.length > MAX_TOKEN_LENGTH)
		{
			throw new IllegalArgumentException("Maximum length of tokens is 3.  2 numbers separated by 1 operator");
		}

		ExpressionComponent[] components = new ExpressionComponent[3];

		SymbolParser symbolParser = new SymbolParser();
		for(int i = 0; i < MAX_TOKEN_LENGTH; i++)
		{
			components[i] = symbolParser.parse(s[i]);
		}


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
