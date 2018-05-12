package cf.rachlinski.cryspscript.runtime.exec.method.funcEval;

import cf.rachlinski.cryspscript.prerun.parsing.expression.Evaluable;
import cf.rachlinski.cryspscript.runtime.dataStructs.variable.InstructionPointer;
import cf.rachlinski.cryspscript.runtime.exec.method.Subroutine;

public class Function extends Subroutine implements Evaluable
{

	public Function(InstructionPointer startPtr, InstructionPointer returnPtr)
	{
		super(startPtr, returnPtr);
	}


	@Override
	public int eval()
	{
		return 0;
	}
}
