package cf.rachlinski.cryspScript.runtime.dataStructs.stack;

import cf.rachlinski.cryspScript.prerun.parsing.line.Line;
import cf.rachlinski.cryspScript.runtime.codeAccessors.Registers;
import cf.rachlinski.cryspScript.runtime.dataStructs.variable.InstructionPointer;

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
	 * Return an instruction pointer to the next occurrence of the specified value, accounting for nested statements
	 * @param instruction the {@code Class} object corresponding to the next instruction
	 * @return an InstructionPointer to the next occurrence of the specified instruction
	 */
	public InstructionPointer getNextOccNest(Class<?> instruction)
	{
		//TODO Account for nested if and for and any other user added
		int occurrence = -1;
		for(int i = Registers.r1.getValue(); i < contents.length; i++)
		{
			if(contents[i].parse().getClass().equals(instruction))
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
		if(Registers.r1.getValue() >= contents.length)
			return;
		contents[Registers.r1.getValue()].parse().run();
		Registers.r1.inc();
	}
}
