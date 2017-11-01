package cf.rachlinski.cryspScript.prerun.parsing.line;

import java.io.File;
import java.io.IOException;

/**
 * Class representing a pre execution script, containing raw text,
 * as well as methods to find certain features, IE method calls, all variables, etc
 */
public class ScriptFile
{
	/*
	TODO Write this class
	 */
	/**
	 * Construct a ScriptFile given an array representing the lines of file
	 * @param lines the lines to store
	 */
	public ScriptFile(String[] lines)
	{
		//TODO constructors for this class
	}

	/**
	 * Construct an ScriptFile representing the lines of file with a  file
	 * @param f the file to read
	 * @throws IOException if an error is encountered in reading the file
	 */
	public ScriptFile(File f) throws IOException
	{

	}

	/**
	 * Construct a ScriptFile representing the lines of a file with a path to a file <br>
	 * This constructor is identical to the File constructor
	 * @param path the path of the file to read
	 * @throws IOException if an error is encountered in reading the file
	 */
	public ScriptFile(String path) throws IOException
	{

	}
}
