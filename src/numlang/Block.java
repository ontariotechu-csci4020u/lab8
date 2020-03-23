package numlang;

public class Block extends Expr {
    Expr[] exprList;

    public Block(Expr[] exprList) {
        this.exprList = exprList;
    }

    public Double evaluate(Context ctx) throws Exception {
        // To be completed
        return 0.0;
    }

    public String toString() {
        String s = "{\n";
        for(Expr e : this.exprList) {
            s += e.toString() + "\n";
        }
        s += "}";
        return s;
    }
}
