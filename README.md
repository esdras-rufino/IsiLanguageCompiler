# IsiLanguage Compiler

This repository contains a project for a compiler of the IsiLanguage that generates Java files. The compiler was developed using the Eclipse IDE along with the ANTLR plugin. The IsiCompiler and IsiLangVisitor classes were created to test the program. The input.isi file is written in the IsiLanguage and serves as a test for the required functions in the project.

## Project Overview
The IsiLanguage compiler project consists of the following components:

IsiCompiler: This class represents the main compiler driver. It uses the ANTLR-generated parser and lexer to parse the input IsiLanguage code and generate Java code.

IsiLangVisitor: This class extends AbstractParseTreeVisitor and implements the visitor pattern for the IsiLanguage grammar. It visits different parts of the parse tree and generates the corresponding Java code.

ANTLR Plugin: The compiler was developed using the ANTLR plugin for Eclipse, which facilitates the generation of parser and lexer classes based on the grammar.

input.isi: This file contains IsiLanguage code and serves as a test input for the compiler.

## Optional Features Implemented
Editor Highlight
To simulate a small IDE, the compiler supports the highlight statement. For example:
highlight x;
This code highlights the variable x in the source code.
## Arithmetic Expression Evaluator
The compiler evaluates arithmetic expressions using the expr statement. For example:

expr = 1 + 2;
This code evaluates the arithmetic expression 1 + 2 and stores the result in the variable expr.

## Logical Operators
The compiler supports logical operators for decision-making. For example:

if (x > y) {
    // code
} else {
    // code
}
This code compares the values of x and y using logical operators and executes different code blocks based on the comparison.

## Generation of Multiple Target Languages
The compiler can generate code in multiple target languages using the generateTarget statement. For example:

prog = 'programa' decl bloco 'fimprog;';

// Generate Java source code
java = prog.generateTarget('java');

// Generate C++ source code
cpp = prog.generateTarget('cpp');

// Generate Python source code
python = prog.generateTarget('python');
This code generates Java, C++, and Python source code from the prog program.

## API Rest for Compiler Implementation
The compiler supports implementing a compiler using a REST API. For example:

apirest = 'apirest' AP ID SC;

// Implement a compiler using a REST API
compilar = apirest.implementarCompilador();
This code implements a compiler using a REST API.

## Interpreter (Runtime)
The compiler supports implementing an interpreter for the language using the interpretador statement. For example:

interpretador = 'interpretador' AP SC;

// Implement an interpreter for the language
interpretar = interpretador.implementarInterpretador();
This code implements an interpreter for the IsiLanguage.

## Additional Grammar Additions
The IsiLanguage grammar has been extended to support the following features:

highlight statement for code highlighting.
expr statement for evaluating arithmetic expressions.
OPREL token for logical operators.
generateTarget statement for generating code in multiple target languages.
apirest token for implementing a compiler using a REST API.
interpretador token for implementing an interpreter for the language.
Please refer to the IsiLanguage grammar file for the complete grammar with these additions.

## Getting Started
Clone this repository to your local machine.
Import the project into Eclipse.
Use the IsiCompiler and IsiLangVisitor classes to test the compiler and visit different parts of the grammar.
Feel free to explore and extend the project to further enhance the capabilities of the IsiLanguage compiler.
