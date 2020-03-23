package numlang;

public class IfElse extends Expr {
    Cond cond;
    Expr ifExpr;
    Expr elseExpr;

    public IfElse(Cond cond, Expr ifExpr, Expr elseExpr) {
        this.cond = cond;
        this.ifExpr = ifExpr;
        this.elseExpr = elseExpr;
    }

    public Double evaluate(Context ctx) throws Exception {
        // To be completed
        return 0.0;
    }

    public String toString() {
        return String.format("if %s then %s else %s", this.cond, this.ifExpr, this.elseExpr);
    }
}
