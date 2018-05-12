package cf.rachlinski.cryspscript.runtime.dataStructs.variable;

/**
 * A mutable version of the variable class with an integer value.  This class is ideal for storing constants
 * throughout the entire script, IE the current instruction, the return pointer, return values, etc
 */
public class Register extends Variable<Integer>
{

	/**
	 * Construct a new variable of given type
	 *
	 * @param val the value of the new variable
	 */
	public Register(Integer val)
	{
		super(val);
	}

	/**
	 * Update the value of the register
	 * @param val the integer to update the value to
	 */
	public void update(Integer val)
	{
		value = val;
	}

	/**
	 * Increment the value of the register
	 */
	public void inc()
	{
		this.value++;
	}

	/**
	 * Decrement the value of the register
	 */
	public void dec()
	{
		this.value--;
	}

	/**
	 * Copy the value of another register into this register
	 * @param r the register to add the value to
	 */
	public void copyReg(Register r)
	{
		value = r.getValue();
	}
}
