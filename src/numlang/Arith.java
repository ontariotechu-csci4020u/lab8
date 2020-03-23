package numlang;

public class Arith extends Expr {
    Expr e1;
    Expr e2;
    String op;

    public Arith(String op, Expr e) {
        this.op = op;
        this.e1 = e;
    }

    public Arith(String op, Expr e1, Expr e2) {
        this.op = op;
        this.e1 = e1;
        this.e2 = e2;
    }

    public Double evaluate(Context ctx) throws Exception {
        // To be completed
        return 0.0;
    }

    public String toString() {
        if(e2 == null)
            return String.format("(%s %s)", this.op, this.e1);
        else
            return String.format("(%s %s %s)", this.op, this.e1, this.e2);
    }
}
