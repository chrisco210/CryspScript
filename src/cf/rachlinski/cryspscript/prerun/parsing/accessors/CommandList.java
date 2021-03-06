package cf.rachlinski.cryspscript.prerun.parsing.accessors;

import cf.rachlinski.cryspscript.runtime.dataStructs.stack.ParameterStack;
import cf.rachlinski.cryspscript.runtime.exec.Executable;
import cf.rachlinski.cryspscript.runtime.exec.keyword.Runnable;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Object representation of the keyword name to fully qualified class name association based on
 * a command xml or included annotations
 */
public class CommandList
{
	private Map<String, Constructor<?>> map;

	/**
	 * Construct a CommandList using annotations included in the classes
	 */
	public CommandList()
	{
		map = new HashMap<>();

		try (ScanResult scanResult = new ClassGraph().enableAllInfo().whitelistPackages("cf.rachlinski.cryspscript.runtime.exec.keyword.defaultkeywords").scan())
		{

			ClassInfoList scanRes = scanResult.getClassesWithAnnotation(Runnable.class.getName());

			List<Class<?>> matches = scanRes.loadClasses();

			matches.forEach((match) -> {
				try
				{
					map.put(
							match.getAnnotation(Runnable.class).value(),
							match.getConstructor(ParameterStack.class)
					);
				}
				catch (NoSuchMethodException e)
				{
					System.err.println("Annotated class does not match expected model.");
					e.printStackTrace();		//TODO
				}
			});
		}


	}

	/**
	 * Construct a CommandList given an input stream for the xml file
	 * <br>use of{@code @Runnable} annotation is preferable to xml files
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 */
	public CommandList(InputStream xmlStream) throws ParserConfigurationException, IOException, SAXException
	{
		Document document = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder()
				.parse(xmlStream);

		//List of child nodes of the document
		NodeList nodeList = document.getChildNodes();

		System.out.println(nodeList);
		for(int i = 0; i < nodeList.getLength(); i++)
		{
			Node n = nodeList.item(i);
			NamedNodeMap attribs = n.getAttributes();
			Constructor<?> constructor = null;
			try
			{
				constructor = Class.forName(attribs.getNamedItem("class").getTextContent()).getConstructor(ParameterStack.class);
			}
			catch (NoSuchMethodException e)
			{
				e.printStackTrace();
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}

			if(constructor != null)
			{
				map.put(attribs.getNamedItem("name").getTextContent(), constructor);
			}
		}
	}

	/**
	 * Get an instance of a keyword given the name of the keyword and the parameters
	 * @param keyName the name of the keyword
	 * @param parameters the parameters to supply to the keyword
	 * @return an instance of a keyword
	 */
	public Executable getInstance(String keyName, ParameterStack parameters) throws IllegalAccessException, InvocationTargetException, InstantiationException
	{
		return (Executable) map.get(keyName).newInstance(parameters);
	}
}
