/*
 * A LA grammar for ANTLR 4 derived from the Go grammar
 * https://github.com/antlr/grammars-v4/blob/master/golang/GoLexer.g4
 */

lexer grammar LALexer;

// Keywords

ALGORITMO               : 'algoritmo';
DECL                    : 'declare';
TIPO                    : 'tipo';
VAR                     : 'var';
CONSTANTE               : 'constante';
LOGICO                  : 'logico';
LITERAL                 : 'literal';
INTEIRO                 : 'inteiro';
REGISTRO                : 'registro';
FIMREGISTRO             : 'fim_registro';
PROCEDIMENTO            : 'procedimento';
FIMPROCEDIMENTO         : 'fim_procedimento';
FUNCAO                  : 'funcao';
RETORNE                 : 'retorne';
FIMFUNCAO               : 'fim_funcao';
FALSO                   : 'falso';
NAO                     : 'nao';
VERDADEIRO              : 'verdadeiro';
REAL                    : 'real';
ENTAO                   : 'entao';
OU                      : 'ou';
E                       : 'e';
SE                      : 'se';
FIMSE                   : 'fim_se';
SENAO                   : 'senao';
FACA                    : 'faca';
ENQUANTO                : 'enquanto';
FIMENQUANTO             : 'fim_enquanto';
PARA                    : 'para';
FIMPARA                 : 'fim_para';
ATE                     : 'ate';
SEJA                    : 'seja';
CASO                    : 'caso';
FIMCASO                 : 'fim_caso';
FIMALGORITMO            : 'fim_algoritmo';
DELIM	                : ':';

// Functions

LER                     : 'leia';
ESCREVER                : 'escreva';

// Punctuation

ABREPAR                 : '(';
FECHAPAR                : ')';
ABRECOLCHETES           : '[';
FECHACOLCHETES          : ']';
VIRG                    : ',';
PONTOS                  : '..';
PONTO                   : '.';

// Arithmetic operators

DIV                     : '/';
MODULO                  : '%';

// Mixed operators

ATRIBUI                 : '<-';
SOMA                    : '+';
MENOS                   : '-';
MULT                    : '*';
PONTEIRO                : '^';
ENDERECO                : '&';

// Relation operators

IGUAL                   : '=';
DIFERENTE               : '<>';
MENOR                   : '<';
MENORIGUAL              : '<=';
MAIOR                   : '>';
MAIORIGUAL              : '>=';

// Number literals

NUM_INT                 : ('0'..'9')+;
NUM_REAL                : ('0'..'9')+ ('.' ('0'..'9')+)?;

// String literals

IDENT                   : ( 'a'..'z' | 'A'..'Z' | '_' ) ( 'a'..'z' | 'A'..'Z' | '0'..'9' | '_' )* ;
CADEIA                  : '"' ~('\n')*? '"';
WS                      : ( ' ' | '\t' | '\r' | '\n' ) -> skip;
COMENTARIOS             : '{' ~('}' | '\n')*? '}' -> skip;

// Errors

ERRO_CADEIA             : '"' .*?;
ERRO_COMENTARIO         :   '{' .*?;
ERRO_SIMBOLO            : .;