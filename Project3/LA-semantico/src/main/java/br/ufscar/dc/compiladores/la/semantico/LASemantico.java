package br.ufscar.dc.compiladores.la.semantico;

import br.ufscar.dc.compiladores.la.semantico.LASemanticoUtils.Scopes;
import br.ufscar.dc.compiladores.la.semantico.LASemanticoUtils.SymbleTable;
import br.ufscar.dc.compiladores.la.semantico.LASemanticoUtils.TipoLA;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LASemantico extends LABaseVisitor<Void> {
    SymbleTable tabela;
    Scopes scope;

    @Override
    public Void visitPrograma(LAParser.ProgramaContext ctx) {

        // Creating new scope
        scope = new Scopes();

        // this isn't needed anymore since I'm adding a stack for each table
        // tabela = new TabelaDeSimbolos();
        return super.visitPrograma(ctx);
    }

    @Override
    public Void visitDeclaracao_local(LAParser.Declaracao_localContext ctx) {

        //
        TipoLA.verifyType(scope, ctx);

        return super.visitDeclaracao_local(ctx);
    }

    @Override
    public Void visitVariavel(LAParser.VariavelContext ctx) {

        // moving everything into verifyType func
        TipoLA.verifyType(scope, ctx);

        return super.visitVariavel(ctx);
    }

    @Override
    public Void visitDeclaracao_global(LAParser.Declaracao_globalContext ctx) {

        // remove last global context
        if (scope.getContextLevel() > 1)
            scope.removeContext();

        TipoLA.verifyType(scope, ctx);

        return super.visitDeclaracao_global(ctx);
    }

//    @Override
//    public Void visitCorpo(LAParser.CorpoContext ctx) {
//
//        return super.visitCorpo(ctx);
//    }

    @Override
    public Void visitCmdAtribuicao(LAParser.CmdAtribuicaoContext ctx) {

        SymbleTable.TipoLA typeAssign;
        //leftTermType = SymbleTable.verificar(ctx.identificador().getText());

        typeAssign = TipoLA.verifyType(scope, ctx);
        if (typeAssign == SymbleTable.TipoLA.INVALIDO) {
            String v = ctx.identificador().getText();
            if (ctx.PONTEIRO() != null)
                v = "^"+v;
            TipoLA.adicionarErroSemantico(ctx.expressao().stop, "atribuicao nao compativel para "+v);
        }


        return super.visitCmdAtribuicao(ctx);
    }

    @Override
    public Void visitCmdChamada(LAParser.CmdChamadaContext ctx) {

        // DEBUG: cmdchamada
        //System.out.println("chamando func: "+ctx.IDENT());


        return super.visitCmdChamada(ctx);
    }

    // The better way to detect the use of undeclared variables is directly in visitIdentificador.
    @Override
    public Void visitIdentificador(LAParser.IdentificadorContext ctx) {

        SymbleTable.TipoLA typeId = SymbleTable.TipoLA.INVALIDO;

        typeId = TipoLA.verifyType(scope, ctx);

        // DEBUG: check if variable already exists in this context
        //System.out.println("retrieving: "+ctx.getText());
        if (!scope.existsInCurrentScope(ctx.getText())) {
            if (scope.getRegisterCounter() == 0) {
                // Semantic error! using a undeclared var
                System.out.println("error not defined in this context: " + ctx.getText());
                TipoLA.adicionarErroSemantico(ctx.stop, "identificador " + ctx.getText() + " nao declarado");
            } else {
                scope.decreaseRegisterCounter();
            }
        }
        //System.out.println(ctx.getText());
        return super.visitIdentificador(ctx);
    }

    @Override
    public Void visitFator(LAParser.FatorContext ctx) {
        // DEBUG: Just for debug purposes
        //System.out.println("visitFator");

        TipoLA.verifyType(scope, ctx);
        return super.visitFator(ctx);
    }


}