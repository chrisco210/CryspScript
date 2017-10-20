package cf.rachlinski.cryspScript.runtime.exec.method;

import cf.rachlinski.cryspScript.runtime.codeAccessors.Registers;
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

	/**
	 * Construct a Subroutine with a specific starting point and return location. 
	 * If you wish to return to the line after the method call, you should add 1 to the 
	 * value of returnPointer
	 * @param startPtr the start location of the function
	 * @param returnPtr the location to return to
	 */
	public Subroutine(InstructionPointer startPtr, InstructionPointer returnPtr)
	{
		entryLoc = startPtr;
		returnLoc = returnPt;
	}
	
	/**
	 * Jump to the location specified by returnLoc
	 * This will update the value of {@code %r1} to be the return location
	 */
	public void ret()
	{
		returnLoc.jumpTo();
	}
}
