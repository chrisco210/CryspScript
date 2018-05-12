package cf.rachlinski.cryspscript.runtime.exec.method.routine;

import cf.rachlinski.cryspscript.runtime.dataStructs.variable.InstructionPointer;
import cf.rachlinski.cryspscript.runtime.exec.method.Subroutine;

public class Routine extends Subroutine
{
	public Routine(InstructionPointer startPtr, InstructionPointer returnPtr)
	{
		super(startPtr, returnPtr);
	}
}
