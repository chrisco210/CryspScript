package cf.rachlinski.cryspScript.exec;

/**
 * Executable commands implement this interface
 */
public interface Executable
{
	/**
	 *
	 * @param text
	 */
	void parse(String text);

	/**
	 * Run the command
	 */
	void run();
}
