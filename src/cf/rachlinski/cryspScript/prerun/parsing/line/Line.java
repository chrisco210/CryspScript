package cf.rachlinski.cryspScript.prerun.parsing.line;

import cf.rachlinski.cryspScript.prerun.parsing.line.parameters.PrecondensedParameter;
import cf.rachlinski.cryspScript.runtime.dataStructs.map.GlobalVariableMap;
import cf.rachlinski.cryspScript.runtime.exec.Executable;

import java.nio.CharBuffer;

/**
 * Class that represents an unparsed line
 */
public class Line
{
	/**
	 * Name of the keyword (Or routine) that has been specified on the line
	 */
	private String keyword;

	/**
	 * Specify if the thing that is being called is a routine.  If it is not, it must be a keyword
	 */
	private boolean isRoutine;

	/**
	 * Parameters of the keyword. <br>
	 * Parameters are surrounded by {@code {curly braces}}
	 * Parameters are separated by {@code ,}
	 */
	private PrecondensedParameter[] parameters;

	/**
	 * Construct a new line based on a string.  Most parsing takes place in the
	 * constructor, so the {@code parse()} method only reads an XML file
	 * @param line the string of text to turn into a line
	 */
	public Line(String line)
	{
		//Check for comments, don't read them if found
		line = line.contains(";") ? line.substring(0, line.indexOf(";") - 1) : line;



		//Remove the keyword to make working with parameters more easy
		line = line.substring(line.indexOf("{")).trim();

		//Parse parameters
		parameters = new ParameterParser().parse(line);
	}

	/**
	 * Converts a line into an Executable command.  To do this it first evaluates variables from the Variable stack,
	 * then evaluates any functions.  If the line is only a routine, the routine is executed, otherwise, the keyword
	 * on the line is evaluated.
	 * @return an executable command
	 */
	public Executable parse()
	{
		//TODO XML FILE PARSER
		return null;
	}
}
