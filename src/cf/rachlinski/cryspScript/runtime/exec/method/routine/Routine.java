package cf.rachlinski.cryspScript.runtime.exec.method.routine;

import cf.rachlinski.cryspScript.runtime.dataStructs.variable.InstructionPointer;
import cf.rachlinski.cryspScript.runtime.exec.method.Subroutine;

public class Routine extends Subroutine
{
	public Routine(InstructionPointer startPtr, InstructionPointer returnPtr)
	{
		super(startPtr, returnPtr);
	}
}
