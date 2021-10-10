package br.ufscar.dc.compiladores.la.semantico;

import br.ufscar.dc.compiladores.la.semantico.LASemanticoUtils.Scopes;
import br.ufscar.dc.compiladores.la.semantico.LASemanticoUtils.SymbleTable;
import br.ufscar.dc.compiladores.la.semantico.LASemanticoUtils.TipoLA;

public class LAGeradorC extends LABaseVisitor<Void>{
    StringBuilder out;
    SymbleTable table;
    Scopes scope;

    public LAGeradorC() {
        this.out = new StringBuilder();
        this.table = new SymbleTable();
        this.scope = new Scopes();
    }

    @Override
    public Void visitPrograma(LAParser.ProgramaContext ctx) {


        // Creating new scope
        scope = new Scopes();

        out.append("#include <stdio.h>\n");
        out.append("#include <stdlib.h>\n\n");

        if (ctx.declaracoes() != null)
            visitDeclaracoes(ctx.declaracoes());

        visitCorpo(ctx.corpo());

//        ctx.declaracoes().decl_local_global().forEach(
//                dec -> visitDecl_local_global(dec));

        return null;
    }

    @Override
    public Void visitDeclaracoes(LAParser.DeclaracoesContext ctx) {

        // DEBUG:
        System.out.println("visitDeclaracoes");

        for (var d : ctx.decl_local_global()) {
            System.out.println("aaaaaaa");
            visitDecl_local_global(d);
        }
        return null;
    }

    @Override
    public Void visitDecl_local_global(LAParser.Decl_local_globalContext ctx) {

        // DEBUG:
        System.out.println("visitDecl_local_global");

        if (ctx.declaracao_global() != null) {
            visitDeclaracao_global(ctx.declaracao_global());
        } else if (ctx.declaracao_local() != null) {
            visitDeclaracao_local(ctx.declaracao_local());
        }
        return null;
    }

    @Override
    public Void visitDeclaracao_global(LAParser.Declaracao_globalContext ctx) {
        // DEBUG:
        System.out.println("visitDeclaracao_global");
        return null;
    }

    @Override
    public Void visitDeclaracao_local(LAParser.Declaracao_localContext ctx) {
        // DEBUG:
        System.out.println("visitDeclaracao_local");
        if (ctx.DECL() != null) {
            // DEBUG
            for (var v : ctx.variavel().identificador()) {
                String type = "";
                switch (ctx.variavel().tipo().getText()) {
                    case "inteiro":
                        type = "int";
                        break;
                }
                out.append(type + " " + v.getText()+";\n");
            }
            System.out.println(ctx.variavel().getText());
            visitVariavel(ctx.variavel());
        } else if (ctx.CONSTANTE() != null) {

        } else if (ctx.TIPO() != null) {

        }

        return null;
    }

    @Override
    public Void visitCorpo(LAParser.CorpoContext ctx) {
        // DEBUG:
        System.out.println("visitCorpo");

        out.append("\n");
        out.append("int main() {\n\n");

        for (var v : ctx.declaracao_local()) {
            visitDeclaracao_local(v);
        }

        for (var c : ctx.cmd()) {
            visitCmd(c);
        }

        out.append("return 0;\n}\n");
        return null;
    }

    @Override
    public Void visitCmd(LAParser.CmdContext ctx) {

        if (ctx.cmdLeia() != null) {
            visitCmdLeia(ctx.cmdLeia());
        } else if (ctx.cmdEscreva() != null) {
            visitCmdEscreva(ctx.cmdEscreva());
        }

        return null;
    }

    @Override
    public Void visitCmdLeia(LAParser.CmdLeiaContext ctx) {
        // DEBUG: print leia
        System.out.println(ctx.getText());

        // Adding scanf variables
        out.append("scanf(\"");
        for (var v : ctx.identificador()) {
            out.append("%d");
        }
        out.append("\",");

        // Adding scanf parameters
        for (int i = 0; i < ctx.identificador().size();) {
            out.append("&"+ctx.identificador(i).getText());
            if (++i < ctx.identificador().size())
                out.append(", ");
        }

        out.append(");\n");
        return null;
    }

    @Override
    public Void visitCmdEscreva(LAParser.CmdEscrevaContext ctx) {
        // DEBUG: print escreva
        System.out.println(ctx.getText());

        // Adding printf variables
        out.append("printf(\"");
        for (var v : ctx.expressao()) {
            out.append("%d");
        }
        out.append("\",");

        // Adding printf parameters
        for (int i = 0; i < ctx.expressao().size();) {
            out.append(ctx.expressao(i).getText());
            if (++i < ctx.expressao().size())
                out.append(", ");
        }

        out.append(");\n");
        return null;
    }
}

