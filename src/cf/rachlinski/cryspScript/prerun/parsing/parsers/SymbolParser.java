package cf.rachlinski.cryspScript.prerun.parsing.parsers;

import cf.rachlinski.cryspScript.prerun.parsing.ExpressionComponent;
import cf.rachlinski.cryspScript.prerun.parsing.Operator;
import cf.rachlinski.cryspScript.prerun.parsing.Symbol;

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
