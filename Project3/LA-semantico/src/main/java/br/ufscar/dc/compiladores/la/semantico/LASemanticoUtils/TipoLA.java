/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.compiladores.la.semantico.LASemanticoUtils;

import br.ufscar.dc.compiladores.la.semantico.LAParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.antlr.v4.runtime.Token;

public class TipoLA {
    public static List<String> semanticError = new ArrayList<>();

    public static void adicionarErroSemantico(Token t, String mensagem) {
        int linha = t.getLine();
        int coluna = t.getCharPositionInLine();

        semanticError.add(String.format("Linha %d: %s", linha, mensagem));
    }

    // Global verifier
    public static SymbleTable.TipoLA verifyType(Scopes scope, LAParser.Declaracao_globalContext ctx) {
        // Auxiliar variables
        SymbleTable.TipoLA type, subtype;


        switch(ctx.start.getText()) {
            case "declare":

                // DEBUG: where im
                //System.out.println("declaracao de variavel");
                break;
            case "procedimento":

                // Need to create new context for each procedure
                scope.createNewScope();

                // DEBUG: procedure declaration
                //System.out.println("declaracao de procedimento");
                break;
            case "funcao":

                // First of all, add it as a variable
                scope.addSymbol(ctx.name.getText(), SymbleTable.TipoLA.FUNCAO);

                // Add each variable to the parameter list
                for (var p : ctx.parametros().parametro()) {
                    for (var id : p.identificador()) {
                        if (p.tipo_estendido() == null ||
                                !SymbleTable.typeIsValid(ctx.tipo_estendido().getText())) {
                            // adding semantic error
                            //adicionarErroSemantico(ctx.variavel().start, "tipo "+ctx.variavel().tipo().getText()+" nao declarado");
                            type = SymbleTable.TipoLA.INVALIDO;

                        } else {
                            // if this type is valid, add it to the table anyway (I may merge this part of the code since it's equal)
                            type = SymbleTable.getType(ctx.tipo_estendido().getText());

                            if (type == SymbleTable.TipoLA.PONTEIRO) {
                                String s = ctx.tipo_estendido().getText().replace("^", "");
                                subtype = SymbleTable.getType(s);
                            }

                        }

                        // DEBUG: adding parameter
                        // Add parameters to scope
                        //scope.addSymbol(id.getText(), SymbleTable.getType(p.tipo_estendido().getText()));
                        scope.addFunctionParameter(ctx.name.getText(), id.getText(), SymbleTable.getType(p.tipo_estendido().getText()));

                    }
                }

                // Now create new context for each function
                scope.createNewScope();

                // Also, define it's parameters
                for (var p : ctx.parametros().parametro()) {
                    for (var id : p.identificador()) {
                        if (p.tipo_estendido() == null ||
                                !SymbleTable.typeIsValid(ctx.tipo_estendido().getText())) {
                            // adding semantic error
                            //adicionarErroSemantico(ctx.variavel().start, "tipo "+ctx.variavel().tipo().getText()+" nao declarado");
                            type = SymbleTable.TipoLA.INVALIDO;

                        } else {
                            // if this type is valid, add it to the table anyway (I may merge this part of the code since it's equal)
                            type = SymbleTable.getType(ctx.tipo_estendido().getText());

                            if (type == SymbleTable.TipoLA.PONTEIRO) {
                                String s = ctx.tipo_estendido().getText().replace("^", "");
                                subtype = SymbleTable.getType(s);
                            }

                        }

                        // DEBUG: adding parameter
                        // Add parameters to scope
                        scope.addSymbol(id.getText(), SymbleTable.getType(p.tipo_estendido().getText()));
                        //scope.addFunctionParameter(ctx.name.getText(), id.getText(), SymbleTable.getType(p.tipo_estendido().getText()));

                    }
                }

                // DEBUG: func declaration
                // System.out.println("declaracao de funcao");
                break;
        }
        return null;
    }

