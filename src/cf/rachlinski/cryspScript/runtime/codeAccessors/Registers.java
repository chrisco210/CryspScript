package cf.rachlinski.cryspScript.runtime.codeAccessors;

import cf.rachlinski.cryspScript.runtime.dataStructs.variable.Register;

/**
 * Class containing static general and specific purpose registers
 */
public final class Registers
{
	/**
	 * Prevent registers from being instantiated
	 */
	private Registers() { }

	/**
	 * Register used for return values
	 */
	public static Register r0 = new Register(0);

	/**
	 * Register used for the instruction pointer
	 */
	public static Register r1 = new Register(0);

	/**
	 * Register used for the return instruction pointer
	 */
	public static Register r2 = new Register(0);

	/**
	 * Not yet implemented
	 */
	public static Register r3 = new Register(0);

	/**
	 * Not yet implemented
	 */
	public static Register r4 = new Register(0);

	/**
	 * Not yet implemented
	 */
	public static Register r5 = new Register(0);

	/**
	 * Not yet implemented
	 */
	public static Register r6 = new Register(0);

	/**
	 * Not yet implemented
	 */
	public static Register r7 = new Register(0);


}
