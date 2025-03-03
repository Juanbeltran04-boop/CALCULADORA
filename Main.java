import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una expresión (o escriba 'salir' para terminar):");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("salir")) {
                break;
            }

            // Crear el lexer y parser de ANTLR
            CalculatorLexer lexer = new CalculatorLexer(CharStreams.fromString(input));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            CalculatorParser parser = new CalculatorParser(tokens);

            // Obtener el árbol de análisis sintáctico
            ParseTree tree = parser.expr();

            // Evaluar la expresión con el visitor
            EvalVisitor eval = new EvalVisitor();
            int result = eval.visit(tree);

            // Mostrar el resultado
            System.out.println("Resultado: " + result);
        }

        scanner.close();
    }
}