    // Local verifier
    public static SymbleTable.TipoLA verifyType(Scopes scope, LAParser.Declaracao_localContext ctx) {
        SymbleTable.TipoLA type, subtype = null;
        switch(ctx.start.getText()) {
            case "declare":

                // check if it doesn't have a valid type
                if (ctx.variavel().tipo() == null ||
                        !SymbleTable.typeIsValid(ctx.variavel().tipo().getText())) {
                    // adding semantic error
                    //adicionarErroSemantico(ctx.variavel().start, "tipo "+ctx.variavel().tipo().getText()+" nao declarado");
                    type = SymbleTable.TipoLA.INVALIDO;

                } else {
                    // if this type is valid, add it to the table anyway (I may merge this part of the code since it's equal)
                    type = SymbleTable.getType(ctx.variavel().tipo().getText());

                    if (type == SymbleTable.TipoLA.PONTEIRO) {
                        String s = ctx.variavel().tipo().getText().replace("^", "");
                        subtype = SymbleTable.getType(s);
                    }

                }


                break;

            case "constante":
                // TODO: treat constant values?
                // DEBUG: treat constant values
                // System.out.println("declaracao de constante");

                break;
            case "tipo":
                // TODO: type declaration
                // DEBUG: treat types

                // I'm adding a new variable called TypeName__type for each new type created.
                // Then, for each instance of this variable I'll make a copy of it.
                System.out.println("declaring type: "+ctx.IDENT());
                scope.registerType(ctx.IDENT().getText(), SymbleTable.TipoLA.REGISTRO);


                for (int i = 0; i < ctx.tipo().registro().variavel().size(); i++)
                    for (int j = 0; j < ctx.tipo().registro().variavel(i).identificador().size(); j++) {
                        scope.increseRegisterCounter();

                        // DEBUG: adding registers
                        //System.out.println("adding " + ctx.tipo().registro().variavel(i).identificador(j).getText() + " to register " + ctx.IDENT().getText());
                        scope.addRegisterVariable(ctx.IDENT().getText(),
                                ctx.tipo().registro().variavel(i).identificador(j).getText(),
                                SymbleTable.getType(ctx.tipo().registro().variavel(i).tipo().getText()));
                    }
                // DEBUG: aaa
                //System.out.println("declaracao criacao de tipos");
                break;
        }
        return null;
    }

    // Body verification
    public static SymbleTable.TipoLA verifyType(Scopes scope, LAParser.CorpoContext ctx) {
        // No need to call it
        for (var local_decl : ctx.declaracao_local()) {
            //System.out.println("declaracao de variaveis locais do corpo");
            verifyType(scope, local_decl);
        }

        // TODO: check if this is necessary
        for (var cmd : ctx.cmd()) {
            // MISSING: treat commands
            //System.out.println("passando pelos comandos");
        }

        return null;
    }

    // Atribuicao verification
    public static SymbleTable.TipoLA verifyType(Scopes scope, LAParser.CmdAtribuicaoContext ctx) {
        SymbleTable.TipoLA typeVariable, typeExpression;

        // get left side type
        typeVariable = scope.getSymbolType(ctx.identificador().getText());
        // DEBUG:
        //System.out.println("Left: "+typeVariable);

        // get expression type
        typeExpression = verifyType(scope, ctx.expressao());

        return SymbleTable.verifyTypeEquality(typeVariable, typeExpression);
    }

    // Expressao verification
    public static SymbleTable.TipoLA verifyType(Scopes scope, LAParser.ExpressaoContext ctx) {
        SymbleTable.TipoLA leftTermType, rightTermType;

        leftTermType = verifyType(scope, ctx.termo_logico(0));
        for (int i = 1; i < ctx.termo_logico().size(); i++) {
           // System.out.println("termo logico:"+ctx.termo_logico(i).getText());
            rightTermType = verifyType(scope, ctx.termo_logico(i));

            // Verify if it is the same type
            leftTermType = SymbleTable.verifyTypeEquality(leftTermType, rightTermType);
        }

        if (leftTermType != SymbleTable.TipoLA.INVALIDO && ctx.termo_logico().size() > 1)
            leftTermType = SymbleTable.TipoLA.LOGICO;

        return leftTermType;
    }

    // Termo Logico verification
    public static SymbleTable.TipoLA verifyType(Scopes scope, LAParser.Termo_logicoContext ctx) {
        SymbleTable.TipoLA leftTermType, rightTermType;

        leftTermType = verifyType(scope, ctx.fator_logico(0));
        for (int i = 1; i < ctx.fator_logico().size(); i++) {
            rightTermType = verifyType(scope, ctx.fator_logico(i));

            // Verify if it is the same type
            leftTermType = SymbleTable.verifyTypeEquality(leftTermType, rightTermType);
        }
        if (leftTermType != SymbleTable.TipoLA.INVALIDO && ctx.fator_logico().size() > 1)
            leftTermType = SymbleTable.TipoLA.LOGICO;

        //
        return leftTermType;
    }

    // Fator Logico verification
    public static SymbleTable.TipoLA verifyType(Scopes scope, LAParser.Fator_logicoContext ctx) {
        SymbleTable.TipoLA TypeTerm;
        //
        if (ctx.parcela_logica() != null) {
            TypeTerm = verifyType(scope, ctx.parcela_logica());
            return TypeTerm;
        }

        return SymbleTable.TipoLA.INVALIDO;
    }

