package cf.rachlinski.cryspscript.runtime.codeAccessors;

import cf.rachlinski.cryspscript.runtime.dataStructs.variable.Register;

/**
 * Class containing static general and specific purpose registers
 */
public final class Registers
{
	/**
	 * Prevent registers from being instantiated
	 */
	//private Registers() { }

	static
	{
		r0 = new Register(0);
		r1 = new Register(0);
	}

	/**
	 * Register used for return values
	 */
	public static final Register r0;

	/**
	 * Register used for the instruction pointer
	 */
	public static final Register r1;

	/**
	 * Register used for the return instruction pointer
	 */
	public static final Register r2 = new Register(0);

	/**
	 * Register used to represent the depth of nesting at the current instruction ({@code r1})
	 */
	public static final Register r3 = new Register(0);

	/**
	 * Not yet implemented
	 */
	public static final Register r4 = new Register(0);

	/**
	 * Not yet implemented
	 */
	public static final Register r5 = new Register(0);

	/**
	 * Not yet implemented
	 */
	public static final Register r6 = new Register(0);

	/**
	 * Not yet implemented
	 */
	public static final Register r7 = new Register(0);


}