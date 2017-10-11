package cf.rachlinski.cryspScript.runtime.dataStructs.variable;

import cf.rachlinski.cryspScript.runtime.codeAccessors.Registers;

public class InstructionPointer extends Variable<Integer>
{
	/**
	 * Construct a new variable of given type
	 *
	 * @param val the value of the new variable
	 */
	public InstructionPointer(Integer val)
	{
		super(val);
	}

	/**
	 * Jump to the specified return address
	 */
	public void jumpTo()
	{
		Registers.r1.update(value);
	}
}
