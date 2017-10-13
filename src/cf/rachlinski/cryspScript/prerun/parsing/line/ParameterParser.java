package cf.rachlinski.cryspScript.prerun.parsing.line;

import cf.rachlinski.cryspScript.prerun.parsing.Parser;

public class ParameterParser extends Parser<String[]>
{
	@Override
	public String[] parse(String args)
	{
		args = args.trim();

		args.replace(" ", "");

		int braceDepth = 0;		//how deep in braces
		int notedPosition; 	//Position of a character that may assist in param parsing
		for(int i = 0; i < args.length(); i++)
		{
			if(args.charAt(i) == '{')
				braceDepth++;
			else if(args.charAt(i) == '}')
				braceDepth--;
			//else

		}

		return new String[0];
	}
}
