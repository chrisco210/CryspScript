package cf.rachlinski.cryspscript.runtime.exec.keyword;

public class UnmatchedNestException extends Error
{
	public UnmatchedNestException(String start, String finding)
	{
		super("Could not find the matching " + finding + " for " + start);
	}
}
