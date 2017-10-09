package cf.rachlinski.cryspScript.prerun.parsing.expression.parsers;

public abstract class Parser<E>
{
	/**
	 * Parse a string into a type specified by {@code E}
	 * @param args the string to parse
	 * @throws IllegalArgumentException if the expression cannot be parsed correctly
	 * @return a instance of the class specified by {@code E}
	 */
	public abstract E parse(String args);
}
