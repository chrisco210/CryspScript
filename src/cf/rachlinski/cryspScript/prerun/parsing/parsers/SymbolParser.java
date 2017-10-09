package cf.rachlinski.cryspScript.prerun.parsing.parsers;

import cf.rachlinski.cryspScript.prerun.parsing.ExpressionComponent;
import cf.rachlinski.cryspScript.prerun.parsing.Operator;
import cf.rachlinski.cryspScript.prerun.parsing.Symbol;

/**
 * Class containing Operator and number parsers
 */
public class SymbolParser
{
	private NumberParser numberParser;
	private OperatorParser operatorParser;

	public SymbolParser()
	{
		numberParser = new NumberParser();
		operatorParser = new OperatorParser();
	}

	/**
	 * Return the number parser
	 * @return the number parser
	 */
	public NumberParser getNumberParser()
	{
		return numberParser;
	}

	/**
	 * Return the Operation parser
	 * @return the operation parser
	 */
	public OperatorParser getOperatorParser()
	{
		return operatorParser;
	}

	/**
	 * Inner class for parsing number symbols
	 */
	protected class NumberParser extends Parser<Symbol>
	{
		@Override
		public Symbol parse(String args)
		{
			return new Symbol(Integer.parseInt(args));
		}
	}

	/**
	 * Inner class for parsing Operator symbols
	 */
	protected class OperatorParser extends Parser<Operator>
	{

		@Override
		public Operator parse(String args)
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
	}
}
