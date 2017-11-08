package cf.rachlinski.cryspScript.prerun.parsing.line;

import cf.rachlinski.cryspScript.prerun.parsing.accessors.CommandXML;
import cf.rachlinski.cryspScript.prerun.parsing.line.parameters.PrecondensedParameter;
import cf.rachlinski.cryspScript.runtime.dataStructs.map.GlobalVariableMap;
import cf.rachlinski.cryspScript.runtime.dataStructs.stack.ParameterStack;
import cf.rachlinski.cryspScript.runtime.dataStructs.variable.Variable;
import cf.rachlinski.cryspScript.runtime.exec.Executable;
import cf.rachlinski.cryspScript.runtime.exec.keyword.Print;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.CharBuffer;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.NodeList;

/**
 * Class that represents an unparsed line
 */
public class Line
{
	/**
	 * Constant for the main function type of keyword
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
	 * Name of the keyword (Or routine) that has been specified on the line
	 */
	private String keyword;

	/**
	 * Specify if the thing that is being called is a routine.  If it is not, it must be a keyword
	 */
	private int type;

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

		//Find what kind of thing the line is, be it keyword, method, blah blah blah
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
			keyword = line.substring(0, line.indexOf("{")).trim();
		}
		else
		{
			keyword = line.substring(1, line.indexOf("{")).trim();
		}

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

		String className = "noclassdef";
		System.out.println(keyword);
		try
		{
			className =  (String) XPathFactory.newInstance().newXPath().compile(
					"/commands/command[@name='" + keyword + "']/class").evaluate(CommandXML.COMMANDS_XML, XPathConstants.STRING
			);
		}
		catch (XPathExpressionException e)
		{
			//TODO handle exception
		}
		
		try {
			System.out.println(className);
			Constructor<?> con = Class.forName(className).getConstructor(ParameterStack.class);
			
			Variable<?>[] v = new Variable<?>[parameters.length];
			
			for(int i = 0; i < v.length; i++)
			{ 
				v[i] = parameters[i].valueOf();
			}
			
			return (Executable) con.newInstance(new ParameterStack(v));
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | IllegalArgumentException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Print(new ParameterStack(new Variable<?>[] {new Variable<String>("ClassNotFound")}));
	}
}
