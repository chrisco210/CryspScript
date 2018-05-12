package cf.rachlinski.cryspscript.prerun.parsing.line;

import cf.rachlinski.cryspscript.prerun.parsing.Except.IllegalKeywordException;
import cf.rachlinski.cryspscript.prerun.parsing.accessors.CommandXML;
import cf.rachlinski.cryspscript.prerun.parsing.line.parameters.PrecondensedParameter;
import cf.rachlinski.cryspscript.runtime.codeAccessors.Registers;
import cf.rachlinski.cryspscript.runtime.dataStructs.stack.ParameterStack;
import cf.rachlinski.cryspscript.runtime.dataStructs.variable.Variable;
import cf.rachlinski.cryspscript.runtime.exec.Executable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

/**
 * Class that represents an unparsed line
 */
public class Line
{
	/**
	 * Constant for the main function type of keywordText
	 */
	public static final int KEYWORD = 0;

	/**
	 * Constant for the main function type of subroutine
	 */
	public static final int SUBROUTINE = 1;

	/**
	 * Constant for the main function type of function
	 */
	public static final int FUNCTION = 2;

	/**
	 * Name of the keywordText (Or routine) that has been specified on the line
	 */
	private String keywordText;

	/**
	 * Specify if the thing that is being called is a routine.  If it is not, it must be a keywordText
	 */
	private int type;

	/**
	 * Parameters of the keywordText. <br>
	 * Parameters are surrounded by {@code {curly braces}}
	 * Parameters are separated by {@code ,}
	 */
	private PrecondensedParameter[] parameters;

	/**
	 * Contains the original, unparsed, text, so it can be supplied for exceptions
	 */
	private String origText;

	/**
	 * Construct a new line based on a string.  Most parsing takes place in the
	 * constructor, so the {@code parse()} method only reads an XML file
	 * @param line the string of text to turn into a line
	 */
	public Line(String line)
	{
		this.origText = line;
		//Check for comments, don't read them if found
		line = line.contains(";") ? line.substring(0, line.indexOf(';') - 1) : line;

		//Find what kind of thing the line is, be it keywordText, method, blah blah blah
		char mainType = line.charAt(0);
		switch(mainType)
		{
		case '_':
			type = SUBROUTINE;
			break;
		case '^':
			type = FUNCTION;
			break;
		default:
			type = KEYWORD;
			break;
		}

		if(type == KEYWORD)
		{
			keywordText = line.substring(0, line.indexOf('{')).trim();
		}
		else
		{
			keywordText = line.substring(1, line.indexOf('{')).trim();
		}

		//Remove the keywordText to make working with parameters more easy
		line = line.substring(line.indexOf('{')).trim();

		//Parse parameters
		parameters = new ParameterParser().parse(line);
	}

	public PrecondensedParameter[] getParameters()
	{
		return parameters;
	}

	public String getKeywordText()
	{
		return keywordText;
	}

	/**
	 * Converts a line into an Executable command.  To do this it first evaluates variables from the Variable stack,
	 * then evaluates any functions.  If the line is only a routine, the routine is executed, otherwise, the keywordText
	 * on the line is evaluated.
	 * @return an executable command
	 */
	public Executable parse()
	{

		String className = "noclassdef";

		try
		{
			className =  (String) XPathFactory.newInstance().newXPath().compile(
					"/commands/command[@name='" + keywordText + "']/class").evaluate(CommandXML.COMMANDS_XML, XPathConstants.STRING
			);
		}
		catch (XPathExpressionException e)
		{
			e.printStackTrace();
		}


		try {

			Constructor<?> con = Class.forName(className).getConstructor(ParameterStack.class);
			
			Variable<?>[] v = new Variable<?>[parameters.length];
			for(int i = 0; i < v.length; i++)
			{
				v[i] = parameters[i].valueOf();
			}
			
			return (Executable) con.newInstance(new ParameterStack(v));
		}
		catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | IllegalArgumentException | InstantiationException | IllegalAccessException | InvocationTargetException e)
		{
			e.printStackTrace();
			throw new IllegalKeywordException(this, Registers.r1.getValue());
		}
	}

	@Override
	public String toString()
	{
		return origText;
	}
}
