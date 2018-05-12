package cf.rachlinski.cryspscript.runtime.exec.method;

import cf.rachlinski.cryspscript.runtime.dataStructs.stack.ParameterStack;
import cf.rachlinski.cryspscript.runtime.dataStructs.stack.TypeStack;

/**
 * Exception thrown when a subroutine is supplied an illegal argument type
 */
public class IllegalMethodTypeException extends Error
{
	public IllegalMethodTypeException(TypeStack expected, ParameterStack received)
	{
		super("Invalid method parameter types supplied.\n Expected: " + expected + "Received: " + received.typesToString());
	}

	public IllegalMethodTypeException()
	{
		super("Invalid method parameter types supplied.");
	}

}
