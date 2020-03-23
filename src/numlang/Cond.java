package numlang;

public class Cond extends Expr {
    Expr e1;
    Expr e2;
    String op;

    public Cond(String op, Expr e1) {
        this(op, e1, null);
    }
    public Cond(String op, Expr e1, Expr e2) {
        this.e1 = e1;
        this.e2 = e2;
        this.op = op;
    }

    public Double evaluate(Context ctx) throws Exception {
        // To be completed
        return 0.0;
    }

    public String toString() {
        if(this.e2 == null)
            return String.format("(%s %s)", this.op, this.e1);
        else
            return String.format("(%s %s %s)", this.op, this.e1, this.e2);
    }
}

