# CryspScript

# Syntax
## Basics
Each line contains one command, function call, or keyword.  Comments can be indicated with a ; (semicolon), which causes the parser to ignore the rest of the line.

Expressions should be surrounded by (parenthesis), indicating that they should be evaluated.  Innermost parenthesis are evaluated first, then order of operations is followed. (*, /, %, +, \-).

## Functions vs Routines
CryspScript distinguishes between functions and routines with the return type, routines have no return type, while functions have a return type. Functions are declared with the func keyword, and delimited using cnuf.  Routines are declared with the rout keyword, and delimited with tour.  Functions can be called to be evaluated with the ^ operator, while routines are called with the _ operator, and should be the only command on the line.  Functions store their return type in the %r0 register, and can be called with the call keyword.  Routines can also be called with call, however, nothing will be written to the %r0 register.  

### Constants and Literals
Number constants can be denoted using just numbers

String literals should be denoted using "double quotes"

Boolean literals are defined by the constants $_TRUE and $_FALSE, which are equal to 1 and 0 respectively.

There are no object literals yet

### Operators
..* Addition +
..* Subtration -
..* Mutiplcation *
..* Division /
..* Modulus %
..* Call Routine _
..* Call Function ^
..* Access Variable Value $
..* Specify Register %
..* Logical Equals =
..* Logical Not !
..* Logical Greater Than >
..* Logical Greater Than or Equal To >=
..* Logical Less Than <
..* Logical Less Than or Equal To <=
..* Logical And &&
..* Logical Or ||
..* Logical XOR ^^

### Keywords Reference
#### Control Flow
if { Boolean Expression } ... fi 

Execute a block of code if the condition inside the {brackets} is true.  Block is delimited by fi.

else ... esle

Execute a block of code if the condition in the last if statement was not true

while { Boolean Expression } ... elihw

Execute a block of code while the condition inside the {brackets} is true.

whileiter { varname, Boolean Expression } ..reti

Execute a block of code while the condition inside the second argument is true.  

#### Functions
func rtype name {type param1, type param2 ...} ... cnuf

Declare a function with name name, and parameters of specified type, delimited with cnuf, and with return type of rtype

rout name {type param1, type param2 ... } ... tour

Declare a routine with name name, and parameters of type param1 ..., delimited with tour

#### Variable Decl.
var {type, name}

Declare a variable with type type, and name name.  Variable names can contain letters and numbers, but cannot be just numbers.  To declare an object type (Not yet implemented) include type Object and the fully qualified class name.  

set {name, value}

Set the value of variable name

ret {val}

Return a value from a function

#### Low Level Commands
These commands are used by the parser to call functions, setup stacks, set variables, etc

call {name}

Calls the routine/function of the given name

retj 

Jumps to the return location of the function

sreg {regname, val}

Set the value of a register to a given value

decl {type, name}

Declare a variable of name name, and type type

set {name, val}

Update the value of a variable

jmp {loc}

Jump to a location in the script.  To get the location of a label call lbllookup, which returns the line number of the label

:: lblname

Mark a label in the code.  This will be added to the lbllookup index, and will be removed before runtime, resulting in an effective label location of n + 1

DISPLICENSE

Write the copy of the MIT license that should have been included in your copy of CryspScript to stdout.  If no license is found, a link will be provided to find one.
