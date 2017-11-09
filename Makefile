# You will probably want to edit this makefile to suit your needs better, for now, this is good enough
# Requirements: 64bit gcc, this makefile is for windows, 

# Directory of your 64 bit c compiler
gcc = C:/mingw64/bin/gcc

# Directory where java installations are located
javaHome = C:/Program Files/Java

# Which JDK installation to use
javaInstall = jdk1.8.0_121

# Which java includes to use (OS dependent)
OS = win32

out = res/Operator.dll

frootdir = NativeLibs
file = Operator.c

# Any additional flags
addlflags = 

all:
	$(gcc) -I "$(javaHome)/$(javaInstall)/include" -I "$(javaHome)/$(javaInstall)/include/$(OS)" -Wl,--add-stdcall-alias -m64 $(addlflags) -shared -o $(out) $(frootdir)/$(file)