// Generated from br\u005Cufscar\dc\compiladores\la\lexico\LALexer.g4 by ANTLR 4.9.2
package br.ufscar.dc.compiladores.la.lexico;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LALexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ALGORITMO=1, DECL=2, TIPO=3, VAR=4, CONSTANTE=5, LOGICO=6, LITERAL=7, 
		INTEIRO=8, REGISTRO=9, FIMREGISTRO=10, PROCEDIMENTO=11, FIMPROCEDIMENTO=12, 
		FUNCAO=13, RETORNE=14, FIMFUNCAO=15, FALSO=16, NAO=17, VERDADEIRO=18, 
		REAL=19, LER=20, ESCREVER=21, ENTAO=22, OU=23, E=24, SE=25, FIMSE=26, 
		SENAO=27, FACA=28, ENQUANTO=29, FIMENQUANTO=30, PARA=31, FIMPARA=32, ATE=33, 
		SEJA=34, CASO=35, FIMCASO=36, FIMALGORITMO=37, DELIM=38, ABREPAR=39, FECHAPAR=40, 
		ABRECOLCHETES=41, FECHACOLCHETES=42, VIRG=43, PONTOS=44, PONTO=45, DIV=46, 
		MODULO=47, ATRIBUI=48, SOMA=49, MENOS=50, MULT=51, PONTEIRO=52, ENDERECO=53, 
		IGUAL=54, DIFERENTE=55, MENOR=56, MENORIGUAL=57, MAIOR=58, MAIORIGUAL=59, 
		NUM_INT=60, NUM_REAL=61, IDENT=62, CADEIA=63, WS=64, COMENTARIOS=65, ERRO_CADEIA=66, 
		ERRO_COMENTARIO=67, ERRO_SIMBOLO=68;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ALGORITMO", "DECL", "TIPO", "VAR", "CONSTANTE", "LOGICO", "LITERAL", 
			"INTEIRO", "REGISTRO", "FIMREGISTRO", "PROCEDIMENTO", "FIMPROCEDIMENTO", 
			"FUNCAO", "RETORNE", "FIMFUNCAO", "FALSO", "NAO", "VERDADEIRO", "REAL", 
			"LER", "ESCREVER", "ENTAO", "OU", "E", "SE", "FIMSE", "SENAO", "FACA", 
			"ENQUANTO", "FIMENQUANTO", "PARA", "FIMPARA", "ATE", "SEJA", "CASO", 
			"FIMCASO", "FIMALGORITMO", "DELIM", "ABREPAR", "FECHAPAR", "ABRECOLCHETES", 
			"FECHACOLCHETES", "VIRG", "PONTOS", "PONTO", "DIV", "MODULO", "ATRIBUI", 
			"SOMA", "MENOS", "MULT", "PONTEIRO", "ENDERECO", "IGUAL", "DIFERENTE", 
			"MENOR", "MENORIGUAL", "MAIOR", "MAIORIGUAL", "NUM_INT", "NUM_REAL", 
			"IDENT", "CADEIA", "WS", "COMENTARIOS", "ERRO_CADEIA", "ERRO_COMENTARIO", 
			"ERRO_SIMBOLO"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'algoritmo'", "'declare'", "'tipo'", "'var'", "'constante'", "'logico'", 
			"'literal'", "'inteiro'", "'registro'", "'fim_registro'", "'procedimento'", 
			"'fim_procedimento'", "'funcao'", "'retorne'", "'fim_funcao'", "'falso'", 
			"'nao'", "'verdadeiro'", "'real'", "'leia'", "'escreva'", "'entao'", 
			"'ou'", "'e'", "'se'", "'fim_se'", "'senao'", "'faca'", "'enquanto'", 
			"'fim_enquanto'", "'para'", "'fim_para'", "'ate'", "'seja'", "'caso'", 
			"'fim_caso'", "'fim_algoritmo'", "':'", "'('", "')'", "'['", "']'", "','", 
			"'..'", "'.'", "'/'", "'%'", "'<-'", "'+'", "'-'", "'*'", "'^'", "'&'", 
			"'='", "'<>'", "'<'", "'<='", "'>'", "'>='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ALGORITMO", "DECL", "TIPO", "VAR", "CONSTANTE", "LOGICO", "LITERAL", 
			"INTEIRO", "REGISTRO", "FIMREGISTRO", "PROCEDIMENTO", "FIMPROCEDIMENTO", 
			"FUNCAO", "RETORNE", "FIMFUNCAO", "FALSO", "NAO", "VERDADEIRO", "REAL", 
			"LER", "ESCREVER", "ENTAO", "OU", "E", "SE", "FIMSE", "SENAO", "FACA", 
			"ENQUANTO", "FIMENQUANTO", "PARA", "FIMPARA", "ATE", "SEJA", "CASO", 
			"FIMCASO", "FIMALGORITMO", "DELIM", "ABREPAR", "FECHAPAR", "ABRECOLCHETES", 
			"FECHACOLCHETES", "VIRG", "PONTOS", "PONTO", "DIV", "MODULO", "ATRIBUI", 
			"SOMA", "MENOS", "MULT", "PONTEIRO", "ENDERECO", "IGUAL", "DIFERENTE", 
			"MENOR", "MENORIGUAL", "MAIOR", "MAIORIGUAL", "NUM_INT", "NUM_REAL", 
			"IDENT", "CADEIA", "WS", "COMENTARIOS", "ERRO_CADEIA", "ERRO_COMENTARIO", 
			"ERRO_SIMBOLO"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public LALexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LALexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2F\u0217\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3"+
		" \3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3"+
		"$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3"+
		"&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3-\3.\3.\3/\3/\3\60\3"+
		"\60\3\61\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3"+
		"\67\3\67\38\38\38\39\39\3:\3:\3:\3;\3;\3<\3<\3<\3=\6=\u01d8\n=\r=\16="+
		"\u01d9\3>\6>\u01dd\n>\r>\16>\u01de\3>\3>\6>\u01e3\n>\r>\16>\u01e4\5>\u01e7"+
		"\n>\3?\3?\7?\u01eb\n?\f?\16?\u01ee\13?\3@\3@\7@\u01f2\n@\f@\16@\u01f5"+
		"\13@\3@\3@\3A\3A\3A\3A\3B\3B\7B\u01ff\nB\fB\16B\u0202\13B\3B\3B\3B\3B"+
		"\3C\3C\7C\u020a\nC\fC\16C\u020d\13C\3D\3D\7D\u0211\nD\fD\16D\u0214\13"+
		"D\3E\3E\6\u01f3\u0200\u020b\u0212\2F\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083"+
		"C\u0085D\u0087E\u0089F\3\2\7\5\2C\\aac|\6\2\62;C\\aac|\3\2\f\f\5\2\13"+
		"\f\17\17\"\"\4\2\f\f\177\177\2\u021f\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3"+
		"\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2"+
		"\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2"+
		"\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2["+
		"\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2"+
		"\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2"+
		"\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2"+
		"\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089"+
		"\3\2\2\2\3\u008b\3\2\2\2\5\u0095\3\2\2\2\7\u009d\3\2\2\2\t\u00a2\3\2\2"+
		"\2\13\u00a6\3\2\2\2\r\u00b0\3\2\2\2\17\u00b7\3\2\2\2\21\u00bf\3\2\2\2"+
		"\23\u00c7\3\2\2\2\25\u00d0\3\2\2\2\27\u00dd\3\2\2\2\31\u00ea\3\2\2\2\33"+
		"\u00fb\3\2\2\2\35\u0102\3\2\2\2\37\u010a\3\2\2\2!\u0115\3\2\2\2#\u011b"+
		"\3\2\2\2%\u011f\3\2\2\2\'\u012a\3\2\2\2)\u012f\3\2\2\2+\u0134\3\2\2\2"+
		"-\u013c\3\2\2\2/\u0142\3\2\2\2\61\u0145\3\2\2\2\63\u0147\3\2\2\2\65\u014a"+
		"\3\2\2\2\67\u0151\3\2\2\29\u0157\3\2\2\2;\u015c\3\2\2\2=\u0165\3\2\2\2"+
		"?\u0172\3\2\2\2A\u0177\3\2\2\2C\u0180\3\2\2\2E\u0184\3\2\2\2G\u0189\3"+
		"\2\2\2I\u018e\3\2\2\2K\u0197\3\2\2\2M\u01a5\3\2\2\2O\u01a7\3\2\2\2Q\u01a9"+
		"\3\2\2\2S\u01ab\3\2\2\2U\u01ad\3\2\2\2W\u01af\3\2\2\2Y\u01b1\3\2\2\2["+
		"\u01b4\3\2\2\2]\u01b6\3\2\2\2_\u01b8\3\2\2\2a\u01ba\3\2\2\2c\u01bd\3\2"+
		"\2\2e\u01bf\3\2\2\2g\u01c1\3\2\2\2i\u01c3\3\2\2\2k\u01c5\3\2\2\2m\u01c7"+
		"\3\2\2\2o\u01c9\3\2\2\2q\u01cc\3\2\2\2s\u01ce\3\2\2\2u\u01d1\3\2\2\2w"+
		"\u01d3\3\2\2\2y\u01d7\3\2\2\2{\u01dc\3\2\2\2}\u01e8\3\2\2\2\177\u01ef"+
		"\3\2\2\2\u0081\u01f8\3\2\2\2\u0083\u01fc\3\2\2\2\u0085\u0207\3\2\2\2\u0087"+
		"\u020e\3\2\2\2\u0089\u0215\3\2\2\2\u008b\u008c\7c\2\2\u008c\u008d\7n\2"+
		"\2\u008d\u008e\7i\2\2\u008e\u008f\7q\2\2\u008f\u0090\7t\2\2\u0090\u0091"+
		"\7k\2\2\u0091\u0092\7v\2\2\u0092\u0093\7o\2\2\u0093\u0094\7q\2\2\u0094"+
		"\4\3\2\2\2\u0095\u0096\7f\2\2\u0096\u0097\7g\2\2\u0097\u0098\7e\2\2\u0098"+
		"\u0099\7n\2\2\u0099\u009a\7c\2\2\u009a\u009b\7t\2\2\u009b\u009c\7g\2\2"+
		"\u009c\6\3\2\2\2\u009d\u009e\7v\2\2\u009e\u009f\7k\2\2\u009f\u00a0\7r"+
		"\2\2\u00a0\u00a1\7q\2\2\u00a1\b\3\2\2\2\u00a2\u00a3\7x\2\2\u00a3\u00a4"+
		"\7c\2\2\u00a4\u00a5\7t\2\2\u00a5\n\3\2\2\2\u00a6\u00a7\7e\2\2\u00a7\u00a8"+
		"\7q\2\2\u00a8\u00a9\7p\2\2\u00a9\u00aa\7u\2\2\u00aa\u00ab\7v\2\2\u00ab"+
		"\u00ac\7c\2\2\u00ac\u00ad\7p\2\2\u00ad\u00ae\7v\2\2\u00ae\u00af\7g\2\2"+
		"\u00af\f\3\2\2\2\u00b0\u00b1\7n\2\2\u00b1\u00b2\7q\2\2\u00b2\u00b3\7i"+
		"\2\2\u00b3\u00b4\7k\2\2\u00b4\u00b5\7e\2\2\u00b5\u00b6\7q\2\2\u00b6\16"+
		"\3\2\2\2\u00b7\u00b8\7n\2\2\u00b8\u00b9\7k\2\2\u00b9\u00ba\7v\2\2\u00ba"+
		"\u00bb\7g\2\2\u00bb\u00bc\7t\2\2\u00bc\u00bd\7c\2\2\u00bd\u00be\7n\2\2"+
		"\u00be\20\3\2\2\2\u00bf\u00c0\7k\2\2\u00c0\u00c1\7p\2\2\u00c1\u00c2\7"+
		"v\2\2\u00c2\u00c3\7g\2\2\u00c3\u00c4\7k\2\2\u00c4\u00c5\7t\2\2\u00c5\u00c6"+
		"\7q\2\2\u00c6\22\3\2\2\2\u00c7\u00c8\7t\2\2\u00c8\u00c9\7g\2\2\u00c9\u00ca"+
		"\7i\2\2\u00ca\u00cb\7k\2\2\u00cb\u00cc\7u\2\2\u00cc\u00cd\7v\2\2\u00cd"+
		"\u00ce\7t\2\2\u00ce\u00cf\7q\2\2\u00cf\24\3\2\2\2\u00d0\u00d1\7h\2\2\u00d1"+
		"\u00d2\7k\2\2\u00d2\u00d3\7o\2\2\u00d3\u00d4\7a\2\2\u00d4\u00d5\7t\2\2"+
		"\u00d5\u00d6\7g\2\2\u00d6\u00d7\7i\2\2\u00d7\u00d8\7k\2\2\u00d8\u00d9"+
		"\7u\2\2\u00d9\u00da\7v\2\2\u00da\u00db\7t\2\2\u00db\u00dc\7q\2\2\u00dc"+
		"\26\3\2\2\2\u00dd\u00de\7r\2\2\u00de\u00df\7t\2\2\u00df\u00e0\7q\2\2\u00e0"+
		"\u00e1\7e\2\2\u00e1\u00e2\7g\2\2\u00e2\u00e3\7f\2\2\u00e3\u00e4\7k\2\2"+
		"\u00e4\u00e5\7o\2\2\u00e5\u00e6\7g\2\2\u00e6\u00e7\7p\2\2\u00e7\u00e8"+
		"\7v\2\2\u00e8\u00e9\7q\2\2\u00e9\30\3\2\2\2\u00ea\u00eb\7h\2\2\u00eb\u00ec"+
		"\7k\2\2\u00ec\u00ed\7o\2\2\u00ed\u00ee\7a\2\2\u00ee\u00ef\7r\2\2\u00ef"+
		"\u00f0\7t\2\2\u00f0\u00f1\7q\2\2\u00f1\u00f2\7e\2\2\u00f2\u00f3\7g\2\2"+
		"\u00f3\u00f4\7f\2\2\u00f4\u00f5\7k\2\2\u00f5\u00f6\7o\2\2\u00f6\u00f7"+
		"\7g\2\2\u00f7\u00f8\7p\2\2\u00f8\u00f9\7v\2\2\u00f9\u00fa\7q\2\2\u00fa"+
		"\32\3\2\2\2\u00fb\u00fc\7h\2\2\u00fc\u00fd\7w\2\2\u00fd\u00fe\7p\2\2\u00fe"+
		"\u00ff\7e\2\2\u00ff\u0100\7c\2\2\u0100\u0101\7q\2\2\u0101\34\3\2\2\2\u0102"+
		"\u0103\7t\2\2\u0103\u0104\7g\2\2\u0104\u0105\7v\2\2\u0105\u0106\7q\2\2"+
		"\u0106\u0107\7t\2\2\u0107\u0108\7p\2\2\u0108\u0109\7g\2\2\u0109\36\3\2"+
		"\2\2\u010a\u010b\7h\2\2\u010b\u010c\7k\2\2\u010c\u010d\7o\2\2\u010d\u010e"+
		"\7a\2\2\u010e\u010f\7h\2\2\u010f\u0110\7w\2\2\u0110\u0111\7p\2\2\u0111"+
		"\u0112\7e\2\2\u0112\u0113\7c\2\2\u0113\u0114\7q\2\2\u0114 \3\2\2\2\u0115"+
		"\u0116\7h\2\2\u0116\u0117\7c\2\2\u0117\u0118\7n\2\2\u0118\u0119\7u\2\2"+
		"\u0119\u011a\7q\2\2\u011a\"\3\2\2\2\u011b\u011c\7p\2\2\u011c\u011d\7c"+
		"\2\2\u011d\u011e\7q\2\2\u011e$\3\2\2\2\u011f\u0120\7x\2\2\u0120\u0121"+
		"\7g\2\2\u0121\u0122\7t\2\2\u0122\u0123\7f\2\2\u0123\u0124\7c\2\2\u0124"+
		"\u0125\7f\2\2\u0125\u0126\7g\2\2\u0126\u0127\7k\2\2\u0127\u0128\7t\2\2"+
		"\u0128\u0129\7q\2\2\u0129&\3\2\2\2\u012a\u012b\7t\2\2\u012b\u012c\7g\2"+
		"\2\u012c\u012d\7c\2\2\u012d\u012e\7n\2\2\u012e(\3\2\2\2\u012f\u0130\7"+
		"n\2\2\u0130\u0131\7g\2\2\u0131\u0132\7k\2\2\u0132\u0133\7c\2\2\u0133*"+
		"\3\2\2\2\u0134\u0135\7g\2\2\u0135\u0136\7u\2\2\u0136\u0137\7e\2\2\u0137"+
		"\u0138\7t\2\2\u0138\u0139\7g\2\2\u0139\u013a\7x\2\2\u013a\u013b\7c\2\2"+
		"\u013b,\3\2\2\2\u013c\u013d\7g\2\2\u013d\u013e\7p\2\2\u013e\u013f\7v\2"+
		"\2\u013f\u0140\7c\2\2\u0140\u0141\7q\2\2\u0141.\3\2\2\2\u0142\u0143\7"+
		"q\2\2\u0143\u0144\7w\2\2\u0144\60\3\2\2\2\u0145\u0146\7g\2\2\u0146\62"+
		"\3\2\2\2\u0147\u0148\7u\2\2\u0148\u0149\7g\2\2\u0149\64\3\2\2\2\u014a"+
		"\u014b\7h\2\2\u014b\u014c\7k\2\2\u014c\u014d\7o\2\2\u014d\u014e\7a\2\2"+
		"\u014e\u014f\7u\2\2\u014f\u0150\7g\2\2\u0150\66\3\2\2\2\u0151\u0152\7"+
		"u\2\2\u0152\u0153\7g\2\2\u0153\u0154\7p\2\2\u0154\u0155\7c\2\2\u0155\u0156"+
		"\7q\2\2\u01568\3\2\2\2\u0157\u0158\7h\2\2\u0158\u0159\7c\2\2\u0159\u015a"+
		"\7e\2\2\u015a\u015b\7c\2\2\u015b:\3\2\2\2\u015c\u015d\7g\2\2\u015d\u015e"+
		"\7p\2\2\u015e\u015f\7s\2\2\u015f\u0160\7w\2\2\u0160\u0161\7c\2\2\u0161"+
		"\u0162\7p\2\2\u0162\u0163\7v\2\2\u0163\u0164\7q\2\2\u0164<\3\2\2\2\u0165"+
		"\u0166\7h\2\2\u0166\u0167\7k\2\2\u0167\u0168\7o\2\2\u0168\u0169\7a\2\2"+
		"\u0169\u016a\7g\2\2\u016a\u016b\7p\2\2\u016b\u016c\7s\2\2\u016c\u016d"+
		"\7w\2\2\u016d\u016e\7c\2\2\u016e\u016f\7p\2\2\u016f\u0170\7v\2\2\u0170"+
		"\u0171\7q\2\2\u0171>\3\2\2\2\u0172\u0173\7r\2\2\u0173\u0174\7c\2\2\u0174"+
		"\u0175\7t\2\2\u0175\u0176\7c\2\2\u0176@\3\2\2\2\u0177\u0178\7h\2\2\u0178"+
		"\u0179\7k\2\2\u0179\u017a\7o\2\2\u017a\u017b\7a\2\2\u017b\u017c\7r\2\2"+
		"\u017c\u017d\7c\2\2\u017d\u017e\7t\2\2\u017e\u017f\7c\2\2\u017fB\3\2\2"+
		"\2\u0180\u0181\7c\2\2\u0181\u0182\7v\2\2\u0182\u0183\7g\2\2\u0183D\3\2"+
		"\2\2\u0184\u0185\7u\2\2\u0185\u0186\7g\2\2\u0186\u0187\7l\2\2\u0187\u0188"+
		"\7c\2\2\u0188F\3\2\2\2\u0189\u018a\7e\2\2\u018a\u018b\7c\2\2\u018b\u018c"+
		"\7u\2\2\u018c\u018d\7q\2\2\u018dH\3\2\2\2\u018e\u018f\7h\2\2\u018f\u0190"+
		"\7k\2\2\u0190\u0191\7o\2\2\u0191\u0192\7a\2\2\u0192\u0193\7e\2\2\u0193"+
		"\u0194\7c\2\2\u0194\u0195\7u\2\2\u0195\u0196\7q\2\2\u0196J\3\2\2\2\u0197"+
		"\u0198\7h\2\2\u0198\u0199\7k\2\2\u0199\u019a\7o\2\2\u019a\u019b\7a\2\2"+
		"\u019b\u019c\7c\2\2\u019c\u019d\7n\2\2\u019d\u019e\7i\2\2\u019e\u019f"+
		"\7q\2\2\u019f\u01a0\7t\2\2\u01a0\u01a1\7k\2\2\u01a1\u01a2\7v\2\2\u01a2"+
		"\u01a3\7o\2\2\u01a3\u01a4\7q\2\2\u01a4L\3\2\2\2\u01a5\u01a6\7<\2\2\u01a6"+
		"N\3\2\2\2\u01a7\u01a8\7*\2\2\u01a8P\3\2\2\2\u01a9\u01aa\7+\2\2\u01aaR"+
		"\3\2\2\2\u01ab\u01ac\7]\2\2\u01acT\3\2\2\2\u01ad\u01ae\7_\2\2\u01aeV\3"+
		"\2\2\2\u01af\u01b0\7.\2\2\u01b0X\3\2\2\2\u01b1\u01b2\7\60\2\2\u01b2\u01b3"+
		"\7\60\2\2\u01b3Z\3\2\2\2\u01b4\u01b5\7\60\2\2\u01b5\\\3\2\2\2\u01b6\u01b7"+
		"\7\61\2\2\u01b7^\3\2\2\2\u01b8\u01b9\7\'\2\2\u01b9`\3\2\2\2\u01ba\u01bb"+
		"\7>\2\2\u01bb\u01bc\7/\2\2\u01bcb\3\2\2\2\u01bd\u01be\7-\2\2\u01bed\3"+
		"\2\2\2\u01bf\u01c0\7/\2\2\u01c0f\3\2\2\2\u01c1\u01c2\7,\2\2\u01c2h\3\2"+
		"\2\2\u01c3\u01c4\7`\2\2\u01c4j\3\2\2\2\u01c5\u01c6\7(\2\2\u01c6l\3\2\2"+
		"\2\u01c7\u01c8\7?\2\2\u01c8n\3\2\2\2\u01c9\u01ca\7>\2\2\u01ca\u01cb\7"+
		"@\2\2\u01cbp\3\2\2\2\u01cc\u01cd\7>\2\2\u01cdr\3\2\2\2\u01ce\u01cf\7>"+
		"\2\2\u01cf\u01d0\7?\2\2\u01d0t\3\2\2\2\u01d1\u01d2\7@\2\2\u01d2v\3\2\2"+
		"\2\u01d3\u01d4\7@\2\2\u01d4\u01d5\7?\2\2\u01d5x\3\2\2\2\u01d6\u01d8\4"+
		"\62;\2\u01d7\u01d6\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9\u01d7\3\2\2\2\u01d9"+
		"\u01da\3\2\2\2\u01daz\3\2\2\2\u01db\u01dd\4\62;\2\u01dc\u01db\3\2\2\2"+
		"\u01dd\u01de\3\2\2\2\u01de\u01dc\3\2\2\2\u01de\u01df\3\2\2\2\u01df\u01e6"+
		"\3\2\2\2\u01e0\u01e2\7\60\2\2\u01e1\u01e3\4\62;\2\u01e2\u01e1\3\2\2\2"+
		"\u01e3\u01e4\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01e7"+
		"\3\2\2\2\u01e6\u01e0\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7|\3\2\2\2\u01e8"+
		"\u01ec\t\2\2\2\u01e9\u01eb\t\3\2\2\u01ea\u01e9\3\2\2\2\u01eb\u01ee\3\2"+
		"\2\2\u01ec\u01ea\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed~\3\2\2\2\u01ee\u01ec"+
		"\3\2\2\2\u01ef\u01f3\7$\2\2\u01f0\u01f2\n\4\2\2\u01f1\u01f0\3\2\2\2\u01f2"+
		"\u01f5\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f3\u01f1\3\2\2\2\u01f4\u01f6\3\2"+
		"\2\2\u01f5\u01f3\3\2\2\2\u01f6\u01f7\7$\2\2\u01f7\u0080\3\2\2\2\u01f8"+
		"\u01f9\t\5\2\2\u01f9\u01fa\3\2\2\2\u01fa\u01fb\bA\2\2\u01fb\u0082\3\2"+
		"\2\2\u01fc\u0200\7}\2\2\u01fd\u01ff\n\6\2\2\u01fe\u01fd\3\2\2\2\u01ff"+
		"\u0202\3\2\2\2\u0200\u0201\3\2\2\2\u0200\u01fe\3\2\2\2\u0201\u0203\3\2"+
		"\2\2\u0202\u0200\3\2\2\2\u0203\u0204\7\177\2\2\u0204\u0205\3\2\2\2\u0205"+
		"\u0206\bB\2\2\u0206\u0084\3\2\2\2\u0207\u020b\7$\2\2\u0208\u020a\13\2"+
		"\2\2\u0209\u0208\3\2\2\2\u020a\u020d\3\2\2\2\u020b\u020c\3\2\2\2\u020b"+
		"\u0209\3\2\2\2\u020c\u0086\3\2\2\2\u020d\u020b\3\2\2\2\u020e\u0212\7}"+
		"\2\2\u020f\u0211\13\2\2\2\u0210\u020f\3\2\2\2\u0211\u0214\3\2\2\2\u0212"+
		"\u0213\3\2\2\2\u0212\u0210\3\2\2\2\u0213\u0088\3\2\2\2\u0214\u0212\3\2"+
		"\2\2\u0215\u0216\13\2\2\2\u0216\u008a\3\2\2\2\f\2\u01d9\u01de\u01e4\u01e6"+
		"\u01ec\u01f3\u0200\u020b\u0212\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}