// Generated from IsiLang.g4 by ANTLR 4.4

	import br.com.professorisidro.isilanguage.datastructures.IsiSymbol;
	import br.com.professorisidro.isilanguage.datastructures.IsiVariable;
	import br.com.professorisidro.isilanguage.datastructures.IsiSymbolTable;
	import br.com.professorisidro.isilanguage.exceptions.IsiSemanticException;
	import br.com.professorisidro.isilanguage.ast.IsiProgram;
	import br.com.professorisidro.isilanguage.ast.AbstractCommand;
	import br.com.professorisidro.isilanguage.ast.CommandLeitura;
	import br.com.professorisidro.isilanguage.ast.CommandEscrita;
	import br.com.professorisidro.isilanguage.ast.CommandAtribuicao;
	import br.com.professorisidro.isilanguage.ast.CommandDecisao;
	import java.util.ArrayList;
	import java.util.Stack;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsiLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__10=1, T__9=2, T__8=3, T__7=4, T__6=5, T__5=6, T__4=7, T__3=8, T__2=9, 
		T__1=10, T__0=11, AP=12, FP=13, SC=14, OP=15, ATTR=16, VIR=17, ACH=18, 
		FCH=19, OPREL=20, ID=21, NUMBER=22, WS=23;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'"
	};
	public static final String[] ruleNames = {
		"T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", 
		"T__1", "T__0", "AP", "FP", "SC", "OP", "ATTR", "VIR", "ACH", "FCH", "OPREL", 
		"ID", "NUMBER", "WS"
	};


		private int _tipo;
		private String _varName;
		private String _varValue;
		private IsiSymbolTable symbolTable = new IsiSymbolTable();
		private IsiSymbol symbol;
		private IsiProgram program = new IsiProgram();
		private ArrayList<AbstractCommand> curThread;
		private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
		private String _readID;
		private String _writeID;
		private String _exprID;
		private String _exprContent;
		private String _exprDecision;
		private ArrayList<AbstractCommand> listaTrue;
		private ArrayList<AbstractCommand> listaFalse;
		
		public void verificaID(String id){
			if (!symbolTable.exists(id)){
				throw new IsiSemanticException("Symbol "+id+" not declared");
			}
		}
		
		public void exibeComandos(){
			for (AbstractCommand c: program.getComandos()){
				System.out.println(c);
			}
		}
		
		public void generateCode(){
			program.generateTarget();
		}


	public IsiLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\31\u00bd\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r"+
		"\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25"+
		"\u00a4\n\25\3\26\3\26\7\26\u00a8\n\26\f\26\16\26\u00ab\13\26\3\27\6\27"+
		"\u00ae\n\27\r\27\16\27\u00af\3\27\3\27\6\27\u00b4\n\27\r\27\16\27\u00b5"+
		"\5\27\u00b8\n\27\3\30\3\30\3\30\3\30\2\2\31\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\3\2\b\5\2,-//\61\61\4\2>>@@\3\2c|\5\2\62;C\\c|\3\2\62;\5\2"+
		"\13\f\17\17\"\"\u00c6\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\3\61\3\2\2\2\5\64\3\2\2\2\7<\3\2\2\2\tF\3\2\2"+
		"\2\13O\3\2\2\2\r]\3\2\2\2\17c\3\2\2\2\21j\3\2\2\2\23s\3\2\2\2\25{\3\2"+
		"\2\2\27\u0080\3\2\2\2\31\u0086\3\2\2\2\33\u0088\3\2\2\2\35\u008a\3\2\2"+
		"\2\37\u008c\3\2\2\2!\u008e\3\2\2\2#\u0090\3\2\2\2%\u0092\3\2\2\2\'\u0094"+
		"\3\2\2\2)\u00a3\3\2\2\2+\u00a5\3\2\2\2-\u00ad\3\2\2\2/\u00b9\3\2\2\2\61"+
		"\62\7u\2\2\62\63\7g\2\2\63\4\3\2\2\2\64\65\7c\2\2\65\66\7r\2\2\66\67\7"+
		"k\2\2\678\7t\2\289\7g\2\29:\7u\2\2:;\7v\2\2;\6\3\2\2\2<=\7j\2\2=>\7k\2"+
		"\2>?\7i\2\2?@\7j\2\2@A\7n\2\2AB\7k\2\2BC\7i\2\2CD\7j\2\2DE\7v\2\2E\b\3"+
		"\2\2\2FG\7h\2\2GH\7k\2\2HI\7o\2\2IJ\7r\2\2JK\7t\2\2KL\7q\2\2LM\7i\2\2"+
		"MN\7=\2\2N\n\3\2\2\2OP\7k\2\2PQ\7p\2\2QR\7v\2\2RS\7g\2\2ST\7t\2\2TU\7"+
		"r\2\2UV\7t\2\2VW\7g\2\2WX\7v\2\2XY\7c\2\2YZ\7f\2\2Z[\7q\2\2[\\\7t\2\2"+
		"\\\f\3\2\2\2]^\7u\2\2^_\7g\2\2_`\7p\2\2`a\7c\2\2ab\7q\2\2b\16\3\2\2\2"+
		"cd\7p\2\2de\7w\2\2ef\7o\2\2fg\7g\2\2gh\7t\2\2hi\7q\2\2i\20\3\2\2\2jk\7"+
		"r\2\2kl\7t\2\2lm\7q\2\2mn\7i\2\2no\7t\2\2op\7c\2\2pq\7o\2\2qr\7c\2\2r"+
		"\22\3\2\2\2st\7g\2\2tu\7u\2\2uv\7e\2\2vw\7t\2\2wx\7g\2\2xy\7x\2\2yz\7"+
		"c\2\2z\24\3\2\2\2{|\7n\2\2|}\7g\2\2}~\7k\2\2~\177\7c\2\2\177\26\3\2\2"+
		"\2\u0080\u0081\7v\2\2\u0081\u0082\7g\2\2\u0082\u0083\7z\2\2\u0083\u0084"+
		"\7v\2\2\u0084\u0085\7q\2\2\u0085\30\3\2\2\2\u0086\u0087\7*\2\2\u0087\32"+
		"\3\2\2\2\u0088\u0089\7+\2\2\u0089\34\3\2\2\2\u008a\u008b\7=\2\2\u008b"+
		"\36\3\2\2\2\u008c\u008d\t\2\2\2\u008d \3\2\2\2\u008e\u008f\7?\2\2\u008f"+
		"\"\3\2\2\2\u0090\u0091\7.\2\2\u0091$\3\2\2\2\u0092\u0093\7}\2\2\u0093"+
		"&\3\2\2\2\u0094\u0095\7\177\2\2\u0095(\3\2\2\2\u0096\u00a4\t\3\2\2\u0097"+
		"\u0098\7@\2\2\u0098\u00a4\7?\2\2\u0099\u009a\7>\2\2\u009a\u00a4\7?\2\2"+
		"\u009b\u009c\7?\2\2\u009c\u00a4\7?\2\2\u009d\u009e\7#\2\2\u009e\u00a4"+
		"\7?\2\2\u009f\u00a0\7(\2\2\u00a0\u00a4\7(\2\2\u00a1\u00a2\7~\2\2\u00a2"+
		"\u00a4\7~\2\2\u00a3\u0096\3\2\2\2\u00a3\u0097\3\2\2\2\u00a3\u0099\3\2"+
		"\2\2\u00a3\u009b\3\2\2\2\u00a3\u009d\3\2\2\2\u00a3\u009f\3\2\2\2\u00a3"+
		"\u00a1\3\2\2\2\u00a4*\3\2\2\2\u00a5\u00a9\t\4\2\2\u00a6\u00a8\t\5\2\2"+
		"\u00a7\u00a6\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa"+
		"\3\2\2\2\u00aa,\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ae\t\6\2\2\u00ad"+
		"\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2"+
		"\2\2\u00b0\u00b7\3\2\2\2\u00b1\u00b3\7\60\2\2\u00b2\u00b4\t\6\2\2\u00b3"+
		"\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2"+
		"\2\2\u00b6\u00b8\3\2\2\2\u00b7\u00b1\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8"+
		".\3\2\2\2\u00b9\u00ba\t\7\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\b\30\2\2"+
		"\u00bc\60\3\2\2\2\t\2\u00a3\u00a7\u00a9\u00af\u00b5\u00b7\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}