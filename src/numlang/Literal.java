package numlang;

public class Literal extends Expr {
    double v;
    public Literal(double v) {
        this.v = v;
    }
    @Override
    public Double evaluate(Context ctx) {
        // To be completed
        return 0.0;
    }
    @Override
    public String toString() {
        return String.format("%.2f", this.v);
    }
}
