package cf.rachlinski.cryspscript.prerun.parsing.line;

import cf.rachlinski.cryspscript.prerun.parsing.Parser;
import cf.rachlinski.cryspscript.runtime.exec.keyword.Keyword;


public class CommandParser extends Parser<Keyword>
{

	@Override
	public Keyword parse(String args)
	{
		String reqCommand = "";
		//TODO this

		return null;
	}

	/**
	 * Factory to create a command based on user input
	 * @param text The text to decide what command to create
	 * @return A PrecondensedCommand of the desired type, based on command precedence.  If an unrecognized command is entered, a REM command will be returned
	 */
	/*
	public void createCommand(String text)
	{

		//The name of the command requested (Which should be the first thing they typed
		String nameCommandRequested = text.split(" ")[0];

		//There should be no exception thrown here, as the file we are reading is a resource.
		Document doc = null;
		try {
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(CommandParser.class.getResourceAsStream("/resources/commands.xml"));
		}
		catch(Exception e)
		{

		}

		//Get a list of all the command nodes
		NodeList n = doc.getElementsByTagName("command");

		//This is where the desired node will be stored
		String className = "";

		//Use XPath to get the contents of the class node
		try
		{
			className =  (String) XPathFactory.newInstance().newXPath().compile(
					"/commands/command[@name='" + nameCommandRequested + "']/class").evaluate(doc, XPathConstants.STRING
			);
		}
		catch (XPathExpressionException e)
		{
			e.printStackTrace();
		}



		try		//Attempt to return the precondensed command
		{
			//return Class.forName(className).getConstructor(String.class).newInstance(text);
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
			System.err.println("Failed to instantiate the PrecondensedCommand. You should have a constructor that accepts the arguments String.");
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch (InvocationTargetException e)
		{
			e.printStackTrace();
			System.err.println("Error in creating PrecondensedCommand. Your constructor signature should not throw any exceptions.");
		}
		catch (NoSuchMethodException e)
		{
			e.printStackTrace();
			System.err.println("Your PrecondensedCommand is missing the correct constructor.  You should have constructor ClassName(String s)");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			System.err.println("Error parsing commands.xml.  Incorrect class name.  Ensure you have typed the fully qualified name of a precondensed command");
		}


	}
		*/

}