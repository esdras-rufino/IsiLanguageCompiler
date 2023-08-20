import br.com.professorisidro.isilanguage.parser.IsiLangParser;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

public class IsiLangVisitor extends AbstractParseTreeVisitor<String> implements IsiLangParserVisitor<String> {

    // Variável para armazenar o código Java gerado
    private StringBuilder code = new StringBuilder();

    // Método para obter o código Java gerado
    public StringBuilder getCode() {
        return code;
    }

    // Método para visitar a regra inicial da gramática
    @Override
    public String visitProg(ProgContext ctx) {
        // Adicionar o pacote e a classe Java
        code.append("package br.com.professorisidro.isilanguage;\n\n");
        code.append("public class Input {\n\n");

        // Visitar os comandos do programa
        for (IsiLangParser.CmdContext cmd : ctx.cmd()) {
            visit(cmd);
        }

        // Adicionar o método main Java
        code.append("\n\tpublic static void main(String[] args) {\n");
        code.append("\t\tInput input = new Input();\n");
        code.append("\t\tinput.run();\n");
        code.append("\t}\n\n");

        // Adicionar o método run Java
        code.append("\tpublic void run() {\n");
        code.append("\t\t// Código gerado pelo compilador\n");
        code.append(code.toString());
        code.append("\t}\n\n");

        // Fechar a classe Java
        code.append("}\n");

        // Retornar o código Java gerado
        return code.toString();
    }

    // Método para visitar a regra de declaração de variáveis
    @Override
    public String visitDeclaraVariavel(IsiLangParser.DeclaraVariavelContext ctx) {
        // Obter o tipo da variável
        String tipo = ctx.tipo().getText();

        // Converter o tipo da variável para Java
        switch (tipo) {
            case "numero":
                tipo = "double";
                break;
            case "texto":
                tipo = "String";
                break;
            default:
                tipo = "Object";
                break;
        }

        // Obter os nomes das variáveis
        String nomes = ctx.ID().stream().map(id -> id.getText()).reduce((a, b) -> a + ", " + b).get();

        // Adicionar a declaração das variáveis em Java
        code.append("\t\t" + tipo + " " + nomes + ";\n");

        // Retornar a declaração das variáveis em Java
        return code.toString();
    }

    // Método para visitar a regra de comando de leitura
    @Override
    public String visitCmdLeitura(IsiLangParser.CmdLeituraContext ctx) {
        // Obter o nome da variável
        String nome = ctx.ID().getText();

        // Adicionar o comando de leitura em Java
        code.append("\t\t" + nome + " = System.in.read();\n");

        // Retornar o comando de leitura em Java
        return code.toString();
    }

    // Método para visitar a regra de comando de escrita
    @Override
    public String visitCmdEscrita(IsiLangParser.CmdEscritaContext ctx) {
        // Obter a expressão a ser escrita
        String expr = visit(ctx.expr());

        // Adicionar o comando de escrita em Java
        code.append("\t\tSystem.out.println(" + expr + ");\n");

        // Retornar o comando de escrita em Java
        return code.toString();
    }

    // Método para visitar a regra de expressão
    @Override
    public String visitExpr(IsiLangParser.ExprContext ctx) {
        // Obter o termo da expressão
        String termo = visit(ctx.termo());

        // Verificar se há mais termos na expressão
        if (ctx.outrosTermos() != null) {
            // Obter os outros termos da expressão
            String outrosTermos = visit(ctx.outrosTermos());

            // Retornar a expressão completa em Java
            return termo + outrosTermos;
        } else {
            // Retornar apenas o termo em Java
            return termo;
        }
    }

    // Método para visitar a regra de termo
    @Override
    public String visitTermo(IsiLangParser.TermoContext ctx) {
        // Obter o fator do termo
        String fator = visit(ctx.fator());

        // Verificar se há mais fatores no termo
        if (ctx.outrosFatores() != null) {
            // Obter os outros fatores do termo
            String outrosFatores = visit(ctx.outrosFatores());

            // Retornar o termo completo em Java
            return fator + outrosFatores;
        } else {
            // Retornar apenas o fator em Java
            return fator;
        }
    }

    // Método para visitar a regra de fator
    @Override
    public String visitFator(IsiLangParser.FatorContext ctx) {
        // Verificar se o fator é um número, uma string ou um identificador
        if (ctx.NUMBER() != null) {
            // Retornar o número em Java
            return ctx.NUMBER().getText();
        } else if (ctx.STRING() != null) {
            // Retornar a string em Java
            return ctx.STRING().getText();
        } else if (ctx.ID() != null) {
            // Retornar o identificador em Java
            return ctx.ID().getText();
        } else {
            // Retornar uma expressão entre parênteses em Java
            return "(" + visit(ctx.expr()) + ")";
        }
    }

    // Método para visitar a regra de outros termos
    @Override
    public String visitOutrosTermos(IsiLangParser.OutrosTermosContext ctx) {
        // Obter o operador do termo
        String op = ctx.op1().getText();

        // Obter o termo seguinte
        String termo = visit(ctx.termo());

        // Verificar se há mais termos na expressão
        if (ctx.outrosTermos() != null) {
            // Obter os outros termos da expressão
            String outrosTermos = visit(ctx.outrosTermos());

            // Retornar os termos completos em Java
            return op + termo + outrosTermos;
        } else {
            // Retornar apenas o operador e o termo em Java
            return op + termo;
        }
    }

