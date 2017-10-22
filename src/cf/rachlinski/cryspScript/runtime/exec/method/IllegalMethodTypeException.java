package cf.rachlinski.cryspScript.runtime.exec.method;

import cf.rachlinski.cryspScript.runtime.dataStructs.stack.ParameterStack;
import cf.rachlinski.cryspScript.runtime.dataStructs.stack.TypeStack;

/**
 * Exception thrown when a subroutine is supplied an illegal argument type
 */
public class IllegalMethodTypeException extends Error
{
	public IllegalMethodTypeException(TypeStack expected, ParameterStack received)
	{
		super("Invalid method parameter types supplied. Expected: " + expected + "Received: " + received.typesToString());
	}

	public IllegalMethodTypeException()
	{
		super("Invalid method parameter types supplied.");
	}

}
