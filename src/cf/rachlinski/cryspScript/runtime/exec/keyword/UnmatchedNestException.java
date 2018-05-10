package cf.rachlinski.cryspScript.runtime.exec.keyword;

public class UnmatchedNestException extends Error
{
	public UnmatchedNestException(String start, String finding)
	{
		super("Could not find the matching " + finding + " for " + start);
	}
}
