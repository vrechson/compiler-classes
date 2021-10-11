/*
 * A LA grammar for ANTLR 4 derived from the Go grammar
 * https://github.com/antlr/grammars-v4/blob/master/golang/GoLexer.g4
 */

grammar LA;

/*
 * Lexical definitions
 */


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

/*
 * Syntactical definitions
 */

// Program Structures

programa                :  declaracoes 'algoritmo' corpo 'fim_algoritmo';

declaracoes             : (decl_local_global)*;

decl_local_global       : declaracao_local
                            | declaracao_global;

declaracao_local        : 'declare' variavel
                            | 'constante' IDENT ':' tipo_basico '=' valor_constante
                            | 'tipo' IDENT ':' tipo;

variavel                : identificador (',' identificador)* ':' tipo;

identificador           : IDENT ('.' IDENT)* dimensao;

dimensao                : ('[' exp_aritmetica ']')*;

tipo                    : registro
                            | tipo_estendido;

tipo_basico             : 'literal'
                            | 'inteiro'
                            | 'real'
                            | 'logico';

tipo_basico_ident       : tipo_basico
                            | IDENT;

tipo_estendido          : ('^')? tipo_basico_ident;

valor_constante         : CADEIA
                            | NUM_INT
                            | NUM_REAL
                            | 'verdadeiro'
                            | 'falso';

registro                : 'registro' (variavel)* 'fim_registro';

declaracao_global       : 'procedimento' IDENT '(' (parametros)? ')' (declaracao_local)* (cmd)* 'fim_procedimento'
                            | 'funcao' name=IDENT '(' (parametros)? ')' ':' tipo_estendido (declaracao_local)* (cmd)* 'fim_funcao';

parametro               : ('var')? identificador (',' identificador)* ':' tipo_estendido;

parametros              : parametro (',' parametro)*;

corpo                   : (declaracao_local)* (cmd)*;

// Functions and statements

cmd                     : cmdLeia
                            | cmdEscreva
                            | cmdSe
                            | cmdCaso
                            | cmdPara
                            | cmdEnquanto
                            | cmdFaca
                            | cmdAtribuicao
                            | cmdChamada
                            | cmdRetorne;

cmdLeia                 : 'leia' '(' ('^')? identificador (',' ('^')? identificador)* ')';

cmdEscreva              : 'escreva' '(' expressao (',' expressao)* ')';

cmdSe                   : 'se' expressao 'entao' (if_stmt+=cmd)* ('senao' (else_stmt+=cmd)*)? 'fim_se';

cmdCaso                 : 'caso' exp_aritmetica 'seja' selecao ('senao' (cmd)*)? 'fim_caso';

cmdPara                 : 'para' IDENT '<-' exp_aritmetica 'ate' exp_aritmetica 'faca' (cmd)* 'fim_para';

cmdEnquanto             : 'enquanto' expressao 'faca' (cmd)* 'fim_enquanto';

cmdFaca                 : 'faca' (cmd)* 'ate' expressao;

cmdAtribuicao           : ('^')? identificador '<-' expressao;

cmdChamada              : IDENT '(' expressao (',' expressao)* ')';

cmdRetorne              : 'retorne' expressao;

selecao                 : (item_selecao)*;

item_selecao            : constantes ':' (cmd)*;

constantes              : numero_intervalo (',' numero_intervalo)*;

numero_intervalo        : (op_unario)? NUM_INT ('..' (op_unario)? NUM_INT)? ;

// Operators and Expressions

op_unario               : '-';

exp_aritmetica          : termo (op1 termo)*;

termo                   : fator (op2  fator)*;

fator                   : parcela (op3 parcela)*;

op1                     : '+'
                            | '-';

op2                     : '*'
                            | '/';

op3                     : '%';

parcela                 : (op_unario)? parcela_unario | parcela_nao_unario;

parcela_unario          : ('^')? identificador
                            | IDENT '(' expressao (',' expressao)* ')'
                            | NUM_INT
                            | NUM_REAL
                            | '('expressao')';

parcela_nao_unario      : '&' identificador
                            | CADEIA;

exp_relacional          : exp_aritmetica (op_relacional exp_aritmetica)?;

op_relacional           : '='
                            | '<>'
                            | '>='
                            | '<='
                            | '>'
                            | '<';

expressao               : termo_logico (op_logico_1 termo_logico)*;

termo_logico            : fator_logico (op_logico_2 fator_logico)*;

fator_logico            : ('nao')? parcela_logica;

parcela_logica          : ('verdadeiro' | 'falso')
                            | exp_relacional;

op_logico_1             : 'ou';

op_logico_2             : 'e';