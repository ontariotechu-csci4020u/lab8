package numlang;

public class DoubleOrFuncDecl {
    public double number;
    public FuncDecl func;

    public DoubleOrFuncDecl(double number) {
        this.number = number;
    }

    public DoubleOrFuncDecl(FuncDecl func) {
        this.func = func;
    }
}