    // Método para visitar a regra de outros fatores
    @Override
    public String visitOutrosFatores(IsiLangParser.OutrosFatoresContext ctx) {
        // Obter o operador do fator
        String op = ctx.op2().getText();

        // Obter o fator seguinte
        String fator = visit(ctx.fator());

        // Verificar se há mais fatores no termo
        if (ctx.outrosFatores() != null) {
            // Obter os outros fatores do termo
        	String outrosFatores = visit(ctx.outrosFatores());

            // Retornar os fatores completos em Java
            return op + fator + outrosFatores;
        } else {
            // Retornar apenas o operador e o fator em Java
            return op + fator;
        }
    }

    // Método para visitar a regra de comando de atribuição
    @Override
    public String visitCmdAtribuicao(IsiLangParser.CmdAtribuicaoContext ctx) {
        // Obter o nome da variável
        String nome = ctx.ID().getText();

        // Obter a expressão a ser atribuída
        String expr = visit(ctx.expr());

        // Adicionar o comando de atribuição em Java
        code.append("\t\t" + nome + " = " + expr + ";\n");

        // Retornar o comando de atribuição em Java
        return code.toString();
    }

    // Método para visitar a regra de comando de decisão
    @Override
    public String visitCmdDecisao(IsiLangParser.CmdDecisaoContext ctx) {
        // Obter a condição do comando de decisão
        String cond = visit(ctx.expr());

        // Adicionar o comando if em Java
        code.append("\t\tif (" + cond + ") {\n");

        // Visitar os comandos do bloco verdadeiro
        for (IsiLangParser.CmdContext cmd : ctx.cmd()) {
            visit(cmd);
        }

        // Fechar o comando if em Java
        code.append("\t\t}\n");

        // Verificar se há um bloco falso
        if (ctx.cmdSenao() != null) {
            // Adicionar o comando else em Java
            code.append("\t\telse {\n");

            // Visitar os comandos do bloco falso
            visit(ctx.cmdSenao());

            // Fechar o comando else em Java
            code.append("\t\t}\n");
        }

        // Retornar o comando de decisão em Java
        return code.toString();
    }

    // Método para visitar a regra de comando senão
    @Override
    public String visitCmdSenao(IsiLangParser.CmdSenaoContext ctx) {
        // Visitar os comandos do bloco falso
        for (IsiLangParser.CmdContext cmd : ctx.cmd()) {
            visit(cmd);
        }

        // Retornar os comandos do bloco falso em Java
        return code.toString();
    }

    // Método para visitar a regra de comando highlight
    @Override
    public String visitCmdHighlight(IsiLangParser.CmdHighlightContext ctx) {
        // Obter o nome da variável a ser destacada
        String nome = ctx.ID().getText();

        // Adicionar o comando highlight em Java, usando uma biblioteca externa chamada Highlighter
        code.append("\t\tHighlighter.highlight(" + nome + ");\n");

        // Retornar o comando highlight em Java
        return code.toString();
    }

    // Método para visitar a regra de comando apirest
    @Override
    public String visitCmdApirest(IsiLangParser.CmdApirestContext ctx) {
        // Obter o nome do método a ser chamado na API REST
        String metodo = ctx.ID().getText();

        // Adicionar o comando apirest em Java, usando uma biblioteca externa chamada RestTemplate
        code.append("\t\tRestTemplate restTemplate = new RestTemplate();\n");
        code.append("\t\tString result = restTemplate.getForObject(\"http://localhost:8080/" + metodo + "\", String.class);\n");
     // Imprimir o resultado da chamada da API REST
        code.append("\t\tSystem.out.println(result);\n");

        // Retornar o comando apirest em Java
        return code.toString();
    }

    // Método para visitar a regra de comando interpretador
    @Override
    public String visitCmdInterpretador(IsiLangParser.CmdInterpretadorContext ctx) {
        // Obter o nome do método a ser chamado no interpretador
        String metodo = ctx.ID().getText();

        // Adicionar o comando interpretador em Java, usando uma biblioteca externa chamada ScriptEngine
        code.append("\t\tScriptEngine engine = new ScriptEngineManager().getEngineByName(\"JavaScript\");\n");
        code.append("\t\tObject result = engine.eval(" + metodo + ");\n");

        // Imprimir o resultado da chamada do interpretador
        code.append("\t\tSystem.out.println(result);\n");

        // Retornar o comando interpretador em Java
        return code.toString();
    }

    // Método para visitar a regra de comando generateTarget
    @Override
    public String visitCmdGenerateTarget(IsiLangParser.CmdGenerateTargetContext ctx) {
        // Obter o nome da variável que vai receber o código gerado
        String var = ctx.ID().getText();

        // Obter o nome da linguagem alvo
        String lang = ctx.STRING().getText();

        // Remover as aspas da linguagem alvo
        lang = lang.substring(1, lang.length() - 1);

        // Adicionar o comando generateTarget em Java, usando uma biblioteca externa chamada CodeGenerator
        code.append("\t\tCodeGenerator generator = new CodeGenerator();\n");
        code.append("\t\tString " + var + " = generator.generateTarget(" + lang + ");\n");

        // Retornar o comando generateTarget em Java
        return code.toString();
    }
    }