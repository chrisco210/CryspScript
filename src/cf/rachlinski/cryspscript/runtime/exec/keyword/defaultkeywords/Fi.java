package cf.rachlinski.cryspscript.runtime.exec.keyword.defaultkeywords;

import cf.rachlinski.cryspscript.control.ScriptEngine;
import cf.rachlinski.cryspscript.runtime.codeAccessors.Registers;
import cf.rachlinski.cryspscript.runtime.dataStructs.stack.ParameterStack;
import cf.rachlinski.cryspscript.runtime.dataStructs.stack.TypeStack;
import cf.rachlinski.cryspscript.runtime.exec.keyword.EndNestingKeyword;
import cf.rachlinski.cryspscript.runtime.exec.keyword.Runnable;
import cf.rachlinski.cryspscript.runtime.exec.method.IllegalMethodTypeException;

@Runnable("fi")
public class Fi extends EndNestingKeyword
{
	private static final TypeStack EXPECTED_TYPES = new TypeStack(new Class<?>[] {});
	
	public Fi(ParameterStack args) throws IllegalMethodTypeException 
	{
		super(args);
	}

	@Override
	public void run() 
	{
		super.run();
	}
}

