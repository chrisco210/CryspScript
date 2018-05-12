package cf.rachlinski.cryspscript.runtime.exec.keyword;

import cf.rachlinski.cryspscript.runtime.dataStructs.stack.ParameterStack;
import cf.rachlinski.cryspscript.runtime.dataStructs.stack.TypeStack;
import cf.rachlinski.cryspscript.runtime.exec.Executable;
import cf.rachlinski.cryspscript.runtime.exec.method.IllegalMethodTypeException;

/**
 * Represents an executable command
 */
public abstract class Keyword implements Executable
{
	/**
	 * A type stack containing the correct method parameter types
	 * @deprecated
	 */
	public static TypeStack EXPECTED_TYPES;

	protected ParameterStack args;

	/**
	 * Construct a command given arguments
	 * @param args the arguments to supply
	 * @param correctArgs the arguments to
	 * @throws IllegalMethodTypeException if the number of parameters supplied does not match the argument count
	 */
	public Keyword(ParameterStack args, TypeStack correctArgs) throws IllegalMethodTypeException
	{
		this.args = args;

		if(!validateArgs(correctArgs))
			throw new IllegalMethodTypeException(correctArgs, args);
	}

	/**
	 * Construct a command given arguments
	 * @param args the arguments to supply
	 * @throws IllegalMethodTypeException if the number of parameters supplied does not match the argument count
	 */
	public Keyword(ParameterStack args) throws IllegalMethodTypeException
	{
		this.args = args;
	}

	/**
	 * Return true if a {@code Keyword} object is represents the same type of command as this object
	 * @param obj the object to compare to
	 * @return if a {@code Keyword} object is represents the same type of command as this object
	 */
	public boolean equals(Keyword obj)
	{
		return this.getClass().equals(obj.getClass());
	}


	/**
	 * Return true if a {@code Keyword} object is represents the same type of command as this object
	 * @param obj the object to compare to
	 * @return if a {@code Keyword} object is represents the same type of command as this object
	 */
	public boolean equals(Class<?> obj)
	{
		return this.getClass().equals(obj);
	}

	/**
	 * Validate if the arguments supplied are of the correct type
	 * @param against the TypeStack to validate against
	 * @return if the arguments are of the correct type
	 */
	protected final boolean validateArgs(TypeStack against)
	{
		return against.compareTypes(args);
	}
}
