package cf.rachlinski.cryspScript.util;

import cf.rachlinski.cryspScript.parsing.ExpressionComponent;
import cf.rachlinski.cryspScript.parsing.Operator;
import cf.rachlinski.cryspScript.parsing.Symbol;

public class SymbolParser extends Parser<ExpressionComponent>
{
	@Override
	public ExpressionComponent parse(String args)
	{
		args = args.trim();

		if(args.matches("/^(\\\\+|\\\\*|/|-)"))
		{
			switch(args)
			{
			case "+":
				return Operator.ADD;
			case "-":
				return Operator.SUB;
			case "/":
				return Operator.SUB;
			case "*":
				return Operator.MUL;
			default:
				return Operator.ADD;
			}
		}
		else
		{
			return new Symbol(Integer.parseInt(args));
		}
	}
}
