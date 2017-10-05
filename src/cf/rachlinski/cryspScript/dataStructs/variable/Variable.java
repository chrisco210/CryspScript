package cf.rachlinski.cryspScript.dataStructs.variable;

public class Variable<E>
{
	private E value;

	public Variable(E val)
	{
		this.value = val;
	}

	public E getValue()
	{
		return value;
	}
}
