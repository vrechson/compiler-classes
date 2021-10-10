# LA-lexico

This project implements LA Language, including lexical, syntactic, semantic and code generation to an intermediary language. In other words, LA Language is a simplified version of language C, letting a user create a significant part of its data structures such as structs and new types of definitions.

## Students: 
   - Matheus Vrech RA: 727349

# Roardmap

- [X] **Project 1:** Lexical Parser
- [X] **Project 2:** Syntactic Parser
- [X] **Project 3:** Semantic Parser and Code generator
- [ ] **Project 4:** Complete compiler development

## Project 1

In the very first step of this project, the students generated a lexical parser for a defined list of keywords, operators and other grammatical aspects of LA Language using JAVA and the library ANTLR4.

## Project 2

In this project, the undergraduate students generated a syntactical parser for the LA grammar, defined in the first project.

### Building Instructions

Run the following command to build the project:
```
$ docker build . -t la
```

### Running Instructions
You can run the compiler as shown below:
```
$ docker run la exec <lexical|syntactical|semantical|all> <input_file> <output_file>
```

To run lexical tests use the following command:
```
$ docker run la lexical-tests
```

To run syntactical tests use the following command:
```
$ docker run la syntactical-tests
```

**Atention:** rebuild the project to run Project 3 commands!

To semantical tests:
```
$ docker run la semantical-tests
```

To generate source code for the programs:
```
$ docker run la generator-tests
```

