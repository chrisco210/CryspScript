package cf.rachlinski.cryspscript.prerun.parsing.expression.types;

public class IntegerType extends Type<Integer> implements Type.BasicMath<IntegerType>, Type.Comparisons<IntegerType, Boolean>
{
	public IntegerType(Integer value)
	{
		super(value);
	}

	@Override
	public IntegerType add(IntegerType o)
	{
		return new IntegerType(value + o.value);
	}

	@Override
	public IntegerType sub(IntegerType o)
	{
		return new IntegerType(value - o.value);
	}

	@Override
	public IntegerType mult(IntegerType o)
	{
		return new IntegerType(value * o.value);
	}

	@Override
	public IntegerType div(IntegerType o)
	{
		return new IntegerType(value / o.value);
	}

	@Override
	public IntegerType mod(IntegerType o)
	{
		return new IntegerType(value % o.value);
	}

	@Override
	public Boolean eq(IntegerType o)
	{
		return null;
	}

	@Override
	public Boolean lt(IntegerType o)
	{
		return null;
	}

	@Override
	public Boolean gt(IntegerType o)
	{
		return null;
	}

	@Override
	public Boolean lteq(IntegerType o)
	{
		return null;
	}
}
