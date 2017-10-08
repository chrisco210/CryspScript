package cf.rachlinski.cryspScript.runtime.exec.baseCommands;

public class Command
{
	private String[] args;

	public Command(String args)
	{
		this.args = args.split(" ");
	}
}
