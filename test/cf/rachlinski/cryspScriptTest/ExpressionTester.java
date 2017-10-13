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

		System.out.println("1 + 52 / 3 = " + parser.parse("1+	52      /3").eval());
	}
}
