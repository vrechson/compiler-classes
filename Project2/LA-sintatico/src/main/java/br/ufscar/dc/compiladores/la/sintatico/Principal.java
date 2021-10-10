package br.ufscar.dc.compiladores.la.sintatico;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Principal {
    public static void main(String args[]) throws IOException {
        try(PrintWriter pw = new PrintWriter(new File(args[1]))) {
            CharStream cs = CharStreams.fromFileName(args[0]);

            // Instantiate LA Lexer
            LALexer lexer = new LALexer(cs);
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // Instantiate LA Parser
            LAParser parser = new LAParser(tokens);

            // Instantiate our own custom handler
            parser.removeErrorListeners();
            ErrorHandler mcel = new ErrorHandler(pw);
            parser.addErrorListener(mcel);

            // Parse the code
            parser.programa();
            
            
        }
    }
}
