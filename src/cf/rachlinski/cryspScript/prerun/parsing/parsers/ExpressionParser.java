package cf.rachlinski.cryspScript.prerun.parsing.parsers;

import cf.rachlinski.cryspScript.prerun.parsing.*;

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
		System.out.println(args);		//TODO DEBUG
		args = args.trim();
		ArrayList<String> s = new ArrayList<String>(args.split(" ").length);
		s.addAll(Arrays.asList(args.split(" ")));

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

		for(ExpressionComponent ex : symbolList)		//TODO DEBUG
			System.out.print(ex);
		System.out.println();

		return new Expression(new SymbolSequence(new ArrayList<>(Arrays.asList(symbolList))));
	}
}
