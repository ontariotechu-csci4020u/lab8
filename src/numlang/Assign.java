package numlang;

public class Assign extends Expr {
    String name;
    Expr e;

    public Assign(String name, Expr e) {
        this.name = name;
        this.e = e;
    }

    public Double evaluate(Context ctx) throws Exception {
        // To be completed
        return 0.0;
    }

    public String toString() {
        return String.format("%s = %s", this.name, this.e);
    }
}