    // Parcela logica verification
    public static SymbleTable.TipoLA verifyType(Scopes scope, LAParser.Parcela_logicaContext ctx) {
        SymbleTable.TipoLA typeTerm = SymbleTable.TipoLA.INVALIDO;

        if (ctx.VERDADEIRO() != null ||
                ctx.FALSO() != null) {
            typeTerm = SymbleTable.TipoLA.LOGICO;
        } else {
            typeTerm = verifyType(scope, ctx.exp_relacional());
        }

        return typeTerm;
    }

    // Expressao relacional verification
    public static SymbleTable.TipoLA verifyType(Scopes scope, LAParser.Exp_relacionalContext ctx) {
        SymbleTable.TipoLA leftTermType, rightTermType;

        leftTermType = verifyType(scope, ctx.exp_aritmetica(0));
        for (int i = 1; i < ctx.exp_aritmetica().size(); i++) {
            rightTermType = verifyType(scope, ctx.exp_aritmetica(i));

            // Verify if it is the same type
            leftTermType = SymbleTable.verifyTypeEquality(leftTermType, rightTermType);
        }
        if (leftTermType != SymbleTable.TipoLA.INVALIDO && ctx.exp_aritmetica().size() > 1)
            leftTermType = SymbleTable.TipoLA.LOGICO;

        return leftTermType;
    }

    // Expressao aritimetica verification
    public static SymbleTable.TipoLA verifyType(Scopes scope, LAParser.Exp_aritmeticaContext ctx) {
        SymbleTable.TipoLA leftTermType, rightTermType;

        leftTermType = verifyType(scope, ctx.termo(0));
        for (int i = 1; i < ctx.termo().size(); i++) {
            rightTermType = verifyType(scope, ctx.termo(i));

            // Verify if it is the same type
            leftTermType = SymbleTable.verifyTypeEquality(leftTermType, rightTermType);
        }

        return leftTermType;
    }

    // Termo verification
    public static SymbleTable.TipoLA verifyType(Scopes scope, LAParser.TermoContext ctx) {
        SymbleTable.TipoLA leftTermType, rightTermType;

        leftTermType = verifyType(scope, ctx.fator(0));
        for (int i = 1; i < ctx.fator().size(); i++) {
            rightTermType = verifyType(scope, ctx.fator(i));

            // Verify if it is the same type
            leftTermType = SymbleTable.verifyTypeEquality(leftTermType, rightTermType);
        }

        return leftTermType;
    }

    // Fator verification
    public static SymbleTable.TipoLA verifyType(Scopes scope, LAParser.FatorContext ctx) {
        SymbleTable.TipoLA leftTermType, rightTermType;

        leftTermType = verifyType(scope, ctx.parcela(0));
        for (int i = 1; i < ctx.parcela().size(); i++) {
            rightTermType = verifyType(scope, ctx.parcela(i));

            // Verify if it is the same type
            leftTermType = SymbleTable.verifyTypeEquality(leftTermType, rightTermType);
        }

        return leftTermType;
    }

    // Parcela verification
    public static SymbleTable.TipoLA verifyType(Scopes scope, LAParser.ParcelaContext ctx) {
        SymbleTable.TipoLA typeTerm;

        if (ctx.parcela_unario() != null) {
            typeTerm = verifyType(scope, ctx.parcela_unario());
            return typeTerm;
        } else if (ctx.parcela_nao_unario() != null) {
            typeTerm = verifyType(scope, ctx.parcela_nao_unario());
            return typeTerm;
        }

        return SymbleTable.TipoLA.INVALIDO;
    }

    // Parcela unaria verification
    public static SymbleTable.TipoLA verifyType(Scopes scope, LAParser.Parcela_unarioContext ctx) {
        SymbleTable.TipoLA typeTerm = SymbleTable.TipoLA.INVALIDO;
        if (ctx.identificador() != null) {
            if (ctx.PONTEIRO() != null)
                return SymbleTable.TipoLA.PONTEIRO;
            else if (ctx.ABREPAR() != null && ctx.FECHAPAR() != null)
                return SymbleTable.TipoLA.FUNCAO;
            typeTerm = verifyType(scope, ctx.identificador());
        } else if (ctx.IDENT() != null) {
            typeTerm = SymbleTable.TipoLA.LITERAL;
        } else if (ctx.NUM_INT() != null) {
            typeTerm = SymbleTable.TipoLA.INTEIRO;
        } else if (ctx.NUM_REAL() != null) {
            typeTerm = SymbleTable.TipoLA.REAL;
        } else if (ctx.expressao() != null && ctx.expressao().size() == 1) {
            typeTerm = verifyType(scope, ctx.expressao(0));
        }

        return typeTerm;
    }

