import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

public class EvalVisitor extends CalculatorBaseVisitor<Integer> {
    @Override
    public Integer visitExpr(CalculatorParser.ExprContext ctx) {
        if (ctx.INT() != null) {
            return Integer.parseInt(ctx.INT().getText());
        }
        if (ctx.children.size() == 3) {
            int left = visit(ctx.getChild(0));
            int right = visit(ctx.getChild(2));
            String operator = ctx.getChild(1).getText();

            switch (operator) {
                case "+":
                    return left + right;
                case "-":
                    return left - right;
                case "*":
                    return left * right;
                case "/":
                    return right != 0 ? left / right : 0;  // Evita división por cero
            }
        }
        return visit(ctx.getChild(1)); // Caso de paréntesis
    }
}
