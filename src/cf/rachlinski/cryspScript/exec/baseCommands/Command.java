package cf.rachlinski.cryspScript.exec.baseCommands;

public class Command
{
	private String[] args;

	public Command(String args)
	{
		this.args = args.split(" ");
	}
}
