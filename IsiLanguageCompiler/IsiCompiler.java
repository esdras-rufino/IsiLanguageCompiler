import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import br.com.professorisidro.isilanguage.parser.IsiLangParser;
import br.com.professorisidro.isilanguage.parser.IsiLangLexer;

public class IsiCompiler {

    public static void main(String[] args) throws IOException {
        // Criar uma variável String com o nome do arquivo de entrada
        String inputFileName = "input.ini";

        // Usar a variável para criar um objeto do tipo ANTLRInputStream
        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(new File(inputFileName)));

        // Criar um objeto do tipo IsiLangLexer a partir do input
        IsiLangLexer lexer = new IsiLangLexer(input);

        // Criar um objeto do tipo CommonTokenStream a partir do lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Criar um objeto do tipo IsiLangParser a partir dos tokens
        IsiLangParser parser = new IsiLangParser(tokens);

        // Invocar a regra inicial da gramática e obter a raiz da árvore sintática
        IsiLangParser.ProgContext tree = parser.prog();

        // Criar um objeto do tipo IsiLangVisitor
        IsiLangVisitor visitor = new IsiLangVisitor();

        // Visitar a raiz da árvore sintática e gerar o código Java
        visitor.visit(tree);

        // Obter o código Java armazenado no StringBuilder do visitor
        String javaCode = visitor.getCode().toString();

        // Criar o nome do arquivo de saída
        //String outputFileName = inputFileName.replace(".isi", ".java");
        String outputFileName = "input.java";

        // Escrever o código Java em um arquivo de saída
        FileWriter writer = new FileWriter(outputFileName);
        writer.write(javaCode);
        writer.close();

        // Imprimir uma mensagem de sucesso
        System.out.println("Compilação concluída com sucesso!");
    }
}
