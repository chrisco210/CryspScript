package cf.rachlinski.cryspScript.prerun.parsing.Except;

import cf.rachlinski.cryspScript.prerun.parsing.line.Line;

public class IllegalKeywordException extends Error
{
	public IllegalKeywordException(Line l, int lineNum)
	{
		super("Error when executing line " + (lineNum + 1) + ": Keyword " + l.getKeyword() + " was not found in the supplied command xml files.  Ensure you have typed the keyword correctly, and have included the command.xml\n" +
				"Exception encountered when parsing the following: \n"
		+ l);
	}
}
