package cf.rachlinski.cryspscript.prerun.parsing.line.parameters;

public class PrecondensedMethodParameter extends PrecondensedParameter
{
	public PrecondensedMethodParameter(String value) 
	{
		super(value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isMethod()
	{
		return true;
	}
}
