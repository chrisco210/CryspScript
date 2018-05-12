package cf.rachlinski.cryspScriptTest;

import cf.rachlinski.cryspscript.prerun.parsing.line.Line;

public class ReflectionTester
{
	public static void main(String[] args)
	{
		Line l = new Line("print {\"Joe\"} ;This is a comment");

		l.parse().run();
	}
}
