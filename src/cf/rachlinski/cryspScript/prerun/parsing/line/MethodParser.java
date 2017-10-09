package cf.rachlinski.cryspScript.prerun.parsing.line;

import cf.rachlinski.cryspScript.prerun.parsing.Parser;
import cf.rachlinski.cryspScript.prerun.parsing.expression.Symbol;
import cf.rachlinski.cryspScript.prerun.parsing.expression.parsers.ExpressionParser;
import cf.rachlinski.cryspScript.runtime.exec.method.Subroutine;

public class MethodParser extends Parser<Subroutine>
{
	private static final int FUNCTION = 0;
	private static final int ROUTINE = 1;
	private static final int KEYWORD = 2;

	@Override
	public Subroutine parse(String args)
	{
		//Parse method arguments

		String[] sargs = args.substring(args.indexOf('{') + 1, args.lastIndexOf('}') - 1).split(",");
		Symbol[] symbols = new Symbol[sargs.length];
		ExpressionParser parser = new ExpressionParser();
		for(int i = 0; i < sargs.length; i++)
		{
			//symbols[i] = new
		}


		//Figure out if calling a function, routine, or keyword routine
		int type;
		char tid = args.charAt(0);
		if(tid == '^')
			type = FUNCTION;
		else if(tid == '_')
			type = ROUTINE;
		else
			type = KEYWORD;


		return null; //TODO figure out the best way to run methods
	}
}
