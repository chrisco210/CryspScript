package cf.rachlinski.cryspScript.runtime.dataStructs.stack;

import cf.rachlinski.cryspScript.prerun.parsing.line.Line;
import cf.rachlinski.cryspScript.runtime.codeAccessors.Registers;
import cf.rachlinski.cryspScript.runtime.dataStructs.variable.InstructionPointer;
import cf.rachlinski.cryspScript.runtime.exec.Executable;

public class ExecutionStack extends Stack<Line>
{
	/**
	 * Construct a new Stack object given contents
	 *
	 * @param contents the array of {@code Variable<?>}s to initialize
	 */
	public ExecutionStack(Line[] contents)
	{
		super(contents);
	}

	/**
	 * Return an instruction pointer to the next occurrence of the specified value
	 * @param instruction the {@code Class} object corresponding to the next instruction
	 * @return an InstructionPointer to the next occurrence of the specified instruction
	 */
	public InstructionPointer getNextOccurenceOf(Class<?> instruction)
	{
		int occurrence = -1;
		for(int i = Registers.r1.getValue(); i < contents.length; i++)
		{
			if(contents[i].equals(instruction))		//TODO possible bug here
			{
				occurrence = i;
				break;
			}
		}
		
		return new InstructionPointer(occurrence);
	}

	/**
	 * Execute the instruction at the current instruction pointer, specified by {@code Registers.r1}, and increment
	 * the instruction pointer by 1
	 */
	public void exec()
	{
		contents[Registers.r1.getValue()].parse().run();
		Registers.r1.inc();
	}
}