    // Parcela nao unaria verification
    public static SymbleTable.TipoLA verifyType(Scopes scope, LAParser.Parcela_nao_unarioContext ctx) {
        SymbleTable.TipoLA typeTerm = SymbleTable.TipoLA.INVALIDO;

        if (ctx.identificador() != null ) {
            if (ctx.ENDERECO() != null)
                return SymbleTable.TipoLA.PONTEIRO;
            typeTerm = verifyType(scope, ctx.identificador());
        } else if (ctx.CADEIA() != null) {
            typeTerm = SymbleTable.TipoLA.LITERAL;
        }
        //

        return typeTerm;
    }


    // Identificador verification
    public static SymbleTable.TipoLA verifyType(Scopes scope, LAParser.IdentificadorContext ctx) {
        SymbleTable.TipoLA typeTerm = SymbleTable.TipoLA.INVALIDO;
        String ident = ctx.getText();

        if (ctx.PONTO() != null) {
            ident = ident.substring(ident.lastIndexOf(".")+1);
        }

        if (scope.existsInCurrentScope(ident)) {
            typeTerm = scope.getSymbolType(ctx.getText());
        }

        // DEBUG: identificador
        //System.out.println("Identificador: "+ typeTerm + " "+ctx.getText());
        return typeTerm;
    }

    // Variavel verification
    public static void verifyType(Scopes scope, LAParser.VariavelContext ctx) {
        SymbleTable.TipoLA type, subtype = null;

        // DEBUG: purposes
        //System.out.println("verifyTypeVariavel: "+ctx.tipo().getText());

        if (ctx.tipo() == null ||
                !SymbleTable.typeIsValid(ctx.tipo().getText())) {

            // Adding semantic error
            TipoLA.adicionarErroSemantico(ctx.start, "tipo " + ctx.tipo().getText() + " nao declarado");
            type = SymbleTable.TipoLA.INVALIDO;

        } else {

            // get variable type
            type = SymbleTable.getType(ctx.tipo().getText());

            // Some types are a bit more complex, I'll work on them first
            if (type == SymbleTable.TipoLA.PONTEIRO) {
                String s = ctx.tipo().getText().replace("^", "");
                subtype = SymbleTable.getType(s);
            }

        }

        for (var i = 0; i < ctx.identificador().size(); i++) {

            // check if this variable already exists in this context
            if (!scope.existsInCurrentScope(ctx.identificador(i).getText())) {

                // Check variable type
                if (type == SymbleTable.TipoLA.PONTEIRO) {
                    // Define to which type this pointer should point
                    scope.addSymbol(ctx.identificador(i).getText(), type, subtype);

                    // DEBUG: register pointer
                    //System.out.println("Adicionando ponteiro "+ctx.identificador(i).getText() + " para "+subtype);
                } else if (type == SymbleTable.TipoLA.REGISTRO && !SymbleTable.isCustomType(ctx.tipo().getText())) {
                    ArrayList<SymbleTable.Symble> variables;

                    // Add register...
                    scope.addSymbol(ctx.identificador(i).getText(), type);

                    // ... and it's variables
                    for (int j = 0; j < ctx.tipo().registro().variavel().size(); j++)
                        for (int k = 0; k < ctx.tipo().registro().variavel(j).identificador().size(); k++) {

                            // should run only once
                            if (i == 0)
                                scope.increseRegisterCounter();

                            // DEBUG: Add register variables
                            //System.out.println("adding " + ctx.tipo().registro().variavel(j).identificador(k).getText() + " to register " + ctx.identificador(i).getText());
                            scope.addRegisterVariable(ctx.identificador(i).getText(),
                                    ctx.tipo().registro().variavel(j).identificador(k).getText(),
                                    SymbleTable.getType(ctx.tipo().registro().variavel(j).tipo().getText()));
                        }
                    continue;

                } else if (type == SymbleTable.TipoLA.REGISTRO) {

                    // DEBUG: copy type
                    //System.out.println("custom copy of a register");
                    //System.out.println("nome tipo: "+ctx.identificador(i).getText()+" "+ctx.tipo().getText());
                    scope.instanceType(ctx.identificador(i).getText(), ctx.tipo().getText());

                    continue;
                } else {

                    // TODO: this is really needed?

                }

                // DEBUG: If it's a simple variable, add it to the table.
                //System.out.println("Contador: "+scope.getRegisterCounter()+" : "+ctx.identificador(i).getText());

                // Avoid ghost variables
                if (scope.getRegisterCounter() > 0) {
                    scope.decreaseRegisterCounter();
                } else {
                    // DEBUG: message
                    // System.out.println("Adicionando identificador: "+ctx.identificador(i).getText());
                    scope.addSymbol(ctx.identificador(i).getText(), type);
                }

            } else {

                // Semantic error! declaring a variable twice
                TipoLA.adicionarErroSemantico(ctx.identificador(i).stop, "identificador " + ctx.identificador(i).stop.getText() + " ja declarado anteriormente");
            }


        }
    }


}
