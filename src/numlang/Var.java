package numlang;

public class Var extends Expr {
    String name;
    public Var(String name) {
        this.name = name;
    }
    public Double evaluate(Context ctx) throws Exception {
        // To be completed
        return 0.0;
    }
    public String toString() {
        return this.name;
    }
}
