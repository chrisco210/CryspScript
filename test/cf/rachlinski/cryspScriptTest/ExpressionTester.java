package cf.rachlinski.cryspScriptTest;

import cf.rachlinski.cryspScript.prerun.parsing.parsers.ExpressionParser;

public class ExpressionTester
{
	public static void main(String[] args)
	{
		ExpressionParser parser = new ExpressionParser();

		int res = parser.parse("1 + 1").eval();
		System.out.println("Expression 1 + 1 (Expect 2): " + res);

		res = parser.parse("1 + 61").eval();
		System.out.println("Expression 1 + 61 (Expect 62: " + res);

		res = parser.parse("1 + 2 * 3 / 6").eval();
		System.out.println("Expression 1 + 2 * 3 / 6 (Expect 2): " + res);
	}
}
