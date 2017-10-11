package cf.rachlinski.cryspScript.runtime.exec.method;

import cf.rachlinski.cryspScript.runtime.dataStructs.stack.PrecondensedLineStack;
import cf.rachlinski.cryspScript.runtime.dataStructs.variable.InstructionPointer;

/**
 * Superclass for functions and routines
 */
public class Subroutine
{
	/**
	 * Location to return to after the sub has completed
	 */
	private InstructionPointer returnLoc;

	/**
	 * Location of the top of the function
	 */
	private InstructionPointer entryLoc;

	public Subroutine(InstructionPointer startPtr, InstructionPointer returnPtr)
	{
		entryLoc = startPtr;
		returnLoc = returnPtr;
	}
}
