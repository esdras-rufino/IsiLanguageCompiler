# IsiLanguage Compiler

This repository contains a project for a compiler of the IsiLanguage that generates Java files. The compiler was developed using the Eclipse IDE along with the ANTLR plugin. The `IsiCompiler` and `IsiLangVisitor` classes were created to test the program. The `input.isi` file is written in the IsiLanguage and serves as a test for the required functions in the project.

## Project Overview

The IsiLanguage compiler project consists of the following components:

1. **IsiCompiler**: This class represents the main compiler driver. It uses the ANTLR-generated parser and lexer to parse the input IsiLanguage code and generate Java code.

2. **IsiLangVisitor**: This class extends `AbstractParseTreeVisitor` and implements the visitor pattern for the IsiLanguage grammar. It visits different parts of the parse tree and generates the corresponding Java code.

3. **ANTLR Plugin**: The compiler was developed using the ANTLR plugin for Eclipse, which facilitates the generation of parser and lexer classes based on the grammar.

4. **`input.isi`**: This file contains IsiLanguage code and serves as a test input for the compiler.

## Optional Features Implemented

### Editor Highlight

To simulate a small IDE, the compiler supports the `highlight` statement. For example:

```isilang
highlight x;
