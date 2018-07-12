package cf.rachlinski.cryspscript.prerun.parsing.expression;

public class Operator
{
	private char operator;

	public Operator(char operator)
	{
		this.operator = operator;
	}

	public Object operate(Object left, Object right)
	{
		if(left instanceof String)
		{
			return ((String) left) + right;
		}
		else if(right instanceof String)
		{
			return left.toString() + right;
		}
		else if(left instanceof Double)
		{
			return ((Double) left) + (right instanceof Integer ? (Integer) right : (Double) right);
		}
		else
		{
			return left.toString() + right.toString();
		}

	}

	private Object doOp(Object left, Object right)
	{
		switch(operator)
		{
		case '+':
			if(left instanceof String)
			{
				return ((String) left) + right;
			}
			else if(right instanceof String)
			{
				return left.toString() + right;
			}
			else if(left instanceof Double)
			{
				return ((Double) left) + (right instanceof Integer ? (Integer) right : (Double) right);
			}
			else
			{
				return left.toString() + right.toString();
			}
		case '-':		//TODO;
			break;
		case '*':
			break;
		case '/':
			break;
		case '=':
			break;
		case '&':
			break;
		case '|':
			break;
		case '^':
			break;
		default:
			throw new UnsupportedOperationException("Operation " + operator + " is not supported.");

		}
		throw new UnsupportedOperationException("Operation " + operator + " is not supported.");
	}


}
