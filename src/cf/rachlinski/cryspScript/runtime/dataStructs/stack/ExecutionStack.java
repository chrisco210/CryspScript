package cf.rachlinski.cryspScript.runtime.dataStructs.stack;

import cf.rachlinski.cryspScript.runtime.exec.Executable;

public class ExecutionStack extends Stack<Executable>
{
	/**
	 * Construct a new Stack object given contents
	 *
	 * @param contents the array of {@code Variable<?>}s to initialize
	 */
	public ExecutionStack(Executable[] contents)
	{
		super(contents);
	}
}
