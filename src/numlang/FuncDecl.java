package numlang;

public class FuncDecl extends Expr {
    String name;
    String[] paramNames;
    Expr body;

    public FuncDecl(String name, String[] paramNames, Expr body) {
        this.name = name;
        this.paramNames = paramNames;
        this.body = body;
    }

    public Double evaluate(Context context) throws Exception {
        // To be completed
        return 0.0;
    }

    public String toString() {
        String paramNames = String.join(",", this.paramNames);
        return String.format("%s(%s)%s", this.name, paramNames, this.body);
    }
}
