package cf.rachlinski.cryspscript.runtime.exec.keyword.defaultkeywords;

import cf.rachlinski.cryspscript.runtime.codeAccessors.Registers;
import cf.rachlinski.cryspscript.runtime.dataStructs.stack.ParameterStack;
import cf.rachlinski.cryspscript.runtime.dataStructs.variable.InstructionPointer;
import cf.rachlinski.cryspscript.runtime.exec.keyword.Keyword;
import cf.rachlinski.cryspscript.runtime.exec.keyword.Runnable;
import cf.rachlinski.cryspscript.runtime.exec.method.IllegalMethodTypeException;

@Runnable("jmp")
public class Jump extends Keyword
{
	public Jump(ParameterStack args) throws IllegalMethodTypeException
	{
		super(args);
	}

	@Override
	public void run()
	{
		new InstructionPointer((Integer) args.get(0).getValue()).jumpTo();
	}
}
