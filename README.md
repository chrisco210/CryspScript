# CryspScript

# Syntax
## Basics
Each line contains one command, function call, or keyword.  Comments can be indicated with a ; (semicolon), which causes the parser to ignore the rest of the line.

Expressions should be surrounded by (parenthesis), indicating that they should be evaluated.  Innermost parenthesis are evaluated first, then order of operations is followed. (*, /, %, +, \-).

## Functions vs Routines
CryspScript distinguishes between functions and routines with the return type, routines have no return type, while functions have a return type. Functions are declared with the func keyword, and delimited using cnuf.  Routines are declared with the rout keyword, and delimited with tour.  Functions can be called to be evaluated with the ^ operator, while routines are called with the _ operator, and should be the only command on the line.  Functions store their return type in the %r0 register, and can be called with the call keyword.  Routines can also be called with call, however, nothing will be written to the %r0 register.  

### Operators
Addition +


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

Declare a variable with type type, and name name

set {name, value}

Set the value of variable name

