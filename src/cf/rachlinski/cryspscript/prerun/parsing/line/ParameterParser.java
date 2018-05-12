package cf.rachlinski.cryspscript.prerun.parsing.line;

import cf.rachlinski.cryspscript.prerun.parsing.Parser;
import cf.rachlinski.cryspscript.prerun.parsing.line.parameters.PrecondensedParameter;

import java.util.ArrayList;
import java.util.List;

public class ParameterParser extends Parser<PrecondensedParameter[]>
{

	private static final int STR_TYPE = 0;
	private static final int CHR_TYPE = 1;
	private static final int INT_TYPE = 2;
	private static final int DEC_TYPE = 3;

	/*
	Example (really basic) line:

	_print {"Joe"} TODO support method calls within prints

	More complex example containing literals as well as variables:

	_print {^CONCAT {^add   {$a, 2}, }}

	 */
	@Override
	public PrecondensedParameter[] parse(String args)
	{
		args = args.trim();

		args = args.charAt(0) == '{' ? args.substring(1) : args;
		args = args.charAt(args.length() - 1) == '}' ? args.substring(0, args.length() - 1) : args;

		List<PrecondensedParameter> ps = new ArrayList<>();

		ArrayList<Integer> commaLoc = new ArrayList<>();

		for(int i = 0; i < args.length(); i++)
		{
			if(args.charAt(i) == ',')
			{
				commaLoc.add(i);
			}
		}

		if(commaLoc.isEmpty())
		{
			ps.add(new PrecondensedParameter(args));
		}
		else
		{
			int lastI = -1;
			for(int i : commaLoc)
			{
				ps.add(new PrecondensedParameter(args.substring(lastI + 1, i)));
				lastI = i;
			}
		}


		return ps.toArray(new PrecondensedParameter[]{});



		/*



		int paramCount = 1;

		//Get total number of args
		for(int i = 0; i < args.length(); i++)
		{
			if(args.charAt(i) == ',')
				paramCount++;
		}

		//Now find the locations of all these separators if applicable
		//There is an implied separator at 0, with location 0 index 0
		int[] paramSepLoc = new int[paramCount + 1];

		paramSepLoc[0] = 0;		//Set the implied separator

		if(args.length() > 1)
		{
			int j = 1;
			for(int i = 1; i < args.length(); i++)
			{
				if(args.charAt(i) == ',')
				{
					paramSepLoc[j] = i;
					j++;
				}
			}
		}
		else
		{
			paramSepLoc[1] = 1;
		}

		String[] argText = new String[paramCount];

		//get substrings of all arguments, make life easier later
		if(paramCount == 1)
		{
			argText[0] = args;
		}
		else
		{
			for(int i = 0; i < paramCount; i++)
			{
				argText[i] = args.substring(paramSepLoc[i], paramSepLoc[i + 1]);
			}
		}

		PrecondensedParameter[] ps = new PrecondensedParameter[argText.length];

		for(int i = 0; i < ps.length; i++)
		{
			ps[i] = new PrecondensedParameter(argText[i]);
		}

		return ps;
		*/


	}



}
