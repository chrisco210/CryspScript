package cf.rachlinski.cryspscript.runtime.dataStructs.map;

/**
 * HashMap Containing global variables
 * Variables contained in this class are accessable globally,
 */
public class GlobalVariableMap extends Map<String>
{

	/**
	 * De allocate a variable from the variable contents
	 * @param name the name of the variable to free
	 */
	public void free(String name)
	{
		contents.remove(name);
	}
}