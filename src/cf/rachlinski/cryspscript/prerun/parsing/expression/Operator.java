package cf.rachlinski.cryspscript.prerun.parsing.expression;


import org.apache.commons.lang3.SystemUtils;
import org.scijava.nativelib.NativeLoader;

import java.io.IOException;

/**
 * Enum containing operators
 */
public enum Operator implements ExpressionComponent
{


	MUL,
	DIV,
	MOD,
	ADD,
	SUB,
	NATIVE_ADD;

	private native int add(int a, int b);
	private native int sub(int a, int b);
	private native int mul(int a, int b);
	private native int div(int a, int b);
	private native int mod(int a, int b);

	//Boolean to allow JNI operators instead of java ones.
	private static boolean ALLOW_JNI_OPS = false;

	static
	{
		if(SystemUtils.IS_OS_WINDOWS)
		{
			ALLOW_JNI_OPS = true;
			try
			{
				NativeLoader.loadLibrary("Operator");
			}
			catch (IOException e)
			{
				//If you get  here, we have gone terribly wrong
				e.printStackTrace();
			}
		}
	}

	/**
	 * Perform the operation specified by the enum
	 * @param a the first number to operate on
	 * @param b the second number to operate on
	 * @return the result of the operation specified given int a and b
	 */
	public int op(int a, int b)
	{
		switch(this)
		{
		case ADD:
			return a + b;
		case SUB:
			return a - b;
		case MUL:
			return a * b;
		case DIV:
			return a / b;
		case MOD:
			return a % b;
		case NATIVE_ADD:
			return add(a, b);
		}

		throw new RuntimeException("Case not found.");
	}

	public int type()
	{
		return ExpressionComponent.OPERATOR;
	}


	@Override
	public String toString()
	{
		switch(this)
		{
		case ADD:
			return "+";
		case SUB:
			return "-";
		case MUL:
			return "*";
		case DIV:
			return "/";
		case MOD:
			return "%";
		}
		return "not found";
	}
}
