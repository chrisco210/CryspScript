package cf.rachlinski.cryspscript.prerun.parsing.accessors;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;

/**
 *
 */
public class CommandXML
{
	/**
	 * XML Document representing the commands to use
	 */
	public static Document COMMANDS_XML;


	/*
	TODO Make this class expandable to any number of xml files, in any location in any project.
	 */
	static
	{
		try
		{
			COMMANDS_XML = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder()
             					.parse(CommandXML.class.getResourceAsStream("/commands.xml"));
		}
		catch (Exception e)		//TODO make exception type more broad, try multi catch?
		{
			System.err.println("Error! AOIJFIJKSDRFIGSDFGHSDFIG");
			e.printStackTrace();
		}

	}

}
