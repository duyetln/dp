How to Run the Examples/Misc. Notes

C#:
  - The entire C# code is to be compiled and run as a single project in VS.
  - The attached dgml is an interactive codemap for the entire project.
  - Factory_Simplified and Twin_Simplified are used for comparisons across languages.
  - Factory and Twin contain full implementations, and are not used for comparisons.
  - Twin of MazeGame is playable by setting option in Program.cs to 0.
  - Factory cannot be played directly, as create Factory creates a simple factory.

Java:
  - Each Java folder is self-contained and contains a client class.
  - Simply run the client class to execute code.

Python:
  - Each Python file is a self-contained project, complete with all necessary class and method definitions
  - Near the end of each file, there is line consisting of only "#"; illustrative client-esque usage of the program follows this line
  - Running a given file will result in the interpretation of the source code as invoked by the "client" lines

Scala:
  - Change current directory to the scala directory.
  - Open scala console by running "scala" command.
  - Inside console, type ":load 'example.scala'" to run an example.

Lisp:
  - Install Common Lisp. This version is most compatibe with the examples.
  - Change current directory to lisp directory.
  - Open lisp console by running "clisp" command.
  - Inside REPL command line, type "(load 'example.lisp)" to load an example.
  - Any function defined in the file can now be called.
