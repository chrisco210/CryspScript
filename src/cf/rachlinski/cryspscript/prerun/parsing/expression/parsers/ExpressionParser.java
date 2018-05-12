package cf.rachlinski.cryspscript.prerun.parsing.expression.parsers;

import cf.rachlinski.cryspscript.prerun.parsing.Parser;
import cf.rachlinski.cryspscript.prerun.parsing.expression.Expression;
import cf.rachlinski.cryspscript.prerun.parsing.expression.ExpressionComponent;
import cf.rachlinski.cryspscript.prerun.parsing.expression.SymbolSequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ExpressionParser extends Parser<Expression>
{
	/**
	 * The number of operators
	 */
	public static final int NUM_OPS = 5;

	/**
	 * Hash map containing integer codes corresponding to string forms of operators<br>
	 * Codes are as follows:
	 * <ol start="0">
	 * <li>Multiplication</li>
	 * <li>Division</li>
	 * <li>Modulus</li>
	 * <li>Addition</li>
	 * <li>Subtraction</li>
	 * </ol>
	 * <b>The following operators are not yet implemented</b><hr>
	 * 5 - Logical Not
	 * 6 - Equals
	 * 7 - Not Equals
	 * 8 - Greater Than
	 * 9 - Less Than
	 * 10 - Greater than or equal to
	 * 11 - Less than or equal to
	 */
	public static final HashMap<String, Integer> operatorCodes;
	static
	{
		operatorCodes = new HashMap<String, Integer>(NUM_OPS);

		operatorCodes.put("*", 0);
		operatorCodes.put("/", 1);
		operatorCodes.put("%", 2);
		operatorCodes.put("+", 3);
		operatorCodes.put("-", 4);
	}


	@Override
	public Expression parse(String args)
	{
		args = args.trim();

		int num = 1;
		for(int i = 0; i < args.length(); i++)
		{
			if(args.charAt(i) == '+'
					|| args.charAt(i) == '-'
					|| args.charAt(i) == '*'
					|| args.charAt(i) == '/'
					|| args.charAt(i) == '%'
					)
			{
				num += 2;
			}
		}

		ArrayList<String> s = new ArrayList<String>(num);
		int lastLoc = 0;
		for(int i = 0; i < args.length(); i++)
		{
			if(i == args.length() - 1)
			{
				s.add(args.substring(lastLoc, i + 1));
			}

			if(args.charAt(i) == '+'
					|| args.charAt(i) == '-'
					|| args.charAt(i) == '*'
					|| args.charAt(i) == '/'
					|| args.charAt(i) == '%'
					)
			{
				s.add(args.substring(lastLoc, i ));
				s.add(Character.toString(args.charAt(i)));
				lastLoc = i + 1;
			}
		}
		//s.addAll(Arrays.asList(args.split(" ")));
		System.out.println(s);

		//ArrayList<ExpressionComponent> symbolList = new ArrayList<>(s.size());

		ExpressionComponent[] symbolList = new ExpressionComponent[s.size()];

		//Transform the strings into a list of symbols
		SymbolParser symbolParser = new SymbolParser();
		for(int i = 0; i < s.size(); i++)
		{
			if(i % 2 != 0)
			{
				symbolList[i] =  symbolParser.getOperatorParser().parse(s.get(i));
			}
			else
			{
				symbolList[i] = symbolParser.getNumberParser().parse(s.get(i));
			}
		}
		return new Expression(new SymbolSequence(new ArrayList<ExpressionComponent>(Arrays.asList(symbolList))));
	}
}
