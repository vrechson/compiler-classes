package br.ufscar.dc.compiladores.la.lexico;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.antlr.v4.runtime.Token;

public class Principal {
    public static void main(String args[]) throws IOException {
        CharStream cs = CharStreams.fromFileName(args[0]);
        LALexer lex = new LALexer(cs);
        Token t = null;
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

        // this is going to stop the lexer once it finds an error
        boolean noerror = true;

        while((t=lex.nextToken()).getType() != Token.EOF && noerror) {
            String line=null;
            switch (LALexer.VOCABULARY.getDisplayName(t.getType())) {
                /* Not sure if this is the better way of doing it, maybe I should create a ErrorHandler Class instead */
                case "ERRO_CADEIA":
                    line = "Linha " + t.getLine() + ": cadeia literal nao fechada";
                    noerror=false;
                    break;
                case "ERRO_COMENTARIO":
                    line = "Linha " + t.getLine() + ": comentario nao fechado";
                    noerror=false;
                    break;
                case "ERRO_SIMBOLO":
                    line = "Linha " + t.getLine() + ": " + t.getText() + " - simbolo nao identificado";
                    noerror=false;
                    break;
                default:
                    line = "<" + "'" + t.getText() + "'" + "," + LALexer.VOCABULARY.getDisplayName(t.getType()) + ">";

            }
            System.out.println(line);
            writer.write(line);
            // Do not forget to add new lines
            writer.newLine();
        }
        writer.close();
    }
}
