package cf.rachlinski.cryspscript.prerun.parsing.operation;


@FunctionalInterface
public interface Operator
{
	Number op(Number a, Number b);

}
