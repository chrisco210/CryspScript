package cf.rachlinski.cryspscript.runtime.dataStructs.stack;

import cf.rachlinski.cryspscript.prerun.parsing.line.Line;
import cf.rachlinski.cryspscript.runtime.codeAccessors.Registers;
import cf.rachlinski.cryspscript.runtime.dataStructs.variable.InstructionPointer;
import cf.rachlinski.cryspscript.runtime.dataStructs.variable.Register;
import cf.rachlinski.cryspscript.runtime.exec.keyword.UnmatchedNestException;

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
	public InstructionPointer getNextOccNest(String instruction)
	{
		int occurrence = -1;
		int nesting = 0;		//Represents how deep in a region we are

		String start = contents[Registers.r1.getValue()].getKeywordText();


		for(int i = Registers.r1.getValue() + 1; i < contents.length; i++)
		{
			if((nesting == 0) && contents[i].getKeywordText().equals(instruction))
			{
				occurrence = i;
				break;
			}
			if(contents[i].getKeywordText().equals(start))		//Increase nesting level if another statement is added
			{
				nesting++;
			}
			else if(contents[i].getKeywordText().equals(instruction))		//Decrease nesting level if a closing statement is added
			{
				nesting--;
			}
		}

		if(occurrence != -1)
		{
			return new InstructionPointer(occurrence);
		}

		throw new UnmatchedNestException(start, instruction);
	}

	public boolean finished()
	{
		return Registers.r1.getValue() >= contents.length;
	}



	/**
	 * Execute the instruction at the current instruction pointer, specified by {@code Registers.r1}, and increment
	 * the instruction pointer by 1
	 */
	public void exec()
	{
		if(Registers.r1.getValue() >= contents.length)
			return;

		System.out.println("Contents:" + contents[Registers.r1.getValue()]);
		System.out.println("Contents:" + contents[Registers.r1.getValue()].parse());
		contents[Registers.r1.getValue()].parse().run();
		Registers.r1.inc();
	}
}
