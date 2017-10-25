package cf.rachlinski.cryspScript.runtime.dataStructs.stack;

import cf.rachlinski.cryspScript.runtime.dataStructs.variable.InstructionPointer;
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
	
	public InstructionPointer getNextOccurenceOf(Class<?> instruction)
	{
		int occurrence = -1;
		for(int i = 0; i < contents.length; i++)
		{
			if(contents[i].equals(instruction))
			{
				occurrence = i;
				break;
			}
		}
		
		return new InstructionPointer(occurrence);
	}
}
