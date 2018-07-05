package cf.rachlinski.cryspscript.prerun.parsing.accessors;

import cf.rachlinski.cryspscript.runtime.dataStructs.stack.ParameterStack;
import cf.rachlinski.cryspscript.runtime.exec.Executable;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Map;

/**
 * Object representation of the command xml
 */
public class CommandList
{
	private Map<String, Constructor<?>> map;

	public CommandList() throws ParserConfigurationException, IOException, SAXException
	{
		Document document = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder()
				.parse(CommandList.class.getResourceAsStream("/commands.xml"));

		//List of child nodes of the document
		NodeList nodeList = document.getChildNodes();

		System.out.println(nodeList);
		for(int i = 0; i < nodeList.getLength(); i++)
		{
			Node n = nodeList.item(i);
			n.
		}
	}

	/**
	 * Get an instance of a keyword given the name of the keyword and the parameters
	 * @param keyName the name of the keyword
	 * @param parameters the parameters to supply to the keyword
	 * @return an instance of a keyword
	 */
	public Executable getInstance(String keyName, ParameterStack parameters)
	{

	}
}
