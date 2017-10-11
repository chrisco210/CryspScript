package cf.rachlinski.cryspScript.prerun.parsing.line;

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
	private boolean isRoutine;

	/**
	 * Parameters of the keyword. <br>
	 * Parameters are surrounded by {@code {curly braces}}
	 * Parameters are seperated by {@code space}
	 */
	private String[] parameters;

	public Line(String line)
	{
		line = line.contains(";") ? line.substring(0, line.indexOf(";")) : line;		//Check for comments, don't read them if found

		isRoutine = line.charAt(0) == '_'; 		//Easy way to figure out if the line is specifying a routine, as they must appear first on the line

		keyword = line.substring(0, line.indexOf(" "));		//Get the name of the function or keyword

		line = line.substring(line.indexOf(" ")).trim();		//Remove the keyword to make working with parameters more easy


		//TODO Find way to best seperate parameters
		String[] paramList = line.split(" ");		//Seperate parameters
		parameters = new String[paramList.length];


	}

	/**
	 * Converts a line into an Executable command.  To do this it first evaluates variables from the Variable stack,
	 * then evaluates any functions.  If the line is only a routine, the routine is executed, otherwise, the keyword
	 * on the line is evaluated.
	 * @return an executable command
	 */
	public Executable parse()
	{

		return null;
	}

	private String evalVars(GlobalVariableMap map)
	{

	}
}
