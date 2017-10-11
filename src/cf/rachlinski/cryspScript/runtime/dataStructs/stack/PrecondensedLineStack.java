package cf.rachlinski.cryspScript.runtime.dataStructs.stack;

import cf.rachlinski.cryspScript.prerun.parsing.line.Line;
import cf.rachlinski.cryspScript.runtime.codeAccessors.Registers;
import cf.rachlinski.cryspScript.runtime.exec.Executable;

public class PrecondensedLineStack extends Stack<Executable>
{
	private Line[] lines;

	/**
	 * Construct a new Stack object given contents
	 *
	 * @param contents the array of {@code Variable<?>}s to initialize
	 */
	public PrecondensedLineStack(Executable[] contents)
	{
		super(contents);
	}

	/**
	 * Increment the instruction pointer
	 */
	public void parse()
	{
		Registers.r1.update(Registers.r1.getValue() + 1);
	}
}
