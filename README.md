# LA-lexico

This project implements LA Language, including lexical, syntactic, semantic and code generation to an intermediary language. In other words, LA Language is a simplified version of language C, letting a user create a significant part of its data structures such as structs and new types of definitions.

## Students: 
   - José Alfredo Custodio RA: 586935
   - Matheus Vrech RA: 727349
   - Philipe Fonseca Bittencourt RA: 726579 

# Roardmap

- [X] **Project 1:** Lexical Parser
- [X] **Project 2:** Syntactic Parser
- [ ] **Project 3:** Semantic Parser
- [ ] **Project 4:** Complete compiler development

## Project 1

In the very first step of this project, the students generated a lexical parser for a defined list of keywords, operators and other grammatical aspects of LA Language using  JAVA and the library ANTLR4.

## Project 2

In this project, the undergraduate students generated a syntactical parser for the grammar defined in the first project.

### Building Instructions

The easiest way to build this project is through the Dockerfile container:
```
$ docker build . -t la
```

### Running Instructions
To run the compiler against an input file, you can run the program as shown below:
```
$ docker run la exec <lexical|syntactical> <input_file> <output_file>
```

To run it against several lexical tests:
```
$ docker run la lexical-tests
```

To execute against syntactical tests:
```
$ docker run la syntactical-tests
```

To execute against semantical tests:
```
$ docker run la semantical-tests
```