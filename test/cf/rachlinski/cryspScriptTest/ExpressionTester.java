package cf.rachlinski.cryspScriptTest;

import cf.rachlinski.cryspScript.prerun.parsing.parsers.ExpressionParser;

public class ExpressionTester
{
	public static void main(String[] args)
	{
		ExpressionParser parser = new ExpressionParser();

		int res = parser.parse("1 + 2 * 3 / 6").eval();
		System.out.println(res);
	}
}
