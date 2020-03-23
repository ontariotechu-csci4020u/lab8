package numlang;

public class WhileLoop extends Expr {
    Cond cond;
    Block body;

    public WhileLoop(Cond cond, Block body) {
        this.cond = cond;
        this.body = body;
    }

    public Double evaluate(Context ctx) throws Exception {
        // To be completed
        return 0.0;
    }

    public String toString() {
        String s = String.format("while %s ", this.cond) + this.body.toString();
        return s;
    }
}
