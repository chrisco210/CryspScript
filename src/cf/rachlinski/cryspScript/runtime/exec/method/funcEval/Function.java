package cf.rachlinski.cryspScript.runtime.exec.method.funcEval;

import cf.rachlinski.cryspScript.prerun.parsing.expression.Evaluable;
import cf.rachlinski.cryspScript.runtime.dataStructs.variable.InstructionPointer;
import cf.rachlinski.cryspScript.runtime.exec.method.Subroutine;

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
