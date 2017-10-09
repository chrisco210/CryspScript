package cf.rachlinski.cryspScriptTest;

import cf.rachlinski.cryspScript.prerun.parsing.expression.parsers.ExpressionParser;

public class ExpressionTester
{
	static int ten = 10;
	static int two = 2;
	static int three = 3;
	static int fifty = 50;

	public static void main(String[] args)
	{

		ExpressionParser parser = new ExpressionParser();

		long parseStartTime = System.nanoTime();
		int res = parser.parse("10 + 2 * 3 - 50 % 3").eval();
		long parseEndTime = System.nanoTime();

		long javaStartTime = System.nanoTime();
		int res2 = 10 + 2 * 3 - 50 % 3;
		long javaEndTime = System.nanoTime();

		System.out.println(parseEndTime - parseStartTime);
		System.out.println(javaEndTime - javaStartTime);
	}
}
