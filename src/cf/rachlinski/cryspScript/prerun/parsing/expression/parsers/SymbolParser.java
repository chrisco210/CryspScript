package cf.rachlinski.cryspScript.prerun.parsing.expression.parsers;

import cf.rachlinski.cryspScript.prerun.parsing.Except.IllegalOperatorException;
import cf.rachlinski.cryspScript.prerun.parsing.Parser;
import cf.rachlinski.cryspScript.prerun.parsing.expression.Operator;
import cf.rachlinski.cryspScript.prerun.parsing.expression.Symbol;

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
			args = args.trim();
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
			if(args.equals("+"))
				return Operator.ADD;
			else if(args.equals("-"))
				return Operator.SUB;
			else if(args.equals("/"))
				return Operator.DIV;
			else if(args.equals("*"))
				return Operator.MUL;
			else if(args.equals("%"))
				return Operator.MOD;
			else if(args.equals("~+"))
				return Operator.NATIVE_ADD;
			else
			{
				throw new IllegalOperatorException();
			}
		}
	}
}
